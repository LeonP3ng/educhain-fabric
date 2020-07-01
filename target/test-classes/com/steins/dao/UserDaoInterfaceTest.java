package com.steins.dao;

import com.steins.BaseTest;
import com.steins.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserDaoInterfaceTest extends BaseTest {

    @Autowired
    private UserDaoInterface userDaoInterface;

    @Test
    public void loginUser() {
        User user  = userDaoInterface.loginUser("lp","123456");
        System.out.println(user);
    }

    @Test
    public void updateUser() {
        User user =new User();
        user.setIdNumber("20200701");
        user.setUsername("20200701");
        user.setPassword("123");
        user.setRating(1);
        System.out.println(userDaoInterface.updateUser(user));
    }

    @Test
    public void getStudentInfo() {
        System.out.println(userDaoInterface.getStudentInfo("20200702"));
    }

    @Test
    public void getStudentCompetition() {
        System.out.println(userDaoInterface.getStudentCompetition("2017013053",1,5));
    }

    @Test
    public void getStudentExam() {
        System.out.println(userDaoInterface.getStudentExam("2017013053",1,5));
    }

    @Test
    public void getStudentInternship() {
        System.out.println(userDaoInterface.getStudentInternship("2017013053",1,5));
    }

    @Test
    public void getCompetitionCount() {
        System.out.println(userDaoInterface.getCompetitionCount("2017013053"));
    }

    @Test
    public void getExamCount() {
        System.out.println(userDaoInterface.getExamCount("2017013053"));
    }

    @Test
    public void getInternshipCount() {
        System.out.println(userDaoInterface.getInternshipCount("2017013053"));
    }

    @Test
    public void getInfoHeaderByIdNumber() {
        System.out.println(userDaoInterface.getInfoHeaderByIdNumber("2017013053"));
    }
}