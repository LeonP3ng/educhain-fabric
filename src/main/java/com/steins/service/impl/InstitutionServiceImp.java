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
import java.util.List;

@Service
@WebServlet(name = "InstitutionServiceImp")
public class InstitutionServiceImp implements InstitutionService {
    @Resource
    InstitutionDao institutionDao;

    public InstitutionServiceImp() {
    }

    @Anno(
            operationName = "注册",
            operationType = "insert操作"
    )
    public int regist(User user) {
        return this.institutionDao.regist(user);
    }

    public String checkRegist(String idNumber) {
        return this.institutionDao.checkRegist(idNumber);
    }

    @Anno(
            operationName = "增加考试信息",
            operationType = "insert操作"
    )
    @Transactional
    public int addExam(Exam exam) {
        return this.institutionDao.addExam(exam);
    }

    @Anno(
            operationName = "增加实习经历",
            operationType = "insert操作"
    )
    @Transactional
    public int addInternship(Internship internship) {
        return this.institutionDao.addInternship(internship);
    }

    @Anno(
            operationName = "增加竞赛信息",
            operationType = "insert操作"
    )
    @Transactional
    public int addCompetition(Competition competition) {
        return this.institutionDao.addCompetition(competition);
    }

    @Anno(
            operationName = "更新考试信息",
            operationType = "update操作"
    )
    @Transactional
    public int updExam(String uptdate, String examName, String studentId, String grade, String subject) {
        return this.institutionDao.updExam(uptdate, examName, studentId, grade, subject);
    }

    @Anno(
            operationName = "更新实习信息",
            operationType = "update操作"
    )
    @Transactional
    public int updInternship(String uptdate, String companyName, String period, String studentId) {
        return this.institutionDao.updInternship(uptdate, companyName, period, studentId);
    }

    @Anno(
            operationName = "更新竞赛信息",
            operationType = "update操作"
    )
    @Transactional
    public int updCompetition(String uptdate, String competitionName, String studentId) {
        return this.institutionDao.updCompetition(uptdate, competitionName, studentId);
    }

    public Page getStudentsOfInstitution(String idNumber, int pageNum, int pageSize) {
        int studentsOfInstitutionCount = this.institutionDao.getStudentsOfInstitutionCount(idNumber);
        Page page = new Page(pageNum, pageSize, studentsOfInstitutionCount);
        pageNum = pageNum * pageSize - pageSize;
        List<User> studentsOfInstitution = this.institutionDao.getStudentsOfInstitution(idNumber, pageNum, pageSize);
        page.setList(studentsOfInstitution);
        return page;
    }

    @Transactional
    @Anno(
            operationName = "插入学生和组织的映射",
            operationType = "insert操作"
    )
    public int insertStudentOfInstitution(String studentIdNumber, String institutionIdNumber) {
        return this.institutionDao.insertStudentOfInstitution(studentIdNumber, institutionIdNumber);
    }
}