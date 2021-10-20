package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.demo1.controllers.AuthController;
import com.example.demo1.controllers.EvaluationController;
import com.example.demo1.models.Evaluation;
import com.example.demo1.models.User;
import com.example.demo1.ui.DatePickerFragment;
import com.example.demo1.utils.DateUtils;
import com.google.android.material.textfield.TextInputLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewEvaluationActivity extends AppCompatActivity {
        private final String DATE_PATTERN = "yyyy-MM-dd";
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
            String date= fieldDate.getEditText().getText().toString();
            String weight= fieldWeight.getEditText().getText().toString();


            //TODO: validations
            Date evaluationDate= DateUtils.unsafeParse(date);

            Evaluation evaluation = new Evaluation(evaluationDate, 1, 1.70, Double.parseDouble(weight) );

            EvaluationController controller= new EvaluationController(view.getContext());
           controller.register(evaluation);



            Toast.makeText(view.getContext(), "Evaluacion registrada...",Toast.LENGTH_SHORT).show();

        });

        btnBack.setOnClickListener(view -> {
            super.onBackPressed();
        });


    }
}