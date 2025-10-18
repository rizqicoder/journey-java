package com.rizqigo.data;

public abstract class Animal {
  private String name;

  public Animal(String name) {
    this.name = name;
  }

  public abstract void speak();

  public String getName() {
    return this.name;
  }
}