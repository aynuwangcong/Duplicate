package com.wcc.beans;

public class Classes {
    private String classes_id;
    private String classes_name;
    private Double c_usual_total_score;
    private Double c_usual_average_score;
    private Double c_exam_total_score;
    private Double c_exam_average_score;
    private Double c_total_total_score;
    private Double c_total_average_score;
    public Classes(){}

    public Classes(String classes_id, String classes_name, Double c_usual_total_score, Double c_usual_average_score, Double c_exam_total_score, Double c_exam_average_score, Double c_total_total_score, Double c_total_average_score) {
        this.classes_id = classes_id;
        this.classes_name = classes_name;
        this.c_usual_total_score = c_usual_total_score;
        this.c_usual_average_score = c_usual_average_score;
        this.c_exam_total_score = c_exam_total_score;
        this.c_exam_average_score = c_exam_average_score;
        this.c_total_total_score = c_total_total_score;
        this.c_total_average_score = c_total_average_score;
    }

    public String getClasses_id() {
        return classes_id;
    }

    public void setClasses_id(String classes_id) {
        this.classes_id = classes_id;
    }

    public String getClasses_name() {
        return classes_name;
    }

    public void setClasses_name(String classes_name) {
        this.classes_name = classes_name;
    }

    public Double getC_usual_total_score() {
        return c_usual_total_score;
    }

    public void setC_usual_total_score(Double c_usual_total_score) {
        this.c_usual_total_score = c_usual_total_score;
    }

    public Double getC_usual_average_score() {
        return c_usual_average_score;
    }

    public void setC_usual_average_score(Double c_usual_average_score) {
        this.c_usual_average_score = c_usual_average_score;
    }

    public Double getC_exam_total_score() {
        return c_exam_total_score;
    }

    public void setC_exam_total_score(Double c_exam_total_score) {
        this.c_exam_total_score = c_exam_total_score;
    }

    public Double getC_exam_average_score() {
        return c_exam_average_score;
    }

    public void setC_exam_average_score(Double c_exam_average_score) {
        this.c_exam_average_score = c_exam_average_score;
    }

    public Double getC_total_total_score() {
        return c_total_total_score;
    }

    public void setC_total_total_score(Double c_total_total_score) {
        this.c_total_total_score = c_total_total_score;
    }

    public Double getC_total_average_score() {
        return c_total_average_score;
    }

    public void setC_total_average_score(Double c_total_average_score) {
        this.c_total_average_score = c_total_average_score;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "classes_id=" + classes_id +
                ", classes_name='" + classes_name + '\'' +
                ", c_usual_total_score=" + c_usual_total_score +
                ", c_usual_average_score=" + c_usual_average_score +
                ", c_exam_total_score=" + c_exam_total_score +
                ", c_exam_average_score=" + c_exam_average_score +
                ", c_total_total_score=" + c_total_total_score +
                ", c_total_average_score=" + c_total_average_score +
                '}';
    }
}
