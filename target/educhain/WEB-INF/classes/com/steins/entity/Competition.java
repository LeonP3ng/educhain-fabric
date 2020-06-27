package com.steins.entity;

public class Competition {
    private int id;
    private String recordTime; //记录时间
    private String recorderId;  //记录者
    private String studentId;   //被记录的学生
    private String competitionName;   //比赛名字
    private String competitionDegree;  //比赛等级，省赛，国赛
    private String achievement;  //比赛等级，A，B，C，一等奖二等奖三等奖
    private String remark;   //其他描述


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    public String getRecorderId() {
        return recorderId;
    }

    public void setRecorderId(String recorderId) {
        this.recorderId = recorderId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public String getCompetitionDegree() {
        return competitionDegree;
    }

    public void setCompetitionDegree(String competitionDegree) {
        this.competitionDegree = competitionDegree;
    }

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Competition{" +
                "id=" + id +
                ", recordTime='" + recordTime + '\'' +
                ", recorderId=" + recorderId +
                ", studentId=" + studentId +
                ", competitionName='" + competitionName + '\'' +
                ", competitionDegree='" + competitionDegree + '\'' +
                ", achievement='" + achievement + '\'' +
                ", describe='" + remark + '\'' +
                '}';
    }
}
