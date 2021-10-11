package com.example.demo1.ui;

import android.content.Context;
import android.widget.BaseAdapter;

import java.text.SimpleDateFormat;
import java.util.List;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.demo1.R;
import com.example.demo1.models.Evaluation;

public class EvaluationAdapter extends BaseAdapter {


    private Context ctx;
    private List<Evaluation> evaluationList;

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

        Evaluation evaluation = evaluationList.get(i);

        TextView tvId = view.findViewById(R.id.item_evaluation_tv_id);
        TextView tvDate = view.findViewById(R.id.item_evaluation_tv_date);
        TextView tvWeight = view.findViewById(R.id.item_evaluation_tv_weight);
        TextView tvImc = view.findViewById(R.id.item_evaluation_tv_imc);

        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");

        tvId.setText(Long.toString(evaluation.getId()));
        tvDate.setText(dateFormat.format(evaluation.getDate()));
        tvWeight.setText(Double.toString(evaluation.getWeight()));
        tvImc.setText(Double.toString( (evaluation.getImc()) / (1.70 * 1.70)      ));

        return view;
    }
}
