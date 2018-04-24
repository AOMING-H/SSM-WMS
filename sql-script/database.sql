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
INSERT INTO `t_sys_permission` (id, name, description) VALUES (1, 'read system settings', '读取系统设定');
INSERT INTO `t_sys_permission` (id, name, description) VALUES (2, 'edit system settings', '修改系统设定');
INSERT INTO `t_sys_permission` (id, name, description) VALUES (3, 'read self user information', '读取自己的用户信息');
INSERT INTO `t_sys_permission` (id, name, description) VALUES (4, 'edit self user information', '修改自己的用户信息');
INSERT INTO `t_sys_permission` (id, name, description) VALUES (5, 'read others user information', '读取他人的用户信息');
INSERT INTO `t_sys_permission` (id, name, description) VALUES (6, 'edit others user information', '修改他人的用户信息');

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
INSERT INTO `t_sys_role` (id, name, description) VALUES (1, 'admin', '管理员');
INSERT INTO `t_sys_role` (id, name, description) VALUES (2, 'all user', '全体用户');
INSERT INTO `t_sys_role` (id, name, description) VALUES (3, 'guest', '访客');

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
INSERT INTO `t_sys_role_permission` (id, role_id, permission_id) VALUES (1, 1, 1);
INSERT INTO `t_sys_role_permission` (id, role_id, permission_id) VALUES (2, 1, 2);
INSERT INTO `t_sys_role_permission` (id, role_id, permission_id) VALUES (3, 1, 3);
INSERT INTO `t_sys_role_permission` (id, role_id, permission_id) VALUES (4, 1, 4);
INSERT INTO `t_sys_role_permission` (id, role_id, permission_id) VALUES (5, 1, 5);
INSERT INTO `t_sys_role_permission` (id, role_id, permission_id) VALUES (6, 1, 6);
INSERT INTO `t_sys_role_permission` (id, role_id, permission_id) VALUES (7, 2, 1);
INSERT INTO `t_sys_role_permission` (id, role_id, permission_id) VALUES (8, 2, 3);
INSERT INTO `t_sys_role_permission` (id, role_id, permission_id) VALUES (9, 2, 4);
INSERT INTO `t_sys_role_permission` (id, role_id, permission_id) VALUES (10, 2, 5);

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
INSERT INTO `t_sys_user` (id, account, password, user_name, salt) VALUES ('1', 'account1', '5f4dcc3b5aa765d61d8327deb882cf99', '测试帐号1', null);
INSERT INTO `t_sys_user` (id, account, password, user_name, salt) VALUES ('2', 'account2', 'e10adc3949ba59abbe56e057f20f883e', '测试帐号2', null);

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
INSERT INTO `t_sys_user_role` (id, user_id, role_id) VALUES (1, 1, 1);
INSERT INTO `t_sys_user_role` (id, user_id, role_id) VALUES (2, 1, 2);
INSERT INTO `t_sys_user_role` (id, user_id, role_id) VALUES (3, 2, 2);

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
-- Records of t_material_base
-- ----------------------------
INSERT INTO `t_material_base` (id, material_no, name, category, unit, create_user, update_user) VALUES (1, '11111111111', '物料A', 'RM', 'PCE', 1, 1);
INSERT INTO `t_material_base` (id, material_no, name, category, unit, create_user, update_user) VALUES (2, '11111111112', '物料B', 'RM', 'PCE', 1, 1);
INSERT INTO `t_material_base` (id, material_no, name, category, unit, create_user, update_user) VALUES (3, '21111111111', '物料C', 'RM', 'PCE', 1, 1);

-- ----------------------------
-- Table structure for t_warehouse
-- ----------------------------
DROP TABLE IF EXISTS `t_warehouse`;
CREATE TABLE `t_warehouse` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(40) NOT NULL COMMENT '名称',
  `code` varchar(40) NOT NULL COMMENT '代码',
  `description` varchar(255) COMMENT '描述',
  `is_enable` BOOLEAN NOT NULL DEFAULT 1 COMMENT '可用标记',
  `is_delete` BOOLEAN NOT NULL DEFAULT 0 COMMENT '删除标记',
  `create_time` DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
  `create_user` int(11) NOT NULL COMMENT '创建者',
  `update_time` DATETIME NOT NULL DEFAULT NOW() COMMENT '更新时间',
  `update_user` int(11) NOT NULL COMMENT '更新者',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_warehouse
-- ----------------------------
INSERT INTO `t_warehouse` (id, name, code, create_user, update_user) VALUES (1, '仓库1', 'warehouse1', 1, 1);
INSERT INTO `t_warehouse` (id, name, code, create_user, update_user) VALUES (2, '仓库2', 'warehouse2', 1, 1);
INSERT INTO `t_warehouse` (id, name, code, create_user, update_user) VALUES (3, '仓库3', 'warehouse3', 2, 2);

