# Webservice Assignment

This project is a Java-based web service application that includes both SOAP and RESTful web services. The project is built using Maven and can be deployed on an Apache Tomcat server.

## Project Structure

.
├── README.md
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── webservice
    │   │           ├── rest
    │   │           │   ├── RestService.java
    │   │           │   └── RestServicePublisher.java
    │   │           └── soap
    │   │               ├── SoapService.java
    │   │               └── SoapServicePublisher.java
    │   └── webapp
    │       └── WEB-INF
    │           └── web.xml
    └── test
        └── java
            └── com
                └── webservice
                    ├── rest
                    │   └── RestServiceTest.java
                    └── soap
                        └── SoapServiceTest.java


## Prerequisites

- Java 11
- Maven 3.6+
- Apache Tomcat 9

## Building the Project

To build the project, run the following Maven commands:

```bash
mvn clean install
```

This will compile the source code, run the tests, and package the application into a WAR file located in the target directory.

Deploying the Application
To deploy the application to Apache Tomcat, copy the generated WAR file to the Tomcat webapps directory:

```bash
sudo cp target/webservice-assignment-1.0-SNAPSHOT.war /var/lib/tomcat9/webapps/
```

Restart Tomcat to deploy the application:

```bash
sudo systemctl restart tomcat
```

## Accessing the Web Services

The SOAP web service can be accessed at the following URL:

```bash
http://localhost:8080/webservice-assignment-1.0-SNAPSHOT/soap/books?wsdl
```

The RESTful web service can be accessed at the following URL:

```bash
http://localhost:8080/webservice-assignment-1.0-SNAPSHOT/rest/books
```

## Example SOAP Request

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ws="http://webservice.com/">
   <soapenv:Header/>
   <soapenv:Body>
      <ws:getBookRequest>
         <ws:id>1</ws:id>
      </ws:getBookRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

## Example REST Request

```bash
curl http://localhost:8080/webservice-assignment-1.0-SNAPSHOT/rest/books/1
```


## Project Files

### pom.xml
The Maven project configuration file that defines the project dependencies and build settings. Key dependencies include:
- JAX-RS (Jersey) for RESTful web services
- JAX-WS (Metro) for SOAP web services
- Jetty for embedded server support

### web.xml
The `web.xml` file configures the servlets and listeners for the web application. It includes configurations for both Jersey and JAX-WS.

### sun-jaxws.xml
The `sun-jaxws.xml` file configures the JAX-WS endpoints for the SOAP web service.

### BookService.java
Defines the SOAP web service interface.

### BookServiceImpl.java
Implements the SOAP web service.

### Book.java
Defines the model class for the web service.

### SoapServicePublisher.java
Publishes the SOAP web service.

### CORSFilter.java
Implements a CORS filter to handle cross-origin requests.

### index.jsp
A simple JSP file that serves as the home page of the web service application.

## Screenshots
Include screenshots of the following to demonstrate successful deployment:
- Tomcat Manager showing the deployed application.
- Browser showing the WSDL for the SOAP web service.
- Postman showing successful requests and responses for the SOAP web service.
- Postman showing successful requests and responses for the REST web service.

## Conclusion
This project demonstrates how to implement and deploy a simple web service in a Java environment using both SOAP and RESTful web services.

