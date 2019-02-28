/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50513
Source Host           : localhost:3306
Source Database       : shoes

Target Server Type    : MYSQL
Target Server Version : 50513
File Encoding         : 65001

Date: 2019-02-28 23:34:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ssm_control
-- ----------------------------
DROP TABLE IF EXISTS `ssm_control`;
CREATE TABLE `ssm_control` (
  `control_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '控件id',
  `control_name` varchar(50) NOT NULL COMMENT '控件名称',
  `control_mark` varchar(50) DEFAULT NULL COMMENT '控件唯一标识',
  `page_id` int(11) DEFAULT NULL COMMENT '所属页面id',
  `remark` varchar(100) DEFAULT NULL COMMENT '控件备注',
  `create_time` datetime NOT NULL COMMENT '控件创建日期',
  `creator` int(11) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`control_id`),
  UNIQUE KEY `un_control_mark` (`control_mark`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='控件信息表';

-- ----------------------------
-- Records of ssm_control
-- ----------------------------
INSERT INTO `ssm_control` VALUES ('1', '本月业绩查看导出', 'thisMonthViewExport', '1', '战略运营部-业绩查看-本月业绩查看-导出按钮', '2017-11-15 09:13:51', '1');
INSERT INTO `ssm_control` VALUES ('2', '历史业绩查看导出', 'historyPerformanceExport', '1', '战略运营部-业绩查看-历史业绩查看-导出按钮', '2017-11-15 09:24:14', '1');
INSERT INTO `ssm_control` VALUES ('4', '单日CM1查看导出按钮', 'thisDayImport', '3', '战略运营部 -- C-M1 查看 -- 单日CM1查看 -- 导出按钮', '2017-11-20 18:15:22', '1');
INSERT INTO `ssm_control` VALUES ('5', '月度CM1查看导出按钮', 'thisMonthImport', '3', '战略运营部 -- C-M1查看 -- 月度C-M1查看 -- 导出按钮', '2017-11-20 18:17:29', '1');
INSERT INTO `ssm_control` VALUES ('6', '日数据导出按钮', 'dailyDataExport', '4', '风控中心 -- 基础数据 -- 日数据 -- 导出按钮', '2018-02-22 10:09:23', '1');
INSERT INTO `ssm_control` VALUES ('7', '月数据导出按钮', 'monthDataExport', '4', '风控中心 -- 基础数据 -- 月数据 -- 导出按钮', '2018-02-22 10:10:18', '1');
INSERT INTO `ssm_control` VALUES ('8', 'app广播', 'appBroadcast', '5', '客户端用户管理 app广播按钮', '2018-03-12 09:33:41', '1');
INSERT INTO `ssm_control` VALUES ('9', '消息推送', 'appNotification', '5', '客户端用户管理 消息推送按钮', '2018-03-12 09:34:31', '1');
INSERT INTO `ssm_control` VALUES ('10', '修改默认头像', 'appChangeProfile', '5', '客户端用户管理 修改默认头像按钮', '2018-03-12 09:35:33', '1');

-- ----------------------------
-- Table structure for ssm_control_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `ssm_control_role_relation`;
CREATE TABLE `ssm_control_role_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `control_id` int(11) NOT NULL COMMENT '控件主键',
  `role_id` int(11) NOT NULL COMMENT '角色主键',
  `creator` int(11) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ssm_control_role_relation
-- ----------------------------
INSERT INTO `ssm_control_role_relation` VALUES ('3', '1', '1', '1', '2017-11-15 09:41:43');
INSERT INTO `ssm_control_role_relation` VALUES ('4', '1', '6', '1', '2017-11-15 09:41:43');
INSERT INTO `ssm_control_role_relation` VALUES ('5', '2', '1', '1', '2017-11-15 09:41:53');
INSERT INTO `ssm_control_role_relation` VALUES ('6', '2', '7', '1', '2017-11-15 09:41:53');
INSERT INTO `ssm_control_role_relation` VALUES ('7', '4', '8', '1', '2017-11-21 09:47:19');
INSERT INTO `ssm_control_role_relation` VALUES ('8', '5', '9', '1', '2017-11-21 09:47:24');
INSERT INTO `ssm_control_role_relation` VALUES ('9', '6', '13', '1', '2018-02-22 10:22:38');
INSERT INTO `ssm_control_role_relation` VALUES ('10', '7', '14', '1', '2018-02-22 10:22:43');
INSERT INTO `ssm_control_role_relation` VALUES ('11', '8', '1', '1', '2018-03-12 09:41:17');
INSERT INTO `ssm_control_role_relation` VALUES ('12', '9', '1', '1', '2018-03-12 09:41:21');
INSERT INTO `ssm_control_role_relation` VALUES ('13', '10', '1', '1', '2018-03-12 09:41:27');

-- ----------------------------
-- Table structure for ssm_department
-- ----------------------------
DROP TABLE IF EXISTS `ssm_department`;
CREATE TABLE `ssm_department` (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dept_name` varchar(20) NOT NULL COMMENT '部门名称',
  `dept_no` varchar(30) NOT NULL COMMENT '部门编号',
  `remark` varchar(100) DEFAULT NULL COMMENT '部门描述',
  `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '上一级ID',
  `order_id` int(11) DEFAULT NULL COMMENT '排序号',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `creator` int(11) NOT NULL COMMENT '创建人',
  PRIMARY KEY (`dept_id`),
  UNIQUE KEY `un_dept_no` (`dept_no`) USING BTREE,
  UNIQUE KEY `unidx_ssm_department_dept_id` (`dept_id`) USING BTREE,
  KEY `idx_ssm_department_customer_parent_id` (`parent_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ssm_department
-- ----------------------------
INSERT INTO `ssm_department` VALUES ('5', '汇中财富', '1', '汇中财富', '0', null, '2017-03-07 10:34:30', '1');
INSERT INTO `ssm_department` VALUES ('6', '保险经纪事业部', '2', '保险经纪事业部', '5', null, '2017-03-07 10:35:29', '1');
INSERT INTO `ssm_department` VALUES ('7', '运营服务部', 'HZCF_BXJJSYB_YYFWB', '运营服务部', '6', null, '2017-03-07 10:36:35', '1');
INSERT INTO `ssm_department` VALUES ('8', '驾驶舱开发部', 'HZCD_JSC', null, '5', null, '2017-10-12 17:29:30', '1');
INSERT INTO `ssm_department` VALUES ('9', '开发一', 'HZCD_JSC_1', null, '8', null, '2017-10-12 17:29:56', '1');
INSERT INTO `ssm_department` VALUES ('10', '测试部门', '001', '', '0', null, '2019-02-28 22:38:05', '1');
INSERT INTO `ssm_department` VALUES ('11', '测试部门二级', '002', '', '10', null, '2019-02-28 22:38:19', '1');

-- ----------------------------
-- Table structure for ssm_employee
-- ----------------------------
DROP TABLE IF EXISTS `ssm_employee`;
CREATE TABLE `ssm_employee` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `name` varchar(10) DEFAULT NULL COMMENT '姓名',
  `sex` char(1) DEFAULT NULL COMMENT '性别',
  `employee_no` varchar(20) DEFAULT NULL COMMENT '员工编号',
  `email` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `password` varchar(32) DEFAULT NULL COMMENT '登录密码',
  `mobile` varchar(11) DEFAULT NULL COMMENT '移动电话',
  `telephone` varchar(13) DEFAULT NULL COMMENT '固定电话',
  `dept_id` int(11) DEFAULT NULL COMMENT '部门',
  `activated_state` char(1) DEFAULT NULL COMMENT '账号使用状态',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` int(11) DEFAULT NULL COMMENT '创建人',
  `operate_time` datetime DEFAULT NULL COMMENT '操作时间',
  `operator` int(11) DEFAULT NULL COMMENT '操作人',
  PRIMARY KEY (`employee_id`),
  UNIQUE KEY `un_employee_no` (`employee_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8 COMMENT='后台用户管理';

-- ----------------------------
-- Records of ssm_employee
-- ----------------------------
INSERT INTO `ssm_employee` VALUES ('1', '管理员', '0', 'admin', 'admin@yipuhui.com.cn', '917597f01f693e60c01d5f8b699d9bb8', '15210418375', '', '5', '1', '', '2014-01-23 14:18:22', '1', '2017-06-16 14:17:34', '1');
INSERT INTO `ssm_employee` VALUES ('92', '铁国伟', null, '201702210001rongzi', null, '61ab2d930baccf1b3e2123d3e5c874d5', '13520900000', null, null, '1', null, null, null, '2018-04-27 09:47:00', null);
INSERT INTO `ssm_employee` VALUES ('93', '徐浩', null, '201610245005', null, '61ab2d930baccf1b3e2123d3e5c874d5', '13599999999', null, null, '1', null, null, null, '2018-04-27 09:55:07', null);
INSERT INTO `ssm_employee` VALUES ('94', 'zs', null, '201509230037', null, '61ab2d930baccf1b3e2123d3e5c874d5', '13577777777', null, null, '1', null, null, null, '2018-04-27 10:24:08', null);
INSERT INTO `ssm_employee` VALUES ('95', 'zs', null, '201509230037rongzi', null, '61ab2d930baccf1b3e2123d3e5c874d5', '13577777777', null, null, '1', null, null, null, '2018-04-27 10:24:08', null);
INSERT INTO `ssm_employee` VALUES ('96', '2222222222', '1', '201702220001', '12311111@qq.com', '61ab2d930baccf1b3e2123d3e5c874d5', '13520900001', '010-56408881', '7', '1', '222', '2019-02-28 22:11:01', '1', '2019-02-28 22:35:06', '1');

-- ----------------------------
-- Table structure for ssm_employee_copy
-- ----------------------------
DROP TABLE IF EXISTS `ssm_employee_copy`;
CREATE TABLE `ssm_employee_copy` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `name` varchar(10) DEFAULT NULL COMMENT '姓名',
  `sex` char(1) DEFAULT NULL COMMENT '性别',
  `employee_no` varchar(20) DEFAULT NULL COMMENT '员工编号',
  `email` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `password` varchar(32) DEFAULT NULL COMMENT '登录密码',
  `mobile` varchar(11) DEFAULT NULL COMMENT '移动电话',
  `telephone` varchar(13) DEFAULT NULL COMMENT '固定电话',
  `dept_id` int(11) DEFAULT NULL COMMENT '部门',
  `activated_state` char(1) DEFAULT NULL COMMENT '账号使用状态',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` int(11) DEFAULT NULL COMMENT '创建人',
  `operate_time` datetime DEFAULT NULL COMMENT '操作时间',
  `operator` int(11) DEFAULT NULL COMMENT '操作人',
  PRIMARY KEY (`employee_id`),
  UNIQUE KEY `un_employee_no` (`employee_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='后台用户管理';

-- ----------------------------
-- Records of ssm_employee_copy
-- ----------------------------
INSERT INTO `ssm_employee_copy` VALUES ('1', '管理员', '0', 'admin', 'admin@yipuhui.com.cn', 'd87f77b2f690d03d3d59c0e513ba0e40', '', '', '5', '1', '', '2014-01-23 14:18:22', '1', '2017-03-16 14:37:02', '1');

-- ----------------------------
-- Table structure for ssm_employee_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `ssm_employee_permission_relation`;
CREATE TABLE `ssm_employee_permission_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'app用户权限中间表唯一标识符',
  `employee_id` int(11) DEFAULT NULL COMMENT 'app用户id',
  `permission_id` int(11) DEFAULT NULL COMMENT 'app权限id',
  `creator_id` int(11) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=417 DEFAULT CHARSET=utf8 COMMENT='app用户和权限中间表';

-- ----------------------------
-- Records of ssm_employee_permission_relation
-- ----------------------------
INSERT INTO `ssm_employee_permission_relation` VALUES ('360', '6', '7', '1', '2018-01-24 17:00:00');
INSERT INTO `ssm_employee_permission_relation` VALUES ('366', '7', '4', '1', '2018-01-29 10:54:20');
INSERT INTO `ssm_employee_permission_relation` VALUES ('367', '1', '4', '1', '2018-01-29 15:43:58');
INSERT INTO `ssm_employee_permission_relation` VALUES ('368', '35', '5', '1', '2018-02-23 15:49:41');
INSERT INTO `ssm_employee_permission_relation` VALUES ('369', '37', '6', '1', '2018-02-23 15:49:59');
INSERT INTO `ssm_employee_permission_relation` VALUES ('370', '38', '7', '1', '2018-02-23 15:50:23');
INSERT INTO `ssm_employee_permission_relation` VALUES ('371', '39', '13', '1', '2018-02-23 15:50:42');
INSERT INTO `ssm_employee_permission_relation` VALUES ('372', '40', '25', '1', '2018-02-23 15:51:10');
INSERT INTO `ssm_employee_permission_relation` VALUES ('374', '43', '5', null, null);
INSERT INTO `ssm_employee_permission_relation` VALUES ('376', '45', '10', '1', '2018-03-09 15:41:38');
INSERT INTO `ssm_employee_permission_relation` VALUES ('377', '46', '7', '45', '2018-03-09 15:50:50');
INSERT INTO `ssm_employee_permission_relation` VALUES ('378', '47', '6', '1', '2018-03-09 16:21:07');
INSERT INTO `ssm_employee_permission_relation` VALUES ('379', '48', '25', '45', '2018-03-09 16:34:25');
INSERT INTO `ssm_employee_permission_relation` VALUES ('380', '50', '1', '1', '2018-03-16 10:56:14');
INSERT INTO `ssm_employee_permission_relation` VALUES ('381', '51', '1', '1', '2018-03-16 11:01:45');
INSERT INTO `ssm_employee_permission_relation` VALUES ('382', '52', '1', '1', '2018-03-16 11:06:48');
INSERT INTO `ssm_employee_permission_relation` VALUES ('383', '53', '1', '1', '2018-04-09 14:05:42');
INSERT INTO `ssm_employee_permission_relation` VALUES ('384', '54', '4', '1', '2018-04-11 11:23:19');
INSERT INTO `ssm_employee_permission_relation` VALUES ('385', '56', '1', '1', '2018-04-12 10:32:18');
INSERT INTO `ssm_employee_permission_relation` VALUES ('386', '57', '4', '1', '2018-04-12 10:33:27');
INSERT INTO `ssm_employee_permission_relation` VALUES ('387', '59', '6', '1', '2018-04-12 10:35:38');
INSERT INTO `ssm_employee_permission_relation` VALUES ('388', '60', '6', '1', '2018-04-12 10:36:50');
INSERT INTO `ssm_employee_permission_relation` VALUES ('389', '61', '1', '1', '2018-04-12 11:23:47');
INSERT INTO `ssm_employee_permission_relation` VALUES ('390', '62', '1', '1', '2018-04-12 11:26:30');
INSERT INTO `ssm_employee_permission_relation` VALUES ('391', '63', '40', '1', '2018-04-12 12:37:42');
INSERT INTO `ssm_employee_permission_relation` VALUES ('392', '64', '1', '1', '2018-04-12 12:48:26');
INSERT INTO `ssm_employee_permission_relation` VALUES ('393', '65', '1', '1', '2018-04-12 14:50:08');
INSERT INTO `ssm_employee_permission_relation` VALUES ('394', '68', '1', '1', '2018-04-12 17:41:53');
INSERT INTO `ssm_employee_permission_relation` VALUES ('395', '70', '7', '1', '2018-04-19 15:11:17');
INSERT INTO `ssm_employee_permission_relation` VALUES ('396', '71', '8', '1', '2018-04-19 17:08:37');
INSERT INTO `ssm_employee_permission_relation` VALUES ('397', '72', '25', '1', '2018-04-20 11:28:01');
INSERT INTO `ssm_employee_permission_relation` VALUES ('398', '73', '25', '1', '2018-04-20 11:29:10');
INSERT INTO `ssm_employee_permission_relation` VALUES ('399', '74', '4', '1', '2018-04-26 17:55:35');
INSERT INTO `ssm_employee_permission_relation` VALUES ('400', '75', '562', '1', '2018-04-26 17:59:29');
INSERT INTO `ssm_employee_permission_relation` VALUES ('413', '92', '562', '1', '2018-04-27 09:47:00');
INSERT INTO `ssm_employee_permission_relation` VALUES ('414', '93', '8', '1', '2018-04-27 09:55:07');
INSERT INTO `ssm_employee_permission_relation` VALUES ('415', '94', '5', '1', '2018-04-27 10:24:08');
INSERT INTO `ssm_employee_permission_relation` VALUES ('416', '95', '562', '1', '2018-04-27 10:24:08');

-- ----------------------------
-- Table structure for ssm_employee_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `ssm_employee_role_relation`;
CREATE TABLE `ssm_employee_role_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `employee_id` int(11) NOT NULL COMMENT '员工ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `creator` int(11) NOT NULL COMMENT '创建人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unidx_crm_employee_role_relation_id` (`id`) USING BTREE,
  KEY `idx_ssm_employee_role_relation_role_id` (`role_id`) USING BTREE,
  KEY `idx_ssm_employee_role_relation_employee_id` (`employee_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ssm_employee_role_relation
-- ----------------------------
INSERT INTO `ssm_employee_role_relation` VALUES ('44', '6', '2', '2017-11-15 09:42:20', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('45', '5', '2', '2017-11-15 09:42:20', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('51', '5', '6', '2018-01-24 16:48:15', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('52', '1', '6', '2018-01-24 16:48:15', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('53', '1', '1', '2018-02-22 10:21:03', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('54', '2', '1', '2018-02-22 10:21:03', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('55', '8', '1', '2018-02-22 10:21:03', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('56', '9', '1', '2018-02-22 10:21:03', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('57', '13', '1', '2018-02-22 10:21:03', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('58', '14', '1', '2018-02-22 10:21:03', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('59', '15', '45', '2018-03-09 15:41:38', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('60', '15', '46', '2018-03-09 15:50:50', '45');
INSERT INTO `ssm_employee_role_relation` VALUES ('61', '15', '47', '2018-03-09 16:21:07', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('62', '15', '48', '2018-03-09 16:34:25', '45');
INSERT INTO `ssm_employee_role_relation` VALUES ('63', '15', '50', '2018-03-16 10:56:14', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('64', '15', '51', '2018-03-16 11:01:45', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('68', '15', '52', '2018-03-16 12:42:01', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('69', '15', '53', '2018-04-09 14:05:42', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('70', '15', '54', '2018-04-11 11:23:19', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('71', '15', '56', '2018-04-12 10:32:18', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('72', '15', '57', '2018-04-12 10:33:27', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('73', '15', '59', '2018-04-12 10:35:39', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('74', '15', '60', '2018-04-12 10:36:50', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('75', '15', '61', '2018-04-12 11:23:47', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('76', '15', '62', '2018-04-12 11:26:30', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('77', '15', '63', '2018-04-12 12:37:42', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('78', '15', '64', '2018-04-12 12:48:26', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('79', '15', '65', '2018-04-12 14:50:08', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('80', '15', '68', '2018-04-12 17:41:53', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('81', '15', '70', '2018-04-19 15:11:17', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('82', '15', '71', '2018-04-19 17:08:37', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('83', '15', '72', '2018-04-20 11:28:01', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('84', '15', '73', '2018-04-20 11:29:10', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('85', '15', '74', '2018-04-26 17:55:35', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('86', '3', '75', '2018-04-26 18:00:17', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('89', '15', '80', '2018-04-27 09:07:42', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('90', '16', '80', '2018-04-27 09:07:42', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('91', '15', '83', '2018-04-27 09:21:20', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('92', '16', '83', '2018-04-27 09:21:29', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('93', '15', '85', '2018-04-27 09:29:11', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('94', '16', '85', '2018-04-27 09:29:11', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('96', '15', '89', '2018-04-27 09:35:27', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('97', '16', '90', '2018-04-27 09:35:27', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('98', '15', '91', '2018-04-27 09:39:27', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('99', '16', '92', '2018-04-27 09:47:00', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('100', '15', '93', '2018-04-27 09:55:07', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('101', '15', '94', '2018-04-27 10:24:08', '1');
INSERT INTO `ssm_employee_role_relation` VALUES ('102', '16', '95', '2018-04-27 10:24:08', '1');

-- ----------------------------
-- Table structure for ssm_menu
-- ----------------------------
DROP TABLE IF EXISTS `ssm_menu`;
CREATE TABLE `ssm_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name_en` varchar(30) DEFAULT NULL COMMENT '菜单英文名称',
  `name_zh` varchar(30) NOT NULL COMMENT '菜单中文名称',
  `menu_url` varchar(100) DEFAULT NULL COMMENT '菜单url',
  `menu_type` char(1) DEFAULT NULL COMMENT '菜单类型 0:根节点,1:子节点',
  `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '上一级ID',
  `menu_sort` int(3) DEFAULT NULL COMMENT '排序方式',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `creator` int(11) NOT NULL COMMENT '创建人',
  `remark` varchar(100) DEFAULT NULL COMMENT '菜单描述',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ssm_menu
-- ----------------------------
INSERT INTO `ssm_menu` VALUES ('1', 'purviewManage', '权限管理', null, '0', '0', '3', '2014-01-14 14:24:27', '1', '权限管理');
INSERT INTO `ssm_menu` VALUES ('2', 'empManage', '员工管理', '/employee/toEmpList', '1', '1', '2', '2014-01-14 14:25:32', '1', '员工管理');
INSERT INTO `ssm_menu` VALUES ('3', 'menuManage', '菜单管理', '/menu/toMenuList', '1', '1', '4', '2014-01-14 14:26:32', '1', '菜单管理');
INSERT INTO `ssm_menu` VALUES ('4', 'roleManage', '角色管理', '/role/toRoleList', '1', '1', '3', '2014-01-14 14:27:05', '1', '角色管理');
INSERT INTO `ssm_menu` VALUES ('5', 'pageManage', '页面管理', '/page/toPageList', '1', '1', '5', '2014-01-15 10:31:43', '1', '页面管理');
INSERT INTO `ssm_menu` VALUES ('6', 'departmentManage', '部门管理', '/department/toListTreeDept', '1', '1', '1', '2014-01-20 16:13:57', '1', '部门管理');
INSERT INTO `ssm_menu` VALUES ('7', 'systemManage', '系统管理', null, '0', '0', '4', '2014-01-20 16:13:01', '1', '系统管理');
INSERT INTO `ssm_menu` VALUES ('8', 'refreshDictionary', '刷新字典', '/initSystemDict.servlet', '1', '7', '2', '2014-12-22 13:23:28', '1', '刷新字典');

-- ----------------------------
-- Table structure for ssm_page
-- ----------------------------
DROP TABLE IF EXISTS `ssm_page`;
CREATE TABLE `ssm_page` (
  `page_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '页面id',
  `page_name` varchar(50) NOT NULL COMMENT '页面中文名',
  `page_mark` varchar(50) DEFAULT NULL COMMENT '页面唯一标识',
  `remark` varchar(100) DEFAULT NULL COMMENT '页面备注',
  `create_time` datetime NOT NULL COMMENT '页面创建日期',
  `creator` int(11) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`page_id`),
  UNIQUE KEY `un_page_mark` (`page_mark`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='页面信息表';

-- ----------------------------
-- Records of ssm_page
-- ----------------------------
INSERT INTO `ssm_page` VALUES ('1', '业绩查看', 'stratage', '战略运营部 - 业绩查看', '2017-11-15 09:12:45', '1');
INSERT INTO `ssm_page` VALUES ('3', 'CM1查看', 'CM1View', '战略运营部 -- C-M1查看 ', '2017-11-20 18:11:52', '1');
INSERT INTO `ssm_page` VALUES ('4', '风控中心（基础数据）', 'riskBasicData', '风控中心 -- 基础数据 --日数据（月数据）', '2018-02-22 10:04:36', '1');
INSERT INTO `ssm_page` VALUES ('5', '客户端页面管理', 'appManager', '客户端页面管理 app广播 消息推送 修改默认头像按钮', '2018-03-12 09:32:38', '1');

-- ----------------------------
-- Table structure for ssm_properties
-- ----------------------------
DROP TABLE IF EXISTS `ssm_properties`;
CREATE TABLE `ssm_properties` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '系统属性配置表唯一标识符',
  `property_name` varchar(50) DEFAULT NULL COMMENT '属性名称',
  `property_string_value` varchar(512) DEFAULT NULL COMMENT 'string类型的属性值',
  `property_figure_value` decimal(15,2) DEFAULT NULL COMMENT '数字类型的属性值',
  `property_desc` varchar(512) DEFAULT NULL COMMENT '属性描述',
  `update_user_id` int(11) DEFAULT NULL COMMENT '最后修改人id',
  `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='系统属性配置表';

-- ----------------------------
-- Records of ssm_properties
-- ----------------------------
INSERT INTO `ssm_properties` VALUES ('1', 'iosVersion', '1.0.0', null, 'ios端版本号', '1', '2017-07-11 15:21:17');
INSERT INTO `ssm_properties` VALUES ('2', 'iosNewContent', '1.新增xxx\\n2.修改xxx', null, 'ios端新版本内容', null, null);
INSERT INTO `ssm_properties` VALUES ('3', 'iosDownloadUrl', 'https://itunes.apple.com/cn/app/%E4%B8%9A%E5%8A%A1%E7%9B%91%E6%8E%A7%E5%AE%A4/id1250314537?mt=8', null, 'ios端新版本下载地址', '1', '2017-07-10 00:00:00');
INSERT INTO `ssm_properties` VALUES ('4', 'androidVersion', '1.0.1', null, 'Android端版本号', null, null);
INSERT INTO `ssm_properties` VALUES ('5', 'androidNewContent', '1.新增xxx\\n2.修改xxx', null, 'Android端新版本内容', null, null);
INSERT INTO `ssm_properties` VALUES ('6', 'androidDownloadUrl', 'http://openbox.mobilem.360.cn/index/d/sid/3858913', null, 'Android端新版本下载地址', null, null);
INSERT INTO `ssm_properties` VALUES ('7', 'isShowRegister', 'true', null, '是否在ios端展示注册入口,true表示展示,false表示不展示', null, null);
INSERT INTO `ssm_properties` VALUES ('8', 'CheckLogMessagePushPhones', '', null, '校验BI抽取数据异常消息推送手机号,多个手机号中间用逗号隔开', null, null);
INSERT INTO `ssm_properties` VALUES ('9', 'CheckLogMessageSendPhones', '', null, '校验BI抽取数据异常短信发送手机号,多个手机号中间用逗号隔开', '1', '2017-09-11 17:33:47');
INSERT INTO `ssm_properties` VALUES ('10', 'checkLogSendEmails', 'tieguowei@huizhongcf.com,xuhao2@huizhongcf.com,guodong@huizhongcf.com', null, '检查日报表发送人邮箱,多个邮箱用,逗号隔开', null, null);
INSERT INTO `ssm_properties` VALUES ('11', 'checkSubcenterIsNullSendEmails', 'tieguowei@huizhongcf.com,sunxue@huizhongcf.com', null, '检查营业部是否编辑分中心发送人邮箱,多个邮箱用,逗号隔开', null, null);
INSERT INTO `ssm_properties` VALUES ('16', 'overdueRemindDay', '4', null, null, '1', '2018-04-08 09:28:27');

-- ----------------------------
-- Table structure for ssm_role
-- ----------------------------
DROP TABLE IF EXISTS `ssm_role`;
CREATE TABLE `ssm_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_code` varchar(30) NOT NULL COMMENT '角色代码',
  `role_name` varchar(30) NOT NULL COMMENT '角色中文名',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `creator` int(11) NOT NULL COMMENT '创建人',
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `un_role_code` (`role_code`) USING BTREE,
  UNIQUE KEY `un_role_name` (`role_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of ssm_role
-- ----------------------------
INSERT INTO `ssm_role` VALUES ('1', 'ROLE_ADMIN', '超级管理员权限', '拥有所有菜单权限和所有按钮操作权限!', '2014-03-11 10:53:55', '1');
INSERT INTO `ssm_role` VALUES ('2', 'ROLE_MANAGEMONEY', '理财管理', '理财管理', '2017-05-13 09:48:11', '1');
INSERT INTO `ssm_role` VALUES ('3', 'ROLE_FINANCING', '融资管理', '融资管理', '2017-05-13 09:48:54', '1');
INSERT INTO `ssm_role` VALUES ('4', 'ROLE_RISK', '风控中心', '风控中心', '2017-10-16 15:31:04', '1');
INSERT INTO `ssm_role` VALUES ('5', 'ROLE_STRATEGIC', '战略运营部', '战略运营部', '2017-11-15 09:19:44', '1');
INSERT INTO `ssm_role` VALUES ('6', 'ROLE_STRATEGIC_THISMONTHEXPORT', '本月业绩导出', '战略运营部-业绩查看-本月业绩查看-导出按钮', '2017-11-15 09:40:20', '1');
INSERT INTO `ssm_role` VALUES ('7', 'ROLE_STRATEGIC_HISTORYEXPORT', '历史业绩查看导出', '战略运营部-业绩查看-历史业绩查看-导出按钮', '2017-11-15 09:41:16', '1');
INSERT INTO `ssm_role` VALUES ('8', 'ROLE_STRATEGIC_DAYCM1IMPORT', '单日CM1查看导出', '战略运营部 -- CM1查看 -- 单日C-M1查看 -- 导出按钮', '2017-11-21 09:44:02', '1');
INSERT INTO `ssm_role` VALUES ('9', 'ROLE_STRATEGIC_MONTHCM1IMPORT', '月度CM1查看导出', '战略运营部 -- CM1查看 --月度C-M1查看 -- 导出按钮', '2017-11-21 09:46:05', '1');
INSERT INTO `ssm_role` VALUES ('13', 'ROLE_RISK_BASIC_DAILYDATA', '日数据导出按钮', '风控中心 -- 基础数据 -- 日数据 -- 导出按钮', '2018-02-22 10:19:28', '1');
INSERT INTO `ssm_role` VALUES ('14', 'ROLE_RISK_BASIC_MONTHDATA', '月数据导出按钮', '风控中心 -- 基础数据 -- 月数据 -- 导出按钮', '2018-02-22 10:20:06', '1');
INSERT INTO `ssm_role` VALUES ('15', 'ROLE_RISK_COMMON', '风控中心公共权限', '风控中心用户 拥有公共权限', '2018-03-09 14:21:56', '1');
INSERT INTO `ssm_role` VALUES ('16', 'ROLE_RONGZI_COMMON', '融资公共权限', '融资公共权限', '2018-04-26 19:05:39', '1');

-- ----------------------------
-- Table structure for ssm_role_menu_relation
-- ----------------------------
DROP TABLE IF EXISTS `ssm_role_menu_relation`;
CREATE TABLE `ssm_role_menu_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `menu_id` int(11) NOT NULL COMMENT '菜单ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `creator` int(11) NOT NULL COMMENT '创建人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unidx_crm_role_menu_relation_id` (`id`) USING BTREE,
  KEY `idx_ssm_role_menu_relation_role_id` (`role_id`) USING BTREE,
  KEY `idx_ssm_role_menu_relation_menu_id` (`menu_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=153 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ssm_role_menu_relation
-- ----------------------------
INSERT INTO `ssm_role_menu_relation` VALUES ('1', '1', '2', '2015-07-15 14:12:36', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('2', '1', '3', '2015-07-15 16:53:16', '0');
INSERT INTO `ssm_role_menu_relation` VALUES ('3', '1', '4', '2015-07-15 16:53:19', '0');
INSERT INTO `ssm_role_menu_relation` VALUES ('4', '1', '5', '2015-07-15 16:53:23', '0');
INSERT INTO `ssm_role_menu_relation` VALUES ('5', '1', '6', '2015-07-15 16:53:26', '0');
INSERT INTO `ssm_role_menu_relation` VALUES ('6', '1', '8', '2015-07-15 16:53:29', '0');
INSERT INTO `ssm_role_menu_relation` VALUES ('11', '1', '14', '2017-02-23 15:31:38', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('17', '1', '23', '2017-04-07 10:28:46', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('18', '1', '16', '2017-05-13 09:49:41', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('19', '2', '16', '2017-05-13 09:49:41', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('20', '1', '17', '2017-05-13 09:50:27', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('21', '2', '17', '2017-05-13 09:50:27', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('22', '1', '18', '2017-05-13 09:51:15', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('23', '2', '18', '2017-05-13 09:51:15', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('24', '1', '19', '2017-05-13 09:51:52', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('25', '2', '19', '2017-05-13 09:51:52', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('26', '1', '20', '2017-05-13 09:52:34', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('27', '2', '20', '2017-05-13 09:52:34', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('28', '1', '21', '2017-05-13 10:04:54', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('32', '1', '30', '2017-05-23 09:16:33', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('33', '3', '30', '2017-05-23 09:16:33', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('42', '1', '34', '2017-06-09 13:03:32', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('43', '2', '34', '2017-06-09 13:03:32', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('46', '1', '40', '2017-07-11 15:17:40', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('47', '1', '36', '2017-07-27 10:08:14', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('48', '1', '37', '2017-07-27 10:08:22', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('49', '1', '41', '2017-08-01 10:49:19', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('51', '1', '42', '2017-09-14 16:09:07', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('52', '1', '44', '2017-09-26 11:52:53', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('53', '1', '46', '2017-10-16 15:31:34', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('54', '4', '46', '2017-10-16 15:31:34', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('55', '1', '47', '2017-10-16 16:26:55', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('56', '4', '47', '2017-10-16 16:26:55', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('57', '1', '48', '2017-10-16 16:52:13', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('58', '4', '48', '2017-10-16 16:52:13', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('61', '1', '49', '2017-10-17 11:51:35', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('62', '4', '49', '2017-10-17 11:51:35', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('69', '1', '50', '2017-11-08 15:00:19', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('70', '4', '50', '2017-11-08 15:00:19', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('74', '1', '53', '2017-11-13 10:39:32', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('76', '1', '52', '2017-11-13 10:50:31', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('83', '1', '55', '2017-11-15 09:20:28', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('84', '5', '55', '2017-11-15 09:20:28', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('85', '1', '56', '2017-11-15 09:20:59', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('86', '5', '56', '2017-11-15 09:20:59', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('87', '1', '60', '2017-11-15 09:21:03', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('88', '5', '60', '2017-11-15 09:21:03', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('95', '1', '57', '2017-11-15 16:31:02', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('96', '5', '57', '2017-11-15 16:31:02', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('97', '1', '58', '2017-11-15 16:31:07', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('98', '5', '58', '2017-11-15 16:31:07', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('101', '1', '64', '2017-11-16 09:18:13', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('102', '5', '59', '2017-11-17 16:45:59', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('103', '1', '59', '2017-11-17 16:45:59', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('105', '1', '63', '2017-11-21 11:33:06', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('106', '1', '61', '2017-11-21 12:46:51', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('107', '1', '62', '2017-11-21 12:46:57', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('108', '5', '62', '2017-11-21 12:46:57', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('109', '1', '65', '2017-11-27 14:25:23', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('110', '1', '66', '2017-12-21 09:30:16', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('111', '4', '66', '2017-12-21 09:30:16', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('112', '1', '67', '2017-12-28 14:22:54', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('121', '1', '68', '2018-03-09 15:44:56', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('122', '15', '68', '2018-03-09 15:44:56', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('123', '1', '69', '2018-03-09 15:45:02', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('124', '15', '69', '2018-03-09 15:45:02', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('126', '1', '71', '2018-03-09 15:45:12', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('127', '15', '71', '2018-03-09 15:45:12', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('128', '1', '72', '2018-03-09 15:45:19', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('129', '15', '72', '2018-03-09 15:45:19', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('130', '1', '70', '2018-03-09 15:45:52', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('131', '15', '70', '2018-03-09 15:45:52', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('136', '1', '24', '2018-04-27 09:36:45', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('137', '2', '24', '2018-04-27 09:36:45', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('138', '3', '24', '2018-04-27 09:36:45', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('139', '15', '24', '2018-04-27 09:36:45', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('140', '16', '24', '2018-04-27 09:36:45', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('141', '1', '31', '2018-04-27 09:36:52', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('142', '3', '31', '2018-04-27 09:36:52', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('143', '16', '31', '2018-04-27 09:36:52', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('144', '1', '32', '2018-04-27 09:37:06', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('145', '3', '32', '2018-04-27 09:37:06', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('146', '16', '32', '2018-04-27 09:37:06', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('147', '1', '33', '2018-04-27 09:37:10', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('148', '3', '33', '2018-04-27 09:37:10', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('149', '16', '33', '2018-04-27 09:37:10', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('150', '1', '35', '2018-04-27 09:37:15', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('151', '3', '35', '2018-04-27 09:37:15', '1');
INSERT INTO `ssm_role_menu_relation` VALUES ('152', '16', '35', '2018-04-27 09:37:15', '1');

-- ----------------------------
-- Table structure for ssm_work_group
-- ----------------------------
DROP TABLE IF EXISTS `ssm_work_group`;
CREATE TABLE `ssm_work_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `employee_id` int(11) DEFAULT NULL COMMENT '员工id',
  `dept_id` int(11) DEFAULT NULL COMMENT '部门id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unidx_crm_work_group_id` (`id`) USING BTREE,
  KEY `idx_ssm_work_group_customer_employee_id` (`employee_id`) USING BTREE,
  KEY `idx_ssm_work_group_customer_dept_id` (`dept_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ssm_work_group
-- ----------------------------
INSERT INTO `ssm_work_group` VALUES ('4', '52', '5');
INSERT INTO `ssm_work_group` VALUES ('5', '52', '6');
INSERT INTO `ssm_work_group` VALUES ('6', '52', '7');
INSERT INTO `ssm_work_group` VALUES ('7', '35', '5');
INSERT INTO `ssm_work_group` VALUES ('8', '35', '6');
INSERT INTO `ssm_work_group` VALUES ('9', '35', '7');
INSERT INTO `ssm_work_group` VALUES ('10', '1', '5');
INSERT INTO `ssm_work_group` VALUES ('11', '1', '6');
INSERT INTO `ssm_work_group` VALUES ('12', '1', '7');

-- ----------------------------
-- Table structure for system_dict
-- ----------------------------
DROP TABLE IF EXISTS `system_dict`;
CREATE TABLE `system_dict` (
  `dict_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dict_type` varchar(30) DEFAULT NULL COMMENT '字典类别',
  `dict_type_name` varchar(30) DEFAULT NULL COMMENT '字典类别名称',
  `dict_name` varchar(30) DEFAULT NULL COMMENT '字典名称',
  `dict_code` varchar(15) DEFAULT NULL COMMENT '字典代码',
  `status` char(1) DEFAULT NULL COMMENT '状态',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `parent_id` int(11) DEFAULT NULL COMMENT '父类',
  `order_id` int(11) DEFAULT NULL COMMENT '排序号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`dict_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='系统字典';

-- ----------------------------
-- Records of system_dict
-- ----------------------------
INSERT INTO `system_dict` VALUES ('1', 'SEX', '性别', '男', '0', '1', null, null, '1', '2015-08-24 10:27:10');
INSERT INTO `system_dict` VALUES ('2', 'SEX', '性别', '女', '1', '1', null, null, '2', '2015-08-24 10:27:12');
INSERT INTO `system_dict` VALUES ('10', 'SYSTEM_CODE', '系统编码标识', 'SYSTEM_CRM', 'SYSTEM_CRM', '1', null, null, '1', '2015-09-15 14:39:04');
INSERT INTO `system_dict` VALUES ('11', 'SYSTEM_CODE', '系统编码标识', 'SYSTEM_ONLINE', 'SYSTEM_ONLINE', '1', null, null, '2', '2015-09-15 14:39:06');
INSERT INTO `system_dict` VALUES ('21', 'REGISTER_SOURCE', '注册来源', 'PC', '1', '1', null, null, '1', '2015-07-22 16:13:57');
INSERT INTO `system_dict` VALUES ('22', 'REGISTER_SOURCE', '注册来源', 'IOS', '2', '1', null, null, '2', '2015-07-22 16:14:20');
INSERT INTO `system_dict` VALUES ('23', 'REGISTER_SOURCE', '注册来源', 'Android', '3', '1', null, null, '3', '2015-07-22 16:14:50');
INSERT INTO `system_dict` VALUES ('24', 'REGISTER_SOURCE', '注册来源', 'WeChat', '4', '1', null, null, '4', '2016-02-24 15:13:12');

-- ----------------------------
-- Procedure structure for get_cm1_grading_data
-- ----------------------------
DROP PROCEDURE IF EXISTS `get_cm1_grading_data`;
DELIMITER ;;
CREATE DEFINER=`flagship`@`%` PROCEDURE `get_cm1_grading_data`(IN inDate varchar(20),IN inOrgs varchar(20480),IN inType varchar(10),IN inMonth varchar(10),IN startIndex int,IN pageSize int,IN dataType varchar(10))
    READS SQL DATA
BEGIN
#dataType 1表示日数据,2表示月数据
SET @SQL = NULL;
SET @date = inDate;
SET @orgs = inOrgs;
SET @type = inType;
SET @month = inMonth;
SET @subSQL = '';

SET SESSION group_concat_max_len=21845;
SELECT GROUP_CONCAT( DISTINCT CONCAT('IFNULL(CONCAT(CONVERT(MAX(IF(batch= \'',CASE batch WHEN 's' THEN '散标' WHEN 'r' THEN '任意还款日'
	ELSE DATE_FORMAT(batch,'%d')
	END,''', payed_money, 0))/MAX(IF(batch= \'',CASE batch WHEN 's' THEN '散标' WHEN 'r' THEN '任意还款日'
	ELSE DATE_FORMAT(batch,'%d')
	END,''', repayment_money, 0))*100,decimal(10,2)) ,\'%\'),\'--\') AS ''',CASE batch WHEN 's' THEN '散标' WHEN 'r' THEN '任意还款日'
	ELSE DATE_FORMAT(batch,'%d')
	END,'\'')) INTO @SQL
FROM(
	SELECT DISTINCT(batch)
	FROM f_risk_loan_cm1
	WHERE type=@type
	AND `month`=@month
	AND record_date = @date
	ORDER BY batch) a;

SELECT IFNULL(@SQL,'\'--\'') INTO @SQL FROM dual;


IF ('1'=dataType)
		THEN SET @subSQL=CONCAT('\'',@date,'\' 日期');
		ELSE SET @subSQL=CONCAT('\'',DATE_FORMAT(@date,'%Y-%m'),'\' 月份');
		END IF;


SET @SQL =  CONCAT('SELECT org_name 机构,
 			 CASE \'',@type,'\'
			WHEN \'1\' THEN \'整体\'
			WHEN \'2\' THEN \'6期前\'
			WHEN \'3\' THEN \'6期后\'
			END AS 类型,',@SQL,', ',@subSQL,' ,IFNULL(CONCAT(CONVERT(SUM(payed_money)/SUM(repayment_money)*100,decimal(10,2)) ,\'%\'),\'--\') \'C-M1回款率\' ',
' FROM (
				SELECT cm1.org_no, o.org_name,
					(CASE batch WHEN \'s\' THEN \'s\'
					WHEN \'r\' THEN \'r\'
					ELSE DATE_FORMAT(batch,\'%d\')
					END) batch,
					SUM(payed_money) payed_money,
					SUM(repayment_money) repayment_money
				FROM
					f_risk_loan_cm1 cm1
		
				LEFT JOIN (
					SELECT m.org_no,
						(CASE 
							WHEN s.org_short_name is null THEN m.org_name
							WHEN s.org_short_name=\'\' THEN m.org_name
							ELSE s.org_short_name 
							END) org_name,
						m.rank,
						m.parent_no,
						m.create_time
					FROM
						(
							SELECT org_no, org_name, rank, parent_no, create_time
							FROM
								(
									SELECT org_no, org_name, rank, parent_no, create_time
									FROM f_risk_org_struct
									ORDER BY create_time DESC
								) a
							JOIN (
								SELECT create_time_first, org_no2
								FROM
									(
										SELECT create_time create_time_first, org_no org_no2
										FROM f_risk_org_struct
										ORDER BY create_time
									) f
								GROUP BY
									org_no2
							) c ON a.org_no = c.org_no2
							WHERE
								create_time < DATE_ADD(\'',@date,'\', INTERVAL 2 DAY)
							OR create_time = create_time_first
							ORDER BY
								create_time DESC
						) m
				LEFT JOIN 
					(
							SELECT org_no, org_short_name
							FROM
								(
									SELECT org_no, org_short_name
									FROM
										(
											SELECT org_no, org_short_name, create_time
											FROM f_risk_org_data
											ORDER BY create_time DESC
										) a
									JOIN (
										SELECT create_time_first, org_no2
										FROM
											(
												SELECT create_time create_time_first, org_no org_no2
												FROM f_risk_org_data
												ORDER BY create_time
											) f
										GROUP BY
											org_no2
									) c ON a.org_no = c.org_no2
									WHERE
										create_time < DATE_ADD(\'',@date,'\', INTERVAL 2 DAY)
									OR create_time = create_time_first
									ORDER BY
										create_time DESC
								) m
							GROUP BY
								org_no
				)	s ON m.org_no=s.org_no
				GROUP BY
					m.org_no
				) o ON cm1.org_no = o.org_no
				WHERE record_date=\'',@date,'\' 
				AND cm1.org_no IN (',@orgs,')
		
				AND cm1.month=\'',@month,'\' 
				AND cm1.type=\'',@type,'\' 
				GROUP BY
					cm1.org_no,
					cm1.batch
		) a GROUP BY org_no
		
		LIMIT ',startIndex,',',pageSize,'');

#SELECT @SQL FROM dual;

PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;
 
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for get_email_data
-- ----------------------------
DROP PROCEDURE IF EXISTS `get_email_data`;
DELIMITER ;;
CREATE DEFINER=`flagship`@`%` PROCEDURE `get_email_data`(IN inDate varchar(20),IN inType varchar(10),IN inOrg varchar(200)
,IN inMonth varchar(20),IN lastMonthDay varchar(20),IN lastMonth varchar(20),IN times int)
    READS SQL DATA
BEGIN

SET @SQL = NULL;
SET @date=inDate;
SET @type=inType ;
SET @org=inOrg;
SET @month=inMonth;
SET @lastMonthDay=lastMonthDay;
SET @lastMonth=lastMonth;
SET SESSION group_concat_max_len=21845;

IF times=1
	THEN SET @tempOrg=inOrg;
ELSE  SET @tempOrg=inOrg='aaa';
END IF;  

SELECT
	GROUP_CONCAT(
		DISTINCT CONCAT(
			'max(IF(batch= \'',
			batch,
			''', payed_num, 0)) AS ''',
			CASE batch WHEN 's' THEN '散标'
			ELSE batch
			END,
			' 实回款笔数\',',
			
			'max(IF(batch= \'',
			batch,
			''', repayment_num, 0)) AS ''',
				CASE batch WHEN 's' THEN '散标'
			ELSE batch
			END,
			' 应回款笔数\',',

			'max(IF(batch= \'',
			batch,
			''', cm1_value, 0)) AS ''',
				CASE batch WHEN 's' THEN '散标'
			ELSE batch
			END,
			' C-M1回款率\''
		)
	) INTO @SQL
FROM(
	SELECT DISTINCT(batch)
	FROM
		f_risk_loan_cm1
	WHERE record_date=@date
	AND type=@type
	AND `month`=@month
	AND org_no=@org
	ORDER BY batch
) b;

SELECT IFNULL(@SQL,'\'--\'') INTO @SQL FROM dual;

SET @SQL = CONCAT('SELECT REPLACE(p.product_name,\'.\',\'·\') \'产品\',
	#tc.t_repayment_num-tc.t_payed_num \'还需回款几笔\',
	#IFNULL(w.warning_level,\'\') \'预警状态\',
	#IFNULL(wv.warning_value,\'--\') \'C-M1预警线\',
	#\'8%\' as \'M1+逾期率线\',
	#IFNULL(lc.last_month_cm1,\'--\') \'上月回款率\',
	#CASE  WHEN m1.loan_num=NULL OR  m1.loan_num>=20  THEN \'--\' ELSE 	IFNULL( m1.loan_num,\'--\') END \'逾期率-近6个月放款笔数\',
	#CASE WHEN m1.loan_num=NULL OR  m1.loan_num>=20  THEN \'--\' ELSE 	IFNULL( m1.total_principal_interest,\'--\') END \'逾期率-近6个月借款本息\',
	#CASE WHEN m1.loan_num=NULL OR  m1.loan_num>=20  THEN \'--\' ELSE 	IFNULL( m1.overdue_principal_interest,\'--\') END \'逾期率-截止到25日M1+剩余本息\',
	#CASE WHEN m1.loan_num=NULL OR  m1.loan_num>=20  THEN \'--\' ELSE 	IFNULL( m1.m1_value,\'--\') END \'逾期率-近6个月M1+逾期率\',
	tc.t_repayment_num-tc.t_payed_num \'本月总计逾期笔数\',
	tc.t_repayment_num \'本月总计应回款笔数\',
	tc.t_payed_money \'本月实还在贷余额\',
	tc.t_repayment_money \'本月应还在贷余额\',
	IFNULL(tc.t_cm1_value,\'--\') \'本月总计C-M1回款率\',',
@SQL,	
' FROM
(
		SELECT batch,product_no,SUM(payed_num) payed_num ,SUM(repayment_num) repayment_num,
			CONCAT(CONVERT(SUM(payed_money)/SUM(repayment_money)*100,decimal(10,2)),\'%\') cm1_value
		FROM f_risk_loan_cm1
		WHERE record_date=\'',@date,'\'
		AND `month`=\'',@month,'\'
		AND type=\'',@type,'\'
		AND org_no=\'',@org,'\'
		GROUP BY product_no,batch

		UNION

		SELECT batch,\'总计\' product_no,SUM(payed_num) payed_num,SUM(repayment_num) repayment_num,
			CONCAT(CONVERT(SUM(payed_money)/SUM(repayment_money)*100,decimal(10,2)),\'%\') cm1_value
			
		FROM f_risk_loan_cm1
		WHERE record_date=\'',@date,'\'
		AND `month`=\'',@month,'\'
		AND type=\'',@type,'\'
		AND org_no=\'',@org,'\'
		GROUP BY batch
	) cm1

LEFT JOIN(
			SELECT product_no,SUM(payed_num) t_payed_num,SUM(repayment_num) t_repayment_num,
			SUM(payed_money) t_payed_money,SUM(repayment_money) t_repayment_money,
			CONCAT(convert(SUM(payed_money)/SUM(repayment_money)*100,decimal(10,2)),\'%\') t_cm1_value
		FROM f_risk_loan_cm1
		WHERE record_date=\'',@date,'\'
		AND `month`=\'',@month,'\'
		AND type=\'',@type,'\'
		AND org_no=\'',@org,'\'
		GROUP BY product_no

		UNION

		SELECT \'总计\' product_no,SUM(payed_num) t_payed_num,SUM(repayment_num) t_repayment_num,
			SUM(payed_money) t_payed_money,SUM(repayment_money) t_repayment_money,
			CONCAT(convert(SUM(payed_money)/SUM(repayment_money)*100,decimal(10,2)),\'%\') t_cm1_value
		FROM f_risk_loan_cm1
		WHERE record_date=\'',@date,'\'
		AND `month`=\'',@month,'\'
		AND type=\'',@type,'\'
		AND org_no=\'',@org,'\'


) tc ON cm1.product_no=tc.product_no


LEFT JOIN(
	SELECT product_no,warning_level 
	FROM f_risk_warning_level
	WHERE record_date = \'',@date,'\'
	AND org_no = \'',@org,'\') w ON cm1.product_no=w.product_no


LEFT JOIN(
				SELECT
			product_no,
			 CONCAT(CONVERT(warning_value*100,decimal(10,2)),\'%\') warning_value
		FROM
			(
				SELECT
					product_no,
					warning_value
				FROM
					(
						SELECT
							product_no,
							warning_value,
							create_time
						FROM
							f_risk_product_warning
					
						ORDER BY
							create_time DESC
					) a
				JOIN (
					SELECT
						create_time_first,
						product_no2
					FROM
						(
							SELECT
								create_time create_time_first,
								product_no product_no2
							FROM
								f_risk_product_warning
							ORDER BY
								create_time
						) f
					GROUP BY
						product_no2
				) c ON a.product_no = c.product_no2
				WHERE
					create_time < DATE_ADD(\'',@date,'\', INTERVAL 2 DAY)
				OR create_time = create_time_first
				ORDER BY
					create_time DESC
			) m
		GROUP BY
			product_no

	) wv ON cm1.product_no=wv.product_no 


LEFT JOIN(
		SELECT product_no,
			CONCAT(CONVERT(SUM(payed_money)/SUM(repayment_money)*100,decimal(10,2)),\'%\') last_month_cm1
		FROM f_risk_loan_cm1
		WHERE record_date= \'',@lastMonthDay,'\'
		AND `month` = \'',@lastMonth,'\'
		AND org_no=\'',@org,'\'
		AND type=\'',@type,'\'
		GROUP BY product_no

		UNION

		SELECT \'总计\' product_no,
			CONCAT(CONVERT(SUM(payed_money)/SUM(repayment_money)*100,decimal(10,2)),\'%\') last_month_cm1
		FROM f_risk_loan_cm1
		WHERE record_date= \'',@lastMonthDay,'\'
		AND `month` = \'',@lastMonth,'\'
		AND org_no=\'',@org,'\'
		AND type=\'',@type,'\'

) lc ON cm1.product_no=lc.product_no


LEFT JOIN(
			SELECT product_no,SUM(loan_num) loan_num,SUM(total_principal_interest) total_principal_interest,SUM(overdue_principal_interest) overdue_principal_interest,
				CONCAT(CONVERT(SUM(overdue_principal_interest)/SUM(total_principal_interest)*100,decimal(10,2)),\'%\') m1_value
			FROM f_risk_loan_m1_overdue
			WHERE org_no=\'',@tempOrg,'\'
			AND record_date=\'',@date,'\'
			GROUP BY product_no
			UNION

			SELECT \'总计\' product_no,SUM(loan_num) loan_num,SUM(total_principal_interest) total_principal_interest,
			SUM(overdue_principal_interest) overdue_principal_interest,
			CONCAT(CONVERT(SUM(overdue_principal_interest)/SUM(total_principal_interest)*100,decimal(10,2)),\'%\') m1_value
			FROM f_risk_loan_m1_overdue
			WHERE org_no=\'',@tempOrg,'\'
			AND record_date=\'',@date,'\'

) m1 ON cm1.product_no=m1.product_no


LEFT JOIN(
		SELECT
		product_no,
		product_name
		FROM
		(
			SELECT
				product_no,
				product_name
			FROM
				(
					SELECT
						product_no,
						product_name,
						create_time
					FROM
						f_risk_product
					
					ORDER BY
						create_time DESC
				) a
			JOIN (
				SELECT
					create_time_first,
					product_no2
				FROM
					(
						SELECT
							create_time create_time_first,
							product_no product_no2
						FROM
							f_risk_product
						ORDER BY
							create_time
					) f
				GROUP BY
					product_no2
			) c ON a.product_no = c.product_no2
			WHERE
				create_time < DATE_ADD(\'',@date,'\', INTERVAL 2 DAY)
			OR create_time = create_time_first
			ORDER BY
				create_time DESC
		) m
		GROUP BY
		product_no

UNION
SELECT \'总计\' product_no,\'总计\' product_name FROM dual

) p ON cm1.product_no=p.product_no


GROUP BY cm1.product_no'
);
#SELECT @SQL FROM dual;
PREPARE stmt
FROM
	@SQL;

EXECUTE stmt;

DEALLOCATE PREPARE stmt;


END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for get_loan_after_batch_cm1
-- ----------------------------
DROP PROCEDURE IF EXISTS `get_loan_after_batch_cm1`;
DELIMITER ;;
CREATE DEFINER=`flagship`@`%` PROCEDURE `get_loan_after_batch_cm1`(IN inDate varchar(20),IN inMonth VARCHAR(20))
    READS SQL DATA
BEGIN

SET @SQL = NULL;
SET @date = inDate;
SET @month = inMonth;
SET SESSION group_concat_max_len=21845;


SELECT GROUP_CONCAT( DISTINCT CONCAT('IFNULL(CONCAT(CONVERT(MAX(IF(batch= \'',CASE batch WHEN 's' THEN '散标'
	ELSE DATE_FORMAT(batch,'%c-%e')
	END,''', payed_money, 0))/MAX(IF(batch= \'',CASE batch WHEN 's' THEN '散标'
	ELSE DATE_FORMAT(batch,'%c-%e')
	END,''', repayment_money, 0))*100,decimal(10,2)) ,\'%\'),\'--\') AS ''',CASE batch WHEN 's' THEN '散标'
	ELSE DATE_FORMAT(batch,'%c-%e')
	END,'\'')) INTO @SQL
FROM(
	SELECT batch
	FROM f_risk_loan_cm1
	WHERE record_date = @date
	AND type='3'
	AND `month`=@month
	ORDER BY batch) a;

SELECT IFNULL(@SQL,'\'--\'') INTO @SQL FROM dual;


SET @SQL =  CONCAT('SELECT \'整体\' AS \'整体\' ,',
@SQL,', IFNULL(CONCAT(CONVERT(SUM(payed_money)/SUM(repayment_money)*100,decimal(10,2)) ,\'%\'),\'--\') \'总计\'',
' FROM(
SELECT
(CASE batch WHEN \'s\' THEN \'散标\'
	ELSE DATE_FORMAT(batch,\'%c-%e\')
	END) batch,
	SUM(payed_money) payed_money,SUM(repayment_money) repayment_money
FROM f_risk_loan_cm1 cm1
LEFT JOIN(
	SELECT DISTINCT(org_no),rank 
	FROM f_risk_org_struct
) o ON o.org_no=cm1.org_no
WHERE type=\'3\'
AND rank=3
AND month=\'',@month,'\'
AND record_date=\'',@date,'\'GROUP BY batch) a');

PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for get_org_batch_cm1
-- ----------------------------
DROP PROCEDURE IF EXISTS `get_org_batch_cm1`;
DELIMITER ;;
CREATE DEFINER=`flagship`@`%` PROCEDURE `get_org_batch_cm1`(IN inDate varchar(20),IN inOrgs varchar(20480),IN inType varchar(10),IN inMonth varchar(10))
    READS SQL DATA
BEGIN
SET @SQL = NULL;
SET @date = inDate;
SET @orgs = inOrgs;
SET @type = inType;
SET @month = inMonth;

SET SESSION group_concat_max_len=21845;
SELECT GROUP_CONCAT( DISTINCT CONCAT('IFNULL(CONCAT(CONVERT(MAX(IF(batch= \'',CASE batch WHEN 's' THEN '散标'
	ELSE DATE_FORMAT(batch,'%c-%e')
	END,''', payed_money, 0))/MAX(IF(batch= \'',CASE batch WHEN 's' THEN '散标'
	ELSE DATE_FORMAT(batch,'%c-%e')
	END,''', repayment_money, 0))*100,decimal(10,2)) ,\'%\'),\'--\') AS ''',CASE batch WHEN 's' THEN '散标'
	ELSE DATE_FORMAT(batch,'%c-%e')
	END,'\'')) INTO @SQL
FROM(
	SELECT DISTINCT(batch)
	FROM f_risk_loan_cm1
	WHERE type=@type
	AND `month`=@month
	AND record_date = @date
	ORDER BY batch) a;

SELECT IFNULL(@SQL,'\'--\'') INTO @SQL FROM dual;



SET @SQL =  CONCAT('SELECT org_no orgNo,org_name \'大区\',',
@SQL,', IFNULL(CONCAT(CONVERT(SUM(payed_money)/SUM(repayment_money)*100,decimal(10,2)) ,\'%\'),\'--\') \'总计\'',
' FROM (
SELECT
	cm1.org_no,
	o.org_name,
	
	(CASE batch WHEN \'s\' THEN \'散标\'
	ELSE DATE_FORMAT(batch,\'%c-%e\')
	END) batch,
	SUM(payed_money) payed_money,
	SUM(repayment_money) repayment_money
FROM
	f_risk_loan_cm1 cm1

LEFT JOIN (SELECT
	m.org_no,
	(CASE 
		WHEN s.org_short_name is null THEN m.org_name
		WHEN s.org_short_name=\'\' THEN m.org_name
		ELSE s.org_short_name 
		END) org_name,
	m.rank,
	m.parent_no,
	m.create_time
	
FROM
	(
		SELECT
			org_no,
			org_name,
			rank,
			parent_no,
			create_time
		FROM
			(
				SELECT
					org_no,
					org_name,
					rank,
					parent_no,
					create_time
				FROM
					f_risk_org_struct
				
				ORDER BY
					create_time DESC
			) a
		JOIN (
			SELECT
				create_time_first,
				org_no2
			FROM
				(
					SELECT
						create_time create_time_first,
						org_no org_no2
					FROM
						f_risk_org_struct
					ORDER BY
						create_time
				) f
			GROUP BY
				org_no2
		) c ON a.org_no = c.org_no2
		WHERE
			create_time < DATE_ADD(\'',@date,'\', INTERVAL 2 DAY)
		OR create_time = create_time_first
		ORDER BY
			create_time DESC
	) m
	LEFT JOIN 
			(
					SELECT
					org_no,
					org_short_name
					FROM
						(
							SELECT
								org_no,
								org_short_name
							FROM
								(
									SELECT
										org_no,
										org_short_name,
										create_time
									FROM
										f_risk_org_data
									ORDER BY
										create_time DESC
								) a
							JOIN (
								SELECT
									create_time_first,
									org_no2
								FROM
									(
										SELECT
											create_time create_time_first,
											org_no org_no2
										FROM
											f_risk_org_data
										ORDER BY
											create_time
									) f
								GROUP BY
									org_no2
							) c ON a.org_no = c.org_no2
							WHERE
								create_time < DATE_ADD(\'',@date,'\', INTERVAL 2 DAY)
							OR create_time = create_time_first
							ORDER BY
								create_time DESC
						) m
					GROUP BY
						org_no
)	s ON m.org_no=s.org_no
GROUP BY
	m.org_no
) o ON cm1.org_no = o.org_no
WHERE record_date=\'',@date,'\' 
AND cm1.org_no IN (',@orgs,')
AND cm1.month=\'',@month,'\'
AND cm1.type=\'',@type,'\' 
GROUP BY
	cm1.org_no,
	cm1.batch
) a GROUP BY org_no');
#SELECT @sql FROM dual;
SET @SQL= CONCAT('SELECT b.*,
	(
			SELECT COUNT(*)+1 FROM 
			(',@SQL,') t WHERE REPLACE(t.`总计`,\'%\',\'\')+0>REPLACE(b.`总计`,\'%\',\'\')+0
			
	) AS \'排名\'

 FROM (',@SQL,') b ORDER BY `排名`');

PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;
 
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for get_org_month_cm1
-- ----------------------------
DROP PROCEDURE IF EXISTS `get_org_month_cm1`;
DELIMITER ;;
CREATE DEFINER=`flagship`@`%` PROCEDURE `get_org_month_cm1`(IN beginDate varchar(20),IN endDate varchar(20),IN inOrgs varchar(20480),IN inType varchar(10),IN dataType varchar(10))
    READS SQL DATA
BEGIN
#dataType为1时不带总计数据,为2时带总计数据
SET @SQL = NULL;
SET @dates = NULL;
SET @head = NULL;
SET @beginDate = beginDate;
SET @endDate = endDate;
SET @orgs = inOrgs;
SET @type = inType;



SET SESSION group_concat_max_len=21845;

SELECT GROUP_CONCAT( DISTINCT CONCAT(
'MAX(IF(record_date = \'',rep_date,'\' ,cm1_value, 0)) AS \'',rep_month,'月\''
) ) INTO @head
FROM(
SELECT DISTINCT rep_date,rep_month
FROM f_date_week
WHERE rep_day=26
AND rep_date<=@endDate
AND rep_date>=@beginDate
ORDER BY rep_date DESC) a;


SELECT GROUP_CONCAT(CONCAT('\'',rep_date,'\'')) INTO @dates
FROM f_date_week
WHERE rep_day=26
AND rep_date<=@endDate
AND rep_date>=@beginDate;


SELECT IFNULL(@SQL,'\'--\'') INTO @SQL FROM dual;


SET @SQL =  CONCAT('SELECT org_no orgNo,org_name 机构,',
@head,
' FROM (

SELECT cm1.org_no,org.org_name,cm1.record_date,SUM(payed_num)/SUM(repayment_num) cm1_value
FROM f_risk_loan_cm1 cm1
LEFT JOIN(
	
			SELECT
				s.org_no,
				(CASE 
					WHEN d.org_short_name is null THEN s.org_name
					WHEN d.org_short_name=\'\' THEN s.org_name
					ELSE d.org_short_name 
					END) org_name
			FROM (
				SELECT *
				FROM (
					SELECT * 
					FROM f_risk_org_struct
					ORDER BY create_time DESC
				) a
				GROUP BY org_no
			) s
			LEFT JOIN (

			SELECT *
			FROM(
				SELECT *
				FROM f_risk_org_data
				ORDER BY create_time DESC
			)b
			GROUP BY org_no

			)d ON s.org_no=d.org_no

) org ON cm1.org_no=org.org_no
WHERE cm1.record_date IN(',@dates,')
AND cm1.org_no IN(',@orgs,')
AND `month`=DATE_FORMAT(record_date,\'%Y%m\')
AND type=\'',@type,'\' 
GROUP BY cm1.org_no,cm1.record_date
) a
GROUP BY org_no');

IF ('2'=dataType)
		THEN SET @SQL=CONCAT(@SQL,
	' 
		UNION ALL 
		SELECT org_no,org_name 机构,',@head,
		' FROM (

		SELECT \'\' org_no,\'总计\' org_name,record_date,SUM(payed_num)/SUM(repayment_num) cm1_value
		FROM f_risk_loan_cm1 cm1
		WHERE cm1.record_date IN(',@dates,')
		AND cm1.org_no IN(',@orgs,')
		AND `month`=DATE_FORMAT(record_date,\'%Y%m\')
		AND type=\'',@type,'\' 
		GROUP BY cm1.record_date
		) a
		GROUP BY org_no;'
			);
		END IF;

#SELECT @SQL FROM dual;

PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;
 
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for get_org_product_cm1
-- ----------------------------
DROP PROCEDURE IF EXISTS `get_org_product_cm1`;
DELIMITER ;;
CREATE DEFINER=`flagship`@`%` PROCEDURE `get_org_product_cm1`(IN inDate varchar(20),IN inOrgs varchar(20480),IN inType varchar(10),IN inMonth varchar(10))
    READS SQL DATA
BEGIN
SET @SQL = NULL;
SET @date = inDate ;
SET @orgs = inOrgs ;
SET @type = inType ;
SET @month = inMonth ;

SET SESSION group_concat_max_len=21845;
SELECT
GROUP_CONCAT(
DISTINCT CONCAT(
'IFNULL(CONCAT(CONVERT(MAX(IF(product_name= \'',
product_name,
''', payed_money, 0))/MAX(IF(product_name= \'',product_name,''', repayment_money, 0))*100,decimal(10,2)) ,\'%\'),\'--\') AS ''',
REPLACE(product_name,'.','αα'),
'\''
)
) INTO @SQL
FROM
f_risk_loan_cm1 cm1
LEFT JOIN (
	SELECT
	product_no,
	product_name
FROM
	(
		SELECT
			product_no,
			product_name
		FROM
			(
				SELECT
					product_no,
					product_name,
					create_time
				FROM
					f_risk_product
				ORDER BY
					create_time DESC
			) a
		JOIN (
			SELECT
				create_time_first,
				product_no2
			FROM
				(
					SELECT
						create_time create_time_first,
						product_no product_no2
					FROM
						f_risk_product
					ORDER BY
						create_time
				) f
			GROUP BY
				product_no2
		) c ON a.product_no = c.product_no2
		WHERE
			create_time < DATE_ADD(@date, INTERVAL 2 DAY)
		OR create_time = create_time_first
		ORDER BY
			create_time DESC
	) m
GROUP BY
	product_no
) p ON cm1.product_no = p.product_no
WHERE cm1.record_date=@date
AND type=@type;

SELECT IFNULL(@SQL,'\'--\'') INTO @SQL FROM dual;

SET @SQL = CONCAT(
'SELECT org_no orgNo ,org_name \'大区\',
IFNULL(CONCAT(CONVERT(SUM(payed_money)/SUM(repayment_money)*100,decimal(10,2)) ,\'%\'),\'--\') \'总计\',',
@SQL,
' FROM (
SELECT
	cm1.org_no,
	o.org_name,
	p.product_name,
	SUM(payed_money) payed_money,
	SUM(repayment_money) repayment_money
FROM
	f_risk_loan_cm1 cm1
LEFT JOIN (
	SELECT
		product_no,
		product_name
	FROM
		(
			SELECT
				product_no,
				product_name
			FROM
				(
					SELECT
						product_no,
						product_name,
						create_time
					FROM
						f_risk_product
					ORDER BY
						create_time DESC
				) a
			JOIN (
				SELECT
					create_time_first,
					product_no2
				FROM
					(
						SELECT
							create_time create_time_first,
							product_no product_no2
						FROM
							f_risk_product
						ORDER BY
							create_time
					) f
				GROUP BY
					product_no2
			) c ON a.product_no = c.product_no2
			WHERE
				create_time < DATE_ADD(\'',@date,'\', INTERVAL 2 DAY)
			OR create_time = create_time_first
			ORDER BY
				create_time DESC
		) m
	GROUP BY
		product_no
) p ON cm1.product_no = p.product_no
LEFT JOIN (
	SELECT
	m.org_no,
	(CASE 
		WHEN s.org_short_name is null THEN m.org_name
		WHEN s.org_short_name=\'\' THEN m.org_name
		ELSE s.org_short_name 
		END) org_name,
	m.rank,
	m.parent_no,
	m.create_time
	
FROM
	(
		SELECT
			org_no,
			org_name,
			rank,
			parent_no,
			create_time
		FROM
			(
				SELECT
					org_no,
					org_name,
					rank,
					parent_no,
					create_time
				FROM
					f_risk_org_struct
				
				ORDER BY
					create_time DESC
			) a
		JOIN (
			SELECT
				create_time_first,
				org_no2
			FROM
				(
					SELECT
						create_time create_time_first,
						org_no org_no2
					FROM
						f_risk_org_struct
					ORDER BY
						create_time
				) f
			GROUP BY
				org_no2
		) c ON a.org_no = c.org_no2
		WHERE
			create_time < DATE_ADD(\'',@date,'\', INTERVAL 2 DAY)
		OR create_time = create_time_first
		ORDER BY
			create_time DESC
	) m
	LEFT JOIN 
		(
				SELECT
				org_no,
				org_short_name
				FROM
					(
						SELECT
							org_no,
							org_short_name
						FROM
							(
								SELECT
									org_no,
									org_short_name,
									create_time
								FROM
									f_risk_org_data
								ORDER BY
									create_time DESC
							) a
						JOIN (
							SELECT
								create_time_first,
								org_no2
							FROM
								(
									SELECT
										create_time create_time_first,
										org_no org_no2
									FROM
										f_risk_org_data
									ORDER BY
										create_time
								) f
							GROUP BY
								org_no2
						) c ON a.org_no = c.org_no2
						WHERE
							create_time < DATE_ADD(\'',@date,'\', INTERVAL 2 DAY)
						OR create_time = create_time_first
						ORDER BY
							create_time DESC
					) m
				GROUP BY
					org_no
)	s ON m.org_no=s.org_no
GROUP BY
	m.org_no
) o ON cm1.org_no = o.org_no
WHERE record_date=\'',@date,'\' 
AND cm1.org_no IN (',@orgs,')
AND type=\'',@type,'\' 
AND `month`=\'',@month,'\' 
GROUP BY
	cm1.org_no,
	cm1.product_no) a
	GROUP BY org_no'

);

PREPARE stmt
FROM
@SQL;

EXECUTE stmt;

DEALLOCATE PREPARE stmt;
 
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for get_product_batch_cm1
-- ----------------------------
DROP PROCEDURE IF EXISTS `get_product_batch_cm1`;
DELIMITER ;;
CREATE DEFINER=`flagship`@`%` PROCEDURE `get_product_batch_cm1`(IN inDate varchar(20),IN inMonth varchar(10),IN inType varchar(10))
    READS SQL DATA
BEGIN

SET @SQL = NULL;
SET @date = inDate ;
SET @month = inMonth ;
SET @type = inType ;
SET SESSION group_concat_max_len=21845;


SELECT GROUP_CONCAT( DISTINCT CONCAT('IFNULL(CONCAT(CONVERT(MAX(IF(batch= \'',CASE batch WHEN 's' THEN '散标'
	ELSE DATE_FORMAT(batch,'%c-%e')
	END,''', payed_money, 0))/MAX(IF(batch= \'',CASE batch WHEN 's' THEN '散标'
	ELSE DATE_FORMAT(batch,'%c-%e')
	END,''', repayment_money, 0))*100,decimal(10,2)) ,\'%\'),\'--\') AS ''',CASE batch WHEN 's' THEN '散标'
	ELSE DATE_FORMAT(batch,'%c-%e')
	END,'\'')) INTO @SQL
FROM(
	SELECT DISTINCT(batch)
	FROM f_risk_loan_cm1
	WHERE type=@type
	AND `month`=@month
	AND record_date = @date
	ORDER BY batch) a;


SELECT IFNULL(@SQL,'\'--\'') INTO @SQL FROM dual;


SET @SQL =  CONCAT('SELECT product_name AS \'产品\' ,',
@SQL,', IFNULL(CONCAT(CONVERT(SUM(payed_money)/SUM(repayment_money)*100,decimal(10,2)) ,\'%\'),\'--\') \'总计\'',
' FROM(
SELECT
p.product_name,
cm1.product_no,
(CASE batch WHEN \'s\' THEN \'散标\'
	ELSE DATE_FORMAT(batch,\'%c-%e\')
	END) batch,
	SUM(payed_money) payed_money,SUM(repayment_money) repayment_money
FROM f_risk_loan_cm1 cm1
LEFT JOIN(
	SELECT DISTINCT(org_no),rank 
	FROM f_risk_org_struct
) o ON o.org_no=cm1.org_no
LEFT JOIN(
SELECT
	product_no,
	product_name
FROM
	(
		SELECT
			product_no,
			product_name
		FROM
			(
				SELECT
					product_no,
					product_name,
					create_time
				FROM
					f_risk_product
				ORDER BY
					create_time DESC
			) a
		JOIN (
			SELECT
				create_time_first,
				product_no2
			FROM
				(
					SELECT
						create_time create_time_first,
						product_no product_no2
					FROM
						f_risk_product
					ORDER BY
						create_time
				) f
			GROUP BY
				product_no2
		) c ON a.product_no = c.product_no2
		WHERE
			create_time < DATE_ADD(\'',@date,'\', INTERVAL 2 DAY)
		OR create_time = create_time_first
		ORDER BY
			create_time DESC
	) m
GROUP BY
	product_no

) p ON cm1.product_no=p.product_no

WHERE type=\'',@type,'\'
AND rank=3
AND record_date=\'',@date,'\'
AND `month`=\'',@month,'\'
GROUP BY product_no,batch) a
GROUP BY product_no');

PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for get_subcenter_month_cm1
-- ----------------------------
DROP PROCEDURE IF EXISTS `get_subcenter_month_cm1`;
DELIMITER ;;
CREATE DEFINER=`flagship`@`%` PROCEDURE `get_subcenter_month_cm1`(IN beginDate varchar(20),IN endDate varchar(20),IN dataType varchar(10))
    READS SQL DATA
BEGIN
#dataType为1时不带总计数据,为2时带总计数据
SET @SQL = NULL;
SET @dates = NULL;
SET @head = NULL;
SET @beginDate = beginDate;
SET @endDate = endDate;


SET SESSION group_concat_max_len=21845;

SELECT GROUP_CONCAT( DISTINCT CONCAT(
'MAX(IF(record_date = \'',rep_date,'\' ,cm1_value, 0)) AS \'',rep_month,'月\''
) ) INTO @head
FROM(
SELECT DISTINCT rep_date,rep_month
FROM f_date_week
WHERE rep_day=26
AND rep_date<=@endDate
AND rep_date>=@beginDate
ORDER BY rep_date DESC) a;


SELECT GROUP_CONCAT(CONCAT('\'',rep_date,'\'')) INTO @dates
FROM f_date_week
WHERE rep_day=26
AND rep_date<=@endDate
AND rep_date>=@beginDate;


SELECT IFNULL(@SQL,'\'--\'') INTO @SQL FROM dual;


SET @SQL =  CONCAT('SELECT subcenter_no orgNo,short_name 机构,',
@head,
'  FROM (
SELECT org.subcenter_no,org.short_name,cm1.record_date,SUM(payed_num)/SUM(repayment_num) cm1_value
FROM f_risk_loan_cm1 cm1
JOIN (
	SELECT org_short_name, org_no,subcenter_no,short_name
	FROM(
				SELECT org.org_short_name, org.org_no,org.subcenter_no,sub.short_name
				FROM f_risk_org_data org
				JOIN (
						SELECT subcenter_no,`status`,short_name
						FROM(
								SELECT subcenter_no,`status`,short_name
								FROM f_risk_subcenter
								ORDER BY create_time DESC
						) rul
						GROUP BY rul.subcenter_no
				) sub ON org.subcenter_no=sub.subcenter_no AND sub.`status`=1
				ORDER BY create_time DESC
			) a 
	GROUP BY org_no
) org ON cm1.org_no=org.org_no

WHERE cm1.record_date IN(',@dates,')
AND `month`=DATE_FORMAT(record_date,\'%Y%m\')
AND type=\'2\'
GROUP BY org.subcenter_no,cm1.record_date
) a
GROUP BY subcenter_no');


IF ('2'=dataType)
		THEN SET @SQL=CONCAT(@SQL,
	' 
		UNION ALL
		SELECT \'\' subcenter_no,\'总计\' 机构,',@head,
		' FROM (

		SELECT cm1.record_date,SUM(payed_num)/SUM(repayment_num) cm1_value
		FROM f_risk_loan_cm1 cm1
		JOIN (
			SELECT org_short_name, org_no,subcenter_no,short_name
			FROM(
						SELECT org.org_short_name, org.org_no,org.subcenter_no,sub.short_name
						FROM f_risk_org_data org
						JOIN (
								SELECT subcenter_no,`status`,short_name
								FROM(
										SELECT subcenter_no,`status`,short_name
										FROM f_risk_subcenter
										ORDER BY create_time DESC
								) rul
								GROUP BY rul.subcenter_no
						) sub ON org.subcenter_no=sub.subcenter_no AND sub.`status`=1
						ORDER BY create_time DESC
					) a 
			GROUP BY org_no
		) org ON cm1.org_no=org.org_no

		WHERE cm1.record_date IN(',@dates,')
		AND `month`=DATE_FORMAT(record_date,\'%Y%m\')
		AND type=\'2\'
		GROUP BY record_date
		) record_date;'
			);
		END IF;

#SELECT @SQL FROM dual;

PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;
 
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for get_zw_batch_cm1
-- ----------------------------
DROP PROCEDURE IF EXISTS `get_zw_batch_cm1`;
DELIMITER ;;
CREATE DEFINER=`flagship`@`%` PROCEDURE `get_zw_batch_cm1`(IN inDate varchar(20),IN inMonth varchar(10))
    READS SQL DATA
BEGIN
SET @SQL = NULL;
SET @date = inDate;
SET @month = inMonth;

SET SESSION group_concat_max_len=21845;
SELECT GROUP_CONCAT( DISTINCT CONCAT('IFNULL(CONCAT(CONVERT(MAX(IF(batch= \'',CASE batch WHEN 's' THEN '散标'
	ELSE DATE_FORMAT(batch,'%c-%e')
	END,''', payed_money, 0))/MAX(IF(batch= \'',CASE batch WHEN 's' THEN '散标'
	ELSE DATE_FORMAT(batch,'%c-%e')
	END,''', repayment_money, 0))*100,decimal(10,2)) ,\'%\'),\'--\') AS ''',CASE batch WHEN 's' THEN '散标'
	ELSE DATE_FORMAT(batch,'%c-%e')
	END,'\'')) INTO @SQL
FROM(
	SELECT DISTINCT(batch)
	FROM f_risk_loan_cm1
	WHERE type!='3'
	AND`month`=@month
	AND record_date = @date
	ORDER BY batch) a;

SELECT IFNULL(@SQL,'\'--\'') INTO @SQL FROM dual;

#SELECT @SQL FROM dual;

SET @SQL =  CONCAT('SELECT \'整体\' orgName,',
	@SQL,
	', IFNULL(CONCAT(CONVERT(SUM(payed_money)/SUM(repayment_money)*100,decimal(10,2)) ,\'%\'),\'--\') \'总计\'',
	' FROM(
		SELECT 
				(CASE batch 
					WHEN \'s\' THEN \'散标\'
					ELSE DATE_FORMAT(batch,\'%c-%e\')
					END) batch,
			SUM(payed_money) payed_money,
			SUM(repayment_money) repayment_money
		FROM f_risk_loan_cm1
		WHERE record_date=\'',@date,'\'
		AND type=\'1\'
		AND `month`=\'',@month,'\'
		AND org_no IN (
			SELECT DISTINCT(org_no)
			FROM f_risk_org_struct
			WHERE rank=3)
		GROUP BY batch
	)a
	UNION ALL ' ,


	'SELECT org_name \'大区\',',
	@SQL,
	', IFNULL(CONCAT(CONVERT(SUM(payed_money)/SUM(repayment_money)*100,decimal(10,2)) ,\'%\'),\'--\') \'总计\'',
	' FROM (
	SELECT
		cm1.org_no,
		o.org_name,
		
		(CASE batch WHEN \'s\' THEN \'散标\'
		ELSE DATE_FORMAT(batch,\'%c-%e\')
		END) batch,
		SUM(payed_money) payed_money,
		SUM(repayment_money) repayment_money
	FROM
		f_risk_loan_cm1 cm1

	LEFT JOIN (SELECT
		m.org_no,
		(CASE 
			WHEN s.org_short_name is null THEN m.org_name
			WHEN s.org_short_name=\'\' THEN m.org_name
			ELSE s.org_short_name 
			END) org_name,
		m.rank,
		m.parent_no,
		m.create_time
		
	FROM
		(
			SELECT
				org_no,
				org_name,
				rank,
				parent_no,
				create_time
			FROM
				(
					SELECT
						org_no,
						org_name,
						rank,
						parent_no,
						create_time
					FROM
						f_risk_org_struct
					
					ORDER BY
						create_time DESC
				) a
			JOIN (
				SELECT
					create_time_first,
					org_no2
				FROM
					(
						SELECT
							create_time create_time_first,
							org_no org_no2
						FROM
							f_risk_org_struct
						ORDER BY
							create_time
					) f
				GROUP BY
					org_no2
			) c ON a.org_no = c.org_no2
			WHERE
				create_time < DATE_ADD(\'',@date,'\', INTERVAL 2 DAY)
			OR create_time = create_time_first
			ORDER BY
				create_time DESC
		) m
		LEFT JOIN 
				(
						SELECT
						org_no,
						org_short_name
						FROM
							(
								SELECT
									org_no,
									org_short_name
								FROM
									(
										SELECT
											org_no,
											org_short_name,
											create_time
										FROM
											f_risk_org_data
										ORDER BY
											create_time DESC
									) a
								JOIN (
									SELECT
										create_time_first,
										org_no2
									FROM
										(
											SELECT
												create_time create_time_first,
												org_no org_no2
											FROM
												f_risk_org_data
											ORDER BY
												create_time
										) f
									GROUP BY
										org_no2
								) c ON a.org_no = c.org_no2
								WHERE
									create_time < DATE_ADD(\'',@date,'\', INTERVAL 2 DAY)
								OR create_time = create_time_first
								ORDER BY
									create_time DESC
							) m
						GROUP BY
							org_no
	)	s ON m.org_no=s.org_no
	GROUP BY
		m.org_no
	) o ON cm1.org_no = o.org_no
	WHERE record_date=\'',@date,'\' 
	AND cm1.org_no IN (
		SELECT DISTINCT(org_no)
		FROM f_risk_org_struct
		WHERE rank=3)
	AND cm1.month=\'',@month,'\'
	AND cm1.type=\'2\' 
	GROUP BY
		cm1.org_no,
		cm1.batch
	) a GROUP BY org_no');

#SELECT @sql FROM dual;
PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;
 
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for init_f_date_week
-- ----------------------------
DROP PROCEDURE IF EXISTS `init_f_date_week`;
DELIMITER ;;
CREATE DEFINER=`flagship`@`%` PROCEDURE `init_f_date_week`(in start_date VARCHAR(20),in date_count int)
BEGIN
    DECLARE count INT DEFAULT 0;
    DECLARE startDay DATE DEFAULT start_date;
    DECLARE nowYear    INT(11); 
    DECLARE nowWeek INT(11);   
    DECLARE oneWeek    INT(11); 
    
    WHILE count<date_count 
      
 DO
      SET nowYear = DATE_FORMAT(startDay ,'%Y');
      SET oneWeek = WEEK(CONCAT(nowYear,'-01-01'),1); 
      SET nowWeek = WEEK(startDay ,1);
    IF oneWeek=0 THEN SET nowWeek = nowWeek+1;
    END IF;
    IF nowWeek>53 THEN SET nowWeek = 53;
    END IF;
       
 INSERT INTO f_date_week(rep_date,rep_year,rep_month,rep_day,rep_week) VALUES (startDay,YEAR(startDay),MONTH(startDay),DAY(startDay),nowWeek);
        SET count=count+1;
        SET startDay=DATE_ADD(start_date,INTERVAL count DAY);
 	
    END WHILE;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for insert_default_cm1
-- ----------------------------
DROP PROCEDURE IF EXISTS `insert_default_cm1`;
DELIMITER ;;
CREATE DEFINER=`flagship`@`%` PROCEDURE `insert_default_cm1`(nowDate varchar(20))
    READS SQL DATA
BEGIN

	INSERT INTO f_risk_loan_cm1 (record_date,type,org_no,product_no,`month`,batch,payed_num,repayment_num,cm1_value,create_time)
	(
		SELECT nowDate,type,org_no,product_no,`month`,batch,payed_num,repayment_num,cm1_value,create_time
		FROM f_risk_loan_cm1
		WHERE record_date=DATE_SUB(nowDate ,INTERVAL 1 DAY)
		AND `month`=DATE_FORMAT(nowDate,'%Y%m')
		AND batch IN(
			SELECT DISTINCT batch
			FROM f_risk_loan_cm1
			WHERE record_date=DATE_SUB(nowDate ,INTERVAL 1 DAY)
			AND `month`=DATE_FORMAT(nowDate,'%Y%m')
			AND batch NOT IN(
				SELECT DISTINCT batch 
				FROM f_risk_loan_cm1
				WHERE record_date=nowDate
			)
		)
	);
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for RUN_DEL_F_FINANCE_MONTH_DISTRICT
-- ----------------------------
DROP PROCEDURE IF EXISTS `RUN_DEL_F_FINANCE_MONTH_DISTRICT`;
DELIMITER ;;
CREATE DEFINER=`flagship`@`%` PROCEDURE `RUN_DEL_F_FINANCE_MONTH_DISTRICT`()
    SQL SECURITY INVOKER
BEGIN
IF DATE_FORMAT(SYSDATE(), '%d') = '01' THEN
	DELETE
FROM
	f_finance_month_district
WHERE
	date_format(record_date, '%Y%m%d') = CONCAT(
		date_format(
			date_sub(sysdate(), INTERVAL 1 DAY),
			'%Y%m'
		),
		'01'
	);
COMMIT;
END
IF;
commit;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for RUN_DEL_F_FINANCE_MONTH_ORG
-- ----------------------------
DROP PROCEDURE IF EXISTS `RUN_DEL_F_FINANCE_MONTH_ORG`;
DELIMITER ;;
CREATE DEFINER=`flagship`@`%` PROCEDURE `RUN_DEL_F_FINANCE_MONTH_ORG`()
BEGIN
IF DATE_FORMAT(SYSDATE(), '%d') = '01' THEN
	DELETE
FROM
	f_finance_month_org
WHERE
	date_format(record_date, '%Y%m%d') = CONCAT(
		date_format(
			date_sub(SYSDATE(), INTERVAL 1 DAY),
			'%Y%m'
		),
		'01'
	);
COMMIT;
END
IF;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for RUN_DEL_F_FINANCE_MONTH_PERFORMANCE
-- ----------------------------
DROP PROCEDURE IF EXISTS `RUN_DEL_F_FINANCE_MONTH_PERFORMANCE`;
DELIMITER ;;
CREATE DEFINER=`flagship`@`%` PROCEDURE `RUN_DEL_F_FINANCE_MONTH_PERFORMANCE`()
BEGIN

IF DATE_FORMAT(SYSDATE(), '%d') = '01' THEN
	DELETE
FROM
	f_finance_month_performance
WHERE
	date_format(record_date, '%Y%m%d') = CONCAT(
		date_format(
			date_sub(SYSDATE(), INTERVAL 1 DAY),
			'%Y%m'
		),
		'01'
	);

COMMIT;


END
IF;
COMMIT;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for RUN_DEL_F_MONEYMGR_ACCUMU_PERFORMANCE
-- ----------------------------
DROP PROCEDURE IF EXISTS `RUN_DEL_F_MONEYMGR_ACCUMU_PERFORMANCE`;
DELIMITER ;;
CREATE DEFINER=`flagship`@`%` PROCEDURE `RUN_DEL_F_MONEYMGR_ACCUMU_PERFORMANCE`()
BEGIN
	-- 清除目标表旧数据
	DELETE from F_MONEYMGR_ACCUMU_PERFORMANCE
WHERE
	date_format(record_date, '%Y%m') = date_format(
		date_sub(SYSDATE(), INTERVAL 1 DAY),
		'%Y%m'
	);
COMMIT;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for RUN_DEL_F_MONEYMGR_DAILY_PERFORMANCE
-- ----------------------------
DROP PROCEDURE IF EXISTS `RUN_DEL_F_MONEYMGR_DAILY_PERFORMANCE`;
DELIMITER ;;
CREATE DEFINER=`flagship`@`%` PROCEDURE `RUN_DEL_F_MONEYMGR_DAILY_PERFORMANCE`()
BEGIN
	-- 清除目标表旧数据
	DELETE from F_MONEYMGR_DAILY_PERFORMANCE

WHERE
	date_format(record_date, '%Y%m') = date_format(
		date_sub(SYSDATE(), INTERVAL 1 DAY),
		'%Y%m'
	);
COMMIT;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for RUN_DEL_F_MONEYMGR_DISTRICT_ACCUMU_PERFORMANCE
-- ----------------------------
DROP PROCEDURE IF EXISTS `RUN_DEL_F_MONEYMGR_DISTRICT_ACCUMU_PERFORMANCE`;
DELIMITER ;;
CREATE DEFINER=`flagship`@`%` PROCEDURE `RUN_DEL_F_MONEYMGR_DISTRICT_ACCUMU_PERFORMANCE`()
BEGIN
	-- 清除目标表旧数据
	DELETE from F_MONEYMGR_DISTRICT_ACCUMU_PERFORMANCE

WHERE
	date_format(record_date, '%Y%m') = date_format(
		date_sub(SYSDATE(), INTERVAL 1 DAY),
		'%Y%m'
	);
COMMIT;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for RUN_DEL_F_MONEYMGR_ORG_ACCUMU_PERFORMANCE
-- ----------------------------
DROP PROCEDURE IF EXISTS `RUN_DEL_F_MONEYMGR_ORG_ACCUMU_PERFORMANCE`;
DELIMITER ;;
CREATE DEFINER=`flagship`@`%` PROCEDURE `RUN_DEL_F_MONEYMGR_ORG_ACCUMU_PERFORMANCE`()
BEGIN
	-- 清除目标表旧数据
	DELETE from F_MONEYMGR_ORG_ACCUMU_PERFORMANCE

WHERE
	date_format(record_date, '%Y%m') = date_format(
		date_sub(SYSDATE(), INTERVAL 1 DAY),
		'%Y%m'
	);
COMMIT;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for str_spilt
-- ----------------------------
DROP PROCEDURE IF EXISTS `str_spilt`;
DELIMITER ;;
CREATE DEFINER=`flagship`@`%` PROCEDURE `str_spilt`(str varchar(2000),param varchar(50))
BEGIN  
    #分割字符串，用逗号隔开  
    set @i=0;  
    #如果不存在，择创建一个用于保存分割字符串后数据的临时表str_spilt_result  
    CREATE TEMPORARY TABLE if not exists str_spilt_result(id BIGINT(20) NOT NULL);     
    #清空临时表  
    truncate table str_spilt_result;    
    SET @cnt = 1+(LENGTH(str) - LENGTH(REPLACE(str,param,'')));    
    WHILE @i < @cnt DO    
        SET @i = @i + 1;    
        SET @result = REVERSE(SUBSTRING_INDEX(REVERSE(SUBSTRING_INDEX(str,param,@i)),param,1));  
        #把数据插入临时表1  
        INSERT INTO str_spilt_result(id) VALUES (@result);    
    END WHILE;    
    SELECT * from str_spilt_result;   
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for str_spilt_test_copy
-- ----------------------------
DROP PROCEDURE IF EXISTS `str_spilt_test_copy`;
DELIMITER ;;
CREATE DEFINER=`flagship`@`%` PROCEDURE `str_spilt_test_copy`(rootId varchar(2000),goalRank int)
BEGIN  
    
    set @temp=rootId;
		set @sql='select org_no from f_risk_org_struct where parent_no in(';
		
    
		SELECT rank INTO @thisRank FROM f_risk_org_struct WHERE org_no=rootId;
    
   set @times=1;
    WHILE @thisRank < goalRank-1
			DO set @sql=CONCAT(@sql,@sql);
					SET @thisRank=@thisRank+1;
					SET @times=@times+1;
			END WHILE;
	SET @sql = CONCAT( @sql,'\'',rootId,'\'');
	
	set @i=0;
		WHILE @i < @times
				DO SET @sql=CONCAT(@sql,')');
						SET @i=@i+1;
		END WHILE ;

	SELECT @sql FROM dual;
    
  
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for f_bet_month
-- ----------------------------
DROP FUNCTION IF EXISTS `f_bet_month`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `f_bet_month`(`start_date` date,`end_date` date) RETURNS int(11)
BEGIN
	

	RETURN TIMESTAMPDIFF(MONTH,start_date,end_date);
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for f_get_belong_bu_ranking
-- ----------------------------
DROP FUNCTION IF EXISTS `f_get_belong_bu_ranking`;
DELIMITER ;;
CREATE DEFINER=`flagship`@`%` FUNCTION `f_get_belong_bu_ranking`(inOrg varchar(50),inDate varchar(20),inMonth varchar(20)) RETURNS int(11)
BEGIN
#计算营业部所在事业部的C-M1回款率排名
	DECLARE this_org VARCHAR(50);
	DECLARE this_rank int DEFAULT 0;
	DECLARE orgs VARCHAR(21845);
	DECLARE ranking int DEFAULT 0;

	SET this_org=inOrg;
	WHILE (this_rank != 3) DO
			
			SELECT org_no,rank INTO this_org,this_rank
			FROM f_risk_org_struct
			WHERE org_no=(
					SELECT parent_no 
					FROM f_risk_org_struct
					WHERE org_no=this_org
					ORDER BY create_time DESC
					LIMIT 1)
			ORDER BY create_time DESC
			LIMIT 1;
		
	END WHILE;
	


	SELECT COUNT(*)+1 INTO ranking
	FROM(
		SELECT c.org_no,SUM(payed_num)/SUM(repayment_num) cm1
		FROM f_risk_loan_cm1 c
		LEFT JOIN (
			SELECT org_no,rank,parent_no FROM(
				SELECT org_no,rank,parent_no
				FROM f_risk_org_struct
				ORDER BY create_time DESC
			) o GROUP BY org_no
		) o2 ON c.org_no=o2.org_no AND o2.parent_no in(SELECT org_no FROM f_risk_org_struct WHERE parent_no=this_org)
		WHERE rank=5
		AND c.type='2'
		AND `month`=inMonth
		AND c.record_date=inDate
		GROUP BY org_no	
	) a
	WHERE cm1>(
			SELECT SUM(payed_num)/SUM(repayment_num) FROM f_risk_loan_cm1
			WHERE type='2'	
			AND `month`=inMonth
			AND org_no=inOrg
			AND record_date=inDate
		);

	RETURN ranking;
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for f_ret_dept_id
-- ----------------------------
DROP FUNCTION IF EXISTS `f_ret_dept_id`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `f_ret_dept_id`(`v_dept_id` int) RETURNS varchar(50) CHARSET utf8
BEGIN

  /*临时变量*/
	DECLARE v_temp_dept_id VARCHAR(50) DEFAULT "";

	/*父部门id*/
	DECLARE v_parent_id INT DEFAULT 0;

	SELECT d.parent_id INTO v_parent_id from ssm_department d where d.dept_id = v_dept_id;

	IF (v_parent_id != 0) THEN
		 SET v_temp_dept_id = v_dept_id;
		 WHILE (v_parent_id != 0) DO 
			SET v_temp_dept_id = CONCAT(v_parent_id,",",v_temp_dept_id);
			SELECT d.parent_id INTO v_parent_id from ssm_department d where d.dept_id = v_parent_id;
		 END WHILE;
	ELSE
		SET v_temp_dept_id = v_dept_id;
	END IF;

	RETURN v_temp_dept_id;
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for f_ret_dept_name
-- ----------------------------
DROP FUNCTION IF EXISTS `f_ret_dept_name`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `f_ret_dept_name`(`v_dept_id` int) RETURNS varchar(500) CHARSET utf8
BEGIN

	/*部门名称*/
	DECLARE v_dept_name VARCHAR(10) DEFAULT "";

  /*临时变量*/
	DECLARE v_temp_name VARCHAR(500) DEFAULT "";

	/*父部门id*/
	DECLARE v_parent_id INT DEFAULT 0;

	SELECT d.dept_name,d.parent_id INTO v_dept_name,v_parent_id from ssm_department d where d.dept_id = v_dept_id;

	IF (v_parent_id != 0) THEN
		 WHILE (v_parent_id != 0) DO 
			SET v_temp_name = CONCAT(v_dept_name,"→",v_temp_name);
			SELECT d.dept_name,d.parent_id INTO v_dept_name,v_parent_id from ssm_department d where d.dept_id = v_parent_id;
		 END WHILE;
 
		 IF (v_parent_id = 0) THEN
				SELECT d.dept_name,d.parent_id INTO v_dept_name,v_parent_id from ssm_department d where d.dept_id = v_parent_id;
				SET v_temp_name = CONCAT(v_dept_name,"→",v_temp_name);
		 END IF;
		 RETURN SUBSTR(v_temp_name,1,CHAR_LENGTH(v_temp_name)-1);
	ELSE
		SET v_temp_name = v_dept_name;
	  RETURN SUBSTR(v_temp_name,1,CHAR_LENGTH(v_temp_name));
	END IF;
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for get_childList_by_orgNo
-- ----------------------------
DROP FUNCTION IF EXISTS `get_childList_by_orgNo`;
DELIMITER ;;
CREATE DEFINER=`flagship`@`%` FUNCTION `get_childList_by_orgNo`(`rootId` VARCHAR(50)) RETURNS varchar(21845) CHARSET utf8
BEGIN
          DECLARE sTemp VARCHAR(21845);
          DECLARE sTempChd VARCHAR(21845);
			    SET SESSION group_concat_max_len=21845;
          SET sTemp = '$';
          SET sTempChd =cast(rootId as CHAR);

         WHILE sTempChd is not null
 DO
            SET sTemp = concat(sTemp,',',sTempChd);
            SELECT group_concat(DISTINCT concat(org_no)) INTO sTempChd FROM  f_risk_org_struct  where FIND_IN_SET(parent_no,sTempChd)>0 ;
       END WHILE;
       RETURN sTemp;
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for get_childList_by_orgNo_test
-- ----------------------------
DROP FUNCTION IF EXISTS `get_childList_by_orgNo_test`;
DELIMITER ;;
CREATE DEFINER=`flagship`@`%` FUNCTION `get_childList_by_orgNo_test`(`rootId` VARCHAR(50),`rank` INT) RETURNS varchar(21845) CHARSET utf8
BEGIN
					DECLARE thisRank INT;
					DECLARE temp VARCHAR(21845);
			    SET SESSION group_concat_max_len=21845;
         
					SET @temp=rootId;
					SELECT rank INTO thisRank FROM f_risk_org_struct WHERE org_no=rootId LIMIT 1;
					
					WHILE thisRank<rank
			DO SELECT GROUP_CONCAT(org_no) INTO @temp FROM f_risk_org_struct WHERE parent_no ='A';
					SET temp=@temp;
					SET thisRank=thisRank+1;
			END WHILE;


         
       RETURN temp;
END
;;
DELIMITER ;
