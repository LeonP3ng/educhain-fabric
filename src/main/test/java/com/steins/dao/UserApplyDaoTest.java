package com.steins.dao;


import com.steins.entity.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.steins.BaseTest;

import java.util.List;

public class UserApplyDaoTest extends BaseTest {
	@Autowired
	private UserDaoInterface userDaoInterface;

	@Autowired
	private InstitutionDao institutionDao;

	@Test
	public void insertInfoHeader(){
		String studentIdNumber = "1234";
		String institutionIdNumber = "11111";
		String insertTime = "";
		String updateTIme = "";
		InfoHeader infoHeader = new InfoHeader();
		infoHeader.setIdNumber("11111");
		infoHeader.setBlockHeight(21);
		infoHeader.setContractAddress("0xxasas");
		infoHeader.setDataCheck(1);
		infoHeader.setDataProtect(0);
		infoHeader.setInsertTime("asx");
		infoHeader.setUpdateTime("aas");
		infoHeader.setDirTitle("test");
		int i = institutionDao.addInfoHeader(infoHeader);
		System.out.println(i);
	}

	@Test
	public void asdasdStudentOfInsti(){
		String studentIdNumber = "2";
		InfoHeader infoHeaderByIdNumber = userDaoInterface.getInfoHeaderByIdNumber(studentIdNumber);
		System.out.println(infoHeaderByIdNumber);
	}
	@Test
	public void insertStudentOfInsti(){
		String studentIdNumber = "1234";
		String institutionIdNumber = "11111";
		userDaoInterface.insertStudentOfInstitution(studentIdNumber,institutionIdNumber);
	}
	@Test
	public void getStudentOfInsti(){
		String idNumber = "11111";
		int pageNum = 0;
		int pageSize = 5;
		List<User> studentsOfInstitution = userDaoInterface.getStudentsOfInstitution(idNumber, pageNum, pageSize);
		System.out.println(studentsOfInstitution);
	}

	@Test
	public void testcheckStudentLogin(){
		String username = "admin";
		String password = "admin123" ;
		User user = userDaoInterface.loginUser(username, password);
		System.out.println(user);
	}

	@Test
	public void testInsert(){
		User admin = userDaoInterface.getStudentInfo("admin");
		System.out.println(admin);
	}

	@Test
	public void testUpdate(){
		User user = new User();
		user.setPassword("123");
		user.setNickname("pxq");
		user.setRating(3);
		user.setSex(1);
		user.setIdNumber("2019");
		int i = userDaoInterface.updateUser(user);
		System.out.println(i);
	}
	@Test
	public void testSelectInfo(){

	    String idNumber ="1";
	    int pageNum = 1;
	    int pageSize = 5;
		List<Competition> studentCompetition = userDaoInterface.getStudentCompetition(idNumber,pageNum,pageSize);
		List<Internship> studentInternship = userDaoInterface.getStudentInternship(idNumber,pageNum,pageSize);
		List<Exam> studentExam = userDaoInterface.getStudentExam(idNumber,pageNum,pageSize);
		System.out.println(studentCompetition.toString() + studentExam.toString()+studentInternship.toString());


	}

	@Test
	public void selectInfoHeader(){
		String idNumber = "2019";
		InfoHeader infoHeaderById = userDaoInterface.getInfoHeaderByIdNumber(idNumber);
		System.out.println(infoHeaderById);
	}
}