package com.steins.dao;


import com.steins.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.servlet.annotation.WebServlet;

@Repository
@WebServlet(name = "InstitutionDao")
public interface InstitutionDao {
    public int regist(User user);
    public User login(@Param("username") String username);
    public int addExam(Exam exam);
    public int addInternship(Internship internship);
    public int addCompetition(Competition competition);
    public int updExam(@Param("uptdate") String uptdate, @Param("examName") String examName, @Param("studentId") String studentId, @Param("grade") String grade, @Param("subject") String subject);
    public int updInternship(@Param("uptdate") String uptdate, @Param("companyName") String companyName, @Param("period") String period, @Param("studentId") String studentId);
    public int updCompetition(@Param("uptdate") String uptdate, @Param("competitionName") String competitionName, @Param("studentId") String studentId);


    int addInfoHeader(InfoHeader infoHeader);
}
