package com.steins.dao;


import com.steins.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.servlet.annotation.WebServlet;
import java.util.List;

@Repository
@WebServlet(name = "InstitutionDao")
public interface InstitutionDao {
    int regist(User var1);

    //少了
   // String checkRegist(@Param("idNumber") String var1);

    int addExam(Exam var1);

    int addInternship(Internship var1);

    int addCompetition(Competition var1);

    int updExam(@Param("uptdate") String var1, @Param("examName") String var2, @Param("studentId") String var3, @Param("grade") String var4, @Param("subject") String var5);

    int updInternship(@Param("uptdate") String var1, @Param("companyName") String var2, @Param("period") String var3, @Param("studentId") String var4);

    int updCompetition(@Param("uptdate") String var1, @Param("competitionName") String var2, @Param("studentId") String var3);

    List<User> getStudentsOfInstitution(@Param("idNumber") String var1, @Param("pageNum") int var2, @Param("pageSize") int var3);

    int insertStudentOfInstitution(@Param("studentIdNumber") String var1, @Param("institutionIdNumber") String var2);

    int getStudentsOfInstitutionCount(@Param("idNumber") String var1);
}
