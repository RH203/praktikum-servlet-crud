package com.example.praktikumcrud.users;

import com.example.praktikumcrud.database.DatabaseConnection;
import com.example.praktikumcrud.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "list-user", value = "/list-user")
public class GetUserServlet extends HttpServlet {
  private final DatabaseConnection databaseConnection = new DatabaseConnection();




  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
//      System.out.println("doGet berjalan");
      List<User> users = databaseConnection.getAllUser();
      req.setAttribute("user", users);
      req.getRequestDispatcher("users/list-user.jsp").forward(req, resp);
//      System.out.println("doGet berakhir");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
