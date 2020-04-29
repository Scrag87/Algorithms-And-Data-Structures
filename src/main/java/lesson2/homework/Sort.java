package lesson2.homework;

import java.util.Arrays;

public class Sort {

  static PerformanceTester performanceTester = new PerformanceTester();

  public static void sortInsert(int[] initialArray) {
    int[] testArray = Arrays.copyOf(initialArray, initialArray.length);
    printNumberOfFirstValues(testArray,10);

    performanceTester.measureStart();

    for (int i = 1; i < testArray.length; i++) {
      int temp = testArray[i];
      int insertPosition = i - 1;
      while (insertPosition >= 0 && temp < testArray[insertPosition]) {
        testArray[insertPosition + 1] = testArray[insertPosition];
        insertPosition--;
      }
      // at this point we've exited, so j is either -1
      // or it's at the first element where current >= a[j]
      testArray[insertPosition + 1] = temp;
    }

    performanceTester.measureFinish("sortInsert");
    printNumberOfFirstValues(testArray,10);
  }

  public static void bubbleSort(int[] initialArray) {
    int[] testArray = Arrays.copyOf(initialArray, initialArray.length);

    printNumberOfFirstValues(testArray,10);

    boolean sorted = false;
    int temp;
    performanceTester.measureStart();

    while (!sorted) {
      sorted = true;
      for (int i = 0; i < testArray.length - 1; i++) {
        if (testArray[i] > testArray[i + 1]) {  //left - right
          temp = testArray[i];
          testArray[i] = testArray[i + 1];
          testArray[i + 1] = temp;
          sorted = false;
        }
      }
    }

    performanceTester.measureFinish("bubbleSort");

    printNumberOfFirstValues(testArray,10);
  }

  public static void selectionSort(int[] initialArray) {
    int[] testArray = Arrays.copyOf(initialArray, initialArray.length);
    printNumberOfFirstValues(testArray,10);
    performanceTester.measureStart();
    for (int i = 0; i < testArray.length; i++) {
      int min = testArray[i];
      int minId = i;
      for (int j = i + 1; j < testArray.length; j++) {
        if (testArray[j] < min) {
          min = testArray[j];
          minId = j;
        }
      }
      // swapping
      int temp = testArray[i];
      testArray[i] = min;
      testArray[minId] = temp;
    }
    performanceTester.measureFinish("selectionSort");
    printNumberOfFirstValues(testArray,10);
  }

  public static void nativeSort(int[] initialArray) {
    int[] testArray = Arrays.copyOf(initialArray, initialArray.length);
    printNumberOfFirstValues(testArray,10);
    performanceTester.measureStart();
    Arrays.sort(testArray);
    performanceTester.measureFinish("nativeSort");
    printNumberOfFirstValues(testArray,10);
  }


  private static void printNumberOfFirstValues(int[] data, int number) {
    if (data.length < number) {
      throw new IndexOutOfBoundsException("incorrect Data");
    }
    System.out.println();
    System.out.print("first "+number+" int of given test array: ");
    for (int i = 0; i < number; i++) {
      System.out.print(data[i] + " ");
    }
    System.out.println();
  }
}
