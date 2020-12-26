package com.wcc.beans;

public class Students {
    private String student_id;
    private String student_name;
    private String student_sex;
    private String classes_name;
    private String course_name;
    private Double s_usual_score;
    private Double s_exam_score;
    private Double s_total_score;
    public Students(){}
    public Students(String student_id, String student_name, String student_sex, String classes_name, String course_name, Double s_usual_score, Double s_exam_score, Double s_total_score) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.student_sex = student_sex;
        this.classes_name = classes_name;
        this.course_name = course_name;
        this.s_usual_score = s_usual_score;
        this.s_exam_score = s_exam_score;
        this.s_total_score = s_total_score;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_sex() {
        return student_sex;
    }

    public void setStudent_sex(String student_sex) {
        this.student_sex = student_sex;
    }

    public String getClasses_name() {
        return classes_name;
    }

    public void setClasses_name(String classes_name) {
        this.classes_name = classes_name;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public Double getS_usual_score() {
        return s_usual_score;
    }

    public void setS_usual_score(Double s_usual_score) {
        this.s_usual_score = s_usual_score;
    }

    public Double getS_exam_score() {
        return s_exam_score;
    }

    public void setS_exam_score(Double s_exam_score) {
        this.s_exam_score = s_exam_score;
    }

    public Double getS_total_score() {
        return s_total_score;
    }

    public void setS_total_score(Double s_total_score) {
        this.s_total_score = s_total_score;
    }

    @Override
    public String toString() {
        return "Students{" +
                "student_id='" + student_id + '\'' +
                ", student_name='" + student_name + '\'' +
                ", student_sex='" + student_sex + '\'' +
                ", classes_name='" + classes_name + '\'' +
                ", course_name='" + course_name + '\'' +
                ", s_usual_score=" + s_usual_score +
                ", s_exam_score=" + s_exam_score +
                ", s_total_score=" + s_total_score +
                '}';
    }
}
