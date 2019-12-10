package wang.redbean.blog.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import wang.redbean.blog.common.base.entity.BaseEntity;

/**
 *  用户信息实体类
 */
@Data
@TableName(value = "user_msg")
public class UserMsg extends BaseEntity {

    @TableId(value = "user_id",type = IdType.AUTO)
    private Integer userId;//用户ID

    @TableField(value = "user_name")
    private String userName; //用户名

    @TableField(value = "user_nickname")
    private String userNickname;//用户昵称

    @TableField(value = "user_password")
    private String userPassword;// 用户密码

    @TableField(value = "user_sex")
    private String userSex;//用户性别

    @TableField(value = "user_age")
    private String userAge;//用户年龄

    @TableField(value = "user_area")
    private String userArea;//用户地址

    @TableField(value = "user_email")
    private String  userEmail;//用户邮箱

    @TableField(value = "user_phone")
    private  String userPhone;//用户手机号

    @TableField(value = "user_profession")
    private String userProfession;//用户职业

    @TableField(value = "user_position")
    private String userPosition;//用户职位

    @TableField(value = "user_description")
    private String userDescription;//用户个人简介

    @TableField(value = "user_icon")
    private String userIcon;//用户头像图片

    @TableField(value = "user_status")
    private Integer userStatus;//用户状态，0正常1作废

}
