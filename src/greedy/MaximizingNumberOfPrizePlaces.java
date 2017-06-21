package greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MaximizingNumberOfPrizePlaces {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    List<Integer> result = new ArrayList<>();
    for (int i = 1; ; i++) {
      if (2*i < n) {
        result.add(i);
        n -= i;
      } else {
        result.add(n);
        break;
      }
    }
    System.out.println(result.size());
    System.out.println(String.join(" ",
        result.stream().map(Object::toString).collect(Collectors.toList())));
  }
}
