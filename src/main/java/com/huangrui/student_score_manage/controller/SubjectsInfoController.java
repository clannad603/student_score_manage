package com.huangrui.student_score_manage.controller;

import com.huangrui.student_score_manage.StudentScoreManageApplication;
import com.huangrui.student_score_manage.model.ScoreRankModel;
import com.huangrui.student_score_manage.model.SubjectInfo;
import com.huangrui.student_score_manage.service.CourseService;
import com.huangrui.student_score_manage.view.MenuSelectView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
public class SubjectsInfoController implements Initializable {

    @Autowired
    private CourseService courseService;

    private  SubjectInfo subjectInfo;
    public TextField subjects_name;
    public TableView<SubjectInfo> hr_subjects_info_table;
    public TableColumn average;
    public TableColumn failPercentage;
    public TableColumn passPercentage;
    public TableColumn goodPercentage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        average.setCellValueFactory(new PropertyValueFactory<ScoreRankModel, String>("average"));
        failPercentage.setCellValueFactory(new PropertyValueFactory<ScoreRankModel, String>("failPercentage"));
        passPercentage.setCellValueFactory(new PropertyValueFactory<ScoreRankModel, String>("passPercentage"));
        goodPercentage.setCellValueFactory(new PropertyValueFactory<ScoreRankModel, String>("goodPercentage"));
    }

    public void callBack() {
        StudentScoreManageApplication.getStage().close();
        StudentScoreManageApplication.showView(MenuSelectView.class);
    }

    public void select() {
        hr_subjects_info_table.getItems().clear();
        subjectInfo = courseService.getSubjectsInfo(subjects_name.getText());
        hr_subjects_info_table.getItems().add(subjectInfo);
    }
}
