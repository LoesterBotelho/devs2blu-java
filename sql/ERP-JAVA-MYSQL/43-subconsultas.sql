-- =====================================================
-- ERP JAVA MYSQL
-- Arquivo: 43-subconsultas.sql
-- Subconsultas
-- =====================================================

USE erp_java;



-- =====================================================
-- 1 - PRODUTOS ACIMA DA MÉDIA DE PREÇO
-- =====================================================

SELECT

nome,

preco_venda


FROM produto


WHERE preco_venda >

(
    SELECT AVG(preco_venda)

    FROM produto
);



-- =====================================================
-- 2 - PRODUTO MAIS CARO
-- =====================================================

SELECT


nome,


preco_venda



FROM produto



WHERE preco_venda =

(

SELECT MAX(preco_venda)

FROM produto

);



-- =====================================================
-- 3 - CLIENTES QUE JÁ COMPRARAM
-- IN
-- =====================================================

SELECT


p.nome



FROM pessoa p


JOIN cliente c

ON c.pessoa_id=p.id



WHERE c.id IN

(

SELECT cliente_id

FROM pedido

);



-- =====================================================
-- 4 - CLIENTES SEM COMPRA
-- NOT IN
-- =====================================================

SELECT


p.nome



FROM pessoa p


JOIN cliente c

ON c.pessoa_id=p.id



WHERE c.id NOT IN

(

SELECT cliente_id

FROM pedido

);



-- =====================================================
-- 5 - PRODUTOS QUE FORAM VENDIDOS
-- =====================================================

SELECT


nome



FROM produto



WHERE id IN

(

SELECT produto_id

FROM pedido_item

);



-- =====================================================
-- 6 - PRODUTOS NUNCA VENDIDOS
-- =====================================================

SELECT


nome



FROM produto



WHERE id NOT IN

(

SELECT produto_id

FROM pedido_item

);



-- =====================================================
-- 7 - CLIENTES COM VALOR ACIMA DA MÉDIA
-- =====================================================

SELECT


pe.nome,


SUM(ped.valor_total)

AS total



FROM cliente c


JOIN pessoa pe

ON pe.id=c.pessoa_id


JOIN pedido ped

ON ped.cliente_id=c.id



GROUP BY pe.nome



HAVING total >

(

SELECT AVG(valor_total)

FROM pedido

);



-- =====================================================
-- 8 - PEDIDOS MAIORES QUE O MAIOR DESCONTO
-- =====================================================

SELECT


id,


valor_total



FROM pedido



WHERE valor_total >

(

SELECT MAX(valor_desconto)

FROM pedido

);



-- =====================================================
-- 9 - FORNECEDORES COM PRODUTOS
-- EXISTS
-- =====================================================

SELECT


pe.nome



FROM fornecedor f


JOIN pessoa pe

ON pe.id=f.pessoa_id



WHERE EXISTS

(

SELECT 1

FROM fornecedor_produto fp

WHERE fp.fornecedor_id=f.id

);



-- =====================================================
-- 10 - FORNECEDORES SEM PRODUTOS
-- NOT EXISTS
-- =====================================================

SELECT


pe.nome



FROM fornecedor f


JOIN pessoa pe

ON pe.id=f.pessoa_id



WHERE NOT EXISTS

(

SELECT 1

FROM fornecedor_produto fp

WHERE fp.fornecedor_id=f.id

);



-- =====================================================
-- 11 - ÚLTIMA VENDA DE CADA CLIENTE
-- =====================================================

SELECT


pe.nome,


(

SELECT MAX(data_pedido)

FROM pedido ped

WHERE ped.cliente_id=c.id

)

AS ultima_compra



FROM cliente c


JOIN pessoa pe

ON pe.id=c.pessoa_id;



-- =====================================================
-- 12 - QUANTIDADE DE VENDAS POR CLIENTE
-- SUBQUERY NO SELECT
-- =====================================================

SELECT


pe.nome,


(

SELECT COUNT(*)

FROM pedido ped

WHERE ped.cliente_id=c.id

)

AS quantidade_compras



FROM cliente c


JOIN pessoa pe

ON pe.id=c.pessoa_id;



-- =====================================================
-- 13 - TOTAL COMPRADO PELO CLIENTE
-- =====================================================

SELECT


pe.nome,


(

SELECT SUM(valor_total)

FROM pedido ped

WHERE ped.cliente_id=c.id

)

AS total_gasto



FROM cliente c


JOIN pessoa pe

ON pe.id=c.pessoa_id;



-- =====================================================
-- 14 - FUNCIONARIOS ACIMA DO SALÁRIO MÉDIO
-- =====================================================

SELECT


p.nome,


f.salario



FROM funcionario f


JOIN pessoa p

ON p.id=f.pessoa_id



WHERE f.salario >

(

SELECT AVG(salario)

FROM funcionario

);



-- =====================================================
-- 15 - PRODUTOS MAIS CAROS DA CATEGORIA
-- =====================================================

SELECT


p.nome,


p.preco_venda,


p.categoria_id



FROM produto p



WHERE preco_venda =

(

SELECT MAX(p2.preco_venda)

FROM produto p2

WHERE p2.categoria_id=p.categoria_id

);



-- =====================================================
-- 16 - CLIENTES COM PAGAMENTO APROVADO
-- =====================================================

SELECT


pe.nome



FROM pessoa pe


JOIN cliente c

ON c.pessoa_id=pe.id



WHERE EXISTS

(

SELECT 1

FROM pedido ped

JOIN pagamento pg

ON pg.pedido_id=ped.id

WHERE ped.cliente_id=c.id

AND pg.status='APROVADO'

);



-- =====================================================
-- 17 - PRODUTOS COM ESTOQUE ABAIXO DA MÉDIA
-- =====================================================

SELECT


p.nome,


e.quantidade



FROM produto p


JOIN estoque e

ON e.produto_id=p.id



WHERE e.quantidade <

(

SELECT AVG(quantidade)

FROM estoque

);



-- =====================================================
-- 18 - PEDIDOS DO MAIOR CLIENTE
-- =====================================================

SELECT *


FROM pedido



WHERE cliente_id =

(

SELECT cliente_id

FROM pedido

GROUP BY cliente_id

ORDER BY SUM(valor_total) DESC

LIMIT 1

);



-- =====================================================
-- 19 - CLIENTE QUE MAIS COMPROU
-- =====================================================

SELECT


pe.nome,


SUM(ped.valor_total) total



FROM pessoa pe


JOIN cliente c

ON c.pessoa_id=pe.id


JOIN pedido ped

ON ped.cliente_id=c.id



GROUP BY pe.nome



ORDER BY total DESC



LIMIT 1;



-- =====================================================
-- 20 - PRODUTOS COM VENDA SUPERIOR A 1 UNIDADE
-- =====================================================

SELECT


p.nome



FROM produto p



WHERE

(

SELECT SUM(quantidade)

FROM pedido_item pi

WHERE pi.produto_id=p.id

) > 1;
