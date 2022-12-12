create table book
(
    id     serial,
    title  varchar,
    page_number int not null default 0,
    author_id int REFERENCES author(id),
    release_date date,
    primary key (id)
);