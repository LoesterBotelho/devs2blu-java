-- =====================================================
-- ERP JAVA MYSQL
-- Arquivo: 04-produtos.sql
-- Módulo Produtos
-- =====================================================

USE erp_java;


-- =====================================================
-- FABRICANTE
-- =====================================================

CREATE TABLE fabricante (

    id INT AUTO_INCREMENT PRIMARY KEY,

    nome VARCHAR(150) NOT NULL,

    pais_origem VARCHAR(100),

    site VARCHAR(200),

    observacao TEXT,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    ativo BOOLEAN DEFAULT TRUE,

    CONSTRAINT uq_fabricante_nome
        UNIQUE(nome)

) ENGINE=InnoDB;



-- =====================================================
-- MARCA
-- =====================================================

CREATE TABLE marca (

    id INT AUTO_INCREMENT PRIMARY KEY,

    fabricante_id INT,

    nome VARCHAR(100) NOT NULL,

    descricao TEXT,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    ativo BOOLEAN DEFAULT TRUE,


    CONSTRAINT fk_marca_fabricante
        FOREIGN KEY (fabricante_id)
        REFERENCES fabricante(id),


    CONSTRAINT uq_marca_nome
        UNIQUE(nome)

) ENGINE=InnoDB;



-- =====================================================
-- CATEGORIA
-- =====================================================

CREATE TABLE categoria (

    id INT AUTO_INCREMENT PRIMARY KEY,


    categoria_pai_id INT,


    nome VARCHAR(100) NOT NULL,


    descricao TEXT,


    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,


    ativo BOOLEAN DEFAULT TRUE,


    CONSTRAINT fk_categoria_pai
        FOREIGN KEY (categoria_pai_id)
        REFERENCES categoria(id),


    CONSTRAINT uq_categoria_nome
        UNIQUE(nome)

) ENGINE=InnoDB;



-- =====================================================
-- SUBCATEGORIA
-- =====================================================

CREATE TABLE subcategoria (

    id INT AUTO_INCREMENT PRIMARY KEY,


    categoria_id INT NOT NULL,


    nome VARCHAR(100) NOT NULL,


    descricao TEXT,


    ativo BOOLEAN DEFAULT TRUE,


    CONSTRAINT fk_subcategoria_categoria
        FOREIGN KEY (categoria_id)
        REFERENCES categoria(id),


    CONSTRAINT uq_subcategoria
        UNIQUE(categoria_id,nome)

) ENGINE=InnoDB;



-- =====================================================
-- UNIDADE MEDIDA
-- =====================================================

CREATE TABLE unidade_medida (

    id INT AUTO_INCREMENT PRIMARY KEY,


    nome VARCHAR(50) NOT NULL,


    sigla VARCHAR(10) NOT NULL,


    CONSTRAINT uq_unidade_nome
        UNIQUE(nome),


    CONSTRAINT uq_unidade_sigla
        UNIQUE(sigla)

) ENGINE=InnoDB;



-- =====================================================
-- COR
-- =====================================================

CREATE TABLE cor (

    id INT AUTO_INCREMENT PRIMARY KEY,


    nome VARCHAR(50) NOT NULL,


    codigo_hex VARCHAR(10),


    CONSTRAINT uq_cor_nome
        UNIQUE(nome)

) ENGINE=InnoDB;



-- =====================================================
-- TAMANHO
-- =====================================================

CREATE TABLE tamanho (

    id INT AUTO_INCREMENT PRIMARY KEY,


    nome VARCHAR(50) NOT NULL,


    descricao VARCHAR(100),


    CONSTRAINT uq_tamanho_nome
        UNIQUE(nome)

) ENGINE=InnoDB;



-- =====================================================
-- PRODUTO
-- =====================================================

