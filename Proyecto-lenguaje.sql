---creado con el sys
create tablespace Proyecto datafile 'c:\Proyecto-lenguaje\Proyecto01.dbf' size 100m
default storage (initial 1m next 1m pctincrease 0);

create user Carlos identified by Carlos
default tablespace Proyecto
temporary tablespace temp;
alter user Carlos quota UNLIMITEd on Proyecto;
grant connect,resource to Carlos;



drop table cliente;
CREATE TABLE cliente (
  id_cliente int  ,
  cedula varchar(8) not null,
  nombre varchar(100) NOT NULL,
  apellido varchar(100) NOT NULL,
  PRIMARY KEY (id_cliente)
);
CREATE TRIGGER trig_usuarios_seque
  BEFORE INSERT ON cliente
  FOR EACH ROW
  BEGIN
    SELECT seq_usuarios_id_cliente.nextval INTO :new.id_cliente FROM dual;
  END
;


CREATE SEQUENCE seq_usuarios_id_cliente --nombre de la secuencia
START WITH 1 --la secuencia empieza por 1
INCREMENT BY 1 --se incrementa de uno en uno
NOMAXVALUE; --no tiene valor maximo


----Prueba--------------------------------------
INSERT INTO cliente(cedula , nombre,apellido) VALUES('121221', 'carlos','Matamoros');
INSERT INTO cliente(cedula , nombre,apellido) VALUES('111111', 'Sandy','Mejia');
select * from cliente;
-------------------------------------------------

create table telefonos(
id_cliente int not null,
tipoTelefono varchar2(15),
numero varchar2(8));

alter table telefonos add constraint FK_id_cliente
foreign key (id_cliente)
references cliente(id_cliente);

alter table telefonos add primary key (tipoTelefono);

--
CREATE TRIGGER trig_Telefono_seque
  BEFORE INSERT ON telefonos
  FOR EACH ROW
  BEGIN
    SELECT seq_telefonos_tipo.nextval INTO :new.tipoTelefono FROM dual;
  END
;

CREATE SEQUENCE seq_telefonos_tipo --nombre de la secuencia
START WITH 1 --la secuencia empieza por 1
INCREMENT BY 1 --se incrementa de uno en uno
NOMAXVALUE; --no tiene valor maximo

---Pruebas---
insert into telefonos(id_cliente , numero) values ('1' ,'83994559');
insert into telefonos(id_cliente , numero) values ('2' ,'83629573');
insert into telefonos(id_cliente , numero) values ('7' ,'8362');
select * from telefonos;

create table provincias(
idProvincias int not null ,
descripcion varchar(45));

alter table provincias add primary key (idProvincias);

--pruebas---------------------------------------------------
insert into provincias(idProvincias , descripcion) values (1 ,'San Jose');
insert into provincias(idProvincias , descripcion) values (2 ,'Alajuela');
insert into provincias(idProvincias , descripcion) values (3 ,'Cartago');
insert into provincias(idProvincias , descripcion) values (4 ,'Heredio');
insert into provincias(idProvincias , descripcion) values (5 ,'Guanacaste');
insert into provincias(idProvincias , descripcion) values (6 ,'Puntarenas');
insert into provincias(idProvincias , descripcion) values (7 ,'Limon');
insert into provincias(idProvincias , descripcion) values (8 ,'Extranjero...');
select * from provincias;

--------------------------------------------------------------
create table cantones(
idcantones int not null ,
provincia int not null ,
descripcion varchar(45));

alter table cantones add primary key (idcantones);

create table distrito(
idDistrito int not null ,
canton int not null ,
descripcion varchar(45));

alter table distrito add primary key (idDistrito);
-------------------------------------
create table direccion(
idDireccion int not null,
id_cliente int not null,
domicilio varchar (45),
idProvincia int not null,
idCanton int not null,
idDistrito int not null);

alter table direccion add constraint FK_id_direccion_cliente
foreign key (id_cliente)
references cliente(id_cliente);

alter table direccion add constraint FK_id_direccion_provincia
foreign key (idProvincia)
references provincias(idProvincias);

alter table direccion add constraint FK_id_direccion_canton
foreign key (idCanton)
references cantones(idCantones);

alter table direccion add constraint FK_id_direccion_distrito
foreign key (idDistrito)
references distrito(idDistrito);

alter table direccion add primary key (idDireccion);



----------------------------

create table vehiculo (
idVehiculo int not null ,
id_cliente int not null,
placa varchar(6),
modelo varchar(15),
marca varchar(15),
estado varchar(15));

alter table vehiculo add constraint FK_id_cliente_vehiculo
foreign key (id_cliente)
references cliente(id_cliente);

alter table vehiculo add primary key (placa);

