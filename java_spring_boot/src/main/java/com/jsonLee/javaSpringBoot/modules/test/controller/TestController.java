package com.jsonLee.javaSpringBoot.modules.test.controller;

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

    /**
     * 127.0.0.1:8080/test/testDesc  ----  get
     * @return
     */
    @GetMapping("/testDesc")
    @ResponseBody  //该接口返回的不是view层，所以我们要加上@ResponseBody注解，代表返回的是一个数据，这里是String类型的数据而已
    public String testDesc(){
        return "This is for test modules";
    }
}
