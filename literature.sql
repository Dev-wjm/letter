/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : literature

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2018-03-03 13:02:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('5');
INSERT INTO `hibernate_sequence` VALUES ('5');
INSERT INTO `hibernate_sequence` VALUES ('5');

-- ----------------------------
-- Table structure for sys_permissions
-- ----------------------------
DROP TABLE IF EXISTS `sys_permissions`;
CREATE TABLE `sys_permissions` (
  `id` varchar(255) NOT NULL,
  `available` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `menu_order` int(11) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `parent_ids` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permissions
-- ----------------------------
INSERT INTO `sys_permissions` VALUES ('1', '', '系统管理', '1', null, '1/', 'sys:*', null, null);
INSERT INTO `sys_permissions` VALUES ('11', '', '用户管理', null, '1', '1/11', 'user:*', null, null);
INSERT INTO `sys_permissions` VALUES ('12', '', '用户新增', null, '1', '1/11', 'user:create', null, null);
INSERT INTO `sys_permissions` VALUES ('13', '', '用户删除', null, '1', '1/11', 'user:delete', null, null);
INSERT INTO `sys_permissions` VALUES ('14', '', '用户修改', null, '1', '1/11', 'user:update', null, null);
INSERT INTO `sys_permissions` VALUES ('15', '', '用户查询', null, '1', '1/11', 'user:select', null, null);
INSERT INTO `sys_permissions` VALUES ('21', '', '书籍管理', null, '1', '1/21', 'book:*', null, null);
INSERT INTO `sys_permissions` VALUES ('22', '', '书籍新增', null, '1', '1/11', 'book:create', null, null);
INSERT INTO `sys_permissions` VALUES ('23', '', '书籍删除', null, '1', '1/11', 'book:delete', null, null);
INSERT INTO `sys_permissions` VALUES ('24', '', '书籍修改', null, '1', '1/11', 'book:update', null, null);
INSERT INTO `sys_permissions` VALUES ('25', '', '书籍查询', null, '1', '1/11', 'book:select', null, null);
INSERT INTO `sys_permissions` VALUES ('31', '', '书评管理', null, '1', '1/31', 'comment:*', null, null);
INSERT INTO `sys_permissions` VALUES ('32', '', '书评新增', null, '1', '1/11', 'comment:create', null, null);
INSERT INTO `sys_permissions` VALUES ('33', '', '书评删除', null, '1', '1/11', 'comment:delete', null, null);
INSERT INTO `sys_permissions` VALUES ('34', '', '书评修改', null, '1', '1/11', 'comment:update', null, null);
INSERT INTO `sys_permissions` VALUES ('35', '', '书评查询', null, '1', '1/11', 'comment:select', null, null);
INSERT INTO `sys_permissions` VALUES ('41', '', '权限管理', null, '1', '1/41', 'authority:*', null, null);
INSERT INTO `sys_permissions` VALUES ('42', '', '权限新增', null, '1', '1/11', 'authority:create', null, null);
INSERT INTO `sys_permissions` VALUES ('43', '', '权限删除', null, '1', '1/11', 'authority:delete', null, null);
INSERT INTO `sys_permissions` VALUES ('44', '', '权限修改', null, '1', '1/11', 'authority:update', null, null);
INSERT INTO `sys_permissions` VALUES ('45', '', '权限查询', null, '1', '1/11', 'authority:select', null, null);

-- ----------------------------
-- Table structure for sys_roles
-- ----------------------------
DROP TABLE IF EXISTS `sys_roles`;
CREATE TABLE `sys_roles` (
  `id` varchar(255) NOT NULL,
  `available` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_roles
-- ----------------------------
INSERT INTO `sys_roles` VALUES ('1', '', '超级管理员', 'super');
INSERT INTO `sys_roles` VALUES ('2', '', '管理员', 'admin');
INSERT INTO `sys_roles` VALUES ('3', '', '用户管理员', 'user-manager');
INSERT INTO `sys_roles` VALUES ('4', '', '书籍管理员', 'book-manager');
INSERT INTO `sys_roles` VALUES ('5', '', '书评管理员', 'comment-manager');
INSERT INTO `sys_roles` VALUES ('6', '', '笔记管理员', 'note-manager');

-- ----------------------------
-- Table structure for sys_roles_permissions
-- ----------------------------
DROP TABLE IF EXISTS `sys_roles_permissions`;
CREATE TABLE `sys_roles_permissions` (
  `permission_id` varchar(255) NOT NULL,
  `role_id` varchar(255) NOT NULL,
  PRIMARY KEY (`role_id`,`permission_id`),
  KEY `FK52babvlfsi3tu5newpxun9jyg` (`permission_id`),
  CONSTRAINT `FK52babvlfsi3tu5newpxun9jyg` FOREIGN KEY (`permission_id`) REFERENCES `sys_permissions` (`id`),
  CONSTRAINT `FKjeh4lw1u75s8oiso87hykb95j` FOREIGN KEY (`role_id`) REFERENCES `sys_roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_roles_permissions
-- ----------------------------
INSERT INTO `sys_roles_permissions` VALUES ('1', '1');
INSERT INTO `sys_roles_permissions` VALUES ('11', '1');
INSERT INTO `sys_roles_permissions` VALUES ('12', '3');
INSERT INTO `sys_roles_permissions` VALUES ('15', '3');
INSERT INTO `sys_roles_permissions` VALUES ('21', '1');
INSERT INTO `sys_roles_permissions` VALUES ('31', '1');
INSERT INTO `sys_roles_permissions` VALUES ('41', '1');

-- ----------------------------
-- Table structure for sys_url
-- ----------------------------
DROP TABLE IF EXISTS `sys_url`;
CREATE TABLE `sys_url` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `permissions` varchar(255) DEFAULT NULL,
  `roles` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_url
-- ----------------------------

-- ----------------------------
-- Table structure for sys_users
-- ----------------------------
DROP TABLE IF EXISTS `sys_users`;
CREATE TABLE `sys_users` (
  `id` varchar(255) NOT NULL,
  `locked` bit(1) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_users
-- ----------------------------
INSERT INTO `sys_users` VALUES ('15e7454c2ae74763997301ed58958d41', '\0', '1', null, 'test04');
INSERT INTO `sys_users` VALUES ('1d1543c29d744b4c9ab8aed4ce9d498d', '\0', '1', null, 'test05');
INSERT INTO `sys_users` VALUES ('2ec26eb066de406bb85dea79677c417a', '\0', '1', null, 'test08');
INSERT INTO `sys_users` VALUES ('36492a266e60475ea0270b90963f5360', '\0', '1', null, 'test11');
INSERT INTO `sys_users` VALUES ('43e76dffea534e448525ad4748f39874', '\0', '1', null, 'test10');
INSERT INTO `sys_users` VALUES ('652afbe1-c0df-468a-b5c5-9fa2916aeafb', '\0', 'test', '59800bb67ce168ff490ca640ef2001d4', 'super');
INSERT INTO `sys_users` VALUES ('660007b8be61472ead3e5236f0ad8e93', '\0', '1', null, 'test15');
INSERT INTO `sys_users` VALUES ('7a7eec4c6b5b4c49b7b09fa48330f3c3', '\0', '1', null, 'test09');
INSERT INTO `sys_users` VALUES ('879cdde55a49440da0075b7858bfa4c0', '\0', '1', null, 'test12');
INSERT INTO `sys_users` VALUES ('88673adf-5cb4-48c4-949c-19bffad4c048', '\0', 'test', 'c9e191b3095d19e72e9baed9c6b4955b', 'admin');
INSERT INTO `sys_users` VALUES ('95708b44564b4531bfa7ffe991b1dea6', '\0', '1', null, 'test03');
INSERT INTO `sys_users` VALUES ('96a15de273f04f2b97d6befe5149d8ec', '\0', '1', null, 'test02');
INSERT INTO `sys_users` VALUES ('ae03ba74410642aabee5c02fdc262b4f', '\0', '1', null, 'test01');
INSERT INTO `sys_users` VALUES ('bc782caf-757b-416e-94c1-81f395183acb', '\0', 'test', '8d5c9358569cd4bbfdcc48e4f06c5ad1', 'note');
INSERT INTO `sys_users` VALUES ('bee1db3a7ba444cdbdd64e9c139ac752', '\0', '1', null, 'test14');
INSERT INTO `sys_users` VALUES ('d5a1d757-331b-4480-8b3b-0ca3fb2e17d5', '\0', 'test', '5888fe7fe48345a25346562d1ff57e2d', 'user');
INSERT INTO `sys_users` VALUES ('f288fd47e7734ce39ebd26faac9b37a7', '\0', '1', null, 'test07');
INSERT INTO `sys_users` VALUES ('f3f545a8fafc49a6b490428ae537ef52', '\0', '1', null, 'test13');

-- ----------------------------
-- Table structure for sys_users_roles
-- ----------------------------
DROP TABLE IF EXISTS `sys_users_roles`;
CREATE TABLE `sys_users_roles` (
  `user_id` varchar(255) NOT NULL,
  `role_id` varchar(255) NOT NULL,
  PRIMARY KEY (`role_id`,`user_id`),
  KEY `FKhb1mqe7k1b420ejl0dohs75jx` (`user_id`),
  CONSTRAINT `FKhb1mqe7k1b420ejl0dohs75jx` FOREIGN KEY (`user_id`) REFERENCES `sys_users` (`id`),
  CONSTRAINT `FKj0mwl6bo3gaxtxjy87xbvuv3s` FOREIGN KEY (`role_id`) REFERENCES `sys_roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_users_roles
-- ----------------------------
INSERT INTO `sys_users_roles` VALUES ('652afbe1-c0df-468a-b5c5-9fa2916aeafb', '1');
INSERT INTO `sys_users_roles` VALUES ('652afbe1-c0df-468a-b5c5-9fa2916aeafb', '2');
INSERT INTO `sys_users_roles` VALUES ('652afbe1-c0df-468a-b5c5-9fa2916aeafb', '3');

-- ----------------------------
-- Table structure for t_books
-- ----------------------------
DROP TABLE IF EXISTS `t_books`;
CREATE TABLE `t_books` (
  `id` varchar(255) NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `author_intro` varchar(255) DEFAULT NULL,
  `catalog` varchar(255) DEFAULT NULL,
  `collection` int(11) DEFAULT NULL,
  `ibsn` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `pages` int(11) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `publish_date` datetime(6) DEFAULT NULL,
  `publisher` varchar(255) DEFAULT NULL,
  `summary` varchar(255) DEFAULT NULL,
  `tags` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_books
-- ----------------------------
INSERT INTO `t_books` VALUES ('10', '超级管理员', '测试人员', '目录', '100', '742424', null, '100', '10', '2018-02-24 14:09:20.000000', '测试出版部', '书籍简介', '标签', '书名书名', '古典,网络文学', 'URL');
INSERT INTO `t_books` VALUES ('11', '超级管理员', '测试人员', '目录', '100', '34534564', null, '100', '10', '2018-02-24 14:09:20.000000', '测试出版部', '书籍简介', '标签', '书名书名', '古典,网络文学', 'URL');
INSERT INTO `t_books` VALUES ('12', '超级管理员', '测试人员sssssssss', '目录', null, '4645645', null, '100', '10', '2018-02-24 14:09:20.000000', '测试出版部', '书籍简介', null, '书名书名', '古典,网络文学,散文', null);
INSERT INTO `t_books` VALUES ('13', '超级管理员', '测试人员', '目录', '100', '4434234', null, '100', '10', '2018-02-24 14:09:20.000000', '测试出版部', '书籍简介', '标签', '书名书名', '古典,网络文学', 'URL');
INSERT INTO `t_books` VALUES ('14', '超级管理员', '测试人员', '目录', '100', '434383834', null, '100', '10', '2018-02-24 14:09:20.000000', '测试出版部', '书籍简介', '标签', '书名书名', '古典,网络文学', 'URL');
INSERT INTO `t_books` VALUES ('3', '超级管理员', '测试人员', '目录', '100', '87978676', null, '100', '10', '2018-02-24 14:09:20.000000', '测试出版部', '书籍简介', '标签', '测试数据', '古典,网络文学', 'URL');
INSERT INTO `t_books` VALUES ('4', '超级管理员', '测试人员', '目录', '100', '34345', null, '100', '10', '2018-02-24 14:09:20.000000', '测试出版部', '书籍简介', '标签', '测试数据', '古典,网络文学', 'URL');
INSERT INTO `t_books` VALUES ('5', '超级管理员', '测试人员', '目录', '100', '387343434', null, '100', '10', '2018-02-24 14:09:20.000000', '测试出版部', '书籍简介', '标签', '测试数据', '古典,网络文学', 'URL');
INSERT INTO `t_books` VALUES ('6', '超级管理员', '测试人员', '目录', '100', '439453434', null, '100', '10', '2018-02-24 14:09:20.000000', '测试出版部', '书籍简介', '标签', '测试数据', '古典,网络文学', 'URL');
INSERT INTO `t_books` VALUES ('7', '超级管理员', '测试人员', '目录', '100', '4345648454', null, '100', '10', '2018-02-24 14:09:20.000000', '测试出版部', '书籍简介', '标签', '测试数据', '古典', 'URL');
INSERT INTO `t_books` VALUES ('8', '超级管理员', '测试人员', '目录', '100', '3454345', null, '100', '10', '2018-02-24 14:09:20.000000', '测试出版部', '书籍简介', '标签', '测试数据', '古典', 'URL');
INSERT INTO `t_books` VALUES ('9', '超级管理员', '测试人员', '目录', null, '4346648464544', null, '100', '10', '2018-02-24 14:09:20.000000', '测试出版部', '书籍简介sss', null, '测试数据', '古典', null);

-- ----------------------------
-- Table structure for t_collections
-- ----------------------------
DROP TABLE IF EXISTS `t_collections`;
CREATE TABLE `t_collections` (
  `id` varchar(255) NOT NULL,
  `book_id` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_collections
-- ----------------------------

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `id` varchar(255) NOT NULL,
  `book_id` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `created` datetime(6) DEFAULT NULL,
  `rating` double(255,0) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_comment
-- ----------------------------
INSERT INTO `t_comment` VALUES ('1', '3', '这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容', '2018-02-24 16:43:27.000000', '3', '书名书名', '36492a266e60475ea0270b90963f5360');
INSERT INTO `t_comment` VALUES ('10', '3', '这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容', '2018-02-24 16:43:27.000000', '3', '书名书名', '36492a266e60475ea0270b90963f5360');
INSERT INTO `t_comment` VALUES ('2', '3', '这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容', '2018-02-24 16:43:27.000000', '3', '书名书名', '36492a266e60475ea0270b90963f5360');
INSERT INTO `t_comment` VALUES ('3', '3', '这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容', '2018-02-24 16:43:27.000000', '3', '书名书名', '36492a266e60475ea0270b90963f5360');
INSERT INTO `t_comment` VALUES ('4', '3', '这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容', '2018-02-24 16:43:27.000000', '5', '书名书名', '36492a266e60475ea0270b90963f5360');
INSERT INTO `t_comment` VALUES ('5', '3', '这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容', '2018-02-24 16:43:27.000000', '5', '书名书名', '36492a266e60475ea0270b90963f5360');
INSERT INTO `t_comment` VALUES ('6', '3', '这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容', '2018-02-24 16:43:27.000000', '5', '书名书名', '36492a266e60475ea0270b90963f5360');
INSERT INTO `t_comment` VALUES ('7', '3', '这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容', '2018-02-24 16:43:27.000000', '5', '书名书名', '36492a266e60475ea0270b90963f5360');
INSERT INTO `t_comment` VALUES ('8', '3', '这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容，这是测试评论显示内容', '2018-02-24 16:43:27.000000', '4', '书名书名', '36492a266e60475ea0270b90963f5360');

-- ----------------------------
-- Table structure for t_customerinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_customerinfo`;
CREATE TABLE `t_customerinfo` (
  `id` varchar(255) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `birthday` datetime(6) DEFAULT NULL,
  `created` datetime(6) DEFAULT NULL,
  `descs` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `img_src` varchar(255) DEFAULT NULL,
  `letter_type` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `add_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_customerinfo
-- ----------------------------
INSERT INTO `t_customerinfo` VALUES ('36492a266e60475ea0270b90963f5360', '10', '2018-02-23 14:10:33.000000', '2018-02-23 14:10:33.000000', null, 'test@qq.com', 'test11', '1', '男', '10101010101', 'test11', null, '古典,网络文学', null, '440000,440100,440106');
INSERT INTO `t_customerinfo` VALUES ('43e76dffea534e448525ad4748f39874', '10', '2018-02-23 14:10:33.000000', '2018-02-23 14:10:33.000000', null, 'test@qq.com', 'test10', '1', '男', '10101010101', 'test10', null, '古典,网络文学', null, '440000,440100,440106');
INSERT INTO `t_customerinfo` VALUES ('660007b8be61472ead3e5236f0ad8e93', '10', '2018-02-23 14:10:33.000000', '2018-02-23 14:10:33.000000', null, 'test@qq.com', 'test15', '1', '男', '10101010101', 'test15', null, '古典,网络文学', null, '440000,440100,440106');
INSERT INTO `t_customerinfo` VALUES ('7a7eec4c6b5b4c49b7b09fa48330f3c3', '10', '2018-02-23 14:10:33.000000', '2018-02-23 14:10:33.000000', null, 'test@qq.com', 'test9', '1', '男', '10101010101', 'test09', null, '古典,网络文学', null, '440000,440100,440106');
INSERT INTO `t_customerinfo` VALUES ('879cdde55a49440da0075b7858bfa4c0', '10', '2018-02-23 14:10:33.000000', '2018-02-23 14:10:33.000000', null, 'test@qq.com', 'test12', '1', '男', '10101010101', 'test12', null, '古典,网络文学', null, '440000,440100,440106');
INSERT INTO `t_customerinfo` VALUES ('889d999ca8474275a23f6cd9d122b75f', null, '2018-02-24 00:00:00.000000', null, 'aaaaaa', 'aa@qq.com', null, null, '男', '1778899999', 'ssss', '', '古典,网络文学', '内蒙古自治区通辽市开鲁县', '150000,150500,150523');
INSERT INTO `t_customerinfo` VALUES ('95708b44564b4531bfa7ffe991b1dea6', '10', '2018-02-23 14:10:33.000000', '2018-02-23 14:10:33.000000', null, 'test@qq.com', 'test3', '1', '男', '10101010101', 'test03', null, '古典,网络文学', null, '440000,440100,440106');
INSERT INTO `t_customerinfo` VALUES ('96a15de273f04f2b97d6befe5149d8ec', '10', '2018-02-23 14:10:33.000000', '2018-02-23 14:10:33.000000', null, 'test@qq.com', 'test2', '1', '男', '10101010101', 'test02', null, '古典,网络文学', null, '440000,440100,440106');
INSERT INTO `t_customerinfo` VALUES ('bee1db3a7ba444cdbdd64e9c139ac752', '10', '2018-02-23 14:10:33.000000', '2018-02-23 14:10:33.000000', null, 'test@qq.com', 'test14', '1', '男', '10101010101', 'test14', null, '古典,网络文学', null, '440000,440100,440106');
INSERT INTO `t_customerinfo` VALUES ('f288fd47e7734ce39ebd26faac9b37a7', '10', '2018-02-23 14:10:33.000000', '2018-02-23 14:10:33.000000', null, 'test@qq.com', 'test7 ', '1', '男', '10101010101', 'test07', null, '古典,网络文学', null, '440000,440100,440106');
INSERT INTO `t_customerinfo` VALUES ('f3f545a8fafc49a6b490428ae537ef52', '10', '2018-02-23 14:10:33.000000', '2018-02-23 14:10:33.000000', null, 'test@qq.com', 'test13', '1', '男', '10101010101', 'test13', null, '古典,网络文学', null, '440000,440100,440106');

-- ----------------------------
-- Table structure for t_notes
-- ----------------------------
DROP TABLE IF EXISTS `t_notes`;
CREATE TABLE `t_notes` (
  `id` varchar(255) NOT NULL,
  `book_id` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `create_time` datetime(6) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `update_time` datetime(6) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_notes
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` varchar(255) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `birthday` datetime(6) DEFAULT NULL,
  `created` datetime(6) DEFAULT NULL,
  `descs` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('21cd3e64c4b84c2c975e078ddc823a8d', null, null, null, null, '1@qq.com', '111', '1', null, '10101010101', '1111');
INSERT INTO `t_user` VALUES ('66b24a4fa69a4defb2a4cf04f262c302', null, null, null, null, 'test@qq.com', 'test', '1', null, '10101010101', 'test');
