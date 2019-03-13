CREATE table product_info(
	product_id VARCHAR(32) not null,
	product_name VARCHAR(64) not null comment '��Ʒ����',
	product_price DECIMAL(8,2) not null comment '����',
	product_stock int not null comment '���',
	product_description varchar(64) comment '����',
	product_icon varchar(512) comment 'Сͼ',
	product_status TINYINT(3) DEFAULT '0' COMMENT '��Ʒ״̬��0����1�¼�',
	category_type int not null comment '��Ŀ���',
	create_time TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP comment '����ʱ��',
	update_time TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP on UPDATE CURRENT_TIMESTAMP COMMENT '�޸�ʱ��',
	PRIMARY KEY(product_id)
) COMMENT '��Ʒ��';


CREATE table product_category(
	category_id  int not null auto_increment,
	category_name varchar(64) not null comment '��Ŀ����',
	category_type int not null COMMENT '��Ŀ���',
	create_time TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP comment '����ʱ��',
	update_time TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP on UPDATE CURRENT_TIMESTAMP COMMENT '�޸�ʱ��',
	PRIMARY KEY(category_id),
	UNIQUE KEY uqe_category_type(category_type)
)comment '��Ŀ��';


CREATE table order_master(
	order_id varchar(32) not null,
	buyer_name varchar(32) not null comment '�������',
	buyer_phone varchar(32) not null comment '��ҵ绰',
	buyer_address varchar(128) not null comment '��ҵ�ַ',
	buyer_openid VARCHAR(64) not null comment '���΢��openid',
	order_amount DECIMAL(8,2) not null comment '�����ܽ��',
	order_status TINYINT(3) not null DEFAULT '0' comment '����״̬��Ĭ��0���µ�',
	pay_status TINYINT(3) not null DEFAULT '0' comment '֧��״̬��Ĭ��0δ֧��',
	create_time TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP comment '����ʱ��',
	update_time TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP on UPDATE CURRENT_TIMESTAMP COMMENT '�޸�ʱ��',
	PRIMARY key (order_id),
  key idx_buyer_openid(buyer_openid)
)comment '������';

CREATE table order_detail(
	detail_id varchar(32) not null,
	order_id varchar(32) not null,
	product_id varchar(32) not null,
	product_name varchar(64) not null comment '��Ʒ����',
	product_price DECIMAL(8,2) not null comment '��Ʒ�۸�',
	product_quantity int not null comment '��Ʒ����',
	product_icon varchar(512) comment '��ƷСͼ',
	create_time TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP comment '����ʱ��',
	update_time TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP on UPDATE CURRENT_TIMESTAMP COMMENT '�޸�ʱ��',
	PRIMARY key (detail_id),
	key idx_order_id(order_id)
) comment '���������'
	
	