

CREATE TABLE macavi.cliente (
  id         serial NOT NULL, 
  id_locate  int4 NOT NULL, 
  id_usuario int4 NOT NULL, 
  direccion  varchar(60) NOT NULL, 
  telefono   int4 NOT NULL, 
  CONSTRAINT pk_cliente 
    PRIMARY KEY (id), 
  CONSTRAINT uk_usuario 
    UNIQUE (id_usuario));
CREATE TABLE macavi.factura (
  id            serial NOT NULL, 
  id_usuario    int4 NOT NULL, 
  id_cliente    int4 NOT NULL, 
  fecha_fact    date NOT NULL, 
  fecha_venc    date, 
  total_factura int4 NOT NULL, 
  descripcion   varchar(500) NOT NULL, 
  tipo_pago     varchar(10) NOT NULL, 
  CONSTRAINT pk_factura 
    PRIMARY KEY (id));
CREATE TABLE macavi.locate (
  id           serial NOT NULL, 
  pais         varchar(50) NOT NULL, 
  departamento varchar(50) NOT NULL, 
  ciudad       varchar(50) NOT NULL, 
  CONSTRAINT pk_locate 
    PRIMARY KEY (id), 
  CONSTRAINT uk_locate 
    UNIQUE (pais, departamento, ciudad));
CREATE TABLE macavi.producto (
  id                   serial NOT NULL, 
  descripcion_producto varchar(100) NOT NULL, 
  marca                varchar(20) NOT NULL, 
  genero               varchar(20) NOT NULL, 
  talla                int4 NOT NULL, 
  estilo               varchar(20) NOT NULL, 
  cantidad_producto    int4 NOT NULL, 
  porcentaje_iva       float4, 
  CONSTRAINT pk_producto 
    PRIMARY KEY (id));
CREATE TABLE macavi.producto_factura (
  id_producto  int4 NOT NULL, 
  id_factura   int4 NOT NULL, 
  cantidad     int4 NOT NULL, 
  precio_venta numeric(19, 2) NOT NULL, 
  IVA          numeric(19, 2), 
  CONSTRAINT pk_producto_factura 
    PRIMARY KEY (id_producto, 
  id_factura));
CREATE TABLE macavi.rol (
  id         serial NOT NULL, 
  nombre_rol varchar(20) NOT NULL, 
  CONSTRAINT pk_rol 
    PRIMARY KEY (id), 
  CONSTRAINT uk_rol 
    UNIQUE (nombre_rol));
CREATE TABLE macavi.rol_usuario (
  rolid     int4 NOT NULL, 
  usuarioid int4 NOT NULL, 
  PRIMARY KEY (rolid, 
  usuarioid));
CREATE TABLE macavi.tipo_dni (
  id         serial NOT NULL, 
  nombre_dni varchar(20) NOT NULL, 
  CONSTRAINT pk_tipo_dni 
    PRIMARY KEY (id), 
  CONSTRAINT uk_tipo_dni 
    UNIQUE (nombre_dni));
CREATE TABLE macavi.usuario (
  id            serial NOT NULL, 
  id_dni        int4 NOT NULL, 
  numero_dni    int4 NOT NULL, 
  nombre        varchar(20) NOT NULL, 
  login_usuario varchar(80) NOT NULL, 
  password      varchar(30) NOT NULL, 
  email         varchar(100) NOT NULL, 
  CONSTRAINT pk_usuario 
    PRIMARY KEY (id), 
  CONSTRAINT uk_usuario_login 
    UNIQUE (login_usuario), 
  CONSTRAINT uk_dni 
    UNIQUE (id_dni, numero_dni), 
  CONSTRAINT uk_email 
    UNIQUE (email));
ALTER TABLE macavi.cliente ADD CONSTRAINT fk_clie_loca FOREIGN KEY (id_locate) REFERENCES macavi.locate (id) ON UPDATE No action ON DELETE No action;
ALTER TABLE macavi.factura ADD CONSTRAINT fk_fact_clie FOREIGN KEY (id_cliente) REFERENCES macavi.cliente (id) ON UPDATE No action ON DELETE No action;
ALTER TABLE macavi.factura ADD CONSTRAINT fk_fact_usua FOREIGN KEY (id_usuario) REFERENCES macavi.usuario (id) ON UPDATE No action ON DELETE No action;
ALTER TABLE macavi.producto_factura ADD CONSTRAINT fk_prfa_fact FOREIGN KEY (id_factura) REFERENCES macavi.factura (id) ON UPDATE No action ON DELETE No action;
ALTER TABLE macavi.producto_factura ADD CONSTRAINT fk_prfa_prod FOREIGN KEY (id_producto) REFERENCES macavi.producto (id) ON UPDATE No action ON DELETE No action;
ALTER TABLE macavi.rol_usuario ADD CONSTRAINT fk_rol_usua FOREIGN KEY (rolid) REFERENCES macavi.rol (id);
ALTER TABLE macavi.usuario ADD CONSTRAINT fk_usu_dni FOREIGN KEY (id_dni) REFERENCES macavi.tipo_dni (id) ON UPDATE No action ON DELETE No action;
ALTER TABLE macavi.cliente ADD CONSTRAINT fk_usua_clie FOREIGN KEY (id_usuario) REFERENCES macavi.usuario (id);
ALTER TABLE macavi.rol_usuario ADD CONSTRAINT fk_usua_rol FOREIGN KEY (usuarioid) REFERENCES macavi.usuario (id);

