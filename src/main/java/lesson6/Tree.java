package lesson6;


public interface Tree<E extends Comparable<? super E>> {

  boolean add(E value);

  boolean contains(E value);

  boolean remove(E value);

  boolean isEmpty();

  int size();

  void display();

  void traverse(TraverseMode mode);

  int height();

  boolean isBalanced();

  enum TraverseMode {
    IN_ORDER,
    PRE_ORDER,
    POST_ORDER,
  }
}