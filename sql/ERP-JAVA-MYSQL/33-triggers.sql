-- =====================================================
-- ERP JAVA MYSQL
-- Arquivo: 33-triggers.sql
-- Triggers
-- =====================================================


USE erp_java;


DELIMITER $$



-- =====================================================
-- BAIXAR ESTOQUE APÓS VENDA
-- =====================================================

CREATE TRIGGER trg_baixar_estoque_venda

AFTER INSERT ON pedido_item

FOR EACH ROW

BEGIN


UPDATE estoque

SET quantidade = quantidade - NEW.quantidade

WHERE produto_id = NEW.produto_id;


END$$





-- =====================================================
-- IMPEDIR ESTOQUE NEGATIVO
-- =====================================================

CREATE TRIGGER trg_validar_estoque

BEFORE UPDATE ON estoque

FOR EACH ROW

BEGIN


IF NEW.quantidade < 0 THEN


SIGNAL SQLSTATE '45000'

SET MESSAGE_TEXT =
'Estoque não pode ficar negativo';


END IF;


END$$





-- =====================================================
-- HISTORICO ALTERACAO PRECO
-- =====================================================

CREATE TRIGGER trg_historico_preco

AFTER UPDATE ON produto

FOR EACH ROW

BEGIN


IF OLD.preco_venda <> NEW.preco_venda THEN


INSERT INTO historico_preco

(
produto_id,

preco_anterior,

preco_novo,

data_alteracao

)

VALUES

(

NEW.id,

OLD.preco_venda,

NEW.preco_venda,

NOW()

);


END IF;


END$$





-- =====================================================
-- AUDITORIA CLIENTE INSERT
-- =====================================================

CREATE TRIGGER trg_auditoria_cliente_insert

AFTER INSERT ON cliente

FOR EACH ROW

BEGIN


INSERT INTO auditoria_log

(

tabela_nome,

registro_id,

operacao,

valor_novo,

data_evento

)

VALUES

(

'cliente',

NEW.id,

'INSERT',

CONCAT(
'Pessoa:',
NEW.pessoa_id
),

NOW()

);



END$$





-- =====================================================
-- AUDITORIA CLIENTE UPDATE
-- =====================================================

CREATE TRIGGER trg_auditoria_cliente_update

AFTER UPDATE ON cliente

FOR EACH ROW

BEGIN



INSERT INTO auditoria_log

(

tabela_nome,

registro_id,

operacao,

valor_antigo,

valor_novo

)


VALUES


(

'cliente',

NEW.id,

'UPDATE',

CONCAT(
'Limite antigo:',
OLD.limite_credito
),

CONCAT(
'Novo limite:',
NEW.limite_credito
)

);



END$$





-- =====================================================
-- DATA ALTERACAO PRODUTO
-- =====================================================

CREATE TRIGGER trg_produto_atualizacao

BEFORE UPDATE ON produto

FOR EACH ROW

BEGIN


SET NEW.updated_at = CURRENT_TIMESTAMP;


END$$





-- =====================================================
-- HISTORICO SALARIO
-- =====================================================

CREATE TRIGGER trg_historico_salario

AFTER UPDATE ON salario

FOR EACH ROW

BEGIN


IF OLD.valor <> NEW.valor THEN


INSERT INTO historico_salario

(

funcionario_id,

salario_anterior,

salario_novo,

data_alteracao,

motivo

)


VALUES


(

NEW.funcionario_id,

OLD.valor,

NEW.valor,

CURDATE(),

'Ajuste automático'

);



END IF;


END$$





-- =====================================================
-- REGISTRAR PAGAMENTO
-- =====================================================

CREATE TRIGGER trg_log_pagamento

AFTER INSERT ON pagamento

FOR EACH ROW

BEGIN


INSERT INTO auditoria_log

(

tabela_nome,

registro_id,

operacao,

valor_novo

)

VALUES

(

'pagamento',

NEW.id,

'INSERT',

CONCAT(
'Valor:',
NEW.valor
)

);


END$$





DELIMITER ;