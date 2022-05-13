CREATE DATABASE biblioteca;
use biblioteca;
Create table biblioteca (
ISBN VARCHAR(10),
Titulo VARCHAR(50),
editorial VARCHAR(50),
socio VARCHAR(50),
fecha_prestamo date,
fecha_devolucion date
);

insert into biblioteca values("1","El temor de un hombre sabio","Delta","Kaladin","2022-05-01","2022-05-12");
insert into biblioteca values("2","Perico los palotes","Delta","Kaladin","2022-05-01","2022-05-12");

Create table Socio (
Nombre VARCHAR(50),
DNI VARCHAR(9),
id_Socio VARCHAR(5) Primary Key
);

insert into Socio values("Alfonso","12345678A","1");
insert into Socio values("Amelia","98765432B","2");

select * from biblioteca;
select * from biblioteca where titulo = "Delta" OR editorial = "Delta";