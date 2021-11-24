package com.jtechnologies.labs5.beans;

import com.jtechnologies.labs5.exception.ExamInvalidDuration;
import com.jtechnologies.labs5.models.Exam;
import com.jtechnologies.labs5.repositories.ExamRepository;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

@ManagedBean(name = "ExamInputBean", eager = false)
@RequestScoped
public class ExamInputBean {

    @EJB
    private ExamRepository examRepository;
    private String transactionResult;

    private String subject;
    private String starting;
    private int duration;

    public void submit() {
        try {
            examRepository.addExam(new Exam(subject,starting,duration));
            transactionResult = "Exam has been added successfully !";
        } catch (ExamInvalidDuration e) {
            transactionResult = e.getMessage();
        }

    }

    public String getSubject() {
        return subject;
    }
    public String getStarting() {
        return starting;
    }
    public int getDuration() {
        return duration;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setStarting(String starting) {
        this.starting = starting;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getTransactionResult() {
        return transactionResult;
    }
}
