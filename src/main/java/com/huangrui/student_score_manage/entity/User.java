package com.huangrui.student_score_manage.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
@TableName("hr_user")
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField("user_name")
    private String username;
    @TableField("password")
    private String password;
    @TableField("deleted")
    @TableLogic
    private Integer deleted;

}
