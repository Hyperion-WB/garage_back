/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 80034
Source Host           : localhost:3306
Source Database       : garage

Target Server Type    : MYSQL
Target Server Version : 80034
File Encoding         : 65001

Date: 2024-10-11 17:58:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `env`
-- ----------------------------
DROP TABLE IF EXISTS `env`;
CREATE TABLE `env` (
  `id` int NOT NULL AUTO_INCREMENT,
  `temp` decimal(10,2) NOT NULL,
  `pre` varchar(255) NOT NULL,
  `hum` decimal(10,2) NOT NULL,
  `gas` varchar(255) NOT NULL,
  `fire` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of env
-- ----------------------------
INSERT INTO `env` VALUES ('8', '15.00', '1019', '10.00', '2', '5', '2024-10-11 17:55:13');

-- ----------------------------
-- Table structure for `env_check`
-- ----------------------------
DROP TABLE IF EXISTS `env_check`;
CREATE TABLE `env_check` (
  `id` int NOT NULL AUTO_INCREMENT,
  `field_name` varchar(255) NOT NULL,
  `value` decimal(10,2) NOT NULL,
  `exceed_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of env_check
-- ----------------------------
INSERT INTO `env_check` VALUES ('17', 'pre', '1019.00', '2024-10-11 17:55:13');
INSERT INTO `env_check` VALUES ('18', 'gas', '2.00', '2024-10-11 17:55:13');
INSERT INTO `env_check` VALUES ('19', 'fire', '5.00', '2024-10-11 17:55:13');
