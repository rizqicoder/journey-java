package com.rizqigo.data;

public class PrintedBook extends Book {

  private int pages;

  public PrintedBook(String title, String author, int pages) {
    super(title, author);
    this.pages = pages;
  }

  @Override
  public String getInfo() {
    return "[Printed] " + getTitle() + " by " + getAuthor() + " (" + pages + " pages)";
  }
}