DROP DATABASE IF EXISTS escola;
CREATE DATABASE escola
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

USE escola;

-- ============================
-- TABELA ALUNO
-- ============================

CREATE TABLE aluno (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    data_nascimento DATE NOT NULL
);

INSERT INTO aluno (nome, email, data_nascimento) VALUES
('João Silva', 'joao.silva@email.com', '2000-03-15'),
('Maria Oliveira', 'maria.oliveira@email.com', '1999-07-22'),
('Pedro Santos', 'pedro.santos@email.com', '2001-01-10'),
('Ana Souza', 'ana.souza@email.com', '2002-12-05'),
('Lucas Pereira', 'lucas.pereira@email.com', '1998-09-18'),
('Carla Lima', 'carla.lima@email.com', '2000-06-30'),
('Rafael Costa', 'rafael.costa@email.com', '1997-11-11'),
('Fernanda Rocha', 'fernanda.rocha@email.com', '2001-04-25'),
('Bruno Almeida', 'bruno.almeida@email.com', '1999-08-08'),
('Juliana Martins', 'juliana.martins@email.com', '2003-02-14');

-- ============================
-- TABELA DEPARTAMENTO
-- ============================

CREATE TABLE departamento (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

INSERT INTO departamento (nome) VALUES
('Recursos Humanos'),
('Financeiro'),
('Tecnologia da Informação'),
('Comercial'),
('Marketing');

-- ============================
-- TABELA FUNCIONARIO
-- ============================

CREATE TABLE funcionario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    salario DECIMAL(10,2) NOT NULL,
    id_departamento INT NOT NULL,

    CONSTRAINT fk_funcionario_departamento
        FOREIGN KEY (id_departamento)
        REFERENCES departamento(id)
);

INSERT INTO funcionario (nome, salario, id_departamento) VALUES
('João', 2500.00, 3),
('Maria', 4200.00, 2),
('Pedro', 3500.00, 3),
('Ana', 2800.00, 1),
('Lucas', 5000.00, 4),
('Carla', 3900.00, 5);

-- ============================
-- TABELA PRODUTO
-- ============================

CREATE TABLE produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL(10,2) NOT NULL
);

INSERT INTO produto (nome, preco) VALUES
('Notebook', 4500.00),
('Mouse', 80.00),
('Teclado', 150.00),
('Monitor', 1200.00),
('Headset', 250.00);

-- ============================
-- TABELA PEDIDO
-- ============================

CREATE TABLE pedido (
    id INT AUTO_INCREMENT PRIMARY KEY,
    data_pedido DATE NOT NULL,
    valor_total DECIMAL(10,2) NOT NULL
);

INSERT INTO pedido (data_pedido, valor_total) VALUES
('2026-07-31', 4730.00),
('2026-08-01', 1450.00);

-- ============================
-- TABELA PRODUTO_PEDIDO
-- ============================

CREATE TABLE produto_pedido (
    id_pedido INT NOT NULL,
    id_produto INT NOT NULL,
    quantidade INT NOT NULL,

    PRIMARY KEY (id_pedido, id_produto),

    CONSTRAINT fk_produto_pedido_pedido
        FOREIGN KEY (id_pedido)
        REFERENCES pedido(id),

    CONSTRAINT fk_produto_pedido_produto
        FOREIGN KEY (id_produto)
        REFERENCES produto(id)
);

INSERT INTO produto_pedido (id_pedido, id_produto, quantidade) VALUES
(1, 1, 1),
(1, 2, 1),
(1, 3, 1),
(2, 4, 1),
(2, 5, 1);

-- ============================
-- CONSULTAS
-- ============================

SELECT * FROM aluno;

SELECT * FROM departamento;

SELECT * FROM funcionario;

SELECT * FROM produto;

SELECT * FROM pedido;

SELECT * FROM produto_pedido;