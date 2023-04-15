package com.example.springboot04.mapper;

import com.example.springboot04.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.List;

//需要加这个注解，表示这是一个mybatis的mapper类
//也可以在主类中使用@MpperScan("com.example.mapper")
@Mapper
@Repository
public interface UserMapper {
    List<User> queryAll();
    User queryUserById(String id);
}
