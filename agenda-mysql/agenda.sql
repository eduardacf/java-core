create database Agenda;

use Agenda;


create table contato (
    id  auto_increment primary key, 
    nome varchar(100) not null,
    email varchar(100) not null,
    telefone varchar(100) not null
);