package com.jtechnologies.labs3.controllers;

import com.jtechnologies.labs3.dao.StudentDAO;
import com.jtechnologies.labs3.dao.StudentDAOImpl;
import com.jtechnologies.labs3.models.Student;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "StudentInputBean ", eager = false)
@RequestScoped
public class StudentInputBean {
    private String fullName;

    private StudentDAO studentDao;

    public StudentInputBean() {
        studentDao = new StudentDAOImpl();
    }

    public void submit() {
        studentDao.addStudent(new Student(fullName));
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
