-- =====================================================
-- ERP JAVA MYSQL
-- Arquivo: 08-financeiro.sql
-- Módulo Financeiro
-- =====================================================

USE erp_java;


-- =====================================================
-- FORMA PAGAMENTO
-- =====================================================

CREATE TABLE forma_pagamento (

    id INT AUTO_INCREMENT PRIMARY KEY,


    nome VARCHAR(100) NOT NULL,


    tipo ENUM(
        'DINHEIRO',
        'PIX',
        'CARTAO_CREDITO',
        'CARTAO_DEBITO',
        'BOLETO',
        'TRANSFERENCIA'
    ) NOT NULL,


    taxa DECIMAL(5,2) DEFAULT 0,


    prazo_recebimento INT DEFAULT 0,


    ativo BOOLEAN DEFAULT TRUE,


    CONSTRAINT uq_forma_pagamento_nome
        UNIQUE(nome)

) ENGINE=InnoDB;



-- =====================================================
-- PAGAMENTO
-- Relacionado ao pedido
-- =====================================================

CREATE TABLE pagamento (

    id INT AUTO_INCREMENT PRIMARY KEY,


    pedido_id INT NOT NULL,


    forma_pagamento_id INT NOT NULL,


    data_pagamento DATETIME,


    valor DECIMAL(12,2),


    status ENUM(
        'PENDENTE',
        'APROVADO',
        'RECUSADO',
        'CANCELADO'
    ) DEFAULT 'PENDENTE',


    codigo_transacao VARCHAR(100),


    observacao TEXT,


    CONSTRAINT fk_pagamento_pedido
        FOREIGN KEY(pedido_id)
        REFERENCES pedido(id),


    CONSTRAINT fk_pagamento_forma
        FOREIGN KEY(forma_pagamento_id)
        REFERENCES forma_pagamento(id)

) ENGINE=InnoDB;



CREATE INDEX idx_pagamento_data
ON pagamento(data_pagamento);



-- =====================================================
-- PARCELA
-- =====================================================

CREATE TABLE parcela (

    id INT AUTO_INCREMENT PRIMARY KEY,


    pagamento_id INT NOT NULL,


    numero INT NOT NULL,


    vencimento DATE,


    valor DECIMAL(12,2),


    data_pagamento DATE,


    status ENUM(
        'ABERTA',
        'PAGA',
        'ATRASADA',
        'CANCELADA'
    ) DEFAULT 'ABERTA',



    CONSTRAINT fk_parcela_pagamento
        FOREIGN KEY(pagamento_id)
        REFERENCES pagamento(id)
        ON DELETE CASCADE

) ENGINE=InnoDB;



-- =====================================================
-- CONTA RECEBER
-- Clientes
-- =====================================================

CREATE TABLE conta_receber (

    id INT AUTO_INCREMENT PRIMARY KEY,


    cliente_id INT NOT NULL,


    pedido_id INT,


    parcela_id INT,


    descricao VARCHAR(255),


    valor DECIMAL(12,2),


    vencimento DATE,


    pagamento DATE,


    status ENUM(
        'ABERTA',
        'PAGA',
        'ATRASADA',
        'CANCELADA'
    ) DEFAULT 'ABERTA',



    CONSTRAINT fk_conta_receber_cliente
        FOREIGN KEY(cliente_id)
        REFERENCES cliente(id),


    CONSTRAINT fk_conta_receber_pedido
        FOREIGN KEY(pedido_id)
        REFERENCES pedido(id),


    CONSTRAINT fk_conta_receber_parcela
        FOREIGN KEY(parcela_id)
        REFERENCES parcela(id)

) ENGINE=InnoDB;



-- =====================================================
-- CONTA PAGAR
-- Fornecedores
-- =====================================================

CREATE TABLE conta_pagar (

    id INT AUTO_INCREMENT PRIMARY KEY,


    fornecedor_id INT NOT NULL,


    compra_id INT,


    descricao VARCHAR(255),


    valor DECIMAL(12,2),


    vencimento DATE,


    pagamento DATE,


    status ENUM(
        'ABERTA',
        'PAGA',
        'ATRASADA',
        'CANCELADA'
    ) DEFAULT 'ABERTA',



    CONSTRAINT fk_conta_pagar_fornecedor
        FOREIGN KEY(fornecedor_id)
        REFERENCES fornecedor(id),


    CONSTRAINT fk_conta_pagar_compra
        FOREIGN KEY(compra_id)
        REFERENCES compra(id)

) ENGINE=InnoDB;



-- =====================================================
-- CAIXA
-- =====================================================

CREATE TABLE caixa (

    id INT AUTO_INCREMENT PRIMARY KEY,


    funcionario_id INT NOT NULL,


    nome VARCHAR(100),


    saldo_inicial DECIMAL(12,2),


    saldo_atual DECIMAL(12,2),


    data_abertura DATETIME,


    data_fechamento DATETIME,


    status ENUM(
        'ABERTO',
        'FECHADO'
    ) DEFAULT 'ABERTO',



    CONSTRAINT fk_caixa_funcionario
        FOREIGN KEY(funcionario_id)
        REFERENCES funcionario(id)

) ENGINE=InnoDB;



-- =====================================================
-- MOVIMENTO CAIXA
-- =====================================================

CREATE TABLE movimento_caixa (

    id INT AUTO_INCREMENT PRIMARY KEY,


    caixa_id INT NOT NULL,


    tipo ENUM(
        'ENTRADA',
        'SAIDA'
    ) NOT NULL,


    origem ENUM(
        'VENDA',
        'COMPRA',
        'AJUSTE',
        'OUTROS'
    ),


    documento_id INT,


    descricao VARCHAR(255),


    valor DECIMAL(12,2),


    data_movimento DATETIME DEFAULT CURRENT_TIMESTAMP,



    CONSTRAINT fk_movimento_caixa
        FOREIGN KEY(caixa_id)
        REFERENCES caixa(id)

) ENGINE=InnoDB;



-- =====================================================
-- CONCILIACAO FINANCEIRA
-- =====================================================

CREATE TABLE conciliacao_financeira (

    id INT AUTO_INCREMENT PRIMARY KEY,


    pagamento_id INT NOT NULL,


    data_conciliacao DATE,


    valor_sistema DECIMAL(12,2),


    valor_banco DECIMAL(12,2),


    diferenca DECIMAL(12,2),


    observacao TEXT,


    CONSTRAINT fk_conciliacao_pagamento
        FOREIGN KEY(pagamento_id)
        REFERENCES pagamento(id)

) ENGINE=InnoDB;



-- =====================================================
-- BANCO
-- =====================================================

CREATE TABLE banco (

    id INT AUTO_INCREMENT PRIMARY KEY,


    nome VARCHAR(100) NOT NULL,


    codigo VARCHAR(20),


    agencia VARCHAR(20),


    conta VARCHAR(30),


    ativo BOOLEAN DEFAULT TRUE,


    CONSTRAINT uq_banco_codigo
        UNIQUE(codigo)

) ENGINE=InnoDB;



-- =====================================================
-- MOVIMENTO BANCARIO
-- =====================================================

CREATE TABLE movimento_bancario (

    id INT AUTO_INCREMENT PRIMARY KEY,


    banco_id INT NOT NULL,


    tipo ENUM(
        'CREDITO',
        'DEBITO'
    ),


    valor DECIMAL(12,2),


    data_movimento DATE,


    descricao VARCHAR(255),



    CONSTRAINT fk_movimento_banco
        FOREIGN KEY(banco_id)
        REFERENCES banco(id)

) ENGINE=InnoDB;