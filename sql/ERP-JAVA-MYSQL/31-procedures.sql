-- =====================================================
-- ERP JAVA MYSQL
-- Arquivo: 31-procedures.sql
-- Procedures
-- =====================================================

USE erp_java;


DELIMITER $$



-- =====================================================
-- CADASTRAR CLIENTE
-- =====================================================

CREATE PROCEDURE sp_cadastrar_cliente

(
    IN p_pessoa_id INT,
    IN p_limite DECIMAL(12,2)
)

BEGIN


INSERT INTO cliente
(
    pessoa_id,
    data_cadastro,
    limite_credito,
    ativo
)

VALUES

(
    p_pessoa_id,
    CURRENT_DATE,
    p_limite,
    TRUE
);


END$$





-- =====================================================
-- BUSCAR VENDAS CLIENTE
-- =====================================================

CREATE PROCEDURE sp_vendas_cliente

(
    IN p_cliente_id INT
)

BEGIN


SELECT

    ped.id AS pedido,

    ped.data_pedido,

    ped.status,

    ped.valor_total


FROM pedido ped


WHERE ped.cliente_id = p_cliente_id


ORDER BY ped.data_pedido DESC;


END$$





-- =====================================================
-- ATUALIZAR ESTOQUE
-- =====================================================

CREATE PROCEDURE sp_atualizar_estoque

(

    IN p_produto_id INT,

    IN p_quantidade DECIMAL(12,3)

)

BEGIN



UPDATE estoque


SET quantidade = quantidade + p_quantidade


WHERE produto_id = p_produto_id;



END$$





-- =====================================================
-- REGISTRAR PAGAMENTO
-- =====================================================

CREATE PROCEDURE sp_registrar_pagamento

(

    IN p_pedido_id INT,

    IN p_forma_pagamento INT,

    IN p_valor DECIMAL(12,2)

)

BEGIN



INSERT INTO pagamento

(

pedido_id,

forma_pagamento_id,

data_pagamento,

valor,

status

)


VALUES


(

p_pedido_id,

p_forma_pagamento,

NOW(),

p_valor,

'APROVADO'

);



END$$





-- =====================================================
-- GERAR PARCELAS
-- =====================================================

CREATE PROCEDURE sp_gerar_parcelas

(

    IN p_pagamento_id INT,

    IN p_quantidade INT,

    IN p_valor DECIMAL(12,2),

    IN p_primeiro_vencimento DATE

)

BEGIN


DECLARE contador INT DEFAULT 1;



WHILE contador <= p_quantidade DO



INSERT INTO parcela

(

pagamento_id,

numero,

vencimento,

valor,

status

)


VALUES


(

p_pagamento_id,

contador,

DATE_ADD(
p_primeiro_vencimento,
INTERVAL contador MONTH
),

p_valor,

'ABERTA'

);



SET contador = contador + 1;



END WHILE;



END$$





-- =====================================================
-- FATURAMENTO POR PERIODO
-- =====================================================

CREATE PROCEDURE sp_faturamento_periodo

(

IN p_inicio DATE,

IN p_fim DATE

)

BEGIN



SELECT


COUNT(id) AS quantidade_vendas,


SUM(valor_total) AS faturamento



FROM pedido



WHERE data_pedido BETWEEN p_inicio AND p_fim



AND status IN

(

'PAGO',

'ENTREGUE'

);



END$$



DELIMITER ;