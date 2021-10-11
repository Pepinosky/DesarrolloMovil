package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.demo1.controllers.AuthController;
import com.example.demo1.models.Evaluation;
import com.example.demo1.models.User;
import com.example.demo1.ui.DatePickerFragment;
import com.example.demo1.ui.EvaluationAdapter;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout fieldFrom, fieldUntil;
    private TextView tvTitle;
    private ListView lvAllEvaluations;

    private Button btnLogout, btnNewEvaluation;
    private AuthController authController;
    private List<Evaluation> evaluationList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNewEvaluation= findViewById(R.id.activity_main_btn_new_evaluation);
        btnLogout = findViewById(R.id.activity_main_btn_logout);
        fieldFrom= findViewById(R.id.activity_main_date_from);
        fieldUntil= findViewById(R.id.activity_main_date_until);
        tvTitle= findViewById(R.id.activity_main_title_evaluations);
        authController = new AuthController(this);

        User user = authController.getUserSession();
        tvTitle.setText(String.format("Evaluaciones de %s", user.getFirstName()));


        fieldFrom.getEditText().setOnClickListener(view -> {
            DatePickerFragment.showDatePickerDialog(this, fieldFrom, new Date());
        });
        fieldUntil.getEditText().setOnClickListener(view -> {
            DatePickerFragment.showDatePickerDialog(this, fieldUntil, new Date());
        });


        lvAllEvaluations = findViewById(R.id.activity_main_lv_evaluations);
        for (int x = 0; x < 6; ++x) {
            Evaluation newEvaluation = new Evaluation(new Date(), x , 20, 65);
            newEvaluation.setId(x);
            evaluationList.add(newEvaluation);
        }
        EvaluationAdapter adapter = new EvaluationAdapter(this, evaluationList);

        lvAllEvaluations.setAdapter(adapter);

        lvAllEvaluations.setOnItemClickListener(((adapterView, view, index, id) -> {
            Evaluation evaluation = evaluationList.get(index);

            Intent i = new Intent(view.getContext(), EvaluationDetailsActivity.class);
            i.putExtra("evaluacion", evaluation);
            view.getContext().startActivity(i);
        }));


        btnNewEvaluation.setOnClickListener(view -> {
            Intent i = new Intent(view.getContext(), NewEvaluationActivity.class);
            startActivity(i);
        });


        btnLogout.setOnClickListener(view -> { authController.logout(); });



    }







}