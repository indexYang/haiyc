/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : haiyc

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 06/11/2020 16:22:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for base_menu
-- ----------------------------
DROP TABLE IF EXISTS `base_menu`;
CREATE TABLE `base_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menuName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `menuUrl` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单url',
  `parentMenuId` bigint(20) NULL DEFAULT NULL COMMENT '父级菜单id',
  `seq` int(2) NULL DEFAULT NULL COMMENT '菜单序号',
  `level` tinyint(1) NULL DEFAULT NULL COMMENT '菜单层级，1：一级，2：二级',
  `menuImage` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图片',
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '状态，1：启用，0：禁用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '基础表-菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of base_menu
-- ----------------------------
INSERT INTO `base_menu` VALUES (1, '系统首页', 'dashboard', 0, 1, 1, 'el-icon-lx-home', 1);
INSERT INTO `base_menu` VALUES (2, '基础表格', '/table', 0, 2, 1, 'el-icon-lx-cascades', 1);
INSERT INTO `base_menu` VALUES (3, 'tab选项卡', '/tabs', 0, 3, 1, 'el-icon-lx-copy', 1);
INSERT INTO `base_menu` VALUES (4, '表单相关', '/3', 0, 4, 1, 'el-icon-lx-calendar', 1);
INSERT INTO `base_menu` VALUES (5, '基本表单', '/form', 4, 1, 2, '', 1);
INSERT INTO `base_menu` VALUES (6, '三级菜单', '/3-2', 4, 2, 2, '', 1);
INSERT INTO `base_menu` VALUES (7, '富文本编辑器', '/editor', 6, 1, 3, '', 1);
INSERT INTO `base_menu` VALUES (8, 'markdown编辑器', '/markdown', 6, 2, 3, '', 1);
INSERT INTO `base_menu` VALUES (9, '文件上传', '/upload', 4, 3, 2, '', 1);
INSERT INTO `base_menu` VALUES (10, '自定义图标', '/icon', 0, 5, 1, 'el-icon-lx-emoji', 1);
INSERT INTO `base_menu` VALUES (11, 'schart图表', '/charts', 0, 6, 1, 'el-icon-pie-chart', 1);
INSERT INTO `base_menu` VALUES (12, '拖拽组件', '/6', 0, 7, 1, 'el-icon-rank', 1);
INSERT INTO `base_menu` VALUES (13, '拖拽列表', '/drag', 12, 1, 2, '', 1);
INSERT INTO `base_menu` VALUES (14, '拖拽弹框', '/dialog', 12, 2, 2, '', 1);
INSERT INTO `base_menu` VALUES (15, '国际化功能', '/i18n', 0, 8, 1, 'el-icon-lx-global', 1);
INSERT INTO `base_menu` VALUES (16, '错误处理', '/7', 0, 9, 1, 'el-icon-lx-warn', 1);
INSERT INTO `base_menu` VALUES (17, '权限测试', '/permission', 16, 1, 2, '', 1);
INSERT INTO `base_menu` VALUES (18, '404页面', '/404', 16, 2, 2, '', 1);
INSERT INTO `base_menu` VALUES (19, '用户', '/user', 0, 10, 1, 'el-icon-lx-peoplefill', 1);

-- ----------------------------
-- Table structure for base_menu_permission
-- ----------------------------
DROP TABLE IF EXISTS `base_menu_permission`;
CREATE TABLE `base_menu_permission`  (
  `id` bigint(10) NULL DEFAULT NULL COMMENT '主键',
  `menuId` bigint(20) NULL DEFAULT NULL COMMENT '菜单id',
  `permissionUrl` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '权限URL',
  `permissionName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '权限名称',
  `permissionCode` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '权限码:根据用户登录时判断页面的操作时否显示',
  `status` tinyint(1) NULL DEFAULT 1 COMMENT '状态 1:有效 2:无效'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '菜单权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of base_menu_permission
-- ----------------------------
INSERT INTO `base_menu_permission` VALUES (1, 1, '/', '查询', 'sys:user:view', 1);
INSERT INTO `base_menu_permission` VALUES (2, 1, '/', '新增', 'sys:user:add', 1);

-- ----------------------------
-- Table structure for base_role
-- ----------------------------
DROP TABLE IF EXISTS `base_role`;
CREATE TABLE `base_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `roleName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `roleDescribe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '状态 0-删除 1-未删除',
  `createDate` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modifyDate` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `creatorId` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `modifierId` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '基础表-角色信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of base_role
