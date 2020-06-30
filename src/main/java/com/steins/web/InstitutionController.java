package com.steins.web;


import com.steins.annotation.Anno;
import com.steins.entity.*;
import com.steins.service.InstitutionService;
import com.steins.service.impl.InstitutionServiceImp;
import com.steins.util.IPFSdemo;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/Institution")
public class InstitutionController {
    @Autowired
    InstitutionService institutionServiceImp;

    Logger logger = LoggerFactory.getLogger(InstitutionController.class);

    @RequestMapping(
            value = {"/identification"},
            method = {RequestMethod.POST}
    )
    @ResponseBody
    public Map<String, Object> identification(HttpServletRequest request, @RequestParam("username") String username, @RequestParam("rating") int rating, @RequestParam("password") String password, @RequestParam("idNumber") String idNumber) throws ServletException, IOException {
        Map<String, Object> result = new HashMap();
        User user = new User();
        if (username != null && password != null && idNumber != null) {
            user.setUsername(username);
            user.setPassword(password);
            user.setRating(rating);
            user.setIdNumber(idNumber);
            boolean var8 = false;

            int flag;
            try {
                flag = this.institutionServiceImp.regist(user);
            } catch (Exception var10) {
                var10.getStackTrace();
                this.logger.error(var10.toString());
                result.put("errMsg", "系统出错!");
                result.put("success", false);
                return result;
            }

            if (flag == 1) {
                result.put("success", true);
            } else {
                result.put("success", false);
            }
        } else {
            result.put("errMsg", "请提交完整的信息表！");
            result.put("success", false);
        }

        return result;
    }

    @RequestMapping(
            value = {"/addExam"},
            method = {RequestMethod.POST}
    )
    @ResponseBody
    public Map<String, Object> addExam(HttpServletRequest request, @RequestParam("examData") String list) throws ServletException, IOException {
        Map<String, Object> result = new HashMap();
        JSONArray examList = JSONArray.fromObject(list);
        IPFSdemo ipfSdemo = new IPFSdemo();
        File tempfile = new File("ipfsfile");

        try {
            if (!tempfile.exists()) {
                tempfile.createNewFile();
            }

            FileWriter resultFile = new FileWriter(tempfile);
            PrintWriter myFile = new PrintWriter(resultFile);
            myFile.println(list.toString());
            myFile.flush();
            resultFile.close();
        } catch (IOException var14) {
            System.err.println("IPFS文件写入出错");
        }

        String ipfsHash = ipfSdemo.upload(tempfile);
        result.put("ipfsHash", ipfsHash);
        tempfile.delete();
        int flag = 1;

        for(int i = 0; i < examList.size(); ++i) {
            Exam exam = new Exam();
            String id = ((User)request.getSession().getAttribute("user")).getIdNumber();
            exam.setRecorderId(id);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            exam.setRecordTime(df.format(new Date()));
            exam.setStudentId((String)examList.getJSONObject(i).get("studentId"));
            exam.setSubject((String)examList.getJSONObject(i).get("subject"));
            exam.setGrade((String)examList.getJSONObject(i).get("grade"));
            exam.setExamName((String)examList.getJSONObject(i).get("examName"));
            exam.setScore((String)examList.getJSONObject(i).get("score"));
            exam.setRemark((String)examList.getJSONObject(i).get("remark"));

            try {
                flag = this.institutionServiceImp.addExam(exam);
                if (flag == 0) {
                    result.put("success", false);
                    break;
                }
            } catch (Exception var15) {
                var15.getStackTrace();
                this.logger.error(var15.toString());
                result.put("errMsg", "系统出错！");
                result.put("success", false);
            }
        }

        if (flag == 1) {
            result.put("success", true);
        } else {
            result.put("success", false);
        }

        return result;
    }

