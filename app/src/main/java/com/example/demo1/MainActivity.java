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
import com.example.demo1.controllers.EvaluationController;
import com.example.demo1.lib.FieldValidator;
import com.example.demo1.models.Evaluation;
import com.example.demo1.models.User;
import com.example.demo1.ui.DatePickerFragment;
import com.example.demo1.ui.EvaluationAdapter;
import com.example.demo1.utils.DateUtils;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout fieldFrom, fieldUntil;
    private TextView tvTitle, tvClearFilter;
    private ListView lvAllEvaluations;
    private Button btnLogout, btnNewEvaluation, btnFilter;
    private AuthController authController;
    private EvaluationController evaluationController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        authController = new AuthController(this);
        evaluationController= new EvaluationController(this);


        btnNewEvaluation= findViewById(R.id.activity_main_btn_new_evaluation);
        btnLogout = findViewById(R.id.activity_main_btn_logout);
        btnFilter = findViewById(R.id.activity_main_btn_filter);
        lvAllEvaluations = findViewById(R.id.activity_main_lv_evaluations);
        fieldFrom= findViewById(R.id.activity_main_date_from);
        fieldUntil= findViewById(R.id.activity_main_date_until);
        tvTitle= findViewById(R.id.activity_main_title_evaluations);
        tvClearFilter= findViewById(R.id.activity_main_clear_filter);

        fieldFrom.getEditText().setOnClickListener(view -> {
            DatePickerFragment.showDatePickerDialog(this, fieldFrom, new Date());
        });
        fieldUntil.getEditText().setOnClickListener(view -> {
            DatePickerFragment.showDatePickerDialog(this, fieldUntil, new Date());
        });

        User user = authController.getUserSession();
        tvTitle.setText(String.format("Evaluaciones de %s", user.getFirstName()));

        List<Evaluation> evaluationList= evaluationController.getAll();
        this.setAllEvaluationsAdapter(evaluationList);

        btnNewEvaluation.setOnClickListener(view -> {
            Intent i = new Intent(view.getContext(), NewEvaluationActivity.class);
           view.getContext().startActivity(i);
        });


        btnFilter.setOnClickListener(view -> {
            String fromStr = fieldFrom.getEditText().getText().toString();
            String untilStr = fieldUntil.getEditText().getText().toString();
            boolean validFrom = new FieldValidator(fieldFrom)
                    .required()
                    .date()
                    .dateBefore(DateUtils.unsafeParse(untilStr))
                    .isValid();
            boolean validUntil = new FieldValidator(fieldUntil)
                    .required()
                    .date()
                    .dateAfter(DateUtils.unsafeParse(fromStr))
                    .isValid();

            if (validFrom && validUntil) {
                Date from = DateUtils.unsafeParse(fromStr);
                Date to = DateUtils.unsafeParse(untilStr);

                List<Evaluation> evaluationRangeList = evaluationController.getRange(from, to);
                this.setAllEvaluationsAdapter(evaluationRangeList);
            }
        });

        tvClearFilter.setOnClickListener(view -> {
            fieldFrom.getEditText().setText("");
            fieldUntil.getEditText().setText("");
            this.setAllEvaluationsAdapter(evaluationList);
        });

        btnLogout.setOnClickListener(view -> { authController.logout(); });



    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Evaluation> evaluationList = evaluationController.getAll();
        this.setAllEvaluationsAdapter(evaluationList);
    }

    private void setAllEvaluationsAdapter(List<Evaluation> evaluationList) {
        EvaluationAdapter adapter = new EvaluationAdapter(this, evaluationList);
        lvAllEvaluations.setAdapter(adapter);

        lvAllEvaluations.setOnItemClickListener(((adapterView, view, index, id) -> {
            Evaluation evaluation = evaluationList.get(index);

            Intent i = new Intent(view.getContext(), EvaluationDetailsActivity.class);
            i.putExtra("evaluation", evaluation);
            view.getContext().startActivity(i);
        }));
    }
}