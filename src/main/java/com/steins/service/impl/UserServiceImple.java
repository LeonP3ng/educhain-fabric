package com.steins.service.impl;


import com.steins.annotation.Anno;
import com.steins.dao.UserDaoInterface;
import com.steins.entity.*;
import com.steins.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author  liup
 */

@Service
public class UserServiceImple implements UserServiceInterface {
    @Autowired
    UserDaoInterface userDaoInterface;

    public UserServiceImple() {
    }

    public User checkStudentLogin(String username, String password) {
        return this.userDaoInterface.loginUser(username, password);
    }

    @Transactional
    @Anno(
            operationName = "更改基本信息",
            operationType = "update"
    )
    public int updateUser(User user) {
        return this.userDaoInterface.updateUser(user);
    }

    @Anno(
            operationType = "select操作",
            operationName = "根据id查所有信息"
    )
    public Map<String, Object> getStudentInfo(String idNumber, int pageNum, int pageSize) {
        pageNum = pageNum * pageSize - pageSize;
        List<Competition> studentCompetition = this.userDaoInterface.getStudentCompetition(idNumber, pageNum, pageSize);
        List<Exam> studentExam = this.userDaoInterface.getStudentExam(idNumber, pageNum, pageSize);
        List<Internship> studentInternship = this.userDaoInterface.getStudentInternship(idNumber, pageNum, pageSize);
        Map<String, Object> result = new HashMap();
        result.put("competitionInfo", studentCompetition);
        result.put("examInfo", studentExam);
        result.put("internshipInfo", studentInternship);
        return result;
    }

    @Anno(
            operationType = "select操作",
            operationName = "根据id查竞赛信息"
    )
    public Page getStudentCompetition(String idNumber, int pageNum, int pageSize) {
        int competitionCount = this.userDaoInterface.getCompetitionCount(idNumber);
        Page page = new Page(pageNum, pageSize, competitionCount);
        pageNum = pageNum * pageSize - pageSize;
        List<Competition> studentCompetition = this.userDaoInterface.getStudentCompetition(idNumber, pageNum, pageSize);
        page.setList(studentCompetition);
        return page;
    }

    @Anno(
            operationType = "select操作",
            operationName = "根据id查考试信息"
    )
    public Page getStudentExam(String idNumber, int pageNum, int pageSize) {
        int examCount = this.userDaoInterface.getExamCount(idNumber);
        Page page = new Page(pageNum, pageSize, examCount);
        pageNum = pageNum * pageSize - pageSize;
        List<Exam> studentExam = this.userDaoInterface.getStudentExam(idNumber, pageNum, pageSize);
        page.setList(studentExam);
        return page;
    }

    @Anno(
            operationType = "select操作",
            operationName = "根据id查实习信息"
    )
    public Page getStudentInternship(String idNumber, int pageNum, int pageSize) {
        int internshipCount = this.userDaoInterface.getInternshipCount(idNumber);
        Page page = new Page(pageNum, pageSize, internshipCount);
        pageNum = pageNum * pageSize - pageSize;
        List<Internship> studentInternship = this.userDaoInterface.getStudentInternship(idNumber, pageNum, pageSize);
        page.setList(studentInternship);
        return page;
    }

    @Anno(
            operationType = "select操作",
            operationName = "根据id查区块信息"
    )
    public InfoHeader getInfoHeaderByIdNumber(String idNumber) {
        return this.userDaoInterface.getInfoHeaderByIdNumber(idNumber);
    }

    @Anno(
            operationType = "select操作",
            operationName = "根据id查个人基本信息"
    )
    public User getUser(String idNumber) {
        return this.userDaoInterface.getStudentInfo(idNumber);
    }
}
