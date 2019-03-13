CREATE table product_info(
	product_id VARCHAR(32) not null,
	product_name VARCHAR(64) not null comment '商品名称',
	product_price DECIMAL(8,2) not null comment '单价',
	product_stock int not null comment '库存',
	product_description varchar(64) comment '描述',
	product_icon varchar(512) comment '小图',
	product_status TINYINT(3) DEFAULT '0' COMMENT '商品状态，0正常1下架',
	category_type int not null comment '类目编号',
	create_time TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP comment '创建时间',
	update_time TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP on UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
	PRIMARY KEY(product_id)
) COMMENT '商品表';


CREATE table product_category(
	category_id  int not null auto_increment,
	category_name varchar(64) not null comment '类目名字',
	category_type int not null COMMENT '类目编号',
	create_time TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP comment '创建时间',
	update_time TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP on UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
	PRIMARY KEY(category_id),
	UNIQUE KEY uqe_category_type(category_type)
)comment '类目表';


CREATE table order_master(
	order_id varchar(32) not null,
	buyer_name varchar(32) not null comment '买家名字',
	buyer_phone varchar(32) not null comment '买家电话',
	buyer_address varchar(128) not null comment '买家地址',
	buyer_openid VARCHAR(64) not null comment '买家微信openid',
	order_amount DECIMAL(8,2) not null comment '订单总金额',
	order_status TINYINT(3) not null DEFAULT '0' comment '订单状态，默认0新下单',
	pay_status TINYINT(3) not null DEFAULT '0' comment '支付状态，默认0未支付',
	create_time TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP comment '创建时间',
	update_time TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP on UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
	PRIMARY key (order_id),
  key idx_buyer_openid(buyer_openid)
)comment '订单表';

CREATE table order_detail(
	detail_id varchar(32) not null,
	order_id varchar(32) not null,
	product_id varchar(32) not null,
	product_name varchar(64) not null comment '商品名称',
	product_price DECIMAL(8,2) not null comment '商品价格',
	product_quantity int not null comment '商品数量',
	product_icon varchar(512) comment '商品小图',
	create_time TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP comment '创建时间',
	update_time TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP on UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
	PRIMARY key (detail_id),
	key idx_order_id(order_id)
) comment '订单详情表'
	
	