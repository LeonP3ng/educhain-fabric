package com.steins.entity;

import javax.servlet.annotation.WebServlet;

/**
 * Created by Swingland on 2019/5/17 15:37
 * Tomorrow is a new day!
 */
@WebServlet(name = "AccountInfo")
public class AccountInfo {
    private String userName;

    private String phone;

    private String address;

    private String school;

    @Override
    public String toString() {
        return "AccountInfo{" +
                "userName='" + userName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", school='" + school + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }


}
