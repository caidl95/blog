
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限名称',
  `permission` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限标识',
  `create_time` timestamp not null default current_timestamp COMMENT '创建时间',
  `update_time` timestamp not null default current_timestamp on update current_timestamp COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 87 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '查看用户信息', 'sys:system:info',null,null );
INSERT INTO `sys_menu` VALUES (2, '查看所有权限', 'sys:menu:info',null,null );
INSERT INTO `sys_menu` VALUES (3, '查看所有角色', 'sys:role:info',null,null );

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `create_time` timestamp not null default current_timestamp COMMENT '创建时间',
  `update_time` timestamp not null default current_timestamp on update current_timestamp COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'ADMIN',null,null );
INSERT INTO `sys_role` VALUES (2, 'USER',null,null );

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `role_id` bigint(11) NULL DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(11) NULL DEFAULT NULL COMMENT '权限ID',
  `create_time` timestamp not null default current_timestamp COMMENT '创建时间',
  `update_time` timestamp not null default current_timestamp on update current_timestamp COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色与权限关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (1, 1, 1,null,null );
INSERT INTO `sys_role_menu` VALUES (2, 1, 2,null,null );
INSERT INTO `sys_role_menu` VALUES (3, 1, 3,null,null );
INSERT INTO `sys_role_menu` VALUES (4, 2, 1,null,null );

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `nickname` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '用户昵称',
  `sex` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '用户性别',
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '用户邮箱',
  `phone` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '用户手机号',
  `icon` varchar(99) CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '用户头像图片地址',
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'NORMAL' COMMENT '状态 PROHIBIT：禁用   NORMAL：正常',
  `create_time` timestamp not NULL DEFAULT current_timestamp COMMENT '创建时间',
  `update_time` timestamp not NULL DEFAULT current_timestamp on update current_timestamp COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '$2a$10$5T851lZ7bc2U87zjt/9S6OkwmLW62tLeGLB2aCmq3XRZHA7OI7Dqa','carl','男','caidl95@163.com','13662925808','', 'NORMAL',null,null );
INSERT INTO `sys_user` VALUES (2, 'system', '$2a$10$szHoqQ64g66PymVJkip98.Fap21Csy8w.RD8v5Dhq08BMEZ9KaSmS','csa','男','caidl95@163.com','13662925808','','NORMAL',null,null );

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` bigint(11) NULL DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(11) NULL DEFAULT NULL COMMENT '角色ID',
  `create_time` timestamp not NULL DEFAULT current_timestamp COMMENT '创建时间',
  `update_time` timestamp not NULL DEFAULT current_timestamp on update current_timestamp COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户与角色关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1, 1,null,null );
INSERT INTO `sys_user_role` VALUES (2, 2, 2,null,null );





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

SET FOREIGN_KEY_CHECKS = 1;