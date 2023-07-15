package com.bread.springbootdemo.mapper;
import com.bread.springbootdemo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    // 根据手机号查询用户
    @Select("SELECT * FROM user WHERE phone_num = #{phoneNum}")
    User findByPhoneNum(String phoneNum);

    // 插入新用户
    @Insert("INSERT INTO user (phone_num, username, user_pwd, user_type) " +
            "VALUES (#{phoneNum}, #{username}, #{password}, #{userType})")
    void save(User user);

    // 修改用户昵称
    @Update("UPDATE user SET user_name = #{userName} WHERE user_id = #{userId} ")
    int updateUserNameById(User user);

    // 修改用户密码
    @Update("UPDATE user SET user_pwd = #{userPwd} WHERE user_id = #{userId} ")
    int updateUserPwdById(User user);
}
