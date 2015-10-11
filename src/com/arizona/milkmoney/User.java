package com.arizona.milkmoney;

public class User {

<<<<<<< HEAD
    String name, lname, username, password, phone, email;
    String don, vol;
  
    
    public User(String fname, String lname, String username, String password, String email, String phone, String don, String vol) {
        this.name = fname;
        this.lname = lname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.don = don;
        this.vol = vol;
    }

    public User(String username, String password) {
        this("", "", username, password, "", "", "", "");
=======
    String name, username, password;
    int age;

    public User(String name, int age, String username, String password) {
        this.name = name;
        this.age = age;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password) {
        this("", -1, username, password);
>>>>>>> 268d4b0bc35999f8ebacf749c94c360a93d0696c
    }
}
