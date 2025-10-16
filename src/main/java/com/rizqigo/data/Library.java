package com.rizqigo.data;

import java.util.ArrayList;
import java.util.List;

public class Library {

  private static final Library INSTANCE = new Library();

  private List<Book> books = new ArrayList<>();
  private List<Member> members = new ArrayList<>();

  private Library() {
    System.out.println("library instance created");
  }

  public static Library getInstance() {
    return INSTANCE;
  }

  public void addBook(Book book) {
    books.add(book);
  }

  public void addMember(Member member) {
    members.add(member);
  }

  public void showAllBooks() {
    System.out.println("📖 Daftar Buku di Perpustakaan:");
    for (Book book : this.books) {
      System.out.println("  - " + book.getInfo() + (book.isBorrowed() ? " [Dipinjam]" : " [Belum dipinjam]"));
    }
  }

  public void showAllMembers() {
    System.out.println("👥 Daftar Anggota Perpustakaan:");
    for (Member member : members) {
      System.out.println("  - " + member.getName());
    }
  }

  public List<Book> getBooks() {
    return this.books;
  }

  public List<Member> getMembers() {
    return this.members;
  }
}