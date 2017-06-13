import java.util.Scanner;

public class ChangingMoney {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int m = scanner.nextInt();

    int[] coins = {10, 5, 1};

    int n = 0;
    for (int coin : coins) {
      while (m - coin >= 0) {
        m -= coin;
        n++;
      }
    }

    System.out.println(n);
  }
}
