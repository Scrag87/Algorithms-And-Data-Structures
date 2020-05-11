package lesson5.homework;

public class Calc {

  private float powFinder(float number, int power) {
    if (power <= 1) {
      return number;
    }
    return number * powFinder(number, --power);
  }

  public float pow(float number, int power) {
    System.out.println("Math.pow " + Math.pow(number, power));
    if (power == 0) {
      return 1;
    }
    if (power < 0) {
      // 2^-3 = 1/2^3
      return 1 / powFinder(number, -1 * power);
    } else {
      return powFinder(number, power);
    }
  }
}
