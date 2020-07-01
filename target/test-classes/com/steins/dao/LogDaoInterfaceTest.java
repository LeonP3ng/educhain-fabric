package com.steins.dao;

import com.steins.BaseTest;
import com.steins.entity.SystemLog;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class LogDaoInterfaceTest extends BaseTest {

    @Autowired
    private LogDaoInterface logDaoInterface;
    @Test
    public void addLog() {
        SystemLog systemLog = new SystemLog();
        systemLog.setRequestIp("localhost");
        systemLog.setCreateBy("test");
        systemLog.setCreateDate("202007");
        systemLog.setDescription("test");
        System.out.println(logDaoInterface.addLog(systemLog));
    }

    @Test
    public void getLogCount() {
        System.out.println(logDaoInterface.getLogCount());
    }

    @Test
    public void getAllLogs() {
        System.out.println(logDaoInterface.getAllLogs(0,5));
    }
}