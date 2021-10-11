package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.demo1.ui.DatePickerFragment;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Date;

public class NewEvaluationActivity extends AppCompatActivity {
        private Button btnRegisterEvaluation, btnBack;
        private TextInputLayout fieldDate, fieldWeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_evaluation);
        btnRegisterEvaluation= findViewById(R.id.activity_new_evaluation_btn_register_evaluation);
        btnBack= findViewById(R.id.activity_new_evaluation_btn_back);
        fieldDate= findViewById(R.id.activity_new_evaluation_field_date);
        fieldWeight= findViewById(R.id.activity_new_evaluation_field_weight);

        fieldDate.getEditText().setOnClickListener(view -> {
            DatePickerFragment.showDatePickerDialog(this, fieldDate, new Date());
        });


        btnRegisterEvaluation.setOnClickListener(view -> {
            Toast.makeText(view.getContext(), "Evaluacion registrada...",Toast.LENGTH_SHORT).show();
            Intent i = new Intent(view.getContext(), MainActivity.class);
            startActivity(i);
            finish();
        });

        btnBack.setOnClickListener(view -> {
            Intent i = new Intent(view.getContext(), MainActivity.class);
            startActivity(i);
            finish();
        });


    }
}