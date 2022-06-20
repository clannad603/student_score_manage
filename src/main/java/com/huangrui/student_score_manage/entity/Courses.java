package com.huangrui.student_score_manage.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
@TableName("hr_courses")
public class Courses {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "student_id")
    private Long studentId;

    @TableField(value = "course_id")
    private Long courseId;
    @TableField(value = "score")
    private Integer score;

    @TableField(value ="deleted")
    @TableLogic
    private Integer deleted;
}