-- ----------------------------
-- Table structure for t_warehouse_shelf
-- ----------------------------
DROP TABLE IF EXISTS `t_warehouse_shelf`;
CREATE TABLE `t_warehouse_shelf` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `warehouse_id` int(11) NOT NULL COMMENT '仓库ID',
  `material_base_id` int(11) COMMENT '指定的材料',
  `name` varchar(40) NOT NULL COMMENT '名称',
  `code` varchar(40) NOT NULL COMMENT '代码',
  `capacity` int(11) COMMENT '仓库容量',
  `description` varchar(255) COMMENT '描述',
  `is_enable` BOOLEAN NOT NULL DEFAULT 1 COMMENT '可用标记',
  `is_delete` BOOLEAN NOT NULL DEFAULT 0 COMMENT '删除标记',
  `create_time` DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
  `create_user` int(11) NOT NULL COMMENT '创建者',
  `update_time` DATETIME NOT NULL DEFAULT NOW() COMMENT '更新时间',
  `update_user` int(11) NOT NULL COMMENT '更新者',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_warehouse_shelf
-- ----------------------------
INSERT INTO `t_warehouse_shelf` (id, warehouse_id, name, code, create_user, update_user) VALUES (1, 1, '仓库1-货架1', 'w1-s00001', 1, 1);
INSERT INTO `t_warehouse_shelf` (id, warehouse_id, name, code, create_user, update_user) VALUES (2, 1, '仓库1-货架2', 'w1-s00002', 1, 1);
INSERT INTO `t_warehouse_shelf` (id, warehouse_id, name, code, create_user, update_user) VALUES (3, 1, '仓库1-货架3', 'w1-s00003', 1, 1);
INSERT INTO `t_warehouse_shelf` (id, warehouse_id, name, code, create_user, update_user) VALUES (4, 1, '仓库1-货架4', 'w1-s00004', 1, 1);
INSERT INTO `t_warehouse_shelf` (id, warehouse_id, name, code, create_user, update_user) VALUES (5, 1, '仓库1-货架5', 'w1-s00005', 1, 1);
INSERT INTO `t_warehouse_shelf` (id, warehouse_id, name, code, create_user, update_user) VALUES (6, 1, '仓库1-货架6', 'w1-s00006', 1, 1);
INSERT INTO `t_warehouse_shelf` (id, warehouse_id, name, code, create_user, update_user) VALUES (7, 2, '仓库2-货架1', 'w2-s00001', 1, 1);
INSERT INTO `t_warehouse_shelf` (id, warehouse_id, name, code, create_user, update_user) VALUES (8, 2, '仓库2-货架2', 'w2-s00002', 1, 1);
INSERT INTO `t_warehouse_shelf` (id, warehouse_id, name, code, create_user, update_user) VALUES (9, 2, '仓库2-货架3', 'w2-s00003', 1, 1);
INSERT INTO `t_warehouse_shelf` (id, warehouse_id, name, code, create_user, update_user) VALUES (10, 2, '仓库2-货架4', 'w2-s00004', 1, 1);
INSERT INTO `t_warehouse_shelf` (id, warehouse_id, name, code, create_user, update_user) VALUES (11, 2, '仓库2-货架5', 'w2-s00005', 1, 1);
INSERT INTO `t_warehouse_shelf` (id, warehouse_id, name, code, create_user, update_user) VALUES (12, 2, '仓库2-货架6', 'w2-s00006', 1, 1);

-- ----------------------------
-- Table structure for t_vendor
-- ----------------------------
DROP TABLE IF EXISTS `t_vendor`;
CREATE TABLE `t_vendor` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(40) NOT NULL COMMENT '名称',
  `code` varchar(40) NOT NULL COMMENT '代码',
  `contact` varchar(20) NOT NULL COMMENT '联系人',
  `phoneNo` varchar(20) NOT NULL COMMENT '联系电话',
  `email` varchar(20) COMMENT '电子邮箱',
  `address` varchar(255) COMMENT '联系地址',
  `description` varchar(255) COMMENT '描述',
  `is_enable` BOOLEAN NOT NULL DEFAULT 1 COMMENT '可用标记',
  `is_delete` BOOLEAN NOT NULL DEFAULT 0 COMMENT '删除标记',
  `create_time` DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
  `create_user` int(11) NOT NULL COMMENT '创建者',
  `update_time` DATETIME NOT NULL DEFAULT NOW() COMMENT '更新时间',
  `update_user` int(11) NOT NULL COMMENT '更新者',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_vendor
-- ----------------------------
INSERT INTO `t_vendor` (id, name, code, contact, phoneNo, create_user, update_user) VALUES (1, '上海XXX', 'SHXXXX', '李小姐', '13851111111', 1, 1);
INSERT INTO `t_vendor` (id, name, code, contact, phoneNo, create_user, update_user) VALUES (2, '北京XXX', 'BJXXXX', '王小姐', '13852222222', 1, 1);
INSERT INTO `t_vendor` (id, name, code, contact, phoneNo, create_user, update_user) VALUES (3, '杭州XXX', 'HZXXXX', '赵先生', '13853333333', 1, 1);
