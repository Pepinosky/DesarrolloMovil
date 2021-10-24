package com.example.demo1.models;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "evaluations")
public class EvaluationEntity implements  IEvaluation{
    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "imc")
    private double imc;

    @ColumnInfo(name = "weight")
    private double weight;

    @ColumnInfo(name = "date")
    private Date date;

    @ColumnInfo(name = "user_id")
    private long userId;

    public EvaluationEntity(long id,  double weight, Date date, double imc, long userId) {
        this.id = id;
        this.weight = weight;
        this.date = date;
        this.imc= imc;
        this.userId= userId;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public double getImc() {
        return imc;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public long getUserId() {
        return userId;
    }
}
