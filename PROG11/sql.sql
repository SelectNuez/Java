use concesionario;

create table propietarios(
    id_prop int(11) auto_increment,
    nombre_prop varchar(100),
    dni_prop varchar(9),
    constraint id_prop_pk primary key (id_prop)
);
create table vehiculos(
    mat_veh char(7),
    marca_veh varchar(50),
    kms_veh int(11),
    precio_veh float(12),
    desc_veh varchar(300),
    id_prop int(11),
    constraint mat_veh_pk primary key (mat_veh),
    constraint id_prop_fk foreign key (id_prop) references propietarios(id_prop)
);

DELETE FROM propietarios where id_prop > 0;
DELETE FROM vehiculos where id_prop > 0;

select * from vehiculos;
select * from propietarios;

Select count(DNI_prop) from vehiculos v join propietarios p on v.id_prop = p.id_prop WHERE p.dni_prop = '45612378C';