/*1 consultar las facturas de un cliente por su tipo_dni y numero_dni*/
SELECT * FROM  macavi.tipo_dni td INNER JOIN macavi.usuario u ON td.id = u.id_dni
INNER JOIN macavi.cliente cl on u.id = cl.id_usuario
INNER JOIN macavi.factura f ON cl.id = f.id_cliente
WHERE td.nombre_dni = 'nit' AND u.numero_dni = '00'; 

/*2 consultar los clientes por locate y numero_dni*/
SELECT * FROM  macavi.tipo_dni td INNER JOIN macavi.usuario u ON td.id = u.id_dni
INNER JOIN macavi.cliente cl on u.id = cl.id_usuario
INNER JOIN macavi.locate lo ON lo.id = cl.id_locate
WHERE u.id_dni = '0' AND cl.id_locate = '1';

/*3 consultar los usuarios por rol*/
SELECT * FROM  macavi.rol r INNER JOIN macavi.rol_usuario ru ON r.id = ru.rolid
INNER JOIN macavi.usuario u on u.id = ru.usuarioid
WHERE r.id  = '1' AND u.id = '1';

/*4 consultar las facturas por producto facturado*/
SELECT * FROM  macavi.producto p INNER JOIN macavi.producto_factura pf ON p.id = pf.id_producto
INNER JOIN macavi.factura f on f.id = pf.id_factura
WHERE f.id  = '1' AND p.id = '1';

/*5 consultar las facturas por usuario*/
SELECT * FROM  macavi.usuario u INNER JOIN macavi.factura f ON u.id = f.id_usuario
WHERE u.id  = '1';

/*6 consultar las facturas por locate*/
SELECT * FROM  macavi.locate l INNER JOIN macavi.cliente cl ON l.id = cl.id_locate
INNER JOIN macavi.factura f ON cl.id = f.id_cliente
WHERE cl.id_locate  = '1' and f.id_cliente = '1';

/*7 consultar cliente por email*/
SELECT * FROM  macavi.usuario u INNER JOIN macavi.cliente cl ON u.id = cl.id_usuario
WHERE u.email  = '' and cl.id = '1'; 

/*8 consultar usuario por tipo dni*/
SELECT * FROM  macavi.tipo_dni td INNER JOIN macavi.usuario u ON td.id = u.id_dni
WHERE u.id_dni  = '1' and u.id = '1';

/*9 consultar cliente por ciudad*/
SELECT * FROM  macavi.locate l INNER JOIN macavi.cliente cl ON l.id = cl.id_locate
WHERE l.pais  = '' and cl.id = '1';

/*9 consultar cliente por ciudad*/
SELECT * FROM  macavi.locate l INNER JOIN macavi.cliente cl ON l.id = cl.id_locate
WHERE l.pais  = '' and cl.id = '1';

/*10 consultar cliente por dni*/
SELECT * FROM  macavi.tipo_dni td INNER JOIN macavi.usuario u ON td.id = u.id_dni
INNER JOIN macavi.cliente cl on u.id = cl.id_usuario
WHERE cl.id = '1' AND u.numero_dni = '00'; 

INSERT INTO macavi.locate(
	pais, departamento, ciudad)
	VALUES ('Colombia','Cundinamarca','soacha');
    
INSERT INTO macavi.rol(
	id,nombre_rol)
	VALUES (1,'ADMIN'),(2,'CLIENTE');

INSERT INTO macavi.producto(
	id, descripcion_producto, marca, genero, talla, estilo, cantidad_producto, porcentaje_iva)
	VALUES (1,'zapatilla color negro con naranja','JORDAN','MASCULINO',39,'RETRO 6',10, 0.19);

INSERT INTO macavi.tipo_dni(
	id, nombre_dni)
	VALUES (1,'NIT'),(2,'CEDULA CIUDADANIA'),(3,'PASAPORTE');

INSERT INTO macavi.usuario(
	id,id_dni, numero_dni, nombre, login_usuario, password, email)
	VALUES (1,2,'1003804101','DEISON MAÑOSCA','Dmañosca','deisonperroloco123','deisonperroloco@gmail.com');

INSERT INTO macavi.factura(
	id, id_usuario, id_cliente, fecha_fact, fecha_venc, total_factura, descripcion, tipo_pago)
	VALUES (1, 1, 1, '14-11-2021','15-11-2021',170000,'mala paga','credito');

INSERT INTO macavi.cliente(
	id, id_locate, id_usuario, direccion, telefono)
	VALUES (1,1,1,'leon 13',3212);




