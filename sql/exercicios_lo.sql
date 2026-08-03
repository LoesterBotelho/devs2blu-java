-------------------------------------------------------------------

--- Exercício 01

CREATE DATABASE ex01;
USE ex01; 

CREATE TABLE funcionario (
id INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(50),
email VARCHAR(50),
cpf CHAR(11),
salario DECIMAL(10,2)
);

INSERT INTO funcionario (nome,email,cpf,salario)
VALUE ('teste1','teste1@teste.com','12345678911',10000.55);

INSERT INTO funcionario (nome,email,cpf,salario)
VALUE ('teste2','teste2@teste.com','12345678911',10000.55);

INSERT INTO funcionario (nome,email,cpf,salario)
VALUE ('teste3','teste3@teste.com','12345678911',123.55);

SELECT * FROM funcionario;

UPDATE funcionario SET
	nome = 'Maria Ana Clara',
	email = 'maria.ana@gmail.com'
WHERE id = 1;

UPDATE funcionario SET
	nome = 'Leticia Jessica Lorena',
	email = 'Leticia.jersey@gmail.com'
WHERE id = 2;

SELECT * FROM funcionario;

DELETE FROM funcionario WHERE id = 3;

SELECT * FROM funcionario;


-------------------------------------------------------------------

--- Exercício 02

CREATE DATABASE ex02;
USE ex02; 

--- cor
CREATE TABLE cor (
id INT AUTO_INCREMENT PRIMARY KEY,
nome_cor VARCHAR(50)
);

INSERT INTO cor (nome_cor)
VALUE ('BRANCO');

INSERT INTO cor (nome_cor)
VALUE ('PRETO');

INSERT INTO cor (nome_cor)
VALUE ('VERMELHO');

SELECT * FROM cor;

--- modelo

---DROP TABLE modelo;


--- marca
CREATE TABLE marca (
id INT AUTO_INCREMENT PRIMARY KEY,
nome_marca VARCHAR(50)
);

INSERT INTO marca (nome_marca)
VALUE ('Toyota');

INSERT INTO marca (nome_marca)
VALUE ('Honda');

INSERT INTO marca (nome_marca)
VALUE ('Volkswagen');

SELECT * FROM marca;


CREATE TABLE modelo (
id INT AUTO_INCREMENT PRIMARY KEY,
nome_modelo VARCHAR(50),
marca_id INT,
CONSTRAINT fk_modelo_marca FOREIGN KEY (marca_id) REFERENCES marca(id)
);

INSERT INTO modelo (nome_modelo, marca_id)
VALUE ('Corolla',1);

INSERT INTO modelo (nome_modelo, marca_id)
VALUE ('Civic',2);

INSERT INTO modelo (nome_modelo, marca_id)
VALUE ('Golf',3);

SELECT * FROM modelo;

/*
Toyota Corolla

Marca: Toyota
Modelo: Corolla

Honda Civic

Marca: Honda
Modelo: Civic

Volkswagen Golf

Marca: Volkswagen
Modelo: Golf

*/




--- combustivel
CREATE TABLE combustivel (
id INT AUTO_INCREMENT PRIMARY KEY,
nome_combustivel VARCHAR(50)
);

INSERT INTO combustivel (nome_combustivel)
VALUE ('Gasolina');

INSERT INTO combustivel (nome_combustivel)
VALUE ('Disel');

INSERT INTO combustivel (nome_combustivel)
VALUE ('Energia');

INSERT INTO combustivel (nome_combustivel)
VALUE ('Hidrogenio');

SELECT * FROM combustivel;

--- proprietario
CREATE TABLE proprietario (
id INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(50),
telefone VARCHAR(11),
email VARCHAR(50),
data_nascimento DATE
);

INSERT INTO proprietario (nome,telefone,email,data_nascimento)
VALUE ('Teste01', '4791231234', 'teste01@gmail.com','1979-8-4');

INSERT INTO proprietario (nome,telefone,email,data_nascimento)
VALUE ('Teste02', '4793245234', 'teste01@gmail.com','1979-8-4');


SELECT * FROM proprietario;



--- veiculo
CREATE TABLE veiculo (
id INT AUTO_INCREMENT PRIMARY KEY,
ano_fabricacao INT,
ano_modelo INT,
quilometragem INT,
portas INT,
cor_id INT,
modelo_id INT,
proprietario_id INT,
CONSTRAINT fk_veiculo_cor FOREIGN KEY (cor_id) REFERENCES cor(id) ,
CONSTRAINT fk_veiculo_modelo FOREIGN KEY (modelo_id) REFERENCES modelo(id) ,
CONSTRAINT fk_veiculo_proprietario FOREIGN KEY (proprietario_id) REFERENCES proprietario(id) 
);

INSERT INTO veiculo (
ano_fabricacao,
ano_modelo,
quilometragem,
portas,
cor_id,
modelo_id,
proprietario_id)
VALUE (2026,2025,0,4,1,1);

INSERT INTO veiculo (
ano_fabricacao,
ano_modelo,
quilometragem,
portas,
cor_id,
modelo_id,
proprietario_id)
VALUE (2026,2025,0,4,2,2,2);

INSERT INTO veiculo (
ano_fabricacao,
ano_modelo,
quilometragem,
portas,
cor_id,
modelo_id,
proprietario_id)
VALUE (2026,2025,0,4,3,3,2);

SELECT * FROM veiculo;



