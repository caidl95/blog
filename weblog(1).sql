url:127.0.0.1
database:weblog
username:root
password:1234

/*5.tourist_msg		--游客信息表*/
1.user_msg			--用户信息表
2.user_login		--用户登录信息表
3.user_attention	--用户关注表
4.user_praise		--用户点赞表
5.user_rights		--用户权限表
6.user_comment		--用户评论表
7.article_category	--文章类别
8.article_info		--文章详情
9.article_content	--文章内容



create table user_msg(
	user_id int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
	user_name varchar(64) COMMENT '用户名',
	user_nickname varchar(64) not null COMMENT '用户昵称',
	user_password varchar(64) not null COMMENT '用户密码',
	user_sex varchar(64) COMMENT '用户性别',
	user_age varchar(64) COMMENT '用户年龄',
	user_area varchar(64) COMMENT '用户地址',
	user_email varchar(64) COMMENT '用户邮箱',
	user_phone varchar(64) COMMENT '用户手机号',
	user_profession varchar(64) COMMENT '用户职业',
	user_position varchar(64) COMMENT '用户职位',
	user_description varchar(512) COMMENT '用户个人简介',
	user_icon varchar(64) COMMENT '用户头像图片地址',
	user_status TINYINT(3) NOT NULL DEFAULT '0' COMMENT '用户状态，0正常1作废',
	create_time timestamp not null default current_timestamp COMMENT '创建时间',
	update_time timestamp not null default current_timestamp on update current_timestamp COMMENT '创建时间',
	primary key (user_id)
	)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '用户信息表'

create table user_group(
 group_id int(11) NOT NULL AUTO_INCREMENT COMMENT '分组ID',
 user_id int(11) comment '用户ID',
 rights_type int not null COMMENT '用户权限',
 create_time timestamp not null default current_timestamp comment '创建时间',
 update_time timestamp not null default current_timestamp on update current_timestamp comment '创建时间',
 primary key (group_id)
 )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '用户分组表'

create table user_rights (
	rights_id int(11) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
	rights_name varchar(64) not null comment '权限名字',
	rights_type int not null comment '权限编号',
	create_time timestamp not null default current_timestamp comment '创建时间',
	update_time timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
	primary key (rights_id),
	unique key uqe_rights_type (rights_type)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '用户权限表'

create table user_login(
	login_id int(11) NOT NULL AUTO_INCREMENT COMMENT '登录ID',
	user_id int(11) comment '用户ID',
	login_ip varchar(64) not null comment '登录ip',
	create_time timestamp not null default current_timestamp comment '创建时间',
	update_time timestamp not null default current_timestamp on update current_timestamp comment '创建时间',
	primary key (login_id)
	)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '用户登录信息表'

create table user_attention(
	attention_id int(11) NOT NULL AUTO_INCREMENT COMMENT '关注表id',
	user_id int(11) comment '用户ID',
	attention_user_id int(11) not null comment '关注的ID',
	attention_status TINYINT(3) NULL DEFAULT '0' COMMENT '关注状态，0正常1取消',
	create_time timestamp not null default current_timestamp comment '创建时间',
	update_time timestamp not null default current_timestamp on update current_timestamp comment '创建时间',
	primary key (attention_id)
	) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '用户关注表'

create table user_praise(
	praise_id int(11) NOT NULL AUTO_INCREMENT COMMENT '点赞表id',
	user_id int(11) comment '用户ID',
	praise_article_id int(11) not null comment '点赞文章的ID',
	praise_status TINYINT(3) NULL DEFAULT '0' COMMENT '点赞状态，0正常1取消',
	create_time timestamp not null default current_timestamp comment '创建时间',
	update_time timestamp not null default current_timestamp on update current_timestamp comment '创建时间',
	primary key (praise_id)
	) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '用户点赞表'



create table user_comment(
	comment_id int(11) NOT NULL AUTO_INCREMENT COMMENT '评论ID',
	comment_content varchar(64) not null comment '评论内容',
	article_id int(11) not null comment '文章ID',
	user_id int(11) not null comment '用户ID',
	comment_status TINYINT(3) NULL DEFAULT '0' COMMENT '评论状态，0正常1作废',
	create_time timestamp not null default current_timestamp comment '创建时间',
	update_time timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
	primary key (comment_id)
	) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '用户评论表'


/*create table tourist_msg(
	tourist_id int(11) NOT NULL AUTO_INCREMENT COMMENT '游客ID',
	tourist_name varchar(64) not null comment '游客昵称',
	tourist_status TINYINT(3) NULL DEFAULT '0' COMMENT '游客状态，0正常1作废',
	rights_type int not null comment '游客权限',
	create_time timestamp not null default current_timestamp comment '创建时间',
	update_time timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
	primary key (tourist_id)
	)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '游客信息表'*/



create table article_category (
	category_id int(11) NOT NULL AUTO_INCREMENT COMMENT '类目ID',
	category_name varchar(64) not null comment '类目名字',
	category_type int(11) not null comment '类目编号',
	create_time timestamp not null default current_timestamp comment '创建时间',
	update_time timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
	primary key (category_id),
	unique key uqe_category_type (category_type)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '文章类目表'

create table article_info(
	article_id int(11) NOT NULL AUTO_INCREMENT COMMENT '文章ID',
	user_id int(11) not null comment '用户ID',
	article_name varchar(64) not null comment '文章标题',
	article_description varchar(512) not null comment '文章简介',
	article_status TINYINT(3) NULL DEFAULT '0' COMMENT '文章状态，0正常1作废',
	article_icon varchar(512) comment '文章图片',
	category_type int not null comment '文章类目编号',
	create_time timestamp not null default current_timestamp comment '创建时间',
	update_time timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
	primary key (article_id)
	) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '文章详情表'

create table article_content(
	content_id int(11) NOT NULL AUTO_INCREMENT COMMENT '正文ID',
	article_id int(11) not null comment '文章ID',
	content_body text comment '文章正文',
	create_time timestamp NOT NULL default current_timestamp COMMENT '创建时间',
	update_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP on update current_timestamp COMMENT '修改时间',
	primary key (content_id)
	) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '文章内容表'