select * from vehiculo;
insert into vehiculo(idVehiculo , id_cliente , placa,modelo,marca, tipoVehiculo) values (1,1 ,'989919' , '4x4' ,'Toyota' , 'mantenimiento');
insert into vehiculo(idVehiculo , id_cliente , placa,modelo,marca, tipoVehiculo) values (2,1 ,'123456' , '4x4' ,'mercedes' , 'espera');
-----------------------------------

create table mecanicos(
idMecanicos int ,
cedula_mecanico varchar(8),
nombre varchar(8),
apellido varchar(20),
FechaIngreso date);

alter table mecanicos add primary key (idMecanicos);

-----------

create table aigna_mantenimiento(
idMantenimiento int not null ,
idMecanico int not null);


alter table aigna_mantenimiento add constraint FK_id_mecanico
foreign key (idMecanico)
references mecanicos(idMecanicos);

alter table aigna_mantenimiento add primary key (idMantenimiento);

-------------------------------
drop table mantenimiento;
create table mantenimiento(
idMantenimiento int not null ,
placa varchar(8),
descripcion varchar(90),
fechaHoraLL date ,
fechaHoraSA date);

alter table mantenimiento add constraint FK_id_mantenimiento
foreign key (placa)
references vehiculo(placa);
alter table mantenimiento add primary key (idMantenimiento);

delete from mantenimiento where idmantenimiento =1;

select * from mantenimiento;
insert into mantenimiento(idMantenimiento , placa ,descripcion , fechaHoraLL , fechaHoraSa)values (2 ,'989919' ,'cambio de llantas','04/01/2020' , '06/01/2020');
insert into mantenimiento(idMantenimiento , placa ,descripcion , fechaHoraLL , fechaHoraSa)values (1 ,'123456' ,'cambio de llantas','04/01/2020' , '06/01/2020');

------------------------------
drop table detalle_mantenimiento;
/*create table detalle_mantenimiento(
idDetalle_mantenimiento int not null ,
idMantenimiento int ,
tarea varchar(90),
fecha_hora_inicio date, 
fecha_hora_fin date);*/

/*alter table detalle_mantenimiento add constraint FK_id_mantenimiento_detalle
foreign key (idMantenimiento)
references mantenimiento(idMantenimiento);
alter table detalle_mantenimiento add primary key (idDetalle_mantenimiento);
insert into DETALLE_MANTENIMIENTO(idDetalle_mantenimiento, idMantenimiento,tarea ,fecha_hora_inicio , fecha_hora_fin) values(1 ,1 ,'lavado de motor','06/01/2022' , '07/01/2020' );
select * from detalle_mantenimiento;*/
---------------------------
create table detalle_factura(
idDetalleFactura int not null ,
idFactura int not null ,
idDetalle_mantenimiento int,
subTotal long,
IVA int);

alter table detalle_factura add constraint FK_detalle_factura
foreign key (idDetalle_Mantenimiento)
references detalle_mantenimiento(idDetalle_mantenimiento);

alter table detalle_factura add constraint FK_facturaa
foreign key (idFactura)
references Factura(idFactura);


alter table detalle_factura add primary key (idDetalleFactura);

create table Factura(
idFactura int ,
id_cliente int not null,
fechaFact date,
montoTotal long);


alter table Factura add constraint FK_Factura
foreign key (id_cliente)
references cliente(id_cliente);

alter table Factura add primary key (idFactura);
-----------------------------------------------------

-------------Principales Funcionalidades---------------------

/*El administrador puede consultar la información de los
autos que están en 
el taller, como el daño que presenta y cuál mecánico está a cargo*/
create view  vista_VEHICULOS as
   select e.IDVEHICULO, c.nombre ||'-'|| apellido "Cliente" ,e.PLACA  "Placa Vehiculo",m.DESCRIPCION "descripcion"
   from VEHICULO e  join cliente c on e.ID_CLIENTE = c.ID_CLIENTE 
   join mantenimiento m on e.PLACA = m.PLACA;
select * from vista_vehiculos;

/*El sistema permitirá que para el cliente se le 
ingrese sus datos personales (para efectos de facturación electrónica y
también en el caso de que deseara contactar con el mismo) así también como 
los datos requeridos del vehículo; con antelación para que
el personal del taller pueda organizar lo necesario para dar solución.*/ 
----------------------------------------------
create or replace procedure ingresar_datoss( param_cedula in VARCHAR , param_nombre in VARCHAR,
  param_apellido in VARCHAR)

as
  var_cedula varchar(8);
  var_nombre varchar(100);
  var_apellido varchar(100);
  var_resultado varchar(100);
  
begin

var_cedula :=param_cedula;
var_nombre :=param_nombre;
var_apellido := param_apellido;

var_resultado :='Los datos fueron ingresados de manera correcta';
  insert into cliente(cedula , nombre, apellido)values(var_cedula,var_nombre , var_apellido);
  dbms_output.put_line(var_resultado);
end;
set serveroutput on;
  ---------------------------------------------
  execute ingresar_datoss('00000','prueba','prueba');
  -------------------------------------------
  


