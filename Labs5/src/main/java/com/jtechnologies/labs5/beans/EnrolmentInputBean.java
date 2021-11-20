package com.jtechnologies.labs5.beans;

import com.jtechnologies.labs5.service.EnrolmentService;
import com.jtechnologies.labs5.models.Enrolment;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

@ManagedBean(name = "EnrolmentInputBean", eager = false)
@RequestScoped
public class EnrolmentInputBean {

    private int studentId;
    private int examId;

    @Inject
    private EnrolmentService enrolmentService;


    public void submit() {
        enrolmentService.addEnrolment(new Enrolment(studentId,examId));
    }

    public int getStudentId() {
        return studentId;
    }

    public int getExamId() {
        return examId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }
}