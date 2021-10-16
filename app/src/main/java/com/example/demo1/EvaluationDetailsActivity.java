package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demo1.models.Evaluation;

public class EvaluationDetailsActivity extends AppCompatActivity {
    private TextView tvDate, tvImc, tvHeight;
    private Button btnDelete, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluation_details);
        Evaluation evaluation = (Evaluation)  getIntent().getSerializableExtra("Evaluation");

        tvDate = findViewById(R.id.activity_evaluation_details_text_date);
        tvHeight= findViewById(R.id.activity_evaluation_details_text_weight);
        tvImc= findViewById(R.id.activity_evaluation_details_text_imc);
        btnDelete= findViewById(R.id.activity_evaluation_details_btn_delete);
        btnBack= findViewById(R.id.activity_evaluation_details_btn_back);


        btnDelete.setOnClickListener(view -> {
            Toast.makeText(view.getContext(), "Evaluacion eliminada...",Toast.LENGTH_SHORT).show();
            Intent i = new Intent(view.getContext(), MainActivity.class);
            startActivity(i);
            finish();
        });

        btnBack.setOnClickListener(view -> {
            super.onBackPressed();
        });


    }
}