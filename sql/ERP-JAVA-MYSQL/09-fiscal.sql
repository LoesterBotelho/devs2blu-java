-- =====================================================
-- ERP JAVA MYSQL
-- Arquivo: 09-fiscal.sql
-- Módulo Fiscal
-- =====================================================

USE erp_java;


-- =====================================================
-- NATUREZA OPERACAO
-- =====================================================

CREATE TABLE natureza_operacao (

    id INT AUTO_INCREMENT PRIMARY KEY,


    nome VARCHAR(150) NOT NULL,


    tipo ENUM(
        'ENTRADA',
        'SAIDA'
    ) NOT NULL,


    cfop VARCHAR(10),


    descricao TEXT,


    ativo BOOLEAN DEFAULT TRUE,


    CONSTRAINT uq_natureza_nome
        UNIQUE(nome)

) ENGINE=InnoDB;



-- =====================================================
-- SERIE DOCUMENTO
-- =====================================================

CREATE TABLE serie_documento (

    id INT AUTO_INCREMENT PRIMARY KEY,


    nome VARCHAR(50) NOT NULL,


    numero_inicial INT DEFAULT 1,


    numero_atual INT DEFAULT 0,


    modelo VARCHAR(20),


    ativo BOOLEAN DEFAULT TRUE,


    CONSTRAINT uq_serie_nome
        UNIQUE(nome)

) ENGINE=InnoDB;



-- =====================================================
-- IMPOSTO
-- =====================================================

CREATE TABLE imposto (

    id INT AUTO_INCREMENT PRIMARY KEY,


    nome VARCHAR(100) NOT NULL,


    sigla VARCHAR(20),


    descricao TEXT,


    CONSTRAINT uq_imposto_nome
        UNIQUE(nome)

) ENGINE=InnoDB;



-- =====================================================
-- ALIQUOTA
-- =====================================================

CREATE TABLE aliquota (

    id INT AUTO_INCREMENT PRIMARY KEY,


    imposto_id INT NOT NULL,


    percentual DECIMAL(5,2) NOT NULL,


    estado_origem VARCHAR(2),


    estado_destino VARCHAR(2),


    data_inicio DATE,


    data_fim DATE,


    ativo BOOLEAN DEFAULT TRUE,



    CONSTRAINT fk_aliquota_imposto
        FOREIGN KEY(imposto_id)
        REFERENCES imposto(id)

) ENGINE=InnoDB;



-- =====================================================
-- TRIBUTACAO PRODUTO
-- =====================================================

CREATE TABLE tributacao_produto (

    id INT AUTO_INCREMENT PRIMARY KEY,


    produto_id INT NOT NULL,


    imposto_id INT NOT NULL,


    aliquota_id INT NOT NULL,


    codigo_situacao VARCHAR(20),


    observacao TEXT,



    CONSTRAINT fk_tributacao_produto
        FOREIGN KEY(produto_id)
        REFERENCES produto(id),


    CONSTRAINT fk_tributacao_imposto
        FOREIGN KEY(imposto_id)
        REFERENCES imposto(id),


    CONSTRAINT fk_tributacao_aliquota
        FOREIGN KEY(aliquota_id)
        REFERENCES aliquota(id)

) ENGINE=InnoDB;



-- =====================================================
-- NOTA FISCAL
-- =====================================================

CREATE TABLE nota_fiscal (

    id INT AUTO_INCREMENT PRIMARY KEY,


    pedido_id INT,


    compra_id INT,


    natureza_operacao_id INT NOT NULL,


    serie_id INT NOT NULL,


    numero INT NOT NULL,


    chave_acesso VARCHAR(50),


    data_emissao DATETIME,


    valor_produtos DECIMAL(12,2),


    valor_impostos DECIMAL(12,2),


    valor_total DECIMAL(12,2),


    status ENUM(
        'DIGITADA',
        'EMITIDA',
        'CANCELADA'
    ) DEFAULT 'DIGITADA',



    CONSTRAINT fk_nf_pedido
        FOREIGN KEY(pedido_id)
        REFERENCES pedido(id),


    CONSTRAINT fk_nf_compra
        FOREIGN KEY(compra_id)
        REFERENCES compra(id),


    CONSTRAINT fk_nf_natureza
        FOREIGN KEY(natureza_operacao_id)
        REFERENCES natureza_operacao(id),


    CONSTRAINT fk_nf_serie
        FOREIGN KEY(serie_id)
        REFERENCES serie_documento(id)

) ENGINE=InnoDB;



CREATE INDEX idx_nf_data
ON nota_fiscal(data_emissao);



-- =====================================================
-- NOTA ITEM
-- =====================================================

CREATE TABLE nota_item (

    id INT AUTO_INCREMENT PRIMARY KEY,


    nota_fiscal_id INT NOT NULL,


    produto_id INT NOT NULL,


    quantidade DECIMAL(12,3),


    valor_unitario DECIMAL(12,2),


    valor_total DECIMAL(12,2),


    valor_icms DECIMAL(12,2),


    valor_ipi DECIMAL(12,2),


    valor_pis DECIMAL(12,2),


    valor_cofins DECIMAL(12,2),



    CONSTRAINT fk_nota_item_nf
        FOREIGN KEY(nota_fiscal_id)
        REFERENCES nota_fiscal(id)
        ON DELETE CASCADE,


    CONSTRAINT fk_nota_item_produto
        FOREIGN KEY(produto_id)
        REFERENCES produto(id)

) ENGINE=InnoDB;



-- =====================================================
-- CST / CLASSIFICACAO FISCAL
-- =====================================================

CREATE TABLE classificacao_fiscal (

    id INT AUTO_INCREMENT PRIMARY KEY,


    produto_id INT NOT NULL,


    ncm VARCHAR(20),


    cest VARCHAR(20),


    origem VARCHAR(50),


    observacao TEXT,



    CONSTRAINT fk_classificacao_produto
        FOREIGN KEY(produto_id)
        REFERENCES produto(id)

) ENGINE=InnoDB;



-- =====================================================
-- DOCUMENTO FISCAL LOG
-- =====================================================

CREATE TABLE documento_fiscal_log (

    id INT AUTO_INCREMENT PRIMARY KEY,


    nota_fiscal_id INT NOT NULL,


    status_anterior VARCHAR(50),


    status_novo VARCHAR(50),


    data_alteracao DATETIME DEFAULT CURRENT_TIMESTAMP,


    usuario_id INT,


    observacao TEXT,



    CONSTRAINT fk_documento_log_nf
        FOREIGN KEY(nota_fiscal_id)
        REFERENCES nota_fiscal(id)

) ENGINE=InnoDB;