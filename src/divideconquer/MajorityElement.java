package divideconquer;

import java.util.Scanner;

public class MajorityElement {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scanner.nextInt();
    }

    System.out.println(majorityElement(arr, 0, n-1));
  }

  // Majority element appears strictly more than n/2 times.
  private static int majorityElement(int[] arr, int lo, int hi) {
    if (lo > hi) {
      return -1;
    } else if (lo == hi) {
      return arr[lo];
    }

    int n = hi - lo + 1;
    int mid = lo + (hi - lo) / 2;

    int leftMajor = majorityElement(arr, lo, mid);
    if (leftMajor > 0 && appearances(arr, lo, hi, leftMajor) > n / 2) {
      return leftMajor;
    }

    int rightMajor = majorityElement(arr, mid + 1, hi);
    if (rightMajor > 0 && appearances(arr, lo, hi, rightMajor) > n / 2) {
      return rightMajor;
    }

    return -1;
  }

  private static int appearances(int[] arr, int lo, int hi, int elem) {
    int app = 0;
    for (int i = lo; i <= hi; i++) {
      if (arr[i] == elem) {
        app++;
      }
    }
    return app;
  }
}
