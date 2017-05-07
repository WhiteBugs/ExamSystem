package com.gdut.ExamSystem.dao;

import com.gdut.ExamSystem.model.BlankFillingJunction;

public interface BlankFillingJunctionMapper {
    int insert(BlankFillingJunction record);

    int insertSelective(BlankFillingJunction record);
}