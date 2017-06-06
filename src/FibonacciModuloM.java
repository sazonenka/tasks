import java.util.Scanner;

public class FibonacciModuloM {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    long n = scanner.nextLong();
    int m = scanner.nextInt();

    int[] a = new int[6*m];
    a[0] = 0;
    a[1] = 1;
    for (int i = 2; i < 6*m; i++) {
      a[i] = (a[i-2] + a[i-1]) % m;
      if (a[i-1] == 1 && a[i] == 0) {
        System.out.println(a[(int) (n % i)]);
        break;
      }
    }
  }
}
