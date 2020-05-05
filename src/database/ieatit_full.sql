CREATE DATABASE ieatit;

CREATE TABLE usuario(
    IdUsuario 			SERIAL PRIMARY KEY,
    Nombre				VARCHAR(50) 	NOT NULL CHECK(nombre NOT SIMILAR TO '%[0-9]'),
	Paterno				VARCHAR(50) 	NOT NULL CHECK(paterno NOT SIMILAR TO '%[0-9]'),
	Materno				VARCHAR(50) CHECK(materno NOT SIMILAR TO '%[0-9]'),
	Genero				CHAR(1)		NOT NULL CHECK( genero IN ('H','M'))
);

CREATE TABLE cliente(
	IdCliente 			SERIAL PRIMARY KEY,
	IdUsuario			INT NOT NULL,
	CONSTRAINT fk_cliente_usuario FOREIGN KEY(idUsuario) REFERENCES usuario(idUsuario) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT uk_cliente UNIQUE(idUsuario)
);

CREATE TABLE repartidor(
	IdRepartidor		SERIAL PRIMARY KEY,
	IdUsuario			INT NOT NULL,
	CONSTRAINT fk_repartidor_usuario FOREIGN KEY(idUsuario) REFERENCES usuario(idUsuario) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT uk_repartidor UNIQUE(idUsuario)
);

CREATE TABLE administrador(
	IdAdministrador		SERIAL PRIMARY KEY,
	IdUsuario			INT NOT NULL,
	CONSTRAINT fk_administrador_usuario FOREIGN KEY(idUsuario) REFERENCES usuario(idUsuario) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT uk_administrador UNIQUE(idUsuario)
);

CREATE TABLE Alimento (
    IdAlimento INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    Nombre varchar(45) NOT NULL,
    Precio int DEFAULT 0,
    Descripcion varchar(255)
);

CREATE TABLE Categoria (
    IdCategoria INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    Nombre varchar(45) NOT NULL,
    Descripcion varchar(255)
);

CREATE TABLE Orden (
    IdOrden INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    NombreCliente varchar(45),
    DireccionCliente varchar(45),
    Estado varchar(45),
    HoraCreacion time,
    HoraEntrega time
);

/**
* Sección de tablas de atributos multivaluados.
**/


CREATE TABLE correo(
	Correo				VARCHAR(100) 	NOT NULL CHECK(Correo LIKE '%_@%_.%_'),
	IdUsuario 			INT		NOT NULL,
	CONSTRAINT pk_correo PRIMARY KEY (Correo,IdUsuario),
	CONSTRAINT fk_correo_usuario FOREIGN KEY(IdUsuario) REFERENCES usuario(IdUsuario) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE telefono(
	Telefono			CHAR(10) 	NOT NULL CHECK(Telefono ~ '[0-9]{8,10}'),
	IdUsuario 			INT		NOT NULL,
	CONSTRAINT pk_telefono PRIMARY KEY (Telefono,IdUsuario),
	CONSTRAINT fk_telefono_usuario FOREIGN KEY(IdUsuario) REFERENCES usuario(IdUsuario) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE direccion(
	Direccion			VARCHAR(100) 	NOT NULL,
	IdUsuario 			INT		NOT NULL,
	CONSTRAINT pk_direccion PRIMARY KEY (direccion,IdUsuario),
	CONSTRAINT fk_direccion_usuario FOREIGN KEY(IdUsuario) REFERENCES usuario(IdUsuario) ON DELETE CASCADE ON UPDATE CASCADE
);

/**
* Sección de tablas de atributos multivaluados.
**/

CREATE TABLE Administrar (
    IdAdministrador int,
    IdAlimento int,
    IdCategoria int,
    FOREIGN KEY (IdAdministrador) REFERENCES Administrador(IdAdministrador),
    FOREIGN KEY (IdAlimento) REFERENCES Alimento(IdAlimento),
    FOREIGN KEY (IdCategoria) REFERENCES Categoria(IdCategoria)
);

CREATE TABLE Ver (
    IdCliente int,
    IdAlimento int,
    IdCategoria int,
    FOREIGN KEY (IdCliente) REFERENCES Cliente(IdCliente),
    FOREIGN KEY (IdAlimento) REFERENCES Alimento(IdAlimento),
    FOREIGN KEY (IdCategoria) REFERENCES Categoria(IdCategoria)
);

CREATE TABLE Pedir (
    IdCliente int,
    IdOrden int,
    FOREIGN KEY (IdCliente) REFERENCES Cliente(IdCliente),
    FOREIGN KEY (IdOrden) REFERENCES Orden(IdOrden)
);

CREATE TABLE Seleccionar (
    IdRepartidor int,
    IdOrden int,
    FOREIGN KEY (IdRepartidor) REFERENCES Repartidor(IdRepartidor),
    FOREIGN KEY (IdOrden) REFERENCES Orden(IdOrden)
);

CREATE TABLE Formar (
    IdOrden int,
    IdAlimento int,
    FOREIGN KEY (IdOrden) REFERENCES Orden(IdOrden),
    FOREIGN KEY (IdAlimento) REFERENCES Alimento(IdAlimento)
);

CREATE TABLE Pertenecer (
    IdAlimento int,
    IdCategoria int,
    FOREIGN KEY (IdAlimento) REFERENCES Alimento(IdAlimento),
    FOREIGN KEY (IdCategoria) REFERENCES Categoria(IdCategoria));