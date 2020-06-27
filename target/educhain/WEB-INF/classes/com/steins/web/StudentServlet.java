package com.steins.web;


import com.steins.annotation.Anno;
import com.steins.entity.InfoHeader;
import com.steins.entity.Page;
import com.steins.entity.SystemLog;
import com.steins.entity.User;
import com.steins.service.LogServiceInterface;
import com.steins.service.UserServiceInterface;
import com.steins.util.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentServlet {

    @Autowired
    UserServiceInterface userServiceInterface;

    @Autowired
    LogServiceInterface logServiceInterface;

    private Logger logger= LoggerFactory.getLogger(StudentServlet.class);

    //根据id查对应的该学生所有信息
    @ResponseBody
    @RequestMapping("/getInfo")
    public Map<String,Object> getAllInfoById(@RequestParam("idNumber")String idNumber,
                                             @RequestParam("pageNum")int pageNum,
                                             @RequestParam("pageSize")int pageSize) throws IOException {
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> infoMap = new HashMap<>();
        User user;
        try {
            infoMap= userServiceInterface.getStudentInfo(idNumber,pageNum,pageSize);
            user = userServiceInterface.getUser(idNumber);
        }catch (Exception ex){
            ex.getMessage();
            logger.error(ex.toString());
            result.put("errMsg","系统出错！");
            result.put("success",false);
            return result;
        }
        if (user != null) {
            result.put("user",user);
            result.put("infoMap",infoMap);
            result.put("success",true);
        }else {
            result.put("errMsg","查无此人！");
            result.put("success",false);
        }

        return result;
    }

    @ResponseBody
    @RequestMapping("/getCompetitionInfo")
    public Map<String,Object> getCompetitionInfoById(@RequestParam("idNumber")String idNumber,
                                             @RequestParam("pageNum")int pageNum,
                                             @RequestParam("pageSize")int pageSize) throws IOException {
        Map<String,Object> result = new HashMap<>();
        Page studentCompetition;
        try {
             studentCompetition= userServiceInterface.getStudentCompetition(idNumber, pageNum, pageSize);
        }catch (Exception ex){
            ex.getMessage();
            logger.error(ex.toString());
            result.put("success",false);
            result.put("errMsg","系统出错 ！");
            return result;
        }
        result.put("competition",studentCompetition);
        result.put("success",true);
        return result;
    }

    @ResponseBody
    @RequestMapping("/getExamInfo")
    public Map<String,Object> getExamInfoById(@RequestParam("idNumber")String idNumber,
                                                     @RequestParam("pageNum")int pageNum,
                                                     @RequestParam("pageSize")int pageSize) throws IOException {
        Map<String,Object> result = new HashMap<>();
        Page studentExam;
        try {
            studentExam = userServiceInterface.getStudentExam(idNumber, pageNum, pageSize);
        }catch (Exception ex){
            ex.getMessage();
            logger.error(ex.toString());
            result.put("success",false);
            result.put("errMsg"," 系统出错！");
            return result;
        }
        result.put("exam",studentExam);
        result.put("success",true);
        return result;
    }

    @ResponseBody
    @RequestMapping("/getInternshipInfo")
    public Map<String,Object> getInternshipInfoById(@RequestParam("idNumber")String idNumber,
                                                     @RequestParam("pageNum")int pageNum,
                                                     @RequestParam("pageSize")int pageSize) throws IOException {
        Map<String,Object> result = new HashMap<>();

        Page studentInternship;
        try {
            studentInternship= userServiceInterface.getStudentInternship(idNumber, pageNum, pageSize);
        }catch (Exception ex){
            ex.getMessage();
            logger.error(ex.toString());
            result.put("success",false);
            result.put("errMsg","系统出错！ ");
            return result;
        }
        result.put("internship",studentInternship);
        result.put("success",true);
        return result;
    }

    @ResponseBody
    @RequestMapping("/getLog")
    public Map<String,Object> getOperationLog (@RequestParam("pageNum") int pageNum) throws IOException {
        //默认一页有五条数据
        System.out.println("hello pagenUm");
        Map<String,Object> result = new HashMap<>();
        int pageSize = 5;
        Page<SystemLog> allLogs = logServiceInterface.getAllLogs(pageNum,pageSize);
        result.put("allLogs",allLogs);
        result.put("success",true);
        return result;
    }



    @ResponseBody
    @RequestMapping("/updateUserInfo")
    public Map<String,Object> updateUserInfo (String username,String password,String nickname,int rating,int sex,String idNumber,String tel){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setNickname(nickname);
        user.setRating(rating);
        user.setSex(sex);
        user.setIdNumber(idNumber);
        user.setTel(tel);
        Map<String,Object> result = new HashMap<>();
        boolean status;
        try{
            int ifSucceed = userServiceInterface.updateUser(user);
            if (ifSucceed == 0) {
                status = false;
            }else {
                status = true;
            }
        }catch (Exception ex){
            ex.getMessage();
            logger.error(ex.toString());
            result.put("success",false);
            result.put("errMsg","系统出错！");
            return result;
        }
        result.put("success",status);
        return result;
    }


    @ResponseBody
    @RequestMapping("/getInfoHeaderById")
    public Map<String,Object> getInfoHeaderById (@RequestParam("idNumber") String idNumber) throws IOException {
        Map<String,Object> result = new HashMap<>();

        InfoHeader infoHeader = userServiceInterface.getInfoHeaderByIdNumber(idNumber);
        if (infoHeader != null) {
            result.put("success",true);
        }else{
            result.put("success",false);
            result.put("errMsg","该id不存在!");
        }
        result.put("infoHeader",infoHeader);
        return result;
    }


    @ResponseBody
    @RequestMapping("/getStudentsOfInstitution")
    public Map<String,Object> getStudentsOfInstitution (@RequestParam("idNumber") String idNumber,@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize) throws IOException {
        Map<String,Object> result = new HashMap<>();
        Page studentsOfInstitution = null;
        try {
             studentsOfInstitution = userServiceInterface.getStudentsOfInstitution(idNumber, pageNum, pageSize);
        } catch (Exception ex){
            logger.error(ex.toString());
            result.put("success",false);
            result.put("errMsg","系统错误!");
            return result;
        }
        if (studentsOfInstitution != null) {
            result.put("success",true);
        }else{
            result.put("success",false);
            result.put("errMsg","该机构无学生!");
        }
        result.put("studentsOfInstitution",studentsOfInstitution);
        return result;
    }

    @ResponseBody
    @RequestMapping("/insertStudentOfInstitution")
    public Map<String,Object> insertStudentOfInstitution (@RequestParam("studentIdNumber") String studentIdNumber,@RequestParam("institutionIdNumber") String institutionIdNumber) throws IOException {
        Map<String,Object> result = new HashMap<>();
        int flag;
        try {
            flag = userServiceInterface.insertStudentOfInstitution(studentIdNumber,institutionIdNumber);
        } catch (Exception ex){
            logger.error(ex.toString());
            result.put("success",false);
            result.put("errMsg","系统错误!");
            return result;
        }
        if (flag == 1) {
            result.put("success",true);
        }else{
            result.put("success",false);
            result.put("errMsg","添加失败!");
        }
        return result;
    }


    @ResponseBody
    @RequestMapping("/getMessageOfTxByIdNumber")
    public Map<String,Object> getMessageOfTx (@RequestParam("idNumber") String idNumber) throws IOException {
        Map<String,Object> result = new HashMap<>();
        String message;
        InfoHeader infoHeader;
        try {
             infoHeader= userServiceInterface.getInfoHeadById(idNumber);
             message = Account.getTransaction(infoHeader.getContractAddress());
             message =  Account.hexStr2Str(message);
        } catch (Exception ex){
            logger.error(ex.toString());
            result.put("success",false);
            result.put("errMsg","系统错误!");
            return result;
        }

        infoHeader.setDirTitle(message);
        result.put("success",true);
        result.put("infoHeader",infoHeader);
        return result;
    }

}