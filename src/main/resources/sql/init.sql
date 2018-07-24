create table skills
(
  name varchar(25) not null
    primary key
);

create table salaries
(
  vacancy_id varchar(36)                     not null
    primary key,
  amount     double                          not null,
  type       varchar(15) default 'PER_MONTH' null
);

create table skill_requirements
(
  vacancy_id varchar(36)            not null,
  name       varchar(25)            not null,
  level      int(2)                 not null,
  important  tinyint(1) default '0' null,
  primary key (vacancy_id, name),
  constraint skill_requirements_fk
  foreign key (vacancy_id) references vacancies (vacancyId),
  constraint skill_rq_name_fk
  foreign key (name) references skills (name)
);

create index skill_rq_name_fk
  on skill_requirements (name);


create table vacancies
(
  vacancyId     varchar(36)        not null
    primary key,
  name          varchar(100)       not null,
  description   text               not null,
  author_id     varchar(36)        not null,
  hidden        int(1) default '0' null,
  creation_date datetime           null,
  constraint vacancies_fk
  foreign key (author_id) references companies (vacancyId)
);

create index vacancies_fk
  on vacancies (author_id);

create table companies
(
  vacancyId         varchar(36)  not null
    primary key,
  name              varchar(125) not null,
  contact_email     varchar(160) not null,
  registration_date datetime     not null,
  foundation_date   datetime     null
);


