package com.rizqigo.data;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;

public class Basic {

  private static final String version = "1.0.0";
  private static ArrayList<String> listHasing = new ArrayList<>();

  /**
   * contoh pengecekan password
   * data password yang disimpan di list hashing
   * akan di cek dengan password client
   */
  public static void checkPassword() {
    // melakukan penyimpanan password ke list
    storeHashingPassword("rizqigo");
    // bayangkan ini password client
    String passwordClient = "wrong-password";
    try {
      // melakukan hasing menggunakan SHA-256
      MessageDigest md = MessageDigest.getInstance("SHA-256");
      // konversi password client ke base64 agar password sama dengan list
      String hashInputBase64 = Base64.getEncoder().encodeToString(md.digest(passwordClient.getBytes()));
      // check jika password client ada di list
      if (listHasing.contains(hashInputBase64)) {
        sout("password valid");
      } else {
        sout("password invalid");
      }
    } catch (NoSuchAlgorithmException e) {
      sout(e.getMessage());
    }
  }

  /**
   * menyimpan password ke list
   * 
   * @param passsword
   * @return void
   */
  public static void storeHashingPassword(String passsword) {
    listHasing.add(hashingPassword(passsword));
  }

  /**
   * bayangkan anda ingin melakukan hasing password ke SHA-256
   * 
   * @param password
   * @return String
   */
  public static String hashingPassword(String password) {
    try {
      // melakukan hasing menggunakan SHA-256
      MessageDigest md = MessageDigest.getInstance("SHA-256");
      return Base64.getEncoder().encodeToString(md.digest(password.getBytes()));
    } catch (NoSuchAlgorithmException e) {
      return e.getMessage();
    }
  }

  public static void createdArray() {
    String[] cities = { "indonesian", "malaysia", "singapore", "japan" };
    sout("length city " + cities.length);

    int ix = 0;
    for (String city : cities) {
      sout("index[" + ix++ + "] : " + city);
    }

    // manipulasi menambahkan data
    // 1 salin data cities
    String[] newCities = new String[cities.length + 1];
    // 2 tambah data setelah singapore
    int istdx = 3;
    String v = "Australia";
    for (int from = 0; from < istdx; from++) {
      newCities[from] = cities[from];
    }
    // 3 masukkan element pada index 3
    newCities[istdx] = v;
    // 4 geser sisa element ke kanan
    for (int from = istdx; from < cities.length; from++) {
      newCities[from + 1] = cities[from];
    }
    // 5 update referensi
    cities = newCities;
    sout(Arrays.toString(cities));

    // manipulasi edit data australia menjadi uppercase
    int edtdx = 3;
    cities[edtdx] = "australia".toUpperCase();
    sout(Arrays.toString(cities));

    // manipulasi menghapus data dengan geser ke kiri
    // 1 tentukan index mana yang ingin dihapus
    int removeIndex = 3;
    String[] cpCities = new String[cities.length - 1];
    // 2 salin semua kecuali element yang dihapus
    for (int a = 0, b = 0; a < cities.length; a++) {
      if (a != removeIndex) {
        cpCities[b++] = cities[a];
      }
    }
    // 3. update referensi
    cities = cpCities;
    sout(Arrays.toString(cities));
  }

  public static void nonPrimitive() {
    Integer v = 10_0000;
    Long l = v.longValue();

    // false karena perbandingan menggunakan reference objek
    System.out.println(v.equals(l));

    // melihat nilai reference objek
    System.out.println(System.identityHashCode(v));
    System.out.println(System.identityHashCode(l));

    // true karena perbandingan menggunakan value
    System.out.println(v.intValue() == l.longValue());
  }

  public static void dataNumber() {
    byte b = 127;
    short s = 32767;
    int i = 2147483647;
    long l = 9223372036854775807L;

    System.out.println(b);
    System.out.println(s);
    System.out.println(i);
    System.out.println(l);

    // 0x, 0b
    byte b1 = 0x7F;
    byte b2 = 0b0111_1111;
    int my_bith = 0b10101101111000000111;
    System.out.println(b1);
    System.out.println(b2);
    System.out.println(my_bith);

    // convert type data immersive
    int a = 10;
    long c = a;
    System.out.println(a);
    System.out.println(c);

    // convert type data explicit
    long d = 90_000L;
    int e = (int) d;
    System.out.println(d);
    System.out.println(e);
  }

  public static void dataChar() {
    char male = 'm';
    char female = 'f';

    if (male == 'm') {
      System.out.println("Laki-laki");
    }

    if (female == 'f') {
      System.out.println("Perempuan");
    }
  }

  public static void dataBoolean() {
    boolean result = check(false);
    if (result) {
      System.out.println("true boolean");
    }
    if (!result) {
      System.out.println("false boolean");
    }
  }

  /**
   * contoh konversi data string menjadi bytes lalu tampilkan datanya
   */
  public static void dataString() {
    String name = "rizqigo".toUpperCase();
    byte[] nameBytes = name.getBytes();
    if (name.equals("RIZQIGO")) {
      System.out.println("Hello " + name + " bytes is " + Arrays.toString(nameBytes));
    }
  }

  public static void logVersion() {
    System.out.println("version " + getVersion());
  }

  private static boolean check(boolean condition) {
    if (condition) {
      return true;
    }
    return false;
  }

  public static String getVersion() {
    return version;
  }

  public static void sout(String message) {
    System.out.println(message);
  }
}
