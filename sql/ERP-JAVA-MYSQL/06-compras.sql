-- =====================================================
-- ERP JAVA MYSQL
-- Arquivo: 06-compras.sql
-- Módulo Compras
-- =====================================================

USE erp_java;


-- =====================================================
-- FORNECEDOR PRODUTO
-- Relação N:N fornecedor x produto
-- =====================================================

CREATE TABLE fornecedor_produto (

    fornecedor_id INT NOT NULL,

    produto_id INT NOT NULL,

    codigo_fornecedor VARCHAR(50),

    preco_compra DECIMAL(12,2),

    prazo_entrega INT,

    observacao TEXT,


    PRIMARY KEY(fornecedor_id, produto_id),


    CONSTRAINT fk_fornecedor_produto_fornecedor
        FOREIGN KEY(fornecedor_id)
        REFERENCES fornecedor(id),


    CONSTRAINT fk_fornecedor_produto_produto
        FOREIGN KEY(produto_id)
        REFERENCES produto(id)

) ENGINE=InnoDB;



-- =====================================================
-- COTACAO
-- =====================================================

CREATE TABLE cotacao (

    id INT AUTO_INCREMENT PRIMARY KEY,


    fornecedor_id INT NOT NULL,


    funcionario_id INT,


    data_cotacao DATE NOT NULL,


    validade DATE,


    status ENUM(
        'ABERTA',
        'APROVADA',
        'REJEITADA',
        'CANCELADA'
    ) DEFAULT 'ABERTA',


    observacao TEXT,


    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,


    CONSTRAINT fk_cotacao_fornecedor
        FOREIGN KEY(fornecedor_id)
        REFERENCES fornecedor(id),


    CONSTRAINT fk_cotacao_funcionario
        FOREIGN KEY(funcionario_id)
        REFERENCES funcionario(id)

) ENGINE=InnoDB;



-- =====================================================
-- COTACAO ITEM
-- =====================================================

CREATE TABLE cotacao_item (

    id INT AUTO_INCREMENT PRIMARY KEY,


    cotacao_id INT NOT NULL,


    produto_id INT NOT NULL,


    quantidade DECIMAL(12,3),


    valor_unitario DECIMAL(12,2),


    desconto DECIMAL(12,2) DEFAULT 0,


    valor_total DECIMAL(12,2),


    CONSTRAINT fk_cotacao_item_cotacao
        FOREIGN KEY(cotacao_id)
        REFERENCES cotacao(id)
        ON DELETE CASCADE,


    CONSTRAINT fk_cotacao_item_produto
        FOREIGN KEY(produto_id)
        REFERENCES produto(id)

) ENGINE=InnoDB;



-- =====================================================
-- PEDIDO COMPRA
-- =====================================================

CREATE TABLE pedido_compra (

    id INT AUTO_INCREMENT PRIMARY KEY,


    fornecedor_id INT NOT NULL,


    funcionario_id INT,


    cotacao_id INT,


    data_pedido DATE NOT NULL,


    previsao_entrega DATE,


    status ENUM(
        'ABERTO',
        'APROVADO',
        'ENVIADO',
        'RECEBIDO',
        'CANCELADO'
    ) DEFAULT 'ABERTO',


    valor_total DECIMAL(12,2),


    observacao TEXT,


    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,


    CONSTRAINT fk_pedido_compra_fornecedor
        FOREIGN KEY(fornecedor_id)
        REFERENCES fornecedor(id),


    CONSTRAINT fk_pedido_compra_funcionario
        FOREIGN KEY(funcionario_id)
        REFERENCES funcionario(id),


    CONSTRAINT fk_pedido_compra_cotacao
        FOREIGN KEY(cotacao_id)
        REFERENCES cotacao(id)

) ENGINE=InnoDB;



-- =====================================================
-- PEDIDO COMPRA ITEM
-- =====================================================

