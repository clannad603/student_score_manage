package com.huangrui.student_score_manage.controller;

import com.huangrui.student_score_manage.StudentScoreManageApplication;
import com.huangrui.student_score_manage.model.StudentInfoModel;
import com.huangrui.student_score_manage.service.StudentService;
import com.huangrui.student_score_manage.view.MenuSelectView;
import com.huangrui.student_score_manage.view.StudentInfoAddView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
public class StudentInfoController implements Initializable {

    public TextField hr_student_info_id;
    public Button hr_student_info_btn_update;
    public Button hr_student_info_btn_add;
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
        System.out.println(studentInfoModel.getId());
        hr_student_info_table.getItems().add(studentInfoModel);
    }

    public void update() {
        editStudentInfoModel.setId(studentInfoModel.getId());
        int is_update = studentService.update(editStudentInfoModel);
        if (is_update == 1) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(StudentScoreManageApplication.getStage());
            alert.setHeaderText("更新成功");
            alert.showAndWait();
            select();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(StudentScoreManageApplication.getStage());
            alert.setHeaderText("更新失败");
            alert.showAndWait();
        }
    }

    public void addStudent() {
        StudentScoreManageApplication.getStage().close();
        StudentScoreManageApplication.showView(StudentInfoAddView.class);
    }
}
