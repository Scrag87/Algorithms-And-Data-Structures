package lesson4.homework;

public interface LinkedNodeList<T> {

  int size();

  boolean addFirst(T node);

  boolean addLast(T node);

  T getFirst();

  T getLast();

  boolean contains(T node);
}
