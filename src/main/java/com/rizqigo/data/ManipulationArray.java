package com.rizqigo.data;

import java.util.Arrays;

public class ManipulationArray<T> {

  private T[] data;

  public ManipulationArray(T[] data) {
    this.data = data;
  }

  public T[] append(int index, T value) {
    T[] cpData = Arrays.copyOf(this.data, this.data.length + 1);
    for (int from = 0; from < this.data.length; from++) {
      cpData[from] = this.data[from];
    }
    cpData[index] = value;
    for (int from = index; from < this.data.length; from++) {
      cpData[from + 1] = this.data[from];
    }
    this.data = cpData;
    return this.data;
  }

  public T[] update(int index, T value) {
    this.data[index] = value;
    return this.data;
  }

  /**
   * remove value from array use index
   * 
   * @param index
   * @return array
   */
  public T[] remove(int index) {
    T[] cpData = Arrays.copyOf(this.data, this.data.length - 1);
    for (int a = 0, b = 0; a < this.data.length; a++) {
      if (a != index) {
        cpData[b++] = this.data[a];
      }
    }
    this.data = cpData;
    return this.data;
  }

  public T[] get() {
    return this.data;
  }

}
