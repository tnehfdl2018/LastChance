create table MEMBER (
    member_id varchar(20) primary key,
    member_pw varchar(20) not null,
    member_email varchar(30) not null,
    member_reg_date timestamp not null
);

create table AUTH_CODE (
    email varchar(30) primary key,
    auth_code varchar(10) not null,
    code_reg_time varchar(20) not null
);