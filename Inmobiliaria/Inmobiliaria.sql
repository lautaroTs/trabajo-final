CREATE DATABASE IF NOT EXISTS Inmobiliaria;

Create Table Usuario (
id varchar(50) not null,
nombre varchar(50) not null,
apellido varchar(50) not null,
email varchar(50) not null,
contrasenia varchar(50) not null,
nivelAcceso int not null,
primary key (id));

Create Table Administracion (
id varchar(50) not null,
nombre varchar(50) not null,
apellido varchar(50) not null,
email varchar(50) not null,
contrasenia varchar(50) not null,
nivelAcceso int not null,
direccion varchar(100) not null,
primary key (id));

Create Table Inquilino (
id varchar(50) not null,
nombre varchar(50) not null,
apellido varchar(50) not null,
email varchar(50) not null,
contrasenia varchar(50) not null,
nivelAcceso int not null,
dni bigint not null,
primary key (id));

Create Table Propietario (
id varchar(50) not null,
nombre varchar(50) not null,
apellido varchar(50) not null,
email varchar(50) not null,
contrasenia varchar(50) not null,
nivelAcceso int not null,
dni bigint not null,
direccion varchar(100) not null, primary key (id));

Create Table Propiedad (
id varchar(50) not null,
zona varchar(50) not null,
direccion varchar(50) not null,
superficie double not null,
banios int not null,
estacionamiento boolean not null,
precio varchar(50) not null,
disponibilidadInicio date not null,
disponibilidadFinal date not null,
expensas double not null,
plantas int not null,
antiguedad int not null,
alquiler boolean not null,
venta boolean not null, 
primary key (id));

Create Table Locales (
id varchar(50) not null,
zona varchar(50) not null,
direccion varchar(50) not null,
superficie double not null,
banios int not null,
estacionamiento boolean not null,
precio varchar(50) not null,
disponibilidadInicio date not null,
disponibilidadFinal date not null,
expensas double not null,
plantas int not null,
antiguedad int not null,
alquiler boolean not null,
venta boolean not null, 
primary key (id));

Create Table Depto (
id varchar(50) not null,
zona varchar(50) not null,
direccion varchar(50) not null,
superficie double not null,
banios int not null,
estacionamiento boolean not null,
precio varchar(50) not null,
disponibilidadInicio date not null,
disponibilidadFinal date not null,
expensas double not null,
plantas int not null,
antiguedad int not null,
alquiler boolean not null,
venta boolean not null, 
amoblado boolean not null, 
espCompartidos boolean not null, 
piso int not null, 
patio boolean not null, 
domritorios int not null, 
ambientes int not null, 
seguridad boolean not null, 
mascotas boolean not null, 
primary key (id));

Create Table Casa (
id varchar(50) not null,
zona varchar(50) not null,
direccion varchar(50) not null,
superficie double not null,
banios int not null,
estacionamiento boolean not null,
precio varchar(50) not null,
disponibilidadInicio date not null,
disponibilidadFinal date not null,
expensas double not null,
plantas int not null,
antiguedad int not null,
alquiler boolean not null,
venta boolean not null, 
amoblado boolean not null,  
jardin boolean not null, 
domritorios int not null, 
ambientes int not null, 
mascotas boolean not null, primary key (id));