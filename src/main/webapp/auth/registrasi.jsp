<%--
  Created by IntelliJ IDEA.
  User: raiha
  Date: 25/05/2025
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Registrasi</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body class="bg-light">
    <div class="container mt-5">
      <div class="row justify-content-center">
        <div class="col-md-4">
          <h3 class="text-center mb-4">Registrasi</h3>
          <% if (request.getAttribute("error") != null) { %>
          <div class="alert alert-danger">
            <%= request.getAttribute("error") %>
          </div>
          <% } %>
          <form method="post" action="${pageContext.request.contextPath}/register">
            <div class="mb-3">
              <label for="email" class="form-label">Email</label>
              <input type="email" name="email" id="email" class="form-control" required>
            </div>
            <div class="mb-3">
              <label for="password" class="form-label">Password</label>
              <input type="password" name="password" id="password" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-success w-100">Daftar</button>
            <div class="mt-3 text-center">
              Sudah punya akun? <a href="login.jsp">Login</a>
            </div>
          </form>
        </div>
      </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
  </body>
</html>
