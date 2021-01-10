package com.jsonLee.javaSpringBoot.modules.test.service;

import com.jsonLee.javaSpringBoot.modules.common.vo.Result;
import com.jsonLee.javaSpringBoot.modules.test.entity.Student;

public interface StudentService {
    Result<Student> insertStudent(Student student);
}
