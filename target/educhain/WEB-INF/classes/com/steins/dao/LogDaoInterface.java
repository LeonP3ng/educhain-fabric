package com.steins.dao;

import com.steins.entity.SystemLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogDaoInterface {

    int addLog(SystemLog systemLog);

    int getLogCount();

    List<SystemLog> getAllLogs(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

}
