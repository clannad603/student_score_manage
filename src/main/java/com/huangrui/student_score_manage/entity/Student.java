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

    @TableField(value = "student_address")
    private String address;

    @TableField(value ="deleted")
    @TableLogic
    private Integer deleted;
}
