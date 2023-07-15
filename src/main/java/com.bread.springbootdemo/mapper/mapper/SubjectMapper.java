package com.bread.springbootdemo.mapper;

import com.bread.springbootdemo.entity.Subject;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectMapper {
    // 根据老师id查询课程信息
    @Select("SELECT * FROM subject WHERE teacher_id = #{teacher_id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "name", column = "name"),
            @Result(property = "teacher", column = "teacher"),
            @Result(property = "cost", column = "cost"),
            @Result(property = "description", column = "description"),
            @Result(property = "likes", column = "likes"),
            @Result(property = "sTime", column = "s_time"),
            @Result(property = "eTime", column = "e_time")
    })
    Subject findByTeacherId(int teacherId);

    // 查询所有课程信息
    @Select("SELECT * FROM subject")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "name", column = "name"),
            @Result(property = "teacher", column = "teacher"),
            @Result(property = "cost", column = "cost"),
            @Result(property = "description", column = "description"),
            @Result(property = "likes", column = "likes"),
            @Result(property = "sTime", column = "s_time"),
            @Result(property = "eTime", column = "e_time")
    })
    List<Subject> findAll();

    // 插入课程信息
    @Insert("INSERT INTO subject (title, name, teacher, teacher_id, cost, description, s_time, e_time) " +
            "VALUES (#{title}, #{name}, #{teacher}, #{teacherId} #{cost}, #{description}, #{sTime}, #{eTime}"
            )
   int save(Subject subject);

    // 修改课程信息
    @Update("UPDATE subject SET title = #{title}, name = #{name}, teacher = #{teacher}, " +
            "cost = #{cost}, description = #{description}, s_time = #{sTime}, e_time = #{eTime} WHERE id = #{id}")
    int update(Subject subject);

    // 增加点赞数
    @Update("UPDATE subject SET likes = likes+1")
    int updateLikes(Subject subject);

    // 根据id删除课程信息
    @Delete("DELETE FROM subject WHERE id = #{id}")
    int delete(int id);
}