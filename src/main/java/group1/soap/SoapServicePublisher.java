package group1.soap;

import group1.soap.service.BookServiceImpl;
import javax.xml.ws.Endpoint;

public class SoapServicePublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/soap/books", new BookServiceImpl());
        System.out.println("SOAP Web Service is published at http://localhost:8080/soap/books?wsdl");
    }
}
