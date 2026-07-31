-- =====================================================
-- ERP JAVA MYSQL
-- Arquivo: 32-functions.sql
-- Functions
-- =====================================================


USE erp_java;


DELIMITER $$



-- =====================================================
-- CALCULAR DESCONTO PERCENTUAL
-- =====================================================

CREATE FUNCTION fn_calcular_desconto

(
    valor DECIMAL(12,2),
    percentual DECIMAL(5,2)
)

RETURNS DECIMAL(12,2)

DETERMINISTIC

BEGIN


RETURN valor -
(
    valor * percentual / 100
);


END$$





-- =====================================================
-- CALCULAR IMPOSTO
-- =====================================================

CREATE FUNCTION fn_calcular_imposto

(

    valor DECIMAL(12,2),

    aliquota DECIMAL(5,2)

)

RETURNS DECIMAL(12,2)


DETERMINISTIC


BEGIN


RETURN

(
valor * aliquota / 100
);


END$$





-- =====================================================
-- CALCULAR IDADE
-- =====================================================

CREATE FUNCTION fn_calcular_idade

(

    nascimento DATE

)

RETURNS INT


DETERMINISTIC


BEGIN



RETURN TIMESTAMPDIFF

(

YEAR,

nascimento,

CURDATE()

);



END$$





-- =====================================================
-- CALCULAR COMISSAO
-- =====================================================

CREATE FUNCTION fn_calcular_comissao

(

valor_venda DECIMAL(12,2),

percentual DECIMAL(5,2)

)

RETURNS DECIMAL(12,2)


DETERMINISTIC


BEGIN



RETURN

(
valor_venda * percentual / 100
);



END$$





-- =====================================================
-- CALCULAR MARGEM LUCRO
-- =====================================================

CREATE FUNCTION fn_calcular_margem

(

preco_venda DECIMAL(12,2),

preco_custo DECIMAL(12,2)

)

RETURNS DECIMAL(12,2)


DETERMINISTIC


BEGIN



RETURN

(

((preco_venda - preco_custo)
/ preco_venda)
*100

);



END$$





-- =====================================================
-- DIAS DE ATRASO
-- =====================================================

CREATE FUNCTION fn_dias_atraso

(

vencimento DATE

)

RETURNS INT


DETERMINISTIC


BEGIN



IF vencimento >= CURDATE()

THEN


RETURN 0;


ELSE


RETURN DATEDIFF
(
CURDATE(),
vencimento
);


END IF;



END$$





-- =====================================================
-- VALOR FINAL VENDA
-- =====================================================

CREATE FUNCTION fn_valor_final_venda

(

valor_produto DECIMAL(12,2),

desconto DECIMAL(12,2),

frete DECIMAL(12,2)

)

RETURNS DECIMAL(12,2)


DETERMINISTIC


BEGIN



RETURN

(
valor_produto
-
desconto
+
frete
);



END$$





DELIMITER ;