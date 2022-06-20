package com.huangrui.student_score_manage;

import com.huangrui.student_score_manage.dao.StudentMapper;
import com.huangrui.student_score_manage.entity.Student;
import com.huangrui.student_score_manage.model.StudentInfoModel;
import com.huangrui.student_score_manage.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.util.Random;

@SpringBootTest
class StudentScoreManageApplicationTests {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentMapper studentMapper;

    int getRandom(int max, int min){
        Random random = new Random();
        int i = random.nextInt(max) % (max - min + 1) + min;
        return  i;
    }


    @Test
    void md5Code(){
        String s = DigestUtils.md5DigestAsHex("123456".getBytes());
        System.out.println(s);
    }


    @Test
    void intiStudent(){
        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            student.setName("学生" + i);
            student.setMath(getRandom(100, 0));
            student.setEnglish(getRandom(100, 0));
            student.setProgramDesign(getRandom(100, 0));
            studentMapper.insert(student);
        }
    }

    @Test
    void selectStudent(){
        StudentInfoModel studentInfoModel = studentService.getStudentInfoModel("1");
        System.out.println(studentInfoModel.getMath());
    }

}
