import java.util.Scanner;

public class LastDigitOfPartialSumFibonacci {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    long m = scanner.nextLong();
    long n = scanner.nextLong();

    int sumM = lastDigitOfFibSum(m - 1);
    int sumN = lastDigitOfFibSum(n);

    int result = (10 + sumN - sumM) % 10;

    System.out.println(result);
  }

  private static int lastDigitOfFibSum(long n) {
    int m = (int) (n % 60);

    int[] a = new int[m+1];
    a[0] = 0;
    a[1] = 1;
    for (int i = 2; i <= m; i++) {
      a[i] = (a[i-2] + a[i-1] + 1) % 10;
    }

    return a[m];
  }
}
