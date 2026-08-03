-------------------------------------------------------------------
-- Exercício 01
-------------------------------------------------------------------

DROP DATABASE IF EXISTS ex01;
CREATE DATABASE ex01;
USE ex01;

CREATE TABLE funcionario (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50),
    email VARCHAR(50),
    cpf CHAR(11),
    salario DECIMAL(10,2),
    PRIMARY KEY (id)
);

-------------------------------------------------------------------
-- Exercício 02
-------------------------------------------------------------------

DROP DATABASE IF EXISTS ex02;
CREATE DATABASE ex02;
USE ex02;

-- cor
CREATE TABLE cor (
    id INT NOT NULL AUTO_INCREMENT,
    nome_cor VARCHAR(50),
    PRIMARY KEY (id)
);

-- modelo
CREATE TABLE modelo (
    id INT NOT NULL AUTO_INCREMENT,
    nome_modelo VARCHAR(50),
    PRIMARY KEY (id)
);

-- marca
CREATE TABLE marca (
    id INT NOT NULL AUTO_INCREMENT,
    nome_marca VARCHAR(50),
    PRIMARY KEY (id)
);

-- combustivel
CREATE TABLE combustivel (
    id INT NOT NULL AUTO_INCREMENT,
    nome_combustivel VARCHAR(50),
    PRIMARY KEY (id)
);

-- proprietario
CREATE TABLE proprietario (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50),
    telefone VARCHAR(11),
    email VARCHAR(50),
    PRIMARY KEY (id)
);

-- veiculo
CREATE TABLE veiculo (
    id INT NOT NULL AUTO_INCREMENT,
    ano_fabricacao INT,
    ano_modelo INT,
    quilometragem INT,
    portas INT,
    cor_id INT,
    modelo_id INT,
    marca_id INT,
    proprietario_id INT,
    PRIMARY KEY (id),

    CONSTRAINT fk_veiculo_cor
        FOREIGN KEY (cor_id)
        REFERENCES cor(id),

    CONSTRAINT fk_veiculo_modelo
        FOREIGN KEY (modelo_id)
        REFERENCES modelo(id),

    CONSTRAINT fk_veiculo_marca
        FOREIGN KEY (marca_id)
        REFERENCES marca(id),

    CONSTRAINT fk_veiculo_proprietario
        FOREIGN KEY (proprietario_id)
        REFERENCES proprietario(id)
);

-- veiculo_combustivel
CREATE TABLE veiculo_combustivel (
    veiculo_id INT,
    combustivel_id INT,

    PRIMARY KEY (veiculo_id, combustivel_id),

    CONSTRAINT fk_veiculo_combustivel_veiculo
        FOREIGN KEY (veiculo_id)
        REFERENCES veiculo(id),

    CONSTRAINT fk_veiculo_combustivel_combustivel
        FOREIGN KEY (combustivel_id)
        REFERENCES combustivel(id)
);

-------------------------------------------------------------------
-- Exercício 03
-------------------------------------------------------------------

DROP DATABASE IF EXISTS ex03;
CREATE DATABASE ex03;
USE ex03;

-- cor
CREATE TABLE cor (
    id INT,
    nome_cor VARCHAR(50)
);

ALTER TABLE cor
    ADD PRIMARY KEY (id);

ALTER TABLE cor
    MODIFY id INT NOT NULL AUTO_INCREMENT;

-- modelo
CREATE TABLE modelo (
    id INT,
    nome_modelo VARCHAR(50)
);

ALTER TABLE modelo
    ADD PRIMARY KEY (id);

ALTER TABLE modelo
    MODIFY id INT NOT NULL AUTO_INCREMENT;

-- marca
CREATE TABLE marca (
    id INT,
    nome_marca VARCHAR(50)
);

ALTER TABLE marca
    ADD PRIMARY KEY (id);

ALTER TABLE marca
    MODIFY id INT NOT NULL AUTO_INCREMENT;

-- combustivel
CREATE TABLE combustivel (
    id INT,
    nome_combustivel VARCHAR(50)
);

ALTER TABLE combustivel
    ADD PRIMARY KEY (id);

ALTER TABLE combustivel
    MODIFY id INT NOT NULL AUTO_INCREMENT;

-- proprietario
CREATE TABLE proprietario (
    id INT,
    nome VARCHAR(50),
    telefone VARCHAR(11),
    email VARCHAR(50)
);

ALTER TABLE proprietario
    ADD PRIMARY KEY (id);

ALTER TABLE proprietario
    MODIFY id INT NOT NULL AUTO_INCREMENT;

-- veiculo
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

ALTER TABLE veiculo
    ADD PRIMARY KEY (id);

ALTER TABLE veiculo
    MODIFY id INT NOT NULL AUTO_INCREMENT;

-- veiculo_combustivel
CREATE TABLE veiculo_combustivel (
    veiculo_id INT,
    combustivel_id INT
);

ALTER TABLE veiculo_combustivel
    ADD PRIMARY KEY (veiculo_id, combustivel_id);

-- Foreign Keys da tabela veiculo

ALTER TABLE veiculo
    ADD CONSTRAINT fk_veiculo_cor
    FOREIGN KEY (cor_id)
    REFERENCES cor(id);

ALTER TABLE veiculo
    ADD CONSTRAINT fk_veiculo_modelo
    FOREIGN KEY (modelo_id)
    REFERENCES modelo(id);

ALTER TABLE veiculo
    ADD CONSTRAINT fk_veiculo_marca
    FOREIGN KEY (marca_id)
    REFERENCES marca(id);

ALTER TABLE veiculo
    ADD CONSTRAINT fk_veiculo_proprietario
    FOREIGN KEY (proprietario_id)
    REFERENCES proprietario(id);

-- Foreign Keys da tabela veiculo_combustivel

ALTER TABLE veiculo_combustivel
    ADD CONSTRAINT fk_veiculo_combustivel_veiculo
    FOREIGN KEY (veiculo_id)
    REFERENCES veiculo(id);

ALTER TABLE veiculo_combustivel
    ADD CONSTRAINT fk_veiculo_combustivel_combustivel
    FOREIGN KEY (combustivel_id)
    REFERENCES combustivel(id);

-------------------------------------------------------------------
-- Exercício 04
-------------------------------------------------------------------

DROP DATABASE IF EXISTS ex04;
CREATE DATABASE ex04;
USE ex04;

CREATE TABLE cliente (
    id INT,
    nome VARCHAR(50),
    email VARCHAR(50),
    cpf CHAR(11),
    PRIMARY KEY (id)
);

CREATE TABLE pedido (
    id INT,
    data_pedido DATE,
    valor_total DECIMAL(10,2),
    id_cliente INT,

    PRIMARY KEY (id),

    CONSTRAINT fk_pedido_cliente
        FOREIGN KEY (id_cliente)
        REFERENCES cliente(id)
);