package com.example.praktikumcrud.users;

import com.example.praktikumcrud.database.DatabaseConnection;
import com.example.praktikumcrud.model.User;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "edit-user", value = "/edit-user")
public class EditUserServlet extends HttpServlet {

  private final DatabaseConnection databaseConnection = new DatabaseConnection();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
      String id = req.getParameter("id");

      if (id == null) {
        resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Id tidak ditemukan");
      }

      int parseId = Integer.parseInt(id);

      User user = databaseConnection.getUserById(parseId);
      req.setAttribute("user", user);
      req.getRequestDispatcher("users/edit-user.jsp").forward(req, resp);
    } catch (Exception e) {
      System.out.println("Error Edit user servlet get: " + e.getMessage());
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {

      String name = req.getParameter("name");
      String email = req.getParameter("email");
      String alamat = req.getParameter("alamat");
      String noHp = req.getParameter("noHp");
      String nim = req.getParameter("nim");



      User user = new User( name, email, alamat, noHp, nim);

      boolean update = databaseConnection.editUserById(user);



      if (update) {
        resp.sendRedirect("/list-user");
      } else {
        req.setAttribute("status", "Gagal update user");
        resp.sendRedirect("/list-user");
      }
    } catch (Exception e) {
      System.out.println("Error Edit user servlet post: " + e.getMessage());
    }
  }
}
