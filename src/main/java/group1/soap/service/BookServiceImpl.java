package group1.soap.service;

import group1.soap.model.Book;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        return books.stream().filter(book -> book.getIsbn().equals(isbn)).findFirst().orElse(null);
    }

    @Override
    public void updateBook(Book book) {
        books = books.stream().map(b -> {
            if (b.getIsbn().equals(book.getIsbn())) {
                return book;
            }
            return b;
        }).collect(Collectors.toList());
    }

    @Override
    public void deleteBook(String isbn) {
        books = books.stream().filter(book -> !book.getIsbn().equals(isbn)).collect(Collectors.toList());
    }
}
