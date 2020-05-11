package lesson5.homework;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {

  int capacity;
  int bestNetWorth;
  List<Item> knapsackItems;

  public Knapsack(int capacity) {
    this.capacity = capacity;
    this.knapsackItems = new ArrayList<>();
  }

  private int getSumWorthFromList(List<Item> list) {
    int tmp = 0;
    for (Item item : list) {
      tmp += item.worth;
    }
    return tmp;
  }

  private int getSumWeightFromList(List<Item> list) {
    int tmp = 0;
    for (Item item : list) {
      tmp += item.weight;
    }
    return tmp;
  }

  private void calculateBestResult(List<Item> list) {
    if (knapsackItems.isEmpty()) {
      if (getSumWeightFromList(list) <= capacity) {
        knapsackItems.addAll(list);
        bestNetWorth = getSumWorthFromList(list);
      }
    } else {
      if (getSumWeightFromList(list) <= capacity && getSumWorthFromList(list) > bestNetWorth) {
        knapsackItems.clear();
        knapsackItems.addAll(list);
        bestNetWorth = getSumWorthFromList(list);
      }
    }
  }

  public List<Item> getKnapsackItems() {
    return knapsackItems;
  }

  public void checkItemList(List<Item> list) {
    if (!list.isEmpty()) {
      calculateBestResult(list);
    }
    for (int i = 0; i < list.size(); i++) {
      List<Item> itemList = new ArrayList<>(list);
      itemList.remove(i);
      checkItemList(itemList);
    }

  }

  @Override
  public String toString() {
    return "Knapsack{" +
        "capacity=" + capacity +
        ", bestNetWorth=" + bestNetWorth +
        ", knapsackItems=" + knapsackItems +
        '}';
  }
}
