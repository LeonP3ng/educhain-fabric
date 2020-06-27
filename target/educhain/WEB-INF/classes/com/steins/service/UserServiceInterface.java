package com.steins.service;


import com.steins.entity.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface UserServiceInterface {
    //学生登录验证
    User checkStudentLogin(String username, String password);

    //学生信息更改
    int updateUser(User user);



    //查看用户名，密码等基本信息
    User getUser(String idNumber);

    //查询 导出竞赛，考试，实习信息,是下面三个的总和
    Map<String,Object> getStudentInfo(String idNumber,int pageNum,int pageSize);

    Page getStudentCompetition(String idNumber, int pageNum, int pageSize);

    Page getStudentExam(String idNumber, int pageNum, int pageSize);

    Page getStudentInternship(String idNumber, int pageNum, int pageSize);

    InfoHeader getInfoHeaderByIdNumber(String idNumber);


    Page getStudentsOfInstitution(String idNumber, int pageNum, int pageSize);

    int insertStudentOfInstitution(String studentIdNumber,String institutionIdNumber);

    InfoHeader getInfoHeadById(String idNumber);


}
