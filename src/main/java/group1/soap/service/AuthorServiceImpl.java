package group1.soap.service;

import group1.soap.model.Author;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebService(endpointInterface = "group1.soap.service.AuthorService", targetNamespace = "http://soap.group1/")
public class AuthorServiceImpl implements AuthorService {
    private List<Author> authors = new ArrayList<>();

    public AuthorServiceImpl() {
        // Initialize with some sample data
        authors.add(new Author("1", "Author One", "Biography One"));
        authors.add(new Author("2", "Author Two", "Biography Two"));
    }

    @Override
    public List<Author> getAuthors() {
        return authors;
    }

    @Override
    public void addAuthor(Author author) {
        authors.add(author);
    }

    @Override
    public Author getAuthorById(String id) {
        return authors.stream().filter(author -> author.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void updateAuthor(Author author) {
        authors = authors.stream().map(a -> {
            if (a.getId().equals(author.getId())) {
                return author;
            }
            return a;
        }).collect(Collectors.toList());
    }

    @Override
    public void deleteAuthor(String id) {
        authors = authors.stream().filter(author -> !author.getId().equals(id)).collect(Collectors.toList());
    }
}
