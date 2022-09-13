package com.yuriytkach.demo14;

import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.stream.Stream;

import one.util.streamex.EntryStream;
import one.util.streamex.StreamEx;

public class DemoEntryStream {

  public static void main(String[] args) {
    var map = Map.of("a", 1, "b", 2);
    final Stream<Map.Entry<String, Integer>> stream = map.entrySet().stream();

    EntryStream.of(map);
    EntryStream.of("a", 1, "b", 2);

    final EntryStream<Integer, String> of = EntryStream.of(List.of("a", "b"));

    final StreamEx<String> a = EntryStream.of(map)
      .filterKeys(str -> str.equals("a"))
      .filterValues(num -> num > 1)
      .filterKeyValue((str, num) -> true)
      //      .mapKeys(str -> str.length())
      //      .mapValues(num -> num + 1)
      .mapKeyValue((str, num) -> str + num);

    final EntryStream<Integer, String> invert = EntryStream.of(map)
      .distinctKeys()
      .distinctValues()
      .nonNullValues()
      .nonNullKeys()
      .invert();

    final Map<String, List<Integer>> grouping = EntryStream.of(map)
      .append("c", 3)
      .append(Map.of("d", 4))
      .prepend("a", 4)
      .grouping();

    final NavigableMap<String, Integer> stringIntegerNavigableMap = EntryStream.of(map)
      .toNavigableMap();

    final StreamEx<String> keys = EntryStream.of(map)
      .keys();

    final StreamEx<Integer> values = EntryStream.of(map).values();
  }
}
