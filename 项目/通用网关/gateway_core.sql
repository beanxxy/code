/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50548
Source Host           : localhost:3306
Source Database       : gateway_core

Target Server Type    : MYSQL
Target Server Version : 50548
File Encoding         : 65001

Date: 2020-11-20 11:20:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for gw_cfg_alarm
-- ----------------------------
DROP TABLE IF EXISTS `gw_cfg_alarm`;
CREATE TABLE `gw_cfg_alarm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `config` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `DataAddr` varchar(255) DEFAULT NULL,
  `DataModel` varchar(255) DEFAULT NULL,
  `massge` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gw_cfg_alarm
-- ----------------------------
INSERT INTO `gw_cfg_alarm` VALUES ('3', '1#上菜口', '2', '2', '1', 'D3011', 'short', '点检失败', null, '1');

-- ----------------------------
-- Table structure for gw_cfg_call
-- ----------------------------
DROP TABLE IF EXISTS `gw_cfg_call`;
CREATE TABLE `gw_cfg_call` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `config` varchar(255) DEFAULT NULL,
  `funcode` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `DataAddr` varchar(255) DEFAULT NULL,
  `DataModel` varchar(255) DEFAULT NULL,
  `massge` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gw_cfg_call
-- ----------------------------
INSERT INTO `gw_cfg_call` VALUES ('4', '1#上菜口', '2', '1', 'D3011', 'short', '点检成功', null, '1');
INSERT INTO `gw_cfg_call` VALUES ('5', '1#上菜口', '2', '2', 'D3011', 'short', '点检失败', null, '1');
INSERT INTO `gw_cfg_call` VALUES ('7', '1#上菜口', '2', '3', 'D3011', 'short', '点检中', null, '1');
INSERT INTO `gw_cfg_call` VALUES ('10', '2#上菜口', '2', '1', 'D3021', 'short', '点检成功', '', '1');
INSERT INTO `gw_cfg_call` VALUES ('11', '单臂炸', '2', '1', 'D2221', 'short', '点检成功', '', '1');
INSERT INTO `gw_cfg_call` VALUES ('12', '下菜口', '2', '1', 'A026', 'short', '点检成功', '', '1');
INSERT INTO `gw_cfg_call` VALUES ('13', '上#冰库', '2', '1', 'D3031', 'short', '点检成功', '', '1');
INSERT INTO `gw_cfg_call` VALUES ('14', '下#冰库', '2', '1', 'D3041', 'short', '点检成功', '', '1');
INSERT INTO `gw_cfg_call` VALUES ('15', '炒锅', '2', '1', 'B003', 'short', '点检成功', '', '1');
INSERT INTO `gw_cfg_call` VALUES ('16', '蛋糕机', '2', '1', 'D4441', 'short', '点检成功', '', '1');
INSERT INTO `gw_cfg_call` VALUES ('17', '奶茶机', '2', '1', 'D1021', 'short', '点检成功', '', '1');
INSERT INTO `gw_cfg_call` VALUES ('18', '物流线', '2', '1', 'D1911', 'short', '点检成功', '', '1');
INSERT INTO `gw_cfg_call` VALUES ('19', '料盒', '2', '1', 'D3031', 'short', '点检成功', '', '1');
INSERT INTO `gw_cfg_call` VALUES ('20', '一代粉面', '2', '1', 'D3031', 'short', '点检成功', '', '1');
INSERT INTO `gw_cfg_call` VALUES ('21', '左煲仔饭', '2', '1', 'D2801', 'short', '点检成功', '', '1');
INSERT INTO `gw_cfg_call` VALUES ('22', '右煲仔饭', '2', '1', 'D2806', 'short', '点检成功', '', '1');
INSERT INTO `gw_cfg_call` VALUES ('23', '2#上菜口', '2', '2', 'D3021', 'short', '点检失败', '', '1');
INSERT INTO `gw_cfg_call` VALUES ('24', '单臂炸', '2', '2', 'D2221', 'short', '点检失败', '', '1');
INSERT INTO `gw_cfg_call` VALUES ('25', '下菜口', '2', '2', 'A026', 'short', '点检失败', '', '1');
INSERT INTO `gw_cfg_call` VALUES ('26', '上#冰库', '2', '2', 'D3031', 'short', '点检失败', '', '1');
INSERT INTO `gw_cfg_call` VALUES ('27', '下#冰库', '2', '2', 'D3041', 'short', '点检失败', '', '1');
INSERT INTO `gw_cfg_call` VALUES ('28', '炒锅', '2', '2', 'B003', 'short', '点检失败', '', '1');
INSERT INTO `gw_cfg_call` VALUES ('29', '蛋糕机', '2', '2', 'D4441', 'short', '点检失败', '', '1');
INSERT INTO `gw_cfg_call` VALUES ('30', '奶茶机', '2', '2', 'D1021', 'short', '点检失败', '', '1');
INSERT INTO `gw_cfg_call` VALUES ('31', '物流线', '2', '2', 'D1911', 'short', '点检失败', '', '1');
INSERT INTO `gw_cfg_call` VALUES ('32', '料盒', '2', '2', 'D3031', 'short', '点检失败', '', '1');
INSERT INTO `gw_cfg_call` VALUES ('33', '一代粉面', '2', '2', 'D3031', 'short', '点检失败', '', '1');
INSERT INTO `gw_cfg_call` VALUES ('34', '左煲仔饭', '2', '2', 'D2801', 'short', '点检失败', '', '1');
INSERT INTO `gw_cfg_call` VALUES ('35', '右煲仔饭', '2', '2', 'D2806', 'short', '点检失败', '', '1');
INSERT INTO `gw_cfg_call` VALUES ('36', '2#上菜口', '2', '3', 'D3021', 'short', '点检中', '', '1');
INSERT INTO `gw_cfg_call` VALUES ('37', '单臂炸', '2', '3', 'D2221', 'short', '点检中', '', '1');
INSERT INTO `gw_cfg_call` VALUES ('38', '下菜口', '2', '3', 'A026', 'short', '点检中', '', '1');
INSERT INTO `gw_cfg_call` VALUES ('39', '上#冰库', '2', '3', 'D3031', 'short', '点检中', '', '1');
INSERT INTO `gw_cfg_call` VALUES ('40', '下#冰库', '2', '3', 'D3041', 'short', '点检中', '', '1');
INSERT INTO `gw_cfg_call` VALUES ('41', '炒锅', '2', '3', 'B003', 'short', '点检中', '', '1');
INSERT INTO `gw_cfg_call` VALUES ('42', '蛋糕机', '2', '3', 'D4441', 'short', '点检中', '', '1');
INSERT INTO `gw_cfg_call` VALUES ('43', '奶茶机', '2', '3', 'D1021', 'short', '点检中', '', '1');
INSERT INTO `gw_cfg_call` VALUES ('44', '物流线', '2', '3', 'D1911', 'short', '点检中', '', '1');
INSERT INTO `gw_cfg_call` VALUES ('45', '料盒', '2', '3', 'D3031', 'short', '点检中', '', '1');
INSERT INTO `gw_cfg_call` VALUES ('46', '一代粉面', '2', '3', 'D3031', 'short', '点检中', '', '1');
INSERT INTO `gw_cfg_call` VALUES ('47', '左煲仔饭', '2', '3', 'D2801', 'short', '点检中', '', '1');
INSERT INTO `gw_cfg_call` VALUES ('48', '右煲仔饭', '2', '3', 'D2806', 'short', '点检中', '', '1');

-- ----------------------------
-- Table structure for gw_cfg_datamodel
-- ----------------------------
DROP TABLE IF EXISTS `gw_cfg_datamodel`;
CREATE TABLE `gw_cfg_datamodel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group` varchar(255) DEFAULT NULL,
  `index` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `datatype` varchar(255) DEFAULT NULL,
  `length` int(11) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gw_cfg_datamodel
-- ----------------------------

-- ----------------------------
-- Table structure for gw_cfg_dev
-- ----------------------------
DROP TABLE IF EXISTS `gw_cfg_dev`;
CREATE TABLE `gw_cfg_dev` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `devid` varchar(255) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `protocal` varchar(255) DEFAULT NULL,
  `port` varchar(255) DEFAULT NULL,
  `devtype` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `endian` varchar(255) DEFAULT NULL,
  `config` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gw_cfg_dev
-- ----------------------------
INSERT INTO `gw_cfg_dev` VALUES ('5', '4001', '172.28.12.6', 'mc', '8000', '5122', '上菜口', null, '1', null, '1#上菜口');
INSERT INTO `gw_cfg_dev` VALUES ('6', '4002', '172.28.12.6', 'mc', '8000', '5122', '上菜口', '', '1', '', '2#上菜口');
INSERT INTO `gw_cfg_dev` VALUES ('7', '4003', '172.28.12.26', 'mc', '8000', '5122', '上菜口', '', '1', '', '1#上菜口');
INSERT INTO `gw_cfg_dev` VALUES ('8', '4004', '172.28.12.26', 'mc', '8000', '5122', '上菜口', '', '1', '', '2#上菜口');
INSERT INTO `gw_cfg_dev` VALUES ('9', '4005', '172.28.12.46', 'mc', '8000', '5122', '上菜口', '', '1', '', '1#上菜口');
INSERT INTO `gw_cfg_dev` VALUES ('10', '4006', '172.28.12.46', 'mc', '8000', '5122', '上菜口', '', '1', '', '2#上菜口');
INSERT INTO `gw_cfg_dev` VALUES ('11', '4007', '172.28.12.66', 'mc', '8000', '5122', '上菜口', '', '1', '', '1#上菜口');
INSERT INTO `gw_cfg_dev` VALUES ('12', '4008', '172.28.12.66', 'mc', '8000', '5122', '上菜口', '', '1', '', '2#上菜口');
INSERT INTO `gw_cfg_dev` VALUES ('13', '4009', '172.28.12.86', 'mc', '8000', '5122', '上菜口', '', '1', '', '1#上菜口');
INSERT INTO `gw_cfg_dev` VALUES ('14', '4010', '172.28.12.86', 'mc', '8000', '5122', '上菜口', '', '1', '', '2#上菜口');
INSERT INTO `gw_cfg_dev` VALUES ('15', '4601', '172.28.12.103', 'mc', '8000', '5122', '上菜口', '', '1', '', '1#上菜口');
INSERT INTO `gw_cfg_dev` VALUES ('16', '4602', '172.28.12.105', 'mc', '8000', '5122', '上菜口', '', '1', '', '1#上菜口');
INSERT INTO `gw_cfg_dev` VALUES ('17', '4201', '172.28.12.115', 'mc', '8000', '5122', '人工上菜口', '', '1', '', '1#上菜口');
INSERT INTO `gw_cfg_dev` VALUES ('18', '4203', '172.28.12.119', 'mc', '8000', '5122', '人工上菜口', '', '1', '', '1#上菜口');
INSERT INTO `gw_cfg_dev` VALUES ('19', '5821300000000000000', '172.28.10.15', 'mc', '8000', '700', '单臂炸', '', '1', '', '单臂炸');
INSERT INTO `gw_cfg_dev` VALUES ('20', '1092', '172.28.12.84', 'mcu', '50000', '4098', '炒锅', '', '1', '', '炒锅');
INSERT INTO `gw_cfg_dev` VALUES ('21', '5001', '172.28.13.2', 'mcu', '50000', '5889', '下菜口', '', '1', '', '下菜口');
INSERT INTO `gw_cfg_dev` VALUES ('22', '5002', '172.28.13.3', 'mcu', '50000', '5889', '下菜口', '', '1', '', '下菜口');
INSERT INTO `gw_cfg_dev` VALUES ('23', '5003', '172.28.13.4', 'mcu', '50000', '5889', '下菜口', '', '1', '', '下菜口');
INSERT INTO `gw_cfg_dev` VALUES ('24', '5004', '172.28.13.5', 'mcu', '50000', '5889', '下菜口', '', '1', '', '下菜口');
INSERT INTO `gw_cfg_dev` VALUES ('25', '5005', '172.28.13.6', 'mcu', '50000', '5889', '下菜口', '', '1', '', '下菜口');
INSERT INTO `gw_cfg_dev` VALUES ('26', '5006', '172.28.13.7', 'mcu', '50000', '5889', '下菜口', '', '1', '', '下菜口');
INSERT INTO `gw_cfg_dev` VALUES ('27', '5007', '172.28.13.8', 'mcu', '50000', '5889', '下菜口', '', '1', '', '下菜口');
INSERT INTO `gw_cfg_dev` VALUES ('28', '5008', '172.28.13.9', 'mcu', '50000', '5889', '下菜口', '', '1', '', '下菜口');
INSERT INTO `gw_cfg_dev` VALUES ('29', '5009', '172.28.13.10', 'mcu', '50000', '5889', '下菜口', '', '1', '', '下菜口');
INSERT INTO `gw_cfg_dev` VALUES ('30', '5010', '172.28.13.11', 'mcu', '50000', '5889', '下菜口', '', '1', '', '下菜口');
INSERT INTO `gw_cfg_dev` VALUES ('31', '5011', '172.28.13.12', 'mcu', '50000', '5889', '下菜口', '', '1', '', '下菜口');
INSERT INTO `gw_cfg_dev` VALUES ('32', '5012', '172.28.13.13', 'mcu', '50000', '5889', '下菜口', '', '1', '', '下菜口');
INSERT INTO `gw_cfg_dev` VALUES ('33', '5017', '172.28.13.18', 'mcu', '50000', '5889', '下菜口', '', '1', '', '下菜口');
INSERT INTO `gw_cfg_dev` VALUES ('34', '5018', '172.28.13.19', 'mcu', '50000', '5889', '下菜口', '', '1', '', '下菜口');
INSERT INTO `gw_cfg_dev` VALUES ('35', '5019', '172.28.13.20', 'mcu', '50000', '5889', '下菜口', '', '1', '', '下菜口');
INSERT INTO `gw_cfg_dev` VALUES ('36', '5020', '172.28.13.21', 'mcu', '50000', '5889', '下菜口', '', '1', '', '下菜口');
INSERT INTO `gw_cfg_dev` VALUES ('37', '5021', '172.28.13.22', 'mcu', '50000', '5889', '下菜口', '', '1', '', '下菜口');
INSERT INTO `gw_cfg_dev` VALUES ('38', '5022', '172.28.13.23', 'mcu', '50000', '5889', '下菜口', '', '1', '', '下菜口');
INSERT INTO `gw_cfg_dev` VALUES ('39', '5023', '172.28.13.24', 'mcu', '50000', '5889', '下菜口', '', '1', '', '下菜口');
INSERT INTO `gw_cfg_dev` VALUES ('40', '2011', '172.28.12.8', 'mc', '8003', '4355', '冰库', '', '1', '', '上#冰库');
INSERT INTO `gw_cfg_dev` VALUES ('41', '2012', '172.28.12.8', 'mc', '8003', '4355', '冰库', '', '1', '', '下#冰库');
INSERT INTO `gw_cfg_dev` VALUES ('42', '2021', '172.28.12.18', 'mc', '8003', '4355', '冰库', '', '1', '', '上#冰库');
INSERT INTO `gw_cfg_dev` VALUES ('43', '2022', '172.28.12.18', 'mc', '8003', '4355', '冰库', '', '1', '', '下#冰库');
INSERT INTO `gw_cfg_dev` VALUES ('44', '2031', '172.28.12.28', 'mc', '8003', '4355', '冰库', '', '1', '', '上#冰库');
INSERT INTO `gw_cfg_dev` VALUES ('45', '2032', '172.28.12.28', 'mc', '8003', '4355', '冰库', '', '1', '', '下#冰库');
INSERT INTO `gw_cfg_dev` VALUES ('46', '2041', '172.28.12.38', 'mc', '8003', '4355', '冰库', '', '1', '', '上#冰库');
INSERT INTO `gw_cfg_dev` VALUES ('47', '2042', '172.28.12.38', 'mc', '8003', '4355', '冰库', '', '1', '', '下#冰库');
INSERT INTO `gw_cfg_dev` VALUES ('48', '2051', '172.28.12.48', 'mc', '8003', '4355', '冰库', '', '1', '', '上#冰库');
INSERT INTO `gw_cfg_dev` VALUES ('49', '2052', '172.28.12.48', 'mc', '8003', '4355', '冰库', '', '1', '', '下#冰库');
INSERT INTO `gw_cfg_dev` VALUES ('50', '2061', '172.28.12.58', 'mc', '8003', '4355', '冰库', '', '1', '', '上#冰库');
INSERT INTO `gw_cfg_dev` VALUES ('51', '2062', '172.28.12.58', 'mc', '8003', '4355', '冰库', '', '1', '', '下#冰库');
INSERT INTO `gw_cfg_dev` VALUES ('52', '2071', '172.28.12.68', 'mc', '8003', '4355', '冰库', '', '1', '', '上#冰库');
INSERT INTO `gw_cfg_dev` VALUES ('53', '2072', '172.28.12.68', 'mc', '8003', '4355', '冰库', '', '1', '', '下#冰库');
INSERT INTO `gw_cfg_dev` VALUES ('54', '2081', '172.28.12.78', 'mc', '8003', '4355', '冰库', '', '1', '', '上#冰库');
INSERT INTO `gw_cfg_dev` VALUES ('55', '2082', '172.28.12.78', 'mc', '8003', '4355', '冰库', '', '1', '', '下#冰库');
INSERT INTO `gw_cfg_dev` VALUES ('56', '2091', '172.28.12.88', 'mc', '8003', '4355', '冰库', '', '1', '', '上#冰库');
INSERT INTO `gw_cfg_dev` VALUES ('57', '2092', '172.28.12.88', 'mc', '8003', '4355', '冰库', '', '1', '', '下#冰库');
INSERT INTO `gw_cfg_dev` VALUES ('58', '5013', '172.28.13.14', 'mcu', '50000', '5889', '下菜口', '', '1', '', '下菜口');
INSERT INTO `gw_cfg_dev` VALUES ('59', '5014', '172.28.13.15', 'mcu', '50000', '5889', '下菜口', '', '1', '', '下菜口');
INSERT INTO `gw_cfg_dev` VALUES ('60', '5015', '172.28.13.16', 'mcu', '50000', '5889', '下菜口', '', '1', '', '下菜口');
INSERT INTO `gw_cfg_dev` VALUES ('61', '5016', '172.28.13.17', 'mcu', '50000', '5889', '下菜口', '', '1', '', '下菜口');
INSERT INTO `gw_cfg_dev` VALUES ('62', '1011', '172.28.12.2', 'mcu', '50000', '4098', '炒锅', '', '1', '', '炒锅');
INSERT INTO `gw_cfg_dev` VALUES ('63', '1012', '172.28.12.4', 'mcu', '50000', '4098', '炒锅', '', '1', '', '炒锅');
INSERT INTO `gw_cfg_dev` VALUES ('64', '1021', '172.28.12.12', 'mcu', '50000', '4098', '炒锅', '', '1', '', '炒锅');
INSERT INTO `gw_cfg_dev` VALUES ('65', '1022', '172.28.12.14', 'mcu', '50000', '4098', '炒锅', '', '1', '', '炒锅');
INSERT INTO `gw_cfg_dev` VALUES ('66', '1031', '172.28.12.22', 'mcu', '50000', '4098', '炒锅', '', '1', '', '炒锅');
INSERT INTO `gw_cfg_dev` VALUES ('67', '1032', '172.28.12.24', 'mcu', '50000', '4098', '炒锅', '', '1', '', '炒锅');
INSERT INTO `gw_cfg_dev` VALUES ('68', '1041', '172.28.12.32', 'mcu', '50000', '4098', '炒锅', '', '1', '', '炒锅');
INSERT INTO `gw_cfg_dev` VALUES ('69', '1042', '172.28.12.34', 'mcu', '50000', '4098', '炒锅', '', '1', '', '炒锅');
INSERT INTO `gw_cfg_dev` VALUES ('70', '1051', '172.28.12.42', 'mcu', '50000', '4098', '炒锅', '', '1', '', '炒锅');
INSERT INTO `gw_cfg_dev` VALUES ('71', '1052', '172.28.12.44', 'mcu', '50000', '4098', '炒锅', '', '1', '', '炒锅');
INSERT INTO `gw_cfg_dev` VALUES ('72', '1061', '172.28.12.52', 'mcu', '50000', '4098', '炒锅', '', '1', '', '炒锅');
INSERT INTO `gw_cfg_dev` VALUES ('73', '1062', '172.28.12.54', 'mcu', '50000', '4098', '炒锅', '', '1', '', '炒锅');
INSERT INTO `gw_cfg_dev` VALUES ('74', '1071', '172.28.12.62', 'mcu', '50000', '4098', '炒锅', '', '1', '', '炒锅');
INSERT INTO `gw_cfg_dev` VALUES ('75', '1072', '172.28.12.64', 'mcu', '50000', '4098', '炒锅', '', '1', '', '炒锅');
INSERT INTO `gw_cfg_dev` VALUES ('76', '1081', '172.28.12.72', 'mcu', '50000', '4098', '炒锅', '', '1', '', '炒锅');
INSERT INTO `gw_cfg_dev` VALUES ('77', '1082', '172.28.12.74', 'mcu', '50000', '4098', '炒锅', '', '1', '', '炒锅');
INSERT INTO `gw_cfg_dev` VALUES ('78', '1091', '172.28.12.82', 'mcu', '50000', '4098', '炒锅', '', '1', '', '炒锅');
INSERT INTO `gw_cfg_dev` VALUES ('79', '1092', '172.28.12.84', 'mcu', '50000', '4098', '炒锅', '', '1', '', '炒锅');
INSERT INTO `gw_cfg_dev` VALUES ('80', '1', '172.28.11.2', 'mc', '8000', '4865', '物流线', '', '1', '', '物流线');
INSERT INTO `gw_cfg_dev` VALUES ('81', '6721067917451980000', '172.28.10.121', 'mc', '8000', '750', '一代粉面', '', '1', '', '一代粉面');
INSERT INTO `gw_cfg_dev` VALUES ('82', '5821300000000000152_1', '172.28.10.10', 'mc', '8001', '721', '蛋糕机', '', '1', '', '蛋糕机');
INSERT INTO `gw_cfg_dev` VALUES ('83', '5821300000000000152_2', '172.28.10.2', 'mc', '8001', '721', '奶茶机', '', '1', '', '奶茶机');
INSERT INTO `gw_cfg_dev` VALUES ('84', '2603', '172.28.12.109', 'mc', '8003', '4355', '料盒', '', '1', '', '料盒');
INSERT INTO `gw_cfg_dev` VALUES ('85', '4202', '172.28.12.115', 'mc', '8000', '5122', '人工上菜口', '', '1', '', '2#上菜口');
INSERT INTO `gw_cfg_dev` VALUES ('86', '2601', '172.28.12.107', 'mc', '8003', '4355', '冰库', '', '1', '', '上#冰库');
INSERT INTO `gw_cfg_dev` VALUES ('87', '2602', '172.28.12.107', 'mc', '8003', '4355', '冰库', '', '1', '', '下#冰库');
INSERT INTO `gw_cfg_dev` VALUES ('88', '6001', '172.28.12.100', 'mc', '8000', '6145', '煲仔饭', null, '1', null, '左煲仔饭');
INSERT INTO `gw_cfg_dev` VALUES ('89', '6002', '172.28.12.100', 'mc', '8000', '6145', '煲仔饭', null, '1', null, '右煲仔饭');

-- ----------------------------
-- Table structure for gw_cfg_function
-- ----------------------------
DROP TABLE IF EXISTS `gw_cfg_function`;
CREATE TABLE `gw_cfg_function` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `DataAddr` varchar(255) DEFAULT NULL,
  `DataModel` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `config` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gw_cfg_function
-- ----------------------------
INSERT INTO `gw_cfg_function` VALUES ('6', '1＃上菜口-点检', 'D3010', 'short', '2', '1#上菜口', null, '1');
INSERT INTO `gw_cfg_function` VALUES ('7', '2＃上菜口-点检', 'D3020', 'short', '2', '2#上菜口', '', '1');
INSERT INTO `gw_cfg_function` VALUES ('8', '单臂炸点检', 'D2220-1', 'bit', '2', '单臂炸', '', '1');
INSERT INTO `gw_cfg_function` VALUES ('9', '下菜口点检', 'A023', 'short', '2', '下菜口', '', '1');
INSERT INTO `gw_cfg_function` VALUES ('10', '上#冰库点检', 'D3030', 'short', '2', '上#冰库', '', '1');
INSERT INTO `gw_cfg_function` VALUES ('11', '下#冰库点检', 'D3040', 'short', '2', '下#冰库', '', '1');
INSERT INTO `gw_cfg_function` VALUES ('12', '炒锅点检', 'B000', 'short', '2', '炒锅', '', '1');
INSERT INTO `gw_cfg_function` VALUES ('13', '蛋糕机点检', 'D4440', 'short', '2', '蛋糕机', '', '1');
INSERT INTO `gw_cfg_function` VALUES ('14', '奶茶机点检', 'D1020', 'short', '2', '奶茶机', '', '1');
INSERT INTO `gw_cfg_function` VALUES ('15', '物流线', 'D1910', 'short', '2', '物流线', '', '1');
INSERT INTO `gw_cfg_function` VALUES ('16', '料盒点检', 'D3030', 'short', '2', '料盒', '', '1');
INSERT INTO `gw_cfg_function` VALUES ('17', '料盒点检', 'D3030', 'short', '2', '一代粉面', '', '1');
INSERT INTO `gw_cfg_function` VALUES ('18', '煲仔饭', 'D2800', 'short', '2', '左煲仔饭', null, '1');
INSERT INTO `gw_cfg_function` VALUES ('19', '煲仔饭', 'D2805', 'short', '2', '右煲仔饭', null, '1');

-- ----------------------------
-- Table structure for gw_cfg_ioinfo
-- ----------------------------
DROP TABLE IF EXISTS `gw_cfg_ioinfo`;
CREATE TABLE `gw_cfg_ioinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `config` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `parentName` varchar(255) DEFAULT NULL,
  `estimateName` varchar(255) DEFAULT NULL,
  `DataAddr` varchar(255) DEFAULT NULL,
  `DataModel` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gw_cfg_ioinfo
