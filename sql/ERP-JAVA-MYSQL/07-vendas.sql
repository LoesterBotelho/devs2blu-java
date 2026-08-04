-- =====================================================
-- ERP JAVA MYSQL
-- Arquivo: 07-vendas.sql
-- Módulo Vendas
-- =====================================================

USE erp_java;


-- =====================================================
-- CARRINHO
-- =====================================================

CREATE TABLE carrinho (

    id INT AUTO_INCREMENT PRIMARY KEY,

    cliente_id INT NOT NULL,

    data_criacao DATETIME DEFAULT CURRENT_TIMESTAMP,

    status ENUM(
        'ABERTO',
        'FINALIZADO',
        'CANCELADO'
    ) DEFAULT 'ABERTO',


    CONSTRAINT fk_carrinho_cliente
        FOREIGN KEY(cliente_id)
        REFERENCES cliente(id)

) ENGINE=InnoDB;



-- =====================================================
-- CARRINHO ITEM
-- =====================================================

CREATE TABLE carrinho_item (

    id INT AUTO_INCREMENT PRIMARY KEY,


    carrinho_id INT NOT NULL,


    produto_id INT NOT NULL,


    quantidade DECIMAL(12,3) DEFAULT 1,


    valor_unitario DECIMAL(12,2),



    CONSTRAINT fk_carrinho_item_carrinho
        FOREIGN KEY(carrinho_id)
        REFERENCES carrinho(id)
        ON DELETE CASCADE,


    CONSTRAINT fk_carrinho_item_produto
        FOREIGN KEY(produto_id)
        REFERENCES produto(id)

) ENGINE=InnoDB;



-- =====================================================
-- ORCAMENTO
-- =====================================================

CREATE TABLE orcamento (

    id INT AUTO_INCREMENT PRIMARY KEY,


    cliente_id INT NOT NULL,


    vendedor_id INT,


    data_orcamento DATE,


    validade DATE,


    status ENUM(
        'ABERTO',
        'APROVADO',
        'REJEITADO',
        'CANCELADO'
    ) DEFAULT 'ABERTO',


    valor_total DECIMAL(12,2),


    observacao TEXT,


    CONSTRAINT fk_orcamento_cliente
        FOREIGN KEY(cliente_id)
        REFERENCES cliente(id),


    CONSTRAINT fk_orcamento_vendedor
        FOREIGN KEY(vendedor_id)
        REFERENCES vendedor(id)

) ENGINE=InnoDB;



-- =====================================================
-- ORCAMENTO ITEM
-- =====================================================

CREATE TABLE orcamento_item (

    id INT AUTO_INCREMENT PRIMARY KEY,


    orcamento_id INT NOT NULL,


    produto_id INT NOT NULL,


    quantidade DECIMAL(12,3),


    valor_unitario DECIMAL(12,2),


    desconto DECIMAL(12,2),


    valor_total DECIMAL(12,2),



    CONSTRAINT fk_orcamento_item_orcamento
        FOREIGN KEY(orcamento_id)
        REFERENCES orcamento(id)
        ON DELETE CASCADE,


    CONSTRAINT fk_orcamento_item_produto
        FOREIGN KEY(produto_id)
        REFERENCES produto(id)

) ENGINE=InnoDB;



-- =====================================================
-- PEDIDO VENDA
-- =====================================================

CREATE TABLE pedido (

    id INT AUTO_INCREMENT PRIMARY KEY,


    cliente_id INT NOT NULL,


    vendedor_id INT,


    orcamento_id INT,


    data_pedido DATETIME DEFAULT CURRENT_TIMESTAMP,


    status ENUM(
        'ABERTO',
        'PAGO',
        'SEPARANDO',
        'ENVIADO',
        'ENTREGUE',
        'CANCELADO'
    ) DEFAULT 'ABERTO',


    valor_produtos DECIMAL(12,2),


    valor_desconto DECIMAL(12,2),


    valor_frete DECIMAL(12,2),


    valor_total DECIMAL(12,2),


    observacao TEXT,



    CONSTRAINT fk_pedido_cliente
        FOREIGN KEY(cliente_id)
        REFERENCES cliente(id),


    CONSTRAINT fk_pedido_vendedor
        FOREIGN KEY(vendedor_id)
        REFERENCES vendedor(id),


    CONSTRAINT fk_pedido_orcamento
        FOREIGN KEY(orcamento_id)
        REFERENCES orcamento(id)

) ENGINE=InnoDB;



