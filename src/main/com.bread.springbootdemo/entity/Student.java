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
public class Student {

    private Integer id;

    private String name;

    private String major;

    private String phoneNum;

    private Integer age;

    private String grade;

    private String school;
}
