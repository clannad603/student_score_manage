package com.huangrui.student_score_manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.huangrui.student_score_manage.dao.StudentMapper;
import com.huangrui.student_score_manage.entity.Student;
import com.huangrui.student_score_manage.model.ScoreRankModel;
import com.huangrui.student_score_manage.model.SubjectInfo;
import com.huangrui.student_score_manage.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private StudentMapper studentMapper;


    @Override
    public List<ScoreRankModel> getScoreRank() {
        return studentMapper.getScoreRank();
    }

    @Override
    public SubjectInfo getSubjectsInfo(String subjectName) {
        LambdaQueryWrapper<Student> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(Student.class,student->
            student.getColumn().equals(subjectName)
        );
        List<Integer> scores = new ArrayList<>();
        List<Student> students = studentMapper.selectList(queryWrapper);
        for (Student student : students) {
            if (student.getMath() != null) {
                scores.add(student.getMath());
            }
            if (student.getEnglish() != null) {
                scores.add(student.getEnglish());
            }
            if (student.getProgramDesign() != null) {
                scores.add(student.getProgramDesign());
            }
        }
        int count = scores.size();
        int sum = 0;
        float average = 0;
        float failPercentage = 0;
        float passPercentage = 0;
        float goodPercentage = 0;
        for (Integer score : scores) {
            sum += score;
            if (score < 60) {
                failPercentage++;
            } else if (score < 70) {
                passPercentage++;
            } else {
                goodPercentage++;
            }
        }
        average = (float) sum / count;
        failPercentage = failPercentage / count;
        passPercentage = passPercentage / count;
        goodPercentage = goodPercentage / count;
        SubjectInfo subjectInfo = new SubjectInfo();
        subjectInfo.setAverage(String.valueOf(average));
        subjectInfo.setFailPercentage(failPercentage*100+"%");
        subjectInfo.setPassPercentage(passPercentage*100+"%");
        subjectInfo.setGoodPercentage(goodPercentage*100+"%");
        return subjectInfo;
    }
}

