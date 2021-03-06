package com.jtechnologies.labs5.beans;

import com.jtechnologies.labs5.models.Exam;
import com.jtechnologies.labs5.service.ExamService;
import com.jtechnologies.labs5.service.StudentService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean(name = "SearchExamBean", eager = true)
@SessionScoped
public class SearchExamBean {

    private String transactionResult;
    private boolean examSubjectCriteria;
    private boolean timeframeCriteria;

    private String examSubject;
    private String timeFrame;

    private List<Exam> criteriaSearchResult;

    @Inject
    private ExamService examService;

    public void searchForExamByCriteria() {
        transactionResult = "Searched succesfully!";
        criteriaSearchResult = examService.searchByCriteria(examSubjectCriteria,examSubject,timeframeCriteria,timeFrame);
    }

    public String getTransactionResult() {
        return transactionResult;
    }


    public String getExamSubject() {
        return examSubject;
    }

    public void setExamSubject(String examSubject) {
        this.examSubject = examSubject;
    }

    public boolean isExamSubjectCriteria() {
        return examSubjectCriteria;
    }

    public void setExamSubjectCriteria(boolean examSubjectCriteria) {
        this.examSubjectCriteria = examSubjectCriteria;
    }


    public boolean isTimeframeCriteria() {
        return timeframeCriteria;
    }

    public void setTimeframeCriteria(boolean timeframeCriteria) {
        this.timeframeCriteria = timeframeCriteria;
    }

    public String getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(String timeFrame) {
        this.timeFrame = timeFrame;
    }

    public List<Exam> getCriteriaSearchResults() {
        return criteriaSearchResult;
    }

    public void setCriteriaSearchResult(List<Exam> criteriaSearchResult) {
        this.criteriaSearchResult = criteriaSearchResult;
    }
}
