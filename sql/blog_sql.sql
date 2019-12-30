
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