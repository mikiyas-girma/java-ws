package group1.soap.service;

import group1.soap.model.Author;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(targetNamespace = "http://soap.group1/")
public interface AuthorService {
    @WebMethod
    List<Author> getAuthors();

    @WebMethod
    void addAuthor(Author author);

    @WebMethod
    Author getAuthorById(String id);

    @WebMethod
    void updateAuthor(Author author);

    @WebMethod
    void deleteAuthor(String id);
}
