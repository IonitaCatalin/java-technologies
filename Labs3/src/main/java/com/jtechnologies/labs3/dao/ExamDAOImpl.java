package com.jtechnologies.labs3.dao;

import com.jtechnologies.labs3.models.Exam;
import com.jtechnologies.labs3.utils.PostgresRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExamDAOImpl implements ExamDAO {

    private final PostgresRepository postgresRepository;

    public ExamDAOImpl() {
        postgresRepository = PostgresRepository.get();
    }

    @Override
    public List<Exam> getExams() {

        List<Exam> exams = new ArrayList<>();
        ResultSet resultSet = postgresRepository.run("SELECT * FROM EXAMS;");

        while(true){
            try {
                if (!resultSet.next())
                {
                    break;
                }
                exams.add(new Exam(
                        Integer.parseInt(resultSet.getString("id")),
                        resultSet.getString("subject"),
                        resultSet.getString("starting"),
                        Integer.parseInt(resultSet.getString("duration"))));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return exams;
    }

    @Override
    public Exam getExamById(String id) {
        return null;
    }

    @Override
    public void removeExamById(String id) {
        String query = "";
    }

    @Override
    public void addExam(Exam exam) {

        String query = "INSERT INTO exams(subject,starting,duration) VALUES (" +
                "'"+ exam.getSubject() +"',"+
                "'"+ exam.getStarting() +"'," +
                "'" + exam.getDuration() +"'" + "); ";

        postgresRepository.run(query);
    }
}
