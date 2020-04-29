package lesson2.homework;

public interface ActionsOnArray<E> {

  int INITIAL_CAPACITY = 4;

  boolean delete(E element);

  void add(E value);

  boolean contains(E element);
  E get(int index);
  int size();

  default void display() {
    System.out.print("[");
    for (int i = 0; i < size(); i++) {
      E value = get(i);
      System.out.print(value + ", ");
    }
    System.out.println("]");
  }
}
