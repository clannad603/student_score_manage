package com.huangrui.student_score_manage.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
@TableName("hr_student")
public class Student {
    @TableId(value = "student_id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "student_name")
    private String name;

    @TableField(value = "math")
    private Integer math;

    @TableField(value = "english")
    private Integer english;

    @TableField(value = "program_design")
    private Integer programDesign;

    @TableField(value ="deleted")
    @TableLogic
    private Integer deleted;
}
