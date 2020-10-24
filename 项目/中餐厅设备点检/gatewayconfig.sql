/*
Navicat MySQL Data Transfer

Source Server         : 10.187.35.24_3306
Source Server Version : 50548
Source Host           : 127.0.0.1:3306
Source Database       : gatewayconfig

Target Server Type    : MYSQL
Target Server Version : 50548
File Encoding         : 65001

Date: 2020-10-22 11:09:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for addressconfig
-- ----------------------------
DROP TABLE IF EXISTS `addressconfig`;
CREATE TABLE `addressconfig` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(255) DEFAULT NULL,
  `port` int(11) DEFAULT NULL,
  `protocal` varchar(255) DEFAULT NULL,
  `dataAddr` varchar(255) DEFAULT NULL,
  `dataModel` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `parentName` varchar(255) DEFAULT NULL,
  `estimateName` varchar(255) DEFAULT NULL,
  `deviceId` varchar(255) DEFAULT NULL,
  `massge` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1145 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of addressconfig
-- ----------------------------
INSERT INTO `addressconfig` VALUES ('99', '172.28.12.6', '8000', 'mc', 'D3010', 'short', '1', '2', '上菜口', '点检', '4001', 'D3011');
INSERT INTO `addressconfig` VALUES ('100', '172.28.12.6', '8000', 'mc', 'D3020', 'short', '1', '2', '上菜口', '点检', '4002', 'D3021');
INSERT INTO `addressconfig` VALUES ('101', '172.28.12.6', '8000', 'mc', 'D3011', 'short', '1', '1', '上菜口', '点检状态', '4001', '');
INSERT INTO `addressconfig` VALUES ('102', '172.28.12.6', '8000', 'mc', 'D3021', 'short', '1', '1', '上菜口', '点检状态', '4002', '');
INSERT INTO `addressconfig` VALUES ('103', '172.28.12.26', '8000', 'mc', 'D3010', 'short', '1', '2', '上菜口', '点检', '4003', 'D3011');
INSERT INTO `addressconfig` VALUES ('104', '172.28.12.26', '8000', 'mc', 'D3020', 'short', '1', '2', '上菜口', '点检', '4004', 'D3021');
INSERT INTO `addressconfig` VALUES ('105', '172.28.12.26', '8000', 'mc', 'D3011', 'short', '1', '1', '上菜口', '点检状态', '4003', '');
INSERT INTO `addressconfig` VALUES ('106', '172.28.12.26', '8000', 'mc', 'D3021', 'short', '1', '1', '上菜口', '点检状态', '4004', '');
INSERT INTO `addressconfig` VALUES ('107', '172.28.12.46', '8000', 'mc', 'D3010', 'short', '1', '2', '上菜口', '点检', '4005', 'D3011');
INSERT INTO `addressconfig` VALUES ('108', '172.28.12.46', '8000', 'mc', 'D3020', 'short', '1', '2', '上菜口', '点检', '4006', 'D3021');
INSERT INTO `addressconfig` VALUES ('109', '172.28.12.46', '8000', 'mc', 'D3011', 'short', '1', '1', '上菜口', '点检状态', '4006', '');
INSERT INTO `addressconfig` VALUES ('110', '172.28.12.46', '8000', 'mc', 'D3021', 'short', '1', '1', '上菜口', '点检状态', '4004', '');
INSERT INTO `addressconfig` VALUES ('111', '172.28.12.66', '8000', 'mc', 'D3010', 'short', '1', '2', '上菜口', '点检', '4007', 'D3011');
INSERT INTO `addressconfig` VALUES ('112', '172.28.12.66', '8000', 'mc', 'D3020', 'short', '1', '2', '上菜口', '点检', '4008', 'D3021');
INSERT INTO `addressconfig` VALUES ('113', '172.28.12.66', '8000', 'mc', 'D3011', 'short', '1', '1', '上菜口', '点检状态', '4007', '');
INSERT INTO `addressconfig` VALUES ('114', '172.28.12.66', '8000', 'mc', 'D3021', 'short', '1', '1', '上菜口', '点检状态', '4008', '');
INSERT INTO `addressconfig` VALUES ('115', '172.28.12.86', '8000', 'mc', 'D3010', 'short', '1', '2', '上菜口', '点检', '4009', 'D3011');
INSERT INTO `addressconfig` VALUES ('116', '172.28.12.86', '8000', 'mc', 'D3020', 'short', '1', '2', '上菜口', '点检', '4010', 'D3021');
INSERT INTO `addressconfig` VALUES ('117', '172.28.12.86', '8000', 'mc', 'D3011', 'short', '1', '1', '上菜口', '点检状态', '4009', '');
INSERT INTO `addressconfig` VALUES ('118', '172.28.12.86', '8000', 'mc', 'D3021', 'short', '1', '1', '上菜口', '点检状态', '4010', '');
INSERT INTO `addressconfig` VALUES ('119', '172.28.12.103', '8000', 'mc', 'D3010', 'short', '1', '2', '上菜口', '点检', '4601', 'D3011');
INSERT INTO `addressconfig` VALUES ('120', '172.28.12.103', '8000', 'mc', 'D3011', 'short', '1', '1', '上菜口', '点检状态', '4601', '');
INSERT INTO `addressconfig` VALUES ('121', '172.28.12.105', '8000', 'mc', 'D3010', 'short', '1', '2', '上菜口', '点检', '4602', 'D3011');
INSERT INTO `addressconfig` VALUES ('122', '172.28.12.105', '8000', 'mc', 'D3011', 'short', '1', '1', '上菜口', '点检状态', '4602', '');
INSERT INTO `addressconfig` VALUES ('123', '172.28.12.115', '8000', 'mc', 'D3010', 'short', '1', '2', '上菜口', '点检', '4201', 'D3011');
INSERT INTO `addressconfig` VALUES ('124', '172.28.12.115', '8000', 'mc', 'D3011', 'short', '1', '1', '上菜口', '点检状态', '4201', '');
INSERT INTO `addressconfig` VALUES ('125', '172.28.12.119', '8000', 'mc', 'D3010', 'short', '1', '2', '上菜口', '点检', '4203', 'D3011');
INSERT INTO `addressconfig` VALUES ('126', '172.28.12.119', '8000', 'mc', 'D3011', 'short', '1', '1', '上菜口', '点检状态', '4203', '');
INSERT INTO `addressconfig` VALUES ('200', '172.28.12.6', '8000', 'mc', 'D2050-0', 'bit', '1', '1', '上菜口', '电箱急停已按下', '4001', '');
INSERT INTO `addressconfig` VALUES ('201', '172.28.12.6', '8000', 'mc', 'D2050-1', 'bit', '1', '1', '上菜口', '拨盘电机拨菜超时报警', '4001', '');
INSERT INTO `addressconfig` VALUES ('202', '172.28.12.6', '8000', 'mc', 'D2050-2', 'bit', '1', '1', '上菜口', '拨盘电机返回超时报警', '4001', '');
INSERT INTO `addressconfig` VALUES ('203', '172.28.12.6', '8000', 'mc', 'D2050-3', 'bit', '1', '1', '上菜口', '步进电机报警', '4001', '');
INSERT INTO `addressconfig` VALUES ('204', '172.28.12.6', '8000', 'mc', 'D2050-4', 'bit', '1', '1', '上菜口', '顶部缺盘感应报警', '4001', '');
INSERT INTO `addressconfig` VALUES ('205', '172.28.12.6', '8000', 'mc', 'D2050-5', 'bit', '1', '1', '上菜口', '底部缺盘感应报警', '4001', '');
INSERT INTO `addressconfig` VALUES ('206', '172.28.12.6', '8000', 'mc', 'D2050-6', 'bit', '1', '1', '上菜口', '锅下MODBUS RTU读取通信异常', '4001', '');
INSERT INTO `addressconfig` VALUES ('207', '172.28.12.6', '8000', 'mc', 'D2050-7', 'bit', '1', '1', '上菜口', '锅上MODBUS RTU读取通信异常', '4001', '');
INSERT INTO `addressconfig` VALUES ('208', '172.28.12.6', '8000', 'mc', 'D2050-8', 'bit', '1', '1', '上菜口', '锅下MODBUS RTU写入通信异常', '4001', '');
INSERT INTO `addressconfig` VALUES ('209', '172.28.12.6', '8000', 'mc', 'D2050-9', 'bit', '1', '1', '上菜口', '锅上MODBUS RTU写入通信异常', '4001', '');
INSERT INTO `addressconfig` VALUES ('210', '172.28.12.6', '8000', 'mc', 'D2050-10', 'bit', '1', '1', '上菜口', '主站发生重试', '4001', '');
INSERT INTO `addressconfig` VALUES ('211', '172.28.12.6', '8000', 'mc', 'D2050-11', 'bit', '1', '1', '上菜口', '主站发生超时', '4001', '');
INSERT INTO `addressconfig` VALUES ('212', '172.28.12.6', '8000', 'mc', 'D2050-12', 'bit', '1', '1', '上菜口', '炒锅下急停已按下', '4001', '');
INSERT INTO `addressconfig` VALUES ('213', '172.28.12.6', '8000', 'mc', 'D2050-13', 'bit', '1', '1', '上菜口', '炒锅下缺盘报警', '4001', '');
INSERT INTO `addressconfig` VALUES ('214', '172.28.12.6', '8000', 'mc', 'D2050-14', 'bit', '1', '1', '上菜口', '炒锅上急停已按下', '4001', '');
INSERT INTO `addressconfig` VALUES ('215', '172.28.12.6', '8000', 'mc', 'D2050-15', 'bit', '1', '1', '上菜口', '炒锅上缺盘报警', '4001', '');
INSERT INTO `addressconfig` VALUES ('216', '172.28.12.6', '8000', 'mc', 'D2050-0', 'bit', '1', '1', '上菜口', '炒锅下做菜失败', '4001', '');
INSERT INTO `addressconfig` VALUES ('217', '172.28.12.6', '8000', 'mc', 'D2050-1', 'bit', '1', '1', '上菜口', '炒锅上做菜失败', '4001', '');
INSERT INTO `addressconfig` VALUES ('218', '172.28.12.6', '8000', 'mc', 'D2050-2', 'bit', '1', '1', '上菜口', '触摸屏小急停已按下', '4001', '');
INSERT INTO `addressconfig` VALUES ('219', '172.28.12.6', '8000', 'mc', 'D2050-3', 'bit', '1', '1', '上菜口', '上菜口二层缺盘报警', '4001', '');
INSERT INTO `addressconfig` VALUES ('220', '172.28.12.6', '8000', 'mc', 'D2050-4', 'bit', '1', '1', '上菜口', '上菜口二层电机正转超时', '4001', '');
INSERT INTO `addressconfig` VALUES ('221', '172.28.12.6', '8000', 'mc', 'D2050-5', 'bit', '1', '1', '上菜口', '上菜口二层电机反转超时', '4001', '');
INSERT INTO `addressconfig` VALUES ('222', '172.28.12.6', '8000', 'mc', 'D2050-6', 'bit', '1', '1', '上菜口', '启动锅下超时', '4001', '');
INSERT INTO `addressconfig` VALUES ('223', '172.28.12.6', '8000', 'mc', 'D2050-7', 'bit', '1', '1', '上菜口', '启动锅上超时', '4001', '');
INSERT INTO `addressconfig` VALUES ('224', '172.28.12.6', '8000', 'mc', 'D2050-8', 'bit', '1', '1', '上菜口', '上菜口绳子运动检测超时', '4001', '');
INSERT INTO `addressconfig` VALUES ('225', '172.28.12.6', '8000', 'mc', 'D2050-9', 'bit', '1', '1', '上菜口', '步进电机上升极限位', '4001', '');
INSERT INTO `addressconfig` VALUES ('226', '172.28.12.6', '8000', 'mc', 'D2050-10', 'bit', '1', '1', '上菜口', '步进电机下降极限位', '4001', '');
INSERT INTO `addressconfig` VALUES ('227', '172.28.12.6', '8000', 'mc', 'D2050-11', 'bit', '1', '1', '上菜口', '二层到位感应没有感应到报警', '4001', '');
INSERT INTO `addressconfig` VALUES ('228', '172.28.12.6', '8000', 'mc', 'D2050-12', 'bit', '1', '1', '上菜口', 'CC-LINK模块故障报警SW80/81', '4001', '');
INSERT INTO `addressconfig` VALUES ('229', '172.28.12.6', '8000', 'mc', 'D2050-13', 'bit', '1', '1', '上菜口', 'CC-LINK模块故障报警SB0080', '4001', '');
INSERT INTO `addressconfig` VALUES ('300', '172.28.12.6', '8000', 'mc', 'x0', 'bit', '1', '1', '上菜口', '1#急停', '4001', '');
INSERT INTO `addressconfig` VALUES ('301', '172.28.12.6', '8000', 'mc', 'x1', 'bit', '1', '1', '上菜口', '1#上菜口底部行程开关（原点）', '4001', '');
INSERT INTO `addressconfig` VALUES ('302', '172.28.12.6', '8000', 'mc', 'x4', 'bit', '1', '1', '上菜口', '1#顶部绳子编码器检测感应', '4001', '');
INSERT INTO `addressconfig` VALUES ('303', '172.28.12.6', '8000', 'mc', 'x5', 'bit', '1', '1', '上菜口', '2#顶部绳子编码器检测感应', '4002', '');
INSERT INTO `addressconfig` VALUES ('304', '172.28.12.6', '8000', 'mc', 'x6', 'bit', '1', '1', '上菜口', '1#推盘步进报警信号', '4001', '');
INSERT INTO `addressconfig` VALUES ('305', '172.28.12.6', '8000', 'mc', 'x7', 'bit', '1', '1', '上菜口', '1#升降步进电机报警信号', '4001', '');
INSERT INTO `addressconfig` VALUES ('306', '172.28.12.6', '8000', 'mc', 'x10', 'bit', '1', '1', '上菜口', '1#启动按钮', '4001', '');
INSERT INTO `addressconfig` VALUES ('307', '172.28.12.6', '8000', 'mc', 'x11', 'bit', '1', '1', '上菜口', '1#触摸屏小急停', '4001', '');
INSERT INTO `addressconfig` VALUES ('308', '172.28.12.6', '8000', 'mc', 'x12', 'bit', '1', '1', '上菜口', '2#触摸屏小急停', '4002', '');
INSERT INTO `addressconfig` VALUES ('309', '172.28.12.6', '8000', 'mc', 'x13', 'bit', '1', '1', '上菜口', '2#推盘步进报警信号', '4002', '');
INSERT INTO `addressconfig` VALUES ('310', '172.28.12.6', '8000', 'mc', 'x14', 'bit', '1', '1', '上菜口', '2#升降步进电机报警信号', '4002', '');
INSERT INTO `addressconfig` VALUES ('311', '172.28.12.6', '8000', 'mc', 'x15', 'bit', '1', '1', '上菜口', '2#启动按钮', '4001', '');
INSERT INTO `addressconfig` VALUES ('312', '172.28.12.6', '8000', 'mc', 'x16', 'bit', '1', '1', '上菜口', '2#急停', '4002', '');
INSERT INTO `addressconfig` VALUES ('313', '172.28.12.6', '8000', 'mc', 'x17', 'bit', '1', '1', '上菜口', '2#上菜口底部行程开关（原点）', '4002', '');
INSERT INTO `addressconfig` VALUES ('314', '172.28.12.6', '8000', 'mc', 'x200', 'bit', '1', '1', '上菜口', '1#上菜口底部有盘感应', '4001', '');
INSERT INTO `addressconfig` VALUES ('315', '172.28.12.6', '8000', 'mc', 'x201', 'bit', '1', '1', '上菜口', '1#上菜口顶部行程开关', '4001', '');
INSERT INTO `addressconfig` VALUES ('316', '172.28.12.6', '8000', 'mc', 'x202', 'bit', '1', '1', '上菜口', '1#上菜口顶部有盘感应', '4001', '');
INSERT INTO `addressconfig` VALUES ('317', '172.28.12.6', '8000', 'mc', 'x203', 'bit', '1', '1', '上菜口', '1#上菜口顶部拨菜机构原点感应', '4001', '');
INSERT INTO `addressconfig` VALUES ('318', '172.28.12.6', '8000', 'mc', 'x204', 'bit', '1', '1', '上菜口', '1#上菜口顶部拨菜机构到位感应', '4001', '');
INSERT INTO `addressconfig` VALUES ('319', '172.28.12.6', '8000', 'mc', 'x206', 'bit', '1', '1', '上菜口', '1#二层直流电机正转到位', '4001', '');
INSERT INTO `addressconfig` VALUES ('320', '172.28.12.6', '8000', 'mc', 'x207', 'bit', '1', '1', '上菜口', '1#二层直流电机反转原位', '4001', '');
INSERT INTO `addressconfig` VALUES ('321', '172.28.12.6', '8000', 'mc', 'x211', 'bit', '1', '1', '上菜口', '1#二层有盘感应', '4001', '');
INSERT INTO `addressconfig` VALUES ('322', '172.28.12.6', '8000', 'mc', 'x212', 'bit', '1', '1', '上菜口', '1#上菜口顶部拨菜机构蒸笼到位感应', '4001', '');
INSERT INTO `addressconfig` VALUES ('323', '172.28.12.6', '8000', 'mc', 'x214', 'bit', '1', '1', '上菜口', '1#下降限位', '4001', '');
INSERT INTO `addressconfig` VALUES ('324', '172.28.12.6', '8000', 'mc', 'x215', 'bit', '1', '1', '上菜口', '1#上升限位', '4001', '');
INSERT INTO `addressconfig` VALUES ('325', '172.28.12.6', '8000', 'mc', 'x216', 'bit', '1', '1', '上菜口', '1#二层行程开关', '4001', '');
INSERT INTO `addressconfig` VALUES ('326', '172.28.12.6', '8000', 'mc', 'x240', 'bit', '1', '1', '上菜口', '2#上菜口底部有盘感应', '4002', '');
INSERT INTO `addressconfig` VALUES ('327', '172.28.12.6', '8000', 'mc', 'x241', 'bit', '1', '1', '上菜口', '2#上菜口顶部行程开关', '4002', '');
INSERT INTO `addressconfig` VALUES ('328', '172.28.12.6', '8000', 'mc', 'x242', 'bit', '1', '1', '上菜口', '2#上菜口顶部有盘感应', '4002', '');
INSERT INTO `addressconfig` VALUES ('329', '172.28.12.6', '8000', 'mc', 'x243', 'bit', '1', '1', '上菜口', '2#上菜口顶部拨菜机构原点感应', '4002', '');
INSERT INTO `addressconfig` VALUES ('330', '172.28.12.6', '8000', 'mc', 'x244', 'bit', '1', '1', '上菜口', '2#上菜口顶部拨菜机构到位感应', '4002', '');
INSERT INTO `addressconfig` VALUES ('331', '172.28.12.6', '8000', 'mc', 'x246', 'bit', '1', '1', '上菜口', '2#二层直流电机正转到位', '4002', '');
INSERT INTO `addressconfig` VALUES ('332', '172.28.12.6', '8000', 'mc', 'x247', 'bit', '1', '1', '上菜口', '2#二层直流电机反转原位', '4002', '');
INSERT INTO `addressconfig` VALUES ('333', '172.28.12.6', '8000', 'mc', 'x251', 'bit', '1', '1', '上菜口', '2#二层有盘感应', '4002', '');
INSERT INTO `addressconfig` VALUES ('334', '172.28.12.6', '8000', 'mc', 'x252', 'bit', '1', '1', '上菜口', '2#上菜口顶部拨菜机构蒸笼到位感应', '4002', '');
INSERT INTO `addressconfig` VALUES ('335', '172.28.12.6', '8000', 'mc', 'x254', 'bit', '1', '1', '上菜口', '2#下降限位', '4002', '');
INSERT INTO `addressconfig` VALUES ('336', '172.28.12.6', '8000', 'mc', 'x255', 'bit', '1', '1', '上菜口', '2#上升限位', '4002', '');
INSERT INTO `addressconfig` VALUES ('337', '172.28.12.6', '8000', 'mc', 'x256', 'bit', '1', '1', '上菜口', '2#二层行程开关', '4002', '');
INSERT INTO `addressconfig` VALUES ('338', '172.28.12.6', '8000', 'mc', 'y0', 'bit', '1', '1', '上菜口', '1#升降步进脉冲', '4001', '');
INSERT INTO `addressconfig` VALUES ('339', '172.28.12.6', '8000', 'mc', 'y1', 'bit', '1', '1', '上菜口', '2#升降步进脉冲', '4002', '');
INSERT INTO `addressconfig` VALUES ('340', '172.28.12.6', '8000', 'mc', 'y2', 'bit', '1', '1', '上菜口', '1#推盘步进脉冲', '4001', '');
INSERT INTO `addressconfig` VALUES ('341', '172.28.12.6', '8000', 'mc', 'y3', 'bit', '1', '1', '上菜口', '2#推盘步进脉冲', '4001', '');
INSERT INTO `addressconfig` VALUES ('342', '172.28.12.6', '8000', 'mc', 'y4', 'bit', '1', '1', '上菜口', '1#升降步进方向', '4001', '');
INSERT INTO `addressconfig` VALUES ('343', '172.28.12.6', '8000', 'mc', 'y6', 'bit', '1', '1', '上菜口', '1#推盘步进方向', '4001', '');
INSERT INTO `addressconfig` VALUES ('344', '172.28.12.6', '8000', 'mc', 'y7', 'bit', '1', '1', '上菜口', '2#推盘步进方向', '4002', '');
INSERT INTO `addressconfig` VALUES ('345', '172.28.12.6', '8000', 'mc', 'y10', 'bit', '1', '1', '上菜口', '1#升降步进刹车', '4001', '');
INSERT INTO `addressconfig` VALUES ('346', '172.28.12.6', '8000', 'mc', 'y11', 'bit', '1', '1', '上菜口', '2#升降步进刹车', '4002', '');
INSERT INTO `addressconfig` VALUES ('347', '172.28.12.6', '8000', 'mc', 'y16', 'bit', '1', '1', '上菜口', '2#升降步进方向', '4002', '');
INSERT INTO `addressconfig` VALUES ('348', '172.28.12.6', '8000', 'mc', 'y223', 'bit', '1', '1', '上菜口', '1#上菜口顶部电磁铁', '4001', '');
INSERT INTO `addressconfig` VALUES ('349', '172.28.12.6', '8000', 'mc', 'y224', 'bit', '1', '1', '上菜口', '1#上菜口底部电磁铁', '4001', '');
INSERT INTO `addressconfig` VALUES ('350', '172.28.12.6', '8000', 'mc', 'y225', 'bit', '1', '1', '上菜口', '1#蜂鸣器', '4001', '');
INSERT INTO `addressconfig` VALUES ('351', '172.28.12.6', '8000', 'mc', 'y226', 'bit', '1', '1', '上菜口', '1#二层直流电机正转', '4001', '');
INSERT INTO `addressconfig` VALUES ('352', '172.28.12.6', '8000', 'mc', 'y227', 'bit', '1', '1', '上菜口', '1#二层直流电机反转', '4001', '');
INSERT INTO `addressconfig` VALUES ('353', '172.28.12.6', '8000', 'mc', 'y263', 'bit', '1', '1', '上菜口', '2#上菜口顶部电磁铁', '4002', '');
INSERT INTO `addressconfig` VALUES ('354', '172.28.12.6', '8000', 'mc', 'y264', 'bit', '1', '1', '上菜口', '2#上菜口底部电磁铁', '4001', '');
INSERT INTO `addressconfig` VALUES ('355', '172.28.12.6', '8000', 'mc', 'y265', 'bit', '1', '1', '上菜口', '2#蜂鸣器', '4002', '');
INSERT INTO `addressconfig` VALUES ('356', '172.28.12.6', '8000', 'mc', 'y266', 'bit', '1', '1', '上菜口', '2#二层直流电机正转', '4002', '');
INSERT INTO `addressconfig` VALUES ('357', '172.28.12.6', '8000', 'mc', 'y267', 'bit', '1', '1', '上菜口', '2#二层直流电机反转', '4002', '');
INSERT INTO `addressconfig` VALUES ('400', '172.28.12.26', '8000', 'mc', 'x0', 'bit', '1', '1', '上菜口', '1#急停', '4003', '');
INSERT INTO `addressconfig` VALUES ('401', '172.28.12.26', '8000', 'mc', 'x1', 'bit', '1', '1', '上菜口', '1#上菜口底部行程开关（原点）', '4003', '');
INSERT INTO `addressconfig` VALUES ('402', '172.28.12.26', '8000', 'mc', 'x4', 'bit', '1', '1', '上菜口', '1#顶部绳子编码器检测感应', '4003', '');
INSERT INTO `addressconfig` VALUES ('403', '172.28.12.26', '8000', 'mc', 'x5', 'bit', '1', '1', '上菜口', '2#顶部绳子编码器检测感应', '4004', '');
INSERT INTO `addressconfig` VALUES ('404', '172.28.12.26', '8000', 'mc', 'x6', 'bit', '1', '1', '上菜口', '1#推盘步进报警信号', '4003', '');
INSERT INTO `addressconfig` VALUES ('405', '172.28.12.26', '8000', 'mc', 'x7', 'bit', '1', '1', '上菜口', '1#升降步进电机报警信号', '4003', '');
INSERT INTO `addressconfig` VALUES ('406', '172.28.12.26', '8000', 'mc', 'x10', 'bit', '1', '1', '上菜口', '1#启动按钮', '4003', '');
INSERT INTO `addressconfig` VALUES ('407', '172.28.12.26', '8000', 'mc', 'x11', 'bit', '1', '1', '上菜口', '1#触摸屏小急停', '4003', '');
INSERT INTO `addressconfig` VALUES ('408', '172.28.12.26', '8000', 'mc', 'x12', 'bit', '1', '1', '上菜口', '2#触摸屏小急停', '4004', '');
INSERT INTO `addressconfig` VALUES ('409', '172.28.12.26', '8000', 'mc', 'x13', 'bit', '1', '1', '上菜口', '2#推盘步进报警信号', '4004', '');
INSERT INTO `addressconfig` VALUES ('410', '172.28.12.26', '8000', 'mc', 'x14', 'bit', '1', '1', '上菜口', '2#升降步进电机报警信号', '4004', '');
INSERT INTO `addressconfig` VALUES ('411', '172.28.12.26', '8000', 'mc', 'x15', 'bit', '1', '1', '上菜口', '2#启动按钮', '4003', '');
INSERT INTO `addressconfig` VALUES ('412', '172.28.12.26', '8000', 'mc', 'x16', 'bit', '1', '1', '上菜口', '2#急停', '4004', '');
INSERT INTO `addressconfig` VALUES ('413', '172.28.12.26', '8000', 'mc', 'x17', 'bit', '1', '1', '上菜口', '2#上菜口底部行程开关（原点）', '4004', '');
INSERT INTO `addressconfig` VALUES ('414', '172.28.12.26', '8000', 'mc', 'x200', 'bit', '1', '1', '上菜口', '1#上菜口底部有盘感应', '4003', '');
INSERT INTO `addressconfig` VALUES ('415', '172.28.12.26', '8000', 'mc', 'x201', 'bit', '1', '1', '上菜口', '1#上菜口顶部行程开关', '4003', '');
INSERT INTO `addressconfig` VALUES ('416', '172.28.12.26', '8000', 'mc', 'x202', 'bit', '1', '1', '上菜口', '1#上菜口顶部有盘感应', '4003', '');
INSERT INTO `addressconfig` VALUES ('417', '172.28.12.26', '8000', 'mc', 'x203', 'bit', '1', '1', '上菜口', '1#上菜口顶部拨菜机构原点感应', '4003', '');
INSERT INTO `addressconfig` VALUES ('418', '172.28.12.26', '8000', 'mc', 'x204', 'bit', '1', '1', '上菜口', '1#上菜口顶部拨菜机构到位感应', '4003', '');
INSERT INTO `addressconfig` VALUES ('419', '172.28.12.26', '8000', 'mc', 'x206', 'bit', '1', '1', '上菜口', '1#二层直流电机正转到位', '4003', '');
INSERT INTO `addressconfig` VALUES ('420', '172.28.12.26', '8000', 'mc', 'x207', 'bit', '1', '1', '上菜口', '1#二层直流电机反转原位', '4003', '');
INSERT INTO `addressconfig` VALUES ('421', '172.28.12.26', '8000', 'mc', 'x211', 'bit', '1', '1', '上菜口', '1#二层有盘感应', '4003', '');
INSERT INTO `addressconfig` VALUES ('422', '172.28.12.26', '8000', 'mc', 'x212', 'bit', '1', '1', '上菜口', '1#上菜口顶部拨菜机构蒸笼到位感应', '4003', '');
INSERT INTO `addressconfig` VALUES ('423', '172.28.12.26', '8000', 'mc', 'x214', 'bit', '1', '1', '上菜口', '1#下降限位', '4003', '');
INSERT INTO `addressconfig` VALUES ('424', '172.28.12.26', '8000', 'mc', 'x215', 'bit', '1', '1', '上菜口', '1#上升限位', '4003', '');
INSERT INTO `addressconfig` VALUES ('425', '172.28.12.26', '8000', 'mc', 'x216', 'bit', '1', '1', '上菜口', '1#二层行程开关', '4003', '');
INSERT INTO `addressconfig` VALUES ('426', '172.28.12.26', '8000', 'mc', 'x240', 'bit', '1', '1', '上菜口', '2#上菜口底部有盘感应', '4004', '');
INSERT INTO `addressconfig` VALUES ('427', '172.28.12.26', '8000', 'mc', 'x241', 'bit', '1', '1', '上菜口', '2#上菜口顶部行程开关', '4004', '');
INSERT INTO `addressconfig` VALUES ('428', '172.28.12.26', '8000', 'mc', 'x242', 'bit', '1', '1', '上菜口', '2#上菜口顶部有盘感应', '4004', '');
INSERT INTO `addressconfig` VALUES ('429', '172.28.12.26', '8000', 'mc', 'x243', 'bit', '1', '1', '上菜口', '2#上菜口顶部拨菜机构原点感应', '4004', '');
INSERT INTO `addressconfig` VALUES ('430', '172.28.12.26', '8000', 'mc', 'x244', 'bit', '1', '1', '上菜口', '2#上菜口顶部拨菜机构到位感应', '4004', '');
INSERT INTO `addressconfig` VALUES ('431', '172.28.12.26', '8000', 'mc', 'x246', 'bit', '1', '1', '上菜口', '2#二层直流电机正转到位', '4004', '');
INSERT INTO `addressconfig` VALUES ('432', '172.28.12.26', '8000', 'mc', 'x247', 'bit', '1', '1', '上菜口', '2#二层直流电机反转原位', '4004', '');
INSERT INTO `addressconfig` VALUES ('433', '172.28.12.26', '8000', 'mc', 'x251', 'bit', '1', '1', '上菜口', '2#二层有盘感应', '4004', '');
INSERT INTO `addressconfig` VALUES ('434', '172.28.12.26', '8000', 'mc', 'x252', 'bit', '1', '1', '上菜口', '2#上菜口顶部拨菜机构蒸笼到位感应', '4004', '');
INSERT INTO `addressconfig` VALUES ('435', '172.28.12.26', '8000', 'mc', 'x254', 'bit', '1', '1', '上菜口', '2#下降限位', '4004', '');
INSERT INTO `addressconfig` VALUES ('436', '172.28.12.26', '8000', 'mc', 'x255', 'bit', '1', '1', '上菜口', '2#上升限位', '4004', '');
INSERT INTO `addressconfig` VALUES ('437', '172.28.12.26', '8000', 'mc', 'x256', 'bit', '1', '1', '上菜口', '2#二层行程开关', '4004', '');
INSERT INTO `addressconfig` VALUES ('438', '172.28.12.26', '8000', 'mc', 'y0', 'bit', '1', '1', '上菜口', '1#升降步进脉冲', '4003', '');
INSERT INTO `addressconfig` VALUES ('439', '172.28.12.26', '8000', 'mc', 'y1', 'bit', '1', '1', '上菜口', '2#升降步进脉冲', '4004', '');
INSERT INTO `addressconfig` VALUES ('440', '172.28.12.26', '8000', 'mc', 'y2', 'bit', '1', '1', '上菜口', '1#推盘步进脉冲', '4003', '');
INSERT INTO `addressconfig` VALUES ('441', '172.28.12.26', '8000', 'mc', 'y3', 'bit', '1', '1', '上菜口', '2#推盘步进脉冲', '4003', '');
INSERT INTO `addressconfig` VALUES ('442', '172.28.12.26', '8000', 'mc', 'y4', 'bit', '1', '1', '上菜口', '1#升降步进方向', '4003', '');
INSERT INTO `addressconfig` VALUES ('443', '172.28.12.26', '8000', 'mc', 'y6', 'bit', '1', '1', '上菜口', '1#推盘步进方向', '4003', '');
INSERT INTO `addressconfig` VALUES ('444', '172.28.12.26', '8000', 'mc', 'y7', 'bit', '1', '1', '上菜口', '2#推盘步进方向', '4004', '');
INSERT INTO `addressconfig` VALUES ('445', '172.28.12.26', '8000', 'mc', 'y10', 'bit', '1', '1', '上菜口', '1#升降步进刹车', '4003', '');
INSERT INTO `addressconfig` VALUES ('446', '172.28.12.26', '8000', 'mc', 'y11', 'bit', '1', '1', '上菜口', '2#升降步进刹车', '4004', '');
INSERT INTO `addressconfig` VALUES ('447', '172.28.12.26', '8000', 'mc', 'y16', 'bit', '1', '1', '上菜口', '2#升降步进方向', '4004', '');
INSERT INTO `addressconfig` VALUES ('448', '172.28.12.26', '8000', 'mc', 'y223', 'bit', '1', '1', '上菜口', '1#上菜口顶部电磁铁', '4003', '');
INSERT INTO `addressconfig` VALUES ('449', '172.28.12.26', '8000', 'mc', 'y224', 'bit', '1', '1', '上菜口', '1#上菜口底部电磁铁', '4003', '');
INSERT INTO `addressconfig` VALUES ('450', '172.28.12.26', '8000', 'mc', 'y225', 'bit', '1', '1', '上菜口', '1#蜂鸣器', '4003', '');
INSERT INTO `addressconfig` VALUES ('451', '172.28.12.26', '8000', 'mc', 'y226', 'bit', '1', '1', '上菜口', '1#二层直流电机正转', '4003', '');
INSERT INTO `addressconfig` VALUES ('452', '172.28.12.26', '8000', 'mc', 'y227', 'bit', '1', '1', '上菜口', '1#二层直流电机反转', '4003', '');
INSERT INTO `addressconfig` VALUES ('453', '172.28.12.26', '8000', 'mc', 'y263', 'bit', '1', '1', '上菜口', '2#上菜口顶部电磁铁', '4004', '');
INSERT INTO `addressconfig` VALUES ('454', '172.28.12.26', '8000', 'mc', 'y264', 'bit', '1', '1', '上菜口', '2#上菜口底部电磁铁', '4003', '');
INSERT INTO `addressconfig` VALUES ('455', '172.28.12.26', '8000', 'mc', 'y265', 'bit', '1', '1', '上菜口', '2#蜂鸣器', '4004', '');
INSERT INTO `addressconfig` VALUES ('456', '172.28.12.26', '8000', 'mc', 'y266', 'bit', '1', '1', '上菜口', '2#二层直流电机正转', '4004', '');
INSERT INTO `addressconfig` VALUES ('457', '172.28.12.26', '8000', 'mc', 'y267', 'bit', '1', '1', '上菜口', '2#二层直流电机反转', '4004', '');
INSERT INTO `addressconfig` VALUES ('500', '172.28.12.46', '8000', 'mc', 'x0', 'bit', '1', '1', '上菜口', '1#急停', '4005', '');
INSERT INTO `addressconfig` VALUES ('501', '172.28.12.46', '8000', 'mc', 'x1', 'bit', '1', '1', '上菜口', '1#上菜口底部行程开关（原点）', '4005', '');
INSERT INTO `addressconfig` VALUES ('502', '172.28.12.46', '8000', 'mc', 'x4', 'bit', '1', '1', '上菜口', '1#顶部绳子编码器检测感应', '4005', '');
INSERT INTO `addressconfig` VALUES ('503', '172.28.12.46', '8000', 'mc', 'x5', 'bit', '1', '1', '上菜口', '2#顶部绳子编码器检测感应', '4006', '');
INSERT INTO `addressconfig` VALUES ('504', '172.28.12.46', '8000', 'mc', 'x6', 'bit', '1', '1', '上菜口', '1#推盘步进报警信号', '4005', '');
INSERT INTO `addressconfig` VALUES ('505', '172.28.12.46', '8000', 'mc', 'x7', 'bit', '1', '1', '上菜口', '1#升降步进电机报警信号', '4005', '');
INSERT INTO `addressconfig` VALUES ('506', '172.28.12.46', '8000', 'mc', 'x10', 'bit', '1', '1', '上菜口', '1#启动按钮', '4005', '');
INSERT INTO `addressconfig` VALUES ('507', '172.28.12.46', '8000', 'mc', 'x11', 'bit', '1', '1', '上菜口', '1#触摸屏小急停', '4005', '');
INSERT INTO `addressconfig` VALUES ('508', '172.28.12.46', '8000', 'mc', 'x12', 'bit', '1', '1', '上菜口', '2#触摸屏小急停', '4006', '');
INSERT INTO `addressconfig` VALUES ('509', '172.28.12.46', '8000', 'mc', 'x13', 'bit', '1', '1', '上菜口', '2#推盘步进报警信号', '4006', '');
INSERT INTO `addressconfig` VALUES ('510', '172.28.12.46', '8000', 'mc', 'x14', 'bit', '1', '1', '上菜口', '2#升降步进电机报警信号', '4006', '');
INSERT INTO `addressconfig` VALUES ('511', '172.28.12.46', '8000', 'mc', 'x15', 'bit', '1', '1', '上菜口', '2#启动按钮', '4005', '');
INSERT INTO `addressconfig` VALUES ('512', '172.28.12.46', '8000', 'mc', 'x16', 'bit', '1', '1', '上菜口', '2#急停', '4006', '');
INSERT INTO `addressconfig` VALUES ('513', '172.28.12.46', '8000', 'mc', 'x17', 'bit', '1', '1', '上菜口', '2#上菜口底部行程开关（原点）', '4006', '');
INSERT INTO `addressconfig` VALUES ('514', '172.28.12.46', '8000', 'mc', 'x200', 'bit', '1', '1', '上菜口', '1#上菜口底部有盘感应', '4005', '');
INSERT INTO `addressconfig` VALUES ('515', '172.28.12.46', '8000', 'mc', 'x201', 'bit', '1', '1', '上菜口', '1#上菜口顶部行程开关', '4005', '');
INSERT INTO `addressconfig` VALUES ('516', '172.28.12.46', '8000', 'mc', 'x202', 'bit', '1', '1', '上菜口', '1#上菜口顶部有盘感应', '4005', '');
INSERT INTO `addressconfig` VALUES ('517', '172.28.12.46', '8000', 'mc', 'x203', 'bit', '1', '1', '上菜口', '1#上菜口顶部拨菜机构原点感应', '4005', '');
INSERT INTO `addressconfig` VALUES ('518', '172.28.12.46', '8000', 'mc', 'x204', 'bit', '1', '1', '上菜口', '1#上菜口顶部拨菜机构到位感应', '4005', '');
INSERT INTO `addressconfig` VALUES ('519', '172.28.12.46', '8000', 'mc', 'x206', 'bit', '1', '1', '上菜口', '1#二层直流电机正转到位', '4005', '');
INSERT INTO `addressconfig` VALUES ('520', '172.28.12.46', '8000', 'mc', 'x207', 'bit', '1', '1', '上菜口', '1#二层直流电机反转原位', '4005', '');
INSERT INTO `addressconfig` VALUES ('521', '172.28.12.46', '8000', 'mc', 'x211', 'bit', '1', '1', '上菜口', '1#二层有盘感应', '4005', '');
INSERT INTO `addressconfig` VALUES ('522', '172.28.12.46', '8000', 'mc', 'x212', 'bit', '1', '1', '上菜口', '1#上菜口顶部拨菜机构蒸笼到位感应', '4005', '');
INSERT INTO `addressconfig` VALUES ('523', '172.28.12.46', '8000', 'mc', 'x214', 'bit', '1', '1', '上菜口', '1#下降限位', '4005', '');
INSERT INTO `addressconfig` VALUES ('524', '172.28.12.46', '8000', 'mc', 'x215', 'bit', '1', '1', '上菜口', '1#上升限位', '4005', '');
INSERT INTO `addressconfig` VALUES ('525', '172.28.12.46', '8000', 'mc', 'x216', 'bit', '1', '1', '上菜口', '1#二层行程开关', '4005', '');
INSERT INTO `addressconfig` VALUES ('526', '172.28.12.46', '8000', 'mc', 'x240', 'bit', '1', '1', '上菜口', '2#上菜口底部有盘感应', '4006', '');
INSERT INTO `addressconfig` VALUES ('527', '172.28.12.46', '8000', 'mc', 'x241', 'bit', '1', '1', '上菜口', '2#上菜口顶部行程开关', '4006', '');
INSERT INTO `addressconfig` VALUES ('528', '172.28.12.46', '8000', 'mc', 'x242', 'bit', '1', '1', '上菜口', '2#上菜口顶部有盘感应', '4006', '');
INSERT INTO `addressconfig` VALUES ('529', '172.28.12.46', '8000', 'mc', 'x243', 'bit', '1', '1', '上菜口', '2#上菜口顶部拨菜机构原点感应', '4006', '');
INSERT INTO `addressconfig` VALUES ('530', '172.28.12.46', '8000', 'mc', 'x244', 'bit', '1', '1', '上菜口', '2#上菜口顶部拨菜机构到位感应', '4006', '');
INSERT INTO `addressconfig` VALUES ('531', '172.28.12.46', '8000', 'mc', 'x246', 'bit', '1', '1', '上菜口', '2#二层直流电机正转到位', '4006', '');
INSERT INTO `addressconfig` VALUES ('532', '172.28.12.46', '8000', 'mc', 'x247', 'bit', '1', '1', '上菜口', '2#二层直流电机反转原位', '4006', '');
INSERT INTO `addressconfig` VALUES ('533', '172.28.12.46', '8000', 'mc', 'x251', 'bit', '1', '1', '上菜口', '2#二层有盘感应', '4006', '');
INSERT INTO `addressconfig` VALUES ('534', '172.28.12.46', '8000', 'mc', 'x252', 'bit', '1', '1', '上菜口', '2#上菜口顶部拨菜机构蒸笼到位感应', '4006', '');
INSERT INTO `addressconfig` VALUES ('535', '172.28.12.46', '8000', 'mc', 'x254', 'bit', '1', '1', '上菜口', '2#下降限位', '4006', '');
INSERT INTO `addressconfig` VALUES ('536', '172.28.12.46', '8000', 'mc', 'x255', 'bit', '1', '1', '上菜口', '2#上升限位', '4006', '');
INSERT INTO `addressconfig` VALUES ('537', '172.28.12.46', '8000', 'mc', 'x256', 'bit', '1', '1', '上菜口', '2#二层行程开关', '4006', '');
INSERT INTO `addressconfig` VALUES ('538', '172.28.12.46', '8000', 'mc', 'y0', 'bit', '1', '1', '上菜口', '1#升降步进脉冲', '4005', '');
INSERT INTO `addressconfig` VALUES ('539', '172.28.12.46', '8000', 'mc', 'y1', 'bit', '1', '1', '上菜口', '2#升降步进脉冲', '4006', '');
INSERT INTO `addressconfig` VALUES ('540', '172.28.12.46', '8000', 'mc', 'y2', 'bit', '1', '1', '上菜口', '1#推盘步进脉冲', '4005', '');
INSERT INTO `addressconfig` VALUES ('541', '172.28.12.46', '8000', 'mc', 'y3', 'bit', '1', '1', '上菜口', '2#推盘步进脉冲', '4005', '');
INSERT INTO `addressconfig` VALUES ('542', '172.28.12.46', '8000', 'mc', 'y4', 'bit', '1', '1', '上菜口', '1#升降步进方向', '4005', '');
INSERT INTO `addressconfig` VALUES ('543', '172.28.12.46', '8000', 'mc', 'y6', 'bit', '1', '1', '上菜口', '1#推盘步进方向', '4005', '');
INSERT INTO `addressconfig` VALUES ('544', '172.28.12.46', '8000', 'mc', 'y7', 'bit', '1', '1', '上菜口', '2#推盘步进方向', '4006', '');
INSERT INTO `addressconfig` VALUES ('545', '172.28.12.46', '8000', 'mc', 'y10', 'bit', '1', '1', '上菜口', '1#升降步进刹车', '4005', '');
INSERT INTO `addressconfig` VALUES ('546', '172.28.12.46', '8000', 'mc', 'y11', 'bit', '1', '1', '上菜口', '2#升降步进刹车', '4006', '');
INSERT INTO `addressconfig` VALUES ('547', '172.28.12.46', '8000', 'mc', 'y16', 'bit', '1', '1', '上菜口', '2#升降步进方向', '4006', '');
INSERT INTO `addressconfig` VALUES ('548', '172.28.12.46', '8000', 'mc', 'y223', 'bit', '1', '1', '上菜口', '1#上菜口顶部电磁铁', '4005', '');
INSERT INTO `addressconfig` VALUES ('549', '172.28.12.46', '8000', 'mc', 'y224', 'bit', '1', '1', '上菜口', '1#上菜口底部电磁铁', '4005', '');
INSERT INTO `addressconfig` VALUES ('550', '172.28.12.46', '8000', 'mc', 'y225', 'bit', '1', '1', '上菜口', '1#蜂鸣器', '4005', '');
INSERT INTO `addressconfig` VALUES ('551', '172.28.12.46', '8000', 'mc', 'y226', 'bit', '1', '1', '上菜口', '1#二层直流电机正转', '4005', '');
INSERT INTO `addressconfig` VALUES ('552', '172.28.12.46', '8000', 'mc', 'y227', 'bit', '1', '1', '上菜口', '1#二层直流电机反转', '4005', '');
INSERT INTO `addressconfig` VALUES ('553', '172.28.12.46', '8000', 'mc', 'y263', 'bit', '1', '1', '上菜口', '2#上菜口顶部电磁铁', '4006', '');
INSERT INTO `addressconfig` VALUES ('554', '172.28.12.46', '8000', 'mc', 'y264', 'bit', '1', '1', '上菜口', '2#上菜口底部电磁铁', '4005', '');
INSERT INTO `addressconfig` VALUES ('555', '172.28.12.46', '8000', 'mc', 'y265', 'bit', '1', '1', '上菜口', '2#蜂鸣器', '4006', '');
INSERT INTO `addressconfig` VALUES ('556', '172.28.12.46', '8000', 'mc', 'y266', 'bit', '1', '1', '上菜口', '2#二层直流电机正转', '4006', '');
INSERT INTO `addressconfig` VALUES ('557', '172.28.12.46', '8000', 'mc', 'y267', 'bit', '1', '1', '上菜口', '2#二层直流电机反转', '4006', '');
INSERT INTO `addressconfig` VALUES ('600', '172.28.12.46', '8000', 'mc', 'x0', 'bit', '1', '1', '上菜口', '1#急停', '4007', '');
INSERT INTO `addressconfig` VALUES ('601', '172.28.12.46', '8000', 'mc', 'x1', 'bit', '1', '1', '上菜口', '1#上菜口底部行程开关（原点）', '4007', '');
INSERT INTO `addressconfig` VALUES ('602', '172.28.12.46', '8000', 'mc', 'x4', 'bit', '1', '1', '上菜口', '1#顶部绳子编码器检测感应', '4007', '');
INSERT INTO `addressconfig` VALUES ('603', '172.28.12.46', '8000', 'mc', 'x5', 'bit', '1', '1', '上菜口', '2#顶部绳子编码器检测感应', '4008', '');
INSERT INTO `addressconfig` VALUES ('604', '172.28.12.46', '8000', 'mc', 'x6', 'bit', '1', '1', '上菜口', '1#推盘步进报警信号', '4007', '');
INSERT INTO `addressconfig` VALUES ('605', '172.28.12.46', '8000', 'mc', 'x7', 'bit', '1', '1', '上菜口', '1#升降步进电机报警信号', '4007', '');
INSERT INTO `addressconfig` VALUES ('606', '172.28.12.46', '8000', 'mc', 'x10', 'bit', '1', '1', '上菜口', '1#启动按钮', '4007', '');
INSERT INTO `addressconfig` VALUES ('607', '172.28.12.46', '8000', 'mc', 'x11', 'bit', '1', '1', '上菜口', '1#触摸屏小急停', '4007', '');
INSERT INTO `addressconfig` VALUES ('608', '172.28.12.46', '8000', 'mc', 'x12', 'bit', '1', '1', '上菜口', '2#触摸屏小急停', '4008', '');
INSERT INTO `addressconfig` VALUES ('609', '172.28.12.46', '8000', 'mc', 'x13', 'bit', '1', '1', '上菜口', '2#推盘步进报警信号', '4008', '');
INSERT INTO `addressconfig` VALUES ('610', '172.28.12.46', '8000', 'mc', 'x14', 'bit', '1', '1', '上菜口', '2#升降步进电机报警信号', '4008', '');
INSERT INTO `addressconfig` VALUES ('611', '172.28.12.46', '8000', 'mc', 'x15', 'bit', '1', '1', '上菜口', '2#启动按钮', '4007', '');
INSERT INTO `addressconfig` VALUES ('612', '172.28.12.46', '8000', 'mc', 'x16', 'bit', '1', '1', '上菜口', '2#急停', '4008', '');
INSERT INTO `addressconfig` VALUES ('613', '172.28.12.46', '8000', 'mc', 'x17', 'bit', '1', '1', '上菜口', '2#上菜口底部行程开关（原点）', '4008', '');
INSERT INTO `addressconfig` VALUES ('614', '172.28.12.46', '8000', 'mc', 'x200', 'bit', '1', '1', '上菜口', '1#上菜口底部有盘感应', '4007', '');
INSERT INTO `addressconfig` VALUES ('615', '172.28.12.46', '8000', 'mc', 'x201', 'bit', '1', '1', '上菜口', '1#上菜口顶部行程开关', '4007', '');
INSERT INTO `addressconfig` VALUES ('616', '172.28.12.46', '8000', 'mc', 'x202', 'bit', '1', '1', '上菜口', '1#上菜口顶部有盘感应', '4007', '');
INSERT INTO `addressconfig` VALUES ('617', '172.28.12.46', '8000', 'mc', 'x203', 'bit', '1', '1', '上菜口', '1#上菜口顶部拨菜机构原点感应', '4007', '');
INSERT INTO `addressconfig` VALUES ('618', '172.28.12.46', '8000', 'mc', 'x204', 'bit', '1', '1', '上菜口', '1#上菜口顶部拨菜机构到位感应', '4007', '');
INSERT INTO `addressconfig` VALUES ('619', '172.28.12.46', '8000', 'mc', 'x206', 'bit', '1', '1', '上菜口', '1#二层直流电机正转到位', '4007', '');
INSERT INTO `addressconfig` VALUES ('620', '172.28.12.46', '8000', 'mc', 'x207', 'bit', '1', '1', '上菜口', '1#二层直流电机反转原位', '4007', '');
INSERT INTO `addressconfig` VALUES ('621', '172.28.12.46', '8000', 'mc', 'x211', 'bit', '1', '1', '上菜口', '1#二层有盘感应', '4007', '');
INSERT INTO `addressconfig` VALUES ('622', '172.28.12.46', '8000', 'mc', 'x212', 'bit', '1', '1', '上菜口', '1#上菜口顶部拨菜机构蒸笼到位感应', '4007', '');
INSERT INTO `addressconfig` VALUES ('623', '172.28.12.46', '8000', 'mc', 'x214', 'bit', '1', '1', '上菜口', '1#下降限位', '4007', '');
INSERT INTO `addressconfig` VALUES ('624', '172.28.12.46', '8000', 'mc', 'x215', 'bit', '1', '1', '上菜口', '1#上升限位', '4007', '');
INSERT INTO `addressconfig` VALUES ('625', '172.28.12.46', '8000', 'mc', 'x216', 'bit', '1', '1', '上菜口', '1#二层行程开关', '4007', '');
INSERT INTO `addressconfig` VALUES ('626', '172.28.12.46', '8000', 'mc', 'x240', 'bit', '1', '1', '上菜口', '2#上菜口底部有盘感应', '4008', '');
INSERT INTO `addressconfig` VALUES ('627', '172.28.12.46', '8000', 'mc', 'x241', 'bit', '1', '1', '上菜口', '2#上菜口顶部行程开关', '4008', '');
INSERT INTO `addressconfig` VALUES ('628', '172.28.12.46', '8000', 'mc', 'x242', 'bit', '1', '1', '上菜口', '2#上菜口顶部有盘感应', '4008', '');
INSERT INTO `addressconfig` VALUES ('629', '172.28.12.46', '8000', 'mc', 'x243', 'bit', '1', '1', '上菜口', '2#上菜口顶部拨菜机构原点感应', '4008', '');
INSERT INTO `addressconfig` VALUES ('630', '172.28.12.46', '8000', 'mc', 'x244', 'bit', '1', '1', '上菜口', '2#上菜口顶部拨菜机构到位感应', '4008', '');
INSERT INTO `addressconfig` VALUES ('631', '172.28.12.46', '8000', 'mc', 'x246', 'bit', '1', '1', '上菜口', '2#二层直流电机正转到位', '4008', '');
INSERT INTO `addressconfig` VALUES ('632', '172.28.12.46', '8000', 'mc', 'x247', 'bit', '1', '1', '上菜口', '2#二层直流电机反转原位', '4008', '');
INSERT INTO `addressconfig` VALUES ('633', '172.28.12.46', '8000', 'mc', 'x251', 'bit', '1', '1', '上菜口', '2#二层有盘感应', '4008', '');
INSERT INTO `addressconfig` VALUES ('634', '172.28.12.46', '8000', 'mc', 'x252', 'bit', '1', '1', '上菜口', '2#上菜口顶部拨菜机构蒸笼到位感应', '4008', '');
INSERT INTO `addressconfig` VALUES ('635', '172.28.12.46', '8000', 'mc', 'x254', 'bit', '1', '1', '上菜口', '2#下降限位', '4008', '');
INSERT INTO `addressconfig` VALUES ('636', '172.28.12.46', '8000', 'mc', 'x255', 'bit', '1', '1', '上菜口', '2#上升限位', '4008', '');
INSERT INTO `addressconfig` VALUES ('637', '172.28.12.46', '8000', 'mc', 'x256', 'bit', '1', '1', '上菜口', '2#二层行程开关', '4008', '');
INSERT INTO `addressconfig` VALUES ('638', '172.28.12.46', '8000', 'mc', 'y0', 'bit', '1', '1', '上菜口', '1#升降步进脉冲', '4007', '');
INSERT INTO `addressconfig` VALUES ('639', '172.28.12.46', '8000', 'mc', 'y1', 'bit', '1', '1', '上菜口', '2#升降步进脉冲', '4008', '');
INSERT INTO `addressconfig` VALUES ('640', '172.28.12.46', '8000', 'mc', 'y2', 'bit', '1', '1', '上菜口', '1#推盘步进脉冲', '4007', '');
INSERT INTO `addressconfig` VALUES ('641', '172.28.12.46', '8000', 'mc', 'y3', 'bit', '1', '1', '上菜口', '2#推盘步进脉冲', '4007', '');
INSERT INTO `addressconfig` VALUES ('642', '172.28.12.46', '8000', 'mc', 'y4', 'bit', '1', '1', '上菜口', '1#升降步进方向', '4007', '');
INSERT INTO `addressconfig` VALUES ('643', '172.28.12.46', '8000', 'mc', 'y6', 'bit', '1', '1', '上菜口', '1#推盘步进方向', '4007', '');
INSERT INTO `addressconfig` VALUES ('644', '172.28.12.46', '8000', 'mc', 'y7', 'bit', '1', '1', '上菜口', '2#推盘步进方向', '4008', '');
INSERT INTO `addressconfig` VALUES ('645', '172.28.12.46', '8000', 'mc', 'y10', 'bit', '1', '1', '上菜口', '1#升降步进刹车', '4007', '');
INSERT INTO `addressconfig` VALUES ('646', '172.28.12.46', '8000', 'mc', 'y11', 'bit', '1', '1', '上菜口', '2#升降步进刹车', '4008', '');
INSERT INTO `addressconfig` VALUES ('647', '172.28.12.46', '8000', 'mc', 'y16', 'bit', '1', '1', '上菜口', '2#升降步进方向', '4008', '');
INSERT INTO `addressconfig` VALUES ('648', '172.28.12.46', '8000', 'mc', 'y223', 'bit', '1', '1', '上菜口', '1#上菜口顶部电磁铁', '4007', '');
INSERT INTO `addressconfig` VALUES ('649', '172.28.12.46', '8000', 'mc', 'y224', 'bit', '1', '1', '上菜口', '1#上菜口底部电磁铁', '4007', '');
INSERT INTO `addressconfig` VALUES ('650', '172.28.12.46', '8000', 'mc', 'y225', 'bit', '1', '1', '上菜口', '1#蜂鸣器', '4007', '');
INSERT INTO `addressconfig` VALUES ('651', '172.28.12.46', '8000', 'mc', 'y226', 'bit', '1', '1', '上菜口', '1#二层直流电机正转', '4007', '');
INSERT INTO `addressconfig` VALUES ('652', '172.28.12.46', '8000', 'mc', 'y227', 'bit', '1', '1', '上菜口', '1#二层直流电机反转', '4007', '');
INSERT INTO `addressconfig` VALUES ('653', '172.28.12.46', '8000', 'mc', 'y263', 'bit', '1', '1', '上菜口', '2#上菜口顶部电磁铁', '4008', '');
INSERT INTO `addressconfig` VALUES ('654', '172.28.12.46', '8000', 'mc', 'y264', 'bit', '1', '1', '上菜口', '2#上菜口底部电磁铁', '4007', '');
INSERT INTO `addressconfig` VALUES ('655', '172.28.12.46', '8000', 'mc', 'y265', 'bit', '1', '1', '上菜口', '2#蜂鸣器', '4008', '');
INSERT INTO `addressconfig` VALUES ('656', '172.28.12.46', '8000', 'mc', 'y266', 'bit', '1', '1', '上菜口', '2#二层直流电机正转', '4008', '');
INSERT INTO `addressconfig` VALUES ('657', '172.28.12.46', '8000', 'mc', 'y267', 'bit', '1', '1', '上菜口', '2#二层直流电机反转', '4008', '');
INSERT INTO `addressconfig` VALUES ('700', '172.28.12.86', '8000', 'mc', 'x0', 'bit', '1', '1', '上菜口', '1#急停', '4009', '');
INSERT INTO `addressconfig` VALUES ('701', '172.28.12.86', '8000', 'mc', 'x1', 'bit', '1', '1', '上菜口', '1#上菜口底部行程开关（原点）', '4009', '');
INSERT INTO `addressconfig` VALUES ('702', '172.28.12.86', '8000', 'mc', 'x4', 'bit', '1', '1', '上菜口', '1#顶部绳子编码器检测感应', '4009', '');
INSERT INTO `addressconfig` VALUES ('703', '172.28.12.86', '8000', 'mc', 'x5', 'bit', '1', '1', '上菜口', '2#顶部绳子编码器检测感应', '4009', '');
INSERT INTO `addressconfig` VALUES ('704', '172.28.12.86', '8000', 'mc', 'x6', 'bit', '1', '1', '上菜口', '1#推盘步进报警信号', '4009', '');
INSERT INTO `addressconfig` VALUES ('705', '172.28.12.86', '8000', 'mc', 'x7', 'bit', '1', '1', '上菜口', '1#升降步进电机报警信号', '4009', '');
INSERT INTO `addressconfig` VALUES ('706', '172.28.12.86', '8000', 'mc', 'x10', 'bit', '1', '1', '上菜口', '1#启动按钮', '4009', '');
INSERT INTO `addressconfig` VALUES ('707', '172.28.12.86', '8000', 'mc', 'x11', 'bit', '1', '1', '上菜口', '1#触摸屏小急停', '4009', '');
INSERT INTO `addressconfig` VALUES ('708', '172.28.12.86', '8000', 'mc', 'x12', 'bit', '1', '1', '上菜口', '2#触摸屏小急停', '4009', '');
INSERT INTO `addressconfig` VALUES ('709', '172.28.12.86', '8000', 'mc', 'x13', 'bit', '1', '1', '上菜口', '2#推盘步进报警信号', '4009', '');
INSERT INTO `addressconfig` VALUES ('710', '172.28.12.86', '8000', 'mc', 'x14', 'bit', '1', '1', '上菜口', '2#升降步进电机报警信号', '4009', '');
INSERT INTO `addressconfig` VALUES ('711', '172.28.12.86', '8000', 'mc', 'x15', 'bit', '1', '1', '上菜口', '2#启动按钮', '4009', '');
INSERT INTO `addressconfig` VALUES ('712', '172.28.12.86', '8000', 'mc', 'x16', 'bit', '1', '1', '上菜口', '2#急停', '4009', '');
INSERT INTO `addressconfig` VALUES ('713', '172.28.12.86', '8000', 'mc', 'x17', 'bit', '1', '1', '上菜口', '2#上菜口底部行程开关（原点）', '4009', '');
INSERT INTO `addressconfig` VALUES ('714', '172.28.12.86', '8000', 'mc', 'x200', 'bit', '1', '1', '上菜口', '1#上菜口底部有盘感应', '4009', '');
INSERT INTO `addressconfig` VALUES ('715', '172.28.12.86', '8000', 'mc', 'x201', 'bit', '1', '1', '上菜口', '1#上菜口顶部行程开关', '4009', '');
INSERT INTO `addressconfig` VALUES ('716', '172.28.12.86', '8000', 'mc', 'x202', 'bit', '1', '1', '上菜口', '1#上菜口顶部有盘感应', '4009', '');
INSERT INTO `addressconfig` VALUES ('717', '172.28.12.86', '8000', 'mc', 'x203', 'bit', '1', '1', '上菜口', '1#上菜口顶部拨菜机构原点感应', '4009', '');
INSERT INTO `addressconfig` VALUES ('718', '172.28.12.86', '8000', 'mc', 'x204', 'bit', '1', '1', '上菜口', '1#上菜口顶部拨菜机构到位感应', '4009', '');
INSERT INTO `addressconfig` VALUES ('719', '172.28.12.86', '8000', 'mc', 'x206', 'bit', '1', '1', '上菜口', '1#二层直流电机正转到位', '4009', '');
INSERT INTO `addressconfig` VALUES ('720', '172.28.12.86', '8000', 'mc', 'x207', 'bit', '1', '1', '上菜口', '1#二层直流电机反转原位', '4009', '');
INSERT INTO `addressconfig` VALUES ('721', '172.28.12.86', '8000', 'mc', 'x211', 'bit', '1', '1', '上菜口', '1#二层有盘感应', '4009', '');
INSERT INTO `addressconfig` VALUES ('722', '172.28.12.86', '8000', 'mc', 'x212', 'bit', '1', '1', '上菜口', '1#上菜口顶部拨菜机构蒸笼到位感应', '4009', '');
INSERT INTO `addressconfig` VALUES ('723', '172.28.12.86', '8000', 'mc', 'x214', 'bit', '1', '1', '上菜口', '1#下降限位', '4009', '');
INSERT INTO `addressconfig` VALUES ('724', '172.28.12.86', '8000', 'mc', 'x215', 'bit', '1', '1', '上菜口', '1#上升限位', '4009', '');
INSERT INTO `addressconfig` VALUES ('725', '172.28.12.86', '8000', 'mc', 'x216', 'bit', '1', '1', '上菜口', '1#二层行程开关', '4009', '');
INSERT INTO `addressconfig` VALUES ('726', '172.28.12.86', '8000', 'mc', 'x240', 'bit', '1', '1', '上菜口', '2#上菜口底部有盘感应', '4009', '');
INSERT INTO `addressconfig` VALUES ('727', '172.28.12.86', '8000', 'mc', 'x241', 'bit', '1', '1', '上菜口', '2#上菜口顶部行程开关', '4009', '');
INSERT INTO `addressconfig` VALUES ('728', '172.28.12.86', '8000', 'mc', 'x242', 'bit', '1', '1', '上菜口', '2#上菜口顶部有盘感应', '4009', '');
INSERT INTO `addressconfig` VALUES ('729', '172.28.12.86', '8000', 'mc', 'x243', 'bit', '1', '1', '上菜口', '2#上菜口顶部拨菜机构原点感应', '4009', '');
INSERT INTO `addressconfig` VALUES ('730', '172.28.12.86', '8000', 'mc', 'x244', 'bit', '1', '1', '上菜口', '2#上菜口顶部拨菜机构到位感应', '4009', '');
INSERT INTO `addressconfig` VALUES ('731', '172.28.12.86', '8000', 'mc', 'x246', 'bit', '1', '1', '上菜口', '2#二层直流电机正转到位', '4009', '');
INSERT INTO `addressconfig` VALUES ('732', '172.28.12.86', '8000', 'mc', 'x247', 'bit', '1', '1', '上菜口', '2#二层直流电机反转原位', '4009', '');
INSERT INTO `addressconfig` VALUES ('733', '172.28.12.86', '8000', 'mc', 'x251', 'bit', '1', '1', '上菜口', '2#二层有盘感应', '4009', '');
INSERT INTO `addressconfig` VALUES ('734', '172.28.12.86', '8000', 'mc', 'x252', 'bit', '1', '1', '上菜口', '2#上菜口顶部拨菜机构蒸笼到位感应', '4009', '');
INSERT INTO `addressconfig` VALUES ('735', '172.28.12.86', '8000', 'mc', 'x254', 'bit', '1', '1', '上菜口', '2#下降限位', '4009', '');
INSERT INTO `addressconfig` VALUES ('736', '172.28.12.86', '8000', 'mc', 'x255', 'bit', '1', '1', '上菜口', '2#上升限位', '4009', '');
INSERT INTO `addressconfig` VALUES ('737', '172.28.12.86', '8000', 'mc', 'x256', 'bit', '1', '1', '上菜口', '2#二层行程开关', '4009', '');
INSERT INTO `addressconfig` VALUES ('738', '172.28.12.86', '8000', 'mc', 'y0', 'bit', '1', '1', '上菜口', '1#升降步进脉冲', '4009', '');
INSERT INTO `addressconfig` VALUES ('739', '172.28.12.86', '8000', 'mc', 'y1', 'bit', '1', '1', '上菜口', '2#升降步进脉冲', '4009', '');
INSERT INTO `addressconfig` VALUES ('740', '172.28.12.86', '8000', 'mc', 'y2', 'bit', '1', '1', '上菜口', '1#推盘步进脉冲', '4009', '');
INSERT INTO `addressconfig` VALUES ('741', '172.28.12.86', '8000', 'mc', 'y3', 'bit', '1', '1', '上菜口', '2#推盘步进脉冲', '4009', '');
INSERT INTO `addressconfig` VALUES ('742', '172.28.12.86', '8000', 'mc', 'y4', 'bit', '1', '1', '上菜口', '1#升降步进方向', '4009', '');
INSERT INTO `addressconfig` VALUES ('743', '172.28.12.86', '8000', 'mc', 'y6', 'bit', '1', '1', '上菜口', '1#推盘步进方向', '4009', '');
INSERT INTO `addressconfig` VALUES ('744', '172.28.12.86', '8000', 'mc', 'y7', 'bit', '1', '1', '上菜口', '2#推盘步进方向', '4009', '');
INSERT INTO `addressconfig` VALUES ('745', '172.28.12.86', '8000', 'mc', 'y10', 'bit', '1', '1', '上菜口', '1#升降步进刹车', '4009', '');
INSERT INTO `addressconfig` VALUES ('746', '172.28.12.86', '8000', 'mc', 'y11', 'bit', '1', '1', '上菜口', '2#升降步进刹车', '4009', '');
INSERT INTO `addressconfig` VALUES ('747', '172.28.12.86', '8000', 'mc', 'y16', 'bit', '1', '1', '上菜口', '2#升降步进方向', '4009', '');
INSERT INTO `addressconfig` VALUES ('748', '172.28.12.86', '8000', 'mc', 'y223', 'bit', '1', '1', '上菜口', '1#上菜口顶部电磁铁', '4009', '');
INSERT INTO `addressconfig` VALUES ('749', '172.28.12.86', '8000', 'mc', 'y224', 'bit', '1', '1', '上菜口', '1#上菜口底部电磁铁', '4009', '');
INSERT INTO `addressconfig` VALUES ('750', '172.28.12.86', '8000', 'mc', 'y225', 'bit', '1', '1', '上菜口', '1#蜂鸣器', '4009', '');
INSERT INTO `addressconfig` VALUES ('751', '172.28.12.86', '8000', 'mc', 'y226', 'bit', '1', '1', '上菜口', '1#二层直流电机正转', '4009', '');
INSERT INTO `addressconfig` VALUES ('752', '172.28.12.86', '8000', 'mc', 'y227', 'bit', '1', '1', '上菜口', '1#二层直流电机反转', '4009', '');
INSERT INTO `addressconfig` VALUES ('753', '172.28.12.86', '8000', 'mc', 'y263', 'bit', '1', '1', '上菜口', '2#上菜口顶部电磁铁', '4009', '');
INSERT INTO `addressconfig` VALUES ('754', '172.28.12.86', '8000', 'mc', 'y264', 'bit', '1', '1', '上菜口', '2#上菜口底部电磁铁', '4009', '');
INSERT INTO `addressconfig` VALUES ('755', '172.28.12.86', '8000', 'mc', 'y265', 'bit', '1', '1', '上菜口', '2#蜂鸣器', '4009', '');
INSERT INTO `addressconfig` VALUES ('756', '172.28.12.86', '8000', 'mc', 'y266', 'bit', '1', '1', '上菜口', '2#二层直流电机正转', '4009', '');
INSERT INTO `addressconfig` VALUES ('757', '172.28.12.86', '8000', 'mc', 'y267', 'bit', '1', '1', '上菜口', '2#二层直流电机反转', '4009', '');
INSERT INTO `addressconfig` VALUES ('800', '172.28.12.103', '8000', 'mc', 'X0', 'bit', '1', '1', '双臂煲仔饭上菜口', '急停', '4601', '');
INSERT INTO `addressconfig` VALUES ('801', '172.28.12.103', '8000', 'mc', 'X1', 'bit', '1', '1', '双臂煲仔饭上菜口', '上菜口底部行程开关（原点）', '4601', '');
INSERT INTO `addressconfig` VALUES ('802', '172.28.12.103', '8000', 'mc', 'X2', 'bit', '1', '1', '双臂煲仔饭上菜口', '上菜口底部有盘感应', '4601', '');
INSERT INTO `addressconfig` VALUES ('803', '172.28.12.103', '8000', 'mc', 'X3', 'bit', '1', '1', '双臂煲仔饭上菜口', '上菜口顶部行程开关', '4601', '');
INSERT INTO `addressconfig` VALUES ('804', '172.28.12.103', '8000', 'mc', 'X4', 'bit', '1', '1', '双臂煲仔饭上菜口', '上菜口顶部有盘感应(替换X12)', '4601', '');
INSERT INTO `addressconfig` VALUES ('805', '172.28.12.103', '8000', 'mc', 'X5', 'bit', '1', '1', '双臂煲仔饭上菜口', '上菜口顶部拨菜机构原点感应', '4601', '');
INSERT INTO `addressconfig` VALUES ('806', '172.28.12.103', '8000', 'mc', 'X6', 'bit', '1', '1', '双臂煲仔饭上菜口', '上菜口顶部拨菜机构到位感应', '4601', '');
INSERT INTO `addressconfig` VALUES ('807', '172.28.12.103', '8000', 'mc', 'X7', 'bit', '1', '1', '双臂煲仔饭上菜口', '升降步进电机报警信号', '4601', '');
INSERT INTO `addressconfig` VALUES ('808', '172.28.12.103', '8000', 'mc', 'X10', 'bit', '1', '1', '双臂煲仔饭上菜口', '启动按钮', '4601', '');
INSERT INTO `addressconfig` VALUES ('809', '172.28.12.103', '8000', 'mc', 'X11', 'bit', '1', '1', '双臂煲仔饭上菜口', '推盘步进报警信号', '4601', '');
INSERT INTO `addressconfig` VALUES ('810', '172.28.12.103', '8000', 'mc', 'X12', 'bit', '1', '1', '双臂煲仔饭上菜口', '顶部绳子编码器检测感应(替换X4)', '4601', '');
INSERT INTO `addressconfig` VALUES ('811', '172.28.12.103', '8000', 'mc', 'X13', 'bit', '1', '1', '双臂煲仔饭上菜口', '下降限位', '4601', '');
INSERT INTO `addressconfig` VALUES ('812', '172.28.12.103', '8000', 'mc', 'X14', 'bit', '1', '1', '双臂煲仔饭上菜口', '上升限位', '4601', '');
INSERT INTO `addressconfig` VALUES ('815', '172.28.12.103', '8000', 'mc', 'X17', 'bit', '1', '1', '双臂煲仔饭上菜口', '上菜口顶部拨菜机构蒸笼到位感应', '4601', '');
INSERT INTO `addressconfig` VALUES ('830', '172.28.12.103', '8000', 'mc', 'X36', 'bit', '1', '1', '双臂煲仔饭上菜口', '1#触摸屏小急停', '4601', '');
INSERT INTO `addressconfig` VALUES ('832', '172.28.12.103', '8000', 'mc', 'Y0', 'bit', '1', '1', '双臂煲仔饭上菜口', '升降步进脉冲', '4601', '');
INSERT INTO `addressconfig` VALUES ('834', '172.28.12.103', '8000', 'mc', 'Y2', 'bit', '1', '1', '双臂煲仔饭上菜口', '推盘步进脉冲', '4601', '');
INSERT INTO `addressconfig` VALUES ('836', '172.28.12.103', '8000', 'mc', 'Y4', 'bit', '1', '1', '双臂煲仔饭上菜口', '升降步进方向', '4601', '');
INSERT INTO `addressconfig` VALUES ('837', '172.28.12.103', '8000', 'mc', 'Y5', 'bit', '1', '1', '双臂煲仔饭上菜口', '步进刹车', '4601', '');
INSERT INTO `addressconfig` VALUES ('838', '172.28.12.103', '8000', 'mc', 'Y6', 'bit', '1', '1', '双臂煲仔饭上菜口', '推盘步进方向', '4601', '');
INSERT INTO `addressconfig` VALUES ('840', '172.28.12.103', '8000', 'mc', 'Y10', 'bit', '1', '1', '双臂煲仔饭上菜口', '上菜口顶部电磁铁', '4601', '');
INSERT INTO `addressconfig` VALUES ('841', '172.28.12.103', '8000', 'mc', 'Y11', 'bit', '1', '1', '双臂煲仔饭上菜口', '上菜口底部电磁铁', '4601', '');
INSERT INTO `addressconfig` VALUES ('842', '172.28.12.103', '8000', 'mc', 'Y12', 'bit', '1', '1', '双臂煲仔饭上菜口', '蜂鸣器', '4601', '');
INSERT INTO `addressconfig` VALUES ('900', '172.28.12.105', '8000', 'mc', 'X0', 'bit', '1', '1', '双臂煲仔饭上菜口', '急停', '4602', '');
INSERT INTO `addressconfig` VALUES ('901', '172.28.12.105', '8000', 'mc', 'X1', 'bit', '1', '1', '双臂煲仔饭上菜口', '上菜口底部行程开关（原点）', '4602', '');
INSERT INTO `addressconfig` VALUES ('902', '172.28.12.105', '8000', 'mc', 'X2', 'bit', '1', '1', '双臂煲仔饭上菜口', '上菜口底部有盘感应', '4602', '');
INSERT INTO `addressconfig` VALUES ('903', '172.28.12.105', '8000', 'mc', 'X3', 'bit', '1', '1', '双臂煲仔饭上菜口', '上菜口顶部行程开关', '4602', '');
INSERT INTO `addressconfig` VALUES ('904', '172.28.12.105', '8000', 'mc', 'X4', 'bit', '1', '1', '双臂煲仔饭上菜口', '上菜口顶部有盘感应(替换X12)', '4602', '');
INSERT INTO `addressconfig` VALUES ('905', '172.28.12.105', '8000', 'mc', 'X5', 'bit', '1', '1', '双臂煲仔饭上菜口', '上菜口顶部拨菜机构原点感应', '4602', '');
INSERT INTO `addressconfig` VALUES ('906', '172.28.12.105', '8000', 'mc', 'X6', 'bit', '1', '1', '双臂煲仔饭上菜口', '上菜口顶部拨菜机构到位感应', '4602', '');
INSERT INTO `addressconfig` VALUES ('907', '172.28.12.105', '8000', 'mc', 'X7', 'bit', '1', '1', '双臂煲仔饭上菜口', '升降步进电机报警信号', '4602', '');
INSERT INTO `addressconfig` VALUES ('908', '172.28.12.105', '8000', 'mc', 'X10', 'bit', '1', '1', '双臂煲仔饭上菜口', '启动按钮', '4602', '');
INSERT INTO `addressconfig` VALUES ('909', '172.28.12.105', '8000', 'mc', 'X11', 'bit', '1', '1', '双臂煲仔饭上菜口', '推盘步进报警信号', '4602', '');
INSERT INTO `addressconfig` VALUES ('910', '172.28.12.105', '8000', 'mc', 'X12', 'bit', '1', '1', '双臂煲仔饭上菜口', '顶部绳子编码器检测感应(替换X4)', '4602', '');
INSERT INTO `addressconfig` VALUES ('911', '172.28.12.105', '8000', 'mc', 'X13', 'bit', '1', '1', '双臂煲仔饭上菜口', '下降限位', '4602', '');
INSERT INTO `addressconfig` VALUES ('912', '172.28.12.105', '8000', 'mc', 'X14', 'bit', '1', '1', '双臂煲仔饭上菜口', '上升限位', '4602', '');
INSERT INTO `addressconfig` VALUES ('913', '172.28.12.105', '8000', 'mc', 'X17', 'bit', '1', '1', '双臂煲仔饭上菜口', '上菜口顶部拨菜机构蒸笼到位感应', '4602', '');
INSERT INTO `addressconfig` VALUES ('914', '172.28.12.105', '8000', 'mc', 'X36', 'bit', '1', '1', '双臂煲仔饭上菜口', '1#触摸屏小急停', '4602', '');
INSERT INTO `addressconfig` VALUES ('915', '172.28.12.105', '8000', 'mc', 'Y0', 'bit', '1', '1', '双臂煲仔饭上菜口', '升降步进脉冲', '4602', '');
INSERT INTO `addressconfig` VALUES ('916', '172.28.12.105', '8000', 'mc', 'Y2', 'bit', '1', '1', '双臂煲仔饭上菜口', '推盘步进脉冲', '4602', '');
INSERT INTO `addressconfig` VALUES ('917', '172.28.12.105', '8000', 'mc', 'Y4', 'bit', '1', '1', '双臂煲仔饭上菜口', '升降步进方向', '4602', '');
INSERT INTO `addressconfig` VALUES ('918', '172.28.12.105', '8000', 'mc', 'Y5', 'bit', '1', '1', '双臂煲仔饭上菜口', '步进刹车', '4602', '');
INSERT INTO `addressconfig` VALUES ('919', '172.28.12.105', '8000', 'mc', 'Y6', 'bit', '1', '1', '双臂煲仔饭上菜口', '推盘步进方向', '4602', '');
INSERT INTO `addressconfig` VALUES ('920', '172.28.12.105', '8000', 'mc', 'Y10', 'bit', '1', '1', '双臂煲仔饭上菜口', '上菜口顶部电磁铁', '4602', '');
INSERT INTO `addressconfig` VALUES ('921', '172.28.12.105', '8000', 'mc', 'Y11', 'bit', '1', '1', '双臂煲仔饭上菜口', '上菜口底部电磁铁', '4602', '');
INSERT INTO `addressconfig` VALUES ('922', '172.28.12.105', '8000', 'mc', 'Y12', 'bit', '1', '1', '双臂煲仔饭上菜口', '蜂鸣器', '4602', '');
INSERT INTO `addressconfig` VALUES ('1000', '172.28.12.105', '8000', 'mc', 'x0', 'bit', '1', '1', '人工上菜口', '1#急停', '4201', '');
INSERT INTO `addressconfig` VALUES ('1001', '172.28.12.105', '8000', 'mc', 'x1', 'bit', '1', '1', '人工上菜口', '1#上菜口底部行程开关（原点）', '4201', '');
INSERT INTO `addressconfig` VALUES ('1002', '172.28.12.105', '8000', 'mc', 'x2', 'bit', '1', '1', '人工上菜口', '1#上菜口底部有盘感应', '4201', '');
INSERT INTO `addressconfig` VALUES ('1003', '172.28.12.105', '8000', 'mc', 'x3', 'bit', '1', '1', '人工上菜口', '1#上菜口顶部行程开关', '4201', '');
INSERT INTO `addressconfig` VALUES ('1004', '172.28.12.105', '8000', 'mc', 'x4', 'bit', '1', '1', '人工上菜口', '1#上菜口顶部有盘感应(替换X12)', '4201', '');
INSERT INTO `addressconfig` VALUES ('1005', '172.28.12.105', '8000', 'mc', 'x5', 'bit', '1', '1', '人工上菜口', '1#上菜口顶部拨菜机构原点感应(替换X15)', '4201', '');
INSERT INTO `addressconfig` VALUES ('1006', '172.28.12.105', '8000', 'mc', 'x6', 'bit', '1', '1', '人工上菜口', '1#上菜口顶部拨菜机构到位感应', '4201', '');
INSERT INTO `addressconfig` VALUES ('1007', '172.28.12.105', '8000', 'mc', 'x7', 'bit', '1', '1', '人工上菜口', '1#升降步进电机报警信号', '4201', '');
INSERT INTO `addressconfig` VALUES ('1008', '172.28.12.105', '8000', 'mc', 'x10', 'bit', '1', '1', '人工上菜口', '1#启动按钮', '4201', '');
INSERT INTO `addressconfig` VALUES ('1009', '172.28.12.105', '8000', 'mc', 'x11', 'bit', '1', '1', '人工上菜口', '1#上菜口顶部拨菜机构蒸笼到位感应', '4201', '');
INSERT INTO `addressconfig` VALUES ('1010', '172.28.12.105', '8000', 'mc', 'x12', 'bit', '1', '1', '人工上菜口', '1#顶部绳子编码器检测感应(替换X4)', '4201', '');
INSERT INTO `addressconfig` VALUES ('1011', '172.28.12.105', '8000', 'mc', 'x13', 'bit', '1', '1', '人工上菜口', '1#下降限位', '4201', '');
INSERT INTO `addressconfig` VALUES ('1012', '172.28.12.105', '8000', 'mc', 'x14', 'bit', '1', '1', '人工上菜口', '1#上升限位', '4201', '');
INSERT INTO `addressconfig` VALUES ('1013', '172.28.12.105', '8000', 'mc', 'x15', 'bit', '1', '1', '人工上菜口', '2#顶部绳子编码器检测感应(替换X5)', '4202', '');
INSERT INTO `addressconfig` VALUES ('1014', '172.28.12.105', '8000', 'mc', 'x16', 'bit', '1', '1', '人工上菜口', '2#急停', '4202', '');
INSERT INTO `addressconfig` VALUES ('1015', '172.28.12.105', '8000', 'mc', 'x17', 'bit', '1', '1', '人工上菜口', '2#上菜口底部行程开关（原点）', '4202', '');
INSERT INTO `addressconfig` VALUES ('1016', '172.28.12.105', '8000', 'mc', 'x20', 'bit', '1', '1', '人工上菜口', '2#上菜口底部有盘感应', '4202', '');
INSERT INTO `addressconfig` VALUES ('1017', '172.28.12.105', '8000', 'mc', 'x21', 'bit', '1', '1', '人工上菜口', '2#上菜口顶部行程开关', '4202', '');
INSERT INTO `addressconfig` VALUES ('1018', '172.28.12.105', '8000', 'mc', 'x22', 'bit', '1', '1', '人工上菜口', '2#上菜口顶部有盘感应', '4202', '');
INSERT INTO `addressconfig` VALUES ('1019', '172.28.12.105', '8000', 'mc', 'x23', 'bit', '1', '1', '人工上菜口', '2#上菜口顶部拨菜机构原点感应', '4202', '');
INSERT INTO `addressconfig` VALUES ('1020', '172.28.12.105', '8000', 'mc', 'x24', 'bit', '1', '1', '人工上菜口', '2#上菜口顶部拨菜机构到位感应', '4202', '');
INSERT INTO `addressconfig` VALUES ('1021', '172.28.12.105', '8000', 'mc', 'x25', 'bit', '1', '1', '人工上菜口', '2#升降步进电机报警信号', '4202', '');
INSERT INTO `addressconfig` VALUES ('1022', '172.28.12.105', '8000', 'mc', 'x26', 'bit', '1', '1', '人工上菜口', '2#启动按钮', '4202', '');
INSERT INTO `addressconfig` VALUES ('1023', '172.28.12.105', '8000', 'mc', 'x27', 'bit', '1', '1', '人工上菜口', '2#上菜口顶部拨菜机构蒸笼到位感应', '4202', '');
INSERT INTO `addressconfig` VALUES ('1025', '172.28.12.105', '8000', 'mc', 'x31', 'bit', '1', '1', '人工上菜口', '2#下降限位', '4202', '');
INSERT INTO `addressconfig` VALUES ('1026', '172.28.12.105', '8000', 'mc', 'x32', 'bit', '1', '1', '人工上菜口', '2#上升限位', '4202', '');
INSERT INTO `addressconfig` VALUES ('1027', '172.28.12.105', '8000', 'mc', 'x33', 'bit', '1', '1', '人工上菜口', '1#推盘步进报警信号', '4201', '');
INSERT INTO `addressconfig` VALUES ('1028', '172.28.12.105', '8000', 'mc', 'x34', 'bit', '1', '1', '人工上菜口', '2#推盘步进报警信号', '4202', '');
INSERT INTO `addressconfig` VALUES ('1030', '172.28.12.105', '8000', 'mc', 'x36', 'bit', '1', '1', '人工上菜口', '1#触摸屏小急停', '4201', '');
INSERT INTO `addressconfig` VALUES ('1032', '172.28.12.105', '8000', 'mc', 'y0', 'bit', '1', '1', '人工上菜口', '1#升降步进脉冲', '4201', '');
INSERT INTO `addressconfig` VALUES ('1033', '172.28.12.105', '8000', 'mc', 'y1', 'bit', '1', '1', '人工上菜口', '2#升降步进脉冲', '4202', '');
INSERT INTO `addressconfig` VALUES ('1034', '172.28.12.105', '8000', 'mc', 'y2', 'bit', '1', '1', '人工上菜口', '1#推盘步进脉冲', '4201', '');
INSERT INTO `addressconfig` VALUES ('1035', '172.28.12.105', '8000', 'mc', 'y3', 'bit', '1', '1', '人工上菜口', '2#推盘步进脉冲', '4202', '');
INSERT INTO `addressconfig` VALUES ('1036', '172.28.12.105', '8000', 'mc', 'y4', 'bit', '1', '1', '人工上菜口', '1#升降步进方向', '4201', '');
INSERT INTO `addressconfig` VALUES ('1037', '172.28.12.105', '8000', 'mc', 'y5', 'bit', '1', '1', '人工上菜口', '1#升降步进刹车', '4201', '');
INSERT INTO `addressconfig` VALUES ('1038', '172.28.12.105', '8000', 'mc', 'y6', 'bit', '1', '1', '人工上菜口', '1#推盘步进方向', '4201', '');
INSERT INTO `addressconfig` VALUES ('1039', '172.28.12.105', '8000', 'mc', 'y7', 'bit', '1', '1', '人工上菜口', '2#推盘步进方向', '4202', '');
INSERT INTO `addressconfig` VALUES ('1040', '172.28.12.105', '8000', 'mc', 'y10', 'bit', '1', '1', '人工上菜口', '1#上菜口顶部电磁铁', '4201', '');
INSERT INTO `addressconfig` VALUES ('1041', '172.28.12.105', '8000', 'mc', 'y11', 'bit', '1', '1', '人工上菜口', '1#上菜口底部电磁铁', '4201', '');
INSERT INTO `addressconfig` VALUES ('1042', '172.28.12.105', '8000', 'mc', 'y12', 'bit', '1', '1', '人工上菜口', '1#蜂鸣器', '4201', '');
INSERT INTO `addressconfig` VALUES ('1046', '172.28.12.105', '8000', 'mc', 'y16', 'bit', '1', '1', '人工上菜口', '2#升降步进方向', '4202', '');
INSERT INTO `addressconfig` VALUES ('1047', '172.28.12.105', '8000', 'mc', 'y17', 'bit', '1', '1', '人工上菜口', '2#升降步进刹车', '4202', '');
INSERT INTO `addressconfig` VALUES ('1050', '172.28.12.105', '8000', 'mc', 'y22', 'bit', '1', '1', '人工上菜口', '2#上菜口顶部电磁铁', '4202', '');
INSERT INTO `addressconfig` VALUES ('1051', '172.28.12.105', '8000', 'mc', 'y23', 'bit', '1', '1', '人工上菜口', '2#上菜口底部电磁铁', '4202', '');
INSERT INTO `addressconfig` VALUES ('1052', '172.28.12.105', '8000', 'mc', 'y24', 'bit', '1', '1', '人工上菜口', '2#蜂鸣器', '4202', '');
INSERT INTO `addressconfig` VALUES ('1100', '172.28.12.119', '8000', 'mc', 'x0', 'bit', '1', '1', '人工上菜口', '1#急停', '4203', '');
INSERT INTO `addressconfig` VALUES ('1101', '172.28.12.119', '8000', 'mc', 'x1', 'bit', '1', '1', '人工上菜口', '1#上菜口底部行程开关（原点）', '4203', '');
INSERT INTO `addressconfig` VALUES ('1102', '172.28.12.119', '8000', 'mc', 'x2', 'bit', '1', '1', '人工上菜口', '1#上菜口底部有盘感应', '4203', '');
INSERT INTO `addressconfig` VALUES ('1103', '172.28.12.119', '8000', 'mc', 'x3', 'bit', '1', '1', '人工上菜口', '1#上菜口顶部行程开关', '4203', '');
INSERT INTO `addressconfig` VALUES ('1104', '172.28.12.119', '8000', 'mc', 'x4', 'bit', '1', '1', '人工上菜口', '1#上菜口顶部有盘感应(替换X12)', '4203', '');
INSERT INTO `addressconfig` VALUES ('1105', '172.28.12.119', '8000', 'mc', 'x5', 'bit', '1', '1', '人工上菜口', '1#上菜口顶部拨菜机构原点感应(替换X15)', '4203', '');
INSERT INTO `addressconfig` VALUES ('1106', '172.28.12.119', '8000', 'mc', 'x6', 'bit', '1', '1', '人工上菜口', '1#上菜口顶部拨菜机构到位感应', '4203', '');
INSERT INTO `addressconfig` VALUES ('1107', '172.28.12.119', '8000', 'mc', 'x7', 'bit', '1', '1', '人工上菜口', '1#升降步进电机报警信号', '4203', '');
INSERT INTO `addressconfig` VALUES ('1108', '172.28.12.119', '8000', 'mc', 'x10', 'bit', '1', '1', '人工上菜口', '1#启动按钮', '4203', '');
INSERT INTO `addressconfig` VALUES ('1109', '172.28.12.119', '8000', 'mc', 'x11', 'bit', '1', '1', '人工上菜口', '1#上菜口顶部拨菜机构蒸笼到位感应', '4203', '');
INSERT INTO `addressconfig` VALUES ('1110', '172.28.12.119', '8000', 'mc', 'x12', 'bit', '1', '1', '人工上菜口', '1#顶部绳子编码器检测感应(替换X4)', '4203', '');
INSERT INTO `addressconfig` VALUES ('1111', '172.28.12.119', '8000', 'mc', 'x13', 'bit', '1', '1', '人工上菜口', '1#下降限位', '4203', '');
INSERT INTO `addressconfig` VALUES ('1112', '172.28.12.119', '8000', 'mc', 'x14', 'bit', '1', '1', '人工上菜口', '1#上升限位', '4203', '');
INSERT INTO `addressconfig` VALUES ('1113', '172.28.12.119', '8000', 'mc', 'x15', 'bit', '1', '1', '人工上菜口', '2#顶部绳子编码器检测感应(替换X5)', '4203', '');
INSERT INTO `addressconfig` VALUES ('1114', '172.28.12.119', '8000', 'mc', 'x16', 'bit', '1', '1', '人工上菜口', '2#急停', '4203', '');
INSERT INTO `addressconfig` VALUES ('1115', '172.28.12.119', '8000', 'mc', 'x17', 'bit', '1', '1', '人工上菜口', '2#上菜口底部行程开关（原点）', '4203', '');
INSERT INTO `addressconfig` VALUES ('1116', '172.28.12.119', '8000', 'mc', 'x20', 'bit', '1', '1', '人工上菜口', '2#上菜口底部有盘感应', '4203', '');
INSERT INTO `addressconfig` VALUES ('1117', '172.28.12.119', '8000', 'mc', 'x21', 'bit', '1', '1', '人工上菜口', '2#上菜口顶部行程开关', '4203', '');
INSERT INTO `addressconfig` VALUES ('1118', '172.28.12.119', '8000', 'mc', 'x22', 'bit', '1', '1', '人工上菜口', '2#上菜口顶部有盘感应', '4203', '');
INSERT INTO `addressconfig` VALUES ('1119', '172.28.12.119', '8000', 'mc', 'x23', 'bit', '1', '1', '人工上菜口', '2#上菜口顶部拨菜机构原点感应', '4203', '');
INSERT INTO `addressconfig` VALUES ('1120', '172.28.12.119', '8000', 'mc', 'x24', 'bit', '1', '1', '人工上菜口', '2#上菜口顶部拨菜机构到位感应', '4203', '');
INSERT INTO `addressconfig` VALUES ('1121', '172.28.12.119', '8000', 'mc', 'x25', 'bit', '1', '1', '人工上菜口', '2#升降步进电机报警信号', '4203', '');
INSERT INTO `addressconfig` VALUES ('1122', '172.28.12.119', '8000', 'mc', 'x26', 'bit', '1', '1', '人工上菜口', '2#启动按钮', '4203', '');
INSERT INTO `addressconfig` VALUES ('1123', '172.28.12.119', '8000', 'mc', 'x27', 'bit', '1', '1', '人工上菜口', '2#上菜口顶部拨菜机构蒸笼到位感应', '4203', '');
INSERT INTO `addressconfig` VALUES ('1124', '172.28.12.119', '8000', 'mc', 'x31', 'bit', '1', '1', '人工上菜口', '2#下降限位', '4203', '');
INSERT INTO `addressconfig` VALUES ('1125', '172.28.12.119', '8000', 'mc', 'x32', 'bit', '1', '1', '人工上菜口', '2#上升限位', '4203', '');
INSERT INTO `addressconfig` VALUES ('1126', '172.28.12.119', '8000', 'mc', 'x33', 'bit', '1', '1', '人工上菜口', '1#推盘步进报警信号', '4203', '');
INSERT INTO `addressconfig` VALUES ('1127', '172.28.12.119', '8000', 'mc', 'x34', 'bit', '1', '1', '人工上菜口', '2#推盘步进报警信号', '4203', '');
INSERT INTO `addressconfig` VALUES ('1128', '172.28.12.119', '8000', 'mc', 'x36', 'bit', '1', '1', '人工上菜口', '1#触摸屏小急停', '4203', '');
INSERT INTO `addressconfig` VALUES ('1129', '172.28.12.119', '8000', 'mc', 'y0', 'bit', '1', '1', '人工上菜口', '1#升降步进脉冲', '4203', '');
INSERT INTO `addressconfig` VALUES ('1130', '172.28.12.119', '8000', 'mc', 'y1', 'bit', '1', '1', '人工上菜口', '2#升降步进脉冲', '4203', '');
INSERT INTO `addressconfig` VALUES ('1131', '172.28.12.119', '8000', 'mc', 'y2', 'bit', '1', '1', '人工上菜口', '1#推盘步进脉冲', '4203', '');
INSERT INTO `addressconfig` VALUES ('1132', '172.28.12.119', '8000', 'mc', 'y3', 'bit', '1', '1', '人工上菜口', '2#推盘步进脉冲', '4203', '');
INSERT INTO `addressconfig` VALUES ('1133', '172.28.12.119', '8000', 'mc', 'y4', 'bit', '1', '1', '人工上菜口', '1#升降步进方向', '4203', '');
INSERT INTO `addressconfig` VALUES ('1134', '172.28.12.119', '8000', 'mc', 'y5', 'bit', '1', '1', '人工上菜口', '1#升降步进刹车', '4203', '');
INSERT INTO `addressconfig` VALUES ('1135', '172.28.12.119', '8000', 'mc', 'y6', 'bit', '1', '1', '人工上菜口', '1#推盘步进方向', '4203', '');
INSERT INTO `addressconfig` VALUES ('1136', '172.28.12.119', '8000', 'mc', 'y7', 'bit', '1', '1', '人工上菜口', '2#推盘步进方向', '4203', '');
INSERT INTO `addressconfig` VALUES ('1137', '172.28.12.119', '8000', 'mc', 'y10', 'bit', '1', '1', '人工上菜口', '1#上菜口顶部电磁铁', '4203', '');
INSERT INTO `addressconfig` VALUES ('1138', '172.28.12.119', '8000', 'mc', 'y11', 'bit', '1', '1', '人工上菜口', '1#上菜口底部电磁铁', '4203', '');
INSERT INTO `addressconfig` VALUES ('1139', '172.28.12.119', '8000', 'mc', 'y12', 'bit', '1', '1', '人工上菜口', '1#蜂鸣器', '4203', '');
INSERT INTO `addressconfig` VALUES ('1140', '172.28.12.119', '8000', 'mc', 'y16', 'bit', '1', '1', '人工上菜口', '2#升降步进方向', '4203', '');
INSERT INTO `addressconfig` VALUES ('1141', '172.28.12.119', '8000', 'mc', 'y17', 'bit', '1', '1', '人工上菜口', '2#升降步进刹车', '4203', '');
INSERT INTO `addressconfig` VALUES ('1142', '172.28.12.119', '8000', 'mc', 'y22', 'bit', '1', '1', '人工上菜口', '2#上菜口顶部电磁铁', '4203', '');
INSERT INTO `addressconfig` VALUES ('1143', '172.28.12.119', '8000', 'mc', 'y23', 'bit', '1', '1', '人工上菜口', '2#上菜口底部电磁铁', '4203', '');
INSERT INTO `addressconfig` VALUES ('1144', '172.28.12.119', '8000', 'mc', 'y24', 'bit', '1', '1', '人工上菜口', '2#蜂鸣器', '4203', '');

-- ----------------------------
-- Table structure for addrtype
-- ----------------------------
DROP TABLE IF EXISTS `addrtype`;
CREATE TABLE `addrtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typecode` varchar(255) DEFAULT NULL,
  `typename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of addrtype
-- ----------------------------
INSERT INTO `addrtype` VALUES ('1', '1', '数值');
INSERT INTO `addrtype` VALUES ('2', '2', '上菜口点检');
INSERT INTO `addrtype` VALUES ('3', '3', '下菜口点检');

-- ----------------------------
-- Table structure for datamodel
-- ----------------------------
DROP TABLE IF EXISTS `datamodel`;
CREATE TABLE `datamodel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group` varchar(255) DEFAULT NULL,
  `index` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `datatype` varchar(255) DEFAULT NULL,
  `length` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of datamodel
-- ----------------------------
INSERT INTO `datamodel` VALUES ('1', 'errnum', '1', 'state', 'byte', '1');
INSERT INTO `datamodel` VALUES ('2', 'errnum', '2', 'code1', 'short', '2');
INSERT INTO `datamodel` VALUES ('3', 'errnum', '3', 'code2', 'short', '2');

-- ----------------------------
-- Table structure for serverconfig
-- ----------------------------
DROP TABLE IF EXISTS `serverconfig`;
CREATE TABLE `serverconfig` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `port` int(11) DEFAULT NULL,
  `dataAddr` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of serverconfig
-- ----------------------------
INSERT INTO `serverconfig` VALUES ('1', '17076', '/chinesefood/up/check/', '2', '1');
INSERT INTO `serverconfig` VALUES ('2', '17076', '/chinesefood/down/check/', '3', '1');
