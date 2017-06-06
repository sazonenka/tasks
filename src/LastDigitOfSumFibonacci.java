import java.util.Scanner;

public class LastDigitOfSumFibonacci {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    long n = scanner.nextLong();

    int m = (int) (n % 60);

    int[] a = new int[m+1];
    a[0] = 0;
    a[1] = 1;
    for (int i = 2; i <= m; i++) {
      a[i] = (a[i-2] + a[i-1] + 1) % 10;
    }

    System.out.println(a[m]);
  }
}
