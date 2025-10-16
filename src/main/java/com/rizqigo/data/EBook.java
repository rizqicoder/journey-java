package com.rizqigo.data;

public class EBook extends Book {

  private double fileSize;

  public EBook(String title, String author, double fileSize) {
    super(title, author);
    this.fileSize = fileSize;
  }

  @Override
  public String getInfo() {
    return "[EBook] " + getTitle() + " by " + getAuthor() + " (" + fileSize + "MB)";
  }
}