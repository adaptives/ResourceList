create table resource_type (
    id bigint(20) primary key auto_increment,
    name varchar(255) not null unique,
    comments longtext
);

create table topic (
	id bigint(20) primary key auto_increment,
	title varchar(255) not null,
	slug varchar(255) not null unique,
	comments longtext
);

create table resource (
	id bigint(20) primary key auto_increment,
	title varchar(255),
	url varchar(1000) not null unique,
	comments longtext,
	resource_type_id bigint(20) not null,
		constraint fk_resource_type foreign key (resource_type_id) references resource_type(id)
);

create table resource_topic (	
	resource_id bigint(20) not null,
	topic_id bigint(20) not null,
		primary key (resource_id, topic_id),
		constraint fk_resource foreign key (resource_id) references resource(id),
		constraint fk_topic foreign key (topic_id) references topic(id)
);