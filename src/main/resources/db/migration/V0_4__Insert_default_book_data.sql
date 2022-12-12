insert into book (id, title, page_number, author_id)
values (1, 'Robison Crusoe', 120, null);
insert into book (id, title, page_number, author_id)
values (2, 'Crime passionnel', 75, 2);
insert into book (id, title, page_number, author_id)
values (3, 'Avar', 600, 3);
insert into book (id, title, page_number, author_id)
values (4, 'Mon chevalier et moi', 254, 4);
insert into book (id, title, page_number, author_id)
values (5, 'You', 468, 5);

alter sequence book_id_seq restart with 6;