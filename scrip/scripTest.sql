DROP DATABASE tests;
CREATE DATABASE IF NOT EXISTS tests COLLATE utf8_general_ci;

USE tests;
GRANT ALL PRIVILEGES ON tests.* TO 'tests'@'localhost' IDENTIFIED BY 'tests';

CREATE TABLE IF NOT EXISTS categoria(

    id INT AUTO_INCREMENT UNIQUE,
    codigo VARCHAR(2) PRIMARY KEY,
	nombre VARCHAR(50),
	ultima_mod TIMESTAMP DEFAULT CURRENT_TIMESTAMP 
	ON UPDATE CURRENT_TIMESTAMP
    );
	
CREATE TABLE IF NOT EXISTS test(

    id INT AUTO_INCREMENT UNIQUE,
    codigo VARCHAR(10) PRIMARY KEY,
	tipo VARCHAR(50),
	ultima_mod TIMESTAMP DEFAULT CURRENT_TIMESTAMP 
	ON UPDATE CURRENT_TIMESTAMP
    );
CREATE TABLE IF NOT EXISTS url(

    id INT PRIMARY KEY AUTO_INCREMENT,
	codigo_categoria VARCHAR(2),
	codigo_test VARCHAR(10),
    sub_categoria VARCHAR(100),
	url VARCHAR(300),
	ultima_mod TIMESTAMP DEFAULT CURRENT_TIMESTAMP 
	ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT FK_rel_url_categoria FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo),
    CONSTRAINT FK_rel_url_test FOREIGN KEY (codigo_test) REFERENCES test(codigo)
	);
	
	CREATE TABLE IF NOT EXISTS pregunta(

    id INT PRIMARY KEY AUTO_INCREMENT,
	codigo_test VARCHAR(10),
    texto VARCHAR(400),
	numero INT,
	ultima_mod TIMESTAMP DEFAULT CURRENT_TIMESTAMP 
	ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT FK_rel_pregunta_test FOREIGN KEY (codigo_test) REFERENCES test(codigo)
	);

	CREATE TABLE IF NOT EXISTS opcion(

    id INT PRIMARY KEY AUTO_INCREMENT,
	codigo_categoria VARCHAR(2),
	id_pregunta INT,
    texto VARCHAR(400),
	ultima_mod TIMESTAMP DEFAULT CURRENT_TIMESTAMP 
	ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT FK_rel_opcion_categoria FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo),
	CONSTRAINT FK_rel_opcion_pregunta FOREIGN KEY (id_pregunta) REFERENCES pregunta(id)
	);
	

	
ALTER TABLE url
DROP FOREIGN KEY FK_rel_url_categoria;
ALTER TABLE url
DROP FOREIGN KEY FK_rel_url_test;

ALTER TABLE pregunta
DROP FOREIGN KEY FK_rel_pregunta_test;

ALTER TABLE opcion
DROP FOREIGN KEY FK_rel_opcion_categoria;
ALTER TABLE opcion
DROP FOREIGN KEY FK_rel_opcion_pregunta;

TRUNCATE TABLE categoria;
TRUNCATE TABLE test;
TRUNCATE TABLE url;
TRUNCATE TABLE pregunta;
TRUNCATE TABLE opcion;

ALTER TABLE url
ADD CONSTRAINT FK_rel_url_categoria 
FOREIGN KEY (codigo_categoria) 
REFERENCES categoria(codigo);

ALTER TABLE url
ADD CONSTRAINT FK_rel_url_test 
FOREIGN KEY (codigo_test) 
REFERENCES test(codigo);

ALTER TABLE pregunta
ADD CONSTRAINT FK_rel_pregunta_test
FOREIGN KEY (codigo_test) 
REFERENCES test(codigo);

ALTER TABLE opcion
ADD CONSTRAINT FK_rel_opcion_categoria
FOREIGN KEY (codigo_categoria) 
REFERENCES categoria(codigo);

ALTER TABLE opcion
ADD CONSTRAINT FK_rel_opcion_pregunta
FOREIGN KEY (id_pregunta) 
REFERENCES pregunta(id);


INSERT INTO categoria VALUES 
	(null, 'G', 'Gestión',null),
	(null, 'M', 'Marketing',null),
	(null, 'D', 'Diseño',null),
	(null, 'H', 'Hosteleria y turismo',null),
	(null, 'In', 'Informática',null),
	(null, 'T', 'Tecnología',null),
	(null, 'S', 'Sociosanitaria',null),
	(null, 'IP', 'Imagen personal',null)
	;
	

	
INSERT INTO test VALUES 
	(null, 'a10', 'aula 10',null),
	(null, 'CL', 'escuela de negocio',null)
	;
	
	
INSERT INTO url VALUES 
	(null,  'G','a10','C.Seguridad y Medioambiente', 'http://aula10formacion.com/cursos-de/certificados-de-profesionalidad/certificados-de-seguridad-y-medioambiente/',null);
	
	
INSERT INTO pregunta VALUES 
	(null,'a10','Pregunta numero 1', 1,null)
	;	
	
INSERT INTO opcion VALUES 
	(null,'M', 1,'Marketing',null)
	;



