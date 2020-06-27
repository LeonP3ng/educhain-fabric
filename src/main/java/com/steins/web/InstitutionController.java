package com.steins.web;


import com.steins.annotation.Anno;
import com.steins.entity.Competition;
import com.steins.entity.Exam;
import com.steins.entity.Internship;
import com.steins.entity.User;
import com.steins.service.InstitutionService;
import com.steins.service.impl.InstitutionServiceImp;
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
import java.io.IOException;
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

    @RequestMapping(value = "/identification",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> identification(HttpServletRequest request,
                                             @RequestParam("username")String username, @RequestParam("rating")int rating,
                                             @RequestParam("password")String password,@RequestParam("idNumber")String idNumber) throws ServletException, IOException {
        Map<String,Object> result = new HashMap<>();
        User user = new User();
        if(username!=null&&password!=null&&idNumber!=null) {
            user.setUsername(username);
            user.setPassword(password);
            user.setRating(rating);
            user.setIdNumber(idNumber);
            int flag=0;
            try {
                flag = institutionServiceImp.regist(user);
            }catch (Exception ex){
                ex.getStackTrace();
                logger.error(ex.toString());
                result.put("errMsg","系统出错!");
                result.put("success",false);
                return result;
            }
            if(flag==1)
                result.put("success",true);
            else
                result.put("success",false);
        }else {
            result.put("errMsg","请提交完整的信息表！");
            result.put("success", false);
        }
        return result;

    }

//   @RequestMapping(value = "/login")
//    @ResponseBody
//    public Map<String,Object> login(HttpServletRequest request,
//                      @RequestParam("username")String username, @RequestParam("password")String password)throws ServletException, IOException {
//        Map<String,Object> result = new HashMap<>();
//        Boolean flag ;
//        try{
//            flag = institutionServiceImp.login(username,password);
//        }catch (Exception ex){
//            ex.getStackTrace();
//            logger.error(ex.toString());
//            flag = false;
//            result.put("errMsg","系统出错!");
//            result.put("success",false);
//            return result;
//        }
//        if(flag){
//            result.put("success",true);
//            result.put("current_user",username);
//            request.getSession().setAttribute("current_user",username);
//        }else {
//            result.put("errMsg","账号密码不符！");
//            result.put("success",false);
//        }
//        return result;
//    }
//

    @RequestMapping(value = "/addExam",method = RequestMethod.POST)
    @ResponseBody
//    @RequestParam("recordTime")String recordTime, @RequestParam("recorderId")String recorderId,
//    @RequestParam("studentId")String studentId, @RequestParam("subject")String subject, @RequestParam("grade")String grade,
//    @RequestParam("examName")String examName,@RequestParam("score")String score,@RequestParam("remark")String remark
    public Map<String,Object> addExam(HttpServletRequest request, @RequestParam("examData") String list)throws ServletException, IOException {
        Map<String,Object> result = new HashMap<>();
        JSONArray examList = JSONArray.fromObject(list);
        int flag=1;
        for(int i=0;i<examList.size();i++) {
            Exam exam = new Exam();
            String id=((User)request.getSession().getAttribute("user")).getIdNumber();
            exam.setRecorderId(id);
//            exam.setRecorderId("123456test");
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            exam.setRecordTime( df.format(new Date()));
            exam.setStudentId((String)examList.getJSONObject(i).get("studentId"));
            exam.setSubject((String)examList.getJSONObject(i).get("subject"));
            exam.setGrade((String)examList.getJSONObject(i).get("grade"));
            exam.setExamName((String)examList.getJSONObject(i).get("examName"));
            exam.setScore((String)examList.getJSONObject(i).get("score"));
            exam.setRemark((String)examList.getJSONObject(i).get("remark"));
            try {
                flag=institutionServiceImp.addExam(exam);
                if(flag==0){
                    result.put("success",false);
                    break;
                }
            }catch (Exception ex){
                ex.getStackTrace();
                logger.error(ex.toString());
                result.put("errMsg","系统出错！");
                result.put("success",false);
            }
        }
        if(flag==1)
            result.put("success",true);
        else
            result.put("success",false);
        return result;
    }

    @RequestMapping(value = "/addInternship",method = RequestMethod.POST)
    @ResponseBody
//    @RequestParam("recordTime")String recordTime, @RequestParam("recorderId")String recorderId,@RequestParam("period")String period,
//    @RequestParam("studentId")String studentId, @RequestParam("companyName")String companyName,@RequestParam("remark")String remark
    public Map<String,Object> addInternship(HttpServletRequest request,@RequestParam("internshipData") String list)throws ServletException, IOException {
        Map<String,Object> result = new HashMap<>();
        JSONArray internshipList = JSONArray.fromObject(list);
        int flag=1;
        for(int i=0;i<internshipList.size();i++) {
            Internship internship = new Internship();
            String id=((User)request.getSession().getAttribute("user")).getIdNumber();
            internship.setRecorderId(id);
//            internship.setRecorderId("123456test");
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            internship.setRecordTime( df.format(new Date()));
            internship.setCompanyName((String)internshipList.getJSONObject(i).get("companyName"));
            internship.setPeriod((String)internshipList.getJSONObject(i).get("period"));
            internship.setStudentId((String)internshipList.getJSONObject(i).get("studentId"));
            internship.setRemark((String)internshipList.getJSONObject(i).get("remark"));
            try {
                flag = institutionServiceImp.addInternship(internship);
                if(flag==0){
                    result.put("success",false);
                    break;
                }
            } catch (Exception ex) {
                ex.getStackTrace();
                logger.error(ex.toString());
                result.put("success", false);
                result.put("errMsg", "系统出错！");
            }
        }
        if(flag==1)
            result.put("success",true);
        else
            result.put("success",false);
        return result;
    }


    @RequestMapping(value = "/addCompetition",method = RequestMethod.POST)
    @ResponseBody
//    @RequestParam("recordTime")String recordTime, @RequestParam("recorderId")String recorderId,
//    @RequestParam("studentId")String studentId, @RequestParam("competitionName")String competitionName,
//    @RequestParam("competitionDegree")String competitionDegree, @RequestParam("achievement")String achievement, @RequestParam("remark")String remark
    public Map<String,Object> addCompetition(HttpServletRequest request,@RequestParam("competitionData") String list)throws ServletException, IOException {
        Map<String, Object> result = new HashMap<>();
        JSONArray competitionList = JSONArray.fromObject(list);
        int flag = 1;
        for (int i = 0; i < competitionList.size(); i++) {
            Competition competition = new Competition();
            String id=((User)request.getSession().getAttribute("user")).getIdNumber();
            competition.setRecorderId(id);
//            competition.setRecorderId("123456test");
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            competition.setRecordTime(df.format(new Date()));
            competition.setStudentId((String) competitionList.getJSONObject(i).get("studentId"));
            competition.setCompetitionName((String) competitionList.getJSONObject(i).get("competitionName"));
            competition.setCompetitionDegree((String) competitionList.getJSONObject(i).get("competitionDegree"));
            competition.setAchievement((String) competitionList.getJSONObject(i).get("achievement"));
            competition.setRemark((String) competitionList.getJSONObject(i).get("remark"));
            try {
                flag = institutionServiceImp.addCompetition(competition);
                if (flag == 0) {
                    result.put("success", false);
                    break;
                }
            } catch (Exception ex) {
                ex.getStackTrace();
                logger.error(ex.toString());
                result.put("success", false);
                result.put("errMsg", "系统出错！");
            }
        }
        if (flag == 1)
            result.put("success", true);
        else
            result.put("success", false);
        return result;
    }


    @RequestMapping(value = "updExam",method = RequestMethod.POST)
    @ResponseBody
//    @RequestParam("uptdate")String uptdate, @RequestParam("examName")String examName,
//    @RequestParam("studentId")String studentId,@RequestParam("grade")String grade,@RequestParam("subject")String subject
    public Map<String,Object> updExam(HttpServletRequest request,@RequestParam("examData")String list)throws ServletException, IOException{
        Map<String, Object> result = new HashMap<>();
        JSONArray examList = JSONArray.fromObject(list);
        int flag=1;
        for(int i=0;i<examList.size();i++) {
            try {
                String uptdate=(String)examList.getJSONObject(i).get("uptdate");
                String examName=(String)examList.getJSONObject(i).get("examName");
                String studentId=(String)examList.getJSONObject(i).get("studentId");
                String grade=(String)examList.getJSONObject(i).get("grade");
                String subject=(String)examList.getJSONObject(i).get("subject");
                flag = institutionServiceImp.updExam(uptdate, examName, studentId, grade, subject);
                if (flag == 0) {
                    result.put("success", false);
                    break;
                }
            } catch (Exception ex) {
                ex.getStackTrace();
                logger.error(ex.toString());
                result.put("success", false);
                result.put("errMsg", "系统出错！");
            }
        }
        if(flag==1)
            result.put("success",true);
        else
            result.put("success",false);
        return result;
    }

    @RequestMapping(value = "updInternship",method = RequestMethod.POST)
    @ResponseBody
//    @RequestParam("uptdate")String uptdate, @RequestParam("companyName")String companyName,
//    @RequestParam("period")String period, @RequestParam("studentId")String studentId
    public Map<String,Object> updInternship(HttpServletRequest request,@RequestParam("internshipData")String list)throws ServletException, IOException{
        Map<String, Object> result = new HashMap<>();
        JSONArray internshipList = JSONArray.fromObject(list);
        int flag=1;
        for(int i=0;i<internshipList.size();i++) {
            try {
                String uptdate=(String)internshipList.getJSONObject(i).get("uptdate");
                String companyName=(String)internshipList.getJSONObject(i).get("companyName");
                String period=(String)internshipList.getJSONObject(i).get("period");
                String studentId=(String)internshipList.getJSONObject(i).get("studentId");
                flag=institutionServiceImp.updInternship(uptdate, companyName, period, studentId);
                if (flag == 0) {
                    result.put("success", false);
                    break;
                }
            } catch (Exception ex) {
                ex.getStackTrace();
                logger.error(ex.toString());
                result.put("success", false);
                result.put("errMsg", "系统出错！");
            }
        }
        if(flag==1)
            result.put("success",true);
        else
            result.put("success",false);
        return result;
    }

    @RequestMapping(value = "updCompetition",method = RequestMethod.POST)
    @ResponseBody
//    @RequestParam("uptdate")String uptdate, @RequestParam("competitionName")String competitionName,
//    @RequestParam("studentId")String studentId
    public Map<String,Object> updCompetition(HttpServletRequest request,@RequestParam("competitionData")String list)throws ServletException, IOException {
        Map<String, Object> result = new HashMap<>();
        JSONArray competitionList = JSONArray.fromObject(list);
        int flag = 1;
        for (int i = 0; i < competitionList.size(); i++) {
            try {
                String uptdate = (String) competitionList.getJSONObject(i).get("uptdate");
                String competitionName = (String) competitionList.getJSONObject(i).get("competitionName");
                String studentId = (String) competitionList.getJSONObject(i).get("studentId");
                flag = institutionServiceImp.updCompetition(uptdate, competitionName, studentId);
                if (flag == 0) {
                    result.put("success", false);
                    break;
                }
            } catch (Exception ex) {
                ex.getStackTrace();
                logger.error(ex.toString());
                result.put("success", false);
                result.put("errMsg", "系统出错！");
            }
        }
        if (flag == 1)
            result.put("success", true);
        else
            result.put("success", false);
        return result;
    }
}
