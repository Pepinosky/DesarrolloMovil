package com.example.demo1.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "users", indices = {@Index(value= "nickname", unique = true)})
public class UserEntity implements IUser {
    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "nickname")
    private String nickName;

    @ColumnInfo(name = "first_name")
    private String firstName;

    @ColumnInfo(name = "last_name")
    private String lastName;

    @ColumnInfo(name = "height")
    private double height;

    @ColumnInfo(name = "birthday")
    private Date birthday;

    @ColumnInfo(name = "password")
    private String password;


    public UserEntity(long id, String nickName, String firstName, String lastName, double height, Date birthday, String password) {
        this.id = id;
        this.nickName = nickName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.height = height;
        this.birthday = birthday;
        this.password = password;
    }

    public long getId() {
        return id;
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


}