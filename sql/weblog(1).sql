url:134.175.142.230
database:weblog
username:root
password:1234

3.user_attention	-- 用户关注表 -- 1 用户默认权限 -- 基础权限
4.user_praise		-- 用户点赞表 -- 1 用户默认权限
5.user_rights		-- 用户权限表 -- 3 权限模块 -- 仅管理员开放
6.user_comment		-- 用户评论表 -- 1 用户默认权限
7.article_category	-- 文章类别 -- 2 用户默认查看权限 -- 增删改需要额外分配权限
8.article_info		-- 文章详情 -- 2 用户默认查看权限 -- 增删改需要额外分配权限
9.article_content	-- 文章内容 -- 2 用户默认查看权限 -- 增删改需要额外分配权限

create table user_attention(
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `attention_user_id` bigint(11) not null comment '关注的ID',
  `status` TINYINT(3) NULL DEFAULT '0' COMMENT '关注状态，0正常1取消',
  `create_time` timestamp not NULL DEFAULT current_timestamp COMMENT '创建时间',
  `update_time` timestamp not NULL DEFAULT current_timestamp on update current_timestamp COMMENT '修改时间',
   primary key (id)
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户关注表' ROW_FORMAT = Dynamic;

create table user_praise(
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `praise_article_id` bigint(11) not null comment '点赞文章的ID',
  `status` TINYINT(3) NULL DEFAULT '0' COMMENT '点赞状态，0正常1取消',
  `create_time` timestamp not NULL DEFAULT current_timestamp COMMENT '创建时间',
  `update_time` timestamp not NULL DEFAULT current_timestamp on update current_timestamp COMMENT '修改时间',
   primary key (id)
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户点赞表' ROW_FORMAT = Dynamic;

create table user_comment(
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `comment_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL comment '评论内容',
  `article_id` bigint(11) not null comment '文章ID',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `status` TINYINT(3) NULL DEFAULT '0' COMMENT '评论状态，0正常1作废',
  `create_time` timestamp not NULL DEFAULT current_timestamp COMMENT '创建时间',
  `update_time` timestamp not NULL DEFAULT current_timestamp on update current_timestamp COMMENT '修改时间',
   primary key (id)
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户评论表' ROW_FORMAT = Dynamic;


create table article_info(
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `article_name` varchar(64) not null comment '文章标题',
  `article_description` varchar(512) not null comment '文章简介',
  `status` TINYINT(3) NULL DEFAULT '0' COMMENT '文章状态，0正常1作废',
  `article_icon` varchar(64) comment '文章图片',
  `category_type` bigint(11) not null comment '文章类目编号',
  `create_time` timestamp not NULL DEFAULT current_timestamp COMMENT '创建时间',
  `update_time` timestamp not NULL DEFAULT current_timestamp on update current_timestamp COMMENT '修改时间',
   primary key (id)
)  ENGINE = InnoDB AUTO_INCREMENT = 1000 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文章详情表' ROW_FORMAT = Dynamic;

create table article_content(
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `article_id` bigint(11) not null comment '文章ID',
  `content_body` text comment '文章正文',
  `create_time` timestamp not NULL DEFAULT current_timestamp COMMENT '创建时间',
  `update_time` timestamp not NULL DEFAULT current_timestamp on update current_timestamp COMMENT '修改时间',
   primary key (id)
) ENGINE = InnoDB AUTO_INCREMENT = 1000 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文章内容表' ROW_FORMAT = Dynamic;


CREATE TABLE category (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `parent_id` bigint(11) DEFAULT 0 COMMENT '父类别id当id=0时说明是根节点,一级类别',
  `name` varchar(50) DEFAULT NULL COMMENT '类别名称',
  `type` int not null comment '类目编号',
  `status` TINYINT(3) DEFAULT '0' COMMENT '类别状态0-正常,1-已废弃',
  `create_time` timestamp not NULL DEFAULT current_timestamp COMMENT '创建时间',
  `update_time` timestamp not NULL DEFAULT current_timestamp on update current_timestamp COMMENT '修改时间',
   primary key (id)
)  ENGINE = InnoDB AUTO_INCREMENT = 1000 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '分类' ROW_FORMAT = Dynamic;

