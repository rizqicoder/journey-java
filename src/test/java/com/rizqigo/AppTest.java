package com.rizqigo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rizqigo.data.Calculator;
import com.rizqigo.data.GenericVariantExample;
import com.rizqigo.data.Todo;
import com.rizqigo.enums.Status;

/**
 * Unit test for simple App.
 */
public class AppTest {

  private static final Logger logger = Logger.getLogger(AppTest.class.getName());

  @Test
  public void testStatusEnum() {

    logger.info("test status enum 123");

    // 1. ambil data enum
    Status completed = Status.COMPLETED;
    assertEquals(completed.getDescription(), "task has been completed");

    // konversi enum menjadi string
    String status = Status.COMPLETED.name();
    assertEquals(status, "COMPLETED");

    // konversi string menjadi enum
    Status statusEnum = Status.valueOf(status);
    assertEquals(statusEnum, Status.COMPLETED);

    // melihat isi enum
    Status[] values = Status.values();
    assertEquals(values.length, 3);
    assertEquals(values[0], Status.COMPLETED);
    assertEquals(values[1], Status.PENDING);
    assertEquals(values[2], Status.CANCELLED);
  }

  @Test
  public void testAlwaysTrue() throws Exception {
    Todo todo = new Todo("masak nasi", "memasak nasi");
    ObjectMapper om = new ObjectMapper();

    String json = om.writerWithDefaultPrettyPrinter()
        .writeValueAsString(todo);

    assertNotNull(json);
    assertTrue(json.contains("masak nasi"));
    assertTrue(json.contains("memasak nasi"));

    System.out.println(json);
  }

  @Test
  public void testGenericVariantExample() {
    GenericVariantExample.run();
  }

  @Test
  public void testCalculator() {
    Calculator<Double> doubleValue = new Calculator<>(10.0, 2.0);
    assertEquals(12.0, doubleValue.add());
    assertEquals(20.0, doubleValue.multiply());

    Calculator<Long> longValue = new Calculator<>(10L, 2L);
    assertEquals(12L, longValue.add());
    assertEquals(20L, longValue.multiply());

    // errors karena String tidak turunan dari Number
    // Calculator<String> stringValue = new Calculator<>("10", "2");
  }

  @Test
  public void testTodoComparable() {
    List<Todo> todos = new ArrayList<>(List.of(
        new Todo("membaca buku di rumah", "memasak nasi"),
        new Todo("masak mie", "memasak mie goreng")));

    assertNotNull(todos);

    Collections.sort(todos);
    todos.forEach(d -> System.out.println(d.toString()));
  }

  @Test
  public void testTodoComparator() {
    List<Todo> todos = new ArrayList<>(List.of(
        new Todo("membaca buku di rumah", "memasak nasi"),
        new Todo("masak mie", "memasak mie goreng")));

    assertNotNull(todos);

    // versi panjang sebelum java 8
    Comparator<Todo> comparator = new Comparator<Todo>() {
      @Override
      public int compare(Todo o1, Todo o2) {
        return o1.getTitle().compareTo(o2.getTitle());
      }
    };
    assertNotNull(comparator);

    // versi singkat java 8
    Comparator<Todo> comparator2 = (o1, o2) -> o1.getTitle().compareTo(o2.getTitle());
    assertNotNull(comparator2);

    todos.sort(Comparator.comparing(Todo::getTitle));

    todos.forEach(d -> System.out.println(d.toString()));
  }
}
