package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String name = request.getParameter("name-input");
    String color = request.getParameter("color-input");
    String description = request.getParameter("description-input");

    // // Print the input so you can see it in the server logs.
    System.out.println("name: " + name);
    System.out.println("color: " + color);
    System.out.println("description: " + description);

    // Write the input to the response so the user can see it.
    response.setContentType("text/html;");
    response.getWriter().println("<p>Name: " + name + "</p>");
    response.getWriter().println("<p>Color: " + color + "</p>");
    response.getWriter().println("<p>Description: " + description + "</p>");
  }
}