package com.jsonLee.javaSpringBoot.modules.test.vo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 测试非全局配置文件
 */

@Component    //该注解表示受IOC容器管理，注册为我们的主件
@PropertySource("classpath:config/applicationTest.properties")  // 获取到applicationTest。properties配置文件的内容
@ConfigurationProperties(prefix = "com.qq")  //prefix是设置共同的前缀,就不用读value了，但是要保证变量和后缀一毛一样
public class ApplicationTest {
//    @Value("${com.qq.port}")
//    private int port;
//    @Value("${com.qq.name}")
//    private String name;
//    @Value("${com.qq.age}")
//    private int age;
//    @Value("${com.qq.desc}")
//    private String desc;
//    @Value("${com.qq.random}")
//    private String random;

    private int port;
    private String name;
    private int age;
    private String desc;
    private String random;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getRandom() {
        return random;
    }

    public void setRandom(String random) {
        this.random = random;
    }
}
