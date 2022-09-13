package com.yuriytkach.demo14;

public class Source {

  private String name;

  private int value;

  public Source(final String name, final int value) {
    this.name = name;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public int getValue() {
    return value;
  }

  public void setValue(final int value) {
    this.value = value;
  }
}
