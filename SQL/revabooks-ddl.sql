create user revabooks_app
with password 'revabooks';

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
	password varchar (256) not null,
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

-- inserting a single value into table --
insert into user_roles (name)
values ('Admin');

-- query the user_roles table to ensure the value was added --
select * from user_roles;

-- insert multiple values into the table with a single insert --
insert into user_roles (name)
values ('Manager'), ('Premium Member'), ('Basic Member'), ('LOCKED');

-- populate app_users table with some dummy data
insert into app_users (username, password, first_name, last_name, email, role_id)
values 
	('aanderson', 'password', 'Alice', 'Anderson', 'aanderson@revature.com', 1),
	('bbailey', 'password', 'Bob', 'Bailey', 'bbailey@revature.com', 2),
	('ccalhoun', 'password', 'Charles', 'Calhoun', 'ccalhoun@revature.com', 3),
	('ddavis', 'password', 'Daniel', 'Davis', 'ddavis@revature.com', 4),
	('eeinstein', 'password', 'Emily', 'Einstein', 'eeinstein@revature.com', 5);

select * from app_users au;

select * from app_users
where id = 4;

select * from app_users
where email like '%n@revature.com';

-- get all users and present them in reverse order by id==
select * from app_users
order by id desc;

select * from app_users
order by id asc; -- ascending is implicit/default ordering

-- grab data from both app_users and user_roles
select * 
from app_users au
join user_roles ur
on au.role_id = ur.id;

-- grab only the username and password from the app_users table
select username, password 
from app_users;

-- grab only the username and password from the app_users table and role name from user_roles
select au.username, au.password, ur.name
from app_users au
join user_roles ur
on au.role_id = ur.id;

SELECT * FROM app_users;
COMMIT;
