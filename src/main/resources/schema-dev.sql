
create table IF NOT EXISTS ACCOUNTS (
	customer_id varchar(16) not null,
	acc_number varchar(16) not null,
	branch_id decimal(8,0),
	balance decimal(16,4)	
);

--TRUNCATE TABLE BOOKS;
