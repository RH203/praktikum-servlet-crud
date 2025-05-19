package com.example.praktikumcrud.model;

public class User {

  private String name, email, alamat, no_hp, nim;
  private int id;

  public User() {
  }

  ;

  public User(int id, String name, String email, String alamat, String no_hp, String nim) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.alamat = alamat;
    this.no_hp = no_hp;
    this.nim = nim;
  }

  public User( String name, String email, String alamat, String no_hp, String nim) {
    this.name = name;
    this.email = email;
    this.alamat = alamat;
    this.no_hp = no_hp;
    this.nim = nim;
  }


  public int getId() {
    return id;
  }


  public String getNim() {
    return nim;
  }

  public String getName() {
    return name;
  }

  public String getAlamat() {
    return alamat;
  }

  public String getEmail() {
    return email;
  }

  public String getNoHp() {
    return no_hp;
  }

  public void setNim(String nim) {
    this.nim = nim;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setAlamat(String alamat) {
    this.alamat = alamat;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setNoHp(String no_hp) {
    this.no_hp = no_hp;
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
