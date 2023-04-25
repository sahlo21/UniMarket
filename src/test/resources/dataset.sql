insert into usuario (codigo, contrasena, email, nombre, direccion, telefono) values (1, "aceituna", "pepito@gmail.com", "pepito", "Calle 11 # 2 - 33","7506789");
insert into usuario (codigo, contrasena, email, nombre, direccion, telefono) values (2, "brocoli", "juanita@gmail.com", "juanita", "Calle 12 # 1 - 63","3152089978");
insert into usuario (codigo, contrasena, email, nombre, direccion, telefono) values (3, "perejil", "andrea@gmail.com", "andrea", "Calle 13 # 2 - 13","3102089978");
insert into usuario (codigo, contrasena, email, nombre, direccion, telefono) values (4, "cilantro", "kevin@gmail.com", "kevin", "Calle 14 # 3 - 23","3212089978");
insert into usuario (codigo, contrasena, email, nombre, direccion, telefono) values (5, "puerro", "juancho@gmail.com", "juan", "Calle 15 # 17 - 43","3178586989");

insert into producto (codigo, descripcion, estado, fecha_creacion, fecha_limite, nombre, precio, unidades, usuario_codigo) values (6, "Sirve para escribir", "SIN_REVISAR", '2023-02-28', '2023-03-28', "lapiz", 15000, 17, 1);
insert into producto (codigo, descripcion, estado, fecha_creacion, fecha_limite, nombre, precio, unidades, usuario_codigo) values (7, "Se utiliza en la construccion", "AUTORIZADOS", '2023-02-25', '2023-03-25', "ladrillos", 1700, 1, 2);
insert into producto (codigo, descripcion, estado, fecha_creacion, fecha_limite, nombre, precio, unidades, usuario_codigo) values (8, "Utiles para el mal aliento", "SIN_REVISAR", '2023-02-23', '2023-03-23', "mentas", 100, 100, 3);
insert into producto (codigo, descripcion, estado, fecha_creacion, fecha_limite, nombre, precio, unidades, usuario_codigo) values (9, "Para mejorar bebidas", "NO_AUTORIZADOS", '2023-02-10', '2023-03-10', "azucar", 17000, 30, 4);
insert into producto (codigo, descripcion, estado, fecha_creacion, fecha_limite, nombre, precio, unidades, usuario_codigo) values (10, "Vienen de un pato", "AUTORIZADOS", '2023-02-15', '2023-03-15', "plumas", 5000, 25, 5);

insert into compra (codigo, fecha_creacion, medio_pago, valor_total, usuario_codigo) values (11, '2023-03-18', "EFECTY", 18000, 1);
insert into compra (codigo, fecha_creacion, medio_pago, valor_total, usuario_codigo) values (12, '2023-03-19', "PSE", 20000, 2);
insert into compra (codigo, fecha_creacion, medio_pago, valor_total, usuario_codigo) values (13, '2023-03-20', "TARJETA_CREDITO", 8000, 3);
insert into compra (codigo, fecha_creacion, medio_pago, valor_total, usuario_codigo) values (14, '2023-03-8', "TARJETA_DEBITO", 100, 4);
insert into compra (codigo, fecha_creacion, medio_pago, valor_total, usuario_codigo) values (15, '2023-03-12', "PSE", 3000, 5);

insert into detalle_compra (codigo, precio, unidades, compra_codigo, producto_codigo) values (16, 17000, 10, 11, 6);
insert into detalle_compra (codigo, precio, unidades, compra_codigo, producto_codigo) values (17, 19000, 3, 12, 7);
insert into detalle_compra (codigo, precio, unidades, compra_codigo, producto_codigo) values (18, 7000, 7, 13, 8);
insert into detalle_compra (codigo, precio, unidades, compra_codigo, producto_codigo) values (19, 90, 1, 14, 9);
insert into detalle_compra (codigo, precio, unidades, compra_codigo, producto_codigo) values (20, 2000, 6, 15, 10);

insert into calificacion (codigo, estrellas, producto_codigo, usuario_codigo) values (21, 5, 6, 5);
insert into calificacion (codigo, estrellas, producto_codigo, usuario_codigo) values (22, 4, 7, 4);
insert into calificacion (codigo, estrellas, producto_codigo, usuario_codigo) values (23, 1, 8, 2);
insert into calificacion (codigo, estrellas, producto_codigo, usuario_codigo) values (24, 2, 9, 3);
insert into calificacion (codigo, estrellas, producto_codigo, usuario_codigo) values (25, 3, 10, 1);

