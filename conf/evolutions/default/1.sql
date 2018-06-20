# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table company (
  id                            bigint auto_increment not null,
  name                          varchar(255) not null,
  constraint pk_company primary key (id)
);

create table computer (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  introduced                    datetime(6),
  discontinued                  datetime(6),
  company_id                    bigint,
  constraint pk_computer primary key (id)
);

create table contact (
  id                            bigint auto_increment not null,
  con_name                      varchar(255) not null,
  con_address                   varchar(255),
  con_email                     varchar(255),
  mobile_number                 varchar(255),
  home_number                   varchar(255),
  office_number                 varchar(255),
  user_id                       bigint,
  constraint pk_contact primary key (id)
);

create table user (
  id                            bigint auto_increment not null,
  first_name                    varchar(255) not null,
  last_name                     varchar(255) not null,
  email                         varchar(255) not null,
  password                      varchar(255) not null,
  constraint pk_user primary key (id)
);

alter table computer add constraint fk_computer_company_id foreign key (company_id) references company (id) on delete restrict on update restrict;
create index ix_computer_company_id on computer (company_id);

alter table contact add constraint fk_contact_user_id foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_contact_user_id on contact (user_id);


# --- !Downs

alter table computer drop foreign key fk_computer_company_id;
drop index ix_computer_company_id on computer;

alter table contact drop foreign key fk_contact_user_id;
drop index ix_contact_user_id on contact;

drop table if exists company;

drop table if exists computer;

drop table if exists contact;

drop table if exists user;

