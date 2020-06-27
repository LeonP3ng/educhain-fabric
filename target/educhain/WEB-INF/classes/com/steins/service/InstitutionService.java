package com.steins.service;

import com.steins.entity.*;
import org.springframework.stereotype.Service;

import javax.servlet.annotation.WebServlet;

@Service
@WebServlet(name = "InstitutionService")
public interface InstitutionService {
    public int regist(User user);
    public boolean login(String username, String password);
    public int addExam(Exam exam);
    public int addInternship(Internship internship);
    public int addCompetition(Competition competition);
    public int updExam(String uptdate, String test, String studentId, String grade, String subject);
    public int updInternship(String uptdate, String company, String period, String studentId);
    public int updCompetition(String uptdate, String competition, String studentId);


    int addInfoHeader(InfoHeader infoHeader);

}
