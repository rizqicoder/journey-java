package com.rizqigo.data;

/**
 * Bounded Type Parameter
 * (T extends Number)
 * hanya bisa turunan dari Number class
 */
public class Calculator<T extends Number> {
  private T x;
  private T y;

  public Calculator(T num1, T num2) {
    this.x = num1;
    this.y = num2;
  }

  public double add() {
    return this.x.doubleValue() + this.y.doubleValue();
  }

  public double multiply() {
    return this.x.doubleValue() * this.y.doubleValue();
  }
}