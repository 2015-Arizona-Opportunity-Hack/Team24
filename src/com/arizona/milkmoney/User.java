package com.arizona.milkmoney;

public class User {

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
    }
}
