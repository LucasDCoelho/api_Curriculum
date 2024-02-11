CREATE TABLE users(
    id bigint not null unique auto_increment,
    login varchar(255) unique not null,
    password varchar(255) not null,
    role text not null,

    primary key (id)
);