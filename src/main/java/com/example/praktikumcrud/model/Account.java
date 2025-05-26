package com.example.praktikumcrud.model;

public class Account {
  private int id;
  private String email, password;


  public Account(String email, String password) {
    this.email = email;
    this.password = password;
  }

  public Account(int id, String email) {
    this.id = id;
    this.email = email;
  }

  public Account(int id, String email, String password) {
    this.id = id;
    this.email = email;
    this.password = password;
  }

  public Account() {

  }


  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmail() {
    return email;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
