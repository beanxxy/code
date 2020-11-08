/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50548
Source Host           : localhost:3306
Source Database       : gateway

Target Server Type    : MYSQL
Target Server Version : 50548
File Encoding         : 65001

Date: 2020-10-26 14:54:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for gw_alert
-- ----------------------------
DROP TABLE IF EXISTS `gw_alert`;
CREATE TABLE `gw_alert` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataAddr` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `massge` varchar(255) DEFAULT NULL,
  `deviceid` varchar(255) DEFAULT NULL,
  `command` varchar(255) DEFAULT NULL COMMENT '触发命令',
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gw_alert
-- ----------------------------
INSERT INTO `gw_alert` VALUES ('1', 'D2221', '1', '1', '检点成功', '700', 'over', '1');
INSERT INTO `gw_alert` VALUES ('2', 'D2221', '2', '1', '检点失败', '700', 'over', '1');

-- ----------------------------
-- Table structure for gw_datamodel
-- ----------------------------
DROP TABLE IF EXISTS `gw_datamodel`;
CREATE TABLE `gw_datamodel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group` varchar(255) DEFAULT NULL,
  `index` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `datatype` varchar(255) DEFAULT NULL,
  `length` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gw_datamodel
-- ----------------------------
INSERT INTO `gw_datamodel` VALUES ('1', 'errnum', '1', 'state', 'byte', '1');
INSERT INTO `gw_datamodel` VALUES ('2', 'errnum', '2', 'code1', 'short', '2');
INSERT INTO `gw_datamodel` VALUES ('3', 'errnum', '3', 'code2', 'short', '2');
INSERT INTO `gw_datamodel` VALUES ('4', 'order', '1', 'head', 'short', '2');
INSERT INTO `gw_datamodel` VALUES ('5', 'order', '2', 'qt1', 'short', '2');
INSERT INTO `gw_datamodel` VALUES ('6', 'order', '3', 'qt2', 'short', '2');
INSERT INTO `gw_datamodel` VALUES ('7', 'order', '4', 'id', 'short', '2');
INSERT INTO `gw_datamodel` VALUES ('8', 'order', '5', 'time', 'short', '2');
INSERT INTO `gw_datamodel` VALUES ('9', 'order', '6', 'temp', 'short', '2');
INSERT INTO `gw_datamodel` VALUES ('10', 'order', '8', 'basket', 'short', '2');
INSERT INTO `gw_datamodel` VALUES ('11', 'order', '7', 'taskid', 'short', '2');

-- ----------------------------
-- Table structure for gw_function
-- ----------------------------
DROP TABLE IF EXISTS `gw_function`;
CREATE TABLE `gw_function` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `deviceid` varchar(255) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `protocal` varchar(255) DEFAULT NULL,
  `port` int(255) DEFAULT NULL,
  `dataAddr` varchar(255) DEFAULT NULL,
  `dataModel` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `listenaddr` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `state` int(255) DEFAULT NULL,
  `devtype` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gw_function
-- ----------------------------
INSERT INTO `gw_function` VALUES ('1', '4001', '172.28.12.6', 'mc', '8000', 'D3010', 'short', '2', 'D3011', '点检', '1', '5122');
INSERT INTO `gw_function` VALUES ('8', '700', '172.28.10.15', 'mc', '8000', 'D2220-1', 'bit', '2', '\r\nD2221', '点检', '1', '700');

-- ----------------------------
-- Table structure for gw_ioinfo
-- ----------------------------
DROP TABLE IF EXISTS `gw_ioinfo`;
CREATE TABLE `gw_ioinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `deviceid` varchar(255) DEFAULT NULL COMMENT '设备id',
  `ip` varchar(255) DEFAULT NULL COMMENT '设备ip',
  `protocal` varchar(255) DEFAULT NULL COMMENT '设备通信协议',
  `port` int(255) DEFAULT NULL COMMENT '开放端口',
  `dataAddr` varchar(255) DEFAULT NULL COMMENT '数据地址',
  `dataModel` varchar(255) DEFAULT NULL COMMENT '数据模型',
  `parentName` varchar(255) DEFAULT NULL COMMENT 'io父项',
  `estimateName` varchar(255) DEFAULT NULL COMMENT 'io名称',
  `type` varchar(255) DEFAULT NULL COMMENT '设备类型',
  `state` int(255) DEFAULT NULL COMMENT '状态，0禁用，1启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gw_ioinfo
-- ----------------------------
INSERT INTO `gw_ioinfo` VALUES ('1', '4001', '172.28.12.6', 'mc', '8000', 'D2050-0', 'bit', '上菜口', '电箱急停已按下', '5122', '0');
INSERT INTO `gw_ioinfo` VALUES ('101', '4001', '172.28.12.6', 'mc', '8000', 'D3011', 'short', '上菜口', '点检状态', '5122', '0');
INSERT INTO `gw_ioinfo` VALUES ('102', '700', '172.28.10.15', 'mc', '8000', 'D2221', 'short', '单臂炸', '点检状态', '700', '1');

-- ----------------------------
-- Table structure for gw_serverconfig
-- ----------------------------
DROP TABLE IF EXISTS `gw_serverconfig`;
CREATE TABLE `gw_serverconfig` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `port` int(11) DEFAULT NULL,
  `dataAddr` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gw_serverconfig
-- ----------------------------
INSERT INTO `gw_serverconfig` VALUES ('1', '17076', '/chinesefood/up/check/', '2', '1');
INSERT INTO `gw_serverconfig` VALUES ('2', '17076', '/chinesefood/down/check/', '3', '1');
