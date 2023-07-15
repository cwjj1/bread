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
public class Teacher {

    private Integer id;

    private String name;

    private Integer age;

    private String department;

    private String phoneNum;
}
