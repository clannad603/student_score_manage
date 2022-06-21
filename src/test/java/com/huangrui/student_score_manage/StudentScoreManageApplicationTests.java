package com.huangrui.student_score_manage;

import com.huangrui.student_score_manage.dao.StudentMapper;
import com.huangrui.student_score_manage.entity.Student;
import com.huangrui.student_score_manage.model.ScoreRankModel;
import com.huangrui.student_score_manage.model.StudentInfoModel;
import com.huangrui.student_score_manage.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.util.List;
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
//        for (int i = 1; i < 11; i++) {
//            Student student = studentMapper.selectById(i);
//            student.setTotal(student.getMath() + student.getEnglish() + student.getProgramDesign());
//            studentMapper.updateById(student);
//        }
        Student student = studentMapper.selectById(11);
        student.setTotal(student.getMath() + student.getEnglish() + student.getProgramDesign());
        studentMapper.updateById(student);
    }

    @Test
    void getRank(){
        List<ScoreRankModel> scoreRank = studentMapper.getScoreRank();
        for (ScoreRankModel scoreRankModel : scoreRank) {
            System.out.println(scoreRankModel.getStudentName());
            System.out.println(scoreRankModel.getScore());
        }
    }
}
