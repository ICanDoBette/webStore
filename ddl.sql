CREATE TABLE `comment` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `good_id` INT(11) NOT NULL COMMENT '商品id',
  `user_id` INT(11) NOT NULL COMMENT '用户id',
  `star` INT(11) NOT NULL COMMENT '星级',
  `comment` VARCHAR(200) COLLATE utf8_bin NOT NULL COMMENT '评论',
  `create_time` DATE NOT NULL COMMENT '创建时间',
  `create_user` VARCHAR(20) COLLATE utf8_bin NOT NULL COMMENT '创建人',
  `update_time` DATE NOT NULL COMMENT '更新时间',
  `update_user` VARCHAR(20) COLLATE utf8_bin NOT NULL COMMENT '更新人',
  `is_delete` TINYINT(4) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
CREATE TABLE `goods` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` VARCHAR(20) CHARACTER SET utf8 NOT NULL COMMENT '商品名',
  `picture_path` TEXT COLLATE utf8_bin COMMENT '图片路径',
  `big_type` INT(11) NOT NULL COMMENT '商品大类',
  `small_type` INT(11) NOT NULL COMMENT '商品小类',
  `count` INT(11) NOT NULL DEFAULT '0' COMMENT '库存',
  `price` INT(11) NOT NULL COMMENT '价格',
  `information` TEXT CHARACTER SET utf8 COMMENT '商品信息',
  `is_down` TINYINT(4) NOT NULL DEFAULT '0' COMMENT '是否下架',
  `create_time` DATE NOT NULL COMMENT '创建时间',
  `create_user` VARCHAR(20) CHARACTER SET utf8 NOT NULL COMMENT '创建人',
  `update_time` DATE NOT NULL COMMENT '更新时间',
  `update_user` VARCHAR(20) CHARACTER SET utf8 NOT NULL COMMENT '更新人',
  `is_delete` TINYINT(4) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
CREATE TABLE `news` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `type` INT(11) NOT NULL COMMENT '新闻类型(1:大图轮播 2:左下展示)',
  `title` VARCHAR(50) COLLATE utf8_bin NOT NULL COMMENT '标题',
  `priority` INT(11) NOT NULL COMMENT '优先级',
  `picture_path` TEXT COLLATE utf8_bin COMMENT '图片路径',
  `contain` TEXT COLLATE utf8_bin COMMENT '内容',
  `hot` TINYINT(4) NOT NULL DEFAULT '0' COMMENT '热搜',
  `create_time` DATE NOT NULL COMMENT '创建时间',
  `create_user` VARCHAR(20) COLLATE utf8_bin NOT NULL COMMENT '创建人',
  `update_time` DATE NOT NULL COMMENT '更新时间',
  `update_user` VARCHAR(20) COLLATE utf8_bin NOT NULL COMMENT '更新人',
  `is_delete` TINYINT(4) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
CREATE TABLE `type` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `level` INT(11) NOT NULL DEFAULT '1' COMMENT '类型等级',
  `name` VARCHAR(20) COLLATE utf8_bin NOT NULL COMMENT '类型名称',
  `father_id` INT(11) NOT NULL COMMENT '父级id,无父级时为-1' DEFAULT -1,
  `priority` INT(11) NOT NULL COMMENT '优先级',
  `create_time` DATE NOT NULL COMMENT '创建时间',
  `create_user` VARCHAR(20) COLLATE utf8_bin NOT NULL COMMENT '创建人',
  `update_time` DATE NOT NULL COMMENT '更新时间',
  `update_user` VARCHAR(20) COLLATE utf8_bin NOT NULL COMMENT '更新人',
  `is_delete` TINYINT(4) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
CREATE TABLE `user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `name` VARCHAR(20) COLLATE utf8_bin NOT NULL COMMENT '用户名',
  `password` VARCHAR(50) COLLATE utf8_bin NOT NULL COMMENT '密码',
  `tel` VARCHAR(16) COLLATE utf8_bin NOT NULL COMMENT '电话',
  `email` VARCHAR(50) COLLATE utf8_bin NOT NULL COMMENT '邮箱',
  `create_time` DATE NOT NULL COMMENT '创建时间',
  `create_user` VARCHAR(20) COLLATE utf8_bin NOT NULL COMMENT '创建人',
  `update_time` DATE NOT NULL COMMENT '更新时间',
  `update_user` VARCHAR(20) COLLATE utf8_bin NOT NULL COMMENT '更新人',
  `is_delete` TINYINT(4) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
