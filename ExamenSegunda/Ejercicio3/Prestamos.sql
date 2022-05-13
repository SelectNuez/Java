DROP DATABASE IF EXISTS Prestamos;
CREATE DATABASE Prestamos;
Use Prestamos;

CREATE TABLE Libros (
Id_libro int,
Titulo VARCHAR(30),
Num_ejemplares int,
Editorial VARCHAR(20),
Num_paginas int,
Fecha_edicion DATE,
CONSTRAINT PK_LIBRO PRIMARY KEY(Id_libro));

CREATE TABLE Socios (
Id_socio int,
Nombre_socio VARCHAR(30),
Edad int,
Direccion VARCHAR(40),
CONSTRAINT PK_SOCIOS PRIMARY KEY (Id_socio));


CREATE TABLE Prestamos (
Id_libro int,
Id_socio int,
Fecha_inicio DATE,
Fecha_fin DATE,
CONSTRAINT PK_PRESTAMOS PRIMARY KEY(Id_libro, Id_socio),
CONSTRAINT FK_PRESTAMOS_LIBROS FOREIGN KEY(Id_libro) REFERENCES LIBROS(Id_libro),
CONSTRAINT FK_PRESTAMOS_SOCIOS FOREIGN KEY(Id_socio) REFERENCES SOCIOS(Id_socio)
);

insert into Libros values (1 ,"Narnia", 5 , "Anaya" , 200 , "1996-5-10"),
(2 ,"Harry Potter", 3 , "Anaya" , 5000 , "2010-3-2"),
(3 ,"Teo en la granja", 10 , "Santillana" , 3 , "2000-6-21"),
 (4 ,"Los Pilares de la Tierra", 25 , "Garceta" , 750 , "1990-2-23");



insert into Socios values (1 , "Antonio" , 21 , "Plz La Malagueta" ),
(2 , "Ivan" , 22 , "Gema" ),
(3 , "Ana" , 30 , "Valle Inclan" ),
(4 , "Joaquin" , 18 , "Ramon Sanchez Pizjuan Pizjuan" );

insert into Prestamos values(1,1,"2022-4-17","2022-4-29"),(2,4,"2022-4-7","2022-4-25");