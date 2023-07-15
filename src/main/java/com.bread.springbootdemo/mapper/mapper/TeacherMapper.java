package com.bread.springbootdemo.mapper;

import com.bread.springbootdemo.entity.Teacher;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherMapper {

    // 根据用户ID查询教师信息
    @Select("SELECT * FROM teacher WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age"),
            @Result(property = "department", column = "department"),
            @Result(property = "phoneNum", column = "phone_num")
    })
    Teacher findById(int id);

    // 插入教师信息
    @Insert("INSERT INTO teacher (name, age, department, phone_num) " +
            "VALUES (#{name}, #{age}, #{department}, #{phoneNum})")
    int save(Teacher teacher);

    // 更新教师信息
    @Update("UPDATE teacher SET name = #{name}, age = #{age}, department = #{department}, " +
            "phone_num = #{phoneNum} WHERE id = #{id}")
    int update(Teacher teacher);

    // 删除教师信息
    @Delete("DELETE FROM teacher WHERE id = #{id}")
    int delete(int id);
}