insert into comentario (codigo, fecha_creacion, observacion, producto_codigo, usuario_codigo) values (26, '2023-03-18', "Epico", 6, 5);
insert into comentario (codigo, fecha_creacion, observacion, producto_codigo, usuario_codigo) values (27, '2023-03-20', "Bueno", 7, 4);
insert into comentario (codigo, fecha_creacion, observacion, producto_codigo, usuario_codigo) values (28, '2023-03-12', "Malisima calidad", 8, 2);
insert into comentario (codigo, fecha_creacion, observacion, producto_codigo, usuario_codigo) values (29, '2023-03-15', "No vale la pena", 9, 3);
insert into comentario (codigo, fecha_creacion, observacion, producto_codigo, usuario_codigo) values (30, '2023-03-17', "Esta meh", 10, 1);

insert into cupon (codigo, valor) values (31, 2000);
insert into cupon (codigo, valor) values (32, 15000);
insert into cupon (codigo, valor) values (33, 25000);
insert into cupon (codigo, valor) values (34, 5000);
insert into cupon (codigo, valor) values (35, 24999);

insert into favoritos_productos (id_favorito_producto, producto_codigo, usuario_codigo) values (36, 6, 5);
insert into favoritos_productos (id_favorito_producto, producto_codigo, usuario_codigo) values (37, 7, 4);
insert into favoritos_productos (id_favorito_producto, producto_codigo, usuario_codigo) values (38, 8, 2);
insert into favoritos_productos (id_favorito_producto, producto_codigo, usuario_codigo) values (39, 9, 3);
insert into favoritos_productos (id_favorito_producto, producto_codigo, usuario_codigo) values (40, 10, 1);

insert into imagen (id_imagen, ruta, producto_codigo) values (41, "C:\imagen\lapiz.jpg", 6);
insert into imagen (id_imagen, ruta, producto_codigo) values (42, "C:\imagen\ladrillo.jpg", 7);
insert into imagen (id_imagen, ruta, producto_codigo) values (43, "C:\imagen\mentas.jpg", 8);
insert into imagen (id_imagen, ruta, producto_codigo) values (44, "C:\imagen\azucar.jpg", 9);
insert into imagen (id_imagen, ruta, producto_codigo) values (45, "C:\imagen\plumas.jpg", 10);

insert into moderador (codigo, contrasena, email, nombre) values (46, "contraseña123", "juana@gmail.com", "juana");
insert into moderador (codigo, contrasena, email, nombre) values (47, "contraseña321", "antonia@gmail.com", "antonia");
insert into moderador (codigo, contrasena, email, nombre) values (48, "contraseña213", "andres@gmail.com", "andres");
insert into moderador (codigo, contrasena, email, nombre) values (49, "contraseña456", "benito@gmail.com", "benito");
insert into moderador (codigo, contrasena, email, nombre) values (50, "contraseña785", "julian@gmail.com", "julian");

insert into producto_categoria_list (producto_codigo, categoria_list) values (6, 1);
insert into producto_categoria_list (producto_codigo, categoria_list) values (7, 2);
insert into producto_categoria_list (producto_codigo, categoria_list) values (8, 3);
insert into producto_categoria_list (producto_codigo, categoria_list) values (9, 4);
insert into producto_categoria_list (producto_codigo, categoria_list) values (10, 5);

insert into producto_moderado (codigo, fecha_revision, motivo, moderador_codigo, producto_codigo) values (51, '2023-03-12', "Descripcion no valida", 46, 6);
insert into producto_moderado (codigo, fecha_revision, motivo, moderador_codigo, producto_codigo) values (52, '2023-03-13', "Descripcion no valida", 47, 7);
insert into producto_moderado (codigo, fecha_revision, motivo, moderador_codigo, producto_codigo) values (53, '2023-03-14', "Nombre no valido", 48, 8);
insert into producto_moderado (codigo, fecha_revision, motivo, moderador_codigo, producto_codigo) values (54, '2023-03-15', "Producto no valido", 49, 9);
insert into producto_moderado (codigo, fecha_revision, motivo, moderador_codigo, producto_codigo) values (55, '2023-03-18', "Nombre no valido", 50, 10);

insert into producto_moderado_estados (producto_moderado_codigo, estados) values (51, 1);
insert into producto_moderado_estados (producto_moderado_codigo, estados) values (52, 4);
insert into producto_moderado_estados (producto_moderado_codigo, estados) values (53, 5);
insert into producto_moderado_estados (producto_moderado_codigo, estados) values (54, 2);
insert into producto_moderado_estados (producto_moderado_codigo, estados) values (55, 3);

insert into usuario_cupones (id_favorito_producto, cupon_codigo, usuario_codigo) values (56, 31, 1);
insert into usuario_cupones (id_favorito_producto, cupon_codigo, usuario_codigo) values (57, 32, 3);
insert into usuario_cupones (id_favorito_producto, cupon_codigo, usuario_codigo) values (58, 33, 5);
insert into usuario_cupones (id_favorito_producto, cupon_codigo, usuario_codigo) values (59, 34, 4);
insert into usuario_cupones (id_favorito_producto, cupon_codigo, usuario_codigo) values (60, 35, 2);
