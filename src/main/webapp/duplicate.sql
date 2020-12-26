/*
Navicat MySQL Data Transfer

Source Server         : localhost1
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : duplicate

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2020-12-24 18:09:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `classes`
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes` (
  `classes_id` char(11) NOT NULL,
  `classes_name` char(255) DEFAULT NULL,
  `classes_adress` char(255) DEFAULT NULL,
  PRIMARY KEY (`classes_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES ('1', 'JAVA1班', '文明大道校区教学楼101');
INSERT INTO `classes` VALUES ('2', 'JAVA2班', '文明大道校区教学楼102');
INSERT INTO `classes` VALUES ('3', 'JAVA3班', null);

-- ----------------------------
-- Table structure for `classes_message`
-- ----------------------------
DROP TABLE IF EXISTS `classes_message`;
CREATE TABLE `classes_message` (
  `classes_id` char(11) NOT NULL,
  `classes_name` char(255) DEFAULT NULL,
  `c_usual_total_score` double DEFAULT NULL,
  `c_usual_average_score` double DEFAULT NULL,
  `c_exam_total_score` double DEFAULT NULL,
  `c_exam_average_score` double DEFAULT NULL,
  `c_total_total_score` double DEFAULT NULL,
  `c_total_average_score` double DEFAULT NULL,
  PRIMARY KEY (`classes_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of classes_message
-- ----------------------------
INSERT INTO `classes_message` VALUES ('101', 'JAVA3班', '100', '90', '100', '95', '100', '92.5');
INSERT INTO `classes_message` VALUES ('102', 'JAVA4班', '97', '92', '93', '90', '91', '91.2');
INSERT INTO `classes_message` VALUES ('103', 'JAVA1班', '90', '89', '82', '81', '83', '83.2');
INSERT INTO `classes_message` VALUES ('104', 'JAVA2班', '80', '83', '85', '86', '85.5', '84');
INSERT INTO `classes_message` VALUES ('105', '.net1班', '70', '72', '81', '79', '84', '81.1');
INSERT INTO `classes_message` VALUES ('106', '.net2班', '95', '94', '94.5', '89', '91', '90.2');
INSERT INTO `classes_message` VALUES ('107', '大数据1班', '90', '91', '91.5', '92', '93', '92.5');
INSERT INTO `classes_message` VALUES ('108', '大数据2班', '92', '94', '92', '93', '94', '92.5');

-- ----------------------------
-- Table structure for `corse_grade`
-- ----------------------------
DROP TABLE IF EXISTS `corse_grade`;
CREATE TABLE `corse_grade` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_name` char(255) DEFAULT NULL,
  `course_name` char(255) DEFAULT NULL,
  `s_usual_score` double DEFAULT NULL,
  `s_exam_score` double DEFAULT NULL,
  `s_total_score` double DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=184804311 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of corse_grade
-- ----------------------------
INSERT INTO `corse_grade` VALUES ('184804310', '王聪聪', 'JAVA EE企业级开发', '100', '100', '100');

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_name` char(255) DEFAULT NULL,
  `course_time` char(255) DEFAULT NULL,
  `course_score` char(255) DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('101', 'JAVA EE企业级开发', '45学时', '100');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` varchar(255) DEFAULT NULL,
  `student_name` char(255) DEFAULT NULL,
  `student_age` int(11) DEFAULT NULL,
  `student_sex` char(255) DEFAULT NULL,
  `university` char(255) DEFAULT NULL,
  `classes_name` char(255) DEFAULT NULL,
  `telphone` char(255) DEFAULT NULL,
  `classes_id` char(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `student_id` (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('0', '184804310', '王聪聪', '12', '男', '安阳师范大学', 'JAVA3班', '18348325641', '1');
INSERT INTO `student` VALUES ('1', '184804311', '王小聪', '20', '男', '安阳师范学院', 'JAVA4班', '18348325642', '2');
INSERT INTO `student` VALUES ('2', '184804312', '王大聪', '19', '男', '安阳师范大学', 'JAVA2班', '18348325643', '3');
INSERT INTO `student` VALUES ('3', '184804313', '王聪明', '18', '女', '安阳师范大学', 'JAVA2班', '18348325644', '1');
INSERT INTO `student` VALUES ('4', '184804314', '张三', '19', '男', '安阳师范大学', 'JAVA1班', '18348325645', '2');
INSERT INTO `student` VALUES ('5', '184804320', '李四', '18', '女', '安阳师范大学', 'JAVA3班', '18348325646', '3');
INSERT INTO `student` VALUES ('6', '184804333', '王二', '19', '男', '安阳师范大学', 'JAVA4班', '18348325647', '1');
INSERT INTO `student` VALUES ('17', '11', '王聪聪', '18', '男', '安阳师范大学', 'JAVA3班', '18348325647', null);
INSERT INTO `student` VALUES ('18', '22', '王聪聪', '18', '男', '安阳师范大学', 'JAVA3班', '18348325647', null);
INSERT INTO `student` VALUES ('19', '33', '王聪聪', '18', '男', '安阳师范大学', 'JAVA3班', '18348325647', null);

-- ----------------------------
-- Table structure for `student_classes`
-- ----------------------------
DROP TABLE IF EXISTS `student_classes`;
CREATE TABLE `student_classes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` char(255) DEFAULT NULL,
  `classes_id` char(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of student_classes
-- ----------------------------
INSERT INTO `student_classes` VALUES ('1', '184804310', '1');

-- ----------------------------
-- Table structure for `student_course`
-- ----------------------------
DROP TABLE IF EXISTS `student_course`;
CREATE TABLE `student_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` varchar(255) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `student_id` (`student_id`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `course_id` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`),
  CONSTRAINT `student_id` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of student_course
-- ----------------------------
INSERT INTO `student_course` VALUES ('1', '184804310', '101');

-- ----------------------------
-- Table structure for `student_message`
-- ----------------------------
DROP TABLE IF EXISTS `student_message`;
CREATE TABLE `student_message` (
  `student_id` char(11) NOT NULL,
  `student_name` char(255) DEFAULT NULL,
  `student_sex` char(255) DEFAULT NULL,
  `classes_name` char(255) DEFAULT NULL,
  `course_name` char(255) DEFAULT NULL,
  `s_usual_score` double DEFAULT NULL,
  `s_exam_score` double DEFAULT NULL,
  `s_total_score` double DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of student_message
-- ----------------------------
INSERT INTO `student_message` VALUES ('184804310', '王聪聪', '男', 'JAVA3班', '框架技术', '90', '90', '95');
INSERT INTO `student_message` VALUES ('184804311', '王大聪', '男', 'JAVA3班', '计算机网络', '96', '99', '97.5');
INSERT INTO `student_message` VALUES ('184804312', '王聪明', '男', 'JAVA3班', 'Oracle数据库基础教程', '81', '70', '82');
INSERT INTO `student_message` VALUES ('184804314', '王小聪', '男', 'JAVA3班', '软件工程概论', '86', '79', '81');
INSERT INTO `student_message` VALUES ('184804316', '李四', '男', 'JAVA3班', '企业项目实战', '80', '75', '76');
INSERT INTO `student_message` VALUES ('184804318', '王二', '男', 'JAVA3班', '毛概', '87', '69', '68');
INSERT INTO `student_message` VALUES ('184804410', '小红', '男', 'JAVA3班', 'JAVA基础开发', '63', '45', '57');
INSERT INTO `student_message` VALUES ('184804411', '小米', '男', 'JAVA4班', '马克思原理', '68', '49', '58');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` char(255) NOT NULL DEFAULT '',
  `password` char(255) DEFAULT NULL,
  `name` char(255) DEFAULT NULL,
  `flag` char(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('aaa', '111', '王聪聪', null);
INSERT INTO `user` VALUES ('cong', '111', '王聪聪', '学生');
INSERT INTO `user` VALUES ('wang', '123456', '王聪聪', '系统管理员');
