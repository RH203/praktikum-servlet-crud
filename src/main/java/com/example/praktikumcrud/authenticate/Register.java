package com.example.praktikumcrud.authenticate;


import com.example.praktikumcrud.database.DatabaseConnection;
import com.example.praktikumcrud.model.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import at.favre.lib.crypto.bcrypt.BCrypt;


import java.io.IOException;

@WebServlet(name = "register", value = "/register")
public class Register extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    try {
      String email = request.getParameter("email");
      String password = request.getParameter("password");

      // Hash password menggunakan BCrypt
      String hashedPassword = BCrypt.withDefaults()
        .hashToString(12, password.toCharArray());

      // Buat objek account
      Account account = new Account();
      account.setEmail(email);
      account.setPassword(hashedPassword);

      // Simpan ke database
      DatabaseConnection dao = new DatabaseConnection();
      boolean success = dao.registerUser(account);

      if (success) {
        response.sendRedirect("auth/login.jsp");
      } else {
        request.setAttribute("error", "Gagal mendaftar. Email mungkin sudah digunakan.");
        request.getRequestDispatcher("register.jsp").forward(request, response);
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      request.setAttribute("error", "Terjadi kesalahan server.");
      request.getRequestDispatcher("register.jsp").forward(request, response);
    }
  }
}