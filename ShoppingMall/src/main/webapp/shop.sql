create database member;

use member;

create table product(
id		int primary key,
category	varchar(10) not null,
wname		varchar(20) not null,
pname		varchar(20) not null,
sname		varchar(20) not null,
price		int default 0,
downprice	int default 0,
inputdate	varchar(20),
stock		int default 0,
description	text,
small		varchar(20),
large		varchar(20)
);

create table saleorder(
id		int primary key,
name		varchar(20) not null,
orderdate	varchar(20) not null,
addr		varchar(50) not null,
tel		varchar(20) not null,
pay		varchar(10) not null,
cardno		varchar(20) not null,
prodcount	int default 0,
total		int default 0
);

create table item(
orderid		int not null,
mynum		int not null,
prodid		int not null,
pname		varchar(40),
quantity	int default 0,
price		int default 0
);