-- =====================================================
-- ERP JAVA MYSQL
-- Arquivo: 40-consultas-basicas.sql
-- Consultas Básicas
-- =====================================================

USE erp_java;



-- =====================================================
-- 1 - LISTAR TODOS OS CLIENTES
-- =====================================================

SELECT *

FROM cliente;



-- =====================================================
-- 2 - CLIENTES ATIVOS
-- =====================================================

SELECT *

FROM cliente

WHERE ativo = TRUE;



-- =====================================================
-- 3 - PRODUTOS ACIMA DE 1000 REAIS
-- =====================================================

SELECT

nome,

preco_venda

FROM produto

WHERE preco_venda > 1000;



-- =====================================================
-- 4 - PRODUTOS ENTRE 100 E 1000
-- =====================================================

SELECT

nome,

preco_venda

FROM produto

WHERE preco_venda

BETWEEN 100 AND 1000;



-- =====================================================
-- 5 - PRODUTOS POR NOME
-- =====================================================

SELECT *

FROM produto

WHERE nome LIKE '%Samsung%';



-- =====================================================
-- 6 - CLIENTES DE ALGUMAS CIDADES
-- =====================================================

SELECT

p.nome,

e.cidade

FROM pessoa p


JOIN endereco e

ON e.pessoa_id = p.id


WHERE e.cidade

IN
(
'São Paulo',
'Joinville',
'Curitiba'
);



-- =====================================================
-- 7 - ORDENAR PRODUTOS MAIS CAROS
-- =====================================================

SELECT

nome,

preco_venda

FROM produto

ORDER BY preco_venda DESC;



-- =====================================================
-- 8 - PRODUTOS MAIS BARATOS
-- =====================================================

SELECT

nome,

preco_venda

FROM produto

ORDER BY preco_venda ASC;



-- =====================================================
-- 9 - OS 5 PRODUTOS MAIS CAROS
-- =====================================================

SELECT

nome,

preco_venda

FROM produto

ORDER BY preco_venda DESC

LIMIT 5;



-- =====================================================
-- 10 - CONTAR PRODUTOS
-- =====================================================

SELECT

COUNT(*) quantidade

FROM produto;



-- =====================================================
-- 11 - SOMAR VALOR DOS PRODUTOS
-- =====================================================

SELECT

SUM(preco_venda)

AS valor_total

FROM produto;



-- =====================================================
-- 12 - MÉDIA DOS PRODUTOS
-- =====================================================

SELECT

AVG(preco_venda)

AS media

FROM produto;



-- =====================================================
-- 13 - MAIOR E MENOR PREÇO
-- =====================================================

SELECT

MAX(preco_venda)
AS maior_preco,


MIN(preco_venda)
AS menor_preco


FROM produto;



-- =====================================================
-- 14 - CASE WHEN
-- Classificação preço
-- =====================================================

SELECT


nome,


preco_venda,


CASE


WHEN preco_venda < 500

THEN 'BARATO'


WHEN preco_venda BETWEEN 500 AND 2000

THEN 'MEDIO'


ELSE 'CARO'


END

AS classificacao



FROM produto;



-- =====================================================
-- 15 - PEDIDOS POR STATUS
-- =====================================================

SELECT *

FROM pedido

WHERE status = 'ENTREGUE';



-- =====================================================
-- 16 - VENDAS EM DETERMINADO PERÍODO
-- =====================================================

SELECT *

FROM pedido

WHERE data_pedido

BETWEEN

'2026-01-01'

AND

'2026-12-31';



-- =====================================================
-- 17 - CONTAS ATRASADAS
-- =====================================================

SELECT

descricao,

valor,

vencimento


FROM conta_receber


WHERE status='ATRASADA';



-- =====================================================
-- 18 - FUNCIONARIOS POR SALÁRIO
-- =====================================================

SELECT

*

FROM funcionario


WHERE salario > 4000;



-- =====================================================
-- 19 - PRODUTOS SEM ESTOQUE
-- =====================================================

SELECT

p.nome,


e.quantidade


FROM produto p


JOIN estoque e

ON e.produto_id=p.id


WHERE e.quantidade <= 0;



-- =====================================================
-- 20 - BUSCA MULTICAMPO
-- =====================================================

SELECT *

FROM produto


WHERE

nome LIKE '%Dell%'

OR

nome LIKE '%Samsung%';
