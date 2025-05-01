package com.tosuki;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HttpServletImpl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain");

        PrintWriter writer = response.getWriter();

        writer.write("test");
        writer.flush();
        writer.close();
    }
}
