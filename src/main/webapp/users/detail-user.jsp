<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.praktikumcrud.model.User" %>
<%@ page import="com.example.praktikumcrud.model.Account" %>
<%
  try {
    Account user = (session != null) ? (Account) session.getAttribute("user") : null;

    if (user == null) {
      response.sendRedirect("auth/login.jsp");
      return;
    }
  } catch (Exception e) {
    System.out.println(e.getMessage());
  }
%>
<html>
  <head>
    <title>Detail User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
  </head>
  <body>
    <div class="container mt-4">
      <h2>Detail Pengguna</h2>
      <%
        User u = (User) request.getAttribute("user");
        if (u != null) {
      %>
      <table class="table table-striped">
        <tbody>
          <tr>
            <th>Nama</th>
            <td><%= u.getName() %>
            </td>
          </tr>
          <tr>
            <th>Email</th>
            <td><%= u.getEmail() %>
            </td>
          </tr>
          <tr>
            <th>Alamat</th>
            <td><%= u.getAlamat() %>
            </td>
          </tr>
          <tr>
            <th>No HP</th>
            <td><%= u.getNoHp() %>
            </td>
          </tr>
          <tr>
            <th>NIM</th>
            <td><%= u.getNim() %>
            </td>
          </tr>
        </tbody>
      </table>
<%--      <a class="btn btn-primary" href="/edit-user?id=<%= u.getId() %>">Edit</a>--%>
      <a class="btn btn-primary" href="/edit-user?id=<%=u.getId()%>">Edit</a>
      <% } else { %>
      <div class="alert alert-warning">Data pengguna tidak ditemukan.</div>
      <% } %>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO"
            crossorigin="anonymous"></script>
  </body>
</html>
