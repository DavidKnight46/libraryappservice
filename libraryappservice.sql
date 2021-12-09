create table developer
(
    id   int          not null
        primary key,
    name varchar(255) null
);

create table hibernate_sequence
(
    next_val bigint null
);

create table publisher
(
    id   int         not null
        primary key,
    name varchar(50) null
);

create table users
(
    id       int          not null
        primary key,
    password varchar(255) null,
    username varchar(255) null
);

create table game
(
    id           int          not null
        primary key,
    game_name    varchar(255) null,
    rating       int          null,
    release_date datetime(6)  null,
    developer_id int          null,
    publisher_id int          null,
    user_id      int          not null,
    constraint FKdry9kl3ongf66l7gjnfw0txpn
        foreign key (user_id) references users (id),
    constraint FKevxaidv2wn8bfebjkt1gkhm0t
        foreign key (developer_id) references developer (id),
    constraint FKrkratxa6tso6uahpbd5w9ghay
        foreign key (publisher_id) references publisher (id)
);


