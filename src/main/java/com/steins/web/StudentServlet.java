package com.steins.web;

import com.steins.entity.InfoHeader;
import com.steins.entity.Page;
import com.steins.entity.SystemLog;
import com.steins.entity.User;
import com.steins.service.LogServiceInterface;
import com.steins.service.UserServiceInterface;
import com.steins.util.Account;
import com.steins.util.IPFSdemo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/student"})
public class StudentServlet {

    @Autowired
    UserServiceInterface userServiceInterface;

    @Autowired
    LogServiceInterface logServiceInterface;
    private Logger logger = LoggerFactory.getLogger(StudentServlet.class);

    public StudentServlet() {
    }

    @ResponseBody
    @RequestMapping({"/getInfo"})
    public Map<String, Object> getAllInfoById(@RequestParam("idNumber") String idNumber, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) throws IOException {
        Map<String, Object> result = new HashMap();
        new HashMap();

        Map infoMap;
        User user;
        try {
            infoMap = this.userServiceInterface.getStudentInfo(idNumber, pageNum, pageSize);
            user = this.userServiceInterface.getUser(idNumber);
        } catch (Exception var8) {
            var8.getMessage();
            this.logger.error(var8.toString());
            result.put("errMsg", "系统出错！");
            result.put("success", false);
            return result;
        }

        if (user != null) {
            result.put("user", user);
            result.put("infoMap", infoMap);
            result.put("success", true);
        } else {
            result.put("errMsg", "查无此人！");
            result.put("success", false);
        }

        return result;
    }

    @ResponseBody
    @RequestMapping({"/getCompetitionInfo"})
    public Map<String, Object> getCompetitionInfoById(@RequestParam("idNumber") String idNumber, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize, @RequestParam("ipfsHash") String hash) throws IOException {
        Map<String, Object> result = new HashMap();
        IPFSdemo ipfSdemo = new IPFSdemo();
        File tempfile = new File("ipfsfile");

        try {
            ipfSdemo.download(tempfile, hash);
            BufferedReader reader = null;
            StringBuffer sbf = new StringBuffer();
            try {
                reader = new BufferedReader(new FileReader(tempfile));
                String tempStr;
                while((tempStr = reader.readLine()) != null) {
                    sbf.append(tempStr);
                }
                reader.close();
                result.put("data", sbf.toString());
            } catch (IOException var23) {
                var23.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException var22) {
                        var22.printStackTrace();
                    }
                }

            }

