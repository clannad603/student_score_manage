package com.huangrui.student_score_manage.service;

import com.huangrui.student_score_manage.entity.Student;
import com.huangrui.student_score_manage.model.StudentInfoModel;

public interface StudentService {
    StudentInfoModel getStudentInfoModel(String studentId);

    int update(StudentInfoModel editStudentInfoModel);

    int addStudent(Student student);
}
