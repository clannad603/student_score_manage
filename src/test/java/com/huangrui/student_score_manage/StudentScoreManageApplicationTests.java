package com.huangrui.student_score_manage;

import com.huangrui.student_score_manage.dao.CoursesMapper;
import com.huangrui.student_score_manage.entity.Courses;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.util.Random;

@SpringBootTest
class StudentScoreManageApplicationTests {

    @Autowired
    private CoursesMapper coursesMapper;

    int getRandom(int max, int min){
        Random random = new Random();
        int i = random.nextInt(max) % (max - min + 1) + min;
        return  i;
    }

    @Test
    void contextLoads() {
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 7; j++) {
                Courses courses = new Courses();
                courses.setCourseId((long)j);
                courses.setStudentId((long)i);
                courses.setScore(getRandom(100,0));
                coursesMapper.insert(courses);
            }
        }
    }

    @Test
    void md5Code(){
        String s = DigestUtils.md5DigestAsHex("123456".getBytes());
        System.out.println(s);
    }
}
