package com.steins.dao;

import com.steins.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testDao {
    @Test
    public void say(){
        ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("classpath:spring/spring-dao.xml");
        UserDaoInterface userDaoInterface = (UserDaoInterface) applicationContext.getBean("userDaoInterface");

        String username="admin";
        String password="admin123";
        User user = userDaoInterface.loginUser(username, password);
        System.out.println(user.toString());
    }

}
