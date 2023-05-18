drop database my_app; --aqui borramos la tabla 
create database my_app; -- aqui creamos la base de datos llamada my_app
use my_app;

drop table if exists users_tbl; -- eliminamos la tabla "users_tbl" claro esta, si existe

-- cremaos la tabla "users_tbl" con columnas "user_id", "user_first_name", "user_last_name", "user_email", "user_password" con sus valores respectivos.
create table users_tbl(
user_id INT auto_increment,
user_firstname VARCHAR(40) not null,
user_lastname VARCHAR(40) not null,
user_email VARCHAR(60) not null,
user_password varbinary(256),
PRIMARY KEY(user_id)
);

-- aqui actualizamos la tabla "users_tbl" y el campo "users_password" para pasarlo de varchar a varbinary de 255 caracteres
alter table users_tbl modify user_password varbinary(255);

-- insertamos dtos en la tabla, datos iniciales con la contraseña encrpitada y desencriptada y colocamos le texto "UPPER" para que todos los datos que ingrese el usuario sean en mayusculas
insert into my_app.users_tbl (user_firstname, user_lastname, user_email, user_password) VALUES 
(UPPER('nombres'), UPPER('apellidos'), 'ejemplo@correo.com', AES_ENCRYPT('Suspendisse eget nisi non urna tempor ultricies eu eu felis. Vestibulum cursus ac purus id rutrum. Nullam tellus elit, molestie vel arcu','2ad871f22a9a85099f8202a362afc2792e030b87'));

SELECT * ,CAST(AES_DECRYPT(user_password,'2ad871f22a9a85099f8202a362afc2792e030b87') AS CHAR(50)) end_data FROM users_tbl WHERE user_id = 1;

select* from users_tbl;