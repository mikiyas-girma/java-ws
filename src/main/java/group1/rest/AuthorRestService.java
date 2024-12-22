package group1.rest;

import group1.soap.model.Author;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("/authors")
public class AuthorRestService {
    private static List<Author> authors = new ArrayList<>();

    static {
        authors.add(new Author("1", "Author One", "Biography One"));
        authors.add(new Author("2", "Author Two", "Biography Two"));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Author> getAuthors() {
        return authors;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Author getAuthor(@PathParam("id") String id) {
        return authors.stream().filter(author -> author.getId().equals(id)).findFirst().orElse(null);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAuthor(Author author) {
        authors.add(author);
        return Response.status(Response.Status.CREATED).entity(author).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateAuthor(@PathParam("id") String id, Author updatedAuthor) {
        authors = authors.stream().map(a -> {
            if (a.getId().equals(id)) {
                return updatedAuthor;
            }
            return a;
        }).collect(Collectors.toList());
        return Response.ok(updatedAuthor).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAuthor(@PathParam("id") String id) {
        authors = authors.stream().filter(author -> !author.getId().equals(id)).collect(Collectors.toList());
        return Response.noContent().build();
    }
}
