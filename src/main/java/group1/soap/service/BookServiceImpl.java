package group1.soap.service;

import group1.soap.model.Book;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "group1.soap.service.BookService", targetNamespace = "http://soap.group1/")
public class BookServiceImpl implements BookService {
  private List<Book> books = new ArrayList<>();

  public BookServiceImpl() {
    // Initialize with some sample data
    books.add(new Book("123", "Book One", "Author One", 10.99));
    books.add(new Book("456", "Book Two", "Author Two", 12.99));
  }

  @Override
  public List<Book> getBooks() {
    return books;
  }

  @Override
  public Book addBook(Book book) {
    books.add(book);
    return book;
  }

  @Override
  public Book getBookByIsbn(String isbn) {
    Book book = books.stream().filter(b -> b.getIsbn().equals(isbn)).findFirst().orElse(null);
    System.out.println("Requested ISBN: " + isbn);
    System.out.println("Found Book: " + book);
    return book;
  }

  @Override
  public Book updateBook(Book updatedBook) {
    for (int i = 0; i < books.size(); i++) {
      if (books.get(i).getIsbn().equals(updatedBook.getIsbn())) {
        books.set(i, updatedBook);
        return updatedBook;
      }
    }
    return updatedBook;
  }

  @Override
  public String deleteBook(String isbn) {
    boolean removed = books.removeIf(book -> book.getIsbn().equals(isbn));
    if (removed) {
      return "Book with ISBN " + isbn + " was deleted.";
    } else {
      return "Book with ISBN " + isbn + " was not found.";
    }
  }
}
