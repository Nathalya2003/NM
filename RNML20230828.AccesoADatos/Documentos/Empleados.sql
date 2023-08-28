USE master;
GO
CREATE DATABASE RNML28;
GO
USE RNML28;
GO
CREATE TABLE Empleados(
[Id] Int identity (1,1) primary key,
[Nombre] [varchar](100)not null,
[Apellido] [varchar](100)not null,
[Email] [varchar](100)not null,
[PuestoEmpleado] [varchar](50)not null,


)
