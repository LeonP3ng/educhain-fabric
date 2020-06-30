package com.steins.web;


import com.steins.annotation.Anno;
import com.steins.entity.User;
import com.steins.service.LogServiceInterface;
import com.steins.service.UserServiceInterface;
import com.steins.service.impl.LogServiceImple;
import com.steins.service.impl.UserServiceImple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author by liupeng
 */

@RestController
@RequestMapping({"/user"})
public class LoginServlet {
    @Autowired
    UserServiceInterface userServiceInterface;
    @Autowired
    LogServiceInterface logServiceInterface;
    Logger logger = LoggerFactory.getLogger(LoginServlet.class);

    public LoginServlet() {
    }

    @ResponseBody
    @RequestMapping({"/login"})
    private Map<String, Object> stuLogin(HttpServletRequest request, String username, String password) throws IOException {
        Map<String, Object> result = new HashMap();
        System.out.println(this.userServiceInterface);
        User user = this.userServiceInterface.checkStudentLogin(username, password);
        if (user != null) {
            request.getSession().setAttribute("user", user);
            result.put("success", true);
        } else {
            result.put("success", false);
        }

        result.put("user", user);
        return result;
    }

    @ResponseBody
    @RequestMapping({"/invalide"})
    public Map<String, Object> invalidateMember(HttpServletRequest request) {
        HashMap result = new HashMap();

        try {
            request.getSession().invalidate();
            result.put("success", true);
        } catch (Exception var4) {
            this.logger.error(var4.toString());
            var4.printStackTrace();
            result.put("errMsg", "系统出错!");
            result.put("success", false);
        }

        return result;
    }

    @ResponseBody
    @RequestMapping({"/hello"})
    public Map<String, Object> testHello(HttpServletRequest request) {
        Map<String, Object> result = new HashMap();
        result.put("success", true);
        return result;
    }
}