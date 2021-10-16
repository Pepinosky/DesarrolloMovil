package com.example.demo1.dao;


import androidx.room.Dao;
import androidx.room.Index;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.demo1.models.UserEntity;

@Dao
public interface UserDao {
    @Query("SELECT id, nickname, first_name, last_name, height, birthday, password FROM users WHERE nickname = :nickName LIMIT 1")
    UserEntity findByNickName (String nickName);

    @Insert
    long insert(UserEntity user);
}
