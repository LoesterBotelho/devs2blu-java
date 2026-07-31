-- =====================================================
-- ERP JAVA MYSQL
-- Arquivo: 05-estoque.sql
-- Módulo Estoque
-- =====================================================

USE erp_java;


-- =====================================================
-- DEPOSITO
-- =====================================================

CREATE TABLE deposito (

    id INT AUTO_INCREMENT PRIMARY KEY,

    nome VARCHAR(100) NOT NULL,

    endereco_id INT,

    responsavel_id INT,

    descricao TEXT,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    ativo BOOLEAN DEFAULT TRUE,


    CONSTRAINT fk_deposito_endereco
        FOREIGN KEY(endereco_id)
        REFERENCES endereco(id),


    CONSTRAINT fk_deposito_responsavel
        FOREIGN KEY(responsavel_id)
        REFERENCES funcionario(id),


    CONSTRAINT uq_deposito_nome
        UNIQUE(nome)

) ENGINE=InnoDB;



-- =====================================================
-- LOTE
-- =====================================================

CREATE TABLE lote (

    id INT AUTO_INCREMENT PRIMARY KEY,


    produto_id INT NOT NULL,


    numero_lote VARCHAR(50) NOT NULL,


    data_fabricacao DATE,


    data_validade DATE,


    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,



    CONSTRAINT fk_lote_produto
        FOREIGN KEY(produto_id)
        REFERENCES produto(id),


    CONSTRAINT uq_lote
        UNIQUE(produto_id,numero_lote)

) ENGINE=InnoDB;



-- =====================================================
-- ESTOQUE
-- =====================================================

CREATE TABLE estoque (

    id INT AUTO_INCREMENT PRIMARY KEY,


    deposito_id INT NOT NULL,


    produto_id INT NOT NULL,


    lote_id INT,


    quantidade DECIMAL(12,3) DEFAULT 0,


    estoque_minimo DECIMAL(12,3) DEFAULT 0,


    estoque_maximo DECIMAL(12,3),


    ultima_atualizacao DATETIME DEFAULT CURRENT_TIMESTAMP,


    CONSTRAINT fk_estoque_deposito
        FOREIGN KEY(deposito_id)
        REFERENCES deposito(id),


    CONSTRAINT fk_estoque_produto
        FOREIGN KEY(produto_id)
        REFERENCES produto(id),


    CONSTRAINT fk_estoque_lote
        FOREIGN KEY(lote_id)
        REFERENCES lote(id),


    CONSTRAINT uq_estoque
        UNIQUE(deposito_id,produto_id,lote_id)

) ENGINE=InnoDB;



CREATE INDEX idx_estoque_quantidade
ON estoque(quantidade);



-- =====================================================
-- MOVIMENTACAO ESTOQUE
-- =====================================================

CREATE TABLE movimentacao_estoque (

    id INT AUTO_INCREMENT PRIMARY KEY,


    estoque_id INT NOT NULL,


    funcionario_id INT,


    tipo ENUM(
        'ENTRADA',
        'SAIDA',
        'AJUSTE',
        'DEVOLUCAO'
    ) NOT NULL,


    quantidade DECIMAL(12,3) NOT NULL,


    saldo_anterior DECIMAL(12,3),


    saldo_posterior DECIMAL(12,3),


    documento VARCHAR(100),


    observacao TEXT,


    data_movimento DATETIME DEFAULT CURRENT_TIMESTAMP,



    CONSTRAINT fk_movimentacao_estoque
        FOREIGN KEY(estoque_id)
        REFERENCES estoque(id),


    CONSTRAINT fk_movimentacao_funcionario
        FOREIGN KEY(funcionario_id)
        REFERENCES funcionario(id)

) ENGINE=InnoDB;



CREATE INDEX idx_movimentacao_data
ON movimentacao_estoque(data_movimento);



-- =====================================================
-- INVENTARIO
-- =====================================================

CREATE TABLE inventario (

    id INT AUTO_INCREMENT PRIMARY KEY,


    deposito_id INT NOT NULL,


    funcionario_id INT,


    data_inicio DATE,


    data_fim DATE,


    status ENUM(
        'ABERTO',
        'PROCESSANDO',
        'FINALIZADO'
    ) DEFAULT 'ABERTO',


    observacao TEXT,


    CONSTRAINT fk_inventario_deposito
        FOREIGN KEY(deposito_id)
        REFERENCES deposito(id),


    CONSTRAINT fk_inventario_funcionario
        FOREIGN KEY(funcionario_id)
        REFERENCES funcionario(id)

) ENGINE=InnoDB;



-- =====================================================
-- INVENTARIO ITEM
-- =====================================================

CREATE TABLE inventario_item (

    id INT AUTO_INCREMENT PRIMARY KEY,


    inventario_id INT NOT NULL,


    produto_id INT NOT NULL,


    quantidade_sistema DECIMAL(12,3),


    quantidade_contada DECIMAL(12,3),


    diferenca DECIMAL(12,3),


    observacao TEXT,


    CONSTRAINT fk_inventario_item_inventario
        FOREIGN KEY(inventario_id)
        REFERENCES inventario(id)
        ON DELETE CASCADE,


    CONSTRAINT fk_inventario_item_produto
        FOREIGN KEY(produto_id)
        REFERENCES produto(id)

) ENGINE=InnoDB;



-- =====================================================
-- AJUSTE ESTOQUE
-- =====================================================

CREATE TABLE ajuste_estoque (

    id INT AUTO_INCREMENT PRIMARY KEY,


    estoque_id INT NOT NULL,


    funcionario_id INT,


    quantidade_anterior DECIMAL(12,3),


    quantidade_nova DECIMAL(12,3),


    motivo VARCHAR(255),


    data_ajuste DATETIME DEFAULT CURRENT_TIMESTAMP,


    CONSTRAINT fk_ajuste_estoque
        FOREIGN KEY(estoque_id)
        REFERENCES estoque(id),


    CONSTRAINT fk_ajuste_funcionario
        FOREIGN KEY(funcionario_id)
        REFERENCES funcionario(id)

) ENGINE=InnoDB;



-- =====================================================
-- VALIDADE PRODUTO
-- =====================================================

CREATE TABLE validade_produto (

    id INT AUTO_INCREMENT PRIMARY KEY,


    lote_id INT NOT NULL,


    alerta_dias INT DEFAULT 30,


    status ENUM(
        'VALIDO',
        'PROXIMO_VENCIMENTO',
        'VENCIDO'
    ),


    CONSTRAINT fk_validade_lote
        FOREIGN KEY(lote_id)
        REFERENCES lote(id)

) ENGINE=InnoDB;



-- =====================================================
-- LOCALIZACAO ESTOQUE
-- =====================================================

CREATE TABLE localizacao_estoque (

    id INT AUTO_INCREMENT PRIMARY KEY,


    deposito_id INT NOT NULL,


    corredor VARCHAR(50),


    prateleira VARCHAR(50),


    posicao VARCHAR(50),


    descricao VARCHAR(200),


    CONSTRAINT fk_localizacao_deposito
        FOREIGN KEY(deposito_id)
        REFERENCES deposito(id)

) ENGINE=InnoDB;