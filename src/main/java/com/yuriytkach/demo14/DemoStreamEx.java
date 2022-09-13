package com.yuriytkach.demo14;

import java.io.StringReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import one.util.streamex.StreamEx;

public class DemoStreamEx {

  public static void main(String[] args) throws Exception {
    var list = List.of(1, 2, 3, 3, 3);

    StreamEx.of(list);
    StreamEx.of(1, 2, 3);
    StreamEx.of(list.stream());

//    Files.readAllLines(Path.of(new File("txt.txt").toURI())).stream();

    StreamEx.ofLines(new StringReader("hello\nworld"));

    final boolean has = StreamEx.of(list)
      .has(5);

    StreamEx.of(list)
      .without(5, 6, 7);

    StreamEx.of(new El("a", 1), new El("a", 2))
      .distinct(El::name);

    final StreamEx<Number> select = StreamEx.of(list)
      .select(Number.class);

    StreamEx.of(list)
      .append(10)
      .append(List.of(1, 2))
      .append(Stream.of(1, 2))
      .prepend(99)
      .prepend(List.of(1, 2));

    final Map<String, List<El>> stringListMap = StreamEx.of(new El("a", 1), new El("a", 2))
      .groupingBy(El::name);

    var stream1 = Stream.of(1, 2, 3);
    var stream2 = Stream.of("a", "b");

    final StreamEx<El> els = StreamEx.of(stream1)
      .zipWith(stream2, (num, str) -> new El(str, num));

    StreamEx.ofPermutations(3);

    StreamEx.of(list).count();
  }

  public record El(
    String name,
    int value
  ) { }
}
