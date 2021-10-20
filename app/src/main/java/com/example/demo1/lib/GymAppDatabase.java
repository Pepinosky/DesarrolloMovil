package com.example.demo1.lib;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.demo1.dao.EvaluationDao;
import com.example.demo1.dao.UserDao;
import com.example.demo1.models.EvaluationEntity;
import com.example.demo1.models.UserEntity;
import com.example.demo1.utils.Converters;

@Database(entities = {UserEntity.class, EvaluationEntity.class}, version = 3)
@TypeConverters({Converters.class})
public abstract class GymAppDatabase extends RoomDatabase {
    private  static final String DB_NAME = "gym_app_db";
    private static  GymAppDatabase instance;

    public static synchronized GymAppDatabase getInstance(Context ctx){
        if(instance == null){
            instance = Room.databaseBuilder(ctx.getApplicationContext(), GymAppDatabase.class, DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public abstract UserDao userDao();
    public abstract EvaluationDao evaluationDao();

}
