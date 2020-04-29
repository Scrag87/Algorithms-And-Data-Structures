package lesson2.homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.TreeSet;

public class Main {

  public static void main(String[] args) {
    Random random = new Random();
    int[] testArray = new int[100_000];
    for (int i = 0; i < testArray.length; i++) {
      testArray[i] = random.nextInt();
    }
    System.out.println();


   // Array<Integer> data = new ImplArray<>();

    Sort.bubbleSort(testArray);
    Sort.sortInsert(testArray);
    Sort.selectionSort(testArray);
    Sort.nativeSort(testArray);

//1.
//Test general result is: 18690ms in bubbleSort
//Test general result is: 999ms in sortInsert
//Test general result is: 3952ms in selectionSort
//Test general result is: 28ms in nativeSort
//
//2.
//Test general result is: 18587ms in bubbleSort
//Test general result is: 995ms in sortInsert
//Test general result is: 3932ms in selectionSort
//Test general result is: 14ms in nativeSort
//
//3.
//Test general result is: 18595ms in bubbleSort
//Test general result is: 993ms in sortInsert
//Test general result is: 3926ms in selectionSort
//Test general result is: 13ms in nativeSort

/*
    PerformanceTester performanceTester = new PerformanceTester();
    ArrayList<Integer> arrayList = new ArrayList<>();
    HashSet<Integer> hashSet = new HashSet<>();
    TreeSet<Integer> treeSet = new TreeSet<>();
    LinkedList<Integer> linkedList =new LinkedList<>();


    System.out.println(hashSet.getClass().getSimpleName());
    performanceTester.measureStart();
    performanceTester.addElements(hashSet, 100000, 30);
    performanceTester.measureFinish();

    System.out.println(arrayList.getClass().getSimpleName());
    performanceTester.measureStart();
    performanceTester.addElements(arrayList, 100000, 30);
    performanceTester.measureFinish();

    System.out.println(treeSet.getClass().getSimpleName());
    performanceTester.measureStart();
    performanceTester.addElements(treeSet, 100000, 30);
    performanceTester.measureFinish();

    System.out.println(linkedList.getClass().getSimpleName());
    performanceTester.measureStart();
    performanceTester.addElements(linkedList, 100000, 30);
    performanceTester.measureFinish();

*/

//        HashSet
//    final average Result :11ms
//    Test general result is: 356ms
//
//        ArrayList
//    final average Result :5ms
//    Test general result is: 171ms
//
//        TreeSet
//    final average Result :36ms
//    Test general result is: 1099ms
//
//        LinkedList
//    final average Result :5ms
//    Test general result is: 191ms
//
  }



}
