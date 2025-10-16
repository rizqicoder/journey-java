package com.rizqigo.data;

public abstract class Book {
  private String title;
  private String author;
  private boolean isBorrowed;

  public Book(String title, String author) {
    this.title = title;
    this.author = author;
    this.isBorrowed = false;
  }

  public String getTitle() {
    return this.title;
  }

  public String getAuthor() {
    return this.author;
  }

  public boolean isBorrowed() {
    return this.isBorrowed;
  }

  public void borrow() {
    this.isBorrowed = true;
  }

  public void returnBook() {
    this.isBorrowed = false;
  }

  /**
   * abstract method untuk menampulkan informasi buku
   */
  public abstract String getInfo();
}