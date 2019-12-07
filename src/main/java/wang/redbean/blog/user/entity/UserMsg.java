package wang.redbean.blog.user.entity;

import lombok.Data;
import wang.redbean.blog.common.base.entity.BaseEntity;


/**
 *  用户信息表
 */
@Data
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


}
