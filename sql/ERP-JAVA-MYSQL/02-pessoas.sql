-- =====================================================
-- ERP JAVA MYSQL
-- Arquivo: 02-pessoas.sql
-- Módulo Pessoas
-- =====================================================

USE erp_java;

-- =====================================================
-- PAIS
-- =====================================================

CREATE TABLE pais (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    sigla CHAR(2) NOT NULL,
    codigo_iso CHAR(3),

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    ativo BOOLEAN NOT NULL DEFAULT TRUE,

    CONSTRAINT uq_pais_nome UNIQUE (nome),
    CONSTRAINT uq_pais_sigla UNIQUE (sigla)
) ENGINE=InnoDB;

-- =====================================================
-- ESTADO
-- =====================================================

CREATE TABLE estado (
    id INT AUTO_INCREMENT PRIMARY KEY,

    pais_id INT NOT NULL,

    nome VARCHAR(100) NOT NULL,
    sigla CHAR(2) NOT NULL,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    ativo BOOLEAN NOT NULL DEFAULT TRUE,

    CONSTRAINT fk_estado_pais
        FOREIGN KEY (pais_id)
        REFERENCES pais(id),

    CONSTRAINT uq_estado
        UNIQUE (pais_id, sigla)
) ENGINE=InnoDB;

CREATE INDEX idx_estado_nome
ON estado(nome);

-- =====================================================
-- CIDADE
-- =====================================================

CREATE TABLE cidade (

    id INT AUTO_INCREMENT PRIMARY KEY,

    estado_id INT NOT NULL,

    nome VARCHAR(150) NOT NULL,

    ibge VARCHAR(10),

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    ativo BOOLEAN DEFAULT TRUE,

    CONSTRAINT fk_cidade_estado
        FOREIGN KEY (estado_id)
        REFERENCES estado(id)
) ENGINE=InnoDB;

CREATE INDEX idx_cidade_nome
ON cidade(nome);

-- =====================================================
-- ENDERECO
-- =====================================================

CREATE TABLE endereco (

    id INT AUTO_INCREMENT PRIMARY KEY,

    cidade_id INT NOT NULL,

    cep CHAR(8),

    logradouro VARCHAR(200) NOT NULL,

    numero VARCHAR(20),

    complemento VARCHAR(100),

    bairro VARCHAR(120),

    referencia VARCHAR(200),

    latitude DECIMAL(10,7),

    longitude DECIMAL(10,7),

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    ativo BOOLEAN DEFAULT TRUE,

    CONSTRAINT fk_endereco_cidade
        FOREIGN KEY (cidade_id)
        REFERENCES cidade(id)

) ENGINE=InnoDB;

CREATE INDEX idx_endereco_cep
ON endereco(cep);

-- =====================================================
-- PESSOA
-- =====================================================

CREATE TABLE pessoa (

    id INT AUTO_INCREMENT PRIMARY KEY,

    endereco_id INT,

    nome VARCHAR(150) NOT NULL,

    cpf CHAR(11),

    rg VARCHAR(20),

    sexo ENUM('M','F','O'),

    data_nascimento DATE,

    observacao TEXT,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    ativo BOOLEAN DEFAULT TRUE,

    CONSTRAINT fk_pessoa_endereco
        FOREIGN KEY (endereco_id)
        REFERENCES endereco(id),

    CONSTRAINT uq_pessoa_cpf
        UNIQUE(cpf)

) ENGINE=InnoDB;

CREATE INDEX idx_pessoa_nome
ON pessoa(nome);

-- =====================================================
-- EMAIL
-- =====================================================

CREATE TABLE email (

    id INT AUTO_INCREMENT PRIMARY KEY,

    pessoa_id INT NOT NULL,

    email VARCHAR(150) NOT NULL,

    principal BOOLEAN DEFAULT FALSE,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_email_pessoa
        FOREIGN KEY (pessoa_id)
        REFERENCES pessoa(id)
        ON DELETE CASCADE,

    CONSTRAINT uq_email
        UNIQUE(email)

) ENGINE=InnoDB;

-- =====================================================
-- TELEFONE
-- =====================================================

