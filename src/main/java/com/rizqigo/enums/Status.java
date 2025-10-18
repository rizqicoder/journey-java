package com.rizqigo.enums;

public enum Status {
  COMPLETED("task has been completed"),
  PENDING("task is pending"),
  CANCELLED("task has been cancelled");

  private String description;

  private Status(String description) {
    this.description = description;
  }

  public String getDescription() {
    return this.description;
  }
}
