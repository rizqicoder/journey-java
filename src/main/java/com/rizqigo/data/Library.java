package com.rizqigo.data;

import java.util.ArrayList;
import java.util.List;

public class Library {
  private List<Book> books = new ArrayList<>();
  private List<Member> members = new ArrayList<>();

  public void addBook(Book book) {
    books.add(book);
  }

  public void addMember(Member member) {
    members.add(member);
  }

  public void showAllBooks() {
    System.out.println("📖 Daftar Buku di Perpustakaan:");
    for (Book book : books) {
      System.out.println("  - " + book.getInfo() + (book.isBorrowed() ? " [Dipinjam]" : " [Belum dipinjam]"));
    }
  }

  public List<Book> getBooks() {
    return this.books;
  }

  public List<Member> getMembers() {
    return this.members;
  }
}