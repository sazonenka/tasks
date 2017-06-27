package divideconquer;

import java.util.Scanner;

public class BinarySearch {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = scanner.nextInt();
    }

    int k = scanner.nextInt();

    int[] b = new int[k];
    for (int i = 0; i < k; i++) {
      b[i] = scanner.nextInt();
    }

    for (int i = 0; i < k; i++) {
      System.out.printf("%d ", binarySearch(a, 0, n-1, b[i]));
    }
  }

  private static int binarySearch(int[] a, int lo, int hi, int value) {
    if (lo > hi) {
      return -1;
    }
    int mid = lo + (hi-lo) / 2;
    if (a[mid] == value) {
      return mid;
    } else if (a[mid] > value) {
      return binarySearch(a, lo, mid-1, value);
    } else {
      return binarySearch(a, mid+1, hi, value);
    }
  }
}
