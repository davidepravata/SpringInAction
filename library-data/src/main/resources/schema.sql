-- With it, users can enter information about books they want to read, view the list, and remove books once they’ve been read
drop table if exists registered_user;
drop table if exists userauthorities;
drop table if exists users_books;
drop table if exists books;
drop table if exists users;


create table books(
    id bigint(20) NOT NULL AUTO_INCREMENT,
    title varchar(255) NOT NULL,
    cost decimal(10,2) NOT NULL,
    isbn char(13) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY(isbn)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table users(
    id bigint(20) NOT NULL AUTO_INCREMENT,
    username varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    plain_password varchar(255) NOT NULL,
    email varchar(255) DEFAULT NULL,
    enabled tinyint(1) DEFAULT '1',
    PRIMARY KEY (`id`),
    UNIQUE KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table userauthorities(
    id bigint(20) NOT NULL AUTO_INCREMENT,
    username varchar(255) NOT NULL,
    authority varchar(255) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (username) REFERENCES users(username)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table users_books(
    id bigint(20) NOT NULL AUTO_INCREMENT,
    id_user bigint(20) NOT NULL,
    id_book bigint(20) NOT NULL,
    time_purchase timestamp NOT NULL,
    FOREIGN KEY (id_user) REFERENCES users(id),
    FOREIGN KEY (id_book) REFERENCES books(id),
    UNIQUE KEY(id_user, id_book),
    PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


create table registered_user(
    id bigint(20) NOT NULL AUTO_INCREMENT,
    username varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    UNIQUE KEY(username),
    PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;