package divideconquer;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scanner.nextInt();
    }

    mergeSort(arr);

    System.out.println(Arrays.toString(arr));
  }

  private static void mergeSort(int[] arr) {
    int[] aux = new int[arr.length];
    mergeSort(arr, aux, 0, arr.length - 1);
  }

  private static void mergeSort(int[] arr, int[] aux, int lo, int hi) {
    if (lo >= hi)  {
      return;
    }

    int mid = lo + (hi - lo) / 2;
    mergeSort(arr, aux, lo, mid);
    mergeSort(arr, aux, mid + 1, hi);

    merge(arr, aux, lo, mid, hi);
  }

  private static void merge(int[] arr, int[] aux, int lo, int mid, int hi) {
    System.arraycopy(arr, lo, aux, lo, hi - lo + 1);

    int i = lo;
    int j = mid + 1;
    for (int k = lo; k <= hi; k++) {
      if (j > hi) {
        arr[k] = aux[i++];
      } else if (i > mid) {
        arr[k] = aux[j++];
      } else if (aux[i] < aux[j]) {
        arr[k] = aux[i++];
      } else {
        arr[k] = aux[j++];
      }
    }
  }
}