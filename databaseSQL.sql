drop table if exists users;
create table users (
	user_id serial primary key,
	username varchar(50) unique not null,
	first_name varchar(50),
	last_name varchar(50),
	company varchar(50) not null,
	user_password varchar(50) not null,
	position_role varchar(20) not null check (position_role in ('hospital_admin', 'warranty_manager'))
);



create table devices (
	device_id serial primary key,
	device_type varchar(50) not null
);

drop table if exists device_warranties;
create table device_warranties (
	warranty_id serial primary key,
	device_id int not null,
	warranty_issue_date date not null,
	warranty_expiration_date date not null,
	warranty_amount numeric,
	request_issue_date date default current_date,
	recall_status varchar(15) check (recall_status in ('pending', 'approved', 'denied')) default 'pending',
	confirmation boolean default false,
	warranty_requester varchar(50) not null,
	warranty_resolver varchar(50),
	constraint fk_warranty_requester foreign key (warranty_requester) references users(username),
	constraint fk_warranty_resolver foreign key (warranty_resolver) references users(username),
	constraint fk_device_id foreign key (device_id) references devices(device_id)

	
);





insert into users (username, first_name, last_name, company, user_password, position_role) 
values ('bobby', 'bob', 'smith', 'Ink INC', 'password', 'hospital_admin')

select * from users

insert into devices (device_type) values ('hospital bed'),('MRI'),('syringes'),('EKGs'),('heart moniter'),('respirator')

select * from devices

insert into device_warranties (device_id, warranty_issue_date, warranty_expiration_date, warranty_amount, warranty_requester) values
(2, '2021-01-10', '2022-01-10', 100000, 'bobby')

select * from device_warranties

truncate device_warranties, users;

