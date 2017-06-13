import java.util.Arrays;
import java.util.Scanner;

public class OnlineAdsPlacement {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = scanner.nextInt();
    }
    int[] b = new int[n];
    for (int i = 0; i < n; i++) {
      b[i] = scanner.nextInt();
    }

    Arrays.sort(a);
    Arrays.sort(b);

    for (int i = 0; i < n/2; i++) {
      int temp = a[i];
      a[i] = a[n-1-i];
      a[n-1-i] = temp;
    }
    for (int i = 0; i < n/2; i++) {
      int temp = b[i];
      b[i] = b[n-1-i];
      b[n-1-i] = temp;
    }

    int p = 0;
    for (int i = 0; i < n; i++) {
      p += a[i] * b[i];
    }
    System.out.println(p);
  }
}
