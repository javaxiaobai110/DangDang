create table duser(
       email varchar2(100) primary key,
       password varchar2(100) not null,
       salt varchar2(6) not null
);