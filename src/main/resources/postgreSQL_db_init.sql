create sequence book_seq start with 1 increment by 1;

create table book (id bigint not null, author varchar(50) not null, description varchar(1000), image_url varchar(255), isbn varchar(50) not null, language integer, number_of_pages integer, publication_date date, title varchar(200) not null, unit_cost float, primary key (id));

INSERT INTO book (id,description,image_url,isbn,language,author,number_of_pages,publication_date,title,unit_cost) VALUES(1,'felis ullamcorper viverra. Maecenas iaculis aliquet diam.','mi.felis@icloud.couk',1146,0,'Alika Robbins',4722,'2000-01-01','Suspendisse aliquet, sem ut cursus',148);

ALTER SEQUENCE book_seq RESTART WITH 2;

select * from book;

