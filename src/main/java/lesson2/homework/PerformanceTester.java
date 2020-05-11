package lesson2.homework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PerformanceTester {

  ArrayList<Long> results = new ArrayList<>();

  private long start;
  private long end;

  private long startExternal;
  private long pointExternal;
  private long endExternal;

  public void measureStart() {
    startExternal = System.nanoTime();
  }

  public void measurePoint() {
    pointExternal = System.nanoTime();
  }

  public void measureFinish() {
    endExternal = System.nanoTime();
    long result = endExternal - startExternal;
    System.out.println();
    System.out.println("Test general result is: " + TimeUnit.NANOSECONDS.toMillis(result) + "ms");
    if (pointExternal != 0) {
      long resultPointToStart = pointExternal - startExternal;
      long resultPointToEnd = endExternal - pointExternal;
      System.out.println();
      System.out.println(
          "Test result Point -> Start is: " + TimeUnit.NANOSECONDS.toMillis(resultPointToStart));
      System.out.println(
          "Test result Point -> End is: " + TimeUnit.NANOSECONDS.toMillis(resultPointToEnd));
      pointExternal = 0;
      System.out.println();
    }
  }

  public void measureFinish(String message) {
    endExternal = System.nanoTime();
    long result = endExternal - startExternal;
    System.out.println();
    System.out.println(
        "Test general result is: " + TimeUnit.NANOSECONDS.toMillis(result) + "ms, " + message);
    if (pointExternal != 0) {
      long resultPointToStart = pointExternal - startExternal;
      long resultPointToEnd = endExternal - pointExternal;
      System.out.println();
      System.out.println(
          "Test result Point -> Start is: " + TimeUnit.NANOSECONDS.toMillis(resultPointToStart));
      System.out.println(
          "Test result Point -> End is: " + TimeUnit.NANOSECONDS.toMillis(resultPointToEnd));
      pointExternal = 0;
    }
  }

//  public void addElements(ArrayList list, int iterations, int times) {
//    beforeTest();
//
//    for (int i = 1; i <= times; i++) {
//      list.clear();
//      int x = 0;
//      start = System.nanoTime();
//      while (x <= iterations) {
//        list.add(getRandomIntValue());
//        x++;
//      }
//      end = System.nanoTime();
//      saveResult(getResult());
//    }
//    finalResult(times);
//    System.out.println(list.size());
//  }

  public void addElements(Collection<Integer> list, int iterations, int times) {
    beforeTest();
    for (int i = 1; i <= times; i++) {
      list.clear();
      int x = 0;
      start = System.nanoTime();
      while (x <= iterations) {
        list.add(getRandomIntValue());
        x++;
      }
      end = System.nanoTime();
      saveResult(getResult());
    }
    System.out.println(list.size());
    finalResult(times);
  }

//  public void addElements(Set<Integer> set, int iterations, int times) {
//    if (times <= 0 || iterations <= 0) {
//      throw new IllegalArgumentException("Wrong Parameters");
//    }
//    beforeTest();
//    for (int i = 1; i <= times; i++) {
//      set.clear();
//      int x = 0;
//      start = System.nanoTime();
//      while (x <= iterations) {
//        set.add(getRandomIntValue());
//        x++;
//      }
//      end = System.nanoTime();
//      saveResult(getResult());
//    }
//    finalResult(times);
//    System.out.println(set.size());
//  }

  private void finalResult(int count) {
    long tmp = 0;
    for (Long result : results) {
      tmp += result;
    }
    System.out
        .println("final average Result :" + TimeUnit.NANOSECONDS.toMillis(tmp) / count + "ms");
  }


  private long getResult() {
    long result = end - start;
    return result;
  }

  private int getRandomIntValue() {
    return new Random().nextInt();
  }

  private void saveResult(long result) {
    results.add(result);
  }

  private void beforeTest() {
    start = 0;
    end = 0;
    results.clear();
  }
}
