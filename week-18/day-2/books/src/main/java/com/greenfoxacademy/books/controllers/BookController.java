package com.greenfoxacademy.books.controllers;

import com.greenfoxacademy.books.models.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class BookController {
  private ArrayList<Book> library;

  public BookController() {
    library = new ArrayList<>();
    library.add(new Book("Bogyó és Babóca", "Bartos Erika", 2014));
    library.add(new Book("Brúnó Budapesten", "Bartos Erika", 2017));
    library.add(new Book("Tündér biciklin", "Berg Judit", 2016));
  }

  @GetMapping("/books")
  public String renderAllBooks(Model model){
    model.addAttribute("books", library);
    return "books";
  }

  @GetMapping("/books/{id}/details")
  public String showdetailsOfOneBook(Model model, @PathVariable(name = "id") int id){
    Book bookByID = null;
    for (Book book : library) {
      if (book.getId() == id) {
        bookByID = book;
      }
    }

    if (bookByID != null) {
      model.addAttribute("book", bookByID);
    } else {
      model.addAttribute("error", "There is no ID in the library.");
    }
    return "details";
  }

  @GetMapping("/books2")
  public String showBooksByAuthor(Model model, @RequestParam(name = "author", required = false) String author){
    if (author == null) {
      model.addAttribute("books", library);
    } else {
      model.addAttribute("books", filterBooks(author));
    }
    return "books";
  }

  @GetMapping("/books/add")
  public String addNewBook() {
    return "create";
  }

  @PostMapping("books/add")
  public String createNewBook(@ModelAttribute Book book) {
    library.add(book);
    return "redirect:/books";
  }

  public ArrayList<Book> filterBooks (String author) {
    ArrayList<Book> filteredBooks = new ArrayList<>();
    for (Book book : library) {
      if (book.getAuthor().equals(author)) {
        filteredBooks.add(book);
      }
    }
    return filteredBooks;
  }
}
