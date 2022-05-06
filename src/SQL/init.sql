CREATE TABLE CLANS
( clan_id number(10) NOT NULL,
  clan_name varchar2(50) NOT NULL,
  gold varchar2(50),
  CONSTRAINT customers_pk PRIMARY KEY (clan_id)
);

insert into CLANS (clan_id, clan_name, gold) values
(1, 'Clan_1', 0);

--action - 1 это добавление золота, 2 это уменьшение золота
CREATE TABLE TRACK_GOLD
( clan_id number(10) NOT NULL,
  user_id number(10) NOT NULL,
  gold number(10),
  action number(1)
);

commit;
