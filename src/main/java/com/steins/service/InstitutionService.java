package com.steins.service;

import com.steins.entity.*;
import org.springframework.stereotype.Service;

import javax.servlet.annotation.WebServlet;


public interface InstitutionService {
    int regist(User var1);

    //String checkRegist(String var1);

    int addExam(Exam var1);

    int addInternship(Internship var1);

    int addCompetition(Competition var1);

    int updExam(String var1, String var2, String var3, String var4, String var5);

    int updInternship(String var1, String var2, String var3, String var4);

    int updCompetition(String var1, String var2, String var3);

    Page getStudentsOfInstitution(String var1, int var2, int var3);

    int insertStudentOfInstitution(String var1, String var2);

}