CREATE TABLE produto (

    id INT AUTO_INCREMENT PRIMARY KEY,


    categoria_id INT NOT NULL,


    subcategoria_id INT,


    marca_id INT,


    unidade_medida_id INT,


    nome VARCHAR(200) NOT NULL,


    descricao TEXT,


    codigo_barras VARCHAR(50),


    peso DECIMAL(10,3),


    altura DECIMAL(10,2),


    largura DECIMAL(10,2),


    comprimento DECIMAL(10,2),


    preco_custo DECIMAL(12,2),


    preco_venda DECIMAL(12,2),


    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,


    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,


    ativo BOOLEAN DEFAULT TRUE,



    CONSTRAINT fk_produto_categoria
        FOREIGN KEY (categoria_id)
        REFERENCES categoria(id),


    CONSTRAINT fk_produto_subcategoria
        FOREIGN KEY (subcategoria_id)
        REFERENCES subcategoria(id),


    CONSTRAINT fk_produto_marca
        FOREIGN KEY (marca_id)
        REFERENCES marca(id),


    CONSTRAINT fk_produto_unidade
        FOREIGN KEY (unidade_medida_id)
        REFERENCES unidade_medida(id),


    CONSTRAINT uq_produto_codigo
        UNIQUE(codigo_barras)

) ENGINE=InnoDB;



CREATE INDEX idx_produto_nome
ON produto(nome);



-- =====================================================
-- PRODUTO COR
-- =====================================================

CREATE TABLE produto_cor (

    produto_id INT NOT NULL,

    cor_id INT NOT NULL,


    PRIMARY KEY(produto_id,cor_id),


    CONSTRAINT fk_produto_cor_produto
        FOREIGN KEY(produto_id)
        REFERENCES produto(id)
        ON DELETE CASCADE,


    CONSTRAINT fk_produto_cor_cor
        FOREIGN KEY(cor_id)
        REFERENCES cor(id)
        ON DELETE CASCADE

) ENGINE=InnoDB;



-- =====================================================
-- PRODUTO TAMANHO
-- =====================================================

CREATE TABLE produto_tamanho (

    produto_id INT NOT NULL,


    tamanho_id INT NOT NULL,


    PRIMARY KEY(produto_id,tamanho_id),


    CONSTRAINT fk_produto_tamanho_produto
        FOREIGN KEY(produto_id)
        REFERENCES produto(id)
        ON DELETE CASCADE,


    CONSTRAINT fk_produto_tamanho_tamanho
        FOREIGN KEY(tamanho_id)
        REFERENCES tamanho(id)
        ON DELETE CASCADE

) ENGINE=InnoDB;



-- =====================================================
-- PRODUTO IMAGEM
-- =====================================================

CREATE TABLE produto_imagem (

    id INT AUTO_INCREMENT PRIMARY KEY,


    produto_id INT NOT NULL,


    caminho VARCHAR(255),


    principal BOOLEAN DEFAULT FALSE,


    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,


    CONSTRAINT fk_produto_imagem
        FOREIGN KEY(produto_id)
        REFERENCES produto(id)
        ON DELETE CASCADE

) ENGINE=InnoDB;



-- =====================================================
-- CODIGO BARRAS
-- =====================================================

CREATE TABLE codigo_barras (

    id INT AUTO_INCREMENT PRIMARY KEY,


    produto_id INT NOT NULL,


    codigo VARCHAR(100) NOT NULL,


    tipo VARCHAR(30),



    CONSTRAINT fk_codigo_produto
        FOREIGN KEY(produto_id)
        REFERENCES produto(id),


    CONSTRAINT uq_codigo
        UNIQUE(codigo)

) ENGINE=InnoDB;



-- =====================================================
-- HISTORICO PRECO
-- =====================================================

CREATE TABLE historico_preco (

    id INT AUTO_INCREMENT PRIMARY KEY,


    produto_id INT NOT NULL,


    preco_antigo DECIMAL(12,2),


    preco_novo DECIMAL(12,2),


    data_alteracao DATETIME DEFAULT CURRENT_TIMESTAMP,


    usuario_id INT,


    CONSTRAINT fk_historico_preco_produto
        FOREIGN KEY(produto_id)
        REFERENCES produto(id)

) ENGINE=InnoDB;



-- =====================================================
-- PRODUTO FORNECEDOR
-- =====================================================

CREATE TABLE produto_fornecedor (

    produto_id INT NOT NULL,


    fornecedor_id INT NOT NULL,


    codigo_fornecedor VARCHAR(50),


    preco_compra DECIMAL(12,2),


    prazo_entrega INT,


    PRIMARY KEY(produto_id,fornecedor_id),



    CONSTRAINT fk_produto_fornecedor_produto
        FOREIGN KEY(produto_id)
        REFERENCES produto(id),



    CONSTRAINT fk_produto_fornecedor_fornecedor
        FOREIGN KEY(fornecedor_id)
        REFERENCES fornecedor(id)

) ENGINE=InnoDB;