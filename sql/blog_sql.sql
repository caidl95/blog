
create table user(
	id int(11) NOT NULL AUTO_INCREMENT,
	username varchar(64) NOT NULL COMMENT '用户名',
	password varchar(64) NOT NULL COMMENT '密码',
	primary key (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '用户登录表';

INSERT INTO `user` VALUES (1, 'admin', 'c0608e8340486992c404142f2547eceb');
INSERT INTO `user` VALUES (2, 'caidl', 'c0608e8340486992c404142f2547eceb');

create table role(
	id int(11) NOT NULL AUTO_INCREMENT,
	name varchar(64) NOT NULL COMMENT '权限名称',
	primary key (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '用户权限表';

INSERT INTO `role` VALUES (1, 'ROLE_ADMIN');
INSERT INTO `role` VALUES (2, 'ROLE_USER');

create table role_user(
	id int(11) NOT NULL AUTO_INCREMENT,
	user_id int(11) NOT NULL COMMENT '用户id',
	role_id int(11) NOT NULL COMMENT '权限id',
	primary key (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '用户权限分配表';

INSERT INTO `role_user` VALUES (1, 1, 1);
INSERT INTO `role_user` VALUES (2, 2, 2);

CREATE TABLE `wechat_user`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `open_id` varchar(64) NOT NULL COMMENT '标识该公众号下面的该用户的唯一Id',
  `nick_name` varchar(64) COMMENT '用户昵称',
  `sex` bigint(3) COMMENT ' 性别',
  `province` varchar(64) COMMENT '省份',
  `city` varchar(64) COMMENT '城市',
  `country` varchar(64) COMMENT '区',
  `headimgurl` varchar(225) COMMENT '头像',
  `language` varchar(32) COMMENT '语言',
  `create_time` timestamp not null default current_timestamp COMMENT '创建时间',
  `update_time` timestamp not null default current_timestamp on update current_timestamp COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `open_id`(`open_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '微信公众号授权登录表' ROW_FORMAT = Dynamic;
