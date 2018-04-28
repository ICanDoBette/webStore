/*
SQLyog v10.2 
MySQL - 5.5.27 : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `test`;

/*Table structure for table `address` */

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `addres` text COLLATE utf8_bin NOT NULL COMMENT '收货地址',
  `tel` varchar(16) COLLATE utf8_bin NOT NULL COMMENT '收货电话',
  `name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '收件人人',
  `level` int(11) NOT NULL COMMENT '收货地址等级',
  `create_time` date NOT NULL COMMENT '创建时间',
  `create_user` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '创建人',
  `update_time` date NOT NULL COMMENT '更新时间',
  `update_user` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '更新人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `address` */

insert  into `address`(`id`,`user_id`,`addres`,`tel`,`name`,`level`,`create_time`,`create_user`,`update_time`,`update_user`,`is_delete`) values (1,1,'舒服的','18797818175','hhahhah',1,'2018-04-27','hello','2018-04-27','hello',0),(2,1,'白盒','18797818175','第三个',1,'2018-04-27','hello','2018-04-27','hello',0),(3,1,'假的','+8618797818175','哈哈',1,'2018-04-27','hello','2018-04-27','hello',0),(4,1,'哈哈','18797818175','叫姐姐',1,'2018-04-27','hello','2018-04-27','hello',0),(5,1,'sad','sadas','sadasd',1,'2018-04-27','hello','2018-04-27','hello',0),(6,1,'sad','sadas','sadasd',1,'2018-04-27','hello','2018-04-27','hello',0),(7,1,'sad','sadas','sadasd',1,'2018-04-27','hello','2018-04-27','hello',1),(8,1,'sad','sadas','sadasd',1,'2018-04-27','hello','2018-04-27','hello',0),(9,1,'sad','sadas','sadasd',1,'2018-04-27','hello','2018-04-27','hello',1);

/*Table structure for table `alreadybuy` */

DROP TABLE IF EXISTS `alreadybuy`;

CREATE TABLE `alreadybuy` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `good_id` int(11) NOT NULL COMMENT '货物id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `address_id` int(11) NOT NULL COMMENT '收货地址id',
  `good_count` int(11) NOT NULL COMMENT '购买数量',
  `pay` int(11) NOT NULL COMMENT '付款',
  `state` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0:未发货,1:已发货,2:待领取,3:交易完成,4:申请售后',
  `create_time` date NOT NULL COMMENT '创建时间',
  `create_user` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '创建人',
  `update_time` date NOT NULL COMMENT '更新时间',
  `update_user` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '更新人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `alreadybuy` */

insert  into `alreadybuy`(`id`,`good_id`,`user_id`,`address_id`,`good_count`,`pay`,`state`,`create_time`,`create_user`,`update_time`,`update_user`,`is_delete`) values (1,1,1,2,2,300,0,'2018-04-27','hello','2018-04-27','hello',0),(2,4,1,2,3,300,3,'2018-04-27','hello','2018-04-27','hello',0),(3,5,1,3,2,300,0,'2018-04-27','hello','2018-04-27','hello',0),(4,8,1,4,8,300,0,'2018-04-28','hello','2018-04-28','hello',0),(5,9,1,4,4,300,0,'2018-04-28','hello','2018-04-28','hello',0);

/*Table structure for table `banks` */

DROP TABLE IF EXISTS `banks`;

CREATE TABLE `banks` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '银行英文',
  `label` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '银行中文',
  `style` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '图片定位',
  `level` int(11) NOT NULL COMMENT '优先级',
  `create_time` date NOT NULL COMMENT '创建时间',
  `create_user` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '创建人',
  `update_time` date NOT NULL COMMENT '更新时间',
  `update_user` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '更新人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `banks` */

insert  into `banks`(`id`,`name`,`label`,`style`,`level`,`create_time`,`create_user`,`update_time`,`update_user`,`is_delete`) values (1,'zhaoshang','招商银行','background-position: -2160px 0;',1,'2018-04-27','Sys','2018-04-27','Sys',0),(2,'jianshe','中国建设银行','background-position: -720px 0;',1,'2018-04-27','Sys','2018-04-27','Sys',0),(3,'pufa','浦发银行','background-position: -1800px 0;',1,'2018-04-27','Sys','2018-04-27','Sys',0),(4,'jiaotong','交通银行','background-position: -3120px 0;',1,'2018-04-27','Sys','2018-04-27','Sys',0),(5,'gongshang','中国工商银行','background-position: -2640px 0;',1,'2018-04-27','Sys','2018-04-27','Sys',0),(6,'nongye','中国农业银行','background-position: -1680px 0;',1,'2018-04-27','Sys','2018-04-27','Sys',0),(7,'zhongguo','中国银行','background-position: -2520px 0;',1,'2018-04-27','Sys','2018-04-27','Sys',0),(8,'zhongxin','中信银行','background-position: -480px 0;',1,'2018-04-27','Sys','2018-04-27','Sys',0);

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `good_id` int(11) NOT NULL COMMENT '商品id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `star` int(11) NOT NULL COMMENT '星级',
  `comment` varchar(200) COLLATE utf8_bin NOT NULL COMMENT '评论',
  `create_time` date NOT NULL COMMENT '创建时间',
  `create_user` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '创建人',
  `update_time` date NOT NULL COMMENT '更新时间',
  `update_user` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '更新人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `comment` */

insert  into `comment`(`id`,`good_id`,`user_id`,`star`,`comment`,`create_time`,`create_user`,`update_time`,`update_user`,`is_delete`) values (1,1,1,3,'我觉得不错','2018-04-16','而我','2018-04-16','我对你',0),(2,1,2,4,'我觉得太好了','2018-04-16','干得好','2018-04-16','剪头发',0),(3,2,1,3,'hahahha，什么垃圾产品','2018-04-27','hello','2018-04-27','hello',0),(4,4,1,4,'adsada','2018-04-27','hello','2018-04-27','hello',0);

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '商品名',
  `picture_path` text COLLATE utf8_bin COMMENT '图片路径',
  `big_type` int(11) NOT NULL COMMENT '商品大类',
  `small_type` int(11) NOT NULL COMMENT '商品小类',
  `count` int(11) NOT NULL DEFAULT '0' COMMENT '库存',
  `price` int(11) NOT NULL COMMENT '价格',
  `information` text CHARACTER SET utf8 COMMENT '商品信息',
  `is_down` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否下架',
  `create_time` date NOT NULL COMMENT '创建时间',
  `create_user` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '创建人',
  `update_time` date NOT NULL COMMENT '更新时间',
  `update_user` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '更新人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `goods` */

insert  into `goods`(`id`,`name`,`picture_path`,`big_type`,`small_type`,`count`,`price`,`information`,`is_down`,`create_time`,`create_user`,`update_time`,`update_user`,`is_delete`) values (1,'暖宝宝','/files/pictures/hotPack.jpg',1,2,38,5,'<div class=\"serve-agree-bd\">\r\n    <dl>\r\n                                                \r\n                \r\n                <dt>\r\n            <i class=\"goods\"></i>\r\n            <strong>厂家服务</strong>\r\n        </dt>\r\n        <dd>\r\n                                                *<br>\r\n                                                                                                                                                                                </dd>\r\n\r\n                <dt>\r\n            <i class=\"goods\"></i>\r\n            <strong>京东承诺</strong>\r\n        </dt>\r\n        <dd>\r\n                            京东平台卖家销售并发货的商品，由平台卖家提供发票和相应的售后服务。请您放心购买！<br>\r\n                                        注：因厂家会在没有任何提前通知的情况下更改产品包装、产地或者一些附件，本司不能确保客户收到的货物与商城图片、产地、附件说明完全一致。只能确保为原厂正货！并且保证与当时市场上同样主流新品一致。若本商城没有及时更新，请大家谅解！\r\n        </dd>\r\n\r\n                <dt>\r\n            <i class=\"goods\"></i><strong>\r\n             正品行货             </strong>\r\n        </dt>\r\n                        <dd>京东商城向您保证所售商品均为正品行货，京东自营商品开具机打发票或电子发票。</dd>\r\n                                <dt><i class=\"unprofor\"></i><strong>全国联保</strong></dt>\r\n        <dd>\r\n            凭质保证书及京东商城发票，可享受全国联保服务（奢侈品、钟表除外；奢侈品、钟表由京东联系保修，享受法定三包售后服务），与您亲临商场选购的商品享受相同的质量保证。京东商城还为您提供具有竞争力的商品价格和<a href=\"//help.jd.com/help/question-892.html\" target=\"_blank\">运费政策</a>，请您放心购买！\r\n            <br><br>注：因厂家会在没有任何提前通知的情况下更改产品包装、产地或者一些附件，本司不能确保客户收到的货物与商城图片、产地、附件说明完全一致。只能确保为原厂正货！并且保证与当时市场上同样主流新品一致。若本商城没有及时更新，请大家谅解！\r\n        </dd>\r\n                            </dl>\r\n</div>\r\n<div id=\"state\">\r\n                            <strong>权利声明：</strong><br>京东上的所有商品信息、客户评价、商品咨询、网友讨论等内容，是京东重要的经营资源，未经许可，禁止非法转载使用。\r\n                            <p><b>注：</b>本站商品信息均来自于合作方，其真实性、准确性和合法性由信息拥有者（合作方）负责。本站不提供任何保证，并不承担任何法律责任。</p>\r\n                                                        <br>\r\n                            <strong>价格说明：</strong><br>\r\n                            <p><b>京东价：</b>京东价为商品的销售价，是您最终决定是否购买商品的依据。</p>\r\n                            <p><b>划线价：</b>商品展示的划横线价格为参考价，并非原价，该价格可能是品牌专柜标价、商品吊牌价或由品牌供应商提供的正品零售价（如厂商指导价、建议零售价等）或该商品在京东平台上曾经展示过的销售价；由于地区、时间的差异性和市场行情波动，品牌专柜标价、商品吊牌价等可能会与您购物时展示的不一致，该价格仅供您参考。</p>\r\n                            <p><b>折扣：</b>如无特殊说明，折扣指销售商在原价、或划线价（如品牌专柜标价、商品吊牌价、厂商指导价、厂商建议零售价）等某一价格基础上计算出的优惠比例或优惠金额；如有疑问，您可在购买前联系销售商进行咨询。</p>\r\n                            <p><b>异常问题：</b>商品促销信息以商品详情页“促销”栏中的信息为准；商品的具体售价以订单结算页价格为准；如您发现活动商品售价或促销信息有异常，建议购买前先联系销售商咨询。</p>\r\n\r\n                                            </div>',0,'2018-04-16','大师傅呢','2018-04-16','时间奶粉',0),(2,'热水袋','/files/pictures/hotWater.jpg',1,2,18,15,'<div id=\"J_PublicWelfare\" class=\"j-mdv tm-welfare-detail\"><div class=\"charityTreasure\"><div class=\"imgBox\"><span><img src=\"https://img.alicdn.com/tfs/TB1X73pRVXXXXcHXXXXXXXXXXXX-120-90.jpg_120x90.jpg\" alt=\"\"></span></div><div class=\"infoBox\"><p class=\"brief\" data-spm-anchor-id=\"a220o.1000855.0.i2.4f8755377YeS9n\">该商品参与了公益宝贝计划，卖家承诺每笔成交将为<strong>贫困顶梁柱重病救助行动</strong>捐赠<strong>0.02元</strong>。该商品已累积捐赠<strong>257397笔</strong>。</p><p class=\"use\"><span class=\"field\">善款用途简介：</span>每30元就可以为一位贫困山区的顶梁柱提供最高10万元的医疗保障，并且不限病种、不限医院，通过支付宝扫描医疗单据就可以实现理赔。这可能是迄今为...<a href=\"https://cfpa.tmall.com/p/rd909223.htm?spm=a1z10.1-b.w5001-10098677108.10.7KuoKp&amp;scene=taobao_shop\" target=\"_blank\">了解详情&gt;&gt;</a></p></div></div></div><div id=\"attributes\" class=\"attributes\">\r\n\r\n\r\n		<div class=\"attributes-list\" id=\"J_AttrList\">\r\n                \r\n                    <div class=\"tm-clear tb-hidden tm_brandAttr\" id=\"J_BrandAttr\" style=\"display: block;\"><div class=\"name\">品牌名称：<b class=\"J_EbrandLogo\" target=\"_blank\" href=\"//brand.tmall.com/brandInfo.htm?brandId=107380&amp;type=0&amp;scm=1048.1.1.4\">南极人</b></div></div>\r\n        									<p class=\"attr-list-hd tm-clear\"><em>产品参数：</em></p>\r\n				<ul id=\"J_AttrUL\">\r\n                \r\n				                				    																																																																												<li title=\"&nbsp;20*30CM\">包装体积:&nbsp;20*30CM</li>\r\n                                																																																																																														<li id=\"J_attrBrandName\" title=\"&nbsp;南极人\">品牌:&nbsp;南极人</li>\r\n																																																																																																						<li title=\"&nbsp;N8V5J70043-01\">型号:&nbsp;N8V5J70043-01</li>\r\n                                																																																																																														<li title=\"&nbsp;0.45\">毛重:&nbsp;0.45</li>\r\n                                																																																																																														<li title=\"&nbsp;大众\">适用人群:&nbsp;大众</li>\r\n                                																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																							<li title=\"&nbsp;小号经典枚红&nbsp;小号经典蓝色&nbsp;小号经典紫色&nbsp;中号凸点枚红&nbsp;中号凸点蓝色&nbsp;中号凸点紫色&nbsp;中号祥云大红&nbsp;中号祥云深蓝&nbsp;中号祥云深紫&nbsp;大号凸点枚红&nbsp;大号凸点蓝色&nbsp;大号凸点紫色&nbsp;大号祥云大红&nbsp;大号祥云深蓝&nbsp;大号祥云深紫&nbsp;大号波浪枚红&nbsp;大号波浪蓝色&nbsp;大号波浪紫色&nbsp;大号竹席枚红&nbsp;大号竹席蓝色&nbsp;大号竹席紫色&nbsp;长条款---紫色&nbsp;长条款---蓝色&nbsp;长条款---枚红\">颜色分类:&nbsp;小号经典枚红&nbsp;小号经典蓝色&nbsp;小号经典紫色&nbsp;中号凸点枚红&nbsp;中号凸点蓝色&nbsp;中号凸点紫色&nbsp;中号祥云大红&nbsp;中号祥云深蓝&nbsp;中号祥云深紫&nbsp;大号凸点枚红&nbsp;大号凸点蓝色&nbsp;大号凸点紫色&nbsp;大号祥云大红&nbsp;大号祥云深蓝&nbsp;大号祥云深紫&nbsp;大号波浪枚红&nbsp;大号波浪蓝色&nbsp;大号波浪紫色&nbsp;大号竹席枚红&nbsp;大号竹席蓝色&nbsp;大号竹席紫色&nbsp;长条款---紫色&nbsp;长条款---蓝色&nbsp;长条款---枚红</li>\r\n                                																																																																																														<li title=\"&nbsp;冲水热水袋\">热水袋类型:&nbsp;冲水热水袋</li>\r\n                                																																																																																														<li title=\"&nbsp;高密度PVC\">材质:&nbsp;高密度PVC</li>\r\n                                																					    \r\n                <!-- 健字号相关-->\r\n                		    </ul>\r\n			\r\n									    									</div>\r\n</div>',0,'2018-04-16','大师傅呢','2018-04-16','时间奶粉',0),(3,'口红','/files/pictures/lipstick.jpg',1,3,20,320,'<div class=\"attributes-list\" id=\"J_AttrList\">\r\n                \r\n                    <div class=\"tm-clear tb-hidden tm_brandAttr\" id=\"J_BrandAttr\" style=\"display: block;\" data-spm-anchor-id=\"a220o.1000855.0.i1.12446170pzldy5\"><div class=\"name\">品牌名称：<b class=\"J_EbrandLogo\" target=\"_blank\" href=\"//brand.tmall.com/brandInfo.htm?brandId=20112&amp;type=0&amp;scm=1048.1.1.4\">YSL/圣罗兰</b></div></div>\r\n        									<p class=\"attr-list-hd tm-clear\"><em>产品参数：</em></p>\r\n				<ul id=\"J_AttrUL\">\r\n                \r\n				<li title=\"YSL/圣罗兰 纯口红\">产品名称：YSL/圣罗兰 纯口红</li>                				    																																																																												<li title=\"&nbsp;2014年\">上市时间:&nbsp;2014年</li>\r\n                                																																																																																														<li title=\"&nbsp;5月\">月份:&nbsp;5月</li>\r\n                                																																																																																														<li title=\"&nbsp;3.8g\">净含量:&nbsp;3.8g</li>\r\n                                																																																																																														<li title=\"&nbsp;否\">是否为特殊用途化妆品:&nbsp;否</li>\r\n                                																																																																																														<li title=\"&nbsp;2019-09-01至2020-08-01\">限期使用日期范围:&nbsp;2019-09-01至2020-08-01</li>\r\n                                																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																											<li title=\"&nbsp;N°1 正宫色&nbsp;N°7&nbsp;N°9&nbsp;N°11&nbsp;N°13 正橘色&nbsp;N°16&nbsp;N°17 珊瑚粉&nbsp;N°19&nbsp;N°22&nbsp;N°23&nbsp;N°26&nbsp;N°27&nbsp;N°36&nbsp;N°49 想你色&nbsp;N°50&nbsp;N°51&nbsp;N°52 星星色&nbsp;N°56&nbsp;N°57&nbsp;N°58&nbsp;N°59&nbsp;N°72&nbsp;N°73&nbsp;N°74&nbsp;N°201&nbsp;N°202&nbsp;N°203&nbsp;N°205&nbsp;N°207&nbsp;N°208&nbsp;N°211&nbsp;N°212&nbsp;N°213&nbsp;N°215&nbsp;N°216&nbsp;N°217\">颜色分类:&nbsp;N°1 正宫色&nbsp;N°7&nbsp;N°9&nbsp;N°11&nbsp;N°13 正橘色&nbsp;N°16&nbsp;N°17 珊瑚粉&nbsp;N°19&nbsp;N°22&nbsp;N°23&nbsp;N°26&nbsp;N°27&nbsp;N°36&nbsp;N°49 想你色&nbsp;N°50&nbsp;N°51&nbsp;N°52 星星色&nbsp;N°56&nbsp;N°57&nbsp;N°58&nbsp;N°59&nbsp;N°72&nbsp;N°73&nbsp;N°74&nbsp;N°201&nbsp;N°202&nbsp;N°203&nbsp;N°205&nbsp;N°207&nbsp;N°208&nbsp;N°211&nbsp;N°212&nbsp;N°213&nbsp;N°215&nbsp;N°216&nbsp;N°217</li>\r\n                                																																																																																														<li title=\"&nbsp;正常规格\">规格类型:&nbsp;正常规格</li>\r\n                                																																																																																														<li id=\"J_attrBrandName\" title=\"&nbsp;YSL/圣罗兰\">品牌:&nbsp;YSL/圣罗兰</li>\r\n																																																																																																						<li title=\"&nbsp;纯口红\">YSL/圣罗兰单品:&nbsp;纯口红</li>\r\n                                																																																																																														<li title=\"&nbsp;保湿\">功效:&nbsp;保湿</li>\r\n                                																																																																																														<li title=\"&nbsp;法国\">产地:&nbsp;法国</li>\r\n                                																																																																																														<li title=\"&nbsp;任何肤质\">适合肤质:&nbsp;任何肤质</li>\r\n                                																																																																																														<li title=\"&nbsp;3年\">保质期:&nbsp;3年</li>\r\n                                																					    \r\n                <!-- 健字号相关-->\r\n                		    </ul>\r\n			\r\n									    									</div>',0,'2018-04-16','大师傅呢','2018-04-16','时间奶粉',0),(4,'面膜','/files/pictures/facialMask.jpg',1,3,49,129,'<div class=\"attributes-list\" id=\"J_AttrList\">\r\n                \r\n                    <div class=\"tm-clear tb-hidden tm_brandAttr\" id=\"J_BrandAttr\" style=\"display: block;\"><div class=\"name\">品牌名称：<b class=\"J_EbrandLogo\" target=\"_blank\" href=\"//brand.tmall.com/brandInfo.htm?brandId=6037878&amp;type=0&amp;scm=1048.1.1.4\">wis</b></div></div>\r\n        									<p class=\"attr-list-hd tm-clear\"><em>产品参数：</em></p>\r\n				<ul id=\"J_AttrUL\">\r\n                \r\n				<li title=\"wis 水润面膜套装\">产品名称：wis 水润面膜套装</li>                				    																																																																												<li title=\"&nbsp;36个月\">化妆品保质期:&nbsp;36个月</li>\r\n                                																																																																																														<li title=\"&nbsp;2019-12-20至2020-02-08\">限期使用日期范围:&nbsp;2019-12-20至2020-02-08</li>\r\n                                																																																																																														<li title=\"&nbsp;贴片式\">面膜分类:&nbsp;贴片式</li>\r\n                                																																																																																														<li title=\"&nbsp;正常规格\">规格类型:&nbsp;正常规格</li>\r\n                                																																																																																														<li title=\"&nbsp;任何肤质\">适合肤质:&nbsp;任何肤质</li>\r\n                                																																																																																																																																																												<li title=\"&nbsp;25g/ml&nbsp;500g/mL&nbsp;600g/mL\">化妆品净含量:&nbsp;25g/ml&nbsp;500g/mL&nbsp;600g/mL</li>\r\n                                																																																																																														<li id=\"J_attrBrandName\" title=\"&nbsp;wis\">品牌:&nbsp;wis</li>\r\n																																																																																																						<li title=\"&nbsp;水润面膜套装\">单品:&nbsp;水润面膜套装</li>\r\n                                																																																																																														<li title=\"&nbsp;否\">是否为特殊用途化妆品:&nbsp;否</li>\r\n                                																																																																																																																																																																																																																										<li title=\"&nbsp;平衡水油&nbsp;补水&nbsp;保湿&nbsp;收缩毛孔&nbsp;调理油痘\">功效:&nbsp;平衡水油&nbsp;补水&nbsp;保湿&nbsp;收缩毛孔&nbsp;调理油痘</li>\r\n                                																																																																																														<li title=\"&nbsp;中国\">产地:&nbsp;中国</li>\r\n                                																																																																																														<li title=\"&nbsp;3年\">保质期:&nbsp;3年</li>\r\n                                																					    \r\n                <!-- 健字号相关-->\r\n                		    </ul>\r\n			\r\n									    									</div>',0,'2018-04-16','大师傅呢','2018-04-27','Sys',0),(5,'Q币','/files/pictures/QMoney.jpg',4,5,298,19,'<div class=\"content ke-post\" style=\"height: auto;\"><p align=\"center\"><font color=\"#0000ff\" size=\"5\"><strong>请认准本店唯一旺旺：<a href=\"http://amos.alicdn.com/getcid.aw?v=3&amp;uid=红海点卡专营店 &amp;site=cntaobao&amp;groupid=150333336&amp;s=1&amp;charset=gbk\" target=\"_blank\">红海点卡专营店<img alt=\"点击这里给我发消息\" border=\"0\" src=\"https://img.alicdn.com/imgextra/i1/1849643991/T23EUHXwhaXXXXXXXX-1849643991.gif\" class=\"img-ks-lazyload\"></a></strong></font></p> <p>1.我们的产品绝对是官方产品，不存在充值后有不安全的隐患请大家放心购买！</p> <p>2.购买前请认准是不是要充值的商品，所见即所得，不同游戏之间游戏币不能相互转换。</p> <p>3.我们客服从来不会主动发链接给买家，向你发链接都是骗子。</p> <p>4.购买后请尽快确认收货，谢谢您的合作。</p> <p>5.请认准本店唯一旺旺：红海点卡专营店</p> <p style=\"text-align: center;\"><span style=\"font-size: 18.0px;\"><strong><span style=\"color: #0000ff;\">自动充值 商城品质 10-100秒快速到账 请放心购买！</span></strong></span></p> <p>运营公司：腾讯</p> <p>游戏名称：Q币</p> <p>游戏官网：http://www.qq.com</p> <p>计费方式：20元/20Q币</p> <p>充值方式：自动充值（<span style=\"color: #0000ff;\">充值账号请填QQ号</span>）</p> <p>其它面值：（点击下方链接即可购买）</p> <p style=\"line-height: 1.5;\"><a href=\"https://detail.tmall.com/item.htm?id=36060239199\" style=\"color: #0000ff;\" target=\"_blank\"></a></p> <p style=\"line-height: 1.5;\"><a href=\"https://detail.tmall.com/item.htm?id=36060239199\" style=\"color: #0000ff;\" target=\"_blank\">1元=1Q币</a>, &nbsp; &nbsp; &nbsp; &nbsp;<a href=\"https://detail.tmall.com/item.htm?id=43932284040\" style=\"color: #0000ff;\" target=\"_blank\">2元=2Q币</a>, &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<a href=\"https://detail.tmall.com/item.htm?id=43916133155\" style=\"color: #0000ff;\" target=\"_blank\">3元=3Q币</a>, &nbsp; &nbsp; &nbsp;&nbsp;<a href=\"https://detail.tmall.com/item.htm?id=43878954564\" style=\"color: #0000ff;\" target=\"_blank\">4元=4Q币</a>, &nbsp; &nbsp; &nbsp;&nbsp;<a href=\"https://detail.tmall.com/item.htm?id=36102413680\" style=\"color: #0000ff;\" target=\"_blank\">5元=5Q币</a>, &nbsp;&nbsp;</p> <p style=\"line-height: 1.5;\"><a href=\"https://detail.tmall.com/item.htm?id=43932236406\" style=\"line-height: 1.5;color: #0000ff;\" target=\"_blank\">6元=6Q币</a><span style=\"line-height: 1.5;\">, &nbsp; &nbsp; &nbsp; &nbsp;</span><a href=\"https://detail.tmall.com/item.htm?id=43932276386\" style=\"line-height: 1.5;color: #0000ff;\" target=\"_blank\">8元=8Q币</a><span style=\"line-height: 1.5;\">, &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;</span><a href=\"https://detail.tmall.com/item.htm?id=43878974673\" style=\"line-height: 1.5;color: #0000ff;\" target=\"_blank\">9元=9Q币</a><span style=\"line-height: 1.5;\">, &nbsp; &nbsp; &nbsp;&nbsp;</span><a href=\"https://detail.tmall.com/item.htm?id=36068584613\" style=\"line-height: 1.5;color: #0000ff;\" target=\"_blank\">10元=10Q币</a><span style=\"line-height: 1.5;\">, &nbsp;&nbsp;</span><a href=\"https://detail.tmall.com/item.htm?id=36102417756\" style=\"line-height: 1.5;color: #0000ff;\" target=\"_blank\">15元=15Q币</a><span style=\"line-height: 1.5;\">,</span></p> <p style=\"line-height: 1.5;\"><a href=\"https://detail.tmall.com/item.htm?id=36102409820\" style=\"line-height: 1.5;color: #0000ff;\" target=\"_blank\">20元=20Q币</a><span style=\"line-height: 1.5;\">, &nbsp; &nbsp;</span><a href=\"https://detail.tmall.com/item.htm?id=43916785005\" style=\"line-height: 1.5;color: #0000ff;\" target=\"_blank\">23元=23Q币</a><span style=\"line-height: 1.5;\">, &nbsp; &nbsp;&nbsp;</span><a href=\"https://detail.tmall.com/item.htm?id=43932968233\" style=\"line-height: 1.5;color: #0000ff;\" target=\"_blank\">25元=25Q币</a><span style=\"line-height: 1.5;\">, &nbsp;</span><a href=\"https://detail.tmall.com/item.htm?id=43916649333\" style=\"line-height: 1.5;color: #0000ff;\" target=\"_blank\">26元=26Q币</a><span style=\"line-height: 1.5;\">, &nbsp;&nbsp;</span><a href=\"https://detail.tmall.com/item.htm?id=36102509570\" style=\"line-height: 1.5;color: #0000ff;\" target=\"_blank\">30元=30Q币</a><span style=\"line-height: 1.5;\">,&nbsp;</span></p> <p style=\"line-height: 1.5;\"><a href=\"https://detail.tmall.com/item.htm?id=36104071317\" style=\"line-height: 1.5;color: #0000ff;\" target=\"_blank\">31元=31Q币</a><span style=\"line-height: 1.5;\">, &nbsp; &nbsp;</span><a href=\"https://detail.tmall.com/item.htm?id=36102379983\" style=\"line-height: 1.5;color: #0000ff;\" target=\"_blank\">40元=40Q币</a><span style=\"line-height: 1.5;\">, &nbsp; &nbsp;&nbsp;</span><a href=\"https://detail.tmall.com/item.htm?id=36111436083\" style=\"line-height: 1.5;color: #0000ff;\" target=\"_blank\">41元=41Q币</a><span style=\"line-height: 1.5;\">, &nbsp;</span><span style=\"line-height: 1.5;\">&nbsp;</span><a href=\"https://detail.tmall.com/item.htm?id=45057692410\" style=\"line-height: 1.5;color: #0000ff;\" target=\"_blank\">45元=45Q币</a><span style=\"line-height: 1.5;\">, &nbsp;</span><a href=\"https://detail.tmall.com/item.htm?id=36114080246\" style=\"line-height: 1.5;color: #0000ff;\" target=\"_blank\">46元=46Q币</a><span style=\"line-height: 1.5;\">, &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p> <p style=\"line-height: 1.5;\"><a href=\"https://detail.tmall.com/item.htm?id=36101194406\" style=\"line-height: 1.5;color: #0000ff;\" target=\"_blank\">50元=50Q币</a><span style=\"line-height: 1.5;\">, &nbsp; &nbsp;</span><a href=\"https://detail.tmall.com/item.htm?id=36114664767\" style=\"line-height: 1.5;color: #0000ff;\" target=\"_blank\">51元=51Q币</a><span style=\"line-height: 1.5;\">, &nbsp; &nbsp;</span><a href=\"https://detail.tmall.com/item.htm?id=36060818386\" style=\"line-height: 1.5;color: #0000ff;\" target=\"_blank\">56元=56Q币</a><span style=\"line-height: 1.5;\">, &nbsp;</span><a href=\"https://detail.tmall.com/item.htm?id=36101634244\" style=\"line-height: 1.5;color: #0000ff;\" target=\"_blank\">60元=60Q币</a><span style=\"line-height: 1.5;\">, &nbsp;</span><a href=\"https://detail.tmall.com/item.htm?id=36102651884\" style=\"line-height: 1.5;color: #0000ff;\" target=\"_blank\">61元=61Q币</a><span style=\"line-height: 1.5;\">,&nbsp;</span></p> <p style=\"line-height: 1.5;\"><a href=\"https://detail.tmall.com/item.htm?id=36107427032\" style=\"line-height: 1.5;color: #0000ff;\" target=\"_blank\">67元=67Q币</a><span style=\"line-height: 1.5;\">, &nbsp; &nbsp;</span><a href=\"https://detail.tmall.com/item.htm?id=36103093491\" style=\"line-height: 1.5;color: #0000ff;\" target=\"_blank\">72元=72Q币</a><span style=\"line-height: 1.5;\">, &nbsp; &nbsp;&nbsp;</span><a href=\"https://detail.tmall.com/item.htm?id=36108129169\" style=\"line-height: 1.5;color: #0000ff;\" target=\"_blank\">82元=82Q币</a><span style=\"line-height: 1.5;\">, &nbsp; &nbsp;</span><a href=\"https://detail.tmall.com/item.htm?id=37795884168\" style=\"line-height: 1.5;color: #0000ff;\" target=\"_blank\">92元=92Q币</a><span style=\"line-height: 1.5;\">, &nbsp;&nbsp;</span><a href=\"https://detail.tmall.com/item.htm?id=36102114236\" style=\"line-height: 1.5;color: #0000ff;\" target=\"_blank\">100元=100Q币</a><span style=\"line-height: 1.5;\">, &nbsp; &nbsp;</span></p> <p style=\"line-height: 1.5;\"><a href=\"https://detail.tmall.com/item.htm?id=36106646481\" style=\"line-height: 1.5;color: #0000ff;\" target=\"_blank\">102元=102Q币</a><span style=\"line-height: 1.5;\">, &nbsp;</span><a href=\"https://detail.tmall.com/item.htm?id=37793792396\" style=\"line-height: 1.5;color: #0000ff;\" target=\"_blank\">112元=112Q币</a><span style=\"line-height: 1.5;\">, &nbsp; &nbsp;</span><a href=\"https://detail.tmall.com/item.htm?id=36102246129\" style=\"line-height: 1.5;color: #0000ff;\" target=\"_blank\">153元=153Q币</a><span style=\"line-height: 1.5;\">, &nbsp; &nbsp;</span><a href=\"https://detail.tmall.com/item.htm?id=36103737454\" style=\"line-height: 1.5;color: #0000ff;\" target=\"_blank\">200元=200Q币</a><span style=\"line-height: 1.5;\">, &nbsp; &nbsp; &nbsp;</span><a href=\"https://detail.tmall.com/item.htm?id=36108161523\" style=\"line-height: 1.5;color: #0000ff;\" target=\"_blank\">204元=204Q币</a><span style=\"line-height: 1.5;\">, &nbsp; &nbsp; &nbsp;</span><a href=\"https://detail.tmall.com/item.htm?id=36108353388\" style=\"line-height: 1.5;color: #0000ff;\" target=\"_blank\">255元=255Q币</a><span style=\"line-height: 1.5;\">, &nbsp;</span><a href=\"https://detail.tmall.com/item.htm?id=36103415311\" style=\"line-height: 1.5;color: #0000ff;\" target=\"_blank\">300元=300Q币</a><span style=\"line-height: 1.5;\">, &nbsp;</span><span style=\"line-height: 1.5;\">&nbsp; &nbsp;</span><a href=\"https://detail.tmall.com/item.htm?id=36111856165\" style=\"line-height: 1.5;color: #0000ff;\" target=\"_blank\">357元=357Q币</a><span style=\"line-height: 1.5;\">, &nbsp;</span><a href=\"https://detail.tmall.com/item.htm?id=36106070669\" style=\"line-height: 1.5;color: #0000ff;\" target=\"_blank\">400元=400Q币</a><span style=\"line-height: 1.5;\">, &nbsp; &nbsp; &nbsp;</span><a href=\"https://detail.tmall.com/item.htm?id=36103031397\" style=\"line-height: 1.5;color: #0000ff;\" target=\"_blank\">500元=500Q币</a><span style=\"line-height: 1.5;\">, &nbsp; &nbsp; &nbsp;</span><a href=\"https://detail.tmall.com/item.htm?id=37973129593\" style=\"line-height: 1.5;color: #0000ff;\" target=\"_blank\">510元=510Q币</a><span style=\"line-height: 1.5;\">, &nbsp;</span><a href=\"https://detail.tmall.com/item.htm?id=36110736815\" style=\"line-height: 1.5;color: #0000ff;\" target=\"_blank\">1000元=1000Q币</a><span style=\"line-height: 1.5;\">,&nbsp;</span></p> <p style=\"line-height: 1.5;\">&nbsp;</p> <p><span style=\"color: #ff0000;\">特别说明</span>：本充值方式货源均为官方卡，故官方充值活动本卡充值一样享受！</p></div>',0,'2018-04-16','大师傅呢','2018-04-16','时间奶粉',0),(7,'鼠标','/files/pictures/mouse.jpg',4,5,300,31,'<div class=\"attributes-list\" id=\"J_AttrList\">\r\n                \r\n                    <div class=\"tm-clear tb-hidden tm_brandAttr\" id=\"J_BrandAttr\" style=\"display: block;\"><div class=\"name\">品牌名称：<b class=\"J_EbrandLogo\" target=\"_blank\" href=\"//brand.tmall.com/brandInfo.htm?brandId=134764503&amp;type=0&amp;scm=1048.1.1.4\">追光豹</b></div></div>\r\n        									<p class=\"attr-list-hd tm-clear\"><em>产品参数：</em></p>\r\n				<ul id=\"J_AttrUL\">\r\n                \r\n				<li title=\"追光豹 WX168\">产品名称：追光豹 WX168</li>                				    																																																																												<li title=\"&nbsp;36个月\">保修期:&nbsp;36个月</li>\r\n                                																																																																																														<li id=\"J_attrBrandName\" title=\"&nbsp;追光豹\">品牌:&nbsp;追光豹</li>\r\n																																																																																																						<li title=\"&nbsp;WX168\">型号:&nbsp;WX168</li>\r\n                                																																																																																														<li title=\"&nbsp;官方标配\">套餐类型:&nbsp;官方标配</li>\r\n                                																																																																																														<li title=\"&nbsp;深圳市追光豹电子有限公司\">生产企业:&nbsp;深圳市追光豹电子有限公司</li>\r\n                                																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																												<li title=\"&nbsp;静音版光亮黑*送加大厚垫&nbsp;标准版磨砂黑&nbsp;静音版光亮白-宏定义&nbsp;游戏版光亮白-送加大厚垫&nbsp;游戏版光亮黑-宏定义&nbsp;游戏版光亮黑-送加大厚垫&nbsp;静音版磨砂黑-宏定义&nbsp;静音版磨砂黑-送加大厚垫&nbsp;游戏版磨砂黑-宏定义&nbsp;静音版光亮黑-宏定义&nbsp;游戏版磨砂黑-送加大厚垫&nbsp;静音版光亮白-送加大厚垫&nbsp;游戏版磨砂白*宏定义&nbsp;升级版光亮黑--可吃鸡&nbsp;升级版磨砂黑-可吃鸡&nbsp;游戏版光亮白-宏定义&nbsp;标准版磨砂黑-送加大厚垫&nbsp;加强版磨砂黑-可吃鸡压枪&nbsp;加强版光亮黑-可吃鸡压枪\">颜色分类:&nbsp;静音版光亮黑*送加大厚垫&nbsp;标准版磨砂黑&nbsp;静音版光亮白-宏定义&nbsp;游戏版光亮白-送加大厚垫&nbsp;游戏版光亮黑-宏定义&nbsp;游戏版光亮黑-送加大厚垫&nbsp;静音版磨砂黑-宏定义&nbsp;静音版磨砂黑-送加大厚垫&nbsp;游戏版磨砂黑-宏定义&nbsp;静音版光亮黑-宏定义&nbsp;游戏版磨砂黑-送加大厚垫&nbsp;静音版光亮白-送加大厚垫&nbsp;游戏版磨砂白*宏定义&nbsp;升级版光亮黑--可吃鸡&nbsp;升级版磨砂黑-可吃鸡&nbsp;游戏版光亮白-宏定义&nbsp;标准版磨砂黑-送加大厚垫&nbsp;加强版磨砂黑-可吃鸡压枪&nbsp;加强版光亮黑-可吃鸡压枪</li>\r\n                                																																																																																														<li title=\"&nbsp;光电\">工作方式:&nbsp;光电</li>\r\n                                																																																																																														<li title=\"&nbsp;USB\">接口类型:&nbsp;USB</li>\r\n                                																																																																																														<li title=\"&nbsp;6个\">按键数:&nbsp;6个</li>\r\n                                																																																																																														<li title=\"&nbsp;其他/other\">光学分辨率:&nbsp;其他/other</li>\r\n                                																																																																																														<li title=\"&nbsp;支持\">是否支持人体工程学:&nbsp;支持</li>\r\n                                																																																																																														<li title=\"&nbsp;全新\">成色:&nbsp;全新</li>\r\n                                																																																																																														<li title=\"&nbsp;店铺三包\">售后服务:&nbsp;店铺三包</li>\r\n                                																					    \r\n                <!-- 健字号相关-->\r\n                		    </ul>\r\n			\r\n									    									</div>',1,'2018-04-16','大师傅呢','2018-04-16','时间奶粉',0),(8,'鼠标','/files/pictures/mouse.jpg',4,5,292,31,'<div class=\"attributes-list\" id=\"J_AttrList\">\r\n                \r\n                    <div class=\"tm-clear tb-hidden tm_brandAttr\" id=\"J_BrandAttr\" style=\"display: block;\"><div class=\"name\">品牌名称：<b class=\"J_EbrandLogo\" target=\"_blank\" href=\"//brand.tmall.com/brandInfo.htm?brandId=134764503&amp;type=0&amp;scm=1048.1.1.4\">追光豹</b></div></div>\r\n        									<p class=\"attr-list-hd tm-clear\"><em>产品参数：</em></p>\r\n				<ul id=\"J_AttrUL\">\r\n                \r\n				<li title=\"追光豹 WX168\">产品名称：追光豹 WX168</li>                				    																																																																												<li title=\"&nbsp;36个月\">保修期:&nbsp;36个月</li>\r\n                                																																																																																														<li id=\"J_attrBrandName\" title=\"&nbsp;追光豹\">品牌:&nbsp;追光豹</li>\r\n																																																																																																						<li title=\"&nbsp;WX168\">型号:&nbsp;WX168</li>\r\n                                																																																																																														<li title=\"&nbsp;官方标配\">套餐类型:&nbsp;官方标配</li>\r\n                                																																																																																														<li title=\"&nbsp;深圳市追光豹电子有限公司\">生产企业:&nbsp;深圳市追光豹电子有限公司</li>\r\n                                																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																												<li title=\"&nbsp;静音版光亮黑*送加大厚垫&nbsp;标准版磨砂黑&nbsp;静音版光亮白-宏定义&nbsp;游戏版光亮白-送加大厚垫&nbsp;游戏版光亮黑-宏定义&nbsp;游戏版光亮黑-送加大厚垫&nbsp;静音版磨砂黑-宏定义&nbsp;静音版磨砂黑-送加大厚垫&nbsp;游戏版磨砂黑-宏定义&nbsp;静音版光亮黑-宏定义&nbsp;游戏版磨砂黑-送加大厚垫&nbsp;静音版光亮白-送加大厚垫&nbsp;游戏版磨砂白*宏定义&nbsp;升级版光亮黑--可吃鸡&nbsp;升级版磨砂黑-可吃鸡&nbsp;游戏版光亮白-宏定义&nbsp;标准版磨砂黑-送加大厚垫&nbsp;加强版磨砂黑-可吃鸡压枪&nbsp;加强版光亮黑-可吃鸡压枪\">颜色分类:&nbsp;静音版光亮黑*送加大厚垫&nbsp;标准版磨砂黑&nbsp;静音版光亮白-宏定义&nbsp;游戏版光亮白-送加大厚垫&nbsp;游戏版光亮黑-宏定义&nbsp;游戏版光亮黑-送加大厚垫&nbsp;静音版磨砂黑-宏定义&nbsp;静音版磨砂黑-送加大厚垫&nbsp;游戏版磨砂黑-宏定义&nbsp;静音版光亮黑-宏定义&nbsp;游戏版磨砂黑-送加大厚垫&nbsp;静音版光亮白-送加大厚垫&nbsp;游戏版磨砂白*宏定义&nbsp;升级版光亮黑--可吃鸡&nbsp;升级版磨砂黑-可吃鸡&nbsp;游戏版光亮白-宏定义&nbsp;标准版磨砂黑-送加大厚垫&nbsp;加强版磨砂黑-可吃鸡压枪&nbsp;加强版光亮黑-可吃鸡压枪</li>\r\n                                																																																																																														<li title=\"&nbsp;光电\">工作方式:&nbsp;光电</li>\r\n                                																																																																																														<li title=\"&nbsp;USB\">接口类型:&nbsp;USB</li>\r\n                                																																																																																														<li title=\"&nbsp;6个\">按键数:&nbsp;6个</li>\r\n                                																																																																																														<li title=\"&nbsp;其他/other\">光学分辨率:&nbsp;其他/other</li>\r\n                                																																																																																														<li title=\"&nbsp;支持\">是否支持人体工程学:&nbsp;支持</li>\r\n                                																																																																																														<li title=\"&nbsp;全新\">成色:&nbsp;全新</li>\r\n                                																																																																																														<li title=\"&nbsp;店铺三包\">售后服务:&nbsp;店铺三包</li>\r\n                                																					    \r\n                <!-- 健字号相关-->\r\n                		    </ul>\r\n			\r\n									    									</div>',0,'2018-04-16','大师傅呢','2018-04-28','Sys',0),(9,'头号玩家','/files/pictures/ReadyPlayerOne.jpg',4,6,76,40,'<ul class=\"cont-info\">\r\n								<li>导演：史蒂文·斯皮尔伯格</li>				<li>主演：泰伊·谢里丹,奥利维亚·库克,本·门德尔森,西蒙·佩吉,马克·里朗斯</li>				<li>类型：动作,科幻,冒险</li>				<li>制片国家/地区：美国</li>				<li>语言：英语</li>				<li>片长：140分钟</li>				<li class=\"J_shrink shrink\" style=\"height: 72px;\">剧情介绍：在2045年，现实世界衰退破败，人们沉迷于VR(虚拟现实)游戏“绿洲(OASIS)”的虚幻世界里寻求慰藉。马克·里朗斯饰演的“绿洲”的创始人临终前宣布，将亿万身家全部留给寻获他隐藏的彩蛋的游戏玩家，史上最大规模的寻宝冒险就此展开，由泰伊·谢里丹饰演的男主角韦德·沃兹(Wade Watts/Parzival)和数十亿竞争者踏上奇妙而又危机重重的旅途。<a class=\"shrink-btn\" href=\"javascript:;\">收起&lt;&lt;</a></li>			</ul>',0,'2018-04-16','大师傅呢','2018-04-16','时间奶粉',0),(10,'狂暴巨兽','/files/pictures/Rampage.jpg',4,6,77,50,'<ul class=\"cont-info\">\r\n								<li>导演：布拉德·佩顿</li>				<li>主演：道恩·强森,娜奥米·哈里斯,杰弗里·迪恩·摩根,玛琳·阿克曼</li>				<li>类型：动作,冒险,科幻</li>				<li>制片国家/地区：美国</li>				<li>语言：英语</li>				<li>片长：108分钟</li>				<li class=\"J_shrink shrink\" style=\"height: 54px;\">剧情介绍：巨石强森饰演的灵长类动物学家一直与人类保持距离, 却跟极为聪明的银背大猩猩乔治有着深厚的感情。但是一次基因实验出错, 让这只温驯的大猩猩变成狂怒难驯的庞然巨兽。更可怕的是, 其他动物也发生了同样基因异变。他必须阻止这场全球性的灾难, 更重要是要拯救他的好友乔治。<a class=\"shrink-btn\" href=\"javascript:;\">收起&lt;&lt;</a></li>			</ul>',0,'2018-04-16','大师傅呢','2018-04-16','时间奶粉',0);

/*Table structure for table `headgood` */

DROP TABLE IF EXISTS `headgood`;

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `headgood` */

insert  into `headgood`(`id`,`good_id`,`comment`,`picture_path`,`create_time`,`create_user`,`update_time`,`update_user`,`is_delete`) values (1,1,'在冬天给你夏天的温暖','/files/pictures/1.png','2018-04-20','Sys','2018-04-20','Sys',0),(2,4,'让你的皮肤更加水嫩','/files/pictures/2.png','2018-04-20','Sys','2018-04-20','Sys',0),(3,5,'没有什么是Q币解决不了的，如果有就让Q币再多点','/files/pictures/3.png','2018-04-20','Sys','2018-04-20','Sys',0),(4,9,'这电影你都没看就out了！','/files/pictures/4.png','2018-04-20','Sys','2018-04-20','Sys',0);

/*Table structure for table `news` */

DROP TABLE IF EXISTS `news`;

CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `type` int(11) NOT NULL COMMENT '新闻类型(1:大图轮播 2:左下展示)',
  `title` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '标题',
  `priority` int(11) NOT NULL COMMENT '优先级',
  `picture_path` text COLLATE utf8_bin COMMENT '图片路径',
  `contain` text COLLATE utf8_bin COMMENT '内容',
  `hot` tinyint(4) NOT NULL DEFAULT '0' COMMENT '热搜',
  `create_time` date NOT NULL COMMENT '创建时间',
  `create_user` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '创建人',
  `update_time` date NOT NULL COMMENT '更新时间',
  `update_user` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '更新人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `news` */

insert  into `news`(`id`,`type`,`title`,`priority`,`picture_path`,`contain`,`hot`,`create_time`,`create_user`,`update_time`,`update_user`,`is_delete`) values (1,2,'big1',1,'/files/pictures/pic4.jpg','big1\r\n',1,'2018-04-12','hello1','2018-04-12','hello2',0),(2,2,'big2',2,'/files/pictures/pic3.jpg','big2\r\n',0,'2018-04-12','hello1','2018-04-12','hello2',0),(3,2,'big3',3,'/files/pictures/pic2.jpg','big3\r\n',1,'2018-04-12','hello1','2018-04-12','hello2',0),(4,2,'big4',4,'/files/pictures/pic1.jpg','big4\r\n',0,'2018-04-12','hello1','2018-04-12','hello2',0),(5,1,'small1',1,'','small1',0,'2018-04-12','hello1','2018-04-12','hello2',0),(6,1,'small2',2,'','small2',0,'2018-04-12','hello1','2018-04-12','hello2',0),(7,1,'small3',3,'','small3',0,'2018-04-12','hello1','2018-04-12','hello2',0),(8,1,'small4',4,'','small4',0,'2018-04-12','hello1','2018-04-12','hello2',0);

/*Table structure for table `shopcar` */

DROP TABLE IF EXISTS `shopcar`;

CREATE TABLE `shopcar` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `good_id` int(11) NOT NULL COMMENT '货物id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `good_count` int(11) NOT NULL COMMENT '购买数量',
  `create_time` date NOT NULL COMMENT '创建时间',
  `create_user` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '创建人',
  `update_time` date NOT NULL COMMENT '更新时间',
  `update_user` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '更新人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `shopcar` */

insert  into `shopcar`(`id`,`good_id`,`user_id`,`good_count`,`create_time`,`create_user`,`update_time`,`update_user`,`is_delete`) values (5,1,1,2,'2018-04-27','Sys','2018-04-27','Sys',1),(6,4,1,3,'2018-04-27','Sys','2018-04-27','Sys',1),(7,5,1,2,'2018-04-27','Sys','2018-04-27','Sys',1),(8,8,1,8,'2018-04-28','Sys','2018-04-28','Sys',1),(9,9,1,4,'2018-04-28','Sys','2018-04-28','Sys',1);

/*Table structure for table `type` */

DROP TABLE IF EXISTS `type`;

CREATE TABLE `type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `level` int(11) NOT NULL DEFAULT '1' COMMENT '类型等级',
  `name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '类型名称',
  `father_id` int(11) NOT NULL DEFAULT '-1' COMMENT '父级id,无父级时为-1',
  `priority` int(11) NOT NULL COMMENT '优先级',
  `create_time` date NOT NULL COMMENT '创建时间',
  `create_user` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '创建人',
  `update_time` date NOT NULL COMMENT '更新时间',
  `update_user` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '更新人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `type` */

insert  into `type`(`id`,`level`,`name`,`father_id`,`priority`,`create_time`,`create_user`,`update_time`,`update_user`,`is_delete`) values (1,1,'女士用品',-1,1,'2018-04-19','Sys','2018-04-19','Sys',0),(2,2,'保暖品',1,1,'2018-04-19','Sys','2018-04-19','Sys',0),(3,2,'化妆品',1,2,'2018-04-19','Sys','2018-04-19','Sys',0),(4,1,'男士用品',-1,2,'2018-04-19','Sys','2018-04-19','Sys',0),(5,2,'电竞产品',4,1,'2018-04-19','Sys','2018-04-19','Sys',0),(6,2,'电影',4,2,'2018-04-19','Sys','2018-04-19','Sys',0);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '用户名',
  `password` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '密码',
  `tel` varchar(16) COLLATE utf8_bin NOT NULL COMMENT '电话',
  `email` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '邮箱',
  `create_time` date NOT NULL COMMENT '创建时间',
  `create_user` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '创建人',
  `update_time` date NOT NULL COMMENT '更新时间',
  `update_user` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '更新人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`password`,`tel`,`email`,`create_time`,`create_user`,`update_time`,`update_user`,`is_delete`) values (1,'hello','123456','18797818175','1034065132@qq.com','2018-04-08','hello','2018-04-27','hello的',0),(2,'hello2','11111','22222','2222','2018-04-08','hello2','2018-04-08','hello2',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
