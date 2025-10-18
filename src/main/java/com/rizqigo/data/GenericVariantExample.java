package com.rizqigo.data;

import java.util.ArrayList;
import java.util.List;

public class GenericVariantExample {
  /**
   * covariant (? extends T) example
   * Biasa digunakan saat hanya membaca data, bukan menulis.
   * boleh dibaca tetapi tidak boleh ditulis
   */
  public static void printAnimals(List<? extends Animal> animals) {
    for (Animal a : animals) {
      a.speak(); // boleh dibaca
    }
    // animals.add(new Dog()); tidak boleh ditulis karena tidak tahu tipenya
  }

  /**
   * contravariant (? super T) example
   * Biasa digunakan saat hanya menulis data, bukan membaca dengan tipe spesifik.
   * boleh ditulis, tetapi membaca hanya boleh melalui Object
   */
  public static void addDogs(List<? super Dog> dogs) {
    dogs.add(new Dog("rex")); // boleh ditulis

    // membaca hanya bisa melalui Object
    Object dogObject = dogs.get(0); // hanya object
    System.out.println("Object class " + dogObject.getClass().getSimpleName());
  }

  public static void run() {
    List<Dog> dogs = new ArrayList<>();
    dogs.add(new Dog("soni"));

    List<Cat> cats = new ArrayList<>();
    cats.add(new Cat("moli"));

    System.out.println("convariant example");
    printAnimals(dogs);
    printAnimals(cats);

    System.out.println("contravariant example");
    addDogs(dogs);
    // addDogs(cats); errors
  }
}