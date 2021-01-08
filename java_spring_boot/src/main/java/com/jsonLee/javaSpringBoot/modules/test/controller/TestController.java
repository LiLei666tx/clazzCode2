package com.jsonLee.javaSpringBoot.modules.test.controller;

import com.jsonLee.javaSpringBoot.modules.test.vo.ApplicationTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*在编写完或者修改完一次代码的时候，
都需要点击上面的一个小锤头，rebuild我们的项目，
把java文件编译为class文件*/
@Controller
@RequestMapping("/test")  //是该controller模块访问的话，前面都要加上/test
public class TestController {

    private final static Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Value("${server.port}")
    private int port;
    @Value("${com.name}")
    private String name;
    @Value("${com.age}")
    private int age;
    @Value("${com.desc}")
    private String desc;
    @Value("${com.random}")
    private String random;

    //注入
    @Autowired
    private ApplicationTest applicationTest;

    /**
     * 127.0.0.1:8085/test/logTest
     * @return
     */
    @GetMapping("/logTest")
    @ResponseBody
    public String logTest(){
        LOGGER.trace("this is trace log");
        LOGGER.debug("this is debug log");
        LOGGER.info("this is info log");
        LOGGER.warn("this is warn log");
        LOGGER.error("this is error log");
        return "This is log test";
    }

    /**
     * 127.0.0.1:8085/test/testValue
     * @return
     */
    @GetMapping("/testValue")
    @ResponseBody
    public String testValue(){
       // return port + "==" + name + "==" + age + "==" + desc + "==" + random;
        StringBuffer sb = new StringBuffer();
        return sb.append(port).append("-----")
                 .append(name).append("-----")
                 .append(age).append("-----")
                 .append(desc).append("-----")
                 .append(random).append("-----").append("<br>")
                .append(applicationTest.getPort()).append("-----")  //使用注入的对象去调用该对象的方法获取到相关的配置内容
                .append(applicationTest.getName()).append("-----")
                .append(applicationTest.getAge()).append("-----")
                .append(applicationTest.getDesc()).append("-----")
                .append(applicationTest.getRandom()).append("-----").toString();
   }

    /**
     * 127.0.0.1:8085/test/testDesc  ----  get
     * @return
     */
    @GetMapping("/testDesc")
    @ResponseBody  //该接口返回的不是view层，所以我们要加上@ResponseBody注解，代表返回的是一个数据，这里是String类型的数据而已
    public String testDesc(){
        return "This is for test modules";
    }
}
