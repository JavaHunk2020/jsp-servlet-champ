/*
Navicat MySQL Data Transfer

Source Server         : LOCA
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : vehicle_db

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2020-06-12 19:52:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user_login_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `user_login_tbl`;
CREATE TABLE `user_login_tbl` (
  `username` varchar(30) NOT NULL,
  `password` varchar(30) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `qualification` varchar(100) DEFAULT NULL,
  `mobile` varchar(12) DEFAULT NULL,
  `photo` varchar(500) DEFAULT NULL,
  `gender` varchar(7) DEFAULT NULL,
  `createdate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user_login_tbl
-- ----------------------------
INSERT INTO `user_login_tbl` VALUES ('alish', 'test', 'Alish', 'alish@gmail.com', 'M.S.', '939848484', 'https://www.csi.cuny.edu/sites/default/files/styles/inner_page_slider/public/images/slider/shutterstock_106224497.jpg?itok=kNdZz8B8', 'Male', '2020-06-12 19:11:05');
INSERT INTO `user_login_tbl` VALUES ('yadna01', 'cool', 'Nagendra', 'nagen@gmail.com', 'B.Tech', '9383838', 'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQTnO4YrVr-H7llGYtT1pGivRQyOX425GAp2M93ndrV__mTNTty&usqp=CAU', 'Male', '2020-06-12 19:11:05');
