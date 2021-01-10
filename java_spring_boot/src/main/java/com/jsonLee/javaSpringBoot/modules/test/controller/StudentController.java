package com.jsonLee.javaSpringBoot.modules.test.controller;

import com.jsonLee.javaSpringBoot.modules.common.vo.Result;
import com.jsonLee.javaSpringBoot.modules.test.entity.Student;
import com.jsonLee.javaSpringBoot.modules.test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 127.0.0.1/api/student  --- post
     * {"studentName":"JsonLee","studentCard":{"cardId":"1"}}    //因为是从前端传来的，所以要转为属性
     * @param student
     * @return
     */
    @PostMapping(value = "/student",consumes = "application/json")
    public Result<Student> insertStudent(@RequestBody Student student) {
        return studentService.insertStudent(student);
    }
}
