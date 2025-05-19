package com.example.praktikumcrud.users;

import com.example.praktikumcrud.database.DatabaseConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "delete-user", value = "/delete-user")
public class DeleteUserServlet extends HttpServlet {
  private final DatabaseConnection databaseConnection = new DatabaseConnection();
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
      String id = req.getParameter("id");
      int parseId = Integer.parseInt(id);

      boolean delete = databaseConnection.deleteUserById(parseId);

      if(delete) {
        resp.sendRedirect("/list-user");
      }
    } catch (Exception e) {
      System.out.println("Error while deleting user: " + e.getMessage());
    }
  }
}
