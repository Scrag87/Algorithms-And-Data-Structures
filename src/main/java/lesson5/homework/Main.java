package lesson5.homework;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    //task1(); // float for negative result

    task2();

  }

  protected static void task2() {
    Knapsack knapsack = new Knapsack(4);

    List<Item> itemList = new ArrayList<>();
    itemList.add(new Item("Book", 600, 1));
    itemList.add(new Item("Binoculars", 5000, 2));
    itemList.add(new Item("First aid kit", 1500, 4));
    itemList.add(new Item("Laptop", 40000, 2));
    itemList.add(new Item("Bowler hat", 500, 1));

    knapsack.checkItemList(itemList);
    System.out.println();
    System.out.println(knapsack.getKnapsackItems());
    System.out.println(knapsack);

  }

  protected static void task1() {
    Calc calc = new Calc();
    System.out.println("calc.pow " + calc.pow(3, -3));

  }

}