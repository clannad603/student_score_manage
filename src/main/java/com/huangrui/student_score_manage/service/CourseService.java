package com.huangrui.student_score_manage.service;

import com.huangrui.student_score_manage.model.ScoreRankModel;
import com.huangrui.student_score_manage.model.SubjectInfo;

import java.util.List;

public interface CourseService {

    List<ScoreRankModel> getScoreRank();

    SubjectInfo getSubjectsInfo(String subjectName);
}
