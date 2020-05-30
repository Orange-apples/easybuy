/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50024
Source Host           : localhost:3306
Source Database       : easybuy

Target Server Type    : MYSQL
Target Server Version : 50024
File Encoding         : 65001

Date: 2020-05-30 15:06:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(12) NOT NULL auto_increment,
  `user_name` varchar(255) NOT NULL,
  `password` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  `sex` int(12) default NULL,
  `id_card` varchar(255) default NULL,
  `email` varchar(255) default NULL,
  `phone` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', 'admin', 'admin', 'admin', '1', '411302016515', '31010530', '1310310');

-- ----------------------------
-- Table structure for account_address
-- ----------------------------
DROP TABLE IF EXISTS `account_address`;
CREATE TABLE `account_address` (
  `account_id` int(12) NOT NULL,
  `address` varchar(255) default NULL,
  `remark` varchar(255) default NULL,
  PRIMARY KEY  (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account_address
-- ----------------------------
INSERT INTO `account_address` VALUES ('1', '河南省', '家');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  `l` int(11) default NULL,
  `parrent_id` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '化妆品', '1', null);
INSERT INTO `category` VALUES ('2', '粉底', '2', '1');
INSERT INTO `category` VALUES ('3', '粉底霜', '3', '2');
INSERT INTO `category` VALUES ('4', '食品', '1', null);
INSERT INTO `category` VALUES ('5', '水果', '2', '4');
INSERT INTO `category` VALUES ('6', '热带水果', '3', '5');
INSERT INTO `category` VALUES ('7', '粉底液', '3', '2');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  `price` decimal(10,2) default NULL,
  `stock` int(11) default NULL,
  `content` varchar(255) default NULL,
  `img` varchar(255) default NULL,
  `category_id` int(11) default NULL,
  `create_time` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '苹果', '5.00', '100', 'sad', '1513', '6', '2020-04-01 22:21:29');
INSERT INTO `goods` VALUES ('2', '香蕉', '8.00', '100', 'sad', '阿萨德', '6', '2020-04-01 22:21:51');
INSERT INTO `goods` VALUES ('3', '海蓝之谜粉底霜', '139.00', '100', 'sas', '13', '3', '2020-05-05 14:18:04');
INSERT INTO `goods` VALUES ('4', '海蓝之谜粉底液', '239.00', '100', 'sa', 'sad', '7', '2020-04-28 14:18:32');

-- ----------------------------
-- Table structure for goods_order
-- ----------------------------
DROP TABLE IF EXISTS `goods_order`;
CREATE TABLE `goods_order` (
  `id` int(12) NOT NULL auto_increment,
  `order_id` int(12) default NULL,
  `goods_id` int(12) default NULL,
  `count` int(12) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_order
-- ----------------------------
INSERT INTO `goods_order` VALUES ('1', '1', '1', '2');
INSERT INTO `goods_order` VALUES ('2', '1', '2', '3');
INSERT INTO `goods_order` VALUES ('3', '2', '1', '1');
INSERT INTO `goods_order` VALUES ('4', '2', '2', '1');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(12) NOT NULL auto_increment,
  `account_id` int(12) default NULL,
  `order_num` varchar(255) default NULL,
  `order_price` double(10,2) default NULL,
  `address` varchar(500) default NULL,
  `create_time` datetime default NULL,
  `account_name` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', '1', 'adasdasd', '34.00', '河南省', '2020-03-31 22:45:57', 'admin');
INSERT INTO `order` VALUES ('2', '1', 'dafasaf', '13.00', '河南省', '2020-04-27 00:00:00', 'admin');
