package com.steins.entity;

public class Internship {

    private int id;
    private String recordTime;     //记录时间
    private String recorderId;     //记录者id
    private String studentId;      //学生id
    private String companyName;   //公司
    private String period;         //时期
    private String remark;      //描述
    private String position; //实习岗位

    @Override
    public String toString() {
        return "Internship{" +
                "id=" + id +
                ", recordTime='" + recordTime + '\'' +
                ", recorderId='" + recorderId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", companyName='" + companyName + '\'' +
                ", period='" + period + '\'' +
                ", remark='" + remark + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompanyame() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

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

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
