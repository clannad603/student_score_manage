package com.huangrui.student_score_manage.controller;

import com.huangrui.student_score_manage.StudentScoreManageApplication;
import com.huangrui.student_score_manage.view.StudentInfoView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
public class MenuSelectController implements Initializable {

    public Text hr_menu_select_title;
    public Button hr_menu_select_btn_1;
    public Button hr_menu_select_btn_2;
    public Button hr_menu_select_btn_3;
    public Button hr_menu_select_btn_4;
    public Text hr_menu_select_menu_1;
    public Text hr_menu_select_menu_2;
    public Text hr_menu_select_menu_3;
    public Text hr_menu_select_menu_4;
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
}
