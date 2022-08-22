-- создание таблицы городов
create table city
(
    id      bigserial primary key,
    city_id bigInt not null
        unique,
    name    text   not null,
    state   text,
    country text
);
comment
on table city is 'города';
comment
on column city.id is 'id города';
comment
on column city.name is 'название города';
comment
on column city.state is 'штат';
comment
on column city.country is 'город';
comment
on column city.city_id is 'id города';