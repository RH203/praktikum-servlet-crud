<%@ page import="com.example.praktikumcrud.model.User" %><%--
  Created by IntelliJ IDEA.
  User: raiha
  Date: 19/05/2025
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>Edit Pengguna</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
  </head>
  <body>

    <%
      User user = (User) request.getAttribute("user");

      if (user.getAlamat() != null) {
    %>

    <form action="/edit-user" method="post" class="container">
      <h2>Edit Pengguna</h2>

      <div class="mb-3">
        <label for="name" class="form-label">Name</label>
        <input type="text" class="form-control" name="name" id="name" value="<%=user.getName()%>">
        <%--        <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>--%>
      </div>
      <div class="mb-3">
        <label for="email" class="form-label">Email</label>
        <input type="email" class="form-control" name="email" id="email" aria-describedby="emailHelp"
               value="<%=user.getEmail()%>">
        <%--        <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>--%>
      </div>

      <div class="mb-3">
        <label for="alamat" class="form-label">Alamat</label>
        <input type="text" class="form-control" name="alamat" id="alamat" value="<%=user.getAlamat()%>">
        <%--        <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>--%>
      </div>

      <div class="mb-3">
        <label for="noHp" class="form-label">No HP</label>
        <input type="text" class="form-control" name="noHp" id="noHp" value="<%=user.getNoHp()%>">
        <%--        <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>--%>
      </div>

      <div class="mb-3">
        <label for="nim" class="form-label">NIM</label>
        <input type="text" class="form-control" name="nim" id="nim" value="<%=user.getNim()%>">
        <%--        <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>--%>
      </div>
      <button type="submit" class="btn btn-primary">Submit</button>
      <a class="btn btn-danger" href="${pageContext.request.contextPath}/delete-user?id=<%=user.getId()%>">Delete</a>

    </form>

    <% } %>

    <% if (user.getAlamat() == null) {%>
    <div class="container">
      <div class="alert alert-warning">Data pengguna tidak ditemukan.</div>
    </div>
    <% } %>

    <%
      String status = (String) request.getAttribute("status");
      if (status != null) {
    %>

    <div class="container">
      <div class="alert alert-warning"><%=status%>
      </div>
    </div>
    <% }%>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO"
            crossorigin="anonymous"></script>
  </body>
</html>
