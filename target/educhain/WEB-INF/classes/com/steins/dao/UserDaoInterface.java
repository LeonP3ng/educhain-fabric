package com.steins.dao;

import com.steins.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDaoInterface {

    //学生登录验证
    User loginUser(@Param("username") String username, @Param("password") String password);

    //基本信息更改
    int updateUser(User user);

    //查询 导出信息
    User getStudentInfo(@Param("idNumber") String idNumber);



    //通过idNumber找这个学生的竞赛，考试，实习信息
    List<Competition> getStudentCompetition(@Param("idNumber") String idNumber,
                                            @Param("pageNum") int pageNum,
                                            @Param("pageSize") int pageSize);
    List<Exam> getStudentExam(@Param("idNumber") String idNumber,
                              @Param("pageNum") int pageNum,
                              @Param("pageSize") int pageSize);
    List<Internship> getStudentInternship(@Param("idNumber") String idNumber,
                                          @Param("pageNum") int pageNum,
                                          @Param("pageSize") int pageSize);

    //
    int getCompetitionCount(String idNumber);

    int getExamCount(String idNumber);

    int getInternshipCount(String idNumber);

    InfoHeader getInfoHeaderByIdNumber(String idNumber);

    List<User> getStudentsOfInstitution(@Param("idNumber") String idNumber,
                                        @Param("pageNum") int pageNum,
                                        @Param("pageSize") int pageSize);

    int insertStudentOfInstitution(@Param("studentIdNumber")String studentIdNumber,@Param("institutionIdNumber") String institutionIdNumber);

    int getStudentsOfInstitutionCount(@Param("idNumber") String idNumber);

    InfoHeader getInfoHeadById(String idNumber);

}