CREATE INDEX idx_pedido_data
ON pedido(data_pedido);



-- =====================================================
-- PEDIDO ITEM
-- =====================================================

CREATE TABLE pedido_item (

    id INT AUTO_INCREMENT PRIMARY KEY,


    pedido_id INT NOT NULL,


    produto_id INT NOT NULL,


    quantidade DECIMAL(12,3),


    valor_unitario DECIMAL(12,2),


    desconto DECIMAL(12,2),


    valor_total DECIMAL(12,2),



    CONSTRAINT fk_pedido_item_pedido
        FOREIGN KEY(pedido_id)
        REFERENCES pedido(id)
        ON DELETE CASCADE,


    CONSTRAINT fk_pedido_item_produto
        FOREIGN KEY(produto_id)
        REFERENCES produto(id)

) ENGINE=InnoDB;



-- =====================================================
-- DEVOLUCAO
-- =====================================================

CREATE TABLE devolucao (

    id INT AUTO_INCREMENT PRIMARY KEY,


    pedido_id INT NOT NULL,


    cliente_id INT NOT NULL,


    funcionario_id INT,


    data_devolucao DATE,


    motivo VARCHAR(255),


    valor_total DECIMAL(12,2),


    status ENUM(
        'SOLICITADA',
        'APROVADA',
        'FINALIZADA',
        'NEGADA'
    ),



    CONSTRAINT fk_devolucao_pedido
        FOREIGN KEY(pedido_id)
        REFERENCES pedido(id),


    CONSTRAINT fk_devolucao_cliente
        FOREIGN KEY(cliente_id)
        REFERENCES cliente(id),


    CONSTRAINT fk_devolucao_funcionario
        FOREIGN KEY(funcionario_id)
        REFERENCES funcionario(id)

) ENGINE=InnoDB;



-- =====================================================
-- DEVOLUCAO ITEM
-- =====================================================

CREATE TABLE devolucao_item (

    id INT AUTO_INCREMENT PRIMARY KEY,


    devolucao_id INT NOT NULL,


    produto_id INT NOT NULL,


    quantidade DECIMAL(12,3),


    valor DECIMAL(12,2),


    motivo VARCHAR(255),



    CONSTRAINT fk_devolucao_item_devolucao
        FOREIGN KEY(devolucao_id)
        REFERENCES devolucao(id)
        ON DELETE CASCADE,


    CONSTRAINT fk_devolucao_item_produto
        FOREIGN KEY(produto_id)
        REFERENCES produto(id)

) ENGINE=InnoDB;



-- =====================================================
-- COMISSAO VENDA
-- =====================================================

CREATE TABLE comissao_venda (

    id INT AUTO_INCREMENT PRIMARY KEY,


    vendedor_id INT NOT NULL,


    pedido_id INT NOT NULL,


    percentual DECIMAL(5,2),


    valor DECIMAL(12,2),


    pago BOOLEAN DEFAULT FALSE,


    data_calculo DATE,



    CONSTRAINT fk_comissao_vendedor
        FOREIGN KEY(vendedor_id)
        REFERENCES vendedor(id),


    CONSTRAINT fk_comissao_pedido
        FOREIGN KEY(pedido_id)
        REFERENCES pedido(id)

) ENGINE=InnoDB;



-- =====================================================
-- AVALIACAO PRODUTO
-- =====================================================

CREATE TABLE avaliacao_produto (

    id INT AUTO_INCREMENT PRIMARY KEY,


    cliente_id INT NOT NULL,


    produto_id INT NOT NULL,


    nota INT,


    comentario TEXT,


    data_avaliacao DATETIME DEFAULT CURRENT_TIMESTAMP,



    CONSTRAINT fk_avaliacao_cliente
        FOREIGN KEY(cliente_id)
        REFERENCES cliente(id),


    CONSTRAINT fk_avaliacao_produto
        FOREIGN KEY(produto_id)
        REFERENCES produto(id)

) ENGINE=InnoDB;