package com.steins.service;

import com.steins.entity.Page;
import com.steins.entity.SystemLog;

public interface LogServiceInterface {

    int addLog(SystemLog log); // 插入日志

    Page<SystemLog> getAllLogs(int pageNum, int pageSize);

}
