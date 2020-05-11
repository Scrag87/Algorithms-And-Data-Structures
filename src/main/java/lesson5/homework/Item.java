package lesson5.homework;


public class Item {

  String name;
  int worth;
  int weight;

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
