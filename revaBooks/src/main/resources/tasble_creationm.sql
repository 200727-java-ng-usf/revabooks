CREATE USER revabooks_app
WITH PASSWORD 'revature';

grant all privileges
on database postgres
to revabooks_app;


create table user_roles(
	id serial,
	name varchar(25) not null,

	constraint user_roles_pk
	primary key (id)

);

create table app_users(
	id serial,
	username varchar(25) unique not null,
	password varchar(256) not null,
	first_name varchar(25) not null,
	last_name varchar(25) not null,
	email varchar(256) unique not null,
	role_id int not null,
	
	constraint app_users_pk
	primary key (id),
	
	constraint user_role_fk
	foreign key (role_id)
	references user_roles

);


insert into user_roles (name)
values('Admin');

select * from user_roles;
insert into user_roles (name)
values('Manager'), ('Premium Member'), ('Basic Member'), ('Locked');

insert into app_users (username, password, first_name, last_name, email, role_id )
values 
	('aanderson', 'password', 'Alice', 'Anderson', 'aanderson@revature.com', 1),
	('bbailey', 'password', 'Bob', 'Bailey', 'bbailey@revature.com', 2),
	('ccalhoun', 'password', 'Charles', 'Calhoun', 'ccalhoun@revature.com', 3),
	('ddavis', 'password', 'Daniel', 'Davis', 'ddavis@revature.com', 4),
	('eeinstein', 'password', 'Emily', 'eeinstein', 'eeinstein@revature.com', 5);

select * from app_users;

select * from app_users
where id = 13;

select * from app_users
where email like '%n@revature.com';

select * from app_users
order by id desc;


select * 
from app_users au 
join user_roles ur
on au.role_id = ur.id;

select username, password 
from app_users;

select au.username, au.password, ur.name
from app_users au
join user_roles ur
on au.role_id = ur.id;



