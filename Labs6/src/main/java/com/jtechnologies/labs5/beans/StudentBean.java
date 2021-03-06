package com.jtechnologies.labs5.beans;

import com.jtechnologies.labs5.repositories.StudentRepository;
import com.jtechnologies.labs5.models.Student;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean(name = "StudentBean", eager = false)
public class StudentBean {


    @EJB
    private StudentRepository studentRepository;

    private int id;

    public List<Student> getStudents() {
        return studentRepository.getStudents();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
