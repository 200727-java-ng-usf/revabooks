CREATE USER revabooks_app
WITH PASSWORD 'revature';

grant all privileges
on database postgres
to revabooks_app;


create table user_accounts(
	account_id int,
	name varchar(25) not null,
	balance Decimal(7, 2),
	
	constraint user_accounts_pk
	primary key (account_id)
	
);

create table app_users(
	id serial,
	username varchar(25) unique not null,
	password varchar(256) not null,
	first_name varchar(25) not null,
	last_name varchar(25) not null,
	
	
	constraint app_users_pk
	primary key (id) 
	
);

create table app_user_accounts(
	user_id int not null references app_users(id),
	account_id int not null,
	
	constraint pk_appUserAccounts primary key (
		user_id,
		account_id
	),
	
	foreign key (user_id) references app_users (id),
	foreign key (account_id) references user_accounts (account_id)
);


SELECT * FROM project0.user_accounts as au 
JOIN project0.app_user_accounts as uae ON au.account_id = uae.account_id;




insert into app_users (username, password, first_name, last_name)
values 
	('aanderson', 'password', 'Alice', 'Anderson'),
	('bbailey', 'password', 'Bob', 'Bailey'),
	('ccalhoun', 'password', 'Charles', 'Calhoun'),
	('ddavis', 'password', 'Daniel', 'Davis'),
	('eeinstein', 'password', 'Emily', 'eeinstein');

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

update project0.user_accounts ua
set 
balance = 10.00 
where 

 ua.account_id = account_id from app_user_accounts 

 and
 
UPDATE project0.user_accounts 
SET balance = 100
WHERE account_id IN (
SELECT account_id 
FROM project0.app_user_accounts 
WHERE app_user_accounts.account_id = account_id 
and account_id = 7890
);



SELECT ua.account_id, uae.user_id FROM project0.user_accounts AS ua 
JOIN project0.app_user_accounts AS uae ON ua.account_id = uae.account_id WHERE uae.user_id = 6;

commit;

SELECT ua.account_id, ua."name", ua.balance, uae.user_id FROM project0.user_accounts as ua 
JOIN project0.app_user_accounts as uae ON ua.account_id = uae.account_id;



UPDATE project0.user_accounts SET balance = 1 WHERE account_id IN 
(SELECT account_id FROM project0.app_user_accounts WHERE app_user_accounts.account_id = account_id and account_id = 6;


