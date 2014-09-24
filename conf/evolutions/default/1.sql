# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table parameters (
  parameterId               integer primary key AUTOINCREMENT,
  problemId                 integer not null,
  parameterName             varchar(255) not null,
  parameterProperName       varchar(255) not null,
  parameterDefaultValue     integer not null)
;

create table problems (
  problemId                 integer primary key AUTOINCREMENT,
  problemName               varchar(255) not null,
  problemQuestion           varchar(255) not null)
;




# --- !Downs

PRAGMA foreign_keys = OFF;

drop table parameters;

drop table problems;

PRAGMA foreign_keys = ON;

