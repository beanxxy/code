/*
 Navicat Premium Data Transfer

 Source Server         : 本地8.0版本
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:13306
 Source Schema         : gateway_core

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 06/01/2021 09:48:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for gw_cfg_alarm
-- ----------------------------
DROP TABLE IF EXISTS `gw_cfg_alarm`;
CREATE TABLE `gw_cfg_alarm`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `config` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DataAddr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DataModel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `massge` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 363 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gw_cfg_alarm
-- ----------------------------
INSERT INTO `gw_cfg_alarm` VALUES (1, '新下菜口', '1', '1', '1', 'B002-1', 'byte', '推菜错误', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (2, '新下菜口', '2', '1', '1', 'B002-3', 'byte', '升降错误', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (3, '新下菜口', '3', '12', '1', 'B002-4', 'byte', '推菜任务异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (4, '新下菜口', '4', '23', '1', 'B002-5', 'byte', '升降任务异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (300, '炒锅', '1', '1', '1', 'B001-0', 'allbit', '翻转电机超时', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (301, '炒锅', '2', '1', '1', 'B001-1', 'allbit', '搅拌电机通信异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (302, '炒锅', '3', '1', '1', 'B001-2', 'allbit', '托盘电机超时', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (303, '炒锅', '4', '1', '1', 'B001-3', 'allbit', '推爪电机超时', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (304, '炒锅', '5', '1', '1', 'B001-4', 'allbit', '升降电机超时', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (305, '炒锅', '6', '1', '1', 'B001-5', 'allbit', '夹盘失败', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (306, '炒锅', '7', '1', '1', 'B001-6', 'allbit', '上盘失败', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (307, '炒锅', '8', '1', '1', 'B001-7', 'allbit', '上盘超时', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (308, '炒锅', '9', '1', '1', 'B001-8', 'allbit', '推盘超时', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (309, '炒锅', '10', '1', '1', 'B001-9', 'allbit', '料爪电机超时', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (310, '炒锅', '11', '1', '1', 'B001-10', 'allbit', '来料料桥超时', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (311, '炒锅', '12', '1', '1', 'B001-11', 'allbit', '回收料桥拥堵', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (312, '炒锅', '13', '1', '1', 'B001-12', 'allbit', '投料失败', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (313, '炒锅', '14', '1', '1', 'B001-13', 'allbit', '回收料盒失败', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (314, '炒锅', '15', '1', '1', 'B001-14', 'allbit', '机芯板通信异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (315, '炒锅', '16', '1', '1', 'B001-15', 'allbit', '机芯板故障', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (316, '炒锅', '17', '1', '1', 'B001-16', 'allbit', '加水超时', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (317, '炒锅', '18', '1', '1', 'B001-17', 'allbit', '红外测温模块超时', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (318, '炒锅', '19', '1', '1', 'B001-18', 'allbit', '超温报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (319, '炒锅', '20', '1', '1', 'B001-19', 'allbit', '菜单超时', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (320, '炒锅', '21', '1', '1', 'B001-20', 'allbit', '获取菜肴文件失败', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (321, '炒锅', '22', '1', '1', 'B001-21', 'allbit', '对射传感器异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (322, '炒锅', '23', '1', '1', 'B001-22', 'allbit', '搅拌电机故障', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (323, '炒锅', '24', '1', '1', 'B001-23', 'allbit', '缺盘', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (324, '炒锅', '25', '1', '1', 'B001-24', 'allbit', '硬件急停', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (325, '炒锅', '26', '1', '1', 'B001-25', 'allbit', '上菜口急停', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (326, '炒锅', '27', '1', '1', 'B001-26', 'allbit', '上位机急停', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (327, '炒锅', '28', '1', '1', 'B001-27', 'allbit', '上菜口通信超时', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (328, '炒锅', '29', '1', '1', 'B001-28', 'allbit', '上菜口取消做菜', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (329, '炒锅', '30', '1', '1', 'B001-29', 'allbit', '做菜失败', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (330, '炒锅', '31', '1', '1', 'B001-30', 'allbit', '加热功率异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (400, '2#上菜口', '1', '1', '1', 'D2250-0', 'bit', '电箱急停已按下', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (401, '2#上菜口', '2', '1', '1', 'D2250-1', 'bit', '拨盘电机拨菜超时报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (402, '2#上菜口', '3', '1', '1', 'D2250-2', 'bit', '拨盘电机返回超时报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (403, '2#上菜口', '4', '1', '1', 'D2250-3', 'bit', '步进电机报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (404, '2#上菜口', '5', '1', '1', 'D2250-4', 'bit', '顶部缺盘感应报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (405, '2#上菜口', '6', '1', '1', 'D2250-5', 'bit', '底部缺盘感应报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (406, '2#上菜口', '7', '1', '1', 'D2250-6', 'bit', '锅下MODBUS RTU读取通信异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (407, '2#上菜口', '8', '1', '1', 'D2250-7', 'bit', '锅上MODBUS RTU读取通信异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (408, '2#上菜口', '9', '1', '1', 'D2250-8', 'bit', '锅下MODBUS RTU写入通信异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (409, '2#上菜口', '10', '1', '1', 'D2250-9', 'bit', '锅上MODBUS RTU写入通信异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (410, '2#上菜口', '11', '1', '1', 'D2250-10', 'bit', '主站发生重试', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (411, '2#上菜口', '12', '1', '1', 'D2250-11', 'bit', '主站发生超时', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (412, '2#上菜口', '13', '1', '1', 'D2250-12', 'bit', '炒锅下急停已按下', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (413, '2#上菜口', '14', '1', '1', 'D2250-13', 'bit', '炒锅下缺盘报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (414, '2#上菜口', '15', '1', '1', 'D2250-14', 'bit', '炒锅上急停已按下', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (415, '2#上菜口', '16', '1', '1', 'D2250-15', 'bit', '炒锅上缺盘报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (416, '2#上菜口', '17', '1', '1', 'D2251-0', 'bit', '炒锅下做菜失败', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (417, '2#上菜口', '18', '1', '1', 'D2251-1', 'bit', '炒锅上做菜失败', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (418, '2#上菜口', '19', '1', '1', 'D2251-2', 'bit', '触摸屏小急停已按下', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (419, '2#上菜口', '20', '1', '1', 'D2251-3', 'bit', '上菜口二层缺盘报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (420, '2#上菜口', '21', '1', '1', 'D2251-4', 'bit', '上菜口二层电机正转超时', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (421, '2#上菜口', '22', '1', '1', 'D2251-5', 'bit', '上菜口二层电机反转超时', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (422, '2#上菜口', '23', '1', '1', 'D2251-6', 'bit', '启动锅下超时', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (423, '2#上菜口', '24', '1', '1', 'D2251-7', 'bit', '启动锅上超时', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (424, '2#上菜口', '25', '1', '1', 'D2251-8', 'bit', '上菜口绳子运动检测超时', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (425, '2#上菜口', '26', '1', '1', 'D2251-9', 'bit', '步进电机上升极限位', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (426, '2#上菜口', '27', '1', '1', 'D2251-10', 'bit', '步进电机下降极限位', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (427, '2#上菜口', '28', '1', '1', 'D2251-11', 'bit', '二层到位感应没有感应到报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (428, '2#上菜口', '29', '1', '1', 'D2251-12', 'bit', 'CC-LINK模块故障报警SW80/81', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (429, '2#上菜口', '30', '1', '1', 'D2251-13', 'bit', 'CC-LINK模块故障报警SB0080', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (430, '1#上菜口', '31', '1', '1', 'D2050-0', 'bit', '电箱急停已按下', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (431, '1#上菜口', '32', '1', '1', 'D2050-1', 'bit', '拨盘电机拨菜超时报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (432, '1#上菜口', '33', '1', '1', 'D2050-2', 'bit', '拨盘电机返回超时报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (433, '1#上菜口', '34', '1', '1', 'D2050-3', 'bit', '步进电机报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (434, '1#上菜口', '35', '1', '1', 'D2050-4', 'bit', '顶部缺盘感应报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (435, '1#上菜口', '36', '1', '1', 'D2050-5', 'bit', '底部缺盘感应报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (436, '1#上菜口', '37', '1', '1', 'D2050-6', 'bit', '锅下MODBUS RTU读取通信异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (437, '1#上菜口', '38', '1', '1', 'D2050-7', 'bit', '锅上MODBUS RTU读取通信异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (438, '1#上菜口', '39', '1', '1', 'D2050-8', 'bit', '锅下MODBUS RTU写入通信异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (439, '1#上菜口', '40', '1', '1', 'D2050-9', 'bit', '锅上MODBUS RTU写入通信异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (440, '1#上菜口', '41', '1', '1', 'D2050-10', 'bit', '主站发生重试', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (441, '1#上菜口', '42', '1', '1', 'D2050-11', 'bit', '主站发生超时', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (442, '1#上菜口', '43', '1', '1', 'D2050-12', 'bit', '炒锅下急停已按下', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (443, '1#上菜口', '44', '1', '1', 'D2050-13', 'bit', '炒锅下缺盘报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (444, '1#上菜口', '45', '1', '1', 'D2050-14', 'bit', '炒锅上急停已按下', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (445, '1#上菜口', '46', '1', '1', 'D2050-15', 'bit', '炒锅上缺盘报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (446, '1#上菜口', '47', '1', '1', 'D2051-0', 'bit', '炒锅下做菜失败', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (447, '1#上菜口', '48', '1', '1', 'D2051-1', 'bit', '炒锅上做菜失败', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (448, '1#上菜口', '49', '1', '1', 'D2051-2', 'bit', '触摸屏小急停已按下', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (449, '1#上菜口', '50', '1', '1', 'D2051-3', 'bit', '上菜口二层缺盘报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (450, '1#上菜口', '51', '1', '1', 'D2051-4', 'bit', '上菜口二层电机正转超时', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (451, '1#上菜口', '52', '1', '1', 'D2051-5', 'bit', '上菜口二层电机反转超时', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (452, '1#上菜口', '53', '1', '1', 'D2051-6', 'bit', '启动锅下超时', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (453, '1#上菜口', '54', '1', '1', 'D2051-7', 'bit', '启动锅上超时', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (454, '1#上菜口', '55', '1', '1', 'D2051-8', 'bit', '上菜口绳子运动检测超时', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (455, '1#上菜口', '56', '1', '1', 'D2051-9', 'bit', '步进电机上升极限位', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (456, '1#上菜口', '57', '1', '1', 'D2051-10', 'bit', '步进电机下降极限位', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (457, '1#上菜口', '58', '1', '1', 'D2051-11', 'bit', '二层到位感应没有感应到报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (458, '1#上菜口', '59', '1', '1', 'D2052-0', 'bit', 'CC-LINK模块故障报警SW80/81', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (459, '1#上菜口', '60', '1', '1', 'D2052-1', 'bit', 'CC-LINK模块故障报警SB0080', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (460, '1#人工上菜口', '61', '1', '1', 'D1050-0', 'bit', '1#急停已按下', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (461, '1#人工上菜口', '62', '1', '1', 'D1050-1', 'bit', '1#拨盘电机拨菜超时报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (462, '1#人工上菜口', '63', '1', '1', 'D1050-2', 'bit', '1#拨盘电机返回超时报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (463, '1#人工上菜口', '64', '1', '1', 'D1050-3', 'bit', '1#步进电机报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (464, '1#人工上菜口', '65', '1', '1', 'D1050-4', 'bit', '1#顶部缺盘感应报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (465, '1#人工上菜口', '66', '1', '1', 'D1050-5', 'bit', '1#底部缺盘感应报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (466, '1#人工上菜口', '67', '1', '1', 'D1050-6', 'bit', '1#步进电机上升极限位', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (467, '1#人工上菜口', '68', '1', '1', 'D1050-7', 'bit', '1#步进电机下降极限位', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (468, '2#人工上菜口', '69', '1', '1', 'D1250-0', 'bit', '2#急停已按下', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (469, '2#人工上菜口', '70', '1', '1', 'D1250-1', 'bit', '2#拨盘电机拨菜超时', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (470, '2#人工上菜口', '71', '1', '1', 'D1250-2', 'bit', '2#拨盘电机返回超时', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (471, '2#人工上菜口', '72', '1', '1', 'D1250-3', 'bit', '2#步进电机报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (472, '2#人工上菜口', '73', '1', '1', 'D1250-4', 'bit', '2#顶部缺盘报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (473, '2#人工上菜口', '74', '1', '1', 'D1250-5', 'bit', '2#底部缺盘报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (474, '2#人工上菜口', '75', '1', '1', 'D1250-6', 'bit', '2#步进电机上升极限位', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (475, '2#人工上菜口', '76', '1', '1', 'D1250-7', 'bit', '2#步进电机下降极限位', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (500, '上#冰库', '1', '1', '1', 'D3811-0', 'bit', '1#急停已按下', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (501, '上#冰库', '2', '1', '1', 'D3811-1', 'bit', '1#上下伺服报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (502, '上#冰库', '3', '1', '1', 'D3811-2', 'bit', '1#送料气缸不到位报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (503, '上#冰库', '4', '1', '1', 'D3811-3', 'bit', '1#出料窗口气缸不到位报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (504, '上#冰库', '5', '1', '1', 'D3811-4', 'bit', '1#料盒检测无料报警 ', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (505, '上#冰库', '6', '1', '1', 'D3811-5', 'bit', '1#料盒取料卡料报警 ', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (506, '上#冰库', '7', '1', '1', 'D3811-6', 'bit', '1#移载轴步进结束异常报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (507, '上#冰库', '8', '1', '1', 'D3811-7', 'bit', '1#接收到做菜失败异常信号', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (508, '上#冰库', '9', '1', '1', 'D3811-8', 'bit', '1#送料异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (509, '上#冰库', '10', '1', '1', 'D3811-9', 'bit', '1#出料位置检测到有料盒报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (510, '上#冰库', '11', '1', '1', 'D3811-10', 'bit', '1#升降平台上检测到有料盒报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (511, '下#冰库', '12', '1', '1', 'D4811-0', 'bit', '2#急停已按下', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (512, '下#冰库', '13', '1', '1', 'D4811-1', 'bit', '2#上下伺服报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (513, '下#冰库', '14', '1', '1', 'D4811-2', 'bit', '2#送料气缸不到位报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (514, '下#冰库', '15', '1', '1', 'D4811-3', 'bit', '2#出料窗口气缸不到位报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (515, '下#冰库', '16', '1', '1', 'D4811-4', 'bit', '2#料盒检测无料报警 ', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (516, '下#冰库', '17', '1', '1', 'D4811-5', 'bit', '2#料盒取料卡料报警 ', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (517, '下#冰库', '18', '1', '1', 'D4811-6', 'bit', '2#移载轴步进结束异常报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (518, '下#冰库', '19', '1', '1', 'D4811-7', 'bit', '2#接收到做菜失败异常信号', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (519, '下#冰库', '20', '1', '1', 'D4811-8', 'bit', '2#送料异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (520, '下#冰库', '21', '1', '1', 'D4811-9', 'bit', '2#出料位置检测到有料盒', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (521, '下#冰库', '22', '1', '1', 'D4811-10', 'bit', '2#升降平台上检测到有料盒报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (700, '左煲仔饭', '1', '1', '1', 'D108-0', 'bit', '左运行状态_1.急停', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (701, '左煲仔饭', '2', '1', '1', 'D108-1', 'bit', '左上盘机数据.报警.缺盘报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (702, '左煲仔饭', '3', '1', '1', 'D108-2', 'bit', '左上盘机数据.报警.夹盘松开超时报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (703, '左煲仔饭', '4', '1', '1', 'D108-3', 'bit', '左上盘机数据.报警.夹盘加紧超时报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (704, '左煲仔饭', '5', '1', '1', 'D108-4', 'bit', '左上盘机数据.报警.上升超时报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (705, '左煲仔饭', '6', '1', '1', 'D108-5', 'bit', '左上盘机数据.报警.下降超时报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (706, '左煲仔饭', '7', '1', '1', 'D108-6', 'bit', '左料桥数据.报警.煲盖未吸取', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (707, '左煲仔饭', '8', '1', '1', 'D108-7', 'bit', '左料桥数据.报警.料盒缺料报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (708, '左煲仔饭', '9', '1', '1', 'D108-8', 'bit', '左料桥数据.报警.加水超时报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (709, '左煲仔饭', '10', '1', '1', 'D108-9', 'bit', '左料桥数据.报警.请求工加水', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (710, '左煲仔饭', '11', '1', '1', 'D108-10', 'bit', '左机械臂结构数据.输出.机械臂保护性停止中（报警）', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (711, '左煲仔饭', '12', '1', '1', 'D108-11', 'bit', '左机械臂结构数据.输出.机械臂急停保护（报警）', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (712, '左煲仔饭', '13', '1', '1', 'D108-12', 'bit', '左机械臂结构数据.输出.臂三指气缸夹紧异常（报警）', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (713, '左煲仔饭', '14', '1', '1', 'D108-13', 'bit', '左机械臂结构数据.输出.臂三指气缸松开异常（报警）', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (716, '左煲仔饭', '17', '1', '1', 'D109-0', 'bit', '左上盘机数据.报警.上盘机未检测到盘', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (718, '左煲仔饭', '19', '1', '1', 'D109-2', 'bit', '左煲1数据.报警.煲仔机状态异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (719, '左煲仔饭', '20', '1', '1', 'D109-3', 'bit', '左煲2数据.报警.煲仔机状态异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (720, '左煲仔饭', '21', '1', '1', 'D109-4', 'bit', '左煲3数据.报警.煲仔机状态异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (721, '左煲仔饭', '22', '1', '1', 'D109-5', 'bit', '左煲4数据.报警.煲仔机状态异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (722, '左煲仔饭', '23', '1', '1', 'D109-6', 'bit', '左煲5数据.报警.煲仔机状态异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (723, '左煲仔饭', '24', '1', '1', 'D109-7', 'bit', '左煲6数据.报警.煲仔机状态异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (724, '左煲仔饭', '25', '1', '1', 'D109-8', 'bit', '左煲7数据.报警.煲仔机状态异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (725, '左煲仔饭', '26', '1', '1', 'D109-9', 'bit', '左煲8数据.报警.煲仔机状态异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (726, '左煲仔饭', '27', '1', '1', 'D109-10', 'bit', '左煲9数据.报警.煲仔机状态异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (727, '左煲仔饭', '28', '1', '1', 'D109-11', 'bit', '左煲10数据.报警.煲仔机状态异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (728, '左煲仔饭', '29', '1', '1', 'D109-12', 'bit', '左煲11数据.报警.煲仔机状态异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (729, '左煲仔饭', '30', '1', '1', 'D109-13', 'bit', '左煲12数据.报警.煲仔机状态异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (731, '左煲仔饭', '32', '1', '1', 'D109-15', 'bit', '左设备未登录，请检测网络链接。', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (732, '左煲仔饭', '33', '1', '1', 'D112-0', 'bit', '左升降轴数据.报警.轴运动超时报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (733, '左煲仔饭', '34', '1', '1', 'D112-1', 'bit', '左升降轴数据.报警.轴触发限位报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (734, '左煲仔饭', '35', '1', '1', 'D112-2', 'bit', '左升降轴数据.报警.轴回原点超时报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (735, '左煲仔饭', '36', '1', '1', 'D112-3', 'bit', '左升降轴数据.报警.上下限位传感器异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (736, '左煲仔饭', '37', '1', '1', 'D112-4', 'bit', '左煲1数据.报警.煲仔机机械臂异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (737, '左煲仔饭', '38', '1', '1', 'D112-5', 'bit', '左煲2数据.报警.煲仔机机械臂异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (738, '左煲仔饭', '39', '1', '1', 'D112-6', 'bit', '左煲3数据.报警.煲仔机机械臂异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (739, '左煲仔饭', '40', '1', '1', 'D112-7', 'bit', '左煲4数据.报警.煲仔机机械臂异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (740, '左煲仔饭', '41', '1', '1', 'D112-8', 'bit', '左煲5数据.报警.煲仔机机械臂异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (741, '左煲仔饭', '42', '1', '1', 'D112-9', 'bit', '左煲6数据.报警.煲仔机机械臂异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (742, '左煲仔饭', '43', '1', '1', 'D112-10', 'bit', '左煲7数据.报警.煲仔机机械臂异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (743, '左煲仔饭', '44', '1', '1', 'D112-11', 'bit', '左煲8数据.报警.煲仔机机械臂异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (744, '左煲仔饭', '45', '1', '1', 'D112-12', 'bit', '左煲9数据.报警.煲仔机机械臂异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (745, '左煲仔饭', '46', '1', '1', 'D112-13', 'bit', '左煲10数据.报警.煲仔机机械臂异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (746, '左煲仔饭', '47', '1', '1', 'D112-14', 'bit', '左煲11数据.报警.煲仔机机械臂异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (747, '左煲仔饭', '48', '1', '1', 'D112-15', 'bit', '左煲12数据.报警.煲仔机机械臂异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (748, '左煲仔饭', '49', '1', '1', 'D125-0', 'bit', '左料桥数据.报警.未感应到气缸动作超时', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (749, '左煲仔饭', '50', '1', '1', 'D125-1', 'bit', '左下单数据.报警.接单未准备', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (750, '左煲仔饭', '51', '1', '1', 'D125-2', 'bit', '左机械臂结构数据.控制.机械臂未进入自动状态（报警）', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (751, '左煲仔饭', '52', '1', '1', 'D125-3', 'bit', '左上盘机数据.报警.盘上升到位感应异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (752, '左煲仔饭', '53', '1', '1', 'D125-4', 'bit', '左上盘机数据.报警.推煲任务号为零', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (753, '左煲仔饭', '54', '1', '1', 'D125-5', 'bit', '左下单数据.报警.下单数据为零', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (754, '左煲仔饭', '55', '1', '1', 'D125-6', 'bit', '左料桥数据.报警.煲工位二运输异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (755, '左煲仔饭', '56', '1', '1', 'D125-7', 'bit', '左料桥数据.报警.取盖到位传感器异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (756, '左煲仔饭', '57', '1', '1', 'D125-8', 'bit', '左上盘机数据.报警.上盘机未准备就绪', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (757, '左煲仔饭', '58', '1', '1', 'D125-9', 'bit', '左上盘机数据.报警.上盘机动作异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (758, '左煲仔饭', '59', '1', '1', 'D125-10', 'bit', '左上盘机数据.报警.上盘机检测横移轴未动作', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (759, '左煲仔饭', '60', '1', '1', 'D125-11', 'bit', '左上盘机数据.报警.夹不上盘', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (760, '左煲仔饭', '61', '1', '1', 'D125-12', 'bit', '左料桥数据.报警.机械臂夹煲异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (762, '右煲仔饭', '63', '1', '1', 'D110-0', 'bit', '右运行状态_1.急停', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (763, '右煲仔饭', '64', '1', '1', 'D110-1', 'bit', '右上盘机数据.报警.缺盘报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (764, '右煲仔饭', '65', '1', '1', 'D110-2', 'bit', '右上盘机数据.报警.夹盘松开超时报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (765, '右煲仔饭', '66', '1', '1', 'D110-3', 'bit', '右上盘机数据.报警.夹盘加紧超时报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (766, '右煲仔饭', '67', '1', '1', 'D110-4', 'bit', '右上盘机数据.报警.上升超时报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (767, '右煲仔饭', '68', '1', '1', 'D110-5', 'bit', '右上盘机数据.报警.下降超时报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (768, '右煲仔饭', '69', '1', '1', 'D110-6', 'bit', '右料桥数据.报警.煲盖未吸取', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (769, '右煲仔饭', '70', '1', '1', 'D110-7', 'bit', '右料桥数据.报警.料盒缺料报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (770, '右煲仔饭', '71', '1', '1', 'D110-8', 'bit', '右料桥数据.报警.加水超时报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (771, '右煲仔饭', '72', '1', '1', 'D110-9', 'bit', '右料桥数据.报警.请求工加水', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (772, '右煲仔饭', '73', '1', '1', 'D110-10', 'bit', '右机械臂结构数据.输出.臂二指气缸夹紧异常（报警）', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (773, '右煲仔饭', '74', '1', '1', 'D110-11', 'bit', '右机械臂结构数据.输出.臂二指气缸松开异常（报警）', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (774, '右煲仔饭', '75', '1', '1', 'D110-12', 'bit', '右机械臂结构数据.输出.臂三指气缸夹紧异常（报警）', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (775, '右煲仔饭', '76', '1', '1', 'D110-13', 'bit', '右机械臂结构数据.输出.臂三指气缸松开异常（报警）', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (778, '右煲仔饭', '79', '1', '1', 'D111-0', 'bit', '右上盘机数据.报警.上盘机未检测到盘', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (780, '右煲仔饭', '81', '1', '1', 'D111-2', 'bit', '右煲1数据.报警.煲仔机状态异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (781, '右煲仔饭', '82', '1', '1', 'D111-3', 'bit', '右煲2数据.报警.煲仔机状态异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (782, '右煲仔饭', '83', '1', '1', 'D111-4', 'bit', '右煲3数据.报警.煲仔机状态异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (783, '右煲仔饭', '84', '1', '1', 'D111-5', 'bit', '右煲4数据.报警.煲仔机状态异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (784, '右煲仔饭', '85', '1', '1', 'D111-6', 'bit', '右煲5数据.报警.煲仔机状态异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (785, '右煲仔饭', '86', '1', '1', 'D111-7', 'bit', '右煲6数据.报警.煲仔机状态异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (786, '右煲仔饭', '87', '1', '1', 'D111-8', 'bit', '右煲7数据.报警.煲仔机状态异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (787, '右煲仔饭', '88', '1', '1', 'D111-9', 'bit', '右煲8数据.报警.煲仔机状态异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (788, '右煲仔饭', '89', '1', '1', 'D111-10', 'bit', '右煲9数据.报警.煲仔机状态异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (789, '右煲仔饭', '90', '1', '1', 'D111-11', 'bit', '右煲10数据.报警.煲仔机状态异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (790, '右煲仔饭', '91', '1', '1', 'D111-12', 'bit', '右煲11数据.报警.煲仔机状态异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (791, '右煲仔饭', '92', '1', '1', 'D111-13', 'bit', '右煲12数据.报警.煲仔机状态异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (793, '右煲仔饭', '94', '1', '1', 'D111-15', 'bit', '右设备未登录，请检测网络链接。', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (794, '右煲仔饭', '95', '1', '1', 'D113-0', 'bit', '右升降轴数据.报警.轴运动超时报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (795, '右煲仔饭', '96', '1', '1', 'D113-1', 'bit', '右升降轴数据.报警.轴触发限位报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (796, '右煲仔饭', '97', '1', '1', 'D113-2', 'bit', '右升降轴数据.报警.轴回原点超时报警', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (797, '右煲仔饭', '98', '1', '1', 'D113-3', 'bit', '右升降轴数据.报警.上下限位传感器异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (798, '右煲仔饭', '99', '1', '1', 'D113-4', 'bit', '右煲1数据.报警.煲仔机机械臂异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (799, '右煲仔饭', '100', '1', '1', 'D113-5', 'bit', '右煲2数据.报警.煲仔机机械臂异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (800, '右煲仔饭', '101', '1', '1', 'D113-6', 'bit', '右煲3数据.报警.煲仔机机械臂异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (801, '右煲仔饭', '102', '1', '1', 'D113-7', 'bit', '右煲4数据.报警.煲仔机机械臂异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (802, '右煲仔饭', '103', '1', '1', 'D113-8', 'bit', '右煲5数据.报警.煲仔机机械臂异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (803, '右煲仔饭', '104', '1', '1', 'D113-9', 'bit', '右煲6数据.报警.煲仔机机械臂异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (804, '右煲仔饭', '105', '1', '1', 'D113-10', 'bit', '右煲7数据.报警.煲仔机机械臂异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (805, '右煲仔饭', '106', '1', '1', 'D113-11', 'bit', '右煲8数据.报警.煲仔机机械臂异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (806, '右煲仔饭', '107', '1', '1', 'D113-12', 'bit', '右煲9数据.报警.煲仔机机械臂异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (807, '右煲仔饭', '108', '1', '1', 'D113-13', 'bit', '右煲10数据.报警.煲仔机机械臂异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (808, '右煲仔饭', '109', '1', '1', 'D113-14', 'bit', '右煲11数据.报警.煲仔机机械臂异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (809, '右煲仔饭', '110', '1', '1', 'D113-15', 'bit', '右煲12数据.报警.煲仔机机械臂异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (810, '右煲仔饭', '111', '1', '1', 'D127-0', 'bit', '右料桥数据.报警.未感应到气缸动作超时', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (811, '右煲仔饭', '112', '1', '1', 'D127-1', 'bit', '右下单数据.报警.接单未准备', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (812, '右煲仔饭', '113', '1', '1', 'D127-2', 'bit', '右机械臂结构数据.控制.机械臂未进入自动状态（报警）', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (813, '右煲仔饭', '114', '1', '1', 'D127-3', 'bit', '右上盘机数据.报警.盘上升到位感应异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (814, '右煲仔饭', '115', '1', '1', 'D127-4', 'bit', '右上盘机数据.报警.推煲任务号为零', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (815, '右煲仔饭', '116', '1', '1', 'D127-5', 'bit', '右下单数据.报警.下单数据为零', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (816, '右煲仔饭', '117', '1', '1', 'D127-6', 'bit', '右料桥数据.报警.煲工位二运输异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (817, '右煲仔饭', '118', '1', '1', 'D127-7', 'bit', '右料桥数据.报警.取盖到位传感器异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (818, '右煲仔饭', '119', '1', '1', 'D127-8', 'bit', '右上盘机数据.报警.上盘机未准备就绪', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (819, '右煲仔饭', '120', '1', '1', 'D127-9', 'bit', '右上盘机数据.报警.上盘机动作异常', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (820, '右煲仔饭', '121', '1', '1', 'D127-10', 'bit', '右上盘机数据.报警.上盘机检测横移轴未动作', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (821, '右煲仔饭', '122', '1', '1', 'D127-11', 'bit', '右上盘机数据.报警.夹不上盘', NULL, '1');
INSERT INTO `gw_cfg_alarm` VALUES (822, '右煲仔饭', '123', '1', '1', 'D127-12', 'bit', '右料桥数据.报警.机械臂夹煲异常', NULL, '1');

-- ----------------------------
-- Table structure for gw_cfg_call
-- ----------------------------
DROP TABLE IF EXISTS `gw_cfg_call`;
CREATE TABLE `gw_cfg_call`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `config` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `funcode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DataAddr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DataModel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `massge` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `command` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 344 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gw_cfg_call
-- ----------------------------
INSERT INTO `gw_cfg_call` VALUES (4, '1#上菜口', '2', '1', 'D3011', 'short', '点检成功', NULL, '1', 'close_fun');
INSERT INTO `gw_cfg_call` VALUES (5, '1#上菜口', '2', '2', 'D3011', 'short', '点检失败', NULL, '1', 'close_fun');
INSERT INTO `gw_cfg_call` VALUES (7, '1#上菜口', '2', '3', 'D3011', 'short', '点检中', NULL, '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (10, '2#上菜口', '2', '1', 'D3021', 'short', '点检成功', '', '1', 'close_fun');
INSERT INTO `gw_cfg_call` VALUES (11, '单臂炸', '2', '1', 'D2221', 'short', '点检成功', '', '1', 'close_fun');
INSERT INTO `gw_cfg_call` VALUES (12, '下菜口', '2', '1', 'A026', 'short', '点检成功', '', '1', 'close_fun');
INSERT INTO `gw_cfg_call` VALUES (13, '上#冰库', '2', '1', 'D3031', 'short', '点检成功', '', '1', 'close_fun');
INSERT INTO `gw_cfg_call` VALUES (14, '下#冰库', '2', '1', 'D3041', 'short', '点检成功', '', '1', 'close_fun');
INSERT INTO `gw_cfg_call` VALUES (15, '炒锅', '2', '1', 'B003', 'short', '点检成功', '', '1', 'close_fun');
INSERT INTO `gw_cfg_call` VALUES (16, '蛋糕机', '2', '1', 'D4441', 'short', '点检成功', '', '1', 'close_fun');
INSERT INTO `gw_cfg_call` VALUES (17, '奶茶机', '2', '1', 'D1021', 'short', '点检成功', '', '1', 'close_fun');
INSERT INTO `gw_cfg_call` VALUES (18, '物流线', '2', '1', 'D1911', 'short', '点检成功', '', '1', 'close_fun');
INSERT INTO `gw_cfg_call` VALUES (19, '料盒', '2', '1', 'D3031', 'short', '点检成功', '', '1', 'close_fun');
INSERT INTO `gw_cfg_call` VALUES (20, '一代粉面', '2', '1', 'D3031', 'short', '点检成功', '', '1', 'close_fun');
INSERT INTO `gw_cfg_call` VALUES (21, '左煲仔饭', '2', '1', 'D2801', 'short', '点检成功', '', '1', 'close_fun');
INSERT INTO `gw_cfg_call` VALUES (22, '右煲仔饭', '2', '1', 'D2806', 'short', '点检成功', '', '1', 'close_fun');
INSERT INTO `gw_cfg_call` VALUES (23, '2#上菜口', '2', '2', 'D3021', 'short', '点检失败', '', '1', 'close_fun');
INSERT INTO `gw_cfg_call` VALUES (24, '单臂炸', '2', '2', 'D2221', 'short', '点检失败', '', '1', 'close_fun');
INSERT INTO `gw_cfg_call` VALUES (25, '下菜口', '2', '2', 'A026', 'short', '点检失败', '', '1', 'close_fun');
INSERT INTO `gw_cfg_call` VALUES (26, '上#冰库', '2', '2', 'D3031', 'short', '点检失败', '', '1', 'close_fun');
INSERT INTO `gw_cfg_call` VALUES (27, '下#冰库', '2', '2', 'D3041', 'short', '点检失败', '', '1', 'close_fun');
INSERT INTO `gw_cfg_call` VALUES (28, '炒锅', '2', '2', 'B003', 'short', '点检失败', '', '1', 'close_fun');
INSERT INTO `gw_cfg_call` VALUES (29, '蛋糕机', '2', '2', 'D4441', 'short', '点检失败', '', '1', 'close_fun');
INSERT INTO `gw_cfg_call` VALUES (30, '奶茶机', '2', '2', 'D1021', 'short', '点检失败', '', '1', 'close_fun');
INSERT INTO `gw_cfg_call` VALUES (31, '物流线', '2', '2', 'D1911', 'short', '点检失败', '', '1', 'close_fun');
INSERT INTO `gw_cfg_call` VALUES (32, '料盒', '2', '2', 'D3031', 'short', '点检失败', '', '1', 'close_fun');
INSERT INTO `gw_cfg_call` VALUES (33, '一代粉面', '2', '2', 'D3031', 'short', '点检失败', '', '1', 'close_fun');
INSERT INTO `gw_cfg_call` VALUES (34, '左煲仔饭', '2', '2', 'D2801', 'short', '点检失败', '', '1', 'close_fun');
INSERT INTO `gw_cfg_call` VALUES (35, '右煲仔饭', '2', '2', 'D2806', 'short', '点检失败', '', '1', 'close_fun');
INSERT INTO `gw_cfg_call` VALUES (36, '2#上菜口', '2', '3', 'D3021', 'short', '点检中', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (37, '单臂炸', '2', '3', 'D2221', 'short', '点检中', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (38, '下菜口', '2', '3', 'A026', 'short', '点检中', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (39, '上#冰库', '2', '3', 'D3031', 'short', '点检中', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (40, '下#冰库', '2', '3', 'D3041', 'short', '点检中', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (41, '炒锅', '2', '3', 'B003', 'short', '点检中', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (42, '蛋糕机', '2', '3', 'D4441', 'short', '点检中', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (43, '奶茶机', '2', '3', 'D1021', 'short', '点检中', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (44, '物流线', '2', '3', 'D1911', 'short', '点检中', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (45, '料盒', '2', '3', 'D3031', 'short', '点检中', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (46, '一代粉面', '2', '3', 'D3031', 'short', '点检中', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (47, '左煲仔饭', '2', '3', 'D2801', 'short', '点检中', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (48, '右煲仔饭', '2', '3', 'D2806', 'short', '点检中', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (100, '上#冰库', '2', '1', 'D3034-0', 'bit', '点检开始', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (101, '上#冰库', '2', '1', 'D3034-1', 'bit', '送料气缸在原位', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (102, '上#冰库', '2', '1', 'D3034-2', 'bit', '升降平台移动', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (103, '上#冰库', '2', '1', 'D3034-3', 'bit', '送料气缸已到位', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (104, '上#冰库', '2', '1', 'D3034-4', 'bit', '送料电机正转', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (105, '上#冰库', '2', '1', 'D3034-5', 'bit', '横移轴移动中', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (106, '上#冰库', '2', '1', 'D3034-6', 'bit', '出窗口气缸打开到位', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (107, '下#冰库', '2', '1', 'D3044-0', 'bit', '点检开始', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (108, '下#冰库', '2', '1', 'D3044-1', 'bit', '送料气缸在原位', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (109, '下#冰库', '2', '1', 'D3044-2', 'bit', '升降平台移动', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (110, '下#冰库', '2', '1', 'D3044-3', 'bit', '送料气缸已到位', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (111, '下#冰库', '2', '1', 'D3044-4', 'bit', '送料电机正转', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (112, '下#冰库', '2', '1', 'D3044-5', 'bit', '横移轴移动中', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (113, '下#冰库', '2', '1', 'D3044-6', 'bit', '出窗口气缸打开到位', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (200, '1#上菜口', '2', '1', 'D3014-0', 'bit', '点检开始', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (201, '1#上菜口', '2', '1', 'D3014-1', 'bit', '托盘上升到二层', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (202, '1#上菜口', '2', '1', 'D3014-2', 'bit', '二层翻板正转到位', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (203, '1#上菜口', '2', '1', 'D3014-3', 'bit', '托盘到二层接菜位置', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (204, '1#上菜口', '2', '1', 'D3014-4', 'bit', '托盘步进上升', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (205, '1#上菜口', '2', '1', 'D3014-5', 'bit', '托盘上升到顶部', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (206, '1#上菜口', '2', '1', 'D3014-6', 'bit', '开始推盘', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (207, '1#上菜口', '2', '1', 'D3014-7', 'bit', '推盘返回', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (208, '1#上菜口', '2', '1', 'D3014-8', 'bit', '托盘下降', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (209, '1#上菜口', '2', '1', 'D3014-9', 'bit', '托盘下降到位', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (210, '1#上菜口', '2', '1', 'D3014-10', 'bit', '点检完成', '', '1', 'close_fun');
INSERT INTO `gw_cfg_call` VALUES (211, '2#上菜口', '2', '1', 'D3024-0', 'bit', '点检开始', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (212, '2#上菜口', '2', '1', 'D3024-1', 'bit', '托盘上升到二层', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (213, '2#上菜口', '2', '1', 'D3024-2', 'bit', '二层翻板正转到位', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (214, '2#上菜口', '2', '1', 'D3024-3', 'bit', '托盘到二层接菜位置', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (215, '2#上菜口', '2', '1', 'D3024-4', 'bit', '托盘步进上升', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (216, '2#上菜口', '2', '1', 'D3024-5', 'bit', '托盘上升到顶部', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (217, '2#上菜口', '2', '1', 'D3024-6', 'bit', '开始推盘', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (218, '2#上菜口', '2', '1', 'D3024-7', 'bit', '推盘返回', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (219, '2#上菜口', '2', '1', 'D3024-8', 'bit', '托盘下降', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (220, '2#上菜口', '2', '1', 'D3024-9', 'bit', '托盘下降到位', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (221, '2#上菜口', '2', '1', 'D3024-10', 'bit', '点检完成', '', '1', 'close_fun');
INSERT INTO `gw_cfg_call` VALUES (300, '1#人工上菜口', '2', '1', 'D3014-0', 'bit', '点检开始', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (301, '1#人工上菜口', '2', '1', 'D3014-1', 'bit', '托盘步进上升', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (302, '1#人工上菜口', '2', '1', 'D3014-2', 'bit', '托盘上升到顶部', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (303, '1#人工上菜口', '2', '1', 'D3014-3', 'bit', '开始推盘', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (304, '1#人工上菜口', '2', '1', 'D3014-4', 'bit', '推盘返回', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (305, '1#人工上菜口', '2', '1', 'D3014-5', 'bit', '托盘下降', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (306, '1#人工上菜口', '2', '1', 'D3014-6', 'bit', '托盘下降到位', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (307, '1#人工上菜口', '2', '1', 'D3014-7', 'bit', '点检完成', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (308, '2#人工上菜口', '2', '1', 'D3024-0', 'bit', '点检开始', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (309, '2#人工上菜口', '2', '1', 'D3024-1', 'bit', '托盘步进上升', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (310, '2#人工上菜口', '2', '1', 'D3024-2', 'bit', '托盘上升到顶部', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (311, '2#人工上菜口', '2', '1', 'D3024-3', 'bit', '开始推盘', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (312, '2#人工上菜口', '2', '1', 'D3024-4', 'bit', '推盘返回', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (313, '2#人工上菜口', '2', '1', 'D3024-5', 'bit', '托盘下降', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (314, '2#人工上菜口', '2', '1', 'D3024-6', 'bit', '托盘下降到位', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (315, '2#人工上菜口', '2', '1', 'D3024-7', 'bit', '点检完成', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (336, '1#人工上菜口', '2', '1', 'D3011', 'short', '点检成功', '', '1', 'close_fun');
INSERT INTO `gw_cfg_call` VALUES (337, '1#人工上菜口', '2', '2', 'D3011', 'short', '点检失败', '', '1', 'close_fun');
INSERT INTO `gw_cfg_call` VALUES (338, '1#人工上菜口', '2', '3', 'D3011', 'short', '点检中', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (339, '2#人工上菜口', '2', '1', 'D3021', 'short', '点检成功', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (340, '2#人工上菜口', '2', '2', 'D3021', 'short', '点检失败', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (341, '2#人工上菜口', '2', '3', 'D3021', 'short', '点检中', '', '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (342, '新下菜口', '2', '1', 'B003', 'short', '点检成功', NULL, '1', 'close_fun');
INSERT INTO `gw_cfg_call` VALUES (343, '新下菜口', '2', '2', 'B003', 'short', '点检失败', NULL, '1', 'close_fun');
INSERT INTO `gw_cfg_call` VALUES (700, '左煲仔饭', '2', '1', 'D2802-0', 'bit', '检点开始', NULL, '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (701, '左煲仔饭', '2', '1', 'D2802-1', 'bit', '冷库出煲点检', NULL, '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (702, '左煲仔饭', '2', '1', 'D2802-2', 'bit', '取盖位到位检点', NULL, '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (703, '左煲仔饭', '2', '1', 'D2802-3', 'bit', '取盖功能检点 ', NULL, '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (704, '左煲仔饭', '2', '1', 'D2802-4', 'bit', '加水检点', NULL, '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (705, '左煲仔饭', '2', '1', 'D2802-5', 'bit', '取煲位到位检点', NULL, '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (706, '左煲仔饭', '2', '1', 'D2802-6', 'bit', '机械臂放米煲检点', NULL, '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (707, '左煲仔饭', '2', '1', 'D2802-7', 'bit', '料盒到位及机械臂加菜点检', NULL, '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (708, '左煲仔饭', '2', '1', 'D2802-8', 'bit', '机械臂取饭煲点检', NULL, '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (709, '左煲仔饭', '2', '1', 'D2802-9', 'bit', '上盘机送煲点检', NULL, '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (710, '左煲仔饭', '2', '1', 'D2802-10', 'bit', '上盘机点检', NULL, '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (711, '左煲仔饭', '2', '1', 'D2802-11', 'bit', '炉头加热点检', NULL, '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (712, '左煲仔饭', '2', '1', 'D2802-12', 'bit', '点检完成', NULL, '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (713, '右煲仔饭', '2', '1', 'D2807-0', 'bit', '检点开始', NULL, '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (714, '右煲仔饭', '2', '1', 'D2807-1', 'bit', '冷库出煲点检', NULL, '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (715, '右煲仔饭', '2', '1', 'D2807-2', 'bit', '取盖位到位检点', NULL, '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (716, '右煲仔饭', '2', '1', 'D2807-3', 'bit', '取盖功能检点 ', NULL, '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (717, '右煲仔饭', '2', '1', 'D2807-4', 'bit', '加水检点', NULL, '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (718, '右煲仔饭', '2', '1', 'D2807-5', 'bit', '取煲位到位检点', NULL, '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (719, '右煲仔饭', '2', '1', 'D2807-6', 'bit', '机械臂放米煲检点', NULL, '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (720, '右煲仔饭', '2', '1', 'D2807-7', 'bit', '料盒到位及机械臂加菜点检', NULL, '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (721, '右煲仔饭', '2', '1', 'D2807-8', 'bit', '机械臂取饭煲点检', NULL, '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (722, '右煲仔饭', '2', '1', 'D2807-9', 'bit', '上盘机送煲点检', NULL, '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (723, '右煲仔饭', '2', '1', 'D2807-10', 'bit', '上盘机点检', NULL, '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (724, '右煲仔饭', '2', '1', 'D2807-11', 'bit', '炉头加热点检', NULL, '1', 'close');
INSERT INTO `gw_cfg_call` VALUES (725, '右煲仔饭', '2', '1', 'D2807-12', 'bit', '点检完成', NULL, '1', 'close');

-- ----------------------------
-- Table structure for gw_cfg_datamodel
-- ----------------------------
DROP TABLE IF EXISTS `gw_cfg_datamodel`;
CREATE TABLE `gw_cfg_datamodel`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `group` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `index` int NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `datatype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `length` int NULL DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gw_cfg_datamodel
-- ----------------------------
INSERT INTO `gw_cfg_datamodel` VALUES (5, 'order', 1, 'id', 'long', 64, '1');
INSERT INTO `gw_cfg_datamodel` VALUES (6, 'order', 2, '单号', 'short', 16, '1');

-- ----------------------------
-- Table structure for gw_cfg_dev
-- ----------------------------
DROP TABLE IF EXISTS `gw_cfg_dev`;
CREATE TABLE `gw_cfg_dev`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `devid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `protocal` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `port` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `devtype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `endian` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `config` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 90 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gw_cfg_dev
-- ----------------------------
INSERT INTO `gw_cfg_dev` VALUES (5, '4001', '172.28.12.6', 'mc', '8000', '5122', '上菜口', NULL, '1', NULL, '1#上菜口');
INSERT INTO `gw_cfg_dev` VALUES (6, '4002', '172.28.12.6', 'mc', '8000', '5122', '上菜口', '', '1', '', '2#上菜口');
INSERT INTO `gw_cfg_dev` VALUES (7, '4003', '172.28.12.26', 'mc', '8000', '5122', '上菜口', '', '1', '', '1#上菜口');
INSERT INTO `gw_cfg_dev` VALUES (8, '4004', '172.28.12.26', 'mc', '8000', '5122', '上菜口', '', '1', '', '2#上菜口');
INSERT INTO `gw_cfg_dev` VALUES (9, '4005', '172.28.12.46', 'mc', '8000', '5122', '上菜口', '', '1', '', '1#上菜口');
INSERT INTO `gw_cfg_dev` VALUES (10, '4006', '172.28.12.46', 'mc', '8000', '5122', '上菜口', '', '1', '', '2#上菜口');
INSERT INTO `gw_cfg_dev` VALUES (11, '4007', '172.28.12.66', 'mc', '8000', '5122', '上菜口', '', '1', '', '1#上菜口');
INSERT INTO `gw_cfg_dev` VALUES (12, '4008', '172.28.12.66', 'mc', '8000', '5122', '上菜口', '', '1', '', '2#上菜口');
INSERT INTO `gw_cfg_dev` VALUES (13, '4009', '172.28.12.86', 'mc', '8000', '5122', '上菜口', '', '1', '', '1#上菜口');
INSERT INTO `gw_cfg_dev` VALUES (14, '4010', '172.28.12.86', 'mc', '8000', '5122', '上菜口', '', '1', '', '2#上菜口');
INSERT INTO `gw_cfg_dev` VALUES (15, '4601', '172.28.12.103', 'mc', '8000', '5122', '上菜口', '', '1', '', '1#上菜口');
INSERT INTO `gw_cfg_dev` VALUES (16, '4602', '172.28.12.105', 'mc', '8000', '5122', '上菜口', '', '1', '', '1#上菜口');
INSERT INTO `gw_cfg_dev` VALUES (17, '4201', '172.28.12.115', 'mc', '8000', '5122', '人工上菜口', '', '1', '', '1#人工上菜口');
INSERT INTO `gw_cfg_dev` VALUES (18, '4203', '172.28.12.119', 'mc', '8000', '5122', '人工上菜口', '', '1', '', '1#人工上菜口');
INSERT INTO `gw_cfg_dev` VALUES (19, '5821300000000000000', '172.28.10.15', 'mc', '8000', '700', '单臂炸', '', '1', '', '单臂炸');
INSERT INTO `gw_cfg_dev` VALUES (20, '1092', '172.28.12.84', 'mcu', '50000', '4098', '炒锅', '', '1', '', '炒锅');
INSERT INTO `gw_cfg_dev` VALUES (21, '5001', '172.28.13.2', 'mcu', '50000', '5889', '下菜口', '', '1', '', '新下菜口');
INSERT INTO `gw_cfg_dev` VALUES (22, '5002', '172.28.13.3', 'mcu', '50000', '5889', '下菜口', '', '1', '', '新下菜口');
INSERT INTO `gw_cfg_dev` VALUES (23, '5003', '172.28.13.4', 'mcu', '50000', '5889', '下菜口', '', '1', '', '新下菜口');
INSERT INTO `gw_cfg_dev` VALUES (24, '5004', '172.28.13.5', 'mcu', '50000', '5889', '下菜口', '', '1', '', '新下菜口');
INSERT INTO `gw_cfg_dev` VALUES (25, '5005', '172.28.13.6', 'mcu', '50000', '5889', '下菜口', '', '1', '', '新下菜口');
INSERT INTO `gw_cfg_dev` VALUES (26, '5006', '172.28.13.7', 'mcu', '50000', '5889', '下菜口', '', '1', '', '新下菜口');
INSERT INTO `gw_cfg_dev` VALUES (27, '5007', '172.28.13.8', 'mcu', '50000', '5889', '下菜口', '', '1', '', '新下菜口');
INSERT INTO `gw_cfg_dev` VALUES (28, '5008', '172.28.13.9', 'mcu', '50000', '5889', '下菜口', '', '1', '', '新下菜口');
INSERT INTO `gw_cfg_dev` VALUES (29, '5009', '172.28.13.10', 'mcu', '50000', '5889', '下菜口', '', '1', '', '新下菜口');
INSERT INTO `gw_cfg_dev` VALUES (30, '5010', '172.28.13.11', 'mcu', '50000', '5889', '下菜口', '', '1', '', '新下菜口');
INSERT INTO `gw_cfg_dev` VALUES (31, '5011', '172.28.13.12', 'mcu', '50000', '5889', '下菜口', '', '1', '', '新下菜口');
INSERT INTO `gw_cfg_dev` VALUES (32, '5012', '172.28.13.13', 'mcu', '50000', '5889', '下菜口', '', '1', '', '新下菜口');
INSERT INTO `gw_cfg_dev` VALUES (33, '5017', '172.28.13.18', 'mcu', '50000', '5889', '下菜口', '', '1', '', '新下菜口');
INSERT INTO `gw_cfg_dev` VALUES (34, '5018', '172.28.13.19', 'mcu', '50000', '5889', '下菜口', '', '1', '', '新下菜口');
INSERT INTO `gw_cfg_dev` VALUES (35, '5019', '172.28.13.20', 'mcu', '50000', '5889', '下菜口', '', '1', '', '新下菜口');
INSERT INTO `gw_cfg_dev` VALUES (36, '5020', '172.28.13.21', 'mcu', '50000', '5889', '下菜口', '', '1', '', '新下菜口');
INSERT INTO `gw_cfg_dev` VALUES (37, '5021', '172.28.13.22', 'mcu', '50000', '5889', '下菜口', '', '1', '', '新下菜口');
INSERT INTO `gw_cfg_dev` VALUES (38, '5022', '172.28.13.23', 'mcu', '50000', '5889', '下菜口', '', '1', '', '新下菜口');
INSERT INTO `gw_cfg_dev` VALUES (39, '5023', '172.28.13.24', 'mcu', '50000', '5889', '下菜口', '', '1', '', '新下菜口');
INSERT INTO `gw_cfg_dev` VALUES (40, '2011', '172.28.12.8', 'mc', '8003', '4355', '冰库', '', '1', '', '上#冰库');
INSERT INTO `gw_cfg_dev` VALUES (41, '2012', '172.28.12.8', 'mc', '8003', '4355', '冰库', '', '1', '', '下#冰库');
INSERT INTO `gw_cfg_dev` VALUES (42, '2021', '172.28.12.18', 'mc', '8003', '4355', '冰库', '', '1', '', '上#冰库');
INSERT INTO `gw_cfg_dev` VALUES (43, '2022', '172.28.12.18', 'mc', '8003', '4355', '冰库', '', '1', '', '下#冰库');
INSERT INTO `gw_cfg_dev` VALUES (44, '2031', '172.28.12.28', 'mc', '8003', '4355', '冰库', '', '1', '', '上#冰库');
INSERT INTO `gw_cfg_dev` VALUES (45, '2032', '172.28.12.28', 'mc', '8003', '4355', '冰库', '', '1', '', '下#冰库');
INSERT INTO `gw_cfg_dev` VALUES (46, '2041', '172.28.12.38', 'mc', '8003', '4355', '冰库', '', '1', '', '上#冰库');
INSERT INTO `gw_cfg_dev` VALUES (47, '2042', '172.28.12.38', 'mc', '8003', '4355', '冰库', '', '1', '', '下#冰库');
INSERT INTO `gw_cfg_dev` VALUES (48, '2051', '172.28.12.48', 'mc', '8003', '4355', '冰库', '', '1', '', '上#冰库');
INSERT INTO `gw_cfg_dev` VALUES (49, '2052', '172.28.12.48', 'mc', '8003', '4355', '冰库', '', '1', '', '下#冰库');
INSERT INTO `gw_cfg_dev` VALUES (50, '2061', '172.28.12.58', 'mc', '8003', '4355', '冰库', '', '1', '', '上#冰库');
INSERT INTO `gw_cfg_dev` VALUES (51, '2062', '172.28.12.58', 'mc', '8003', '4355', '冰库', '', '1', '', '下#冰库');
INSERT INTO `gw_cfg_dev` VALUES (52, '2071', '172.28.12.68', 'mc', '8003', '4355', '冰库', '', '1', '', '上#冰库');
INSERT INTO `gw_cfg_dev` VALUES (53, '2072', '172.28.12.68', 'mc', '8003', '4355', '冰库', '', '1', '', '下#冰库');
INSERT INTO `gw_cfg_dev` VALUES (54, '2081', '172.28.12.78', 'mc', '8003', '4355', '冰库', '', '1', '', '上#冰库');
INSERT INTO `gw_cfg_dev` VALUES (55, '2082', '172.28.12.78', 'mc', '8003', '4355', '冰库', '', '1', '', '下#冰库');
INSERT INTO `gw_cfg_dev` VALUES (56, '2091', '172.28.12.88', 'mc', '8003', '4355', '冰库', '', '1', '', '上#冰库');
INSERT INTO `gw_cfg_dev` VALUES (57, '2092', '172.28.12.88', 'mc', '8003', '4355', '冰库', '', '1', '', '下#冰库');
INSERT INTO `gw_cfg_dev` VALUES (58, '5013', '172.28.13.14', 'mcu', '50000', '5889', '下菜口', '', '1', '', '下菜口');
INSERT INTO `gw_cfg_dev` VALUES (59, '5014', '172.28.13.15', 'mcu', '50000', '5889', '下菜口', '', '1', '', '新下菜口');
INSERT INTO `gw_cfg_dev` VALUES (60, '5015', '172.28.13.16', 'mcu', '50000', '5889', '下菜口', '', '1', '', '下菜口');
INSERT INTO `gw_cfg_dev` VALUES (61, '5016', '172.28.13.17', 'mcu', '50000', '5889', '下菜口', '', '1', '', '下菜口');
INSERT INTO `gw_cfg_dev` VALUES (62, '1011', '172.28.12.2', 'mcu', '50000', '4098', '炒锅', '', '1', '', '炒锅');
INSERT INTO `gw_cfg_dev` VALUES (63, '1012', '172.28.12.4', 'mcu', '50000', '4098', '炒锅', '', '1', '', '炒锅');
INSERT INTO `gw_cfg_dev` VALUES (64, '1021', '172.28.12.12', 'mcu', '50000', '4098', '炒锅', '', '1', '', '炒锅');
INSERT INTO `gw_cfg_dev` VALUES (65, '1022', '172.28.12.14', 'mcu', '50000', '4098', '炒锅', '', '1', '', '炒锅');
INSERT INTO `gw_cfg_dev` VALUES (66, '1031', '172.28.12.22', 'mcu', '50000', '4098', '炒锅', '', '1', '', '炒锅');
INSERT INTO `gw_cfg_dev` VALUES (67, '1032', '172.28.12.24', 'mcu', '50000', '4098', '炒锅', '', '1', '', '炒锅');
INSERT INTO `gw_cfg_dev` VALUES (68, '1041', '172.28.12.32', 'mcu', '50000', '4098', '炒锅', '', '1', '', '炒锅');
INSERT INTO `gw_cfg_dev` VALUES (69, '1042', '172.28.12.34', 'mcu', '50000', '4098', '炒锅', '', '1', '', '炒锅');
INSERT INTO `gw_cfg_dev` VALUES (70, '1051', '172.28.12.42', 'mcu', '50000', '4098', '炒锅', '', '1', '', '炒锅');
INSERT INTO `gw_cfg_dev` VALUES (71, '1052', '172.28.12.44', 'mcu', '50000', '4098', '炒锅', '', '1', '', '炒锅');
INSERT INTO `gw_cfg_dev` VALUES (72, '1061', '172.28.12.52', 'mcu', '50000', '4098', '炒锅', '', '1', '', '炒锅');
INSERT INTO `gw_cfg_dev` VALUES (73, '1062', '172.28.12.54', 'mcu', '50000', '4098', '炒锅', '', '1', '', '炒锅');
INSERT INTO `gw_cfg_dev` VALUES (74, '1071', '172.28.12.62', 'mcu', '50000', '4098', '炒锅', '', '1', '', '炒锅');
INSERT INTO `gw_cfg_dev` VALUES (75, '1072', '172.28.12.64', 'mcu', '50000', '4098', '炒锅', '', '1', '', '炒锅');
INSERT INTO `gw_cfg_dev` VALUES (76, '1081', '172.28.12.72', 'mcu', '50000', '4098', '炒锅', '', '1', '', '炒锅');
INSERT INTO `gw_cfg_dev` VALUES (77, '1082', '172.28.12.74', 'mcu', '50000', '4098', '炒锅', '', '1', '', '炒锅');
INSERT INTO `gw_cfg_dev` VALUES (78, '1091', '172.28.12.82', 'mcu', '50000', '4098', '炒锅', '', '1', '', '炒锅');
INSERT INTO `gw_cfg_dev` VALUES (79, '1092', '172.28.12.84', 'mcu', '50000', '4098', '炒锅', '', '1', '', '炒锅');
INSERT INTO `gw_cfg_dev` VALUES (80, '1', '172.28.11.2', 'mc', '8000', '4865', '物流线', '', '1', '', '物流线');
INSERT INTO `gw_cfg_dev` VALUES (81, '6721067917451980000', '172.28.10.121', 'mc', '8000', '750', '一代粉面', '', '1', '', '一代粉面');
INSERT INTO `gw_cfg_dev` VALUES (82, '5821300000000000152_1', '172.28.10.10', 'mc', '8001', '721', '蛋糕机', '', '1', '', '蛋糕机');
INSERT INTO `gw_cfg_dev` VALUES (83, '5821300000000000152_2', '172.28.10.2', 'mc', '8001', '721', '奶茶机', '', '1', '', '奶茶机');
INSERT INTO `gw_cfg_dev` VALUES (84, '2603', '172.28.12.109', 'mc', '8003', '4355', '料盒', '', '1', '', '料盒');
INSERT INTO `gw_cfg_dev` VALUES (85, '4202', '172.28.12.115', 'mc', '8000', '5122', '人工上菜口', '', '1', '', '2#人工上菜口');
INSERT INTO `gw_cfg_dev` VALUES (86, '2601', '172.28.12.107', 'mc', '8003', '4355', '冰库', '', '1', '', '上#冰库');
INSERT INTO `gw_cfg_dev` VALUES (87, '2602', '172.28.12.107', 'mc', '8003', '4355', '冰库', '', '1', '', '下#冰库');
INSERT INTO `gw_cfg_dev` VALUES (88, '6001', '172.28.12.100', 'mc', '8000', '6145', '煲仔饭', NULL, '1', NULL, '左煲仔饭');
INSERT INTO `gw_cfg_dev` VALUES (89, '6002', '172.28.12.100', 'mc', '8000', '6145', '煲仔饭', NULL, '1', NULL, '右煲仔饭');

-- ----------------------------
-- Table structure for gw_cfg_function
-- ----------------------------
DROP TABLE IF EXISTS `gw_cfg_function`;
CREATE TABLE `gw_cfg_function`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DataAddr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DataModel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `config` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gw_cfg_function
-- ----------------------------
INSERT INTO `gw_cfg_function` VALUES (6, '1＃上菜口-点检', 'D3010', 'short', '2', '1#上菜口', NULL, '1');
INSERT INTO `gw_cfg_function` VALUES (7, '2＃上菜口-点检', 'D3020', 'short', '2', '2#上菜口', '', '1');
INSERT INTO `gw_cfg_function` VALUES (8, '单臂炸点检', 'D2220-1', 'bit', '2', '单臂炸', '', '1');
INSERT INTO `gw_cfg_function` VALUES (9, '下菜口点检', 'A023', 'short', '2', '下菜口', '', '1');
INSERT INTO `gw_cfg_function` VALUES (10, '上#冰库点检', 'D3030', 'short', '2', '上#冰库', '', '1');
INSERT INTO `gw_cfg_function` VALUES (11, '下#冰库点检', 'D3040', 'short', '2', '下#冰库', '', '1');
INSERT INTO `gw_cfg_function` VALUES (12, '炒锅点检', 'B000', 'byte', '2', '炒锅', '', '1');
INSERT INTO `gw_cfg_function` VALUES (13, '蛋糕机点检', 'D4440', 'short', '2', '蛋糕机', '', '1');
INSERT INTO `gw_cfg_function` VALUES (14, '奶茶机点检', 'D1020', 'short', '2', '奶茶机', '', '1');
INSERT INTO `gw_cfg_function` VALUES (15, '物流线', 'D1910', 'short', '2', '物流线', '', '1');
INSERT INTO `gw_cfg_function` VALUES (16, '料盒点检', 'D3030', 'short', '2', '料盒', '', '1');
INSERT INTO `gw_cfg_function` VALUES (17, '料盒点检', 'D3030', 'short', '2', '一代粉面', '', '1');
INSERT INTO `gw_cfg_function` VALUES (18, '煲仔饭', 'D2800', 'short', '2', '左煲仔饭', NULL, '1');
INSERT INTO `gw_cfg_function` VALUES (19, '煲仔饭', 'D2805', 'short', '2', '右煲仔饭', NULL, '1');
INSERT INTO `gw_cfg_function` VALUES (20, '新下菜口点检', 'B000', 'short', '2', '新下菜口', NULL, '1');

-- ----------------------------
-- Table structure for gw_cfg_ioinfo
-- ----------------------------
DROP TABLE IF EXISTS `gw_cfg_ioinfo`;
CREATE TABLE `gw_cfg_ioinfo`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `config` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parentName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `estimateName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DataAddr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DataModel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 313 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gw_cfg_ioinfo
-- ----------------------------
INSERT INTO `gw_cfg_ioinfo` VALUES (200, '新下菜口', '2', '下菜口', '顶端接近开关1（磁性）', '0300-2', 'byte', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (201, '新下菜口', '2', '下菜口', '顶端接近开关2（磁性）', '0300-3', 'byte', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (202, '新下菜口', '2', '下菜口', '绳子开关1（微动）', '0300-4', 'byte', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (203, '新下菜口', '2', '下菜口', '绳子开关2（微动）', '0300-5', 'byte', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (204, '新下菜口', '2', '下菜口', '推杆开关1（凹槽光电）', '0300-6', 'byte', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (205, '新下菜口', '2', '下菜口', '推杆开关2（凹槽光电）', '0300-7', 'byte', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (206, '新下菜口', '2', '下菜口', '推杆开关3（凹槽光电）', '0300-8', 'byte', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (207, '新下菜口', '2', '下菜口', '盘子检测（对射）', '0300-9', 'byte', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (208, '新下菜口', '2', '下菜口', '花瓣打开检测（对射）', '0300-10', 'byte', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (209, '新下菜口', '2', '下菜口', '拉绳电机报警', '0300-11', 'byte', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (210, '新下菜口', '2', '下菜口', '推杆电机报警', '0300-12', 'byte', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (211, '新下菜口', '2', '下菜口', '档杆闭合传感器', '0300-13', 'byte', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (212, '新下菜口', '2', '下菜口', '档杆张开传感器', '0300-14', 'byte', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (213, '新下菜口', '2', '下菜口', '电池电压（mv）', 'A021-0', 'short', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (300, '炒锅', '2', '炒锅', '流量汁信息输出', '0300-0', 'byte', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (301, '炒锅', '2', '炒锅', '油液位报警', '0300-1', 'byte', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (302, '炒锅', '2', '炒锅', '料爪位感应器', '0300-8', 'byte', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (303, '炒锅', '2', '炒锅', '料爪上限', '0300-9', 'byte', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (304, '炒锅', '2', '炒锅', '料爪下限', '0300-10', 'byte', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (305, '炒锅', '2', '炒锅', '平移位感应器', '0300-12', 'byte', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (306, '炒锅', '2', '炒锅', '平移位出料感应器', '0300-13', 'byte', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (307, '炒锅', '2', '炒锅', '升降气缸上限', '0300-14', 'byte', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (308, '炒锅', '2', '炒锅', '升降气缸下限', '0300-15', 'byte', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (309, '炒锅', '2', '炒锅', '丢料盒完成感应器', '0300-16', 'byte', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (310, '炒锅', '2', '炒锅', '洗锅位置（下端）', '0300-19', 'byte', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (311, '炒锅', '2', '炒锅', '洗锅位置（中间）', '0300-20', 'byte', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (312, '炒锅', '2', '炒锅', '洗锅位置（上端）', '0300-21', 'byte', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (400, '1#上菜口', '2', '上菜口', '1#急停', 'X0', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (401, '1#上菜口', '2', '上菜口', '1#上菜口底部行程开关（原点）', 'X1', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (404, '1#上菜口', '2', '上菜口', '1#顶部绳子编码器检测感应', 'X4', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (405, '2#上菜口', '2', '上菜口', '2#顶部绳子编码器检测感应', 'X5', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (406, '1#上菜口', '2', '上菜口', '1#推盘步进报警信号', 'X6', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (407, '1#上菜口', '2', '上菜口', '1#升降步进电机报警信号', 'X7', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (408, '1#上菜口', '2', '上菜口', '1#启动按钮', 'X10', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (409, '1#上菜口', '2', '上菜口', '1#触摸屏小急停', 'X11', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (410, '2#上菜口', '2', '上菜口', '2#触摸屏小急停', 'X12', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (411, '2#上菜口', '2', '上菜口', '2#推盘步进报警信号', 'X13', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (412, '2#上菜口', '2', '上菜口', '2#升降步进电机报警信号', 'X14', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (413, '2#上菜口', '2', '上菜口', '2#启动按钮', 'X15', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (414, '2#上菜口', '2', '上菜口', '2#急停', 'X16', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (415, '2#上菜口', '2', '上菜口', '2#上菜口底部行程开关（原点）', 'X17', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (416, '1#上菜口', '2', '上菜口', '1#上菜口底部有盘感应', 'X200', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (417, '1#上菜口', '2', '上菜口', '1#上菜口顶部行程开关', 'X201', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (418, '1#上菜口', '2', '上菜口', '1#上菜口顶部有盘感应', 'X202', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (419, '1#上菜口', '2', '上菜口', '1#上菜口顶部拨菜机构原点感应', 'X203', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (420, '1#上菜口', '2', '上菜口', '1#上菜口顶部拨菜机构到位感应', 'X204', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (422, '1#上菜口', '2', '上菜口', '1#二层直流电机正转到位', 'X206', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (423, '1#上菜口', '2', '上菜口', '1#二层直流电机反转原位', 'X207', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (425, '1#上菜口', '2', '上菜口', '1#二层有盘感应', 'X211', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (426, '1#上菜口', '2', '上菜口', '1#上菜口顶部拨菜机构蒸笼到位感应', 'X212', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (428, '1#上菜口', '2', '上菜口', '1#下降限位', 'X214', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (429, '1#上菜口', '2', '上菜口', '1#上升限位', 'X215', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (430, '1#上菜口', '2', '上菜口', '1#二层行程开关', 'X216', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (432, '2#上菜口', '2', '上菜口', '2#上菜口底部有盘感应', 'X240', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (433, '2#上菜口', '2', '上菜口', '2#上菜口顶部行程开关', 'X241', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (434, '2#上菜口', '2', '上菜口', '2#上菜口顶部有盘感应', 'X242', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (435, '2#上菜口', '2', '上菜口', '2#上菜口顶部拨菜机构原点感应', 'X243', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (436, '2#上菜口', '2', '上菜口', '2#上菜口顶部拨菜机构到位感应', 'X244', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (438, '2#上菜口', '2', '上菜口', '2#二层直流电机正转到位', 'X246', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (439, '2#上菜口', '2', '上菜口', '2#二层直流电机反转原位', 'X247', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (441, '2#上菜口', '2', '上菜口', '2#二层有盘感应', 'X251', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (442, '2#上菜口', '2', '上菜口', '2#上菜口顶部拨菜机构蒸笼到位感应', 'X252', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (444, '2#上菜口', '2', '上菜口', '2#下降限位', 'X254', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (445, '2#上菜口', '2', '上菜口', '2#上升限位', 'X255', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (446, '2#上菜口', '2', '上菜口', '2#二层行程开关', 'X256', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (447, '1#上菜口', '2', '上菜口', '1#升降步进脉冲', 'Y0', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (448, '2#上菜口', '2', '上菜口', '2#升降步进脉冲', 'Y1', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (449, '1#上菜口', '2', '上菜口', '1#推盘步进脉冲', 'Y2', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (450, '2#上菜口', '2', '上菜口', '2#推盘步进脉冲', 'Y3', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (451, '1#上菜口', '2', '上菜口', '1#升降步进方向', 'Y4', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (453, '1#上菜口', '2', '上菜口', '1#推盘步进方向', 'Y6', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (454, '2#上菜口', '2', '上菜口', '2#推盘步进方向', 'Y7', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (455, '1#上菜口', '2', '上菜口', '1#升降步进刹车', 'Y10', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (456, '2#上菜口', '2', '上菜口', '2#升降步进刹车', 'Y11', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (461, '2#上菜口', '2', '上菜口', '2#升降步进方向', 'Y16', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (466, '1#上菜口', '2', '上菜口', '1#上菜口顶部电磁铁', 'Y223', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (467, '1#上菜口', '2', '上菜口', '1#上菜口底部电磁铁', 'Y224', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (468, '1#上菜口', '2', '上菜口', '1#蜂鸣器', 'Y225', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (469, '1#上菜口', '2', '上菜口', '1#二层直流电机正转', 'Y226', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (470, '1#上菜口', '2', '上菜口', '1#二层直流电机反转', 'Y227', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (482, '2#上菜口', '2', '上菜口', '2#上菜口顶部电磁铁', 'Y263', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (483, '2#上菜口', '2', '上菜口', '2#上菜口底部电磁铁', 'Y264', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (484, '2#上菜口', '2', '上菜口', '2#蜂鸣器', 'Y265', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (485, '2#上菜口', '2', '上菜口', '2#二层直流电机正转', 'Y266', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (486, '2#上菜口', '2', '上菜口', '2#二层直流电机反转', 'Y267', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (487, '1#人工上菜口', '2', '上菜口', '1#急停', 'X0', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (488, '1#人工上菜口', '2', '上菜口', '1#上菜口底部行程开关（原点）', 'X1', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (489, '1#人工上菜口', '2', '上菜口', '1#上菜口底部有盘感应', 'X2', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (490, '1#人工上菜口', '2', '上菜口', '1#上菜口顶部行程开关', 'X3', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (491, '1#人工上菜口', '2', '上菜口', '1#上菜口顶部有盘感应(替换X12)', 'X4', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (492, '1#人工上菜口', '2', '上菜口', '1#上菜口顶部拨菜机构原点感应(替换X15)', 'X5', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (493, '1#人工上菜口', '2', '上菜口', '1#上菜口顶部拨菜机构到位感应', 'X6', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (494, '1#人工上菜口', '2', '上菜口', '1#升降步进电机报警信号', 'X7', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (495, '1#人工上菜口', '2', '上菜口', '1#启动按钮', 'X10', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (496, '1#人工上菜口', '2', '上菜口', '1#上菜口顶部拨菜机构蒸笼到位感应', 'X11', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (497, '1#人工上菜口', '2', '上菜口', '1#顶部绳子编码器检测感应(替换X4)', 'X12', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (498, '1#人工上菜口', '2', '上菜口', '1#下降限位', 'X13', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (499, '1#人工上菜口', '2', '上菜口', '1#上升限位', 'X14', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (500, '2#人工上菜口', '2', '上菜口', '2#顶部绳子编码器检测感应(替换X5)', 'X15', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (501, '2#人工上菜口', '2', '上菜口', '2#急停', 'X16', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (502, '2#人工上菜口', '2', '上菜口', '2#上菜口底部行程开关（原点）', 'X17', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (503, '2#人工上菜口', '2', '上菜口', '2#上菜口底部有盘感应', 'X20', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (504, '2#人工上菜口', '2', '上菜口', '2#上菜口顶部行程开关', 'X21', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (505, '2#人工上菜口', '2', '上菜口', '2#上菜口顶部有盘感应', 'X22', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (506, '2#人工上菜口', '2', '上菜口', '2#上菜口顶部拨菜机构原点感应', 'X23', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (507, '2#人工上菜口', '2', '上菜口', '2#上菜口顶部拨菜机构到位感应', 'X24', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (508, '2#人工上菜口', '2', '上菜口', '2#升降步进电机报警信号', 'X25', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (509, '2#人工上菜口', '2', '上菜口', '2#启动按钮', 'X26', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (510, '2#人工上菜口', '2', '上菜口', '2#上菜口顶部拨菜机构蒸笼到位感应', 'X27', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (512, '2#人工上菜口', '2', '上菜口', '2#下降限位', 'X31', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (513, '2#人工上菜口', '2', '上菜口', '2#上升限位', 'X32', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (514, '1#人工上菜口', '2', '上菜口', '1#推盘步进报警信号', 'X33', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (515, '2#人工上菜口', '2', '上菜口', '2#推盘步进报警信号', 'X34', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (517, '1#人工上菜口', '2', '上菜口', '1#触摸屏小急停', 'X36', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (519, '1#人工上菜口', '2', '上菜口', '1#升降步进脉冲', 'Y0', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (520, '2#人工上菜口', '2', '上菜口', '2#升降步进脉冲', 'Y1', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (521, '1#人工上菜口', '2', '上菜口', '1#推盘步进脉冲', 'Y2', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (522, '2#人工上菜口', '2', '上菜口', '2#推盘步进脉冲', 'Y3', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (523, '1#人工上菜口', '2', '上菜口', '1#升降步进方向', 'Y4', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (524, '1#人工上菜口', '2', '上菜口', '1#升降步进刹车', 'Y5', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (525, '1#人工上菜口', '2', '上菜口', '1#推盘步进方向', 'Y6', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (526, '2#人工上菜口', '2', '上菜口', '2#推盘步进方向', 'Y7', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (527, '1#人工上菜口', '2', '上菜口', '1#上菜口顶部电磁铁', 'Y10', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (528, '1#人工上菜口', '2', '上菜口', '1#上菜口底部电磁铁', 'Y11', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (529, '1#人工上菜口', '2', '上菜口', '1#蜂鸣器', 'Y12', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (533, '2#人工上菜口', '2', '上菜口', '2#升降步进方向', 'Y16', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (534, '2#人工上菜口', '2', '上菜口', '2#升降步进刹车', 'Y17', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (537, '2#人工上菜口', '2', '上菜口', '2#上菜口顶部电磁铁', 'Y22', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (538, '2#人工上菜口', '2', '上菜口', '2#上菜口底部电磁铁', 'Y23', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (539, '2#人工上菜口', '2', '上菜口', '2#蜂鸣器', 'Y24', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (600, '上#冰库', '2', '冰库', '1#急停', 'X0', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (601, '上#冰库', '2', '冰库', '1#Z轴原点信号', 'X3', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (602, '上#冰库', '2', '冰库', '1#移栽轴原点信号', 'X4', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (603, '上#冰库', '2', '冰库', '2#Z轴原点信号', 'X5', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (604, '下#冰库', '2', '冰库', '2#移栽轴原点信号', 'X6', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (605, '上#冰库', '2', '冰库', '1#Z轴正极限', 'X7', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (606, '上#冰库', '2', '冰库', '1#Z轴负极限', 'X10', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (607, '上#冰库', '2', '冰库', '1#移栽轴正极限', 'X11', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (608, '上#冰库', '2', '冰库', '1#移栽轴负极限', 'X12', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (609, '下#冰库', '2', '冰库', '2#Z轴正极限', 'X13', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (610, '下#冰库', '2', '冰库', '2#Z轴负极限', 'X14', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (611, '下#冰库', '2', '冰库', '2#移栽轴正极限', 'X15', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (612, '下#冰库', '2', '冰库', '2#移栽轴负极限', 'X16', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (613, '上#冰库', '2', '冰库', '1#送料气缸原位', 'X17', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (614, '上#冰库', '2', '冰库', '1#送料气缸到位', 'X20', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (615, '下#冰库', '2', '冰库', '2#送料气缸原位', 'X21', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (616, '下#冰库', '2', '冰库', '2#送料气缸到位', 'X22', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (617, '上#冰库', '2', '冰库', '1#Z轴伺服报警', 'X23', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (618, '下#冰库', '2', '冰库', '2#Z轴伺服报警', 'X24', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (619, '上#冰库', '2', '冰库', '1#升降机料盒检测1', 'X25', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (620, '上#冰库', '2', '冰库', '1#升降机料盒检测2', 'X26', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (621, '上#冰库', '2', '冰库', '1#升降机料盒检测3', 'X27', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (622, '上#冰库', '2', '冰库', '1#升降机料盒检测4', 'X30', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (623, '上#冰库', '2', '冰库', '1#升降机料盒检测5', 'X31', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (624, '下#冰库', '2', '冰库', '2#升降机料盒检测1', 'X32', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (625, '下#冰库', '2', '冰库', '2#升降机料盒检测2', 'X33', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (626, '下#冰库', '2', '冰库', '2#升降机料盒检测3', 'X34', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (627, '下#冰库', '2', '冰库', '2#升降机料盒检测4', 'X35', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (628, '下#冰库', '2', '冰库', '2#升降机料盒检测5', 'X36', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (629, '上#冰库', '2', '冰库', '1#料盒升降机到位检测1', 'X37', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (630, '上#冰库', '2', '冰库', '1#料盒升降机到位检测2', 'X40', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (631, '上#冰库', '2', '冰库', '2#料盒升降机到位检测1', 'X41', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (632, '上#冰库', '2', '冰库', '2#料盒升降机到位检测2', 'X42', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (633, '上#冰库', '2', '冰库', '1#出料窗口气缸到位', 'X43', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (634, '下#冰库', '2', '冰库', '2#出料窗口气缸到位', 'X44', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (635, '下#冰库', '2', '冰库', '2#急停', 'X45', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (636, '上#冰库', '2', '冰库', '1#平移轴步进报警', 'X46', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (637, '下#冰库', '2', '冰库', '2#平移轴步进报警', 'X47', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (638, '上#冰库', '2', '冰库', '1#Z轴脉冲输出', 'Y0', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (639, '上#冰库', '2', '冰库', '1#移栽轴脉冲输出', 'Y1', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (640, '下#冰库', '2', '冰库', '2#Z轴脉冲输出', 'Y2', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (641, '下#冰库', '2', '冰库', '2#移栽轴脉冲输出', 'Y3', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (642, '上#冰库', '2', '冰库', '1#Z轴脉冲方向', 'Y4', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (643, '上#冰库', '2', '冰库', '1#移栽轴脉冲方向', 'Y5', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (644, '下#冰库', '2', '冰库', '2#Z轴脉冲方向', 'Y6', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (645, '上#冰库', '2', '冰库', '2#移栽轴脉冲方向', 'Y7', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (646, '上#冰库', '2', '冰库', '1#Z轴伺服报警复位', 'Y10', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (647, '下#冰库', '2', '冰库', '2#Z轴伺服报警复位', 'Y11', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (648, '上#冰库', '2', '冰库', '备用', 'Y12', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (649, '上#冰库', '2', '冰库', '1#送料电机正转', 'Y13', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (650, '上#冰库', '2', '冰库', '1#送料电机反转', 'Y14', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (651, '下#冰库', '2', '冰库', '2#送料电机正转', 'Y15', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (652, '下#冰库', '2', '冰库', '2#送料电机反转', 'Y16', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (653, '上#冰库', '2', '冰库', '1#Z轴伺服开启', 'Y17', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (654, '下#冰库', '2', '冰库', '2#Z轴伺服开启', 'Y20', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (655, '上#冰库', '2', '冰库', '1#送料气缸', 'Y21', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (656, '下#冰库', '2', '冰库', '2#送料气缸', 'Y22', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (657, '上#冰库', '2', '冰库', '备用', 'Y23', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (658, '上#冰库', '2', '冰库', '1#Z轴手动松刹车', 'Y24', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (659, '下#冰库', '2', '冰库', '2#Z轴手动松刹车', 'Y25', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (660, '上#冰库', '2', '冰库', '1#出料窗口气缸', 'Y26', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (661, '下#冰库', '2', '冰库', '2#出料窗口气缸', 'Y27', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (700, '左煲仔饭', '2', '煲仔饭', '急停', 'X20', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (702, '右煲仔饭', '2', '煲仔饭', '右加水计量', 'X1', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (703, '右煲仔饭', '2', '煲仔饭', '右夹盘气缸夹紧感应', 'X30', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (704, '右煲仔饭', '2', '煲仔饭', '右夹盘气缸升降上限', 'X33', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (705, '右煲仔饭', '2', '煲仔饭', '右夹盘气缸升降下限', 'X32', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (706, '右煲仔饭', '2', '煲仔饭', '右夹盘气缸松开感应', 'X31', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (707, '右煲仔饭', '2', '煲仔饭', '右皮带出煲到位', 'X26', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (708, '右煲仔饭', '2', '煲仔饭', '右皮带出料盒到位', 'X27', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (709, '右煲仔饭', '2', '煲仔饭', '右取煲盖到位光电', 'X22', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (710, '右煲仔饭', '2', '煲仔饭', '右取煲盖气缸上限', 'X23', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (711, '右煲仔饭', '2', '煲仔饭', '右取煲盖气缸下限', 'X24', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (712, '右煲仔饭', '2', '煲仔饭', '右去煲盖吸起感应', 'X25', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (713, '右煲仔饭', '2', '煲仔饭', '右推盘步进后限', 'X37', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (714, '右煲仔饭', '2', '煲仔饭', '右推盘步进前限', 'X39', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (715, '右煲仔饭', '2', '煲仔饭', '右推盘步进原点', 'X38', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (716, '右煲仔饭', '2', '煲仔饭', '右托盘步进升降上限', 'X36', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (717, '右煲仔饭', '2', '煲仔饭', '右托盘步进升降下限', 'X34', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (718, '右煲仔饭', '2', '煲仔饭', '右托盘步进升降原点', 'X35', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (719, '右煲仔饭', '2', '煲仔饭', '右托盘顶升到位', 'X29', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (720, '右煲仔饭', '2', '煲仔饭', '右有托盘感应光电', 'X28', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (721, '左煲仔饭', '2', '煲仔饭', '左加水计量', 'X0', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (722, '左煲仔饭', '2', '煲仔饭', '左夹盘气缸夹紧感应', 'X10', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (723, '左煲仔饭', '2', '煲仔饭', '左夹盘气缸升降上限', 'X13', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (724, '左煲仔饭', '2', '煲仔饭', '左夹盘气缸升降下限', 'X12', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (725, '左煲仔饭', '2', '煲仔饭', '左夹盘气缸松开感应', 'X11', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (726, '左煲仔饭', '2', '煲仔饭', '左皮带出煲到位', 'X6', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (727, '左煲仔饭', '2', '煲仔饭', '左皮带出料盒到位', 'X7', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (728, '左煲仔饭', '2', '煲仔饭', '左取煲盖到位光电', 'X2', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (729, '左煲仔饭', '2', '煲仔饭', '左取煲盖气缸上限', 'X3', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (730, '左煲仔饭', '2', '煲仔饭', '左取煲盖气缸下限', 'X4', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (731, '左煲仔饭', '2', '煲仔饭', '左去煲盖吸起感应', 'X5', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (732, '左煲仔饭', '2', '煲仔饭', '左推盘步进后限', 'X17', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (733, '左煲仔饭', '2', '煲仔饭', '左推盘步进前限', 'X19', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (734, '左煲仔饭', '2', '煲仔饭', '左推盘步进原点', 'X18', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (735, '左煲仔饭', '2', '煲仔饭', '左托盘步进升降上限', 'X16', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (736, '左煲仔饭', '2', '煲仔饭', '左托盘步进升降下限', 'X14', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (737, '左煲仔饭', '2', '煲仔饭', '左托盘步进升降原点', 'X15', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (738, '左煲仔饭', '2', '煲仔饭', '左托盘顶升到位', 'X9', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (739, '左煲仔饭', '2', '煲仔饭', '左有托盘感应光电', 'X8', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (740, '右煲仔饭', '2', '煲仔饭', '右煲仔皮带', 'Y28', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (741, '右煲仔饭', '2', '煲仔饭', '右臂开始程序中继', 'Y37', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (742, '右煲仔饭', '2', '煲仔饭', '右臂停止程序中继', 'Y38', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (743, '右煲仔饭', '2', '煲仔饭', '右臂远程开机上电中继', 'Y36', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (744, '右煲仔饭', '2', '煲仔饭', '右加水阀', 'Y30', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (745, '右煲仔饭', '2', '煲仔饭', '右加油阀', 'Y31', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (746, '右煲仔饭', '2', '煲仔饭', '右夹盘气缸紧电磁阀', 'Y25', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (747, '右煲仔饭', '2', '煲仔饭', '右夹盘气缸松电磁阀', 'Y26', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (748, '右煲仔饭', '2', '煲仔饭', '右夹盘升降方向', 'Y6', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (749, '右煲仔饭', '2', '煲仔饭', '右夹盘升降脉冲', 'Y2', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (750, '右煲仔饭', '2', '煲仔饭', '右夹盘升降气缸阀', 'Y27', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (751, '右煲仔饭', '2', '煲仔饭', '右料盒皮带', 'Y29', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (752, '右煲仔饭', '2', '煲仔饭', '右取煲盖上电磁阀', 'Y22', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (753, '右煲仔饭', '2', '煲仔饭', '右取煲盖下电磁阀', 'Y23', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (754, '右煲仔饭', '2', '煲仔饭', '右取煲盖真空阀', 'Y24', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (755, '右煲仔饭', '2', '煲仔饭', '右升降刹车SR2', 'Y21', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (756, '右煲仔饭', '2', '煲仔饭', '右推盘方向', 'Y7', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (757, '右煲仔饭', '2', '煲仔饭', '右推盘脉冲', 'Y3', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (758, '左煲仔饭', '2', '煲仔饭', '指示灯红灯', 'Y20', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (759, '左煲仔饭', '2', '煲仔饭', '指示灯绿灯', 'Y8', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (760, '左煲仔饭', '2', '煲仔饭', '指示蜂鸣器', 'Y35', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (761, '左煲仔饭', '2', '煲仔饭', '左煲仔皮带', 'Y16', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (762, '左煲仔饭', '2', '煲仔饭', '左臂开始程序中继', 'Y33', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (763, '左煲仔饭', '2', '煲仔饭', '左臂停止程序中继', 'Y34', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (764, '左煲仔饭', '2', '煲仔饭', '左臂远程开机上电中继', 'Y32', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (765, '左煲仔饭', '2', '煲仔饭', '左加水阀', 'Y18', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (766, '左煲仔饭', '2', '煲仔饭', '左加油阀', 'Y19', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (767, '左煲仔饭', '2', '煲仔饭', '左夹盘气缸紧电磁阀', 'Y13', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (768, '左煲仔饭', '2', '煲仔饭', '左夹盘气缸松电磁阀', 'Y14', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (769, '左煲仔饭', '2', '煲仔饭', '左夹盘升降方向', 'Y4', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (770, '左煲仔饭', '2', '煲仔饭', '左夹盘升降脉冲', 'Y0', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (771, '左煲仔饭', '2', '煲仔饭', '左夹盘升降气缸阀', 'Y15', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (772, '左煲仔饭', '2', '煲仔饭', '左料盒皮带', 'Y17', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (773, '左煲仔饭', '2', '煲仔饭', '左取煲盖上电磁阀', 'Y10', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (774, '左煲仔饭', '2', '煲仔饭', '左取煲盖下电磁阀', 'Y11', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (775, '左煲仔饭', '2', '煲仔饭', '左取煲盖真空阀', 'Y12', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (776, '左煲仔饭', '2', '煲仔饭', '左升降刹车SR1', 'Y9', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (777, '左煲仔饭', '2', '煲仔饭', '左推盘方向', 'Y5', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (778, '左煲仔饭', '2', '煲仔饭', '左推盘脉冲', 'Y1', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (800, '物流线', '2', '物流线', 'B08前挡上到位', 'X1000', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (801, '物流线', '2', '物流线', 'B08前挡下到位', 'X1001', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (802, '物流线', '2', '物流线', 'B08后挡上到位', 'X1002', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (803, '物流线', '2', '物流线', 'B08后挡下到位 ', 'X1003', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (804, '物流线', '2', '物流线', 'B08推菜块推出到位', 'X1004', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (805, '物流线', '2', '物流线', 'B08推菜块缩回到位', 'X1005', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (806, '物流线', '2', '物流线', 'B08工位餐盘感应', 'X1006', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (807, '物流线', '2', '物流线', 'B08滑道餐盘感应', 'X1007', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (808, '物流线', '2', '物流线', 'B06前挡上到位', 'X1010', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (809, '物流线', '2', '物流线', 'B06前挡下到位', 'X1011', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (810, '物流线', '2', '物流线', 'B06后挡上到位', 'X1012', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (811, '物流线', '2', '物流线', 'B06后挡下到位 ', 'X1013', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (812, '物流线', '2', '物流线', 'B06推菜块推出到位', 'X1014', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (813, '物流线', '2', '物流线', 'B06推菜块缩回到位', 'X1015', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (814, '物流线', '2', '物流线', 'B06工位餐盘感应', 'X1016', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (815, '物流线', '2', '物流线', 'B06滑道餐盘感应', 'X1017', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (816, '物流线', '2', '物流线', 'B05前挡上到位', 'X1040', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (817, '物流线', '2', '物流线', 'B05前挡下到位', 'X1041', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (818, '物流线', '2', '物流线', 'B05后挡上到位', 'X1042', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (819, '物流线', '2', '物流线', 'B05后挡下到位 ', 'X1043', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (820, '物流线', '2', '物流线', 'B05推菜块推出到位', 'X1044', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (821, '物流线', '2', '物流线', 'B05推菜块缩回到位', 'X1045', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (822, '物流线', '2', '物流线', 'B05工位餐盘感应', 'X1046', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (823, '物流线', '2', '物流线', 'B05滑道餐盘感应', 'X1047', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (824, '物流线', '2', '物流线', 'B03前挡上到位', 'X1050', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (825, '物流线', '2', '物流线', 'B03前挡下到位', 'X1051', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (826, '物流线', '2', '物流线', 'B03后挡上到位', 'X1052', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (827, '物流线', '2', '物流线', 'B03后挡下到位 ', 'X1053', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (828, '物流线', '2', '物流线', 'B03推菜块推出到位', 'X1054', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (829, '物流线', '2', '物流线', 'B03推菜块缩回到位', 'X1055', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (830, '物流线', '2', '物流线', 'B03工位餐盘感应', 'X1056', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (831, '物流线', '2', '物流线', 'B03滑道餐盘感应', 'X1057', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (832, '物流线', '2', '物流线', 'B02前挡上到位', 'X1100', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (833, '物流线', '2', '物流线', 'B02前挡下到位', 'X1101', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (834, '物流线', '2', '物流线', 'B02后挡上到位', 'X1102', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (835, '物流线', '2', '物流线', 'B02后挡下到位 ', 'X1103', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (836, '物流线', '2', '物流线', 'B02推菜块推出到位', 'X1104', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (837, '物流线', '2', '物流线', 'B02推菜块缩回到位', 'X1105', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (838, '物流线', '2', '物流线', 'B02工位餐盘感应', 'X1106', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (839, '物流线', '2', '物流线', 'B02滑道餐盘感应', 'X1107', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (840, '物流线', '2', '物流线', 'B01前挡上到位', 'X1110', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (841, '物流线', '2', '物流线', 'B01前挡下到位', 'X1111', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (842, '物流线', '2', '物流线', 'B01后挡上到位', 'X1112', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (843, '物流线', '2', '物流线', 'B01后挡下到位 ', 'X1113', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (844, '物流线', '2', '物流线', 'B01推菜块推出到位', 'X1114', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (845, '物流线', '2', '物流线', 'B01推菜块缩回到位', 'X1115', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (846, '物流线', '2', '物流线', 'B01工位餐盘感应', 'X1116', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (847, '物流线', '2', '物流线', 'B01滑道餐盘感应', 'X1117', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (848, '物流线', '2', '物流线', 'B15前挡上到位', 'X1140', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (849, '物流线', '2', '物流线', 'B15前挡下到位', 'X1141', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (850, '物流线', '2', '物流线', 'B15后挡上到位', 'X1142', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (851, '物流线', '2', '物流线', 'B15后挡下到位 ', 'X1143', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (852, '物流线', '2', '物流线', 'B15推菜块推出到位', 'X1144', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (853, '物流线', '2', '物流线', 'B15推菜块缩回到位', 'X1145', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (854, '物流线', '2', '物流线', 'B15工位餐盘感应', 'X1146', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (855, '物流线', '2', '物流线', 'B15滑道餐盘感应', 'X1147', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (856, '物流线', '2', '物流线', 'B13前挡上到位', 'X1150', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (857, '物流线', '2', '物流线', 'B13前挡下到位', 'X1151', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (858, '物流线', '2', '物流线', 'B13后挡上到位', 'X1152', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (859, '物流线', '2', '物流线', 'B13后挡下到位 ', 'X1153', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (860, '物流线', '2', '物流线', 'B13推菜块推出到位', 'X1154', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (861, '物流线', '2', '物流线', 'B13推菜块缩回到位', 'X1155', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (862, '物流线', '2', '物流线', 'B13工位餐盘感应', 'X1156', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (863, '物流线', '2', '物流线', 'B13滑道餐盘感应', 'X1157', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (864, '物流线', '2', '物流线', 'B12前挡上到位', 'X1200', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (865, '物流线', '2', '物流线', 'B12前挡下到位', 'X1201', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (866, '物流线', '2', '物流线', 'B12后挡上到位', 'X1202', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (867, '物流线', '2', '物流线', 'B12后挡下到位 ', 'X1203', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (868, '物流线', '2', '物流线', 'B12推菜块推出到位', 'X1204', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (869, '物流线', '2', '物流线', 'B12推菜块缩回到位', 'X1205', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (870, '物流线', '2', '物流线', 'B12工位餐盘感应', 'X1206', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (871, '物流线', '2', '物流线', 'B12滑道餐盘感应', 'X1207', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (872, '物流线', '2', '物流线', 'B11前挡上到位', 'X1210', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (873, '物流线', '2', '物流线', 'B11前挡下到位', 'X1211', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (874, '物流线', '2', '物流线', 'B11后挡上到位', 'X1212', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (875, '物流线', '2', '物流线', 'B11后挡下到位 ', 'X1213', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (876, '物流线', '2', '物流线', 'B11推菜块推出到位', 'X1214', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (877, '物流线', '2', '物流线', 'B11推菜块缩回到位', 'X1215', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (878, '物流线', '2', '物流线', 'B11工位餐盘感应', 'X1216', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (879, '物流线', '2', '物流线', 'B11滑道餐盘感应', 'X1217', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (880, '物流线', '2', '物流线', 'B10前挡上到位', 'X1240', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (881, '物流线', '2', '物流线', 'B10前挡下到位', 'X1241', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (882, '物流线', '2', '物流线', 'B10后挡上到位', 'X1242', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (883, '物流线', '2', '物流线', 'B10后挡下到位 ', 'X1243', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (884, '物流线', '2', '物流线', 'B10推菜块推出到位', 'X1244', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (885, '物流线', '2', '物流线', 'B10推菜块缩回到位', 'X1245', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (886, '物流线', '2', '物流线', 'B10工位餐盘感应', 'X1246', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (887, '物流线', '2', '物流线', 'B10滑道餐盘感应', 'X1247', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (888, '物流线', '2', '物流线', 'B09前挡上到位', 'X1250', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (889, '物流线', '2', '物流线', 'B09前挡下到位', 'X1251', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (890, '物流线', '2', '物流线', 'B09后挡上到位', 'X1252', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (891, '物流线', '2', '物流线', 'B09后挡下到位 ', 'X1253', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (892, '物流线', '2', '物流线', 'B09推菜块推出到位', 'X1254', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (893, '物流线', '2', '物流线', 'B09推菜块缩回到位', 'X1255', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (894, '物流线', '2', '物流线', 'B09工位餐盘感应', 'X1256', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (895, '物流线', '2', '物流线', 'B09滑道餐盘感应', 'X1257', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (900, '单臂炸', '2', '单臂炸', '急停', 'D5122-0', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (901, '单臂炸', '2', '单臂炸', '升降伺服原点', 'D5122-1', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (902, '单臂炸', '2', '单臂炸', '升降伺服正极限', 'D5122-2', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (903, '单臂炸', '2', '单臂炸', '升降伺服负极限', 'D5122-3', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (904, '单臂炸', '2', '单臂炸', '1#步进原点', 'D5122-4', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (905, '单臂炸', '2', '单臂炸', '冷库A步进到正极限', 'D5122-5', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (906, '单臂炸', '2', '单臂炸', '冷库A步进到正极限', 'D5122-6', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (907, '单臂炸', '2', '单臂炸', '2#步进原点', 'D5122-7', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (908, '单臂炸', '2', '单臂炸', '2#步进正极限', 'D5122-8', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (909, '单臂炸', '2', '单臂炸', '2#步进负极限', 'D5122-9', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (910, '单臂炸', '2', '单臂炸', '3#步进原点', 'D5122-10', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (911, '单臂炸', '2', '单臂炸', '3#步进正极限', 'D5122-11', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (912, '单臂炸', '2', '单臂炸', '3#步进负极限', 'D5122-12', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (913, '单臂炸', '2', '单臂炸', '4#步进原点', 'D5122-13', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (914, '单臂炸', '2', '单臂炸', '4#步进正极限', 'D5122-14', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (915, '单臂炸', '2', '单臂炸', '4#步进负极限', 'D5122-15', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (916, '单臂炸', '2', '单臂炸', '伺服ALM', 'D5123-0', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (917, '单臂炸', '2', '单臂炸', '1#步进ALM', 'D5123-1', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (918, '单臂炸', '2', '单臂炸', '2#步进ALM', 'D5123-2', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (919, '单臂炸', '2', '单臂炸', '3#步进ALM', 'D5123-3', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (920, '单臂炸', '2', '单臂炸', '4#步进ALM', 'D5123-4', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (921, '单臂炸', '2', '单臂炸', '5#步进ALM', 'D5123-5', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (922, '单臂炸', '2', '单臂炸', '6#步进ALM', 'D5123-6', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (923, '单臂炸', '2', '单臂炸', '补碗提示光电1', 'D5123-7', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (924, '单臂炸', '2', '单臂炸', '1#炸篮升位', 'D5123-8', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (925, '单臂炸', '2', '单臂炸', '1#炸篮降位', 'D5123-9', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (926, '单臂炸', '2', '单臂炸', '2#炸篮升位', 'D5123-10', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (927, '单臂炸', '2', '单臂炸', '2#炸篮降位', 'D5123-11', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (928, '单臂炸', '2', '单臂炸', '3#炸篮升位', 'D5123-12', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (929, '单臂炸', '2', '单臂炸', '3#炸篮降位', 'D5123-13', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (930, '单臂炸', '2', '单臂炸', '4#炸篮升位', 'D5123-14', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (931, '单臂炸', '2', '单臂炸', '4#炸篮降位', 'D5123-15', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (932, '单臂炸', '2', '单臂炸', '5#炸篮升位', 'D5124-0', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (933, '单臂炸', '2', '单臂炸', '5#炸篮降位', 'D5124-1', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (934, '单臂炸', '2', '单臂炸', '6#炸篮升位', 'D5124-2', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (935, '单臂炸', '2', '单臂炸', '6#炸篮降位', 'D5124-3', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (936, '单臂炸', '2', '单臂炸', '7#炸篮升位', 'D5124-4', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (937, '单臂炸', '2', '单臂炸', '7#炸篮降位', 'D5124-5', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (938, '单臂炸', '2', '单臂炸', '8#炸篮升位', 'D5124-6', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (939, '单臂炸', '2', '单臂炸', '8#炸篮降位', 'D5124-7', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (940, '单臂炸', '2', '单臂炸', '9#炸篮升位', 'D5124-8', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (941, '单臂炸', '2', '单臂炸', '9#炸篮降位', 'D5124-9', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (942, '单臂炸', '2', '单臂炸', '10#炸篮升位', 'D5124-10', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (943, '单臂炸', '2', '单臂炸', '10#炸篮降位', 'D5124-11', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (944, '单臂炸', '2', '单臂炸', '11#炸篮升位', 'D5124-12', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (945, '单臂炸', '2', '单臂炸', '11#炸篮降位', 'D5124-13', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (946, '单臂炸', '2', '单臂炸', '12#炸篮升位', 'D5124-14', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (947, '单臂炸', '2', '单臂炸', '12#炸篮降位', 'D5124-15', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (948, '单臂炸', '2', '单臂炸', '复位按钮', 'D5125-0', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (949, '单臂炸', '2', '单臂炸', '启动按钮', 'D5125-1', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (950, '单臂炸', '2', '单臂炸', '出餐门气缸2原位', 'D5125-2', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (951, '单臂炸', '2', '单臂炸', '出餐门气缸2工位', 'D5125-3', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (952, '单臂炸', '2', '单臂炸', '出餐门气缸3原位', 'D5125-4', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (953, '单臂炸', '2', '单臂炸', '出餐门气缸3工位', 'D5125-5', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (954, '单臂炸', '2', '单臂炸', '出餐门气缸4原位', 'D5125-6', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (955, '单臂炸', '2', '单臂炸', '出餐门气缸4工位', 'D5125-7', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (956, '单臂炸', '2', '单臂炸', '机器人复位按钮', 'D5125-8', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (957, '单臂炸', '2', '单臂炸', '出餐门光栅2', 'D5125-9', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (958, '单臂炸', '2', '单臂炸', '出餐门光栅3', 'D5125-10', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (959, '单臂炸', '2', '单臂炸', '出餐门光栅4', 'D5125-11', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (960, '单臂炸', '2', '单臂炸', '落杯器感应1', 'D5125-12', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (961, '单臂炸', '2', '单臂炸', '落碗成功光电1', 'D5125-13', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (962, '单臂炸', '2', '单臂炸', '漏斗气缸原位', 'D5125-14', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (963, '单臂炸', '2', '单臂炸', '漏斗气缸工位', 'D5125-15', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (964, '单臂炸', '2', '单臂炸', '纸碗二次定位气缸原位', 'D5126-0', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (965, '单臂炸', '2', '单臂炸', '纸碗二次定位气缸工位', 'D5126-1', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (966, '单臂炸', '2', '单臂炸', '冷柜暂停按钮', 'D5126-2', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (967, '单臂炸', '2', '单臂炸', '冷柜复位按钮', 'D5126-3', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (968, '单臂炸', '2', '单臂炸', '倒料位光电感应', 'D5126-4', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (969, '单臂炸', '2', '单臂炸', '机器人准备好', 'D5126-5', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (970, '单臂炸', '2', '单臂炸', '机器人自动运行中', 'D5126-6', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (971, '单臂炸', '2', '单臂炸', '机器人报警', 'D5126-7', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (972, '单臂炸', '2', '单臂炸', '纵向推成品正极限', 'D5126-8', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (973, '单臂炸', '2', '单臂炸', '纵向推成品负极限', 'D5126-9', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (974, '单臂炸', '2', '单臂炸', '纵向推成品步进原点', 'D5126-10', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (975, '单臂炸', '2', '单臂炸', '横向推成品正极限', 'D5126-11', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (976, '单臂炸', '2', '单臂炸', '横向推成品负极限', 'D5126-12', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (977, '单臂炸', '2', '单臂炸', '横向推成品步进原点', 'D5126-13', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (978, '单臂炸', '2', '单臂炸', '安全围蔽1', 'D5126-14', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (979, '单臂炸', '2', '单臂炸', '安全围蔽2（预留）', 'D5126-15', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (980, '单臂炸', '2', '单臂炸', '餐位感应1A', 'D5127-0', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (981, '单臂炸', '2', '单臂炸', '餐位感应1B', 'D5127-1', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (982, '单臂炸', '2', '单臂炸', '餐位感应2A', 'D5127-2', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (983, '单臂炸', '2', '单臂炸', '餐位感应2B', 'D5127-3', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (984, '单臂炸', '2', '单臂炸', '餐位感应3A', 'D5127-4', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (985, '单臂炸', '2', '单臂炸', '餐位感应3B', 'D5127-5', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (986, '单臂炸', '2', '单臂炸', '餐位感应4A', 'D5127-6', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (987, '单臂炸', '2', '单臂炸', '餐位感应4B', 'D5127-7', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (988, '单臂炸', '2', '单臂炸', '斜坡反射光电1', 'D5127-8', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (989, '单臂炸', '2', '单臂炸', '斜坡反射光电2', 'D5127-9', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (990, '单臂炸', '2', '单臂炸', '斜坡反射光电3', 'D5127-10', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (991, '单臂炸', '2', '单臂炸', '斜坡反射光电4', 'D5127-11', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (992, '单臂炸', '2', '单臂炸', '落杯器感应2', 'D5127-12', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (993, '单臂炸', '2', '单臂炸', '落碗成功光电2', 'D5127-13', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (994, '单臂炸', '2', '单臂炸', '补碗提示光电2', 'D5127-14', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (996, '单臂炸', '2', '单臂炸', '升降机对射光电1', 'D5128-0', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (997, '单臂炸', '2', '单臂炸', '升降机对射光电2', 'D5128-1', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (998, '单臂炸', '2', '单臂炸', '龙门反射光电1', 'D5128-2', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (999, '单臂炸', '2', '单臂炸', '龙门反射光电2', 'D5128-3', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1000, '单臂炸', '2', '单臂炸', '龙门反射光电3', 'D5128-4', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1004, '单臂炸', '2', '单臂炸', '离合气缸原位', 'D5128-8', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1005, '单臂炸', '2', '单臂炸', '离合气缸工位', 'D5128-9', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1006, '单臂炸', '2', '单臂炸', '缓存区A 反射1', 'D5128-10', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1007, '单臂炸', '2', '单臂炸', '缓存区A 反射2', 'D5128-11', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1008, '单臂炸', '2', '单臂炸', '缓存区A 反射3', 'D5128-12', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1009, '单臂炸', '2', '单臂炸', '缓存区B 反射1', 'D5128-13', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1010, '单臂炸', '2', '单臂炸', '缓存区B 反射2', 'D5128-14', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1011, '单臂炸', '2', '单臂炸', '缓存区B 反射3', 'D5128-15', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1012, '单臂炸', '2', '单臂炸', '缓存区C 反射1', 'D5129-0', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1013, '单臂炸', '2', '单臂炸', '缓存区C 反射2', 'D5129-1', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1014, '单臂炸', '2', '单臂炸', '缓存区C 反射3', 'D5129-2', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1015, '单臂炸', '2', '单臂炸', '缓存区D 反射1', 'D5129-3', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1016, '单臂炸', '2', '单臂炸', '缓存区D 反射2', 'D5129-4', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1017, '单臂炸', '2', '单臂炸', '缓存区D 反射3', 'D5129-5', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1018, '单臂炸', '2', '单臂炸', '阻挡气缸原位', 'D5129-6', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1019, '单臂炸', '2', '单臂炸', '阻挡气缸工位', 'D5129-7', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1020, '单臂炸', '2', '单臂炸', 'A门气缸原位', 'D5129-8', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1021, '单臂炸', '2', '单臂炸', 'A门气缸工位', 'D5129-9', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1028, '单臂炸', '2', '单臂炸', '斜坡反射光电1', 'D5130-0', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1029, '单臂炸', '2', '单臂炸', '斜坡反射光电2', 'D5130-1', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1030, '单臂炸', '2', '单臂炸', '斜坡反射光电3', 'D5130-2', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1031, '单臂炸', '2', '单臂炸', '斜坡反射光电4', 'D5130-3', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1044, '奶茶机', '2', '奶茶机', '急停', 'X0', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1045, '奶茶机', '2', '奶茶机', '取杯升降轴原点', 'X1', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1046, '奶茶机', '2', '奶茶机', '取杯平移轴原点', 'X2', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1047, '奶茶机', '2', '奶茶机', '输送轴原点', 'X3', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1048, '奶茶机', '2', '奶茶机', '取杯升降轴正极限', 'X4', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1049, '奶茶机', '2', '奶茶机', '取杯升降轴负极限', 'X5', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1050, '奶茶机', '2', '奶茶机', '取杯平移轴正极限', 'X6', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1051, '奶茶机', '2', '奶茶机', '取杯平移轴负极限', 'X7', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1052, '奶茶机', '2', '奶茶机', '输送轴正极限', 'X10', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1053, '奶茶机', '2', '奶茶机', '输送轴负极限', 'X11', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1054, '奶茶机', '2', '奶茶机', '取杯升降轴驱动器报警', 'X12', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1055, '奶茶机', '2', '奶茶机', '取杯平移轴驱动器报警', 'X13', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1056, '奶茶机', '2', '奶茶机', '输送轴驱动器报警', 'X14', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1057, '奶茶机', '2', '奶茶机', '下料轴原点', 'X15', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1058, '奶茶机', '2', '奶茶机', '取杯位置1检测', 'X16', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1059, '奶茶机', '2', '奶茶机', '取杯位置2检测', 'X17', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1060, '奶茶机', '2', '奶茶机', '下料轴驱动报警', 'X20', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1061, '奶茶机', '2', '奶茶机', '取杯气缸松开检测', 'X21', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1062, '奶茶机', '2', '奶茶机', '取杯气缸夹紧检测', 'X22', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1063, '奶茶机', '2', '奶茶机', '输送线位置检测1', 'X23', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1064, '奶茶机', '2', '奶茶机', '输送线位置检测2', 'X24', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1065, '奶茶机', '2', '奶茶机', '输送线位置检测3', 'X25', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1066, '奶茶机', '2', '奶茶机', '夹爪光电检测', 'X26', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1067, '奶茶机', '2', '奶茶机', '输送线气缸1前进检测', 'X27', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1068, '奶茶机', '2', '奶茶机', '输送线气缸1后退检测', 'X30', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1069, '奶茶机', '2', '奶茶机', '输送线气缸2前进检测', 'X31', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1070, '奶茶机', '2', '奶茶机', '输送线气缸2后退检测', 'X32', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1071, '奶茶机', '2', '奶茶机', '夹杯上气缸夹紧1', 'X33', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1072, '奶茶机', '2', '奶茶机', '夹杯上气缸松开1', 'X34', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1073, '奶茶机', '2', '奶茶机', '夹杯下气缸夹紧1', 'X35', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1074, '奶茶机', '2', '奶茶机', '夹杯下气缸松开1', 'X36', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1075, '奶茶机', '2', '奶茶机', '光栅1', 'X43', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1076, '奶茶机', '2', '奶茶机', '杯盖定位松开检测', 'X44', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1077, '奶茶机', '2', '奶茶机', '杯盖定位夹紧检测', 'X45', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1078, '奶茶机', '2', '奶茶机', '杯盖定位有无检测', 'X46', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1079, '奶茶机', '2', '奶茶机', '出菜口1到位检测1', 'X47', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1080, '奶茶机', '2', '奶茶机', '出菜口1到位检测2  ', 'X50', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1081, '奶茶机', '2', '奶茶机', '出菜口1气缸打开检测', 'X53', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1082, '奶茶机', '2', '奶茶机', '出菜口1气缸关闭检测', 'X54', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1083, '奶茶机', '2', '奶茶机', '杯盖1满料检测', 'X55', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1084, '奶茶机', '2', '奶茶机', '杯盖2满料检测', 'X56', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1085, '奶茶机', '2', '奶茶机', '杯盖3满料检测', 'X57', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1086, '奶茶机', '2', '奶茶机', '杯盖4满料检测', 'X60', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1087, '奶茶机', '2', '奶茶机', '杯盖1缺料检测', 'X61', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1088, '奶茶机', '2', '奶茶机', '杯盖2缺料检测', 'X62', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1089, '奶茶机', '2', '奶茶机', '杯盖3缺料检测', 'X63', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1090, '奶茶机', '2', '奶茶机', '杯盖4缺料检测', 'X64', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1091, '奶茶机', '2', '奶茶机', '机器人运行状态', 'X65', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1092, '奶茶机', '2', '奶茶机', '机器人停止状态', 'X66', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1093, '奶茶机', '2', '奶茶机', '机器人暂停状态', 'X67', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1094, '蛋糕机', '2', '蛋糕机', '急停', 'X0', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1095, '蛋糕机', '2', '蛋糕机', '停止', 'X1', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1096, '蛋糕机', '2', '蛋糕机', '复位', 'X2', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1097, '蛋糕机', '2', '蛋糕机', '层选Z轴原点', 'X4', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1098, '蛋糕机', '2', '蛋糕机', '层选X轴原点', 'X5', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1099, '蛋糕机', '2', '蛋糕机', '取料平移气缸原位', 'X10', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1100, '蛋糕机', '2', '蛋糕机', '取料平移气缸工位', 'X11', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1101, '蛋糕机', '2', '蛋糕机', '层选挡料气缸原位', 'X12', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1102, '蛋糕机', '2', '蛋糕机', '层选挡料气缸工位', 'X13', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1103, '蛋糕机', '2', '蛋糕机', '取料平台位置对射检测1', 'X14', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1104, '蛋糕机', '2', '蛋糕机', '取料平台位置对射检测2', 'X15', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1105, '蛋糕机', '2', '蛋糕机', '层选Z轴伺服报警', 'X16', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1106, '蛋糕机', '2', '蛋糕机', '层选Z轴下极限', 'X17', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1107, '蛋糕机', '2', '蛋糕机', '层选X轴报警', 'X21', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1108, '蛋糕机', '2', '蛋糕机', '层选X轴左极限', 'X22', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1109, '蛋糕机', '2', '蛋糕机', '层选内部推杆气缸原位', 'X24', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1110, '蛋糕机', '2', '蛋糕机', '层选内部推杆气缸工位', 'X25', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1111, '蛋糕机', '2', '蛋糕机', '1#滑道位置1', 'X26', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1112, '蛋糕机', '2', '蛋糕机', '1#滑道位置检测2', 'X27', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1113, '蛋糕机', '2', '蛋糕机', '1#取餐平台对射检测1', 'X33', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1114, '蛋糕机', '2', '蛋糕机', '1#取餐平台对射检测2', 'X34', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1115, '蛋糕机', '2', '蛋糕机', '1#取餐口安全光栅', 'X35', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1116, '蛋糕机', '2', '蛋糕机', '1#取餐口关闭检测', 'X36', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1117, '蛋糕机', '2', '蛋糕机', '1#取餐口打开检测', 'X37', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1118, '蛋糕机', '2', '蛋糕机', 'Robot运行中', 'X46', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1119, '蛋糕机', '2', '蛋糕机', 'Robot停止中', 'X47', 'bit', NULL, '1');
INSERT INTO `gw_cfg_ioinfo` VALUES (1120, '蛋糕机', '2', '蛋糕机', 'Robot暂停中', 'X50', 'bit', NULL, '1');

SET FOREIGN_KEY_CHECKS = 1;
