create table if not exists Kysymys(
  id int (10) not null AUTO_INCREMENT,
  kysymysTeksti varchar(200) DEFAULT null,
  primary key (id)
);