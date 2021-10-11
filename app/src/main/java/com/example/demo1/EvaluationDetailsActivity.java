package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.demo1.models.Evaluation;

public class EvaluationDetailsActivity extends AppCompatActivity {
    private TextView tvDate, tvImc, tvHeight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluation_details);
        Evaluation evaluation = (Evaluation)  getIntent().getSerializableExtra("Evaluation");

        tvDate = findViewById(R.id.activity_evaluation_details_text_date);
        tvHeight= findViewById(R.id.activity_evaluation_details_text_weight);
        tvImc= findViewById(R.id.activity_evaluation_details_text_imc);



    }
}