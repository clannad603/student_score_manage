package com.huangrui.student_score_manage.controller;

import com.huangrui.student_score_manage.StudentScoreManageApplication;
import com.huangrui.student_score_manage.service.UserService;
import com.huangrui.student_score_manage.view.MenuSelectView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
public class LoginViewController implements Initializable {

    public Text hr_login_title;
    @FXML
    private TextField hr_login_username;

    @FXML
    private TextField hr_login_password;

    @FXML
    private Button hr_login_btn;

    @Autowired
    private UserService userService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    public void login() {
        String name = hr_login_username.getText();
        String password = hr_login_password.getText();
        if (name.equals("")){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.initOwner(StudentScoreManageApplication.getStage());
            a.setHeaderText("请填写用户名");
            a.showAndWait();
        } else if (password.equals("")) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.initOwner(StudentScoreManageApplication.getStage());
            a.setHeaderText("请填写密码");
            a.showAndWait();
        } else if (userService.login(name,password)){
            StudentScoreManageApplication.getStage().close();
            StudentScoreManageApplication.showView(MenuSelectView.class);
        }else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.initOwner(StudentScoreManageApplication.getStage());
            a.setHeaderText("用户名或密码错误！");
            a.showAndWait();
            hr_login_username.clear();
            hr_login_password.clear();
        }
    }

}
