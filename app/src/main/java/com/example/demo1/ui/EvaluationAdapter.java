package com.example.demo1.ui;

import android.content.Context;
import android.widget.BaseAdapter;
import java.util.List;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.demo1.R;
import com.example.demo1.controllers.AuthController;
import com.example.demo1.models.Evaluation;
import com.example.demo1.models.User;

public class EvaluationAdapter extends BaseAdapter {


    private Context ctx;
    private List<Evaluation> evaluationList;
    private AuthController authController;

    public EvaluationAdapter(Context ctx, List<Evaluation> evaluationList) {
        this.ctx = ctx;
        this.evaluationList = evaluationList;
    }

    @Override
    public int getCount() {
        return evaluationList.size();
    }

    @Override
    public Object getItem(int i) {
        return evaluationList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(ctx);

        view = inflater.inflate(R.layout.item_evaluation, null);
        authController = new AuthController(ctx);
        User user = authController.getUserSession();
        Evaluation evaluation = evaluationList.get(i);


        TextView tvDate = view.findViewById(R.id.item_evaluation_tv_date);
        TextView tvWeight = view.findViewById(R.id.item_evaluation_tv_weight);
        TextView tvImc = view.findViewById(R.id.item_evaluation_tv_imc);


        tvDate.setText( String.format("Fecha: %s",evaluation.getStringDate()));
        tvWeight.setText(String.format("Peso: %s",Double.toString(evaluation.getWeight())));
        tvImc.setText(String.format("IMC: %s",Double.toString((evaluation.getWeight()) / (user.getHeight() * user.getHeight()))));

        return view;
    }
}
