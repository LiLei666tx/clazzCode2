package com.jsonLee.javaSpringBoot.modules.test.service.impl;

import com.jsonLee.javaSpringBoot.modules.common.vo.Result;
import com.jsonLee.javaSpringBoot.modules.test.entity.Card;
import com.jsonLee.javaSpringBoot.modules.test.entity.Student;
import com.jsonLee.javaSpringBoot.modules.test.repository.StudentRepository;
import com.jsonLee.javaSpringBoot.modules.test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public Result<Student> insertStudent(Student student) {
        student.setCreateDate(LocalDateTime.now());   //因为表中使用的时间类型是localTime
        studentRepository.saveAndFlush(student);
        return new Result<Student>(Result.ResultStatus.SUCCESS.status,
                "Insert success",student);
    }
}
