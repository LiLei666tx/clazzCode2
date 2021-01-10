package com.jsonLee.javaSpringBoot.config;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration   //代表是一个配置类
@AutoConfigureAfter(WebMvcAutoConfiguration.class)   //表示在该类之后配置，优先级更高
public class WebMvcConfig {

    @Value("${server.http.port}")
    private int httpPort;

    //1、为http新建连接器，因为配置了ssl证书，http访问不了
    @Bean    //返回的是一个bean，所以要加注解@Bean，注册为容器的一个Bean配置
    public Connector connector(){
        Connector connector = new Connector();
        connector.setPort(httpPort);   //为http设置端口80
        connector.setScheme("http");   //设置前缀名为http
        return connector;
    }

    //2、将http连接器设置到我们的容器里面去，重写接口
    @Bean
    public ServletWebServerFactory webServerFactory(){
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addAdditionalTomcatConnectors(connector());  //添加进来
        return tomcat;   //返回一个TomcatwebServlet工厂
    }
}

