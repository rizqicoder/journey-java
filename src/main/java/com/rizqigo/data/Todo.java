package com.rizqigo.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Todo implements Comparable<Todo> {
  private String title;
  private String description;

  @JsonProperty("done")
  private boolean isDone;

  public Todo() {
  }

  public Todo(String title, String description) {
    this.title = title;
    this.description = description;
    this.isDone = false;
  }

  public String getTitle() {
    return this.title;
  }

  public String getDescription() {
    return this.description;
  }

  public boolean isDone() {
    return this.isDone;
  }

  public void markAsDone() {
    this.isDone = true;
  }

  @Override
  public int compareTo(Todo o) {
    return this.title.compareTo(o.title);
  }

  @Override
  public String toString() {
    return "Todo [title=" + title + ", description=" + description + ", isDone=" + isDone + "]";
  }
}