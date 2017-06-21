package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class FractionalKnapsackProblem {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int w = scanner.nextInt();

    Item[] items = new Item[n];
    for (int i = 0; i < n; i++) {
      items[i] = new Item(scanner.nextInt(), scanner.nextInt());
    }

    Arrays.sort(items);

    double v = 0.0;
    for (Item item : items) {
      if (w <= 0) {
        break;
      }
      int wi = Math.min(w, item.w);

      v += item.vPerW * wi;
      w -= wi;
    }
    System.out.printf("%.4f", v);
  }

  private static class Item implements Comparable<Item> {
    final int v;
    final int w;

    final double vPerW;

    Item(int v, int w) {
      this.v = v;
      this.w = w;

      this.vPerW = 1.0 * v / w;
    }

    @Override
    public int compareTo(Item i) {
      return Double.compare(i.vPerW, vPerW);
    }
  }
}

