insert into usuario values (1, "aceituna", "pepito@gmail.com", "pepito", "Calle 11 # 2 - 33","7506789");
insert into usuario values (2, "brocoli", "juanita@gmail.com", "juanita", "Calle 12 # 1 - 63","3152089978");
insert into usuario values (3, "perejil", "andrea@gmail.com", "andrea", "Calle 13 # 2 - 13","3102089978");
insert into usuario values (4, "cilantro", "kevin@gmail.com", "kevin", "Calle 14 # 3 - 23","3212089978");
insert into usuario values (5, "puerro", "juancho@gmail.com", "juan", "Calle 15 # 17 - 43","3178586989");

insert into cupon values (6, 2000);
insert into cupon values (7, 15000);
insert into cupon values (8, 25000);
insert into cupon values (9, 5000);
insert into cupon values (10, 24999);

insert into usuario_cupones values (1, 5, 1);
insert into usuario_cupones values (2, 7, 3);
insert into usuario_cupones values (3, 6, 5);
insert into usuario_cupones values (4, 9, 4);
insert into usuario_cupones values (5, 10, 2);

insert into producto values (11, 1, "Sirve para escribir", "SIN_REVISAR", '31-05-2022', '31-06-2022', "lapiz", 15000, 17, 1);
insert into producto values (12, 3, "Se utiliza en la construccion", "AUTORIZADOS", '29-05-2022', '29-06-2022', "ladrillos", 1700, 1, 3);
insert into producto values (13, 5, "Utiles para el mal aliento", "SIN_REVISAR", '27-05-2022', '27-06-2022', "mentas", 100, 100, 5);
insert into producto values (14, 4, "Para mejorar bebidas", "NO_AUTORIZADOS", '10-05-2022', '10-06-2022', "azucar", 17000, 30, 4);
insert into producto values (15, 2, "Vienen de un pato", "AUTORIZADOS", '15-05-2022', '15-06-2022', "plumas", 5000, 25, 2);

insert into moderador values (16, "contraseña123", "juana@gmail.com", "juana");
insert into moderador values (17, "contraseña321", "antonia@gmail.com", "antonia");
insert into moderador values (18, "contraseña213", "andres@gmail.com", "andres");
insert into moderador values (19, "contraseña456", "benito@gmail.com", "benito");
insert into moderador values (20, "contraseña785", "julian@gmail.com", "julian");

insert into producto_moderado values (21, '02-06-2022', "Descripcion no valida", 16, 11);
insert into producto_moderado values (22, '31-05-2022', "Descripcion no valida", 17, 12);
insert into producto_moderado values (23, '17-06-2022', "Nombre no valido", 18, 13);
insert into producto_moderado values (24, '08-06-2022', "Producto no valido", 19, 14);
insert into producto_moderado values (25, '07-05-2022', "Nombre no valido", 20, 15);

insert into producto_moderado_estados values (21, 1);
insert into producto_moderado_estados values (22, 2);
insert into producto_moderado_estados values (23, 3);
insert into producto_moderado_estados values (24, 2);
insert into producto_moderado_estados values (25, 3);

insert into producto_categoria_list values (11, 1);
insert into producto_categoria_list values (12, 2);
insert into producto_categoria_list values (13, 3);
insert into producto_categoria_list values (14, 4);
insert into producto_categoria_list values (15, 5);

insert into imagen values (26, "C:\imagen\lapiz.jpg", 11);
insert into imagen values (27, "C:\imagen\ladrillo.jpg", 12);
insert into imagen values (28, "C:\imagen\mentas.jpg", 13);
insert into imagen values (29, "C:\imagen\azucar.jpg", 14);
insert into imagen values (30, "C:\imagen\plumas.jpg", 15);

insert into favotiros_productos values (31, 11, 1);
insert into favotiros_productos values (32, 12, 2);
insert into favotiros_productos values (33, 13, 3);
insert into favotiros_productos values (34, 14, 4);
insert into favotiros_productos values (35, 15, 5);

insert into compra values (36, '18-06-2022', "EFECTY", 18000, 1);
insert into compra values (37, '19-06-2022', "PSE", 20000, 2);
insert into compra values (38, '20-06-2022', "TARJETA_CREDITO", 8000, 3);
insert into compra values (39, '31-06-2022', "TARJETA_DEBITO", 100, 4);
insert into compra values (40, '27-06-2022', "PSE", 3000, 5);

insert into detalle_compra values (41, 17000, 10, 36, 11);
insert into detalle_compra values (42, 19000, 3, 37, 12);
insert into detalle_compra values (43, 7000, 7, 38, 14);
insert into detalle_compra values (44, 90, 1, 39, 13);
insert into detalle_compra values (45, 2000, 6, 40, 15);

insert into comentario values (46, '14-07-2022', "Mala calidad de producto", 11, 2);
insert into comentario values (47, '16-07-2022', "Excelente", 12, 1);
insert into comentario values (48, '18-07-2022', "Pesimo trato del vendedor", 13, 4);
insert into comentario values (49, '13-07-2022', "Hola", 14, 5);
insert into comentario values (50, '11-07-2022', "Cumple con lo que dice", 15, 3);

insert into calificacion values (51, 5, 11, 2);
insert into calificacion values (52, 1, 12, 1);
insert into calificacion values (53, 2, 13, 4);
insert into calificacion values (54, 3, 14, 5);
insert into calificacion values (55, 4, 15, 3);