CREATE TABLE telefone (

    id INT AUTO_INCREMENT PRIMARY KEY,

    pessoa_id INT NOT NULL,

    tipo ENUM(
        'CELULAR',
        'RESIDENCIAL',
        'COMERCIAL',
        'WHATSAPP'
    ),

    ddd CHAR(2),

    numero VARCHAR(15),

    principal BOOLEAN DEFAULT FALSE,

    CONSTRAINT fk_telefone_pessoa
        FOREIGN KEY (pessoa_id)
        REFERENCES pessoa(id)
        ON DELETE CASCADE

) ENGINE=InnoDB;

-- =====================================================
-- CLIENTE
-- =====================================================

CREATE TABLE cliente (

    id INT AUTO_INCREMENT PRIMARY KEY,

    pessoa_id INT NOT NULL,

    data_cadastro DATE NOT NULL,

    limite_credito DECIMAL(12,2) DEFAULT 0,

    pontos_fidelidade INT DEFAULT 0,

    CONSTRAINT fk_cliente_pessoa
        FOREIGN KEY (pessoa_id)
        REFERENCES pessoa(id),

    CONSTRAINT uq_cliente_pessoa
        UNIQUE(pessoa_id)

) ENGINE=InnoDB;

-- =====================================================
-- CARGO
-- =====================================================

CREATE TABLE cargo (

    id INT AUTO_INCREMENT PRIMARY KEY,

    nome VARCHAR(100) NOT NULL,

    salario_base DECIMAL(12,2),

    descricao TEXT,

    CONSTRAINT uq_cargo_nome
        UNIQUE(nome)

) ENGINE=InnoDB;

-- =====================================================
-- DEPARTAMENTO
-- =====================================================

CREATE TABLE departamento (

    id INT AUTO_INCREMENT PRIMARY KEY,

    nome VARCHAR(100) NOT NULL,

    descricao TEXT,

    CONSTRAINT uq_departamento_nome
        UNIQUE(nome)

) ENGINE=InnoDB;

-- =====================================================
-- FUNCIONARIO
-- =====================================================

CREATE TABLE funcionario (

    id INT AUTO_INCREMENT PRIMARY KEY,

    pessoa_id INT NOT NULL,

    cargo_id INT NOT NULL,

    departamento_id INT NOT NULL,

    data_admissao DATE,

    salario DECIMAL(12,2),

    matricula VARCHAR(20),

    CONSTRAINT fk_funcionario_pessoa
        FOREIGN KEY (pessoa_id)
        REFERENCES pessoa(id),

    CONSTRAINT fk_funcionario_cargo
        FOREIGN KEY (cargo_id)
        REFERENCES cargo(id),

    CONSTRAINT fk_funcionario_departamento
        FOREIGN KEY (departamento_id)
        REFERENCES departamento(id),

    CONSTRAINT uq_funcionario_matricula
        UNIQUE(matricula)

) ENGINE=InnoDB;

-- =====================================================
-- FORNECEDOR
-- =====================================================

CREATE TABLE fornecedor (

    id INT AUTO_INCREMENT PRIMARY KEY,

    pessoa_id INT,

    cnpj CHAR(14),

    inscricao_estadual VARCHAR(30),

    razao_social VARCHAR(200),

    nome_fantasia VARCHAR(200),

    CONSTRAINT fk_fornecedor_pessoa
        FOREIGN KEY (pessoa_id)
        REFERENCES pessoa(id),

    CONSTRAINT uq_fornecedor_cnpj
        UNIQUE(cnpj)

) ENGINE=InnoDB;

-- =====================================================
-- VENDEDOR
-- =====================================================

CREATE TABLE vendedor (

    id INT AUTO_INCREMENT PRIMARY KEY,

    funcionario_id INT NOT NULL,

    percentual_comissao DECIMAL(5,2),

    meta_mensal DECIMAL(12,2),

    CONSTRAINT fk_vendedor_funcionario
        FOREIGN KEY (funcionario_id)
        REFERENCES funcionario(id),

    CONSTRAINT uq_vendedor_funcionario
        UNIQUE(funcionario_id)

) ENGINE=InnoDB;

-- =====================================================
-- CONTATO
-- =====================================================

CREATE TABLE contato (

    id INT AUTO_INCREMENT PRIMARY KEY,

    fornecedor_id INT NOT NULL,

    nome VARCHAR(150) NOT NULL,

    cargo VARCHAR(100),

    telefone VARCHAR(20),

    email VARCHAR(150),

    observacao TEXT,

    CONSTRAINT fk_contato_fornecedor
        FOREIGN KEY (fornecedor_id)
        REFERENCES fornecedor(id)
        ON DELETE CASCADE

) ENGINE=InnoDB;