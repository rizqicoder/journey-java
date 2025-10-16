package com.rizqigo;

// import com.rizqigo.data.Basic;
import java.util.Arrays;

import com.rizqigo.data.Book;
import com.rizqigo.data.EBook;
import com.rizqigo.data.Library;
import com.rizqigo.data.ManipulationArray;
import com.rizqigo.data.Member;
import com.rizqigo.data.PrintedBook;

/**
 * main class
 */
public class App {
  public static void main(String[] args) {
    App app = new App();
    app.mainLibrary();
  }

  public void mainManipulationArray() {
    String[] country = { "indonesian", "malaysia", "singapore", "japan" };
    ManipulationArray<String> ma = new ManipulationArray<>(country);
    sout(Arrays.toString(ma.append(2, "australia".toUpperCase())));
    sout(Arrays.toString(ma.update(2, "japan".toLowerCase())));
    sout(Arrays.toString(ma.remove(2)));
  }

  public void mainLibrary() {
    Library library = Library.getInstance();

    // adding book to library
    library.addBook(new EBook("sprited away", "kuromi", 3.2));
    library.addBook(new PrintedBook("the secret world of arrietty", "studio ghibli", 344));

    // adding member subscription library
    Member joko = new Member("joko");
    Member moro = new Member("moro");
    library.addMember(joko);
    library.addMember(moro);

    // show all books
    library.showAllBooks();

    // show all members library
    library.showAllMembers();

    // joko meminjam buku
    Book book1 = library.getBooks().get(0);
    joko.borrowBook(book1, library);

    // member lain mencoba meminjam buku yang sama dengan joko
    moro.borrowBook(book1, library);

    // daftar buku pinjaman joko
    joko.showBorrowedBooks();

    // joko mengembalikan buku yang dipinjam
    library.showAllBooks();
    joko.returnBook(book1, library);

    // lihat daftar buku setelah pengembalian pinjaman joko
    library.showAllBooks();
    System.exit(0);
  }

  public static void sout(String message) {
    System.out.println(message);
  }
}
