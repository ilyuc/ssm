package com.ssm.pojo;

import java.io.Serializable;
/**
 * @author ilyuc
 * @date 2020/6/7 15:10
 */
public class User implements Serializable{

    private String userId;
    private String userCreateDate;
    private String userName;
    private String userPassword;
    private String mail;

    public String getUserCreateDate() {
        return userCreateDate;
    }

    public String getMail() {
        return mail;
    }

    public void setUserCreateDate(String userCreateDate) {
        this.userCreateDate = userCreateDate;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public User(String userId, String userCreateDate, String userName, String userPassword, String mail) {
        this.userId = userId;
        this.userCreateDate = userCreateDate;
        this.userName = userName;
        this.userPassword = userPassword;
        this.mail = mail;
    }

    public User() {
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userCreateDate='" + userCreateDate + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
