package com.rizqigo;

import java.io.File;
// import com.rizqigo.data.Basic;
import java.util.Arrays;
import java.util.List;

import com.rizqigo.data.Book;
import com.rizqigo.data.EBook;
import com.rizqigo.data.Library;
import com.rizqigo.data.ManipulationArray;
import com.rizqigo.data.Member;
import com.rizqigo.data.PrintedBook;
import com.rizqigo.data.Todo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * main class
 */
public class App {
  public static void main(String[] args) throws Exception {
    App app = new App();
    app.manipulationJson();
  }

  public void manipulationJson() throws Exception {
    ObjectMapper om = new ObjectMapper();

    Todo todo = new Todo("masak nasi", "memasak nasi");
    String json = om.writerWithDefaultPrettyPrinter()
        .writeValueAsString(todo);
    sout(json);

    Todo objTodo = om.readValue(
        new File("todo.json"), Todo.class);
    sout(objTodo.toString());

    List<Todo> objTodos = om.readValue(
        new File("todo2.json"),
        new TypeReference<List<Todo>>() {
        });
    objTodos.forEach(data -> sout(data.toString()));
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
    Book book1 = library.getBooks().get(1);
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
