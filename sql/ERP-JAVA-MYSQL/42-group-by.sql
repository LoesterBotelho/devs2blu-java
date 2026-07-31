-- =====================================================
-- ERP JAVA MYSQL
-- Arquivo: 42-group-by.sql
-- GROUP BY / HAVING
-- =====================================================

USE erp_java;



-- =====================================================
-- 1 - QUANTIDADE DE CLIENTES
-- =====================================================

SELECT

COUNT(*) AS total_clientes

FROM cliente;



-- =====================================================
-- 2 - CLIENTES POR ESTADO
-- =====================================================

SELECT

e.estado,

COUNT(*) AS quantidade


FROM cliente c


JOIN pessoa p

ON p.id=c.pessoa_id


JOIN endereco e

ON e.pessoa_id=p.id


GROUP BY e.estado;



-- =====================================================
-- 3 - PRODUTOS POR CATEGORIA
-- =====================================================

SELECT


c.nome AS categoria,


COUNT(p.id) AS quantidade_produtos



FROM categoria c


LEFT JOIN produto p

ON p.categoria_id=c.id


GROUP BY c.nome;



-- =====================================================
-- 4 - VALOR TOTAL DO ESTOQUE
-- =====================================================

SELECT


SUM(

e.quantidade * p.preco_venda

)

AS valor_estoque



FROM estoque e


JOIN produto p

ON p.id=e.produto_id;



-- =====================================================
-- 5 - ESTOQUE POR CATEGORIA
-- =====================================================

SELECT


c.nome,


SUM(e.quantidade)

AS quantidade



FROM categoria c


JOIN produto p

ON p.categoria_id=c.id


JOIN estoque e

ON e.produto_id=p.id


GROUP BY c.nome;



-- =====================================================
-- 6 - VENDAS POR CLIENTE
-- =====================================================

SELECT


pe.nome,


COUNT(ped.id)

AS quantidade_pedidos,


SUM(ped.valor_total)

AS total_comprado



FROM cliente c


JOIN pessoa pe

ON pe.id=c.pessoa_id


JOIN pedido ped

ON ped.cliente_id=c.id



GROUP BY pe.nome;



-- =====================================================
-- 7 - CLIENTES QUE COMPRARAM MAIS DE 5000
-- HAVING
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



HAVING total > 5000;



-- =====================================================
-- 8 - PRODUTOS MAIS VENDIDOS
-- =====================================================

SELECT


p.nome,


SUM(pi.quantidade)

AS vendidos



FROM produto p


JOIN pedido_item pi

ON pi.produto_id=p.id



GROUP BY p.nome


ORDER BY vendidos DESC;



-- =====================================================
-- 9 - FATURAMENTO POR STATUS
-- =====================================================

SELECT


status,


COUNT(*) quantidade,


SUM(valor_total) total



FROM pedido



GROUP BY status;



-- =====================================================
-- 10 - FATURAMENTO MENSAL
-- =====================================================

SELECT


YEAR(data_pedido) ano,


MONTH(data_pedido) mes,


SUM(valor_total) faturamento



FROM pedido



GROUP BY


YEAR(data_pedido),


MONTH(data_pedido);



-- =====================================================
-- 11 - MÉDIA DAS VENDAS
-- =====================================================

SELECT


AVG(valor_total)

AS ticket_medio



FROM pedido;



-- =====================================================
-- 12 - MAIOR VENDA
-- =====================================================

SELECT


MAX(valor_total)

AS maior_venda



FROM pedido;



-- =====================================================
-- 13 - MENOR VENDA
-- =====================================================

SELECT


MIN(valor_total)

AS menor_venda



FROM pedido;



-- =====================================================
-- 14 - VENDAS POR FORMA PAGAMENTO
-- =====================================================

SELECT


fp.nome,


COUNT(pg.id),


SUM(pg.valor)



FROM pagamento pg


JOIN forma_pagamento fp

ON fp.id=pg.forma_pagamento_id



GROUP BY fp.nome;



-- =====================================================
-- 15 - CONTAS A RECEBER POR STATUS
-- =====================================================

SELECT


status,


COUNT(*) quantidade,


SUM(valor) total



FROM conta_receber



GROUP BY status;



-- =====================================================
-- 16 - CONTAS A PAGAR POR FORNECEDOR
-- =====================================================

SELECT


pe.nome,


SUM(cp.valor)



FROM conta_pagar cp


JOIN fornecedor f

ON f.id=cp.fornecedor_id


JOIN pessoa pe

ON pe.id=f.pessoa_id



GROUP BY pe.nome;



-- =====================================================
-- 17 - NOTA MÉDIA DOS PRODUTOS
-- =====================================================

SELECT


p.nome,


AVG(a.nota) media



FROM produto p


JOIN avaliacao_produto a

ON a.produto_id=p.id



GROUP BY p.nome;



-- =====================================================
-- 18 - PRODUTOS COM MÉDIA MAIOR QUE 4
-- =====================================================

SELECT


p.nome,


AVG(a.nota) media



FROM produto p


JOIN avaliacao_produto a

ON a.produto_id=p.id



GROUP BY p.nome



HAVING media >=4;



-- =====================================================
-- 19 - COMISSÃO POR VENDEDOR
-- =====================================================

SELECT


vendedor_id,


SUM(valor)

AS total_comissao



FROM comissao_venda



GROUP BY vendedor_id;



-- =====================================================
-- 20 - RESUMO FINANCEIRO
-- =====================================================

SELECT


'RECEBER' tipo,


SUM(valor) total



FROM conta_receber



UNION ALL



SELECT


'PAGAR',


SUM(valor)



FROM conta_pagar;
