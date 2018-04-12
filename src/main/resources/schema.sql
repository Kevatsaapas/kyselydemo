create table if not exists KYSELY(
  kysely_id int (10) not null AUTO_INCREMENT,
  kyselyn_nimi varchar(50) DEFAULT null,
  primary key (kysely_id)
);

create table if not exists KYSYMYS(
  kysymys_id int (10) not null AUTO_INCREMENT,
  kysymyksen_teksti varchar(100) DEFAULT null,
  kysely_id int (10) not null,
  PRIMARY KEY (kysymys_id),
  FOREIGN KEY (kysely_id) REFERENCES KYSELY(kysely_id)
);

create table if not exists KYSYMYSVASTAUS(
  vastaus_id int (10) not NULL AUTO_INCREMENT,
  vastaus_teksti varchar(1000) DEFAULT null,
  PRIMARY KEY (vastaus_id)
);

create table if not exists KYSELYVASTAUS(
  kyselyvastaus_id int (10) not null AUTO_INCREMENT,
  kyselyvastaus varchar(1000) DEFAULT NULL,
  PRIMARY KEY (kyselyvastaus_id)
);