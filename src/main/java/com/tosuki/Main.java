package com.tosuki;

public class Main {
    public static void main(String[] args) {
        HttpServer server = new HttpServer();

        try {
            server.start(8080, "localhost");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
