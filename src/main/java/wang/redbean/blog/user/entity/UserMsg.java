package wang.redbean.blog.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import wang.redbean.blog.core.base.entity.BaseEntity;

/**
 *  用户信息实体类
 */
@Data
@TableName(value = "user_msg")
public class UserMsg extends BaseEntity {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField(value = "user_id")
    private Integer userId;//用户ID

    @TableField(value = "nickname")
    private String nickname;//用户昵称

    @TableField(value = "sex")
    private String sex;//用户性别

    @TableField(value = "age")
    private String age;//用户年龄

    @TableField(value = "area")
    private String area;//用户地址

    @TableField(value = "email")
    private String  email;//用户邮箱

    @TableField(value = "phone")
    private  String phone;//用户手机号

    @TableField(value = "profession")
    private String profession;//用户职业

    @TableField(value = "position")
    private String position;//用户职位

    @TableField(value = "description")
    private String description;//用户个人简介

    @TableField(value = "icon")
    private String icon;//用户头像图片

    @TableField(value = "status")
    private Integer status;//用户状态，0正常1作废

}
