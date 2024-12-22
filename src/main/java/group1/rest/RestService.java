package group1.rest;

import group1.soap.model.Book;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("/books")
public class RestService {
    private static List<Book> books = new ArrayList<>();

    static {
        books.add(new Book("123", "Book One", "Author One", 10.99));
        books.add(new Book("456", "Book Two", "Author Two", 12.99));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getBooks() {
        return books;
    }

    @GET
    @Path("/{isbn}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book getBook(@PathParam("isbn") String isbn) {
        return books.stream().filter(book -> book.getIsbn().equals(isbn)).findFirst().orElse(null);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addBook(Book book) {
        books.add(book);
        return Response.status(Response.Status.CREATED).entity(book).build();
    }

    @PUT
    @Path("/{isbn}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateBook(@PathParam("isbn") String isbn, Book updatedBook) {
        books = books.stream().map(b -> {
            if (b.getIsbn().equals(isbn)) {
                return updatedBook;
            }
            return b;
        }).collect(Collectors.toList());
        return Response.ok(updatedBook).build();
    }

  @DELETE
  @Path("/{isbn}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response deleteBook(@PathParam("isbn") String isbn) {
      boolean bookExists = books.stream().anyMatch(book -> book.getIsbn().equals(isbn));
      if (bookExists) {
          books = books.stream().filter(book -> !book.getIsbn().equals(isbn)).collect(Collectors.toList());
          return Response.ok("{\"message\":\"Book deleted successfully.\"}").build();
      } else {
          return Response.status(Response.Status.NOT_FOUND)
                        .entity("{\"message\":\"Book not found.\"}")
                        .build();
      }
  }
}
