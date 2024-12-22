package group1.soap.service;

import group1.soap.model.Book;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(targetNamespace = "http://soap.group1/")
public interface BookService {
    @WebMethod
    List<Book> getBooks();

    @WebMethod
    Book addBook(Book book);

    @WebMethod
    Book getBookByIsbn(@WebParam(name = "isbn") String isbn);

    @WebMethod
    Book updateBook(Book book);

    @WebMethod
    String deleteBook(@WebParam(name = "isbn") String isbn);
}
