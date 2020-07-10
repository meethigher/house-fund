/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : fund

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 10/07/2020 12:05:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb001
-- ----------------------------
DROP TABLE IF EXISTS `tb001`;
CREATE TABLE `tb001`  (
  `seqname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '键值信息',
  `seq` int(255) NOT NULL COMMENT '当前序号',
  `maxseq` int(255) NOT NULL DEFAULT 999999999 COMMENT '最大序号',
  `desc` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '描述',
  `freeuse` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用1',
  UNIQUE INDEX `tb001_pk_1`(`seqname`) USING BTREE COMMENT '唯一索引，键值信息'
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb001
-- ----------------------------
INSERT INTO `tb001` VALUES ('peraccnum', 16, 999999999, '公积金个人账号序号', NULL);
INSERT INTO `tb001` VALUES ('unitaccnum', 5, 999999999, '公积金单位账号序号', NULL);

-- ----------------------------
-- Table structure for tb002
-- ----------------------------
DROP TABLE IF EXISTS `tb002`;
CREATE TABLE `tb002`  (
  `unitaccnum` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '单位公积金账号，自动生成，\r\n',
  `unitaccname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '单位名称，页面录入',
  `unitaddr` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '单位地址，页面录入',
  `orgcode` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '组织机构代码，页面录入',
  `unitchar` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '1-企业\r\n2-事业\r\n3-机关\r\n4-团体\r\n5-其他\r\n，页面录入',
  `unitkind` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '110-国有经济\r\n120-集体经济\r\n130-股份合作企业\r\n140-联营企业\r\n150-有限责任公司\r\n160-股份有限公司\r\n170-私营企业\r\n190-其他企业\r\n200-港澳台商投资企业\r\n300-外商投资企业\r\n900-其他，页面录入',
  `salarydate` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发薪日期，页面录入',
  `unitphone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系电话，页面录入',
  `unitlinkman` varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '单位联系人，页面录入',
  `unitagentpapno` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经办人身份证号码，页面录入',
  `accstate` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '0-正常\r\n9-销户，开户时默认为0',
  `balance` decimal(16, 2) NOT NULL DEFAULT 0.00 COMMENT '公积金余额，单位下所有个人公积金余额之和，开户时默认为0',
  `basenumber` decimal(16, 2) NOT NULL DEFAULT 0.00 COMMENT '缴存基数，单位下所有个人的缴存基数之和，开户时默认为0',
  `unitprop` decimal(6, 3) NOT NULL COMMENT '单位比例，页面录入',
  `perprop` decimal(6, 3) NOT NULL COMMENT '个人比例，页面录入',
  `unitpaysum` decimal(16, 2) NOT NULL DEFAULT 0.00 COMMENT '单位月应缴额，单位下所有非销户个人的单位月应缴额之和，开户时默认为0',
  `perpaysum` decimal(16, 2) NOT NULL DEFAULT 0.00 COMMENT '个人月应缴额，单位下所有非销户个人的个人月应缴额之和，开户时默认为0',
  `persnum` int(11) NOT NULL DEFAULT 0 COMMENT '单位人数，非销户人数，开户时默认为0',
  `lastpaydate` date NOT NULL DEFAULT '1899-12-01' COMMENT '最后缴汇月，开户时默认，待汇缴时改为实际汇缴年月',
  `instcode` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0110' COMMENT '公积金中心机构代码，页面录入',
  `op` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '111111' COMMENT '柜员，获取当前登录管理员的用户名录入',
  `createdate` date NOT NULL COMMENT '创建日期，自动获取创建时间填充',
  `remark` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注，页面录入',
  PRIMARY KEY (`unitaccnum`) USING BTREE,
  UNIQUE INDEX `tb002_PK_1`(`unitaccnum`) USING BTREE,
  UNIQUE INDEX `tb002_PK_2`(`unitaccname`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb002
-- ----------------------------
INSERT INTO `tb002` VALUES ('000000000001', '阿里巴巴网络技术有限公司', '浙江省杭州市滨江区网商路699号', '24525255', '1', '160', '20', '13838385638', '马云', '138383383838383838', '0', 0.00, 125665.00, 0.120, 0.050, 15079.80, 6283.25, 5, '1899-12-01', '0110', '胡列娜', '2020-06-30', '风清扬。阿里巴巴创始人、创业十八罗汉之一');
INSERT INTO `tb002` VALUES ('000000000002', '小米科技有限责任公司', '北京市海淀区西二旗中路33号院6号楼6层006号', '24525256', '1', '150', '2', '13838385638', '雷军', '138383383838383838', '0', 0.00, 31788.00, 0.120, 0.050, 3814.56, 1589.40, 5, '1899-12-01', '0110', '胡列娜', '2020-06-30', '雷军，全国工商联副主席、金山软件公司董事长，小米科技CEO');
INSERT INTO `tb002` VALUES ('000000000003', '华为技术有限公司', '深圳市龙岗区坂田华为总部办公楼', '24525257', '1', '170', '5', '13838385638', '任正非', '138383383838383838', '9', 0.00, 0.00, 0.050, 0.120, 0.00, 0.00, 0, '1899-12-01', '0110', '江厌离', '2020-07-10', '任正非，华为技术有限公司主要创始人');
INSERT INTO `tb002` VALUES ('000000000004', '深圳市腾讯计算机系统有限公司', '深圳市南山区粤海街道麻岭社区科技中一路腾讯大厦35层', '24525258', '1', '150', '1', '13838385638', '马化腾', '138383383838383838', '0', 0.00, 999999.00, 0.080, 0.080, 79999.92, 79999.92, 1, '1899-12-01', '0110', '江厌离', '2020-07-10', '马化腾，1998年创立腾讯公司');

-- ----------------------------
-- Table structure for tb003
-- ----------------------------
DROP TABLE IF EXISTS `tb003`;
CREATE TABLE `tb003`  (
  `accnum` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '个人公积金账号，自动生成',
  `accname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名，页面录入',
  `papno` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号，页面录入',
  `unitaccnum` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '单位公积金账号，页面录入',
  `opendate` date NULL DEFAULT NULL COMMENT '开户日期，自动生成',
  `balance` decimal(16, 2) NULL DEFAULT 0.00 COMMENT '公积金余额，开户时默认为0',
  `peraccstate` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '开户时默认为0。\r\n0-正常\r\n9-销户',
  `basenumber` decimal(16, 2) NOT NULL COMMENT '缴存基数，页面录入',
  `unitprop` decimal(6, 3) NOT NULL COMMENT '单位比例，取单位表的单位比例',
  `perprop` decimal(6, 3) NOT NULL COMMENT '个人比例，取单位表的个人比例',
  `lastpaydate` date NULL DEFAULT '1899-12-01' COMMENT '最后汇缴月，默认值1899-12-01',
  `unitmonpaysum` decimal(16, 2) NOT NULL COMMENT '单位月应缴额，等于缴存基数*单位比例',
  `permonpaysum` decimal(16, 2) NOT NULL COMMENT '个人月应缴额，等于缴存基数*个人比例',
  `ypayamt` decimal(16, 2) NOT NULL DEFAULT 0.00 COMMENT '本年汇补缴额，开户时默认为0',
  `ydrawamt` decimal(16, 2) NOT NULL DEFAULT 0.00 COMMENT '年提取额，开户时默认为0',
  `yinterestbal` decimal(16, 2) NOT NULL DEFAULT 0.00 COMMENT '年度结息，开户时默认为0',
  `instcode` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0110' COMMENT '公积金中心机构代码，默认值0110',
  `op` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '111111' COMMENT '柜员',
  `remark` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`accnum`) USING BTREE,
  UNIQUE INDEX `tb003_PK_1`(`accnum`) USING BTREE,
  UNIQUE INDEX `tb003_PK_3`(`papno`) USING BTREE,
  INDEX `tb003_PK_2`(`unitaccnum`) USING BTREE,
  CONSTRAINT `tb003_PK_2` FOREIGN KEY (`unitaccnum`) REFERENCES `tb002` (`unitaccnum`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb003
-- ----------------------------
INSERT INTO `tb003` VALUES ('000000000001', '雷军', '692548202007081584', '000000000002', '2020-07-08', 0.00, '9', 80000.00, 0.120, 0.050, '1899-12-01', 9600.00, 4000.00, 0.00, 0.00, 0.00, '0110', '胡列娜', '改变中国史上手机价格走势第一人！永远相信美好的事情即将发生！小米牛逼，雷军牛逼！');
INSERT INTO `tb003` VALUES ('000000000002', '马云', '692548202007081583', '000000000001', '2020-07-08', 0.00, '9', 100000.00, 0.120, 0.050, '1899-12-01', 12000.00, 5000.00, 0.00, 0.00, 0.00, '0110', '胡列娜', '马云大大牛逼');
INSERT INTO `tb003` VALUES ('000000000003', '卢伟冰', '692548202007081585', '000000000002', '2020-07-08', 0.00, '9', 3333.00, 0.120, 0.050, '1899-12-01', 266.64, 111.10, 0.00, 0.00, 0.00, '0110', '江厌离', '现任小米中国区总裁兼红米Redmi品牌总经理。怼天怼地铁憨憨，志在干掉友军，干掉小米，红米一家独大');
INSERT INTO `tb003` VALUES ('000000000004', '张勇', '692548202007081586', '000000000001', '2020-07-08', 0.00, '0', 2222.00, 0.120, 0.050, '1899-12-01', 266.64, 111.10, 0.00, 0.00, 0.00, '0110', '江厌离', '逍遥子。阿里巴巴集团董事局执行主席、首席执行官（CEO）');
INSERT INTO `tb003` VALUES ('000000000005', '陆兆禧', '692548202007081587', '000000000001', '2020-07-08', 0.00, '0', 4555.00, 0.120, 0.050, '1899-12-01', 546.60, 227.75, 0.00, 0.00, 0.00, '0110', '江厌离', '铁木真，阿里巴巴集团副主席	');
INSERT INTO `tb003` VALUES ('000000000006', '姜鹏', '692548202007081588', '000000000001', '2020-07-08', 0.00, '0', 20000.00, 0.120, 0.050, '1899-12-01', 2400.00, 1000.00, 0.00, 0.00, 0.00, '0110', '江厌离', '三丰。淘宝网创始人之一、阿里巴巴集团副首席技术官（CTO）');
INSERT INTO `tb003` VALUES ('000000000007', '邵晓锋', '692548202007081589', '000000000001', '2020-07-08', 0.00, '0', 10000.00, 0.120, 0.050, '1899-12-01', 1200.00, 500.00, 0.00, 0.00, 0.00, '0110', '江厌离', '郭靖。阿里巴巴集团秘书长、首席风险官（CRO）');
INSERT INTO `tb003` VALUES ('000000000008', '戴珊', '692548202007081590', '000000000001', '2020-07-08', 0.00, '0', 88888.00, 0.120, 0.050, '1899-12-01', 10666.56, 4444.40, 0.00, 0.00, 0.00, '0110', '江厌离', '苏笙。阿里巴巴集团首席客户服务官（CCO）、阿里创业十八罗汉之一');
INSERT INTO `tb003` VALUES ('000000000009', '林斌', '692548202007081591', '000000000002', '2020-07-08', 0.00, '0', 888.00, 0.120, 0.050, '1899-12-01', 106.56, 44.40, 0.00, 0.00, 0.00, '0110', '江厌离', '小米公司联合创始人、总裁 ');
INSERT INTO `tb003` VALUES ('000000000010', '周光平', '692548202007081592', '000000000002', '2020-07-08', 0.00, '0', 12345.00, 0.120, 0.050, '1899-12-01', 1481.40, 617.25, 0.00, 0.00, 0.00, '0110', '江厌离', '小米科技联合创始人');
INSERT INTO `tb003` VALUES ('000000000011', '黄江吉', '692548202007081594', '000000000002', '2020-07-09', 0.00, '0', 5555.00, 0.120, 0.050, '1899-12-01', 666.60, 277.75, 0.00, 0.00, 0.00, '0110', '江厌离', '小米科技联合创始人');
INSERT INTO `tb003` VALUES ('000000000012', '刘德', '692548202007081595', '000000000002', '2020-07-09', 0.00, '0', 8000.00, 0.120, 0.050, '1899-12-01', 960.00, 400.00, 0.00, 0.00, 0.00, '0110', '江厌离', '小米科技联合创始人');
INSERT INTO `tb003` VALUES ('000000000013', '洪峰', '692548202007081596', '000000000002', '2020-07-09', 0.00, '9', 8000.00, 0.120, 0.050, '1899-12-01', 960.00, 400.00, 0.00, 0.00, 0.00, '0110', '江厌离', '洪锋毕业于上海交通大学，取得计算机科学与工程学士学位，后取得美国普渡大学计算机科学硕士。 ');
INSERT INTO `tb003` VALUES ('000000000014', '王川', '692548202007081597', '000000000002', '2020-07-09', 0.00, '0', 5000.00, 0.120, 0.050, '1899-12-01', 600.00, 250.00, 0.00, 0.00, 0.00, '0110', '江厌离', '2012年，王川加入小米科技，担任联合创始人及副总裁');
INSERT INTO `tb003` VALUES ('000000000015', '马化腾', '692548202007081599', '000000000004', '2020-07-10', 0.00, '0', 999999.00, 0.080, 0.080, '1899-12-01', 79999.92, 79999.92, 0.00, 0.00, 0.00, '0110', '江厌离', '马化腾，1998年创立腾讯公司');

-- ----------------------------
-- Table structure for tb004
-- ----------------------------
DROP TABLE IF EXISTS `tb004`;
CREATE TABLE `tb004`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `addr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lasttime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb004
-- ----------------------------
INSERT INTO `tb004` VALUES (1, '胡列娜', '5201314', '127.0.0.1', '2020-07-10 10:54:11');
INSERT INTO `tb004` VALUES (3, '江厌离', '1314520', '127.0.0.1', '2020-07-10 11:37:52');

SET FOREIGN_KEY_CHECKS = 1;
