package com.huangrui.student_score_manage.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
@TableName("hr_course")
public class Course {
    @TableId(value = "course_id", type = IdType.AUTO)
    private Long courseId;

    @TableField(value = "course_name")
    private String courseName;

    @TableField("deleted")
    @TableLogic
    private Integer deleted;
}
