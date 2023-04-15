package com.example.springboot04;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class Springboot04ApplicationTests {

    //Springboot已经配置好了数据源
    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        //默认数据源hikari
        System.out.println(dataSource.getClass());
        //获取数据库连接
        Connection connection = dataSource.getConnection();
        //xxxxTemplate: springboot已经配置好了模版bean


        connection.close();
    }

}
