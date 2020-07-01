package com.steins.dao;

import com.steins.BaseTest;
import com.steins.entity.Competition;
import com.steins.entity.Exam;
import com.steins.entity.Internship;
import com.steins.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class InstitutionDaoTest extends BaseTest {

    @Autowired
    private InstitutionDao institutionDao;

    @Test
    public void regist() {
        User user =new User();
        user.setIdNumber("20200701");
        user.setUsername("20200701");
        user.setPassword("123");
        user.setRating(1);
        System.out.println(institutionDao.regist(user));
    }

    @Test
    public void addExam() {
        Exam exam = new Exam();
        exam.setExamName("test1");
        exam.setGrade("2017");
        exam.setRecorderId("2017013052");
        exam.setRecordTime("20200701");
        exam.setStudentId("2017");
        exam.setSubject("test");
        exam.setScore("80");
        exam.setRemark("test");
        System.out.println(institutionDao.addExam(exam));
    }

    @Test
    public void addInternship() {
        Internship internship= new Internship();
        internship.setCompanyName("test1");
        internship.setPeriod("2017");
        internship.setRecorderId("2017013052");
        internship.setRecordTime("20200701");
        internship.setStudentId("2017");
        System.out.println(institutionDao.addInternship(internship));
    }

    @Test
    public void addCompetition() {
        Competition competition =new Competition();
        competition.setAchievement("test");
        competition.setRecorderId("test");
        competition.setRecordTime("20200701");
        competition.setStudentId("2017");
        competition.setCompetitionName("test");
        competition.setCompetitionDegree("test");
        competition.setRemark("test");
        System.out.println(institutionDao.addCompetition(competition));
    }

    @Test
    public void updExam() {
        Exam exam = new Exam();
        exam.setExamName("test1");
        exam.setGrade("2017");
        exam.setRecorderId("2017013052");
        System.out.println(institutionDao.updExam("","","","",""));
    }

    @Test
    public void updInternship() {
        System.out.println(institutionDao.updInternship("","","",""));
    }

    @Test
    public void updCompetition() {
        System.out.println(institutionDao.updCompetition("","",""));
    }

    @Test
    public void getStudentsOfInstitution() {
        System.out.println(institutionDao.getStudentsOfInstitutionCount("test"));
    }

    @Test
    public void insertStudentOfInstitution() {
        System.out.println(institutionDao.insertStudentOfInstitution("test1","test2"));
    }

    @Test
    public void getStudentsOfInstitutionCount() {
        List<User> test = institutionDao.getStudentsOfInstitution("test", 2017, 2017);
        System.out.println(test.size());
    }
}