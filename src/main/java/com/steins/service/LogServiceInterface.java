package com.steins.service;

import com.steins.entity.Page;
import com.steins.entity.SystemLog;
import org.springframework.stereotype.Service;

public interface LogServiceInterface {
    int addLog(SystemLog var1);

    Page<SystemLog> getAllLogs(int var1, int var2);

}
