

create table Signup(
    meter_no varchar(20),
    username varchar(20),
    name varchar(20),
    password varchar(20),
    usertype varchar(20)
);


select * from Signup;


create table new_customer(
name varchar(20),
meter_no varchar(20),
address varchar(40),
city varchar(20),
state varchar(20),
email varchar(30),
phone_no varchar(20)
);

create table meter_info(
meter_number varchar(20),
meter_location varchar(20),
meter_type varchar(20),
phase_code varchar(20),
bill_type varchar(30),
days varchar(10));

create table tax(
cost_per_unit varchar(20),
meter_rent varchar(20),
service_charge varchar(20),
service_tax varchar(20),
swacch_bharat varchar(20),
fixed_tax varchar(20)
);

insert into tax
values('10','45','20','58','5','18');


create table bill(
meter_no varchar(20),
month varchar(20),
unit varchar(20),
total_bill varchar(20),
status varchar(20)
);
select * from Signup;