CREATE TABLE pedido_compra_item (

    id INT AUTO_INCREMENT PRIMARY KEY,


    pedido_compra_id INT NOT NULL,


    produto_id INT NOT NULL,


    quantidade DECIMAL(12,3),


    valor_unitario DECIMAL(12,2),


    desconto DECIMAL(12,2) DEFAULT 0,


    valor_total DECIMAL(12,2),



    CONSTRAINT fk_pedido_item_pedido
        FOREIGN KEY(pedido_compra_id)
        REFERENCES pedido_compra(id)
        ON DELETE CASCADE,


    CONSTRAINT fk_pedido_item_produto
        FOREIGN KEY(produto_id)
        REFERENCES produto(id)

) ENGINE=InnoDB;



-- =====================================================
-- COMPRA
-- Recebimento da mercadoria
-- =====================================================

CREATE TABLE compra (

    id INT AUTO_INCREMENT PRIMARY KEY,


    pedido_compra_id INT,


    fornecedor_id INT NOT NULL,


    funcionario_id INT,


    numero_nota VARCHAR(50),


    data_compra DATE NOT NULL,


    valor_total DECIMAL(12,2),


    status ENUM(
        'PENDENTE',
        'RECEBIDA',
        'CANCELADA'
    ) DEFAULT 'PENDENTE',


    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,


    CONSTRAINT fk_compra_pedido
        FOREIGN KEY(pedido_compra_id)
        REFERENCES pedido_compra(id),


    CONSTRAINT fk_compra_fornecedor
        FOREIGN KEY(fornecedor_id)
        REFERENCES fornecedor(id),


    CONSTRAINT fk_compra_funcionario
        FOREIGN KEY(funcionario_id)
        REFERENCES funcionario(id)

) ENGINE=InnoDB;



-- =====================================================
-- COMPRA ITEM
-- =====================================================

CREATE TABLE compra_item (

    id INT AUTO_INCREMENT PRIMARY KEY,


    compra_id INT NOT NULL,


    produto_id INT NOT NULL,


    lote_id INT,


    quantidade DECIMAL(12,3),


    valor_unitario DECIMAL(12,2),


    valor_total DECIMAL(12,2),



    CONSTRAINT fk_compra_item_compra
        FOREIGN KEY(compra_id)
        REFERENCES compra(id)
        ON DELETE CASCADE,


    CONSTRAINT fk_compra_item_produto
        FOREIGN KEY(produto_id)
        REFERENCES produto(id),


    CONSTRAINT fk_compra_item_lote
        FOREIGN KEY(lote_id)
        REFERENCES lote(id)

) ENGINE=InnoDB;



-- =====================================================
-- ENTRADA ESTOQUE
-- =====================================================

CREATE TABLE entrada_estoque (

    id INT AUTO_INCREMENT PRIMARY KEY,


    compra_id INT NOT NULL,


    estoque_id INT NOT NULL,


    funcionario_id INT,


    quantidade DECIMAL(12,3),


    data_entrada DATETIME DEFAULT CURRENT_TIMESTAMP,


    observacao TEXT,


    CONSTRAINT fk_entrada_compra
        FOREIGN KEY(compra_id)
        REFERENCES compra(id),


    CONSTRAINT fk_entrada_estoque
        FOREIGN KEY(estoque_id)
        REFERENCES estoque(id),


    CONSTRAINT fk_entrada_funcionario
        FOREIGN KEY(funcionario_id)
        REFERENCES funcionario(id)

) ENGINE=InnoDB;



-- =====================================================
-- HISTORICO COMPRA FORNECEDOR
-- =====================================================

CREATE TABLE historico_compra_fornecedor (

    id INT AUTO_INCREMENT PRIMARY KEY,


    fornecedor_id INT NOT NULL,


    compra_id INT NOT NULL,


    data_compra DATE,


    valor DECIMAL(12,2),


    CONSTRAINT fk_historico_fornecedor
        FOREIGN KEY(fornecedor_id)
        REFERENCES fornecedor(id),


    CONSTRAINT fk_historico_compra
        FOREIGN KEY(compra_id)
        REFERENCES compra(id)

) ENGINE=InnoDB;