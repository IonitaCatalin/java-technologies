package com.jtechnologies.labs3.controllers;

import com.jtechnologies.labs3.dao.ExamDAO;
import com.jtechnologies.labs3.dao.ExamDAOImpl;
import com.jtechnologies.labs3.models.Exam;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "ExamInputBean", eager = false)
@RequestScoped
public class ExamInputBean {
    private String subject;
    private String starting;
    private int duration;

    ExamDAO examDao;

    public ExamInputBean() {
        examDao = new ExamDAOImpl();
    }

    public void submit() {
        examDao.addExam(new Exam(subject,starting,duration));
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

}
