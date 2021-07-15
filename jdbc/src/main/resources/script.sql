create table Location
(
            id serial primary key,
            name text   not null,

            unique (name)
);

create table Route(
                      id serial primary key,
                      from_id integer not null,
                      to_id integer not null,
                      cost integer not null ,
                      foreign key (from_id) references Location(id) on delete restrict on update cascade,
                      foreign key (to_id) references Location(id) on delete restrict on update cascade
);

create table Problem(
                        id serial not null primary key,
                        from_id integer not null,
                        to_id integer not null,
                        foreign key (from_id) references Location(id) on delete restrict on update cascade,
                        foreign key (to_id) references Location(id) on delete restrict on update cascade
);

create table Solution(
                         problem_id integer primary key not null ,
                         cost integer,
                         foreign key (problem_id) references Problem(id) on delete cascade on update restrict,
                         check (cost > 0 and cost < 200000)
);

alter table Route add check (cost > 0);

insert into Location(name) values ('gdansk');
insert into Location(name) values ('bydgoszcz');
insert into Location(name) values ('torun');
insert into Location(name) values ('warszawa');

insert into Route(from_id, to_id, cost) values (1, 2, 1);
insert into Route(from_id, to_id, cost) values (1, 3, 3);
insert into Route(from_id, to_id, cost) values (2, 1, 1);
insert into Route(from_id, to_id, cost) values (2, 3, 1);
insert into Route(from_id, to_id, cost) values (2, 4, 4);
insert into Route(from_id, to_id, cost) values (3, 1, 3);
insert into Route(from_id, to_id, cost) values (3, 2, 1);
insert into Route(from_id, to_id, cost) values (3, 4, 1);
insert into Route(from_id, to_id, cost) values (4, 2, 4);
insert into Route(from_id, to_id, cost) values (4, 3, 1);

insert into Problem(from_id, to_id) values (1, 4);
insert into Problem(from_id, to_id) values (2, 4);