CREATE TABLE `headgood` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `good_id` int(11) NOT NULL COMMENT '商品id',
  `comment` varchar(200) COLLATE utf8_bin NOT NULL COMMENT '简介',
  `picture_path` text COLLATE utf8_bin COMMENT '图片路径',
  `create_time` date NOT NULL COMMENT '创建时间',
  `create_user` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '创建人',
  `update_time` date NOT NULL COMMENT '更新时间',
  `update_user` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '更新人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
CREATE TABLE `shopcar` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `good_id` INT(11) NOT NULL COMMENT '货物id',
  `user_id` INT(11) NOT NULL COMMENT '用户id',
  `good_count` INT(11) NOT NULL COMMENT '购买数量',
  `create_time` DATE NOT NULL COMMENT '创建时间',
  `create_user` VARCHAR(20) CHARACTER SET utf8 NOT NULL COMMENT '创建人',
  `update_time` DATE NOT NULL COMMENT '更新时间',
  `update_user` VARCHAR(20) CHARACTER SET utf8 NOT NULL COMMENT '更新人',
  `is_delete` TINYINT(4) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
CREATE TABLE `address` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` INT(11) NOT NULL COMMENT '用户id',
  `addres` TEXT COLLATE utf8_bin NOT NULL COMMENT '收货地址',
  `tel` VARCHAR(16) COLLATE utf8_bin NOT NULL COMMENT '收货电话',
  `name` VARCHAR(20) COLLATE utf8_bin NOT NULL COMMENT '收件人人',
  `level` INT(11) NOT NULL COMMENT '收货地址等级',
  `create_time` DATE NOT NULL COMMENT '创建时间',
  `create_user` VARCHAR(20) COLLATE utf8_bin NOT NULL COMMENT '创建人',
  `update_time` DATE NOT NULL COMMENT '更新时间',
  `update_user` VARCHAR(20) COLLATE utf8_bin NOT NULL COMMENT '更新人',
  `is_delete` TINYINT(4) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
CREATE TABLE `alreadyBuy` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `good_id` INT(11) NOT NULL COMMENT '货物id',
  `user_id` INT(11) NOT NULL COMMENT '用户id',
  `address_id` INT(11) NOT NULL COMMENT '收货地址id',
  `good_count` INT(11) NOT NULL COMMENT '购买数量',
  `pay` INT(11) NOT NULL COMMENT '付款',
  `state` TINYINT(4) NOT NULL DEFAULT '0' COMMENT '0:未发货,1:已发货,2:待领取,3:交易完成,4:申请售后',
  `create_time` DATE NOT NULL COMMENT '创建时间',
  `create_user` VARCHAR(20) CHARACTER SET utf8 NOT NULL COMMENT '创建人',
  `update_time` DATE NOT NULL COMMENT '更新时间',
  `update_user` VARCHAR(20) CHARACTER SET utf8 NOT NULL COMMENT '更新人',
  `is_delete` TINYINT(4) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
CREATE TABLE `banks` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` VARCHAR(20) CHARACTER SET utf8 NOT NULL COMMENT '银行英文',
  `label` VARCHAR(20) CHARACTER SET utf8 NOT NULL COMMENT  '银行中文',
  `style`  VARCHAR(50) CHARACTER SET utf8 NOT NULL COMMENT '图片定位',
  `level` INT(11) NOT NULL COMMENT '优先级',
  `create_time` DATE NOT NULL COMMENT '创建时间',
  `create_user` VARCHAR(20) CHARACTER SET utf8 NOT NULL COMMENT '创建人',
  `update_time` DATE NOT NULL COMMENT '更新时间',
  `update_user` VARCHAR(20) CHARACTER SET utf8 NOT NULL COMMENT '更新人',
  `is_delete` TINYINT(4) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;