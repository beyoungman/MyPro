/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : bitou-manager

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-01-25 11:40:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bmoney
-- ----------------------------
DROP TABLE IF EXISTS `bmoney`;
CREATE TABLE `bmoney` (
  `bid` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `money` int(11) NOT NULL,
  `sid` int(11) NOT NULL,
  `CreateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bmoney
-- ----------------------------

-- ----------------------------
-- Table structure for buy
-- ----------------------------
DROP TABLE IF EXISTS `buy`;
CREATE TABLE `buy` (
  `buy_id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `customer` varchar(55) DEFAULT NULL,
  `goods` varchar(55) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  `weigh_money` int(11) DEFAULT NULL,
  `money` int(11) DEFAULT '0',
  `remarks` varchar(255) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `CreateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`buy_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of buy
-- ----------------------------

-- ----------------------------
-- Table structure for ot
-- ----------------------------
DROP TABLE IF EXISTS `ot`;
CREATE TABLE `ot` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `hours` float(11,0) DEFAULT NULL,
  `money` int(11) DEFAULT NULL,
  `sid` int(11) NOT NULL,
  `CreateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ot
-- ----------------------------

-- ----------------------------
-- Table structure for otherpay
-- ----------------------------
DROP TABLE IF EXISTS `otherpay`;
CREATE TABLE `otherpay` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `payFor` varchar(255) DEFAULT NULL,
  `money` float DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of otherpay
-- ----------------------------

-- ----------------------------
-- Table structure for rest
-- ----------------------------
DROP TABLE IF EXISTS `rest`;
CREATE TABLE `rest` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `days` double NOT NULL,
  `sid` int(11) NOT NULL,
  `CreateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rest
-- ----------------------------

-- ----------------------------
-- Table structure for sale
-- ----------------------------
DROP TABLE IF EXISTS `sale`;
CREATE TABLE `sale` (
  `sale_id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `customer` varchar(55) DEFAULT NULL,
  `goods` varchar(55) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  `weigh_money` int(11) DEFAULT NULL,
  `money` int(11) DEFAULT '0',
  `remarks` varchar(255) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `CreateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`sale_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sale
-- ----------------------------

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `idNum` varchar(255) NOT NULL,
  `name` varchar(20) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `salary` int(10) DEFAULT NULL,
  `year-salary` double(10,2) DEFAULT NULL,
  `uid` int(11) NOT NULL,
  `CreateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL DEFAULT '',
  `name` varchar(255) NOT NULL,
  `CreateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1392378585', '123456', 'xxx', '2018-01-24 13:55:46');
