# Tomcat Example
One thing I've noticed when people talk about building REST APIs in Java is that many lack a deeper understanding of how things actually work under the hood. That's why I decided to study a bit more about the Java architecture and its HTTP protocol implementations.

How Does HTTP Work?
The HTTP protocol is essentially a set of rules built on top of TCP. In simple terms, for a TCP socket to serve as an HTTP request, it needs to bind to a port (which acts as the server), emit a "data" event (sending the request), wait for a response, and finally close the connection.

Of course, HTTP is more complex than that, but this is enough to understand the basic idea: an HTTP server is just an application that intercepts TCP packets, parses them according to the HTTP specification, and handles them accordingly.

## How Is Java Different?
Unlike some other languages, Java doesn’t come with a fully built-in HTTP server. Instead, it provides a standard interface, known as the Jakarta Servlet API (previously Java EE). Java defines a set of interfaces and contracts that HTTP server implementations are expected to follow. Because of this, we have multiple servlet container implementations, such as Tomcat, Jetty, Undertow, and others — each providing their own HTTP stack but following the same standard interface.

### What Is a Servlet?
So, what exactly is a Servlet? A Servlet is a Java interface that HTTP servers (like Tomcat) use to delegate HTTP requests. It defines how a request should be handled and how a response should be constructed.

How this delegation is managed can vary. For example, Spring Framework builds on top of the Servlet API and adds its own powerful mechanisms — such as IoC (Inversion of Control) and dependency injection — to wire everything together using Spring-managed beans. This makes the architecture far more flexible and maintainable compared to handling everything manually.

# This project
This repository stores a simple example of how to use one of those http servers, the tomcat. There are many ways to use tomcat, this time i used it as an embedded dependency, which has its advantanges and disvantanges(bloat jar...), but for a learning purpose project it is good enough.

## How to use this project?
First of all, you have to clone this repository:
```
git clone http://github.com/tosuki/tomcat-embedded-server-example ./
cd tomcat-embedded-server-example
gradle run
```
After you follow those steps, the server should be running on http://localhost:8080
