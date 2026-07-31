-- =====================================================
-- ERP JAVA MYSQL
-- Arquivo: 10-entregas.sql
-- Módulo Entregas / Logística
-- =====================================================

USE erp_java;


-- =====================================================
-- TRANSPORTADORA
-- =====================================================

CREATE TABLE transportadora (

    id INT AUTO_INCREMENT PRIMARY KEY,


    pessoa_id INT,


    cnpj CHAR(14),


    nome_fantasia VARCHAR(150) NOT NULL,


    razao_social VARCHAR(200),


    registro_antt VARCHAR(50),


    telefone VARCHAR(20),


    email VARCHAR(150),


    ativo BOOLEAN DEFAULT TRUE,


    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,


    CONSTRAINT fk_transportadora_pessoa
        FOREIGN KEY(pessoa_id)
        REFERENCES pessoa(id),


    CONSTRAINT uq_transportadora_cnpj
        UNIQUE(cnpj)

) ENGINE=InnoDB;



-- =====================================================
-- MOTORISTA
-- =====================================================

CREATE TABLE motorista (

    id INT AUTO_INCREMENT PRIMARY KEY,


    transportadora_id INT,


    nome VARCHAR(150) NOT NULL,


    cpf CHAR(11),


    cnh VARCHAR(30),


    categoria_cnh VARCHAR(5),


    validade_cnh DATE,


    telefone VARCHAR(20),


    ativo BOOLEAN DEFAULT TRUE,


    CONSTRAINT fk_motorista_transportadora
        FOREIGN KEY(transportadora_id)
        REFERENCES transportadora(id),


    CONSTRAINT uq_motorista_cpf
        UNIQUE(cpf)

) ENGINE=InnoDB;



-- =====================================================
-- VEICULO
-- =====================================================

CREATE TABLE veiculo (

    id INT AUTO_INCREMENT PRIMARY KEY,


    transportadora_id INT NOT NULL,


    motorista_id INT,


    placa VARCHAR(10) NOT NULL,


    modelo VARCHAR(100),


    marca VARCHAR(100),


    ano INT,


    capacidade_kg DECIMAL(10,2),


    tipo ENUM(
        'MOTO',
        'CARRO',
        'VAN',
        'CAMINHAO',
        'CARRETA'
    ),


    ativo BOOLEAN DEFAULT TRUE,



    CONSTRAINT fk_veiculo_transportadora
        FOREIGN KEY(transportadora_id)
        REFERENCES transportadora(id),


    CONSTRAINT fk_veiculo_motorista
        FOREIGN KEY(motorista_id)
        REFERENCES motorista(id),


    CONSTRAINT uq_veiculo_placa
        UNIQUE(placa)

) ENGINE=InnoDB;



-- =====================================================
-- ROTA ENTREGA
-- =====================================================

CREATE TABLE rota_entrega (

    id INT AUTO_INCREMENT PRIMARY KEY,


    nome VARCHAR(100) NOT NULL,


    cidade_origem VARCHAR(100),


    cidade_destino VARCHAR(100),


    distancia_km DECIMAL(10,2),


    tempo_estimado INT,


    descricao TEXT,


    CONSTRAINT uq_rota_nome
        UNIQUE(nome)

) ENGINE=InnoDB;



-- =====================================================
-- FRETE
-- =====================================================

CREATE TABLE frete (

    id INT AUTO_INCREMENT PRIMARY KEY,


    pedido_id INT NOT NULL,


    transportadora_id INT,


    rota_id INT,


    valor DECIMAL(12,2),


    peso DECIMAL(12,3),


    prazo_dias INT,


    tipo ENUM(
        'NORMAL',
        'EXPRESSO',
        'GRATIS'
    ),


    data_calculo DATETIME DEFAULT CURRENT_TIMESTAMP,



    CONSTRAINT fk_frete_pedido
        FOREIGN KEY(pedido_id)
        REFERENCES pedido(id),


    CONSTRAINT fk_frete_transportadora
        FOREIGN KEY(transportadora_id)
        REFERENCES transportadora(id),


    CONSTRAINT fk_frete_rota
        FOREIGN KEY(rota_id)
        REFERENCES rota_entrega(id)

) ENGINE=InnoDB;



-- =====================================================
-- ENTREGA
-- =====================================================

CREATE TABLE entrega (

    id INT AUTO_INCREMENT PRIMARY KEY,


    pedido_id INT NOT NULL,


    frete_id INT,


    motorista_id INT,


    veiculo_id INT,


    data_saida DATETIME,


    data_prevista DATETIME,


    data_entrega DATETIME,


    status ENUM(
        'AGUARDANDO',
        'EM_TRANSITO',
        'ENTREGUE',
        'DEVOLVIDA',
        'CANCELADA'
    ) DEFAULT 'AGUARDANDO',


    observacao TEXT,



    CONSTRAINT fk_entrega_pedido
        FOREIGN KEY(pedido_id)
        REFERENCES pedido(id),


    CONSTRAINT fk_entrega_frete
        FOREIGN KEY(frete_id)
        REFERENCES frete(id),


    CONSTRAINT fk_entrega_motorista
        FOREIGN KEY(motorista_id)
        REFERENCES motorista(id),


    CONSTRAINT fk_entrega_veiculo
        FOREIGN KEY(veiculo_id)
        REFERENCES veiculo(id)

) ENGINE=InnoDB;



-- =====================================================
-- RASTREAMENTO
-- =====================================================

CREATE TABLE rastreamento (

    id INT AUTO_INCREMENT PRIMARY KEY,


    entrega_id INT NOT NULL,


    status VARCHAR(100),


    localizacao VARCHAR(200),


    latitude DECIMAL(10,7),


    longitude DECIMAL(10,7),


    data_evento DATETIME DEFAULT CURRENT_TIMESTAMP,


    observacao TEXT,



    CONSTRAINT fk_rastreamento_entrega
        FOREIGN KEY(entrega_id)
        REFERENCES entrega(id)
        ON DELETE CASCADE

) ENGINE=InnoDB;



-- =====================================================
-- OCORRENCIA ENTREGA
-- =====================================================

CREATE TABLE ocorrencia_entrega (

    id INT AUTO_INCREMENT PRIMARY KEY,


    entrega_id INT NOT NULL,


    tipo ENUM(
        'ATRASO',
        'ENDERECO_INVALIDO',
        'CLIENTE_AUSENTE',
        'AVARIA',
        'OUTROS'
    ),


    descricao TEXT,


    data_ocorrencia DATETIME DEFAULT CURRENT_TIMESTAMP,



    CONSTRAINT fk_ocorrencia_entrega
        FOREIGN KEY(entrega_id)
        REFERENCES entrega(id)

) ENGINE=InnoDB;



-- =====================================================
-- COMPROVANTE ENTREGA
-- =====================================================

CREATE TABLE comprovante_entrega (

    id INT AUTO_INCREMENT PRIMARY KEY,


    entrega_id INT NOT NULL,


    nome_recebedor VARCHAR(150),


    documento_recebedor VARCHAR(30),


    assinatura VARCHAR(255),


    foto VARCHAR(255),


    data_recebimento DATETIME,



    CONSTRAINT fk_comprovante_entrega
        FOREIGN KEY(entrega_id)
        REFERENCES entrega(id)

) ENGINE=InnoDB;