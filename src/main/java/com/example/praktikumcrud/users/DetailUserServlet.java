package com.example.praktikumcrud.users;

import com.example.praktikumcrud.database.DatabaseConnection;
import com.example.praktikumcrud.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "detail-user", value = "/detail-user")
public class DetailUserServlet extends HttpServlet {
  private final DatabaseConnection databaseConnection = new DatabaseConnection();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
      String idParam = req.getParameter("id");
      System.out.println("idParam: " + idParam);
      if (idParam == null) {
        resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing user id");
        return;
      }

      int id = Integer.parseInt(idParam);

      User user = databaseConnection.getUserById(id);

      if (user == null) {
        resp.sendError(HttpServletResponse.SC_NOT_FOUND, "User not found");
        return;
      }

      req.setAttribute("user", user);
      req.getRequestDispatcher("/users/detail-user.jsp").forward(req, resp);

    } catch (NumberFormatException e) {
      resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid user id");
    } catch (Exception e) {
      e.printStackTrace();
      resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Server error");
    }
  }
}
