package com.huangrui.student_score_manage.controller;

import com.huangrui.student_score_manage.StudentScoreManageApplication;
import com.huangrui.student_score_manage.model.StudentInfoModel;
import com.huangrui.student_score_manage.service.StudentService;
import com.huangrui.student_score_manage.view.MenuSelectView;
import com.huangrui.student_score_manage.view.StudentInfoView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@FXMLController
public class StudentInfoController implements Initializable {

    public TextField hr_student_info_id;
    public Button hr_student_info_btn_update;
    @Autowired
    private StudentService studentService;
    private StudentInfoModel studentInfoModel;
    private StudentInfoModel editStudentInfoModel;
    public TableColumn math;
    public TableColumn programDesign;
    public TableColumn english;
    public TableColumn total;
    public TableView<StudentInfoModel> hr_student_info_table;

    void bindData() {
        math.setCellValueFactory(new PropertyValueFactory<StudentInfoModel, String>("math"));
        programDesign.setCellValueFactory(new PropertyValueFactory<StudentInfoModel, String>("programDesign"));
        english.setCellValueFactory(new PropertyValueFactory<StudentInfoModel, String>("english"));
        total.setCellValueFactory(new PropertyValueFactory<StudentInfoModel, String>("total"));
        math.setCellFactory(TextFieldTableCell.forTableColumn());
        programDesign.setCellFactory(TextFieldTableCell.forTableColumn());
        english.setCellFactory(TextFieldTableCell.forTableColumn());
        math.setOnEditCommit((EventHandler<TableColumn.CellEditEvent<StudentInfoModel, String>>) event -> {
            editStudentInfoModel = event.getRowValue();
            editStudentInfoModel.setMath(event.getNewValue());
        });
        programDesign.setOnEditCommit((EventHandler<TableColumn.CellEditEvent<StudentInfoModel, String>>) event -> {
            editStudentInfoModel = event.getRowValue();
            editStudentInfoModel.setProgramDesign(event.getNewValue());
        });
        english.setOnEditCommit((EventHandler<TableColumn.CellEditEvent<StudentInfoModel, String>>) event -> {
            editStudentInfoModel = event.getRowValue();
            editStudentInfoModel.setEnglish(event.getNewValue());
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hr_student_info_table.setEditable(true);
        bindData();
    }

    public void callBack() {
        StudentScoreManageApplication.getStage().close();
        StudentScoreManageApplication.showView(MenuSelectView.class);
    }

    public void select() {
        hr_student_info_table.getItems().remove(studentInfoModel);
        studentInfoModel = studentService.getStudentInfoModel(hr_student_info_id.getText());
        hr_student_info_table.getItems().add(studentInfoModel);
    }

    public void update() {
        System.out.println(editStudentInfoModel.getMath());
    }
}