-- ----------------------------
INSERT INTO `base_role` VALUES (1, '超级管理员', '上天入地，无所不能', 1, '2020-03-26 17:14:42', NULL, NULL, NULL);
INSERT INTO `base_role` VALUES (2, '普通角色', '正常人', 1, '2020-03-26 17:20:56', NULL, NULL, NULL);
INSERT INTO `base_role` VALUES (3, '财务负责人', '财政大权手中拿', 1, '2020-03-27 14:46:01', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for base_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `base_role_menu`;
CREATE TABLE `base_role_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `roleId` bigint(20) NULL DEFAULT NULL COMMENT '角色id',
  `menuId` bigint(20) NULL DEFAULT NULL COMMENT '菜单id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '基础表-角色菜单关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of base_role_menu
-- ----------------------------
INSERT INTO `base_role_menu` VALUES (1, 1, 1);
INSERT INTO `base_role_menu` VALUES (2, 1, 2);
INSERT INTO `base_role_menu` VALUES (3, 1, 3);
INSERT INTO `base_role_menu` VALUES (4, 1, 4);
INSERT INTO `base_role_menu` VALUES (5, 1, 5);
INSERT INTO `base_role_menu` VALUES (6, 1, 6);
INSERT INTO `base_role_menu` VALUES (7, 1, 7);
INSERT INTO `base_role_menu` VALUES (8, 1, 8);
INSERT INTO `base_role_menu` VALUES (9, 1, 9);
INSERT INTO `base_role_menu` VALUES (10, 1, 10);
INSERT INTO `base_role_menu` VALUES (11, 1, 11);
INSERT INTO `base_role_menu` VALUES (12, 1, 12);
INSERT INTO `base_role_menu` VALUES (13, 1, 13);
INSERT INTO `base_role_menu` VALUES (14, 1, 14);
INSERT INTO `base_role_menu` VALUES (15, 1, 15);
INSERT INTO `base_role_menu` VALUES (16, 1, 16);
INSERT INTO `base_role_menu` VALUES (17, 1, 17);
INSERT INTO `base_role_menu` VALUES (18, 1, 18);
INSERT INTO `base_role_menu` VALUES (19, 1, 19);
INSERT INTO `base_role_menu` VALUES (20, 2, 1);
INSERT INTO `base_role_menu` VALUES (21, 2, 2);
INSERT INTO `base_role_menu` VALUES (22, 3, 1);

-- ----------------------------
-- Table structure for base_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `base_role_permission`;
CREATE TABLE `base_role_permission`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `roleId` bigint(20) NULL DEFAULT NULL COMMENT '角色id',
  `permissionId` bigint(20) NULL DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '基础表-角色权限关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of base_role_permission
-- ----------------------------
INSERT INTO `base_role_permission` VALUES (1, 1, 1);
INSERT INTO `base_role_permission` VALUES (2, 1, 2);
INSERT INTO `base_role_permission` VALUES (3, 2, 1);
INSERT INTO `base_role_permission` VALUES (4, 3, 1);

-- ----------------------------
-- Table structure for base_user
-- ----------------------------
DROP TABLE IF EXISTS `base_user`;
CREATE TABLE `base_user`  (
  `userNo` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户编码',
  `userName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `salt` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '加密盐',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `sex` tinyint(1) NULL DEFAULT NULL COMMENT '性别 0-女孩 1-男孩 2-变态 3-人妖',
  `birthDate` date NULL DEFAULT NULL COMMENT '出生日期',
  `imgHead` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '状态 0-删除 1-未删除 2-锁定',
  `createDate` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modifyDate` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `creatorId` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `modifierId` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`userNo`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of base_user
-- ----------------------------
INSERT INTO `base_user` VALUES ('2020201029132001', 'admin', '123456', NULL, '13851508664', 25, '1994-07-15', NULL, 1, '2020-10-29 13:21:55', '2020-10-29 13:21:58', '2020201029132001', '2020201029132001');

-- ----------------------------
-- Table structure for base_user_role
-- ----------------------------
DROP TABLE IF EXISTS `base_user_role`;
CREATE TABLE `base_user_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userNo` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户编码',
  `roleId` bigint(20) NULL DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '基础表-用户角色关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of base_user_role
-- ----------------------------
INSERT INTO `base_user_role` VALUES (1, '2020201029132001', 1);

SET FOREIGN_KEY_CHECKS = 1;
