package com.example.praktikumcrud.database;

import com.example.praktikumcrud.model.Account;
import com.example.praktikumcrud.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {
  private String jdbcUrl = "jdbc:mysql://localhost:3306/praktikum-crud-pbo";
  private String user = "root";
  private String password = "";

  private Connection getConnection() throws SQLException {
    return DriverManager.getConnection(jdbcUrl, user, password);
  }

  // Method get all list user
  public List<User> getAllUser() throws SQLException {
    try {
      System.out.println("getAllUser berjalan");
      List<User> users = new ArrayList<User>();
      Class.forName("com.mysql.cj.jdbc.Driver");

      String query = "select * from users";

      Connection conn = getConnection();

      Statement stmt = conn.createStatement();

      ResultSet rs = stmt.executeQuery(query);

      while (rs.next()) {
        int id = Integer.parseInt(rs.getString("id"));
        String name = rs.getString("name");
        String email = rs.getString("email");
        String alamat = rs.getString("alamat");
        String no_hp = rs.getString("no_hp");
        String nim = rs.getString("nim");

        users.add(new User(id, name, email, alamat, no_hp, nim));
      }

      return users;
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return null;
  }

  // Method get user by id
  public User getUserById(int id) throws SQLException {
    try {
      User user = new User();
      String parseStringId = String.valueOf(id);

      String query = "select * from users where id = (?) ";

      Connection conn = getConnection();

      PreparedStatement stmt = conn.prepareStatement(query);

      stmt.setString(1, parseStringId);

      ResultSet rs = stmt.executeQuery();

      if (rs.next()) {
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        user.setAlamat(rs.getString("alamat"));
        user.setNim(rs.getString("nim"));
        user.setNoHp(rs.getString("no_hp"));
      }


      return user;
    } catch (Exception e) {
      System.out.println("Error getUserById: " + e.getMessage());
    }
    return null;
  }
  // Method add new user

  // Method edit user
  public boolean editUserById(User user) throws SQLException {
    try {

      String query = "update users set name = (?), email = (?), alamat = (?), no_hp = (?), nim = (?) where email = (?)";
      Connection conn = getConnection();
      PreparedStatement stmt = conn.prepareStatement(query);
      stmt.setString(1, user.getName());
      stmt.setString(2, user.getEmail());
      stmt.setString(3, user.getAlamat());
      stmt.setString(4, user.getNoHp());
      stmt.setString(5, user.getNim());
      stmt.setString(6, user.getEmail());

      int affectedRows = stmt.executeUpdate();
      return affectedRows > 0;

    } catch (Exception e) {
      System.out.println("Error editUserById: " + e.getMessage());
    }
    return false;
  }

  // Method delete user
  public boolean deleteUserById(int id) throws SQLException {
    try {
      String query = "delete from users where id = (?)";

      Connection conn = getConnection();
      PreparedStatement stmt = conn.prepareStatement(query);

      stmt.setInt(1, id);

      stmt.executeUpdate();


      return true;
    } catch (Exception e) {
      System.out.println("Error deleteUserById: " + e.getMessage());
    }
    return false;
  }

  public boolean registerUser(Account account) throws SQLException {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection conn = getConnection();
      PreparedStatement ps = conn.prepareStatement("INSERT INTO account (email, password) VALUES (?, ?)");
      ps.setString(1, account.getEmail());
      ps.setString(2, account.getPassword());
      ps.executeUpdate();

      return true;
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      return false;
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  public Account loginUser(String email) throws SQLException {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection conn = getConnection();
      PreparedStatement ps = conn.prepareStatement("select * from account where email = ?");
      ps.setString(1, email);
      ResultSet rs = ps.executeQuery();
      Account accountUser = null;
      if (rs.next()) {
        int id = Integer.parseInt(rs.getString("id"));
        String emailUser = rs.getString("email");
        String password = rs.getString("password");
        accountUser = new Account(id, emailUser, password);
      }

      return accountUser;

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
    return null;
  }
}
