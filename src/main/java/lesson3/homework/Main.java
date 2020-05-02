package lesson3.homework;

import java.util.PriorityQueue;
import lesson3.stack.Stack;
import lesson3.stack.StackImpl;

public class Main {

  public static void main(String[] args) {
    task1();
    //task2("Methods of Java Deque Interface");
    //task3();

  }

  private static void task3() {
    lesson3.homework.Deque<Integer> deque = new Deque<>(5);
    System.out.println(deque.insertHead(1));
    System.out.println(deque.insertTail(2));
    System.out.println(deque);
    System.out.println(deque.insertHead(3));
    System.out.println(deque.insertTail(4));
    System.out.println(deque);
    System.out.println(deque.insertHead(5));
    System.out.println(deque.insertTail(8));
    System.out.println(deque);
    System.out.println("rem");
    System.out.println(deque.removeTail());
    System.out.println(deque.removeHead());
    System.out.println(deque);
    System.out.println(deque.insertTail(6));

    int x = 0;
    while (!deque.isFull()) {
      ++x;
      System.out.println(deque.insertTail(x));
      System.out.println(deque);
      System.out.println("insertTail");

    }
    System.out.println("removeTail");
    while (!deque.isEmpty()) {
      System.out.println(deque.removeTail());
      System.out.println(deque);
    }
    System.out.println(deque);

    System.out.println(deque.removeTail());
    System.out.println("removeHead");
    while (!deque.isEmpty()) {
      System.out.println(deque.removeHead());
      System.out.println(deque);
    }
    System.out.println("insertHead");
    x = 0;
    while (!deque.isFull()) {
      ++x;
      System.out.println(deque.insertHead(x));
      System.out.println(deque);
    }
    System.out.println(deque.removeTail());
  }

  //O(n^2)
  private static void task2(String message) {
    Stack<Character> stack = new StackImpl<>(message.length());
    for (int i = 0; i < message.length(); i++) {
      stack.push(message.charAt(i));
    }
    for (int i = 0; i < message.length(); i++) {
      System.out.print(stack.pop());
    }
    System.out.println();
  }

  private static void task1() {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    priorityQueue.add(10);
    priorityQueue.add(20);
    priorityQueue.add(15);
    System.out.println(priorityQueue.peek());
    System.out.println(priorityQueue.poll());
    System.out.println(priorityQueue.peek());
  }
}

