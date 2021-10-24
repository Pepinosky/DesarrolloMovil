package com.example.demo1.models;

public class EvaluationMapper {
    private IEvaluation evaluation;

    public EvaluationMapper(IEvaluation evaluation) {
        this.evaluation = evaluation;
    }

    public Evaluation toBase(){
        Evaluation baseEvaluation = new Evaluation(
                this.evaluation.getDate(),
                this.evaluation.getImc(),
                this.evaluation.getWeight(),
                this.evaluation.getUserId()
        );
        baseEvaluation.setId(this.evaluation.getId());
        return baseEvaluation;
    }

    public EvaluationEntity toEntity(){
        return new EvaluationEntity(
                this.evaluation.getId(),
                this.evaluation.getWeight(),
                this.evaluation.getDate(),
                this.evaluation.getImc(),
                this.evaluation.getUserId()
        );
    }
}
