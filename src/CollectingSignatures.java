import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CollectingSignatures {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    Segment[] segments = new Segment[n];
    for (int i = 0; i < n; i++) {
      segments[i] = new Segment(scanner.nextInt(), scanner.nextInt());
    }

    Arrays.sort(segments);

    List<Integer> points = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (points.isEmpty() || segments[i].start > points.get(points.size() - 1)) {
        points.add(segments[i].end);
      }
    }
    System.out.println(points.size());
    System.out.println(String.join(" ",
        points.stream().map(Object::toString).collect(Collectors.toList())));
  }

  private static class Segment implements Comparable<Segment> {
    final int start;
    final int end;

    Segment(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public int compareTo(Segment s) {
      return Integer.compare(end, s.end);
    }
  }
}
