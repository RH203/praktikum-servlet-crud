package com.example.praktikumcrud.authenticate;


import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.praktikumcrud.database.DatabaseConnection;
import com.example.praktikumcrud.model.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "Login", value = "/login")
public class Login extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    try {
      String email = request.getParameter("email");
      String password = request.getParameter("password");


      DatabaseConnection dao = new DatabaseConnection();
      Account user = dao.loginUser(email);

      if (user != null) {
        // verifikasi password
        BCrypt.Result result = BCrypt.verifyer()
          .verify(password.toCharArray(), user.getPassword());

        if (result.verified) {
          // password cocok → simpan ke session
          HttpSession session = request.getSession();
          session.setAttribute("user", user);

          response.sendRedirect("index.jsp");
          return;
        }
      }

      // jika gagal login
      request.setAttribute("error", "Email atau password salah.");
      request.getRequestDispatcher("auth/login.jsp").forward(request, response);

    } catch (Exception e) {
      System.out.println(e.getMessage());
      request.setAttribute("error", "Terjadi kesalahan server.");
      request.getRequestDispatcher("auth/login.jsp").forward(request, response);
    }
  }
}