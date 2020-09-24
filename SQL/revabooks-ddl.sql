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
	role varchar(10) not null,
	
	constraint app_users_pk
	primary key (id)
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
insert into app_users (username, password, first_name, last_name, email, role)
values 
	('aanderson', 'password', 'Alice', 'Anderson', 'aanderson@revature.com', 'ADMIN');
--	('bbailey', 'password', 'Bob', 'Bailey', 'bbailey@revature.com', ),
--	('ccalhoun', 'password', 'Charles', 'Calhoun', 'ccalhoun@revature.com', 3),
--	('ddavis', 'password', 'Daniel', 'Davis', 'ddavis@revature.com', 4),
--	('eeinstein', 'password', 'Emily', 'Einstein', 'eeinstein@revature.com', 5);

SELECT * FROM app_users;

DELETE FROM app_users WHERE id=1;