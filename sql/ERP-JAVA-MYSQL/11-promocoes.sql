-- =====================================================
-- ERP JAVA MYSQL
-- Arquivo: 11-promocoes.sql
-- Módulo Promoções
-- =====================================================

USE erp_java;


-- =====================================================
-- CAMPANHA
-- =====================================================

CREATE TABLE campanha (

    id INT AUTO_INCREMENT PRIMARY KEY,


    nome VARCHAR(150) NOT NULL,


    descricao TEXT,


    data_inicio DATE NOT NULL,


    data_fim DATE NOT NULL,


    status ENUM(
        'PLANEJADA',
        'ATIVA',
        'ENCERRADA',
        'CANCELADA'
    ) DEFAULT 'PLANEJADA',


    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,


    ativo BOOLEAN DEFAULT TRUE,


    CONSTRAINT uq_campanha_nome
        UNIQUE(nome)

) ENGINE=InnoDB;



-- =====================================================
-- PROMOCAO
-- =====================================================

CREATE TABLE promocao (

    id INT AUTO_INCREMENT PRIMARY KEY,


    campanha_id INT,


    nome VARCHAR(150) NOT NULL,


    tipo ENUM(
        'PERCENTUAL',
        'VALOR_FIXO',
        'LEVE_PAGUE'
    ) NOT NULL,


    valor_desconto DECIMAL(12,2),


    percentual_desconto DECIMAL(5,2),


    quantidade_minima DECIMAL(12,3),


    data_inicio DATE,


    data_fim DATE,


    ativo BOOLEAN DEFAULT TRUE,



    CONSTRAINT fk_promocao_campanha
        FOREIGN KEY(campanha_id)
        REFERENCES campanha(id),


    CONSTRAINT uq_promocao_nome
        UNIQUE(nome)

) ENGINE=InnoDB;



-- =====================================================
-- PRODUTO PROMOCAO
-- Relacionamento N:N
-- =====================================================

CREATE TABLE produto_promocao (

    produto_id INT NOT NULL,


    promocao_id INT NOT NULL,


    preco_promocional DECIMAL(12,2),


    limite_quantidade DECIMAL(12,3),


    PRIMARY KEY(
        produto_id,
        promocao_id
    ),



    CONSTRAINT fk_produto_promocao_produto
        FOREIGN KEY(produto_id)
        REFERENCES produto(id)
        ON DELETE CASCADE,


    CONSTRAINT fk_produto_promocao_promocao
        FOREIGN KEY(promocao_id)
        REFERENCES promocao(id)
        ON DELETE CASCADE

) ENGINE=InnoDB;



-- =====================================================
-- CUPOM DESCONTO
-- =====================================================

CREATE TABLE cupom (

    id INT AUTO_INCREMENT PRIMARY KEY,


    codigo VARCHAR(50) NOT NULL,


    descricao VARCHAR(255),


    tipo ENUM(
        'PERCENTUAL',
        'VALOR_FIXO',
        'FRETE_GRATIS'
    ),


    valor DECIMAL(12,2),


    percentual DECIMAL(5,2),


    valor_minimo_compra DECIMAL(12,2),


    limite_uso INT,


    usos_realizados INT DEFAULT 0,


    validade_inicio DATE,


    validade_fim DATE,


    ativo BOOLEAN DEFAULT TRUE,


    CONSTRAINT uq_cupom_codigo
        UNIQUE(codigo)

) ENGINE=InnoDB;



-- =====================================================
-- CLIENTE CUPOM
-- =====================================================

CREATE TABLE cliente_cupom (

    cliente_id INT NOT NULL,


    cupom_id INT NOT NULL,


    data_utilizacao DATETIME,


    utilizado BOOLEAN DEFAULT FALSE,


    PRIMARY KEY(
        cliente_id,
        cupom_id
    ),



    CONSTRAINT fk_cliente_cupom_cliente
        FOREIGN KEY(cliente_id)
        REFERENCES cliente(id)
        ON DELETE CASCADE,


    CONSTRAINT fk_cliente_cupom_cupom
        FOREIGN KEY(cupom_id)
        REFERENCES cupom(id)
        ON DELETE CASCADE

) ENGINE=InnoDB;



-- =====================================================
-- REGRA DESCONTO
-- =====================================================

CREATE TABLE regra_desconto (

    id INT AUTO_INCREMENT PRIMARY KEY,


    nome VARCHAR(150) NOT NULL,


    valor_minimo DECIMAL(12,2),


    valor_maximo DECIMAL(12,2),


    percentual_desconto DECIMAL(5,2),


    ativo BOOLEAN DEFAULT TRUE,


    CONSTRAINT uq_regra_nome
        UNIQUE(nome)

) ENGINE=InnoDB;



-- =====================================================
-- PROMOCAO REGRA
-- =====================================================

CREATE TABLE promocao_regra (

    promocao_id INT NOT NULL,


    regra_id INT NOT NULL,


    PRIMARY KEY(
        promocao_id,
        regra_id
    ),


    CONSTRAINT fk_promocao_regra_promocao
        FOREIGN KEY(promocao_id)
        REFERENCES promocao(id)
        ON DELETE CASCADE,


    CONSTRAINT fk_promocao_regra_regra
        FOREIGN KEY(regra_id)
        REFERENCES regra_desconto(id)
        ON DELETE CASCADE

) ENGINE=InnoDB;



-- =====================================================
-- CLIENTE CAMPANHA
-- =====================================================

CREATE TABLE cliente_campanha (

    cliente_id INT NOT NULL,


    campanha_id INT NOT NULL,


    data_entrada DATE,


    ativo BOOLEAN DEFAULT TRUE,


    PRIMARY KEY(
        cliente_id,
        campanha_id
    ),


    CONSTRAINT fk_cliente_campanha_cliente
        FOREIGN KEY(cliente_id)
        REFERENCES cliente(id)
        ON DELETE CASCADE,


    CONSTRAINT fk_cliente_campanha_campanha
        FOREIGN KEY(campanha_id)
        REFERENCES campanha(id)
        ON DELETE CASCADE

) ENGINE=InnoDB;