    @RequestMapping(
            value = {"/addInternship"},
            method = {RequestMethod.POST}
    )
    @ResponseBody
    public Map<String, Object> addInternship(HttpServletRequest request, @RequestParam("internshipData") String list) throws ServletException, IOException {
        Map<String, Object> result = new HashMap();
        JSONArray internshipList = JSONArray.fromObject(list);
        IPFSdemo ipfSdemo = new IPFSdemo();
        File tempfile = new File("ipfsfile");

        try {
            if (!tempfile.exists()) {
                tempfile.createNewFile();
            }

            FileWriter resultFile = new FileWriter(tempfile);
            PrintWriter myFile = new PrintWriter(resultFile);
            myFile.println(list.toString());
            myFile.flush();
            resultFile.close();
        } catch (IOException var14) {
            System.err.println("IPFS文件写入出错");
        }

        String ipfsHash = ipfSdemo.upload(tempfile);
        result.put("ipfsHash", ipfsHash);
        tempfile.delete();
        int flag = 1;

        for(int i = 0; i < internshipList.size(); ++i) {
            Internship internship = new Internship();
            String id = ((User)request.getSession().getAttribute("user")).getIdNumber();
            internship.setRecorderId(id);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            internship.setRecordTime(df.format(new Date()));
            internship.setCompanyName((String)internshipList.getJSONObject(i).get("companyName"));
            internship.setPeriod((String)internshipList.getJSONObject(i).get("period"));
            internship.setStudentId((String)internshipList.getJSONObject(i).get("studentId"));
            internship.setRemark((String)internshipList.getJSONObject(i).get("remark"));

            try {
                flag = this.institutionServiceImp.addInternship(internship);
                if (flag == 0) {
                    result.put("success", false);
                    break;
                }
            } catch (Exception var15) {
                var15.getStackTrace();
                this.logger.error(var15.toString());
                result.put("success", false);
                result.put("errMsg", "系统出错！");
            }
        }

        if (flag == 1) {
            result.put("success", true);
        } else {
            result.put("success", false);
        }

        return result;
    }

    @RequestMapping(
            value = {"/addCompetition"},
            method = {RequestMethod.POST}
    )
    @ResponseBody
    public Map<String, Object> addCompetition(HttpServletRequest request, @RequestParam("competitionData") String list) throws ServletException, IOException {
        Map<String, Object> result = new HashMap();
        JSONArray competitionList = JSONArray.fromObject(list);
        IPFSdemo ipfSdemo = new IPFSdemo();
        File tempfile = new File("ipfsfile");

        try {
            if (!tempfile.exists()) {
                tempfile.createNewFile();
            }

            FileWriter resultFile = new FileWriter(tempfile);
            PrintWriter myFile = new PrintWriter(resultFile);
            myFile.println(list.toString());
            myFile.flush();
            resultFile.close();
        } catch (IOException var14) {
            System.err.println("IPFS文件写入出错");
        }

        String ipfsHash = ipfSdemo.upload(tempfile);
        result.put("ipfsHash", ipfsHash);
        tempfile.delete();
        int flag = 1;

        for(int i = 0; i < competitionList.size(); ++i) {
            Competition competition = new Competition();
            String id = ((User)request.getSession().getAttribute("user")).getIdNumber();
            competition.setRecorderId(id);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            competition.setRecordTime(df.format(new Date()));
            competition.setStudentId((String)competitionList.getJSONObject(i).get("studentId"));
            competition.setCompetitionName((String)competitionList.getJSONObject(i).get("competitionName"));
            competition.setCompetitionDegree((String)competitionList.getJSONObject(i).get("competitionDegree"));
            competition.setAchievement((String)competitionList.getJSONObject(i).get("achievement"));
            competition.setRemark((String)competitionList.getJSONObject(i).get("remark"));

            try {
                flag = this.institutionServiceImp.addCompetition(competition);
                if (flag == 0) {
                    result.put("success", false);
                    break;
                }
            } catch (Exception var15) {
                var15.getStackTrace();
                this.logger.error(var15.toString());
                result.put("success", false);
                result.put("errMsg", "系统出错！");
            }
        }

        if (flag == 1) {
            result.put("success", true);
        } else {
            result.put("success", false);
        }

        return result;
    }

    @RequestMapping(
            value = {"updExam"},
            method = {RequestMethod.POST}
    )
    @ResponseBody
    public Map<String, Object> updExam(HttpServletRequest request, @RequestParam("examData") String list) throws ServletException, IOException {
        Map<String, Object> result = new HashMap();
        JSONArray examList = JSONArray.fromObject(list);
        int flag = 1;

        for(int i = 0; i < examList.size(); ++i) {
            try {
                String uptdate = (String)examList.getJSONObject(i).get("uptdate");
                String examName = (String)examList.getJSONObject(i).get("examName");
                String studentId = (String)examList.getJSONObject(i).get("studentId");
                String grade = (String)examList.getJSONObject(i).get("grade");
                String subject = (String)examList.getJSONObject(i).get("subject");
                flag = this.institutionServiceImp.updExam(uptdate, examName, studentId, grade, subject);
                if (flag == 0) {
                    result.put("success", false);
                    break;
                }
            } catch (Exception var12) {
                var12.getStackTrace();
                this.logger.error(var12.toString());
                result.put("success", false);
                result.put("errMsg", "系统出错！");
            }
        }

        if (flag == 1) {
            result.put("success", true);
        } else {
            result.put("success", false);
        }

        return result;
    }

