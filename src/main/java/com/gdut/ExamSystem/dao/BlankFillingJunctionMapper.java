package com.gdut.ExamSystem.dao;

import com.gdut.ExamSystem.model.BlankFillingJunction;
import com.gdut.ExamSystem.model.BlankFillingJunctionKey;

public interface BlankFillingJunctionMapper {
    int deleteByPrimaryKey(BlankFillingJunctionKey key);

    int insert(BlankFillingJunction record);

    int insertSelective(BlankFillingJunction record);

    BlankFillingJunction selectByPrimaryKey(BlankFillingJunctionKey key);

    int updateByPrimaryKeySelective(BlankFillingJunction record);

    int updateByPrimaryKey(BlankFillingJunction record);
}