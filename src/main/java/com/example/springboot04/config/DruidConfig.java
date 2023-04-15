package com.example.springboot04.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

//自定义Druid配置
@Configuration
public class DruidConfig {

    //绑定配置文件中属性
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    //后台监控
    //因为sprinboot内置了servlet容器，没有web.xml，替代方法ServletRegistrationBean
    @Bean
    public ServletRegistrationBean a(){
        ServletRegistrationBean<StatViewServlet> bean=new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        //后台需要有人登陆，账号密码设置
        HashMap<String,String> initParameters = new HashMap<>();
        //增加配置,固定的loginUsername，不能自定义
        initParameters.put("loginUsername","admin");
        initParameters.put("loginPassword","123456");

        //允许谁可以访问
        initParameters.put("allow","");

        //禁止谁访问
        //initParameters.put("名字","ip地址");

        bean.setInitParameters(initParameters);
        return bean;
    }

    //filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean=new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        HashMap<String, String> initParameters = new HashMap<>();
        initParameters.put("exclusions","*.js,*.css,/druid/*");
        //可以过滤哪些请求
        bean.setInitParameters(initParameters);
        return bean;
    }
}
