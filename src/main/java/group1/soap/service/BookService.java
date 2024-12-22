package group1.soap.service;

import group1.soap.model.Book;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(targetNamespace = "http://soap.group1/")
public interface BookService {
    @WebMethod
    List<Book> getBooks();

    @WebMethod
    void addBook(Book book);
}
