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

    public EvaluationEntity(long id,  double weight, Date date, double imc) {
        this.id = id;
        this.weight = weight;
        this.date = date;
        this.imc= imc;
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
        return weight / (1.70 * 1.70);
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
