package com.example.demo1.models;

import java.util.Date;

public interface IUser {
    long getId();
    String getNickName();
    String getFirstName();
    String getLastName();
    double getHeight();
    Date getBirthday();
    String getPassword();

}
