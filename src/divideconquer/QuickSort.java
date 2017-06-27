package divideconquer;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scanner.nextInt();
    }

    quickSort(arr, 0, n-1);
    System.out.println(Arrays.toString(arr));
  }

  private static void quickSort(int[] arr, int lo, int hi) {
    if (lo >= hi) {
      return;
    }

    int pivotIndex = partition(arr, lo, hi);
    quickSort(arr, lo, pivotIndex-1);
    quickSort(arr, pivotIndex+1, hi);
  }

  private static int partition(int[] arr, int lo, int hi) {
    // i is the last index of the right partition.
    // j is the last index of the left partition.

    int j = lo;
    for (int i = lo + 1; i <= hi; i++) {
      if (arr[i] <= arr[lo]) {
        swap(arr, i, ++j);
      }
    }
    swap(arr, lo, j);
    return j;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
