package com.example.demo1.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.demo1.models.EvaluationEntity;
import com.example.demo1.models.UserEntity;

import java.util.List;

@Dao
public interface EvaluationDao {
    @Query("SELECT id, imc, weight, date FROM evaluations ")
    List<EvaluationEntity> findAll ();

    @Insert
    long insert(EvaluationEntity evaluation);

    @Query("DELETE FROM evaluations WHERE id= :id ")
    void delete(long id);
}
