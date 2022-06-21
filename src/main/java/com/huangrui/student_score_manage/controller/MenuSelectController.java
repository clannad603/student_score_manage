package com.huangrui.student_score_manage.controller;

import com.huangrui.student_score_manage.StudentScoreManageApplication;
import com.huangrui.student_score_manage.view.ScoreRankView;
import com.huangrui.student_score_manage.view.StudentInfoView;
import com.huangrui.student_score_manage.view.SubjectsInfoView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
public class MenuSelectController implements Initializable {

    @FXML
    private VBox hr_menu_vbox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void choose_one() {
        StudentScoreManageApplication.getStage().close();
        StudentScoreManageApplication.showView(StudentInfoView.class);
    }

    public void choose_two() {
        StudentScoreManageApplication.getStage().close();
        StudentScoreManageApplication.showView(ScoreRankView.class);
    }

    public void choose_three() {
        StudentScoreManageApplication.getStage().close();
        StudentScoreManageApplication.showView(SubjectsInfoView.class);
    }
}