    @RequestMapping(
            value = {"updInternship"},
            method = {RequestMethod.POST}
    )
    @ResponseBody
    public Map<String, Object> updInternship(HttpServletRequest request, @RequestParam("internshipData") String list) throws ServletException, IOException {
        Map<String, Object> result = new HashMap();
        JSONArray internshipList = JSONArray.fromObject(list);
        int flag = 1;

        for(int i = 0; i < internshipList.size(); ++i) {
            try {
                String uptdate = (String)internshipList.getJSONObject(i).get("uptdate");
                String companyName = (String)internshipList.getJSONObject(i).get("companyName");
                String period = (String)internshipList.getJSONObject(i).get("period");
                String studentId = (String)internshipList.getJSONObject(i).get("studentId");
                flag = this.institutionServiceImp.updInternship(uptdate, companyName, period, studentId);
                if (flag == 0) {
                    result.put("success", false);
                    break;
                }
            } catch (Exception var11) {
                var11.getStackTrace();
                this.logger.error(var11.toString());
                result.put("success", false);
                result.put("errMsg", "系统出错！");
            }
        }

        if (flag == 1) {
            result.put("success", true);
        } else {
            result.put("success", false);
        }

        return result;
    }

    @RequestMapping(
            value = {"updCompetition"},
            method = {RequestMethod.POST}
    )
    @ResponseBody
    public Map<String, Object> updCompetition(HttpServletRequest request, @RequestParam("competitionData") String list) throws ServletException, IOException {
        Map<String, Object> result = new HashMap();
        JSONArray competitionList = JSONArray.fromObject(list);
        int flag = 1;

        for(int i = 0; i < competitionList.size(); ++i) {
            try {
                String uptdate = (String)competitionList.getJSONObject(i).get("uptdate");
                String competitionName = (String)competitionList.getJSONObject(i).get("competitionName");
                String studentId = (String)competitionList.getJSONObject(i).get("studentId");
                flag = this.institutionServiceImp.updCompetition(uptdate, competitionName, studentId);
                if (flag == 0) {
                    result.put("success", false);
                    break;
                }
            } catch (Exception var10) {
                var10.getStackTrace();
                this.logger.error(var10.toString());
                result.put("success", false);
                result.put("errMsg", "系统出错！");
            }
        }

        if (flag == 1) {
            result.put("success", true);
        } else {
            result.put("success", false);
        }

        return result;
    }



    @ResponseBody
    @RequestMapping({"/getStudentsOfInstitution"})
    public Map<String, Object> getStudentsOfInstitution(@RequestParam("idNumber") String idNumber, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) throws IOException {
        Map<String, Object> result = new HashMap();
        Page studentsOfInstitution = null;

        try {
            studentsOfInstitution = this.institutionServiceImp.getStudentsOfInstitution(idNumber, pageNum, pageSize);
        } catch (Exception var7) {
            this.logger.error(var7.toString());
            result.put("success", false);
            result.put("errMsg", "系统错误!");
            return result;
        }

        if (studentsOfInstitution != null) {
            result.put("success", true);
        } else {
            result.put("success", false);
            result.put("errMsg", "该机构无学生!");
        }

        result.put("studentsOfInstitution", studentsOfInstitution);
        return result;
    }

    @ResponseBody
    @RequestMapping({"/insertStudentOfInstitution"})
    public Map<String, Object> insertStudentOfInstitution(@RequestParam("studentIdNumber") String studentIdNumber, @RequestParam("institutionIdNumber") String institutionIdNumber) throws IOException {
        HashMap result = new HashMap();

        int flag;
        try {
            flag = this.institutionServiceImp.insertStudentOfInstitution(studentIdNumber, institutionIdNumber);
        } catch (Exception var6) {
            this.logger.error(var6.toString());
            result.put("success", false);
            result.put("errMsg", "系统错误!");
            return result;
        }

        if (flag == 1) {
            result.put("success", true);
        } else {
            result.put("success", false);
            result.put("errMsg", "添加失败!");
        }

        return result;
    }
}
