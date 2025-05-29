# 🐱‍💻 Tomcat Embedded Example

One thing I've noticed when people talk about building REST APIs in Java is that many lack a deeper understanding of how things actually work under the hood.  
That's why I decided to dive deeper into **Java architecture** and its **HTTP protocol** implementations.

---

## 🌐 How Does HTTP Work?

The **HTTP protocol** is essentially a set of rules built on top of **TCP**.

In simple terms:
1. A **TCP socket** binds to a port (acting as the server).
2. It emits a `"data"` event (sending the request).
3. Waits for a response.
4. Closes the connection.

🔍 Of course, HTTP is much more complex, but this gives the basic idea:  
An **HTTP server** is just an application that **intercepts TCP packets**, parses them according to the HTTP specification, and handles them accordingly.

---

## ☕ How Is Java Different?

Unlike some languages, **Java doesn’t ship with a built-in HTTP server**.  
Instead, it provides a **standard interface**: the **Jakarta Servlet API** (previously part of Java EE).

🧩 This API defines a set of **interfaces and contracts** that HTTP server implementations follow — such as:

- Apache **Tomcat**
- **Jetty**
- **Undertow**
- And others

These implementations provide their own HTTP stack but **conform to the same interface**, making them interchangeable.

---

### 📦 What Is a Servlet?

A **Servlet** is a Java interface used by HTTP servers (like Tomcat) to **delegate and handle HTTP requests**.  
It defines:
- How requests are processed
- How responses are constructed

Frameworks like **Spring** build on top of the Servlet API and introduce features like:

- 🧠 **IoC (Inversion of Control)**
- 🔌 **Dependency Injection**
- 🧱 **Component-based wiring**

This makes development **more maintainable and flexible**, compared to managing everything manually.

---

## 📁 About This Project

This repository contains a **minimal example** of using an HTTP server in Java: **Apache Tomcat**, used here as an **embedded dependency**.

🛠️ **Why embedded?**
- ✅ Great for learning and prototyping
- ⚠️ Can lead to **larger JAR files**
- 🚫 Not ideal for production without consideration

---

## 🚀 How to Run This Project

1. 🧬 Clone the repository:
```bash
git clone http://github.com/tosuki/tomcat-embedded-server-example ./
cd tomcat-embedded-server-example
gradle run
```
🌍 Access the server at and check your terminal:
http://localhost:8080
