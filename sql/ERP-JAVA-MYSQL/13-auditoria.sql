-- =====================================================
-- ERP JAVA MYSQL
-- Arquivo: 13-auditoria.sql
-- Módulo Auditoria
-- =====================================================

USE erp_java;



-- =====================================================
-- ACAO SISTEMA
-- =====================================================

CREATE TABLE acao_sistema (

    id INT AUTO_INCREMENT PRIMARY KEY,


    nome VARCHAR(100) NOT NULL,


    descricao TEXT,


    ativo BOOLEAN DEFAULT TRUE,


    CONSTRAINT uq_acao_nome
        UNIQUE(nome)

) ENGINE=InnoDB;



-- =====================================================
-- AUDITORIA LOG
-- Guarda alterações realizadas
-- =====================================================

CREATE TABLE auditoria_log (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,


    usuario_id INT,


    acao_id INT,


    tabela_nome VARCHAR(100),


    registro_id INT,


    operacao ENUM(
        'INSERT',
        'UPDATE',
        'DELETE'
    ),


    valor_antigo TEXT,


    valor_novo TEXT,


    ip_usuario VARCHAR(50),


    data_evento DATETIME DEFAULT CURRENT_TIMESTAMP,



    CONSTRAINT fk_auditoria_usuario
        FOREIGN KEY(usuario_id)
        REFERENCES usuario(id),


    CONSTRAINT fk_auditoria_acao
        FOREIGN KEY(acao_id)
        REFERENCES acao_sistema(id)

) ENGINE=InnoDB;



CREATE INDEX idx_auditoria_data
ON auditoria_log(data_evento);



CREATE INDEX idx_auditoria_tabela
ON auditoria_log(tabela_nome);



-- =====================================================
-- LOGIN USUARIO
-- =====================================================

CREATE TABLE login_usuario (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,


    usuario_id INT NOT NULL,


    data_login DATETIME DEFAULT CURRENT_TIMESTAMP,


    data_logout DATETIME,


    ip VARCHAR(50),


    navegador VARCHAR(200),


    sistema_operacional VARCHAR(100),


    sucesso BOOLEAN DEFAULT TRUE,



    CONSTRAINT fk_login_usuario
        FOREIGN KEY(usuario_id)
        REFERENCES usuario(id)

) ENGINE=InnoDB;



-- =====================================================
-- SESSAO USUARIO
-- =====================================================

CREATE TABLE sessao_usuario (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,


    usuario_id INT NOT NULL,


    token VARCHAR(255),


    inicio DATETIME DEFAULT CURRENT_TIMESTAMP,


    fim DATETIME,


    ativo BOOLEAN DEFAULT TRUE,



    CONSTRAINT fk_sessao_usuario
        FOREIGN KEY(usuario_id)
        REFERENCES usuario(id),


    CONSTRAINT uq_token
        UNIQUE(token)

) ENGINE=InnoDB;



-- =====================================================
-- ERRO SISTEMA
-- =====================================================

CREATE TABLE erro_sistema (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,


    usuario_id INT,


    modulo VARCHAR(100),


    mensagem TEXT,


    stacktrace LONGTEXT,


    data_erro DATETIME DEFAULT CURRENT_TIMESTAMP,


    resolvido BOOLEAN DEFAULT FALSE,



    CONSTRAINT fk_erro_usuario
        FOREIGN KEY(usuario_id)
        REFERENCES usuario(id)

) ENGINE=InnoDB;



-- =====================================================
-- CONFIGURACAO SISTEMA
-- =====================================================

CREATE TABLE configuracao_sistema (

    id INT AUTO_INCREMENT PRIMARY KEY,


    chave VARCHAR(100) NOT NULL,


    valor TEXT,


    descricao TEXT,


    tipo VARCHAR(50),


    ativo BOOLEAN DEFAULT TRUE,


    CONSTRAINT uq_config_chave
        UNIQUE(chave)

) ENGINE=InnoDB;



-- =====================================================
-- ACESSO MODULO
-- =====================================================

CREATE TABLE acesso_modulo (

    id INT AUTO_INCREMENT PRIMARY KEY,


    usuario_id INT NOT NULL,


    modulo VARCHAR(100),


    permissao ENUM(
        'CONSULTAR',
        'INSERIR',
        'ALTERAR',
        'EXCLUIR'
    ),


    data_liberacao DATETIME DEFAULT CURRENT_TIMESTAMP,



    CONSTRAINT fk_acesso_usuario
        FOREIGN KEY(usuario_id)
        REFERENCES usuario(id)

) ENGINE=InnoDB;



-- =====================================================
-- BACKUP LOG
-- =====================================================

CREATE TABLE backup_log (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,


    usuario_id INT,


    nome_arquivo VARCHAR(255),


    tamanho BIGINT,


    data_backup DATETIME DEFAULT CURRENT_TIMESTAMP,


    status ENUM(
        'INICIADO',
        'FINALIZADO',
        'ERRO'
    ),



    CONSTRAINT fk_backup_usuario
        FOREIGN KEY(usuario_id)
        REFERENCES usuario(id)

) ENGINE=InnoDB;



-- =====================================================
-- API LOG
-- =====================================================

CREATE TABLE api_log (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,


    usuario_id INT,


    endpoint VARCHAR(255),


    metodo VARCHAR(20),


    status_http INT,


    tempo_execucao INT,


    data_requisicao DATETIME DEFAULT CURRENT_TIMESTAMP,



    CONSTRAINT fk_api_usuario
        FOREIGN KEY(usuario_id)
        REFERENCES usuario(id)

) ENGINE=InnoDB;