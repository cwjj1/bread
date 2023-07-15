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
public class User {

    private Integer userId;

    private String phoneNum ;

    private String userName;

    private String userPwd;

    private String userType;

    private String salt;
}
