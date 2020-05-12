package lesson6;

import java.util.Random;

public class Test6 {

  static final int TREE_NUMBER = 20;
  static final int TREE_HEIGHT = 6;
  static final int DATA_RANGE = 25;

  static final Random random = new Random();

  public static void main(String[] args) {
    generateTaskResult(TREE_NUMBER);
//    for (int i = 0; i < TREE_NUMBER; i++) {
//      tillFirstTree(TREE_HEIGHT, DATA_RANGE, random);
//    }
  }

  public static void generateTaskResult(int count) {
    if (count == 0) {
      return;
    }
    tillFirstTree(random);
    count--;
    generateTaskResult(count);
  }

  protected static void tillFirstTree(Random random) {
    int count = 0;
    boolean run = true;
    while (run) {
      Tree<Integer> tree = new TreeImpl<>();
      for (int j = 0; j < 100; j++) {
        tree.add(getValue(random, DATA_RANGE));
      }
      if (tree.isBalanced() && tree.height() == TREE_HEIGHT) {
        System.out.println();
        System.out.println("First Balanced Tree at iteration " + (count + 1));
        tree.display();
        run = false;
        System.out.println("tree.height() " + tree.height());
      }
      count++;
    }
    System.out.println("result " + 1 + " balanced " + "and " + (count - 1) + " not");
    System.out.println("ratio " + 100 / count + " %");
    System.out.println();

  }

  protected static int getValue(Random random, int range) {
    if (random.nextInt(2) == 0) {
      return 1 + -1 * random.nextInt(range);
    }
    return 1 + random.nextInt(range);
  }

}
