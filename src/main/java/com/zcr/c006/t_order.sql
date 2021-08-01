

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `id` bigint(11) NOT NULL,
  `member_id` bigint(20) NULL DEFAULT NULL COMMENT '下单人id',
  `price` int(11) NULL DEFAULT NULL COMMENT '订单价格（分）',
  `order_status` int(2) NULL DEFAULT NULL COMMENT '订单状态1.新建订单。2.已支付.3.已发货',
  `create_time` bigint(20) NULL DEFAULT NULL,
  `update_time` bigint(20) NULL DEFAULT NULL,
  `status` int(2) NULL DEFAULT NULL COMMENT '数据状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
