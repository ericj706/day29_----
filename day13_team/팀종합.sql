DROP DATABASE if EXISTS dbtotal;
CREATE DATABASE dbtotal;
USE dbtotal;
CREATE TABLE board( 
    no int AUTO_INCREMENT , 
    content VARCHAR(255) ,
    writer VARCHAR(30) ,
    constraint PRIMARY KEY( no ) 
);
insert into board( content, writer )values( "안녕하세요", "유재석" ),( "누구세요", "강호동");

CREATE TABLE qna( 
    no int AUTO_INCREMENT , 
    question VARCHAR(255) ,
    writer VARCHAR(30) ,
    FOREIGN KEY(no) REFERENCES board(no)
);
insert into qna( question, writer )values( "안녕하세요", "유재석" ),( "문의있어요", "강호동");
