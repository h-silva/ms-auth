create table if not exists cdt_user (
    uuid text primary key not null,
    username text not null unique,
    password text not null,
    active boolean default false
);