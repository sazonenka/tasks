package divideconquer;

import java.util.Scanner;

public class InversionCount {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scanner.nextInt();
    }

    System.out.println(inversions(arr));
  }

  private static int inversions(int[] arr) {
    int[] aux = new int[arr.length];
    return inversions(arr, aux, 0, arr.length - 1);
  }

  private static int inversions(int[] arr, int[] aux, int lo, int hi) {
    if (lo >= hi)  {
      return 0;
    }

    int mid = lo + (hi - lo) / 2;
    int i1 = inversions(arr, aux, lo, mid);
    int i2 = inversions(arr, aux, mid + 1, hi);

    int i3 = inversionsOnMerge(arr, aux, lo, mid, hi);

    return i1 + i2 + i3;
  }

  private static int inversionsOnMerge(int[] arr, int[] aux, int lo, int mid, int hi) {
    System.arraycopy(arr, lo, aux, lo, hi - lo + 1);

    int invs = 0;

    int i = lo;
    int j = mid + 1;
    for (int k = lo; k <= hi; k++) {
      if (j > hi) {
        arr[k] = aux[i++];
      } else if (i > mid) {
        arr[k] = aux[j++];
      } else if (aux[i] <= aux[j]) {
        arr[k] = aux[i++];
      } else {
        arr[k] = aux[j++];
        invs += (mid + 1 - i);
      }
    }
    return invs;
  }
}
