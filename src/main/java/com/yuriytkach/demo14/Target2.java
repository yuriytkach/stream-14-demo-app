package com.yuriytkach.demo14;

import java.util.Optional;

import org.immutables.value.Value;

@Value.Immutable
@Value.Style(get = {"get*", "is*"})
public interface Target2 {

  String getName();

  int getValue();

  Optional<Boolean> isActive();

}
