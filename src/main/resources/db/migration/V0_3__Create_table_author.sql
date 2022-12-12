create table author
(
    id     serial,
    name varchar,
<<<<<<< HEAD
    particularity  varchar,
    birthdate DATE,
=======
    particularity varchar,
    birth_date date,
>>>>>>> 6e6c299 (q3(chore): implements author crud endpoints)
    primary key (id)
);