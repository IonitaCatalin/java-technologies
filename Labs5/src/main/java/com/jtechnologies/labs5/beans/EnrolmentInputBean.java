package com.jtechnologies.labs5.beans;

import com.jtechnologies.labs5.exception.EnrolmentInvalidExamException;
import com.jtechnologies.labs5.exception.EnrolmentInvalidStudentException;
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

    private String transactionResult;

    @Inject
    private EnrolmentService enrolmentService;


    public void submit() {
        try {
            enrolmentService.addEnrolment(new Enrolment(studentId,examId));
            transactionResult = "Enrolment added successfully!";
        } catch (EnrolmentInvalidExamException | EnrolmentInvalidStudentException e) {
            transactionResult = e.getMessage();
        }
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

    public String getTransactionResult() {
        return transactionResult;
    }
}
