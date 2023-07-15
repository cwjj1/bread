package com.bread.springbootdemo.mapper;

import com.bread.springbootdemo.entity.StudentSubjects;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentSubjectsMapper {
    // 根据学生id查询已选课程信息,显示用户所选课程
    @Select("SELECT * FROM order WHERE student_id = #{studentId}")
    @Results({
            @Result(property = "subjectId", column = "subject_id"),
            @Result(property = "subjectName", column = "subject_name"),
            @Result(property = "subjectTitle", column = "subject_title"),
            @Result(property = "subjectTeacher", column = "subject_teacher")
    })
    StudentSubjects findByStudentId(int studentId);

    // 根据课程id查询选课信息，显示已选该课程的学生信息
    @Select("SELECT * FROM order WHERE subject_id = #{subjectId}")
    @Results({
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "phoneNum", column = "phone_num")
    })
    StudentSubjects findBySubjectId(int subjectId);

    //插入学生选课信息
    @Insert("INSERT INTO student_subjects (student_id, student_name, subject_id, subject_name, subject_title, subject_teacher, phone_num) " +
            "VALUES (#{studentId}, #{studentName}, #{subjectId}, #{subjectName}, #{subjectTitle}, #{subjectTeacher}, #{phoneNum}"
    )
    int save(StudentSubjects studentSubjects);

    // 根据id删除选课信息
    @Delete("DELETE FROM student_subject WHERE id = #{id}")
    int delete(int id);
}