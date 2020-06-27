package com.steins.entity;

public class Exam {
    private int id;
    private String recordTime; //记录时间
    private String recorderId; //记录者id
    private String studentId;  //被记录学生id
    private String subject;    //科目
    private String grade;      //年级
    private String examName;   //考试名称
    private String score;      //分数
    private String remark;    //描述

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", recordTime='" + recordTime + '\'' +
                ", recorderId='" + recorderId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", subject='" + subject + '\'' +
                ", grade='" + grade + '\'' +
                ", examName='" + examName + '\'' +
                ", score='" + score + '\'' +
                ", remark='" + remark + '\'' +
                '}';
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
