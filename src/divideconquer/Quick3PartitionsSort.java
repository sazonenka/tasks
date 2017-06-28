package divideconquer;

import java.util.Arrays;
import java.util.Scanner;

public class Quick3PartitionsSort {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scanner.nextInt();
    }

    quick3PartitionsSort(arr, 0, n-1);
    System.out.println(Arrays.toString(arr));
  }

  private static void quick3PartitionsSort(int[] arr, int lo, int hi) {
    if (lo >= hi) {
      return;
    }

    int[] pivots = partition(arr, lo, hi);
    quick3PartitionsSort(arr, lo, pivots[0]-1);
    quick3PartitionsSort(arr, pivots[1]+1, hi);
  }

  private static int[] partition(int[] arr, int lo, int hi) {
    // i is the last index of the 1st partition.
    // j is the last index of the 2nd partition.
    // k is the last index of the 3rd partition.

    int i = lo;
    int j = lo;
    for (int k = lo + 1; k <= hi; k++) {
      if (arr[k] <= arr[lo]) {
        swap(arr, k, ++j);
      }
      if (arr[j] < arr[lo]) {
        swap(arr, j, ++i);
      }
    }
    swap(arr, lo, i);
    return new int[]{i, j};
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
