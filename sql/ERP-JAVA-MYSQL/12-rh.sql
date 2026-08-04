-- =====================================================
-- ERP JAVA MYSQL
-- Arquivo: 12-rh.sql
-- Módulo Recursos Humanos
-- =====================================================

USE erp_java;


-- =====================================================
-- DEPARTAMENTO
-- =====================================================

CREATE TABLE departamento (

    id INT AUTO_INCREMENT PRIMARY KEY,


    nome VARCHAR(100) NOT NULL,


    descricao TEXT,


    ativo BOOLEAN DEFAULT TRUE,


    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,


    CONSTRAINT uq_departamento_nome
        UNIQUE(nome)

) ENGINE=InnoDB;



-- =====================================================
-- CARGO
-- =====================================================

CREATE TABLE cargo (

    id INT AUTO_INCREMENT PRIMARY KEY,


    nome VARCHAR(100) NOT NULL,


    descricao TEXT,


    nivel VARCHAR(50),


    salario_base DECIMAL(12,2),


    ativo BOOLEAN DEFAULT TRUE,


    CONSTRAINT uq_cargo_nome
        UNIQUE(nome)

) ENGINE=InnoDB;



-- =====================================================
-- FUNCIONARIO RH
-- Complemento do funcionário
-- =====================================================

CREATE TABLE funcionario_rh (

    funcionario_id INT PRIMARY KEY,


    departamento_id INT,


    cargo_id INT,


    data_admissao DATE,


    data_demissao DATE,


    tipo_contrato ENUM(
        'CLT',
        'PJ',
        'ESTAGIO',
        'TEMPORARIO'
    ),


    status ENUM(
        'ATIVO',
        'AFASTADO',
        'DEMITIDO'
    ) DEFAULT 'ATIVO',



    CONSTRAINT fk_funcionario_rh_funcionario
        FOREIGN KEY(funcionario_id)
        REFERENCES funcionario(id),


    CONSTRAINT fk_funcionario_rh_departamento
        FOREIGN KEY(departamento_id)
        REFERENCES departamento(id),


    CONSTRAINT fk_funcionario_rh_cargo
        FOREIGN KEY(cargo_id)
        REFERENCES cargo(id)

) ENGINE=InnoDB;



-- =====================================================
-- HISTORICO SALARIO
-- =====================================================

CREATE TABLE historico_salario (

    id INT AUTO_INCREMENT PRIMARY KEY,


    funcionario_id INT NOT NULL,


    salario_anterior DECIMAL(12,2),


    salario_novo DECIMAL(12,2),


    data_alteracao DATE,


    motivo VARCHAR(255),



    CONSTRAINT fk_historico_salario_funcionario
        FOREIGN KEY(funcionario_id)
        REFERENCES funcionario(id)

) ENGINE=InnoDB;



-- =====================================================
-- SALARIO ATUAL
-- =====================================================

CREATE TABLE salario (

    id INT AUTO_INCREMENT PRIMARY KEY,


    funcionario_id INT NOT NULL,


    valor DECIMAL(12,2),


    data_inicio DATE,


    data_fim DATE,


    ativo BOOLEAN DEFAULT TRUE,



    CONSTRAINT fk_salario_funcionario
        FOREIGN KEY(funcionario_id)
        REFERENCES funcionario(id)

) ENGINE=InnoDB;



-- =====================================================
-- FOLHA PAGAMENTO
-- =====================================================

CREATE TABLE folha_pagamento (

    id INT AUTO_INCREMENT PRIMARY KEY,


    funcionario_id INT NOT NULL,


    competencia VARCHAR(7),


    salario_bruto DECIMAL(12,2),


    desconto_inss DECIMAL(12,2),


    desconto_irrf DECIMAL(12,2),


    outros_descontos DECIMAL(12,2),


    salario_liquido DECIMAL(12,2),


    data_pagamento DATE,


    status ENUM(
        'ABERTA',
        'CALCULADA',
        'PAGA'
    ) DEFAULT 'ABERTA',



    CONSTRAINT fk_folha_funcionario
        FOREIGN KEY(funcionario_id)
        REFERENCES funcionario(id)

) ENGINE=InnoDB;



-- =====================================================
-- BENEFICIO
-- =====================================================

CREATE TABLE beneficio (

    id INT AUTO_INCREMENT PRIMARY KEY,


    nome VARCHAR(100) NOT NULL,


    valor DECIMAL(12,2),


    descricao TEXT,


    ativo BOOLEAN DEFAULT TRUE,


    CONSTRAINT uq_beneficio_nome
        UNIQUE(nome)

) ENGINE=InnoDB;



-- =====================================================
-- FUNCIONARIO BENEFICIO
-- =====================================================

CREATE TABLE funcionario_beneficio (

    funcionario_id INT NOT NULL,


    beneficio_id INT NOT NULL,


    data_inicio DATE,


    data_fim DATE,


    ativo BOOLEAN DEFAULT TRUE,


    PRIMARY KEY(
        funcionario_id,
        beneficio_id
    ),



    CONSTRAINT fk_funcionario_beneficio_funcionario
        FOREIGN KEY(funcionario_id)
        REFERENCES funcionario(id),


    CONSTRAINT fk_funcionario_beneficio_beneficio
        FOREIGN KEY(beneficio_id)
        REFERENCES beneficio(id)

) ENGINE=InnoDB;



-- =====================================================
-- PONTO
-- =====================================================

CREATE TABLE ponto (

    id INT AUTO_INCREMENT PRIMARY KEY,


    funcionario_id INT NOT NULL,


    data DATE,


    entrada TIME,


    saida_almoco TIME,


    retorno_almoco TIME,


    saida TIME,


    horas_trabalhadas DECIMAL(5,2),


    observacao TEXT,



    CONSTRAINT fk_ponto_funcionario
        FOREIGN KEY(funcionario_id)
        REFERENCES funcionario(id)

) ENGINE=InnoDB;



-- =====================================================
-- FERIAS
-- =====================================================

CREATE TABLE ferias (

    id INT AUTO_INCREMENT PRIMARY KEY,


    funcionario_id INT NOT NULL,


    data_inicio DATE,


    data_fim DATE,


    quantidade_dias INT,


    status ENUM(
        'SOLICITADA',
        'APROVADA',
        'FINALIZADA'
    ),


    observacao TEXT,



    CONSTRAINT fk_ferias_funcionario
        FOREIGN KEY(funcionario_id)
        REFERENCES funcionario(id)

) ENGINE=InnoDB;



-- =====================================================
-- AFASTAMENTO
-- =====================================================

CREATE TABLE afastamento (

    id INT AUTO_INCREMENT PRIMARY KEY,


    funcionario_id INT NOT NULL,


    motivo VARCHAR(255),


    data_inicio DATE,


    data_fim DATE,


    observacao TEXT,



    CONSTRAINT fk_afastamento_funcionario
        FOREIGN KEY(funcionario_id)
        REFERENCES funcionario(id)

) ENGINE=InnoDB;