-- ----------------------------
INSERT INTO `gw_cfg_ioinfo` VALUES ('7', '1#上菜口', '', '1#上菜口', '点检状态', 'D3011', 'short', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('8', '1#上菜口', '', '1#上菜口', '电箱急停已按下', 'D2050-0', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('9', '1#上菜口', '', '1#上菜口', '拨盘电机拨菜超时报警', 'D2050-1', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('10', '1#上菜口', '', '1#上菜口', '拨盘电机返回超时报警', 'D2050-2', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('11', '1#上菜口', '', '1#上菜口', '步进电机报警', 'D2050-3', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('12', '1#上菜口', '', '1#上菜口', '顶部缺盘感应报警', 'D2050-4', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('13', '1#上菜口', '', '1#上菜口', '底部缺盘感应报警', 'D2050-5', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('14', '1#上菜口', '', '1#上菜口', '锅下MODBUS RTU读取通信异常', 'D2050-6', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('15', '1#上菜口', '', '1#上菜口', '锅上MODBUS RTU读取通信异常', 'D2050-7', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('16', '1#上菜口', '', '1#上菜口', '锅下MODBUS RTU写入通信异常', 'D2050-8', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('17', '1#上菜口', '', '1#上菜口', '锅上MODBUS RTU写入通信异常', 'D2050-9', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('18', '1#上菜口', '', '1#上菜口', '主站发生重试', 'D2050-10', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('19', '1#上菜口', '', '1#上菜口', '主站发生超时', 'D2050-11', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('20', '1#上菜口', '', '1#上菜口', '炒锅下急停已按下', 'D2050-12', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('21', '1#上菜口', '', '1#上菜口', '炒锅下缺盘报警', 'D2050-13', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('22', '1#上菜口', '', '1#上菜口', '炒锅上急停已按下', 'D2050-14', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('23', '1#上菜口', '', '1#上菜口', '炒锅上缺盘报警', 'D2050-15', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('24', '1#上菜口', '', '1#上菜口', '炒锅下做菜失败', 'D2051-0', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('25', '1#上菜口', '', '1#上菜口', '炒锅上做菜失败', 'D2051-1', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('26', '1#上菜口', '', '1#上菜口', '触摸屏小急停已按下', 'D2051-2', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('27', '1#上菜口', '', '1#上菜口', '上菜口二层缺盘报警', 'D2051-3', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('28', '1#上菜口', '', '1#上菜口', '上菜口二层电机正转超时', 'D2051-4', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('29', '1#上菜口', '', '1#上菜口', '上菜口二层电机反转超时', 'D2051-5', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('30', '1#上菜口', '', '1#上菜口', '启动锅下超时', 'D2051-6', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('31', '1#上菜口', '', '1#上菜口', '启动锅上超时', 'D2051-7', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('32', '1#上菜口', '', '1#上菜口', '上菜口绳子运动检测超时', 'D2051-8', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('33', '1#上菜口', '', '1#上菜口', '步进电机上升极限位', 'D2051-9', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('34', '1#上菜口', '', '1#上菜口', '步进电机下降极限位', 'D2051-10', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('35', '1#上菜口', '', '1#上菜口', '二层到位感应没有感应到报警', 'D2051-11', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('36', '1#上菜口', '', '1#上菜口', 'CC-LINK模块故障报警SW80/81', 'D2051-12', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('37', '1#上菜口', '', '1#上菜口', 'CC-LINK模块故障报警SB0080', 'D2051-13', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('40', '2#上菜口', '2', '2#上菜口', '电箱急停已按下', 'D2250-0', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('41', '2#上菜口', '2', '2#上菜口', '拨盘电机拨菜超时报警', 'D2250-1', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('42', '2#上菜口', '2', '2#上菜口', '拨盘电机返回超时报警', 'D2250-2', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('43', '2#上菜口', '2', '2#上菜口', '步进电机报警', 'D2250-3', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('44', '2#上菜口', '2', '2#上菜口', '顶部缺盘感应报警', 'D2250-4', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('45', '2#上菜口', '2', '2#上菜口', '底部缺盘感应报警', 'D2250-5', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('46', '2#上菜口', '2', '2#上菜口', '锅下MODBUS RTU读取通信异常', 'D2250-6', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('47', '2#上菜口', '2', '2#上菜口', '锅上MODBUS RTU读取通信异常', 'D2250-7', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('48', '2#上菜口', '2', '2#上菜口', '锅下MODBUS RTU写入通信异常', 'D2250-8', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('49', '2#上菜口', '2', '2#上菜口', '锅上MODBUS RTU写入通信异常', 'D2250-9', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('50', '2#上菜口', '2', '2#上菜口', '主站发生重试', 'D2250-10', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('51', '2#上菜口', '2', '2#上菜口', '主站发生超时', 'D2250-11', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('52', '2#上菜口', '2', '2#上菜口', '炒锅下急停已按下', 'D2250-12', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('53', '2#上菜口', '2', '2#上菜口', '炒锅下缺盘报警', 'D2250-13', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('54', '2#上菜口', '2', '2#上菜口', '炒锅上急停已按下', 'D2250-14', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('55', '2#上菜口', '2', '2#上菜口', '炒锅上缺盘报警', 'D2250-15', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('56', '2#上菜口', '2', '2#上菜口', '炒锅下做菜失败', 'D2251-0', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('57', '2#上菜口', '2', '2#上菜口', '炒锅上做菜失败', 'D2251-1', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('58', '2#上菜口', '2', '2#上菜口', '触摸屏小急停已按下', 'D2251-2', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('59', '2#上菜口', '2', '2#上菜口', '上菜口二层缺盘报警', 'D2251-3', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('60', '2#上菜口', '2', '2#上菜口', '上菜口二层电机正转超时', 'D2251-4', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('61', '2#上菜口', '2', '2#上菜口', '上菜口二层电机反转超时', 'D2251-5', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('62', '2#上菜口', '2', '2#上菜口', '启动锅下超时', 'D2251-6', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('63', '2#上菜口', '2', '2#上菜口', '启动锅上超时', 'D2251-7', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('64', '2#上菜口', '2', '2#上菜口', '上菜口绳子运动检测超时', 'D2251-8', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('65', '2#上菜口', '2', '2#上菜口', '步进电机上升极限位', 'D2251-9', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('66', '2#上菜口', '2', '2#上菜口', '步进电机下降极限位', 'D2251-10', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('67', '2#上菜口', '2', '2#上菜口', '二层到位感应没有感应到报警', 'D2251-11', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('68', '2#上菜口', '2', '2#上菜口', 'CC-LINK模块故障报警SW80/81', 'D2251-12', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('69', '2#上菜口', '2', '2#上菜口', 'CC-LINK模块故障报警SB0080', 'D2251-13', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('70', '上#冰库', '2', '上#冰库', '1#急停已按下', 'D3811-0', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('71', '上#冰库', '2', '上#冰库', '1#上下伺服报警', 'D3811-1', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('72', '上#冰库', '2', '上#冰库', '1#送料气缸不到位报警', 'D3811-2', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('73', '上#冰库', '2', '上#冰库', '1#出料窗口气缸不到位报警', 'D3811-3', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('74', '上#冰库', '2', '上#冰库', '1#料盒检测无料报警 ', 'D3811-4', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('75', '上#冰库', '2', '上#冰库', '1#料盒取料卡料报警 ', 'D3811-5', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('76', '上#冰库', '2', '上#冰库', '1#移载轴步进结束异常报警', 'D3811-6', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('77', '上#冰库', '2', '上#冰库', '1#接收到做菜失败异常信号', 'D3811-7', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('78', '上#冰库', '2', '上#冰库', '1#送料异常', 'D3811-8', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('79', '上#冰库', '2', '上#冰库', '1#出料位置检测到有料盒报警', 'D3811-9', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('80', '上#冰库', '2', '上#冰库', '1#升降平台上检测到有料盒报警', 'D3811-10', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('81', '下#冰库', '2', '下#冰库', '2#急停已按下', 'D4811-0', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('82', '下#冰库', '2', '下#冰库', '2#上下伺服报警', 'D4811-1', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('83', '下#冰库', '2', '下#冰库', '2#送料气缸不到位报警', 'D4811-2', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('84', '下#冰库', '2', '下#冰库', '2#出料窗口气缸不到位报警', 'D4811-3', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('85', '下#冰库', '2', '下#冰库', '2#料盒检测无料报警 ', 'D4811-4', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('86', '下#冰库', '2', '下#冰库', '2#料盒取料卡料报警 ', 'D4811-5', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('87', '下#冰库', '2', '下#冰库', '2#移载轴步进结束异常报警', 'D4811-6', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('88', '下#冰库', '2', '下#冰库', '2#接收到做菜失败异常信号', 'D4811-7', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('89', '下#冰库', '2', '下#冰库', '2#送料异常', 'D4811-8', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('90', '下#冰库', '2', '下#冰库', '2#出料位置检测到有料盒', 'D4811-9', 'bit', '', '1');
INSERT INTO `gw_cfg_ioinfo` VALUES ('91', '下#冰库', '2', '下#冰库', '2#升降平台上检测到有料盒报警', 'D4811-10', 'bit', '', '1');
