delete from registered_user;
delete from userauthorities;
delete from users_books;
delete from users;
delete from books;


delete from registered_user;

insert into users(id,username, password, plain_password, email,enabled) values (1,"davide.pravata","ec","ec","davide.pravata@virgilio.it",1);
insert into users(id, username, password, plain_password, email,enabled) values (2,"eleonora.cella","dp","dp","eleonora.cella1@libero.it",1);

insert into userauthorities(username, authority) values ("davide.pravata","ADMIN");
insert into userauthorities(username, authority) values ("eleonora.cella","USER");

insert into books(id,title, cost, isbn) values(1,"Manuale di Java 9",49.90, "9788820383022");
insert into books(id,title, cost, isbn) values(2,"Design Patterns",39.00, "978887192150X");
insert into books(id,title, cost, isbn) values(3,"Java Tecniche avanzate di programmazione",49.00, "9788850323891");
insert into books(id,title, cost, isbn) values(4,"Java Fondamenti di programmazione",39.00, "9788850323883");
insert into books(id,title, cost, isbn) values(5,"MongoDB: The Definitive Guide",35.19, "9781449344689");
insert into books(id,title, cost, isbn) values(6,"Head First Design Patterns",52.79, "9780596007126");
insert into books(id,title, cost, isbn) values(7,"Spring Boot In Action",29.44, "9781617292545");

insert into users_books(id_user, id_book, time_purchase) values (1,1,"2015-12-01 12:00:00");
insert into users_books(id_user, id_book, time_purchase) values (1,2,"2016-06-01 12:00:00");
insert into users_books(id_user, id_book, time_purchase) values (1,3,"2016-12-01 12:00:00");
insert into users_books(id_user, id_book, time_purchase) values (1,4,"2017-06-01 12:00:00");
insert into users_books(id_user, id_book, time_purchase) values (1,5,"2017-12-01 12:00:00");
insert into users_books(id_user, id_book, time_purchase) values (1,6,"2018-06-01 12:00:00");
insert into users_books(id_user, id_book, time_purchase) values (1,7,"2018-12-01 12:00:00");

insert into registered_user(username,password) values("davide.pravata","dp");

