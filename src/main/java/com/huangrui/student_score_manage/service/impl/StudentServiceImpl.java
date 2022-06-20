package com.huangrui.student_score_manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.huangrui.student_score_manage.dao.StudentMapper;
import com.huangrui.student_score_manage.entity.Student;
import com.huangrui.student_score_manage.model.StudentInfoModel;
import com.huangrui.student_score_manage.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentMapper studentMapper;

    @Override
    public StudentInfoModel getStudentInfoModel(String studentId) {
        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();
        if (checkStringPositiveNum(studentId)) {
            wrapper.eq(Student::getId, Long.valueOf(studentId));
        }else {
            wrapper.eq(Student::getName, studentId);
        }
        Student student = studentMapper.selectOne(wrapper);
        StudentInfoModel studentInfoModel = new StudentInfoModel();
        studentInfoModel.setMath(String.valueOf(student.getMath()));
        studentInfoModel.setEnglish(String.valueOf(student.getEnglish()));
        studentInfoModel.setProgramDesign(String.valueOf(student.getProgramDesign()));
        studentInfoModel.setTotal(String.valueOf(student.getMath()+ student.getEnglish() + student.getProgramDesign()));
        return studentInfoModel;
    }

    public  Boolean checkStringPositiveNum(String val) {
        if (StringUtils.isBlank(val)) {
            return false;
        }
        Pattern pattern = compile("[0-9]*");
        return pattern.matcher(val).matches();
    }


}
