package com.huangrui.student_score_manage.controller;

import com.huangrui.student_score_manage.StudentScoreManageApplication;
import com.huangrui.student_score_manage.entity.Student;
import com.huangrui.student_score_manage.service.StudentService;
import com.huangrui.student_score_manage.view.MenuSelectView;
import com.huangrui.student_score_manage.view.StudentInfoView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
public class StudentInfoAddController implements Initializable {

    public TextField program_design_score;
    public TextField english_score;
    public TextField math_score;
    public TextField student_name;

    @Autowired
    private StudentService studentService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void addStudent() {
        Student student = new Student();
        student.setName(student_name.getText());
        student.setMath(Integer.parseInt(math_score.getText()));
        student.setEnglish(Integer.parseInt(english_score.getText()));
        student.setProgramDesign(Integer.parseInt(program_design_score.getText()));
        student.setTotal(Integer.parseInt(math_score.getText()) + Integer.parseInt(english_score.getText()) + Integer.parseInt(program_design_score.getText()));
        studentService.addStudent(student);
        if (student.getId() > 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(StudentScoreManageApplication.getStage());
            alert.setHeaderText("添加成功 id为"+student.getId() );
            alert.showAndWait();
            StudentScoreManageApplication.getStage().close();
            StudentScoreManageApplication.showView(StudentInfoView.class);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(StudentScoreManageApplication.getStage());
            alert.setHeaderText("添加失败");
            alert.showAndWait();
        }
    }

    public void callback() {
        StudentScoreManageApplication.getStage().close();
        StudentScoreManageApplication.showView(StudentInfoView.class);
    }
}
