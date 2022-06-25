package com.google.sps.servlets;

import java.io.IOException;
import java.lang.module.ResolutionException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redirect")
public class Redirect extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String add = request.getParameter("address");

    // // Print the input so you can see it in the server logs.
    System.out.println("address: " + add);

    // Write the input to the response so the user can see it.
    response.setContentType("text/html;");
    response.sendRedirect("https://"+add);
  }
}