package lesson2.homework;

import java.util.Arrays;

public class ImplArray<E extends Object & Comparable<? super E>> implements ActionsOnArray<E> {

  protected E[] data;
  protected int size;

  public ImplArray() {
    this(null, INITIAL_CAPACITY);
  }

  @SuppressWarnings("unchecked")
  private ImplArray(E[] data, int capacity) {
    this.size = data != null ? data.length : 0;
    this.data = data != null ? data : (E[]) new Object[capacity];
  }


  @Override
  public boolean delete(E element) {
    int index = indexOf(element);
    try {
      return remove(index) != null;
    } catch (IndexOutOfBoundsException e) {
      return false;
    }
  }

  public E remove(int index) {
    checkIndex(index);
    E removedValue = data[index];
    for (int i = index; i < size - 1; i++) {
      data[i] = data[i + 1];
    }
    data[size - 1] = null;
    size--;
    return removedValue;
  }

  @Override
  public void add(E value) {
    checkAndGrow();
    data[size++] = value;
  }

  @Override
  public boolean contains(E element) {
    for (int i = 0; i < data.length; i++) {
      if (element.equals(data[i])) {
        return true;
      }
    }
    return false;
  }

  @Override
  public E get(int index) {
    checkIndex(index);
    return data[index];
  }

  @Override
  public int size() {
    return this.size;
  }

  protected void checkAndGrow() {
    if (data.length == size) {
      data = Arrays.copyOf(data, data.length * 2);
    }
  }

  public int indexOf(E value) {
    for (int i = 0; i < size; i++) {
      if (data[i].equals(value)) {
        return i;
      }
    }
    return -1;
  }

  protected void checkIndex(int index) {
    if (index < 0 || index >= data.length) {
      String errMsg = String.format("Invalid index %d for array with size %d",
          index, size);
      throw new IndexOutOfBoundsException(errMsg);
    }
  }
}
