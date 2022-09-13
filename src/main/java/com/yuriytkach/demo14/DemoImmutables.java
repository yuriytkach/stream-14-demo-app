package com.yuriytkach.demo14;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.immutables.value.Value;

public class DemoImmutables {

  public static void main(String[] args) {
    final Hello aaa = ImmutableHello.builder()
      .name("aaa")
      .number(45L)
      .active(true)
      .build();

    final ImmutableHello bbb = ImmutableHello.builder()
      .name("bbb")
      .active(true)
      .addAllAddresses(List.of())
      .addAddresses("address", "address2")
      .putAllValues(Map.of())
      .putValues("key", 23)
      .build();

    final ImmutableHello immutableHello = bbb.withActive(false);

    ImmutableHelloStage.builder()
      .name("asdf")
      .active(true)
      .number(67L)
      .age(45)
      .build();

    System.out.println(aaa.getNumber());

    var value = ImmutableSmallValue.of("password", 42);
    System.out.println(value);
  }

  @Value.Immutable
  @Value.Style(get = {"get*", "is*"}, strictBuilder = true)
  public interface Hello {
    String getName();
    Optional<Integer> getAge();
    @Value.Default
    default Long getNumber() {
      return 10L;
    }
    boolean isActive();
    List<String> addresses();
    Map<String, Integer> values();
  }

  @Value.Immutable
  @Value.Style(get = {"get*", "is*"}, stagedBuilder = true)
  public interface HelloStage {
    String getName();
    Optional<Integer> getAge();
    @Value.Default
    default Long getNumber() {
      return 10L;
    }
    boolean isActive();
  }

  @Value.Immutable(builder = false)
  public interface SmallValue {
    @Value.Parameter
    @Value.Redacted
    String getSecret();
    @Value.Parameter
    @Value.Auxiliary
    int getValue();
  }

}
