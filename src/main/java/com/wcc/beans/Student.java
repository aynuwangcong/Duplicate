package com.wcc.beans;

public class Student {
    private Integer id;
    private String  student_id;
    private String  student_name;
    private Integer student_age;
    private String  student_sex;
    private String  university;
    private String  classes_name;
    private String  telphone;
//外键
    private String classes_id;
    public Student(){}

    public Student(String student_id, String student_name, Integer student_age, String student_sex, String university, String classes_name, String telphone) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.student_age = student_age;
        this.student_sex = student_sex;
        this.university = university;
        this.classes_name = classes_name;
        this.telphone = telphone;
    }

    public String getClasses_id() {
        return classes_id;
    }

    public void setClasses_id(String class_id) {
        this.classes_id = class_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getStudent_age() {
        return student_age;
    }

    public void setStudent_age(Integer student_age) {
        this.student_age = student_age;
    }

    public String getStudent_sex() {
        return student_sex;
    }

    public void setStudent_sex(String student_sex) {
        this.student_sex = student_sex;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getClasses_name() {
        return classes_name;
    }

    public void setClasses_name(String classes_name) {
        this.classes_name = classes_name;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", student_id='" + student_id + '\'' +
                ", student_name='" + student_name + '\'' +
                ", student_age=" + student_age +
                ", student_sex='" + student_sex + '\'' +
                ", university='" + university + '\'' +
                ", classes_name='" + classes_name + '\'' +
                ", telphone='" + telphone + '\'' +
                '}';
    }
}
