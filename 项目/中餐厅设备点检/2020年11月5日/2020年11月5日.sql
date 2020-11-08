/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50548
Source Host           : localhost:3306
Source Database       : 2020年11月5日

Target Server Type    : MYSQL
Target Server Version : 50548
File Encoding         : 65001

Date: 2020-11-05 15:33:12
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
) ENGINE=InnoDB AUTO_INCREMENT=420 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gw_alert
-- ----------------------------
INSERT INTO `gw_alert` VALUES ('1', 'D2221', '1', '1', '成功', '5821300000000000113', 'over', '1');
INSERT INTO `gw_alert` VALUES ('2', 'D2221', '2', '1', '失败', '5821300000000000113', 'over', '1');
INSERT INTO `gw_alert` VALUES ('3', 'D3011', '1', '1', '成功', '4001', 'over', '1');
INSERT INTO `gw_alert` VALUES ('4', 'D3021', '1', '1', '成功', '4002', 'over', '1');
INSERT INTO `gw_alert` VALUES ('5', 'D3011', '1', '1', '成功', '4003', 'over', '1');
INSERT INTO `gw_alert` VALUES ('6', 'D3021', '1', '1', '成功', '4004', 'over', '1');
INSERT INTO `gw_alert` VALUES ('7', 'D3021', '1', '1', '成功', '4006', 'over', '1');
INSERT INTO `gw_alert` VALUES ('8', 'D3011', '1', '1', '成功', '4005', 'over', '1');
INSERT INTO `gw_alert` VALUES ('9', 'D3011', '1', '1', '成功', '4007', 'over', '1');
INSERT INTO `gw_alert` VALUES ('10', 'D3021', '1', '1', '成功', '4008', 'over', '1');
INSERT INTO `gw_alert` VALUES ('11', 'D3011', '1', '1', '成功', '4009', 'over', '1');
INSERT INTO `gw_alert` VALUES ('12', 'D3021', '1', '1', '成功', '4010', 'over', '1');
INSERT INTO `gw_alert` VALUES ('13', 'D3011', '1', '1', '成功', '4601', 'over', '1');
INSERT INTO `gw_alert` VALUES ('14', 'D3011', '1', '1', '成功', '4602', 'over', '1');
INSERT INTO `gw_alert` VALUES ('15', 'D3011', '1', '1', '成功', '4201', 'over', '1');
INSERT INTO `gw_alert` VALUES ('16', 'D3011', '1', '1', '成功', '4203', 'over', '1');
INSERT INTO `gw_alert` VALUES ('17', 'D3011', '2', '1', '失败', '4001', 'over', '1');
INSERT INTO `gw_alert` VALUES ('18', 'D3021', '2', '1', '失败', '4002', 'over', '1');
INSERT INTO `gw_alert` VALUES ('19', 'D3011', '2', '1', '失败', '4003', 'over', '1');
INSERT INTO `gw_alert` VALUES ('20', 'D3021', '2', '1', '失败', '4004', 'over', '1');
INSERT INTO `gw_alert` VALUES ('21', 'D3011', '2', '1', '失败', '4006', 'over', '1');
INSERT INTO `gw_alert` VALUES ('22', 'D3021', '2', '1', '失败', '4005', 'over', '1');
INSERT INTO `gw_alert` VALUES ('23', 'D3011', '2', '1', '失败', '4007', 'over', '1');
INSERT INTO `gw_alert` VALUES ('24', 'D3021', '2', '1', '失败', '4008', 'over', '1');
INSERT INTO `gw_alert` VALUES ('25', 'D3011', '2', '1', '失败', '4009', 'over', '1');
INSERT INTO `gw_alert` VALUES ('26', 'D3021', '2', '1', '失败', '4010', 'over', '1');
INSERT INTO `gw_alert` VALUES ('27', 'D3011', '2', '1', '失败', '4601', 'over', '1');
INSERT INTO `gw_alert` VALUES ('28', 'D3011', '2', '1', '失败', '4602', 'over', '1');
INSERT INTO `gw_alert` VALUES ('29', 'D3011', '2', '1', '失败', '4201', 'over', '1');
INSERT INTO `gw_alert` VALUES ('30', 'D3011', '2', '1', '失败', '4203', 'over', '1');
INSERT INTO `gw_alert` VALUES ('100', 'A026', '1', '2', '成功', '5001', 'over', '1');
INSERT INTO `gw_alert` VALUES ('101', 'A026', '1', '2', '成功', '5002', 'over', '1');
INSERT INTO `gw_alert` VALUES ('102', 'A026', '1', '2', '成功', '5003', 'over', '1');
INSERT INTO `gw_alert` VALUES ('103', 'A026', '1', '2', '成功', '5004', 'over', '1');
INSERT INTO `gw_alert` VALUES ('104', 'A026', '1', '2', '成功', '5005', 'over', '1');
INSERT INTO `gw_alert` VALUES ('105', 'A026', '1', '2', '成功', '5006', 'over', '1');
INSERT INTO `gw_alert` VALUES ('106', 'A026', '1', '2', '成功', '5007', 'over', '1');
INSERT INTO `gw_alert` VALUES ('107', 'A026', '1', '2', '成功', '5008', 'over', '1');
INSERT INTO `gw_alert` VALUES ('108', 'A026', '1', '2', '成功', '5009', 'over', '1');
INSERT INTO `gw_alert` VALUES ('109', 'A026', '1', '2', '成功', '5010', 'over', '1');
INSERT INTO `gw_alert` VALUES ('110', 'A026', '1', '2', '成功', '5011', 'over', '1');
INSERT INTO `gw_alert` VALUES ('111', 'A026', '1', '2', '成功', '5012', 'over', '1');
INSERT INTO `gw_alert` VALUES ('112', 'A026', '1', '2', '成功', '5017', 'over', '1');
INSERT INTO `gw_alert` VALUES ('113', 'A026', '1', '2', '成功', '5018', 'over', '1');
INSERT INTO `gw_alert` VALUES ('114', 'A026', '1', '2', '成功', '5019', 'over', '1');
INSERT INTO `gw_alert` VALUES ('115', 'A026', '1', '2', '成功', '5020', 'over', '1');
INSERT INTO `gw_alert` VALUES ('116', 'A026', '1', '2', '成功', '5021', 'over', '1');
INSERT INTO `gw_alert` VALUES ('117', 'A026', '1', '2', '成功', '5022', 'over', '1');
INSERT INTO `gw_alert` VALUES ('118', 'A026', '1', '2', '成功', '5023', 'over', '1');
INSERT INTO `gw_alert` VALUES ('119', 'A026', '2', '2', '失败', '5001', 'over', '1');
INSERT INTO `gw_alert` VALUES ('120', 'A026', '2', '2', '失败', '5002', 'over', '1');
INSERT INTO `gw_alert` VALUES ('121', 'A026', '2', '2', '失败', '5003', 'over', '1');
INSERT INTO `gw_alert` VALUES ('122', 'A026', '2', '2', '失败', '5004', 'over', '1');
INSERT INTO `gw_alert` VALUES ('123', 'A026', '2', '2', '失败', '5005', 'over', '1');
INSERT INTO `gw_alert` VALUES ('124', 'A026', '2', '2', '失败', '5006', 'over', '1');
INSERT INTO `gw_alert` VALUES ('125', 'A026', '2', '2', '失败', '5007', 'over', '1');
INSERT INTO `gw_alert` VALUES ('126', 'A026', '2', '2', '失败', '5008', 'over', '1');
INSERT INTO `gw_alert` VALUES ('127', 'A026', '2', '2', '失败', '5009', 'over', '1');
INSERT INTO `gw_alert` VALUES ('128', 'A026', '2', '2', '失败', '5010', 'over', '1');
INSERT INTO `gw_alert` VALUES ('129', 'A026', '2', '2', '失败', '5011', 'over', '1');
INSERT INTO `gw_alert` VALUES ('130', 'A026', '2', '2', '失败', '5012', 'over', '1');
INSERT INTO `gw_alert` VALUES ('131', 'A026', '2', '2', '失败', '5017', 'over', '1');
INSERT INTO `gw_alert` VALUES ('132', 'A026', '2', '2', '失败', '5018', 'over', '1');
INSERT INTO `gw_alert` VALUES ('133', 'A026', '2', '2', '失败', '5019', 'over', '1');
INSERT INTO `gw_alert` VALUES ('134', 'A026', '2', '2', '失败', '5020', 'over', '1');
INSERT INTO `gw_alert` VALUES ('135', 'A026', '2', '2', '失败', '5021', 'over', '1');
INSERT INTO `gw_alert` VALUES ('136', 'A026', '2', '2', '失败', '5022', 'over', '1');
INSERT INTO `gw_alert` VALUES ('137', 'A026', '2', '2', '失败', '5023', 'over', '1');
INSERT INTO `gw_alert` VALUES ('138', 'D3031', '1', '2', '成功', '2011', 'over', '1');
INSERT INTO `gw_alert` VALUES ('139', 'D3041', '1', '2', '成功', '2012', 'over', '1');
INSERT INTO `gw_alert` VALUES ('140', 'D3031', '1', '2', '成功', '2021', 'over', '1');
INSERT INTO `gw_alert` VALUES ('141', 'D3041', '1', '2', '成功', '2022', 'over', '1');
INSERT INTO `gw_alert` VALUES ('142', 'D3031', '1', '2', '成功', '2031', 'over', '1');
INSERT INTO `gw_alert` VALUES ('143', 'D3041', '1', '2', '成功', '2032', 'over', '1');
INSERT INTO `gw_alert` VALUES ('144', 'D3031', '1', '2', '成功', '2041', 'over', '1');
INSERT INTO `gw_alert` VALUES ('145', 'D3041', '1', '2', '成功', '2042', 'over', '1');
INSERT INTO `gw_alert` VALUES ('146', 'D3031', '1', '2', '成功', '2051', 'over', '1');
INSERT INTO `gw_alert` VALUES ('147', 'D3041', '1', '2', '成功', '2052', 'over', '1');
INSERT INTO `gw_alert` VALUES ('148', 'D3031', '1', '2', '成功', '2061', 'over', '1');
INSERT INTO `gw_alert` VALUES ('149', 'D3041', '1', '2', '成功', '2062', 'over', '1');
INSERT INTO `gw_alert` VALUES ('150', 'D3031', '1', '2', '成功', '2071', 'over', '1');
INSERT INTO `gw_alert` VALUES ('151', 'D3041', '1', '2', '成功', '2072', 'over', '1');
INSERT INTO `gw_alert` VALUES ('152', 'D3031', '1', '2', '成功', '2081', 'over', '1');
INSERT INTO `gw_alert` VALUES ('153', 'D3041', '1', '2', '成功', '2082', 'over', '1');
INSERT INTO `gw_alert` VALUES ('154', 'D3031', '1', '2', '成功', '2091', 'over', '1');
INSERT INTO `gw_alert` VALUES ('155', 'D3041', '1', '2', '成功', '2092', 'over', '1');
INSERT INTO `gw_alert` VALUES ('156', 'D3031', '2', '2', '失败', '2011', 'over', '1');
INSERT INTO `gw_alert` VALUES ('157', 'D3041', '2', '2', '失败', '2012', 'over', '1');
INSERT INTO `gw_alert` VALUES ('158', 'D3031', '2', '2', '失败', '2021', 'over', '1');
INSERT INTO `gw_alert` VALUES ('159', 'D3041', '2', '2', '失败', '2022', 'over', '1');
INSERT INTO `gw_alert` VALUES ('160', 'D3031', '2', '2', '失败', '2031', 'over', '1');
INSERT INTO `gw_alert` VALUES ('161', 'D3041', '2', '2', '失败', '2032', 'over', '1');
INSERT INTO `gw_alert` VALUES ('162', 'D3031', '2', '2', '失败', '2041', 'over', '1');
INSERT INTO `gw_alert` VALUES ('163', 'D3041', '2', '2', '失败', '2042', 'over', '1');
INSERT INTO `gw_alert` VALUES ('164', 'D3031', '2', '2', '失败', '2051', 'over', '1');
INSERT INTO `gw_alert` VALUES ('165', 'D3041', '2', '2', '失败', '2052', 'over', '1');
INSERT INTO `gw_alert` VALUES ('166', 'D3031', '2', '2', '失败', '2061', 'over', '1');
INSERT INTO `gw_alert` VALUES ('167', 'D3041', '2', '2', '失败', '2062', 'over', '1');
INSERT INTO `gw_alert` VALUES ('168', 'D3031', '2', '2', '失败', '2071', 'over', '1');
INSERT INTO `gw_alert` VALUES ('169', 'D3041', '2', '2', '失败', '2072', 'over', '1');
INSERT INTO `gw_alert` VALUES ('170', 'D3031', '2', '2', '失败', '2081', 'over', '1');
INSERT INTO `gw_alert` VALUES ('171', 'D3041', '2', '2', '失败', '2082', 'over', '1');
INSERT INTO `gw_alert` VALUES ('172', 'D3031', '2', '2', '失败', '2091', 'over', '1');
INSERT INTO `gw_alert` VALUES ('173', 'D3041', '2', '2', '失败', '2092', 'over', '1');
INSERT INTO `gw_alert` VALUES ('200', 'A026', '1', '2', '成功', '5013', 'over', '1');
INSERT INTO `gw_alert` VALUES ('201', 'A026', '1', '2', '成功', '5014', 'over', '1');
INSERT INTO `gw_alert` VALUES ('202', 'A026', '1', '2', '成功', '5015', 'over', '1');
INSERT INTO `gw_alert` VALUES ('203', 'A026', '1', '2', '成功', '5016', 'over', '1');
INSERT INTO `gw_alert` VALUES ('204', 'A026', '2', '2', '失败', '5013', 'over', '1');
INSERT INTO `gw_alert` VALUES ('205', 'A026', '2', '2', '失败', '5014', 'over', '1');
INSERT INTO `gw_alert` VALUES ('206', 'A026', '2', '2', '失败', '5015', 'over', '1');
INSERT INTO `gw_alert` VALUES ('207', 'A026', '2', '2', '失败', '5016', 'over', '1');
INSERT INTO `gw_alert` VALUES ('300', 'B003', '1', '2', '成功', '1011', 'over', '1');
INSERT INTO `gw_alert` VALUES ('301', 'B003', '1', '2', '成功', '1012', 'over', '1');
INSERT INTO `gw_alert` VALUES ('302', 'B003', '1', '2', '成功', '1021', 'over', '1');
INSERT INTO `gw_alert` VALUES ('303', 'B003', '1', '2', '成功', '1022', 'over', '1');
INSERT INTO `gw_alert` VALUES ('304', 'B003', '1', '2', '成功', '1031', 'over', '1');
INSERT INTO `gw_alert` VALUES ('305', 'B003', '1', '2', '成功', '1032', 'over', '1');
INSERT INTO `gw_alert` VALUES ('306', 'B003', '1', '2', '成功', '1041', 'over', '1');
INSERT INTO `gw_alert` VALUES ('307', 'B003', '1', '2', '成功', '1042', 'over', '1');
INSERT INTO `gw_alert` VALUES ('308', 'B003', '1', '2', '成功', '1051', 'over', '1');
INSERT INTO `gw_alert` VALUES ('309', 'B003', '1', '2', '成功', '1052', 'over', '1');
INSERT INTO `gw_alert` VALUES ('310', 'B003', '1', '2', '成功', '1061', 'over', '1');
INSERT INTO `gw_alert` VALUES ('311', 'B003', '1', '2', '成功', '1062', 'over', '1');
INSERT INTO `gw_alert` VALUES ('312', 'B003', '1', '2', '成功', '1071', 'over', '1');
INSERT INTO `gw_alert` VALUES ('313', 'B003', '1', '2', '成功', '1072', 'over', '1');
INSERT INTO `gw_alert` VALUES ('314', 'B003', '1', '2', '成功', '1081', 'over', '1');
INSERT INTO `gw_alert` VALUES ('315', 'B003', '1', '2', '成功', '1082', 'over', '1');
INSERT INTO `gw_alert` VALUES ('316', 'B003', '1', '2', '成功', '1091', 'over', '1');
INSERT INTO `gw_alert` VALUES ('317', 'B003', '1', '2', '成功', '1092', 'over', '1');
INSERT INTO `gw_alert` VALUES ('318', 'B003', '2', '2', '失败', '1011', 'over', '1');
INSERT INTO `gw_alert` VALUES ('319', 'B003', '2', '2', '失败', '1012', 'over', '1');
INSERT INTO `gw_alert` VALUES ('320', 'B003', '2', '2', '失败', '1021', 'over', '1');
INSERT INTO `gw_alert` VALUES ('321', 'B003', '2', '2', '失败', '1022', 'over', '1');
INSERT INTO `gw_alert` VALUES ('322', 'B003', '2', '2', '失败', '1031', 'over', '1');
INSERT INTO `gw_alert` VALUES ('323', 'B003', '2', '2', '失败', '1032', 'over', '1');
INSERT INTO `gw_alert` VALUES ('324', 'B003', '2', '2', '失败', '1041', 'over', '1');
INSERT INTO `gw_alert` VALUES ('325', 'B003', '2', '2', '失败', '1042', 'over', '1');
INSERT INTO `gw_alert` VALUES ('326', 'B003', '2', '2', '失败', '1051', 'over', '1');
INSERT INTO `gw_alert` VALUES ('327', 'B003', '2', '2', '失败', '1052', 'over', '1');
INSERT INTO `gw_alert` VALUES ('328', 'B003', '2', '2', '失败', '1061', 'over', '1');
INSERT INTO `gw_alert` VALUES ('329', 'B003', '2', '2', '失败', '1062', 'over', '1');
INSERT INTO `gw_alert` VALUES ('330', 'B003', '2', '2', '失败', '1071', 'over', '1');
INSERT INTO `gw_alert` VALUES ('331', 'B003', '2', '2', '失败', '1072', 'over', '1');
INSERT INTO `gw_alert` VALUES ('332', 'B003', '2', '2', '失败', '1081', 'over', '1');
INSERT INTO `gw_alert` VALUES ('333', 'B003', '2', '2', '失败', '1082', 'over', '1');
INSERT INTO `gw_alert` VALUES ('334', 'B003', '2', '2', '失败', '1091', 'over', '1');
INSERT INTO `gw_alert` VALUES ('335', 'B003', '2', '2', '失败', '1092', 'over', '1');
INSERT INTO `gw_alert` VALUES ('336', 'D1911', '1', '2', '成功', '1', 'over', '1');
INSERT INTO `gw_alert` VALUES ('337', 'D1911', '2', '2', '失败', '1', 'over', '1');
INSERT INTO `gw_alert` VALUES ('338', 'D1911', '3', '2', '点检中', '1', '', '1');
INSERT INTO `gw_alert` VALUES ('401', 'D2801', '1', '2', '成功', '6001', 'over', '1');
INSERT INTO `gw_alert` VALUES ('402', 'D2806', '1', '2', '成功', '6002', 'over', '1');
INSERT INTO `gw_alert` VALUES ('403', 'D2801', '2', '2', '失败', '6001', 'over', '1');
INSERT INTO `gw_alert` VALUES ('404', 'D2806', '2', '2', '失败', '6002', 'over', '1');
INSERT INTO `gw_alert` VALUES ('405', 'D3031', '2', '2', '失败', '6721067917451984896', 'over', '1');
INSERT INTO `gw_alert` VALUES ('406', 'D3031', '1', '2', '成功', '6721067917451984896', 'over', '1');
INSERT INTO `gw_alert` VALUES ('407', 'D3031', '3', '2', '点检中', '6721067917451984896', '', '1');
INSERT INTO `gw_alert` VALUES ('408', 'D4441', '1', '2', '成功', '5821300000000000152_1', 'over', '1');
INSERT INTO `gw_alert` VALUES ('409', 'D1021', '2', '2', '失败', '5821300000000000152_2', 'over', '1');
INSERT INTO `gw_alert` VALUES ('410', 'D3031', '1', '2', '成功', '2603', 'over', '1');
INSERT INTO `gw_alert` VALUES ('411', 'D3031', '2', '2', '失败', '2603', 'over', '1');
INSERT INTO `gw_alert` VALUES ('412', 'D4441', '2', '2', '失败', '5821300000000000152_1', 'over', '1');
INSERT INTO `gw_alert` VALUES ('413', 'D1021', '1', '2', '成功', '5821300000000000152_2', 'over', '1');
INSERT INTO `gw_alert` VALUES ('414', 'D3021', '1', '2', '成功', '4202', 'over', '1');
INSERT INTO `gw_alert` VALUES ('415', 'D3021', '2', '2', '失败', '4202', 'over', '1');
INSERT INTO `gw_alert` VALUES ('416', 'D3031', '1', '2', '成功', '2601', 'over', '1');
INSERT INTO `gw_alert` VALUES ('417', 'D3031', '2', '2', '失败', '2601', 'over', '1');
INSERT INTO `gw_alert` VALUES ('418', 'D3041', '1', '2', '成功', '2602', 'over', '1');
INSERT INTO `gw_alert` VALUES ('419', 'D3041', '2', '2', '失败', '2602', 'over', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=410 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gw_function
-- ----------------------------
INSERT INTO `gw_function` VALUES ('1', '4001', '172.28.12.6', 'mc', '8000', 'D3010', 'short', '2', 'D3011', '点检', '1', '5122');
INSERT INTO `gw_function` VALUES ('2', '4002', '172.28.12.6', 'mc', '8000', 'D3020', 'short', '2', 'D3021', '点检', '1', '5122');
INSERT INTO `gw_function` VALUES ('3', '4003', '172.28.12.26', 'mc', '8000', 'D3010', 'short', '2', 'D3011', '点检', '1', '5122');
INSERT INTO `gw_function` VALUES ('4', '4004', '172.28.12.26', 'mc', '8000', 'D3020', 'short', '2', 'D3021', '点检', '1', '5122');
INSERT INTO `gw_function` VALUES ('5', '4005', '172.28.12.46', 'mc', '8000', 'D3010', 'short', '2', 'D3011', '点检', '1', '5122');
INSERT INTO `gw_function` VALUES ('6', '4006', '172.28.12.46', 'mc', '8000', 'D3020', 'short', '2', 'D3021', '点检', '1', '5122');
INSERT INTO `gw_function` VALUES ('7', '4007', '172.28.12.66', 'mc', '8000', 'D3010', 'short', '2', 'D3011', '点检', '1', '5122');
INSERT INTO `gw_function` VALUES ('8', '4008', '172.28.12.66', 'mc', '8000', 'D3020', 'short', '2', 'D3021', '点检', '1', '5122');
INSERT INTO `gw_function` VALUES ('9', '4009', '172.28.12.86', 'mc', '8000', 'D3010', 'short', '2', 'D3011', '点检', '1', '5122');
INSERT INTO `gw_function` VALUES ('10', '4010', '172.28.12.86', 'mc', '8000', 'D3020', 'short', '2', 'D3021', '点检', '1', '5122');
INSERT INTO `gw_function` VALUES ('11', '4601', '172.28.12.103', 'mc', '8000', 'D3010', 'short', '2', 'D3011', '点检', '1', '5122');
INSERT INTO `gw_function` VALUES ('12', '4602', '172.28.12.105', 'mc', '8000', 'D3010', 'short', '2', 'D3011', '点检', '1', '5122');
INSERT INTO `gw_function` VALUES ('13', '4201', '172.28.12.115', 'mc', '8000', 'D3010', 'short', '2', 'D3011', '点检', '1', '5122');
INSERT INTO `gw_function` VALUES ('14', '4203', '172.28.12.119', 'mc', '8000', 'D3010', 'short', '2', 'D3011', '点检', '1', '5122');
INSERT INTO `gw_function` VALUES ('15', '5821300000000000113', '172.28.10.15', 'mc', '8000', 'D2220-1', 'bit', '2', 'D2221', '单臂炸点检', '1', '700');
INSERT INTO `gw_function` VALUES ('18', '1092', '172.28.12.84', 'mcu', '50000', 'B000', 'short', '2', 'B003', '炒锅点检', '1', '4098');
INSERT INTO `gw_function` VALUES ('100', '5001', '172.28.13.2', 'mcu', '50000', 'A023', 'short', '2', 'A026', '点检', '1', '5889');
INSERT INTO `gw_function` VALUES ('101', '5002', '172.28.13.3', 'mcu', '50000', 'A023', 'short', '2', 'A026', '点检', '1', '5889');
INSERT INTO `gw_function` VALUES ('102', '5003', '172.28.13.4', 'mcu', '50000', 'A023', 'short', '2', 'A026', '点检', '1', '5889');
INSERT INTO `gw_function` VALUES ('103', '5004', '172.28.13.5', 'mcu', '50000', 'A023', 'short', '2', 'A026', '点检', '1', '5889');
INSERT INTO `gw_function` VALUES ('104', '5005', '172.28.13.6', 'mcu', '50000', 'A023', 'short', '2', 'A026', '点检', '1', '5889');
INSERT INTO `gw_function` VALUES ('105', '5006', '172.28.13.7', 'mcu', '50000', 'A023', 'short', '2', 'A026', '点检', '1', '5889');
INSERT INTO `gw_function` VALUES ('106', '5007', '172.28.13.8', 'mcu', '50000', 'A023', 'short', '2', 'A026', '点检', '1', '5889');
INSERT INTO `gw_function` VALUES ('107', '5008', '172.28.13.9', 'mcu', '50000', 'A023', 'short', '2', 'A026', '点检', '1', '5889');
INSERT INTO `gw_function` VALUES ('108', '5009', '172.28.13.10', 'mcu', '50000', 'A023', 'short', '2', 'A026', '点检', '1', '5889');
INSERT INTO `gw_function` VALUES ('109', '5010', '172.28.13.11', 'mcu', '50000', 'A023', 'short', '2', 'A026', '点检', '1', '5889');
INSERT INTO `gw_function` VALUES ('110', '5011', '172.28.13.12', 'mcu', '50000', 'A023', 'short', '2', 'A026', '点检', '1', '5889');
INSERT INTO `gw_function` VALUES ('111', '5012', '172.28.13.13', 'mcu', '50000', 'A023', 'short', '2', 'A026', '点检', '1', '5889');
INSERT INTO `gw_function` VALUES ('112', '5017', '172.28.13.18', 'mcu', '50000', 'A023', 'short', '2', 'A026', '点检', '1', '5889');
INSERT INTO `gw_function` VALUES ('113', '5018', '172.28.13.19', 'mcu', '50000', 'A023', 'short', '2', 'A026', '点检', '1', '5889');
INSERT INTO `gw_function` VALUES ('114', '5019', '172.28.13.20', 'mcu', '50000', 'A023', 'short', '2', 'A026', '点检', '1', '5889');
INSERT INTO `gw_function` VALUES ('115', '5020', '172.28.13.21', 'mcu', '50000', 'A023', 'short', '2', 'A026', '点检', '1', '5889');
INSERT INTO `gw_function` VALUES ('116', '5021', '172.28.13.22', 'mcu', '50000', 'A023', 'short', '2', 'A026', '点检', '1', '5889');
INSERT INTO `gw_function` VALUES ('117', '5022', '172.28.13.23', 'mcu', '50000', 'A023', 'short', '2', 'A026', '点检', '1', '5889');
INSERT INTO `gw_function` VALUES ('118', '5023', '172.28.13.24', 'mcu', '50000', 'A023', 'short', '2', 'A026', '点检', '1', '5889');
INSERT INTO `gw_function` VALUES ('119', '2011', '172.28.12.8', 'mc', '8003', 'D3030', 'short', '2', 'D3031', '点检', '1', '4355');
INSERT INTO `gw_function` VALUES ('120', '2012', '172.28.12.8', 'mc', '8003', 'D3040', 'short', '2', 'D3041', '点检', '1', '4355');
INSERT INTO `gw_function` VALUES ('121', '2021', '172.28.12.18', 'mc', '8003', 'D3030', 'short', '2', 'D3031', '点检', '1', '4355');
INSERT INTO `gw_function` VALUES ('122', '2022', '172.28.12.18', 'mc', '8003', 'D3040', 'short', '2', 'D3041', '点检', '1', '4355');
INSERT INTO `gw_function` VALUES ('123', '2031', '172.28.12.28', 'mc', '8003', 'D3030', 'short', '2', 'D3031', '点检', '1', '4355');
INSERT INTO `gw_function` VALUES ('124', '2032', '172.28.12.28', 'mc', '8003', 'D3040', 'short', '2', 'D3041', '点检', '1', '4355');
INSERT INTO `gw_function` VALUES ('125', '2041', '172.28.12.38', 'mc', '8003', 'D3030', 'short', '2', 'D3031', '点检', '1', '4355');
INSERT INTO `gw_function` VALUES ('126', '2042', '172.28.12.38', 'mc', '8003', 'D3040', 'short', '2', 'D3041', '点检', '1', '4355');
INSERT INTO `gw_function` VALUES ('127', '2051', '172.28.12.48', 'mc', '8003', 'D3030', 'short', '2', 'D3031', '点检', '1', '4355');
INSERT INTO `gw_function` VALUES ('128', '2052', '172.28.12.48', 'mc', '8003', 'D3040', 'short', '2', 'D3041', '点检', '1', '4355');
INSERT INTO `gw_function` VALUES ('129', '2061', '172.28.12.58', 'mc', '8003', 'D3030', 'short', '2', 'D3031', '点检', '1', '4355');
INSERT INTO `gw_function` VALUES ('130', '2062', '172.28.12.58', 'mc', '8003', 'D3040', 'short', '2', 'D3041', '点检', '1', '4355');
INSERT INTO `gw_function` VALUES ('131', '2071', '172.28.12.68', 'mc', '8003', 'D3030', 'short', '2', 'D3031', '点检', '1', '4355');
INSERT INTO `gw_function` VALUES ('132', '2072', '172.28.12.68', 'mc', '8003', 'D3040', 'short', '2', 'D3041', '点检', '1', '4355');
INSERT INTO `gw_function` VALUES ('133', '2081', '172.28.12.78', 'mc', '8003', 'D3030', 'short', '2', 'D3031', '点检', '1', '4355');
INSERT INTO `gw_function` VALUES ('134', '2082', '172.28.12.78', 'mc', '8003', 'D3040', 'short', '2', 'D3041', '点检', '1', '4355');
INSERT INTO `gw_function` VALUES ('135', '2091', '172.28.12.88', 'mc', '8003', 'D3030', 'short', '2', 'D3031', '点检', '1', '4355');
INSERT INTO `gw_function` VALUES ('136', '2092', '172.28.12.88', 'mc', '8003', 'D3040', 'short', '2', 'D3041', '点检', '1', '4355');
INSERT INTO `gw_function` VALUES ('200', '5013', '172.28.13.14', 'mcu', '50000', 'A023', 'short', '2', 'A026', '点检', '1', '5889');
INSERT INTO `gw_function` VALUES ('201', '5014', '172.28.13.15', 'mcu', '50000', 'A023', 'short', '2', 'A026', '点检', '1', '5889');
INSERT INTO `gw_function` VALUES ('202', '5015', '172.28.13.16', 'mcu', '50000', 'A023', 'short', '2', 'A026', '点检', '1', '5889');
INSERT INTO `gw_function` VALUES ('203', '5016', '172.28.13.17', 'mcu', '50000', 'A023', 'short', '2', 'A026', '点检', '1', '5889');
INSERT INTO `gw_function` VALUES ('300', '1011', '172.28.12.2', 'mcu', '50000', 'B000', 'short', '2', 'B003', '炒锅点检', '1', '4098');
INSERT INTO `gw_function` VALUES ('301', '1012', '172.28.12.4', 'mcu', '50000', 'B000', 'short', '2', 'B003', '炒锅点检', '1', '4098');
INSERT INTO `gw_function` VALUES ('302', '1021', '172.28.12.12', 'mcu', '50000', 'B000', 'short', '2', 'B003', '炒锅点检', '1', '4098');
INSERT INTO `gw_function` VALUES ('303', '1022', '172.28.12.14', 'mcu', '50000', 'B000', 'short', '2', 'B003', '炒锅点检', '1', '4098');
INSERT INTO `gw_function` VALUES ('304', '1031', '172.28.12.22', 'mcu', '50000', 'B000', 'short', '2', 'B003', '炒锅点检', '1', '4098');
INSERT INTO `gw_function` VALUES ('305', '1032', '172.28.12.24', 'mcu', '50000', 'B000', 'short', '2', 'B003', '炒锅点检', '1', '4098');
INSERT INTO `gw_function` VALUES ('306', '1041', '172.28.12.32', 'mcu', '50000', 'B000', 'short', '2', 'B003', '炒锅点检', '1', '4098');
INSERT INTO `gw_function` VALUES ('307', '1042', '172.28.12.34', 'mcu', '50000', 'B000', 'short', '2', 'B003', '炒锅点检', '1', '4098');
INSERT INTO `gw_function` VALUES ('308', '1051', '172.28.12.42', 'mcu', '50000', 'B000', 'short', '2', 'B003', '炒锅点检', '1', '4098');
INSERT INTO `gw_function` VALUES ('309', '1052', '172.28.12.44', 'mcu', '50000', 'B000', 'short', '2', 'B003', '炒锅点检', '1', '4098');
INSERT INTO `gw_function` VALUES ('310', '1061', '172.28.12.52', 'mcu', '50000', 'B000', 'short', '2', 'B003', '炒锅点检', '1', '4098');
INSERT INTO `gw_function` VALUES ('311', '1062', '172.28.12.54', 'mcu', '50000', 'B000', 'short', '2', 'B003', '炒锅点检', '1', '4098');
INSERT INTO `gw_function` VALUES ('312', '1071', '172.28.12.62', 'mcu', '50000', 'B000', 'short', '2', 'B003', '炒锅点检', '1', '4098');
INSERT INTO `gw_function` VALUES ('313', '1072', '172.28.12.64', 'mcu', '50000', 'B000', 'short', '2', 'B003', '炒锅点检', '1', '4098');
INSERT INTO `gw_function` VALUES ('314', '1081', '172.28.12.72', 'mcu', '50000', 'B000', 'short', '2', 'B003', '炒锅点检', '1', '4098');
INSERT INTO `gw_function` VALUES ('315', '1082', '172.28.12.74', 'mcu', '50000', 'B000', 'short', '2', 'B003', '炒锅点检', '1', '4098');
INSERT INTO `gw_function` VALUES ('316', '1091', '172.28.12.82', 'mcu', '50000', 'B000', 'short', '2', 'B003', '炒锅点检', '1', '4098');
INSERT INTO `gw_function` VALUES ('317', '1092', '172.28.12.84', 'mcu', '50000', 'B000', 'short', '2', 'B003', '炒锅点检', '1', '4098');
INSERT INTO `gw_function` VALUES ('318', '1', '172.28.11.2', 'mc', '8000', 'D1910', 'short', '2', 'D1911', '点检', '1', '4865');
INSERT INTO `gw_function` VALUES ('400', '6001', '172.28.12.100', 'mc', '8000', 'D2800', 'short', '2', 'D2801', '点检', '1', '6145');
INSERT INTO `gw_function` VALUES ('401', '6002', '172.28.12.100', 'mc', '8000', 'D2805', 'short', '2', 'D2806', '点检', '1', '6145');
INSERT INTO `gw_function` VALUES ('402', '6721067917451984896', '172.28.10.121', 'mc', '8000', 'D3030', 'short', '2', 'D3031', '一代粉面点检', '1', '750');
INSERT INTO `gw_function` VALUES ('403', '5821300000000000152_1', '172.28.10.10', 'mc', '8001', 'D4440', 'short', '2', 'D4441', '蛋糕机点检', '1', '721');
INSERT INTO `gw_function` VALUES ('404', '5821300000000000152_2', '172.28.10.2', 'mc', '8001', 'D1020', 'short', '2', 'D1021', '奶茶机点检', '1', '721');
INSERT INTO `gw_function` VALUES ('406', '2603', '172.28.12.109', 'mc', '8003', 'D3030', 'short', '2', 'D3031', '料盒点检', '1', '4355');
INSERT INTO `gw_function` VALUES ('407', '4202', '172.28.12.115', 'mc', '8000', 'D3020', 'short', '2', 'D3021', '人工上菜口点检', '1', '5122');
INSERT INTO `gw_function` VALUES ('408', '2601', '172.28.12.107', 'mc', '8003', 'D3030', 'short', '2', 'D3031', '冷库点检', '1', '4355');
INSERT INTO `gw_function` VALUES ('409', '2602', '172.28.12.107', 'mc', '8003', 'D3040', 'short', '2', 'D3041', '冷库点检', '1', '4355');

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
) ENGINE=InnoDB AUTO_INCREMENT=409 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gw_ioinfo
-- ----------------------------
INSERT INTO `gw_ioinfo` VALUES ('1', '4001', '172.28.12.6', 'mc', '8000', 'D3011', 'short', '上菜口', '点检状态', '5122', '1');
INSERT INTO `gw_ioinfo` VALUES ('2', '4002', '172.28.12.6', 'mc', '8000', 'D3021', 'short', '上菜口', '点检状态', '5122', '1');
INSERT INTO `gw_ioinfo` VALUES ('3', '4003', '172.28.12.26', 'mc', '8000', 'D3011', 'short', '上菜口', '点检状态', '5122', '1');
INSERT INTO `gw_ioinfo` VALUES ('4', '4004', '172.28.12.26', 'mc', '8000', 'D3021', 'short', '上菜口', '点检状态', '5122', '1');
INSERT INTO `gw_ioinfo` VALUES ('5', '4006', '172.28.12.46', 'mc', '8000', 'D3021', 'short', '上菜口', '点检状态', '5122', '1');
INSERT INTO `gw_ioinfo` VALUES ('6', '4005', '172.28.12.46', 'mc', '8000', 'D3011', 'short', '上菜口', '点检状态', '5122', '1');
INSERT INTO `gw_ioinfo` VALUES ('7', '4007', '172.28.12.66', 'mc', '8000', 'D3011', 'short', '上菜口', '点检状态', '5122', '1');
INSERT INTO `gw_ioinfo` VALUES ('8', '4008', '172.28.12.66', 'mc', '8000', 'D3021', 'short', '上菜口', '点检状态', '5122', '1');
INSERT INTO `gw_ioinfo` VALUES ('9', '4009', '172.28.12.86', 'mc', '8000', 'D3011', 'short', '上菜口', '点检状态', '5122', '1');
INSERT INTO `gw_ioinfo` VALUES ('10', '4010', '172.28.12.86', 'mc', '8000', 'D3021', 'short', '上菜口', '点检状态', '5122', '1');
INSERT INTO `gw_ioinfo` VALUES ('11', '4601', '172.28.12.103', 'mc', '8000', 'D3011', 'short', '上菜口', '点检状态', '5122', '1');
INSERT INTO `gw_ioinfo` VALUES ('12', '4602', '172.28.12.105', 'mc', '8000', 'D3011', 'short', '上菜口', '点检状态', '5122', '1');
INSERT INTO `gw_ioinfo` VALUES ('13', '4201', '172.28.12.115', 'mc', '8000', 'D3011', 'short', '上菜口', '点检状态', '5122', '1');
INSERT INTO `gw_ioinfo` VALUES ('14', '4203', '172.28.12.119', 'mc', '8000', 'D3011', 'short', '上菜口', '点检状态', '5122', '1');
INSERT INTO `gw_ioinfo` VALUES ('15', '5821300000000000113', '172.28.10.15', 'mc', '8000', 'D2221', 'short', '单臂炸', '点检状态', '700', '1');
INSERT INTO `gw_ioinfo` VALUES ('100', '5001', '172.28.13.2', 'mcu', '50000', 'A026', 'short', '下菜口点检', '点检状态', '5889', '1');
INSERT INTO `gw_ioinfo` VALUES ('101', '5002', '172.28.13.3', 'mcu', '50000', 'A026', 'short', '下菜口点检', '点检状态', '5889', '1');
INSERT INTO `gw_ioinfo` VALUES ('102', '5003', '172.28.13.4', 'mcu', '50000', 'A026', 'short', '下菜口点检', '点检状态', '5889', '1');
INSERT INTO `gw_ioinfo` VALUES ('103', '5004', '172.28.13.5', 'mcu', '50000', 'A026', 'short', '下菜口点检', '点检状态', '5889', '1');
INSERT INTO `gw_ioinfo` VALUES ('104', '5005', '172.28.13.6', 'mcu', '50000', 'A026', 'short', '下菜口点检', '点检状态', '5889', '1');
INSERT INTO `gw_ioinfo` VALUES ('105', '5006', '172.28.13.7', 'mcu', '50000', 'A026', 'short', '下菜口点检', '点检状态', '5889', '1');
INSERT INTO `gw_ioinfo` VALUES ('106', '5007', '172.28.13.8', 'mcu', '50000', 'A026', 'short', '下菜口点检', '点检状态', '5889', '1');
INSERT INTO `gw_ioinfo` VALUES ('107', '5008', '172.28.13.9', 'mcu', '50000', 'A026', 'short', '下菜口点检', '点检状态', '5889', '1');
INSERT INTO `gw_ioinfo` VALUES ('108', '5009', '172.28.13.10', 'mcu', '50000', 'A026', 'short', '下菜口点检', '点检状态', '5889', '1');
INSERT INTO `gw_ioinfo` VALUES ('109', '5010', '172.28.13.11', 'mcu', '50000', 'A026', 'short', '下菜口点检', '点检状态', '5889', '1');
INSERT INTO `gw_ioinfo` VALUES ('110', '5011', '172.28.13.12', 'mcu', '50000', 'A026', 'short', '下菜口点检', '点检状态', '5889', '1');
INSERT INTO `gw_ioinfo` VALUES ('111', '5012', '172.28.13.13', 'mcu', '50000', 'A026', 'short', '下菜口点检', '点检状态', '5889', '1');
INSERT INTO `gw_ioinfo` VALUES ('112', '5017', '172.28.13.18', 'mcu', '50000', 'A026', 'short', '下菜口点检', '点检状态', '5889', '1');
INSERT INTO `gw_ioinfo` VALUES ('113', '5018', '172.28.13.19', 'mcu', '50000', 'A026', 'short', '下菜口点检', '点检状态', '5889', '1');
INSERT INTO `gw_ioinfo` VALUES ('114', '5019', '172.28.13.20', 'mcu', '50000', 'A026', 'short', '下菜口点检', '点检状态', '5889', '1');
INSERT INTO `gw_ioinfo` VALUES ('115', '5020', '172.28.13.21', 'mcu', '50000', 'A026', 'short', '下菜口点检', '点检状态', '5889', '1');
INSERT INTO `gw_ioinfo` VALUES ('116', '5021', '172.28.13.22', 'mcu', '50000', 'A026', 'short', '下菜口点检', '点检状态', '5889', '1');
INSERT INTO `gw_ioinfo` VALUES ('117', '5022', '172.28.13.23', 'mcu', '50000', 'A026', 'short', '下菜口点检', '点检状态', '5889', '1');
INSERT INTO `gw_ioinfo` VALUES ('118', '5023', '172.28.13.24', 'mcu', '50000', 'A026', 'short', '下菜口点检', '点检状态', '5889', '1');
INSERT INTO `gw_ioinfo` VALUES ('119', '2011', '172.28.12.8', 'mc', '8003', 'D3031', 'short', '冷柜点检', '点检状态', '4355', '1');
INSERT INTO `gw_ioinfo` VALUES ('120', '2012', '172.28.12.8', 'mc', '8003', 'D3041', 'short', '冷柜点检', '点检状态', '4355', '1');
INSERT INTO `gw_ioinfo` VALUES ('121', '2021', '172.28.12.18', 'mc', '8003', 'D3031', 'short', '冷柜点检', '点检状态', '4355', '1');
INSERT INTO `gw_ioinfo` VALUES ('122', '2022', '172.28.12.18', 'mc', '8003', 'D3041', 'short', '冷柜点检', '点检状态', '4355', '1');
INSERT INTO `gw_ioinfo` VALUES ('123', '2031', '172.28.12.28', 'mc', '8003', 'D3031', 'short', '冷柜点检', '点检状态', '4355', '1');
INSERT INTO `gw_ioinfo` VALUES ('124', '2032', '172.28.12.28', 'mc', '8003', 'D3041', 'short', '冷柜点检', '点检状态', '4355', '1');
INSERT INTO `gw_ioinfo` VALUES ('125', '2041', '172.28.12.38', 'mc', '8003', 'D3031', 'short', '冷柜点检', '点检状态', '4355', '1');
INSERT INTO `gw_ioinfo` VALUES ('126', '2042', '172.28.12.38', 'mc', '8003', 'D3041', 'short', '冷柜点检', '点检状态', '4355', '1');
INSERT INTO `gw_ioinfo` VALUES ('127', '2051', '172.28.12.48', 'mc', '8003', 'D3031', 'short', '冷柜点检', '点检状态', '4355', '1');
INSERT INTO `gw_ioinfo` VALUES ('128', '2052', '172.28.12.48', 'mc', '8003', 'D3041', 'short', '冷柜点检', '点检状态', '4355', '1');
INSERT INTO `gw_ioinfo` VALUES ('129', '2061', '172.28.12.58', 'mc', '8003', 'D3031', 'short', '冷柜点检', '点检状态', '4355', '1');
INSERT INTO `gw_ioinfo` VALUES ('130', '2062', '172.28.12.58', 'mc', '8003', 'D3041', 'short', '冷柜点检', '点检状态', '4355', '1');
INSERT INTO `gw_ioinfo` VALUES ('131', '2071', '172.28.12.68', 'mc', '8003', 'D3031', 'short', '冷柜点检', '点检状态', '4355', '1');
INSERT INTO `gw_ioinfo` VALUES ('132', '2072', '172.28.12.68', 'mc', '8003', 'D3041', 'short', '冷柜点检', '点检状态', '4355', '1');
INSERT INTO `gw_ioinfo` VALUES ('133', '2081', '172.28.12.78', 'mc', '8003', 'D3031', 'short', '冷柜点检', '点检状态', '4355', '1');
INSERT INTO `gw_ioinfo` VALUES ('134', '2082', '172.28.12.78', 'mc', '8003', 'D3041', 'short', '冷柜点检', '点检状态', '4355', '1');
INSERT INTO `gw_ioinfo` VALUES ('135', '2091', '172.28.12.88', 'mc', '8003', 'D3031', 'short', '冷柜点检', '点检状态', '4355', '1');
INSERT INTO `gw_ioinfo` VALUES ('136', '2092', '172.28.12.88', 'mc', '8003', 'D3041', 'short', '冷柜点检', '点检状态', '4355', '1');
INSERT INTO `gw_ioinfo` VALUES ('200', '5013', '172.28.13.14', 'mcu', '50000', 'A026', 'short', '下菜口点检', '点检状态', '5889', '1');
INSERT INTO `gw_ioinfo` VALUES ('201', '5014', '172.28.13.15', 'mcu', '50000', 'A026', 'short', '下菜口点检', '点检状态', '5889', '1');
INSERT INTO `gw_ioinfo` VALUES ('202', '5015', '172.28.13.16', 'mcu', '50000', 'A026', 'short', '下菜口点检', '点检状态', '5889', '1');
INSERT INTO `gw_ioinfo` VALUES ('203', '5016', '172.28.13.17', 'mcu', '50000', 'A026', 'short', '下菜口点检', '点检状态', '5889', '1');
INSERT INTO `gw_ioinfo` VALUES ('300', '1011', '172.28.12.2', 'mcu', '50000', 'B003', 'short', '炒锅点检', '点检状态', '4098', '1');
INSERT INTO `gw_ioinfo` VALUES ('301', '1012', '172.28.12.4', 'mcu', '50000', 'B003', 'short', '炒锅点检', '点检状态', '4098', '1');
INSERT INTO `gw_ioinfo` VALUES ('302', '1021', '172.28.12.12', 'mcu', '50000', 'B003', 'short', '炒锅点检', '点检状态', '4098', '1');
INSERT INTO `gw_ioinfo` VALUES ('303', '1022', '172.28.12.14', 'mcu', '50000', 'B003', 'short', '炒锅点检', '点检状态', '4098', '1');
INSERT INTO `gw_ioinfo` VALUES ('304', '1031', '172.28.12.22', 'mcu', '50000', 'B003', 'short', '炒锅点检', '点检状态', '4098', '1');
INSERT INTO `gw_ioinfo` VALUES ('305', '1032', '172.28.12.24', 'mcu', '50000', 'B003', 'short', '炒锅点检', '点检状态', '4098', '1');
INSERT INTO `gw_ioinfo` VALUES ('306', '1041', '172.28.12.32', 'mcu', '50000', 'B003', 'short', '炒锅点检', '点检状态', '4098', '1');
INSERT INTO `gw_ioinfo` VALUES ('307', '1042', '172.28.12.34', 'mcu', '50000', 'B003', 'short', '炒锅点检', '点检状态', '4098', '1');
INSERT INTO `gw_ioinfo` VALUES ('308', '1051', '172.28.12.42', 'mcu', '50000', 'B003', 'short', '炒锅点检', '点检状态', '4098', '1');
INSERT INTO `gw_ioinfo` VALUES ('309', '1052', '172.28.12.44', 'mcu', '50000', 'B003', 'short', '炒锅点检', '点检状态', '4098', '1');
INSERT INTO `gw_ioinfo` VALUES ('310', '1061', '172.28.12.52', 'mcu', '50000', 'B003', 'short', '炒锅点检', '点检状态', '4098', '1');
INSERT INTO `gw_ioinfo` VALUES ('311', '1062', '172.28.12.54', 'mcu', '50000', 'B003', 'short', '炒锅点检', '点检状态', '4098', '1');
INSERT INTO `gw_ioinfo` VALUES ('312', '1071', '172.28.12.62', 'mcu', '50000', 'B003', 'short', '炒锅点检', '点检状态', '4098', '1');
INSERT INTO `gw_ioinfo` VALUES ('313', '1072', '172.28.12.64', 'mcu', '50000', 'B003', 'short', '炒锅点检', '点检状态', '4098', '1');
INSERT INTO `gw_ioinfo` VALUES ('314', '1081', '172.28.12.72', 'mcu', '50000', 'B003', 'short', '炒锅点检', '点检状态', '4098', '1');
INSERT INTO `gw_ioinfo` VALUES ('315', '1082', '172.28.12.74', 'mcu', '50000', 'B003', 'short', '炒锅点检', '点检状态', '4098', '1');
INSERT INTO `gw_ioinfo` VALUES ('316', '1091', '172.28.12.82', 'mcu', '50000', 'B003', 'short', '炒锅点检', '点检状态', '4098', '1');
INSERT INTO `gw_ioinfo` VALUES ('317', '1092', '172.28.12.84', 'mcu', '50000', 'B003', 'short', '炒锅点检', '点检状态', '4098', '1');
INSERT INTO `gw_ioinfo` VALUES ('318', '1', '172.28.11.2', 'mc', '8000', 'D1911', 'short', '火锅物流线', '点检状态', '4865', '1');
INSERT INTO `gw_ioinfo` VALUES ('400', '6001', '172.28.12.100', 'mc', '8000', 'D2801', 'short', '左煲饭点检', '点检状态', '6145', '1');
INSERT INTO `gw_ioinfo` VALUES ('401', '6002', '172.28.12.100', 'mc', '8000', 'D2806', 'short', '右煲饭点检', '点检状态', '6145', '1');
INSERT INTO `gw_ioinfo` VALUES ('402', '6721067917451984896', '172.28.10.121', 'mc', '8000', 'D3031', 'short', '一代粉面', '点检状态', '750', '1');
INSERT INTO `gw_ioinfo` VALUES ('403', '5821300000000000152_1', '172.28.10.10', 'mc', '8001', 'D4441', 'short', '蛋糕机', '点检状态', '721', '1');
INSERT INTO `gw_ioinfo` VALUES ('404', '5821300000000000152_2', '172.28.10.2', 'mc', '8001', 'D1021', 'short', '奶茶机', '点检状态', '721', '1');
INSERT INTO `gw_ioinfo` VALUES ('405', '2603', '172.28.12.109', 'mc', '8003', 'D3031', 'short', '料盒', '点检状态', '4355', '1');
INSERT INTO `gw_ioinfo` VALUES ('406', '4202', '172.28.12.115', 'mc', '8000', 'D3021', 'short', '人工上菜口', '点检状态', '5122', '1');
INSERT INTO `gw_ioinfo` VALUES ('407', '2601', '172.28.12.107', 'mc', '8003', 'D3031', 'short', '冷库点检', '点检状态', '4355', '1');
INSERT INTO `gw_ioinfo` VALUES ('408', '2602', '172.28.12.107', 'mc', '8003', 'D3041', 'short', '冷库点检', '点检状态', '4355', '1');
