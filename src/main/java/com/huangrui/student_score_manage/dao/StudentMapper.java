package com.huangrui.student_score_manage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huangrui.student_score_manage.entity.Student;
import com.huangrui.student_score_manage.model.ScoreRankModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    List<ScoreRankModel> getScoreRank();

}
