package lesson5.homework;


public class Item {

  private final String name;
  private final int worth;
  private final int weight;

  public String getName() {
    return name;
  }

  public int getWorth() {
    return worth;
  }

  public int getWeight() {
    return weight;
  }

  public Item(String name, int worth, int weight) {
    this.name = name;
    this.worth = worth;
    this.weight = weight;
  }

  @Override
  public String toString() {
    return "Item{" +
        "name='" + name + '\'' +
        ", worth=" + worth +
        ", weight=" + weight +
        '}';
  }
}
