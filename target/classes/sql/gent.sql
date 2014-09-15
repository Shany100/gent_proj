/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : gent

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2014-09-15 08:21:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `event`
-- ----------------------------
DROP TABLE IF EXISTS `event`;
CREATE TABLE `event` (
  `name` varchar(50) DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  `flag` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of event
-- ----------------------------
INSERT INTO `event` VALUES ('read books', '2014-05-18', '1', '1');

-- ----------------------------
-- Table structure for `record`
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `id` int(11) DEFAULT NULL,
  `event_name` varchar(50) DEFAULT NULL,
  `record_time` date DEFAULT NULL,
  `note` varchar(100) DEFAULT NULL,
  `flag` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of record
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL DEFAULT '',
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `createtime` datetime NOT NULL,
  `flag` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('10', '', '123456', 'jantollong@sina.com', '2014-08-17 10:00:00', '1');
INSERT INTO `user` VALUES ('11', '', '123456', 'jantollong@gmail.com', '2014-08-17 13:50:33', '1');
INSERT INTO `user` VALUES ('16', '', '123456', 'shanelman@gmail.com', '2014-08-17 14:06:27', '1');
INSERT INTO `user` VALUES ('17', '', 'test', 'shany@meizu.com', '2014-08-17 14:31:14', '1');
INSERT INTO `user` VALUES ('18', '', 'test', 'chiangtao@sina.com', '2014-08-17 14:50:15', '1');
INSERT INTO `user` VALUES ('19', '', 'test', 'hello@me.com', '2014-08-17 14:59:34', '1');
INSERT INTO `user` VALUES ('20', '', 'test', 'test@meizu.com', '2014-08-17 15:15:59', '1');
