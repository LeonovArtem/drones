-- liquibase formatted sql
-- changeset aleonov:2

insert into drone (battery_capacity, model, serial_number, state, weight_limit)
values (100, 'HEAVYWEIGHT', 'HEAVY-1', 'IDLE', 500),
       (100, 'HEAVYWEIGHT', 'HEAVY-2', 'LOADING', 500),
       (50, 'CRUISERWEIGHT', 'CRUISER-1', 'IDLE', 400),
       (50, 'CRUISERWEIGHT', 'CRUISER-2', 'LOADING', 400),
       (25, 'MIDDLEWEIGHT', 'MIDDLE-1', 'IDLE', 300),
       (25, 'MIDDLEWEIGHT', 'MIDDLE-2', 'LOADING', 300),
       (10, 'LIGHTWEIGHT', 'LIGHT-1', 'IDLE', 100),
       (10, 'LIGHTWEIGHT', 'LIGHT-2', 'LOADING', 100),
       (5, 'LIGHTWEIGHT', 'LIGHT-3', 'RETURNING', 100),
       (15, 'LIGHTWEIGHT', 'LIGHT-4', 'LOADED', 100)
;

insert into medicament (code, image_url, name, weight)
values ('CODE_1', '/img/1.png', 'MED-1', 50),
       ('CODE_2', '/img/2.png', 'MED-HEAVY-1', 500),
       ('CODE_3', '/img/2.png', 'MED-LIGHT-1', 50),
       ('CODE_4', '/img/2.png', 'MED-LIGHT-2', 10)
;
