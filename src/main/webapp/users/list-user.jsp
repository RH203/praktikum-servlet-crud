<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.praktikumcrud.model.User" %>
<html>
  <head>
    <title>List User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
  </head>
  <body>
    <div class="container mt-4">
      <h2>Daftar Pengguna</h2>
      <table class="table table-striped">
        <thead>
          <tr>
            <th scope="col">No.</th>
            <th scope="col">Name</th>
            <th scope="col">Email</th>
            <th scope="col">Alamat</th>
            <th scope="col">No HP</th>
            <th scope="col">NIM</th>
            <th scope="col">Edit</th>
          </tr>
        </thead>
        <tbody>
          <%
            List<User> userList = (List<User>) request.getAttribute("user");
            if (userList != null && !userList.isEmpty()) {
              for (int i = 0; i < userList.size(); i++) {
                User u = userList.get(i);
          %>
          <tr>
            <th scope="row"><%= i + 1 %>
            </th>
            <td><%= u.getName() %>
            </td>
            <td><%= u.getEmail() %>
            </td>
            <td><%= u.getAlamat() %>
            </td>
            <td><%= u.getNoHp() %>
            </td>
            <td><%= u.getNim() %>
            </td>
            <td>
              <a class="btn btn-primary" href="/detail-user?id=<%= u.getId() %>">Edit</a>
            </td>
          </tr>
          <%
            }
          } else {
          %>
          <tr>
            <td colspan="6" class="text-center">Tidak ada data pengguna.</td>
          </tr>
          <%
            }
          %>
        </tbody>
      </table>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO"
            crossorigin="anonymous"></script>
  </body>
</html>
