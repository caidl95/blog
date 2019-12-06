package wang.redbean.blog.user.entity;

import wang.redbean.blog.common.base.entity.BaseEntity;
import javax.xml.crypto.Data;
import java.util.Date;

/**
 *  用户信息表
 */
public class UserMsg extends BaseEntity {

    private Integer userId;//用户ID

    private String userName; //用户名

    private String userNickname;//用户昵称

    private String userPassword;// 用户密码

    private String userSex;//用户性别

    private String userAge;//用户年龄

    private String userArea;//用户地址

    private String  userEmail;//用户邮箱

    private  String userPhone;//用户手机号

    private String userProfession;//用户职业

    private String userPosition;//用户职位

    private String userDescription;//用户个人简介

    private String userIcon;//用户头像图片

    private String userStatus;//用户状态，0正常1作废

    public UserMsg() {
    }

    public UserMsg(Data createTime, Date updateTime, Integer userId, String userName, String userNickname, String userPassword, String userSex, String userAge, String userArea, String userEmail, String userPhone, String userProfession, String userPosition, String userDescription, String userIcon, String userStatus) {
        super(createTime, updateTime);
        this.userId = userId;
        this.userName = userName;
        this.userNickname = userNickname;
        this.userPassword = userPassword;
        this.userSex = userSex;
        this.userAge = userAge;
        this.userArea = userArea;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userProfession = userProfession;
        this.userPosition = userPosition;
        this.userDescription = userDescription;
        this.userIcon = userIcon;
        this.userStatus = userStatus;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserArea() {
        return userArea;
    }

    public void setUserArea(String userArea) {
        this.userArea = userArea;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserProfession() {
        return userProfession;
    }

    public void setUserProfession(String userProfession) {
        this.userProfession = userProfession;
    }

    public String getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }



}
