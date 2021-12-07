
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
