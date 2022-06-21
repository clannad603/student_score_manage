package com.huangrui.student_score_manage.model;

import javafx.beans.property.SimpleStringProperty;

public class ScoreRankModel {
    private SimpleStringProperty studentName;
    private SimpleStringProperty score;

    public String getStudentName() {
        return studentName.get();
    }
    public void setStudentName(String studentName) {
        this.studentName.set(studentName);
    }

    public String getScore() {
        return score.get();
    }

    public void setScore(String score) {
        this.score.set(score);
    }

    public ScoreRankModel() {
        this.studentName = new SimpleStringProperty();
        this.score = new SimpleStringProperty();
    }
}
