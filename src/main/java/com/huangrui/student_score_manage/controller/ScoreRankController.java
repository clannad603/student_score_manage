package com.huangrui.student_score_manage.controller;

import com.huangrui.student_score_manage.StudentScoreManageApplication;
import com.huangrui.student_score_manage.model.ScoreRankModel;
import com.huangrui.student_score_manage.service.CourseService;
import com.huangrui.student_score_manage.view.MenuSelectView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@FXMLController
public class ScoreRankController implements Initializable {
@Autowired
private CourseService courseService;
    public Text score_rank_title;
    public TableView<ScoreRankModel> score_rank_table;
    public TableColumn score_rank_name;
    public TableColumn score_rank_score;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        score_rank_name.setCellValueFactory(new PropertyValueFactory<ScoreRankModel, String>("studentName"));
        score_rank_score.setCellValueFactory(new PropertyValueFactory<ScoreRankModel, String>("score"));
        List<ScoreRankModel> data = courseService.getScoreRank();
        score_rank_table.getItems().addAll(data);
    }

    public void callBack() {
        StudentScoreManageApplication.getStage().close();
        StudentScoreManageApplication.showView(MenuSelectView.class);
    }
}
