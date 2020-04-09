CREATE DATABASE ieatit;

CREATE TABLE Usuario (
    IdUsuario INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    Nombre varchar(45),
    Direccion varchar(45),
    Correo varchar(45),
    Telefono varchar(45)
);

CREATE TABLE Administrador (
    IdAdministrador INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    IdUsuario int,
    Nombre varchar(45),
    Direccion varchar(45),
    Correo varchar(45),
    Telefono varchar(45),
    FOREIGN KEY (IdUsuario) REFERENCES Usuario(IdUsuario)
);

CREATE TABLE Repartidor (
    IdRepartidor INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    IdUsuario int,
    Nombre varchar(45),
    Direccion varchar(45),
    Correo varchar(45),
    Telefono varchar(45),
    FOREIGN KEY (IdUsuario) REFERENCES Usuario(IdUsuario)
);

CREATE TABLE Cliente (
    IdCliente INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    IdUsuario int,
    Nombre varchar(45),
    Direccion varchar(45) DEFAULT 'SIN DIRECCION',
    Correo varchar(45),
    Telefono varchar(45),
    FOREIGN KEY (IdUsuario) REFERENCES Usuario(IdUsuario)
);

CREATE TABLE Alimento (
    IdAlimento INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    Nombre varchar(45) NOT NULL,
    Precio int, DEFAULT 0,
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


CREATE TABLE CorreoAdministrador (
    IdAdministrador int,
    FOREIGN KEY (IdAdministrador) REFERENCES Administrador(IdAdministrador)
);

CREATE TABLE CorreoRepartidor (
    IdRepartidor int,
    FOREIGN KEY (IdRepartidor) REFERENCES Repartidor(IdRepartidor)
);

CREATE TABLE CorreoCliente (
    IdCliente int,
    FOREIGN KEY (IdCliente) REFERENCES Cliente(IdCliente)
);

CREATE TABLE TelefonoAdministrador (
    IdAdministrador int,
    FOREIGN KEY (IdAdministrador) REFERENCES Administrador(IdAdministrador)
);

CREATE TABLE TelefonoRepartidor (
    IdRepartidor int,
    FOREIGN KEY (IdRepartidor) REFERENCES Repartidor(IdRepartidor)
);

CREATE TABLE TelefonoCliente (
    IdCliente int,
    FOREIGN KEY (IdCliente) REFERENCES Cliente(IdCliente)
);

CREATE TABLE DireccionAdministrador (
    IdAdministrador int,
    FOREIGN KEY (IdAdministrador) REFERENCES Administrador(IdAdministrador)
);

CREATE TABLE DireccionRepartidor (
    IdRepartidor int,
    FOREIGN KEY (IdRepartidor) REFERENCES Repartidor(IdRepartidor)
);

CREATE TABLE DireccionCliente (
    IdCliente int,
    FOREIGN KEY (IdCliente) REFERENCES Cliente(IdCliente)
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
    FOREIGN KEY (IdAlimento) REFERENCES Alimento(IdAlimento)
    FOREIGN KEY (IdCategoria) REFERENCES Categoria(IdCategoria),
);
