package lesson3.homework;

import java.util.Arrays;
import lesson3.queue.QueueImpl;

public class Deque<E> extends QueueImpl<E> {

  //   tail _ _ _ _ _ _ head ->

  public Deque(int maxSize) {
    super(maxSize);
    this.head = DEFAULT_HEAD;
    this.tail = DEFAULT_TAIL;
  }

  public E removeTail() {
    if (isEmpty()) {
      return null;
    }
    if (tail == DEFAULT_TAIL) {
      tail = lastIndex();
    }
    E removedValue = data[tail];
    tail--;
    size--;
    return removedValue;
  }

  public boolean insertHead(E value) {
    if (isFull()) {
      return false;
    }
    if (head == 0) {
      head = data.length;
    }
    head--;
    data[head] = value;
    size++;
    return true;
  }

  @Override
  public String toString() {
    return "Deque{" +
        "data=" + Arrays.toString(data) +
        ", size=" + size +
        ", tail=" + tail +
        ", head=" + head +
        '}';
  }
}
