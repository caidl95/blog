package wang.redbean.blog.user.entity;

import wang.redbean.blog.common.base.entity.BaseEntity;

public class UserMsg extends BaseEntity {

    private Integer userId;//'用户ID',
    private String userName; //用户名
    private String user_nickname varchar(64) not null comment '用户昵称',
    private String user_password varchar(64) not null comment '用户密码',
    private String user_sex varchar(64) comment '用户性别',
    private String user_age varchar(64) comment '用户年龄',
    private String user_area varchar(64) comment '用户地址',
    private String  user_email varchar(64) comment '用户邮箱',
    private  String user_phone varchar(64) comment '用户手机号',
    private String user_profession varchar(64) comment '用户职业',
    private  String user_possion varchar(64) comment '用户职位',
    private String user_description varchar(512) comment '用户个人简介',
    private String user_icon varchar(512) comment '用户头像图片',
    private String rights_type int not null comment '用户权限',
    private String user_status TINYINT(3) NULL DEFAULT '0' COMMENT '用户状态，0正常1作废',




}
