package com.rizqigo.data;

public class Dog extends Animal {
  public Dog(String name) {
    super(name);
  }

  public void speak() {
    System.out.println("Woof");
  }
}