create table categories
(
	id         int8      not null unique,
	title      varchar   not null unique,
	created_at timestamp not null,
	updated_at timestamp not null
);
create table sub_categories
(
	id          int8      not null unique,
	category_id int8      not null,
	title       varchar   not null unique,
	created_at  timestamp not null,
	updated_at  timestamp not null
);
create table products
(
	id              int8      not null unique,
	sub_category_id int8      not null,
	title           varchar   not null unique,
	description     varchar,
	price           int4      not null,
	is_in_stock     boolean   not null default false,
	created_at      timestamp not null,
	updated_at      timestamp not null
);
create table images
(
	id              int8      not null unique,
	product_id      int8      not null,
	sub_category_id int8      not null,
	title           varchar   not null unique,
	image_path      varchar   not null,
	created_at      timestamp not null,
	updated_at      timestamp not null
);

create sequence category_sequences start 1 increment 1;
create sequence sub_category_sequences start 1 increment 1;
create sequence product_sequences start 1 increment 1;
create sequence image_sequences start 1 increment 1;

alter table if exists sub_categories
	add constraint sub_category_id_category_id_fk
		foreign key (category_id) references categories (id);

alter table if exists products
	add constraint product_id_sub_category_id_fk
		foreign key (sub_category_id) references sub_categories (id);

alter table if exists images
	add constraint image_id_product_id_fk
		foreign key (product_id) references products (id);

alter table if exists images
	add constraint image_id_sub_category_id_fk
		foreign key (sub_category_id) references sub_categories (id);