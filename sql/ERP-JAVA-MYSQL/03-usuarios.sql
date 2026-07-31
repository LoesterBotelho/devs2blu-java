-- =====================================================
-- ERP JAVA MYSQL
-- Arquivo: 03-usuarios.sql
-- Módulo Segurança
-- =====================================================

USE erp_java;

-- =====================================================
-- PERFIL
-- =====================================================

CREATE TABLE perfil (

    id INT AUTO_INCREMENT PRIMARY KEY,

    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(255),

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    ativo BOOLEAN DEFAULT TRUE,

    CONSTRAINT uq_perfil_nome
        UNIQUE(nome)

) ENGINE=InnoDB;

-- =====================================================
-- PERMISSAO
-- =====================================================

CREATE TABLE permissao (

    id INT AUTO_INCREMENT PRIMARY KEY,

    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(255),

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    ativo BOOLEAN DEFAULT TRUE,

    CONSTRAINT uq_permissao_nome
        UNIQUE(nome)

) ENGINE=InnoDB;

-- =====================================================
-- USUARIO
-- =====================================================

CREATE TABLE usuario (

    id INT AUTO_INCREMENT PRIMARY KEY,

    funcionario_id INT NOT NULL,

    login VARCHAR(50) NOT NULL,
    senha VARCHAR(255) NOT NULL,

    ultimo_login DATETIME,

    trocar_senha BOOLEAN DEFAULT TRUE,

    tentativas_login INT DEFAULT 0,

    bloqueado BOOLEAN DEFAULT FALSE,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    ativo BOOLEAN DEFAULT TRUE,

    CONSTRAINT fk_usuario_funcionario
        FOREIGN KEY (funcionario_id)
        REFERENCES funcionario(id),

    CONSTRAINT uq_usuario_login
        UNIQUE(login),

    CONSTRAINT uq_usuario_funcionario
        UNIQUE(funcionario_id)

) ENGINE=InnoDB;

CREATE INDEX idx_usuario_login
ON usuario(login);

-- =====================================================
-- USUARIO_PERFIL
-- =====================================================

CREATE TABLE usuario_perfil (

    usuario_id INT NOT NULL,

    perfil_id INT NOT NULL,

    PRIMARY KEY (usuario_id, perfil_id),

    CONSTRAINT fk_usuario_perfil_usuario
        FOREIGN KEY (usuario_id)
        REFERENCES usuario(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_usuario_perfil_perfil
        FOREIGN KEY (perfil_id)
        REFERENCES perfil(id)
        ON DELETE CASCADE

) ENGINE=InnoDB;

-- =====================================================
-- PERFIL_PERMISSAO
-- =====================================================

CREATE TABLE perfil_permissao (

    perfil_id INT NOT NULL,

    permissao_id INT NOT NULL,

    PRIMARY KEY (perfil_id, permissao_id),

    CONSTRAINT fk_perfil_permissao_perfil
        FOREIGN KEY (perfil_id)
        REFERENCES perfil(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_perfil_permissao_permissao
        FOREIGN KEY (permissao_id)
        REFERENCES permissao(id)
        ON DELETE CASCADE

) ENGINE=InnoDB;

-- =====================================================
-- SESSAO_USUARIO
-- =====================================================

CREATE TABLE sessao_usuario (

    id INT AUTO_INCREMENT PRIMARY KEY,

    usuario_id INT NOT NULL,

    token VARCHAR(255) NOT NULL,

    ip VARCHAR(45),

    navegador VARCHAR(150),

    sistema_operacional VARCHAR(100),

    data_login DATETIME NOT NULL,

    data_logout DATETIME,

    ativa BOOLEAN DEFAULT TRUE,

    CONSTRAINT fk_sessao_usuario
        FOREIGN KEY (usuario_id)
        REFERENCES usuario(id)
        ON DELETE CASCADE

) ENGINE=InnoDB;

CREATE INDEX idx_sessao_token
ON sessao_usuario(token);

-- =====================================================
-- TOKEN_RECUPERACAO
-- =====================================================

CREATE TABLE token_recuperacao (

    id INT AUTO_INCREMENT PRIMARY KEY,

    usuario_id INT NOT NULL,

    token VARCHAR(255) NOT NULL,

    data_expiracao DATETIME NOT NULL,

    utilizado BOOLEAN DEFAULT FALSE,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_token_usuario
        FOREIGN KEY (usuario_id)
        REFERENCES usuario(id)
        ON DELETE CASCADE

) ENGINE=InnoDB;

CREATE INDEX idx_token_recuperacao
ON token_recuperacao(token);

-- =====================================================
-- HISTORICO_LOGIN
-- =====================================================

CREATE TABLE historico_login (

    id INT AUTO_INCREMENT PRIMARY KEY,

    usuario_id INT NOT NULL,

    data_hora DATETIME NOT NULL,

    ip VARCHAR(45),

    sucesso BOOLEAN,

    motivo VARCHAR(255),

    CONSTRAINT fk_historico_login_usuario
        FOREIGN KEY (usuario_id)
        REFERENCES usuario(id)
        ON DELETE CASCADE

) ENGINE=InnoDB;

CREATE INDEX idx_historico_data
ON historico_login(data_hora);