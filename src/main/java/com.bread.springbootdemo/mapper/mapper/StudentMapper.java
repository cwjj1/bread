package com.bread.springbootdemo.mapper;

import com.bread.springbootdemo.entity.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {

    // 根据用户ID查询学生信息
    @Select("SELECT * FROM student WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "major", column = "major"),
            @Result(property = "phoneNum", column = "phone_num"),
            @Result(property = "age", column = "age"),
            @Result(property = "grade", column = "grade"),
            @Result(property = "school", column = "school")
    })
    Student findById(int id);

    //插入学生信息
    @Insert("INSERT INTO student (name, major, phone_num, age, grade, school) " +
            "VALUES (#{name}, #{major}, #{phoneNum}, #{age}, #{grade}, #{school})")
    int save(Student student);

    // 更新学生信息
    @Update("UPDATE student SET name = #{name}, major = #{major}, phone_num = #{phoneNum}, " +
            "age = #{age}, grade = #{grade}, school = #{school} WHERE id = #{id}")
    int update(Student student);

    // 删除学生信息
    @Delete("DELETE FROM student WHERE id = #{id}")
    int delete(int id);
}