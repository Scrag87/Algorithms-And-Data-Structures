package lesson4.homework;

public class Node<T> {

  public Node<T> nextNode = null;
  public Node<T> previousNode = null;
  public int index;

  public T data;

  public Node(T data) {
    this.data = data;
  }
}