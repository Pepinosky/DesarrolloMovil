package com.example.demo1.models;

import java.io.Serializable;
import java.util.Date;

public class Evaluation implements Serializable {

    private Date date;
    private long id;
    private double imc;
    private double weight;

    public Evaluation(Date date, long id, double imc, double weight) {
        this.date = date;
        this.id = id;
        this.imc = imc;
        this.weight = weight;
    }

    public Date getDate() {
        return date;
    }

    public long getId() {
        return id;
    }

    public double getImc() {
        return imc;
    }

    public double getWeight() {
        return weight;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }




}
