package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MaximizingYourSalary {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    Piece[] pieces = new Piece[n];
    for (int i = 0; i < n; i++) {
      pieces[i] = new Piece(scanner.nextInt());
    }

    Arrays.sort(pieces);

    StringBuilder answer = new StringBuilder();
    for (Piece piece : pieces) {
      answer.append(piece.number);
    }
    System.out.println(answer);
  }

  private static class Piece implements Comparable<Piece> {
    final int number;

    Piece(int number) {
      this.number = number;
    }

    @Override
    public int compareTo(Piece p) {
      int sum1 = Integer.parseInt(String.valueOf(number) + String.valueOf(p.number));
      int sum2 = Integer.parseInt(String.valueOf(p.number) + String.valueOf(number));
      return Integer.compare(sum2, sum1);
    }
  }
}
