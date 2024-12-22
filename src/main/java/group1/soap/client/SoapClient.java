package group1.soap.client;

import javax.xml.namespace.QName;
import java.net.URL;
import javax.xml.ws.Service;
import group1.soap.service.BookService;
import group1.soap.model.Book; // Import the Book class

public class SoapClient {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8080/webservice-assignment-1.0-SNAPSHOT/soap/books?wsdl");
            QName qname = new QName("http://soap.group1/", "BookServiceImplService");
            
            Service service = Service.create(url, qname);
            BookService bookService = service.getPort(BookService.class);
            
            // Test the getBooks method
            System.out.println("Books: " + bookService.getBooks());
            
            // Test the addBook method
            bookService.addBook(new Book("789", "New Book", "Author Name", 19.99));
            System.out.println("Books after adding a new book: " + bookService.getBooks());
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
