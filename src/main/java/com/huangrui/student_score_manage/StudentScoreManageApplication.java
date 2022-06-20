package com.huangrui.student_score_manage;

import com.huangrui.student_score_manage.controller.MainScene;
import com.huangrui.student_score_manage.view.LoginView;
import com.huangrui.student_score_manage.view.MainView;
import com.huangrui.student_score_manage.view.MySplashScreen;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@SpringBootApplication
public class StudentScoreManageApplication extends AbstractJavaFxApplicationSupport {

    public static void main(String[] args) {
        launch(StudentScoreManageApplication.class, LoginView.class, new MySplashScreen(), args);
    }



    @Override
    public void start(Stage stage) throws Exception {
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("退出确认框");
                //设置对话框的 icon 图标
                alert.initOwner(stage);
                alert.setHeaderText("您确定要现在退出程序？");
                Optional result = alert.showAndWait();
                if (result.get() == ButtonType.CANCEL) {
                    event.consume();
                }

            }
        });
        super.start(stage);
    }
}
