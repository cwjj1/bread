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
public class Subject {

    private Integer id;

    private String title;

    private String name;

    private String teacher;

    private Integer cost;

    private String description;

    private Integer likes;

    private Date sTime;

    private Date eTime;
}
