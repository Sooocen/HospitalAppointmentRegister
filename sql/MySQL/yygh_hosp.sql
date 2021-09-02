/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : yygh_hosp

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 02/09/2021 23:07:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for hospital_set
-- ----------------------------
DROP TABLE IF EXISTS `hospital_set`;
CREATE TABLE `hospital_set` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `hosname` varchar(100) DEFAULT NULL COMMENT '医院名称',
  `hoscode` varchar(30) DEFAULT NULL COMMENT '医院编号',
  `api_url` varchar(100) DEFAULT NULL COMMENT 'api基础路径',
  `sign_key` varchar(50) DEFAULT NULL COMMENT '签名秘钥',
  `contacts_name` varchar(20) DEFAULT NULL COMMENT '联系人',
  `contacts_phone` varchar(11) DEFAULT NULL COMMENT '联系人手机',
  `status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(3) NOT NULL DEFAULT '0' COMMENT '逻辑删除(1:已删除，0:未删除)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_hoscode` (`hoscode`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='医院设置表';

-- ----------------------------
-- Records of hospital_set
-- ----------------------------
BEGIN;
INSERT INTO `hospital_set` VALUES (1, '包头医学院第一附属医院', '1000_1', 'http://localhost:8201/', '674c4139707728439a6510eae12deea9', '1', '1', 1, '2021-08-08 08:30:50', '2021-09-02 16:54:17', 0);
INSERT INTO `hospital_set` VALUES (2, '包钢集团第三职工医院', '1000_2', 'http://localhost:9999', '0d62469d45789bd598529d1a8111b023', '2', '2', 1, '2021-08-08 16:07:25', '2021-08-09 16:16:54', 0);
INSERT INTO `hospital_set` VALUES (3, '包头市第三医院', '1000_3', 'http://localhost:9999', '0d62469d45789bd598529d1a8111b789', '3', '3', 1, '2021-08-09 09:45:45', '2021-08-09 16:16:53', 0);
INSERT INTO `hospital_set` VALUES (4, '包头市第六医院', '1000_4', 'http://localhost:9999', '904c4139707728439a6510eae12deea9', '4', '4', 1, '2021-08-09 09:46:13', '2021-08-09 16:16:52', 0);
INSERT INTO `hospital_set` VALUES (5, '包头市中心医院', '1000_5', 'http://localhost:9999', '904c4139707728439a6510eae12deea9', '5', '5', 1, '2021-08-09 12:02:01', '2021-08-09 16:16:51', 0);
INSERT INTO `hospital_set` VALUES (6, '内蒙古包钢医院', '1000_6', 'http://localhost:9999', '0d62469d45789bd598529d1a8111b023', '6', '6', 1, '2021-08-09 12:02:24', '2021-08-09 16:16:50', 0);
INSERT INTO `hospital_set` VALUES (7, '包头医学院第二附属医院', '1000_7', 'http://localhost:9999', '0d62469d45789bd598529d1a8111b023', '7', '7', 1, '2021-08-09 14:32:39', '2021-08-09 16:16:49', 0);
INSERT INTO `hospital_set` VALUES (8, '包头市第八医院', '1000_8', 'http://localhost:9999', '904c4139707728439a6510ehsl2deea9', '8', '8', 1, '2021-08-09 14:33:57', '2021-08-09 16:16:48', 0);
INSERT INTO `hospital_set` VALUES (9, '包头市眼科医院', '1000_9', 'http://localhost:9999', '0d62469d45789bd598529d1a8111b023', '9', '9', 1, '2021-08-09 14:35:30', '2021-08-09 16:16:46', 0);
INSERT INTO `hospital_set` VALUES (10, '内蒙古一机医院', '1000_10', 'http://localhost:9999', '0d62469d45789bd598529d1a8111b023', '10', '10', 1, '2021-08-09 14:36:33', '2021-08-09 15:27:44', 0);
INSERT INTO `hospital_set` VALUES (11, '包头市蒙医中心医院', '1000_11', 'http://localhost:9999', '904c4139707728439a6510eae12deea9', '11', '11', 1, '2021-08-09 14:37:34', '2021-08-09 15:04:11', 0);
INSERT INTO `hospital_set` VALUES (12, '包头市青山区中医医院', '1000_12', 'http://localhost:9999', '2ef0123a9259006e99364a49a6c4d5da', '12', '12', 1, '2021-08-09 14:38:16', '2021-08-09 15:46:55', 0);
INSERT INTO `hospital_set` VALUES (13, '包头市九原区蒙医中医医院', '1000_13', 'http://localhost:9999', '2ef0123a9259006e99364a49a6c4d5da', '13', '13', 1, '2021-08-09 15:46:37', '2021-08-09 15:48:29', 0);
INSERT INTO `hospital_set` VALUES (14, '包头市肿瘤医院', '1000_14', 'http://localhost:9999', '7afbdca811fd5d0bfefb5751d5701da2', '14', '14', 1, '2021-08-09 16:16:20', '2021-08-16 08:38:47', 0);
INSERT INTO `hospital_set` VALUES (15, '包头市第四医院', '1000_15', 'http://localhost:9999', 'b7badedc8e6d5a658de20501f43e5831', '15', '15', 1, '2021-08-17 15:39:03', '2021-09-02 23:07:17', 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
