package com.steins.service.impl;

import com.steins.entity.User;
import com.steins.service.UserServiceInterface;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.steins.BaseTest;

public class UserApplyServiceImplTest extends BaseTest {

    @Autowired
    UserServiceInterface userServiceInterface;

    @Test
    public void testAop(){

        String username = "liup";
        String password = "test";
        User user = userServiceInterface.checkStudentLogin(username, password);
        System.out.println(user);
    }
//	@Autowired
//	private UserApplyService userApplyService;
//
////	@org.junit.jupiter.api.Test
//	void insertApplyHead1() {
//	}
//
//	@Test
//	public void getMemberInfoByIdNum(){
//
//		String s=userApplyService.getMemberInfoByIdNum("513901199810290011");
//		System.out.println(s);
//	}
//	@Test
//	public void getPageMatch(){
//		List<Match> list=new ArrayList<>();
//		list=userApplyService.getPageMatch(1,10);
//		for(Match match:list){
//			System.out.println(match);
//		}
//	}
//	@Test
//	public void getAllTeams(){
//		List<GameApply> list=new ArrayList<>();
//		Map<String, Object> map = new HashMap<>();
//		int matchId=1;
//		int pageNum=2;
//		int pageSize=2;
//		map.put("matchId",matchId);
//		map.put("startIndex", pageNum * pageSize - pageSize);
//		map.put("pageSize", pageSize);
//		list=userApplyService.getAllTeams(1,1,10);
//		for (GameApply gameApply:list){
//			System.out.println(gameApply);
//		}
//	}
//	@Test
//	public void getAllTeamsCount(){
//		int count=userApplyService.getAllTeamsCount(1);
//		System.out.println(count);
//	}
//	@Test
//	public void getApplyedMatch(){
//		List<Match> list=new ArrayList<>();
//		list=userApplyService.getApplyedMatch("5433",1,10);
//		for (Match match:list){
//			System.out.println(match);
//		}
//	}
//	@Test
//	public void updateApplyHead(){
//		GameApply gameApply=new GameApply();
//		gameApply.setTeamName("xinke");
//		gameApply.setGameApplyId(18);
//		int flag=userApplyService.updateApplyHead(gameApply);
//
//		System.out.println(flag);
//	}
//	@Test
//	public void updateTeamMember(){
//		List<TeamMember> list=new ArrayList<>();
//		TeamMember teamMember1=new TeamMember();
//		TeamMember teamMember2=new TeamMember();
//		TeamMember teamMember3=new TeamMember();
//		teamMember1.setMemberName("xiaowang");
//		teamMember1.setTeamMemberId(3);
//		teamMember2.setTeamMemberId(10);
//		teamMember2.setMemberName("111111");
//		list.add(teamMember1);
//		list.add(teamMember2);
//		int flag=userApplyService.updateTeamMember(list);
//		System.out.println(flag);
//
//	}
//	@Test
//	public void insertApplyHead(){
//		GameApply gameApply=new GameApply();
//		gameApply.setTeamName("ghfjhgf");
//		gameApply.setAreaCity("乘除");
//		gameApply.setMatchId(1);
//		GameApplyExecution flag=userApplyService.insertApplyHead(gameApply);
//		int i=flag.getState();
//		System.out.println(i);
//	}
//	@Test
//	public void insertTeamMember(){
//		List<TeamMember> list=new ArrayList<>();
//		TeamMember teamMember1=new TeamMember();
//		TeamMember teamMember2=new TeamMember();
//		TeamMember teamMember3=new TeamMember();
//		teamMember1.setMemberName("东北师范大学1111111111111");
//		teamMember1.setTeamMemberId(0);
//		teamMember2.setMemberName("111111");
//		list.add(teamMember1);
//		list.add(teamMember2);
//		TeamMemberExecution flag=userApplyService.insertTeamMember(list);
//		System.out.println(flag);
//
//	}
////	@Test
////	public void getGameApply(){
////		GameApply gameApply=userApplyService.getGameApply(1,"5433");
////		System.out.println(gameApply);
////
////	}
////	@Test
////	public void addOneTeamMember(){
////		TeamMember teamMember=new TeamMember();
////		teamMember.setMemberName("123456");
////		teamMember.setSex(1);
////		boolean flag=userApplyService.addOneTeamMember(teamMember);
////		System.out.println(flag);
////	}
////	@Test
////	public void deleteOneMember(){
////		int gameApplyId=1;
////		String idNumber="234";
////		boolean flag=userApplyService.deleteOneMember(idNumber,gameApplyId);
////		System.out.println(flag);
////	}
//	@Test
//	public void isAttendMatch(){
//		int matchId=1;
//		String idNumber="5433";
//		boolean flag=userApplyService.isAttendMatch(matchId,idNumber);
//		System.out.println(flag);
//	}
//
//	@Test
//	public void updateGameApply(){
////		GameApply gameApply=new GameApply();
////		int gameApplyId=10;
////		String leaderIdNum="12345";
////		gameApply.setLeaderIdNum(leaderIdNum);
////
////		gameApply.setTeamName("test");
////		gameApply.setAreaProvince("123t");
////		gameApply.setMatchId(1);
//		GameApply gameApply=new GameApply();
//		gameApply.setTeamName("hh");
//		gameApply.setAreaCity("乘除");
//		gameApply.setMatchId(1);
//		gameApply.setLeaderIdNum("12345");
//		int gameApplyId=10;
//		TeamMember teamMember=new TeamMember();
//		teamMember.setMemberName("1234qwe");
//		List<TeamMember> list=new ArrayList<>();
//		list.add(teamMember);
//		gameApply.setTeamMember(list);
//
//
//		String re=userApplyService.updateGameApply(gameApply,gameApplyId);
//		System.out.println(re);
//	}
//	@Test
//	public void deleteGameApply(){
//		String idNumber="123";
//		int gameApplyId=3;
//		String flag=userApplyService.deleteGameApply(gameApplyId, idNumber);
//		System.out.println(flag);
//	}
//	@Test
//	public void getGameApplyList(){
//		int matchId=1;
//		String idNumber="12345";
//		List<GameApply> list=new ArrayList<>();
//		list=userApplyService.getGameApplyList(matchId,idNumber);
//		System.out.println(list.size());
//		for (GameApply gameApply:list){
//			System.out.println(gameApply);
//		}
//
//	}
}