--- veiculo_combustivel
CREATE TABLE veiculo_combustivel (
veiculo_id INT,
combustivel_id INT,
PRIMARY KEY (veiculo_id, combustivel_id),
CONSTRAINT fk_veiculo_combustivel_veiculo FOREIGN KEY (veiculo_id) REFERENCES veiculo(id) ,
CONSTRAINT fk_veiculo_combustivel_combustivel FOREIGN KEY (combustivel_id) REFERENCES combustivel(id)  
);

INSERT INTO veiculo_combustivel (veiculo_id,combustivel_id)
VALUE (1,1);

INSERT INTO veiculo_combustivel (veiculo_id,combustivel_id)
VALUE (2,1);

INSERT INTO veiculo_combustivel (veiculo_id,combustivel_id)
VALUE (3,1);

SELECT * FROM veiculo_combustivel;



SELECT
    v.id AS id_veiculo,
    v.ano_fabricacao,
    v.ano_modelo,
    v.quilometragem,
    v.portas,
    c.nome_cor,
    mo.nome_modelo,
    ma.nome_marca,
    p.nome AS proprietario,
    p.telefone,
    p.email,
    p.data_nascimento,
    co.nome_combustivel
FROM veiculo v
INNER JOIN cor c ON c.id = v.cor_id
INNER JOIN modelo mo ON mo.id = v.modelo_id
INNER JOIN marca ma ON ma.id = mo.marca_id
INNER JOIN proprietario p ON p.id = v.proprietario_id
INNER JOIN veiculo_combustivel vc ON vc.veiculo_id = v.id
INNER JOIN combustivel co ON co.id = vc.combustivel_id;

	
	
-------------------------------------------------------------------

--- Exercício 02

-------------------------------------------------------------------
	
--- Após inserir linhas nas tabelas do exercício 2:
--- a) Atualize o número de telefone do proprietário com código 1 para 47123456789

UPDATE proprietario SET
 telefone = '47123456789'
WHERE id = 1;

---b) Exclua todos os veículos com mais de 200 mil quilômetros rodados produzidos antes de 2010
DELETE FROM veiculo v WHERE v.ano_fabricacao < 2010 and v.quilometragem > 200000;

--- c) Exclua a marca de id 1
DELETE FROM marca m WHERE m.id = 1;	
	
-------------------------------------------------------------------

--- Exercício 03

-------------------------------------------------------------------

CREATE DATABASE ex03;
USE ex03; 

--- cor
CREATE TABLE cor (
id INT,
nome_cor VARCHAR(50)
);
ALTER TABLE cor ADD PRIMARY KEY (id);
ALTER TABLE cor MODIFY id INT AUTO_INCREMENT;

--- modelo
CREATE TABLE modelo (
id INT,
nome_modelo VARCHAR(50)
);
ALTER TABLE modelo ADD PRIMARY KEY (id);
ALTER TABLE modelo MODIFY id INT AUTO_INCREMENT;

--- marca
CREATE TABLE marca (
id INT,
nome_marca VARCHAR(50)
);
ALTER TABLE marca ADD PRIMARY KEY (id);
ALTER TABLE marca MODIFY id INT AUTO_INCREMENT;

--- combustivel
CREATE TABLE combustivel (
id INT,
nome_combustivel VARCHAR(50)
);
ALTER TABLE combustivel ADD PRIMARY KEY (id);
ALTER TABLE combustivel MODIFY id INT AUTO_INCREMENT;

--- proprietario
CREATE TABLE proprietario (
id INT,
nome VARCHAR(50),
telefone VARCHAR(11),
email VARCHAR(50)
);
ALTER TABLE proprietario ADD PRIMARY KEY (id);
ALTER TABLE proprietario MODIFY id INT AUTO_INCREMENT;

--- veiculo
CREATE TABLE veiculo (
id INT,
ano_fabricacao INT,
ano_modelo INT,
quilometragem INT,
portas INT,
cor_id INT,
modelo_id INT,
marca_id INT,
proprietario_id INT
);
ALTER TABLE veiculo ADD PRIMARY KEY (id);
ALTER TABLE veiculo MODIFY id INT AUTO_INCREMENT;

--- veiculo_combustivel
CREATE TABLE veiculo_combustivel (
veiculo_id INT,
combustivel_id INT
);
ALTER TABLE veiculo_combustivel ADD PRIMARY KEY (veiculo_id, combustivel_id);

--- FK VEICULO

ALTER TABLE veiculo ADD CONSTRAINT fk_veiculo_cor FOREIGN KEY (cor_id) REFERENCES cor(id);
ALTER TABLE veiculo ADD CONSTRAINT fk_veiculo_modelo FOREIGN KEY (modelo_id) REFERENCES modelo(id);
ALTER TABLE veiculo ADD CONSTRAINT fk_veiculo_marca FOREIGN KEY (marca_id) REFERENCES marca(id);
ALTER TABLE veiculo ADD CONSTRAINT fk_veiculo_proprietario FOREIGN KEY (proprietario_id) REFERENCES proprietario(id);

--- FK VEICULO_COMBUSTIVEL

ALTER TABLE veiculo_combustivel ADD CONSTRAINT fk_veiculo_combustivel_veiculo FOREIGN KEY (veiculo_id) REFERENCES veiculo(id);
ALTER TABLE veiculo_combustivel ADD CONSTRAINT fk_veiculo_combustivel_combustivel FOREIGN KEY (combustivel_id) REFERENCES combustivel(id);
