/*
Navicat MySQL Data Transfer

Source Server         : demo
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : onlineedudb

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2023-07-15 09:47:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cancellation
-- ----------------------------
DROP TABLE IF EXISTS `cancellation`;
CREATE TABLE `cancellation` (
  `cancel_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(20) NOT NULL,
  `subject_id` int(20) NOT NULL,
  `subject_name` varchar(20) NOT NULL,
  `subject_title` varchar(30) NOT NULL,
  `refund` int(10) NOT NULL,
  `time` datetime(6) NOT NULL,
  PRIMARY KEY (`cancel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cancellation
-- ----------------------------

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `order_id` int(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(20) NOT NULL,
  `cost` int(10) NOT NULL,
  `subject_id` int(20) NOT NULL,
  `subject_name` varchar(20) NOT NULL,
  `subject_title` varchar(30) NOT NULL,
  `time` datetime(6) NOT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `major` varchar(20) NOT NULL,
  `phone_num` varchar(20) NOT NULL,
  `age` int(2) NOT NULL,
  `grade` varchar(10) NOT NULL,
  `school` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `phone_num1` (`phone_num`),
  KEY `name` (`name`),
  CONSTRAINT `phone_num1` FOREIGN KEY (`phone_num`) REFERENCES `user` (`phone_num`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of student
-- ----------------------------

-- ----------------------------
-- Table structure for student_subjects
-- ----------------------------
DROP TABLE IF EXISTS `student_subjects`;
CREATE TABLE `student_subjects` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `student_id` int(10) NOT NULL,
  `student_name` varchar(20) NOT NULL,
  `subject_id` int(20) NOT NULL,
  `subject_name` varchar(20) NOT NULL,
  `subject_title` varchar(30) NOT NULL,
  `subject_teacher` varchar(10) NOT NULL,
  `phone_num` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `subject_id` (`subject_id`),
  KEY `subject_name` (`subject_name`),
  KEY `subject_title` (`subject_title`),
  KEY `subject_teacher` (`subject_teacher`),
  KEY `student_id` (`student_id`),
  KEY `student_name` (`student_name`),
  KEY `phone_num` (`phone_num`),
  CONSTRAINT `phone_num` FOREIGN KEY (`phone_num`) REFERENCES `student` (`phone_num`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `student_id` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `student_name` FOREIGN KEY (`student_name`) REFERENCES `student` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `subject_id` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `subject_name` FOREIGN KEY (`subject_name`) REFERENCES `subject` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `subject_teacher` FOREIGN KEY (`subject_teacher`) REFERENCES `subject` (`teacher`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `subject_title` FOREIGN KEY (`subject_title`) REFERENCES `subject` (`title`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of student_subjects
-- ----------------------------

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(30) NOT NULL,
  `name` varchar(20) NOT NULL,
  `teacher` varchar(10) NOT NULL,
  `teacher_id` int(20) NOT NULL,
  `cost` int(10) NOT NULL,
  `description` varchar(100) NOT NULL,
  `likes` int(10) NOT NULL DEFAULT '0',
  `s_time` datetime(6) NOT NULL,
  `e_time` datetime(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`),
  KEY `title` (`title`),
  KEY `teacher` (`teacher`),
  KEY `teacher_id` (`teacher_id`),
  CONSTRAINT `teacher` FOREIGN KEY (`teacher`) REFERENCES `teacher` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `teacher_id` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subject
-- ----------------------------

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `age` int(2) NOT NULL,
  `department` varchar(20) NOT NULL,
  `phone_num` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `phone_num2` (`phone_num`),
  KEY `name` (`name`),
  CONSTRAINT `phone_num2` FOREIGN KEY (`phone_num`) REFERENCES `user` (`phone_num`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `phone_num` varchar(20) NOT NULL,
  `user_name` varchar(10) NOT NULL,
  `user_pwd` varchar(30) NOT NULL,
  `user_type` enum('学生','老师') NOT NULL,
  `salt` varchar(20) NOT NULL,
  PRIMARY KEY (`user_id`,`phone_num`),
  KEY `phone_num` (`phone_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
