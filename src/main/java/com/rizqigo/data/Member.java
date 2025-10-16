package com.rizqigo.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Member {
  private String name;
  private List<Book> borrowedBooks = new ArrayList<>();

  public Member(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void borrowBook(Book book, Library library) {
    if (book.isBorrowed()) {
      System.out.println("❌ Buku sudah dipinjam orang lain: " + book.getTitle());
    } else {
      book.borrow();
      borrowedBooks.add(book);
      this.toggleBorrowBook(book, library, true);
      System.out.println("✅ " + name + " meminjam " + book.getTitle());
    }
  }

  public void returnBook(Book book, Library library) {
    if (borrowedBooks.remove(book)) {
      book.returnBook();
      this.toggleBorrowBook(book, library, false);
      System.out.println("✅ " + name + " mengembalikan " + book.getTitle());
    } else {
      System.out.println("⚠️ Buku ini tidak ada dalam daftar pinjamanmu!");
    }
  }

  public void showBorrowedBooks() {
    System.out.println("📚 Buku yang dipinjam oleh " + name + ":");
    if (borrowedBooks.isEmpty()) {
      System.out.println("tidak ada");
    }
    borrowedBooks.forEach(book -> System.out.println(" - " + book.getInfo()));
  }

  private void toggleBorrowBook(Book book, Library library, boolean toggle) {
    for (Book b : library.getBooks()) {
      if (b.getTitle().equalsIgnoreCase(book.getTitle())) {
        if (toggle) {
          b.borrow();
        } else {
          b.returnBook();
        }
        break;
      }
    }
  }
}