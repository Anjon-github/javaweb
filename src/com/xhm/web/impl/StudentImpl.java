package com.xhm.web.impl;

import com.xhm.web.bean.Student;
import com.xhm.web.database.StudentBusiness;
import com.xhm.web.interfaces.StudentService;

import java.util.List;

public class StudentImpl implements StudentService{
    @Override
    public List<Student> getAllStudents() {
        return StudentBusiness.getAllStudents();
    }
}
