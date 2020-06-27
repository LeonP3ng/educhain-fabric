package com.steins.service.impl;


import com.steins.annotation.Anno;
import com.steins.dao.InstitutionDao;
import com.steins.entity.*;
import com.steins.service.InstitutionService;
import com.steins.util.Account;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.annotation.WebServlet;
import java.util.Date;

@Service
@WebServlet(name = "InstitutionServiceImp")
public class InstitutionServiceImp implements InstitutionService {
    @Resource
    InstitutionDao institutionDao;

    @Anno(operationName = "注册", operationType = "insert操作")
    public int regist(User user){
        return institutionDao.regist(user);
    }

    public boolean login(String username,String password){
        boolean flag = false;
        User user = institutionDao.login(username);
        if(password.equals(user.getPassword())&&user.getRating()!=3)
            flag=true;
        return flag;
    }

    @Anno(operationName = "增加考试信息", operationType = "insert操作")
    public int addExam(Exam exam){
         int i =institutionDao.addExam(exam);
        String data = Account.str2HexStr(exam.toString());
        String txHash =  Account.sendTransaction(data);
        InfoHeader infoHeader = new InfoHeader();
        Date date = new Date();
        infoHeader.setInsertTime(date.toString());
        infoHeader.setContractAddress(txHash);
        infoHeader.setIdNumber(exam.getStudentId());
        institutionDao.addInfoHeader(infoHeader);
        return i;
    }

    @Anno(operationName = "增加实习经历", operationType = "insert操作")
    public int addInternship(Internship internship){
        int i= institutionDao.addInternship(internship);

        String data = Account.str2HexStr(internship.toString());
        String txHash =  Account.sendTransaction(data);
        InfoHeader infoHeader = new InfoHeader();
        Date date = new Date();
        infoHeader.setInsertTime(date.toString());
        infoHeader.setContractAddress(txHash);
        infoHeader.setIdNumber(internship.getStudentId());
        institutionDao.addInfoHeader(infoHeader);
        return i;
    }

    @Anno(operationName = "增加竞赛信息", operationType = "insert操作")
    public int addCompetition(Competition competition){
        int i= institutionDao.addCompetition(competition);

        String data = Account.str2HexStr(competition.toString());
        String txHash =  Account.sendTransaction(data);
        InfoHeader infoHeader = new InfoHeader();
        Date date = new Date();
        infoHeader.setInsertTime(date.toString());
        infoHeader.setContractAddress(txHash);
        infoHeader.setIdNumber(competition.getStudentId());
        institutionDao.addInfoHeader(infoHeader);
        return i;
    }

    @Anno(operationName = "更新考试信息", operationType = "update操作")
    public int updExam(String uptdate,String examName,String studentId,String grade,String subject){
        return institutionDao.updExam(uptdate,examName,studentId,grade,subject);
    }

    @Anno(operationName = "更新实习信息", operationType = "update操作")
    public int updInternship(String uptdate,String companyName,String period,String studentId){
        return institutionDao.updInternship(uptdate,companyName,period,studentId);
    }


    @Anno(operationName = "更新竞赛信息", operationType = "update操作")
    public int updCompetition(String uptdate,String competitionName,String studentId){
        return institutionDao.updCompetition(uptdate,competitionName,studentId);
    }


    @Override
    @Transactional
    public int addInfoHeader(InfoHeader infoHeader) {
        return institutionDao.addInfoHeader(infoHeader);
    }


}
