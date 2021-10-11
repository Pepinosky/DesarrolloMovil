package com.example.demo1.models;
import java.util.Date;

public class User {
    private long id;
    private String nickName;
    private String firstName;
    private String lastName;
    private double height;
    private Date birthday;
    private String password;

    public User(String nickName, String firstName, String lastName, double height, Date birthday) {
        this.nickName= nickName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.height = height;
        this.birthday = birthday;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getHeight() {
        return height;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
