package com.example.springboot2022.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot2022.entity.Data;
import com.example.springboot2022.entity.line;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface indexMapper extends BaseMapper<Data> {

    @Select("select * from han order by time limit 7")
    List<line> selectline();

    @Insert("insert into han(name,pk,message) values (#{name},#{pk}),#{message}")
    int  insertAll(@Param("name")String name, @Param("pk")String pk,@Param("message")String message);
}
