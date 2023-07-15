package com.bread.springbootdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentSubjects {

    private Integer id;

    private Integer studentId;

    private String studentName;

    private Integer subjectId;

    private String subjectName;

    private String subjectTitle;

    private String subjectTeacher;

    private String phoneNum;
}
