drop database if exists `ssm_wms`;
create database `ssm_wms` character set utf8;
use `ssm_wms`;
SET FOREIGN_KEY_CHECKS=0;


-- ----------------------------
-- Table structure for t_sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_permission`;
CREATE TABLE `t_sys_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(40) NOT NULL COMMENT '权限名称',
  `description` varchar(255) DEFAULT NULL COMMENT '权限描述',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_permission
-- ----------------------------
INSERT INTO `t_sys_permission` VALUES ('1', 'read system settings', '读取系统设定');
INSERT INTO `t_sys_permission` VALUES ('2', 'edit system settings', '修改系统设定');
INSERT INTO `t_sys_permission` VALUES ('3', 'read self user information', '读取自己的用户信息');
INSERT INTO `t_sys_permission` VALUES ('4', 'edit self user information', '修改自己的用户信息');
INSERT INTO `t_sys_permission` VALUES ('5', 'read others user information', '读取他人的用户信息');
INSERT INTO `t_sys_permission` VALUES ('6', 'edit others user information', '修改他人的用户信息');

-- ----------------------------
-- Table structure for t_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role`;
CREATE TABLE `t_sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(40) NOT NULL COMMENT '角色名称',
  `description` varchar(255) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_role
-- ----------------------------
INSERT INTO `t_sys_role` VALUES ('1', 'admin', '管理员');
INSERT INTO `t_sys_role` VALUES ('2', 'all user', '全体用户');
INSERT INTO `t_sys_role` VALUES ('3', 'guest', '访客');

-- ----------------------------
-- Table structure for t_sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role_permission`;
CREATE TABLE `t_sys_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` int(11) NOT NULL COMMENT '角色外键',
  `permission_id` int(11) NOT NULL COMMENT '权限外键',
  PRIMARY KEY (`id`),
  KEY `permission_id` (`permission_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `t_sys_role_permission_ibfk_2` FOREIGN KEY (`permission_id`) REFERENCES `t_sys_permission` (`id`),
  CONSTRAINT `t_sys_role_permission_ibfk_3` FOREIGN KEY (`role_id`) REFERENCES `t_sys_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_role_permission
-- ----------------------------
INSERT INTO `t_sys_role_permission` VALUES ('1', '1', '1');
INSERT INTO `t_sys_role_permission` VALUES ('2', '1', '2');
INSERT INTO `t_sys_role_permission` VALUES ('3', '1', '3');
INSERT INTO `t_sys_role_permission` VALUES ('4', '1', '4');
INSERT INTO `t_sys_role_permission` VALUES ('5', '1', '5');
INSERT INTO `t_sys_role_permission` VALUES ('6', '1', '6');
INSERT INTO `t_sys_role_permission` VALUES ('7', '2', '1');
INSERT INTO `t_sys_role_permission` VALUES ('8', '2', '3');
INSERT INTO `t_sys_role_permission` VALUES ('9', '2', '4');
INSERT INTO `t_sys_role_permission` VALUES ('10', '2', '5');

-- ----------------------------
-- Table structure for t_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account` varchar(40) NOT NULL COMMENT '帐号',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `user_name` varchar(40) NOT NULL COMMENT '用户名',
  `salt` varchar(255) DEFAULT NULL COMMENT '盐',
  PRIMARY KEY (`id`),
  UNIQUE KEY `account` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_user
-- ----------------------------
INSERT INTO `t_sys_user` VALUES ('1', 'account1', '5f4dcc3b5aa765d61d8327deb882cf99', '测试帐号1', null);
INSERT INTO `t_sys_user` VALUES ('2', 'account2', 'e10adc3949ba59abbe56e057f20f883e', '测试帐号2', null);

-- ----------------------------
-- Table structure for t_sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user_role`;
CREATE TABLE `t_sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) NOT NULL COMMENT '用户外键',
  `role_id` int(11) NOT NULL COMMENT '角色外键',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `t_sys_user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_sys_user` (`id`),
  CONSTRAINT `t_sys_user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `t_sys_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_user_role
-- ----------------------------
INSERT INTO `t_sys_user_role` VALUES ('1', '1', '1');
INSERT INTO `t_sys_user_role` VALUES ('2', '1', '2');
INSERT INTO `t_sys_user_role` VALUES ('3', '2', '2');

-- ----------------------------
-- Table structure for t_material_base
-- ----------------------------
DROP TABLE IF EXISTS `t_material_base`;
CREATE TABLE `t_material_base` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `product_series_id` int(11) COMMENT '产品系列',
  `material_no` varchar(20) NOT NULL COMMENT '料号',
  `name` varchar(40) NOT NULL COMMENT '名称',
  `picture` varchar(100) COMMENT '图片地址',
  `category` varchar(100) NOT NULL COMMENT '类别',
  `unit` varchar(100) NOT NULL COMMENT '计量单位',
  `storage_life` int(11) COMMENT '保存期(小时)',
  `specifications` varchar(40) COMMENT '规格',
  `description` varchar(255) COMMENT '描述',
  `is_enable` BOOLEAN NOT NULL DEFAULT 1 COMMENT '可用标记',
  `is_delete` BOOLEAN NOT NULL DEFAULT 0 COMMENT '删除标记',
  `create_time` DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
  `create_user` int(11) NOT NULL COMMENT '创建者',
  `update_time` DATETIME NOT NULL DEFAULT NOW() COMMENT '更新时间',
  `update_user` int(11) NOT NULL COMMENT '更新者',
  PRIMARY KEY (`id`),
  UNIQUE KEY `material_no` (`material_no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_user_role
-- ----------------------------
INSERT INTO `t_material_base` VALUES ('1', null, '11111111111', '物料A', null, 'RM', 'PCE', 8640, '0805', '无描述', true, false, '2018-03-20 12:00:00', 1, '2018-03-20 12:00:00', 1);
INSERT INTO `t_material_base` VALUES ('2', null, '11111111112', '物料B', null, 'RM', 'PCE', 8640, '0805', '无描述', true, false, '2018-03-20 12:00:00', 1, '2018-03-20 12:00:00', 1);
INSERT INTO `t_material_base` VALUES ('3', null, '21111111111', '物料C', null, 'RM', 'PCE', 8640, '1111', '无描述', true, false, '2018-03-20 12:00:00', 1, '2018-03-20 12:00:00', 1);

