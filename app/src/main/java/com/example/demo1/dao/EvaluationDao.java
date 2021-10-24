package com.example.demo1.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.demo1.models.EvaluationEntity;


import java.util.Date;
import java.util.List;

@Dao
public interface EvaluationDao {
    @Query("SELECT id, imc, weight, date, user_id FROM evaluations WHERE user_id = :userId ")
    List<EvaluationEntity> findAll(long userId);

    @Query("SELECT id, imc, weight, date, user_id FROM evaluations WHERE user_id = :userId AND date BETWEEN :from AND :until ")
    List<EvaluationEntity> findByRange(Date from, Date until, long userId);

    @Insert
    long insert(EvaluationEntity evaluation);

    @Query("DELETE FROM evaluations WHERE id= :id ")
    void delete(long id);
}
