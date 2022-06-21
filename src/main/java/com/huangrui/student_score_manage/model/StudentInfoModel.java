package com.huangrui.student_score_manage.model;

import javafx.beans.property.SimpleStringProperty;

public class StudentInfoModel {
    private Long id;
    private SimpleStringProperty math;
    private SimpleStringProperty programDesign;
    private SimpleStringProperty english;
    private SimpleStringProperty total;

    public StudentInfoModel() {
        this.math = new SimpleStringProperty();
        this.programDesign = new SimpleStringProperty();
        this.english = new SimpleStringProperty();
        this.total = new SimpleStringProperty();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMath() {
        return math.get();
    }

    public void setMath(String math) {
        this.math.set(math);
    }

    public String getProgramDesign() {
        return programDesign.get();
    }


    public void setProgramDesign(String programDesign) {
        this.programDesign.set(programDesign);
    }

    public String getEnglish() {
        return english.get();
    }


    public void setEnglish(String english) {
        this.english.set(english);
    }

    public String getTotal() {
        return total.get();
    }

    public void setTotal(String total) {
        this.total.set(total);
    }
}
