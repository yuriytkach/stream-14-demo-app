package com.yuriytkach.demo14;

import org.immutables.value.Value;

@Value.Immutable
public interface Target {

  String getFullName();

  int getNumber();

}
