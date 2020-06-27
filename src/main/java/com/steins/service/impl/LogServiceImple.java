package com.steins.service.impl;

import com.steins.annotation.Anno;
import com.steins.dao.LogDaoInterface;
import com.steins.entity.Page;
import com.steins.entity.SystemLog;
import com.steins.service.LogServiceInterface;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
public class LogServiceImple implements LogServiceInterface {

    @Resource
    LogDaoInterface logDaoInterface;


    @Override
    @Transactional
    public int addLog(SystemLog systemLog) {
        return logDaoInterface.addLog(systemLog);
    }

    @Anno(operationType = "selectALL操作",operationName = "分页展示所有记录")
    public Page<SystemLog> getAllLogs(int pageNum, int pageSize) {
        int count=logDaoInterface.getLogCount();
        Page page=new Page(pageNum,pageSize,count);
        int startIndex = pageNum * pageSize - pageSize;
        List list=logDaoInterface.getAllLogs(startIndex,pageSize);
        page.setList(list);
        return page;
    }

}
