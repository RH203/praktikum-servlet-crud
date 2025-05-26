<%@ page import="com.example.praktikumcrud.model.Account" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
  String email = null;
  try {
    Account user = (session != null) ? (Account) session.getAttribute("user") : null;
    email = "";

    if (user == null) {
      System.out.println("Session tidak ditemukan");
      response.sendRedirect("auth/login.jsp");
      return;
    } else {
      email = user.getEmail();
//      out.println("User found: " + user.getEmail());
    }
  } catch (Exception e) {
    System.out.println(e.getMessage());
  }
%>
<!DOCTYPE html>
<html>
  <head>
    <title>CRUD - User Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
  </head>
  <body>
    <div class="container">

      <ul class="nav nav-tabs">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/list-user">List User</a>
        </li>
        <li class="nav-item ms-auto">
          <span class="nav-link disabled">👤 <%=email%></span>
        </li>
        <li class="nav-item">
          <a class="nav-link text-danger" href="/logout">Logout</a>
        </li>
        <%--        <li class="nav-item">--%>
        <%--          <a class="nav-link" href="#">Add User</a>--%>
        <%--        </li>--%>
        <%--        <li class="nav-item">--%>
        <%--          <a class="nav-link" href="#">Delete</a>--%>
        <%--        </li>--%>
        <%--        <li class="nav-item">--%>
        <%--          <a class="nav-link disabled" aria-disabled="true">Disabled</a>--%>
        <%--        </li>--%>
      </ul>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO"
            crossorigin="anonymous"></script>
  </body>
</html>