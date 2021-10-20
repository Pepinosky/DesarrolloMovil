package com.example.demo1.models;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Evaluation implements Serializable, IEvaluation {

    private Date date;
    private long id;
    private double imc;
    private double weight;

    public Evaluation(Date date, long id, double imc,  double weight) {
        this.date = date;
        this.imc= imc;
        this.id = id;
        this.weight = weight;
    }

    public Date getDate() {
        return date;
    }

    public long getId() {
        return id;
    }

    public double getImc() {
        return weight / (1.70 * 1.70 );
    }

    public String getStringImc(){
        return Double.toString(imc);
    }

    public double getWeight() {
        return weight;
    }
    public String getStringWeight(){
        return Double.toString(weight);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStringDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }




}
