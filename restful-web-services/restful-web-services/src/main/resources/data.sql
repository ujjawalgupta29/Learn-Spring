insert into user_details(id, birth_date, name)
values
(1001, current_date(), 'Ujjawal');

insert into user_details(id, birth_date, name)
values
(1002, current_date(), 'Akshay');

insert into user_details(id, birth_date, name)
values
(1003, current_date(), 'Dinesh');

insert into post(id, description, user_id)
values
(20001, 'I want to learn AWS', 1001);

insert into post(id, description, user_id)
values
(20002, 'I want to learn Spring', 1001);

insert into post(id, description, user_id)
values
(20003, 'I want to learn Kube', 1002);

insert into post(id, description, user_id)
values
(20004, 'I want to learn Dance', 1002);