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

    @Override
    public User checkStudentLogin(String username, String password) {
        return userDaoInterface.loginUser(username, password);
    }

    @Override
    @Transactional
    @Anno(operationName = "更改基本信息",operationType = "update")
    public int updateUser(User user) {
        return userDaoInterface.updateUser(user);
    }

    @Override
    @Anno(operationType = "select操作",operationName = "根据id查所有信息")
    public Map<String,Object> getStudentInfo(String idNumber,int pageNum,int pageSize) {
        pageNum = pageNum * pageSize - pageSize;
        List<Competition> studentCompetition = userDaoInterface.getStudentCompetition(idNumber,pageNum,pageSize);
        List<Exam> studentExam =userDaoInterface.getStudentExam(idNumber,pageNum,pageSize);
        List<Internship> studentInternship = userDaoInterface.getStudentInternship(idNumber,pageNum,pageSize);
        Map<String,Object> result = new HashMap<>();
        result.put("competitionInfo",studentCompetition);
        result.put("examInfo",studentExam);
        result.put("internshipInfo",studentInternship);
        return result;
    }

    @Override
    @Anno(operationType = "select操作",operationName = "根据id查竞赛信息")
    public Page getStudentCompetition(String idNumber,int pageNum,int pageSize) {
        int competitionCount = userDaoInterface.getCompetitionCount(idNumber);
        Page page =new Page(pageNum,pageSize,competitionCount);
        pageNum = pageNum * pageSize - pageSize;
        List<Competition> studentCompetition = userDaoInterface.getStudentCompetition(idNumber, pageNum, pageSize);
        page.setList(studentCompetition);
        return page;
    }

    @Anno(operationType = "select操作",operationName = "根据id查考试信息")
    public Page getStudentExam(String idNumber,int pageNum,int pageSize) {
        int examCount = userDaoInterface.getExamCount(idNumber);
        Page page =new Page(pageNum,pageSize,examCount);
        pageNum = pageNum * pageSize - pageSize;
        List<Exam> studentExam = userDaoInterface.getStudentExam(idNumber, pageNum, pageSize);
        page.setList(studentExam);
        return page;
    }

    @Anno(operationType = "select操作",operationName = "根据id查实习信息")
    public Page getStudentInternship(String idNumber,int pageNum,int pageSize) {
        int internshipCount = userDaoInterface.getInternshipCount(idNumber);
        Page page =new Page(pageNum,pageSize,internshipCount);
        pageNum = pageNum * pageSize - pageSize;
        List<Internship> studentInternship= userDaoInterface.getStudentInternship(idNumber, pageNum, pageSize);
        page.setList(studentInternship);
        return page;
    }

    @Override
    @Anno(operationType = "select操作",operationName = "根据id查区块信息")
    public InfoHeader getInfoHeaderByIdNumber(String idNumber) {
        return userDaoInterface.getInfoHeaderByIdNumber(idNumber);
    }

    @Override
    public Page getStudentsOfInstitution(String idNumber, int pageNum, int pageSize) {
        int studentsOfInstitutionCount  = userDaoInterface.getStudentsOfInstitutionCount(idNumber);
        Page page = new Page(pageNum,pageSize,studentsOfInstitutionCount);
        pageNum = pageNum * pageSize - pageSize;
        List<User> studentsOfInstitution = userDaoInterface.getStudentsOfInstitution(idNumber, pageNum, pageSize);
        page.setList(studentsOfInstitution);
        return page;
    }

    @Override
    @Transactional
    public int insertStudentOfInstitution(String studentIdNumber, String institutionIdNumber) {
        return userDaoInterface.insertStudentOfInstitution(studentIdNumber,institutionIdNumber);
    }


    @Override
    @Anno(operationType = "select操作",operationName = "根据id查个人基本信息")
    public User getUser(String idNumber) {
        return userDaoInterface.getStudentInfo(idNumber);
    }



    @Override
    public InfoHeader getInfoHeadById(String idNumber) {
        return userDaoInterface.getInfoHeadById(idNumber);
    }




}
