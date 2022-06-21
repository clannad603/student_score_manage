package com.huangrui.student_score_manage.model;

import javafx.beans.property.SimpleStringProperty;

public class SubjectInfo {
    private SimpleStringProperty average;
    private SimpleStringProperty failPercentage;
    private SimpleStringProperty passPercentage;
    private SimpleStringProperty goodPercentage;

    public SubjectInfo() {
        this.average = new SimpleStringProperty();
        this.failPercentage = new SimpleStringProperty();
        this.passPercentage = new SimpleStringProperty();
        this.goodPercentage = new SimpleStringProperty();
    }

    public String getAverage() {
        return average.get();
    }

    public void setAverage(String average) {
        this.average.set(average);
    }

    public String getFailPercentage() {
        return failPercentage.get();
    }

    public void setFailPercentage(String failPercentage) {
        this.failPercentage.set(failPercentage);
    }

    public String getPassPercentage() {
        return passPercentage.get();
    }

    public void setPassPercentage(String passPercentage) {
        this.passPercentage.set(passPercentage);
    }

    public String getGoodPercentage() {
        return goodPercentage.get();
    }

    public void setGoodPercentage(String goodPercentage) {
        this.goodPercentage.set(goodPercentage);
    }
}