            result.put("data", sbf.toString());
        } catch (IOException var25) {
            System.err.println("IPFS文件写入出错");
        }

        tempfile.delete();


        //是否无用？
        Page studentCompetition;
        try {
            studentCompetition = this.userServiceInterface.getStudentCompetition(idNumber, pageNum, pageSize);
        } catch (Exception var21) {
            var21.getMessage();
            this.logger.error(var21.toString());
            result.put("success", false);
            result.put("errMsg", "系统出错 ！");
            return result;
        }
        result.put("competition", studentCompetition);
        result.put("success", true);
        return result;
    }

    @ResponseBody
    @RequestMapping({"/getExamInfo"})
    public Map<String, Object> getExamInfoById(@RequestParam("idNumber") String idNumber, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize, @RequestParam("ipfsHash") String hash) throws IOException {
        Map<String, Object> result = new HashMap();
        IPFSdemo ipfSdemo = new IPFSdemo();
        File tempfile = new File("ipfsfile");

        try {
            ipfSdemo.download(tempfile, hash);
            BufferedReader reader = null;
            StringBuffer sbf = new StringBuffer();

            try {
                reader = new BufferedReader(new FileReader(tempfile));

                String tempStr;
                while((tempStr = reader.readLine()) != null) {
                    sbf.append(tempStr);
                }

                reader.close();
                result.put("data", sbf.toString());
            } catch (IOException var23) {
                var23.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException var22) {
                        var22.printStackTrace();
                    }
                }

            }

            result.put("data", sbf.toString());
        } catch (IOException var25) {
            System.err.println("IPFS文件写入出错");
        }

        tempfile.delete();

        Page studentExam;
        try {
            studentExam = this.userServiceInterface.getStudentExam(idNumber, pageNum, pageSize);
        } catch (Exception var21) {
            var21.getMessage();
            this.logger.error(var21.toString());
            result.put("success", false);
            result.put("errMsg", " 系统出错！");
            return result;
        }

        result.put("exam", studentExam);
        result.put("success", true);
        return result;
    }

    @ResponseBody
    @RequestMapping({"/getInternshipInfo"})
    public Map<String, Object> getInternshipInfoById(@RequestParam("idNumber") String idNumber, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize, @RequestParam("ipfsHash") String hash) throws IOException {
        Map<String, Object> result = new HashMap();
        IPFSdemo ipfSdemo = new IPFSdemo();
        File tempfile = new File("ipfsfile");

        try {
            ipfSdemo.download(tempfile, hash);
            BufferedReader reader = null;
            StringBuffer sbf = new StringBuffer();

            try {
                reader = new BufferedReader(new FileReader(tempfile));

                String tempStr;
                while((tempStr = reader.readLine()) != null) {
                    sbf.append(tempStr);
                }

                reader.close();
                result.put("data", sbf.toString());
            } catch (IOException var23) {
                var23.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException var22) {
                        var22.printStackTrace();
                    }
                }

            }

            result.put("data", sbf.toString());
        } catch (IOException var25) {
            System.err.println("IPFS文件写入出错");
        }

        tempfile.delete();

        Page studentInternship;
        try {
            studentInternship = this.userServiceInterface.getStudentInternship(idNumber, pageNum, pageSize);
        } catch (Exception var21) {
            var21.getMessage();
            this.logger.error(var21.toString());
            result.put("success", false);
            result.put("errMsg", "系统出错！ ");
            return result;
        }

        result.put("internship", studentInternship);
        result.put("success", true);
        return result;
    }

    @ResponseBody
    @RequestMapping({"/getLog"})
    public Map<String, Object> getOperationLog(@RequestParam("pageNum") int pageNum) throws IOException {
        System.out.println("hello pagenUm");
        Map<String, Object> result = new HashMap();
        int pageSize = 5;
        Page<SystemLog> allLogs = this.logServiceInterface.getAllLogs(pageNum, pageSize);
        result.put("allLogs", allLogs);
        result.put("success", true);
        return result;
    }

    @ResponseBody
    @RequestMapping({"/updateUserInfo"})
    public Map<String, Object> updateUserInfo(String username, String password, String nickname, int rating, int sex, String idNumber, String tel) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setNickname(nickname);
        user.setRating(rating);
        user.setSex(sex);
        user.setIdNumber(idNumber);
        user.setTel(tel);
        HashMap result = new HashMap();

        boolean status;
        try {
            int ifSucceed = this.userServiceInterface.updateUser(user);
            if (ifSucceed == 0) {
                status = false;
            } else {
                status = true;
            }
        } catch (Exception var12) {
            var12.getMessage();
            this.logger.error(var12.toString());
            result.put("success", false);
            result.put("errMsg", "系统出错！");
            return result;
        }

        result.put("success", status);
        return result;
    }

    @ResponseBody
    @RequestMapping({"/getInfoHeaderById"})
    public Map<String, Object> getInfoHeaderById(@RequestParam("idNumber") String idNumber) throws IOException {
        Map<String, Object> result = new HashMap();
        InfoHeader infoHeader = this.userServiceInterface.getInfoHeaderByIdNumber(idNumber);
        if (infoHeader != null) {
            result.put("success", true);
        } else {
            result.put("success", false);
            result.put("errMsg", "该id不存在!");
        }

        result.put("infoHeader", infoHeader);
        return result;
    }


    @ResponseBody
    @RequestMapping({"/getMessageOfTxByIdNumber"})
    public Map<String, Object> getMessageOfTx(@RequestParam("idNumber") String idNumber) throws IOException {
        HashMap result = new HashMap();

        String message;
        InfoHeader infoHeader;
        try {
            infoHeader = this.userServiceInterface.getInfoHeaderByIdNumber(idNumber);
            message = Account.getTransaction(infoHeader.getContractAddress());
            message = Account.hexStr2Str(message);
        } catch (Exception var6) {
            this.logger.error(var6.toString());
            result.put("success", false);
            result.put("errMsg", "系统错误!");
            return result;
        }

        infoHeader.setDirTitle(message);
        result.put("success", true);
        result.put("infoHeader", infoHeader);
        return result;
    }
}
