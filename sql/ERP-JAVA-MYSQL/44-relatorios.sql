-- =====================================================
-- ERP JAVA MYSQL
-- Arquivo: 44-relatorios.sql
-- Relatórios ERP
-- =====================================================

USE erp_java;



-- =====================================================
-- 1 - DASHBOARD GERAL
-- =====================================================

SELECT

(SELECT COUNT(*) FROM cliente)
AS total_clientes,


(SELECT COUNT(*) FROM produto)
AS total_produtos,


(SELECT COUNT(*) FROM pedido)
AS total_pedidos,


(SELECT SUM(valor_total)
 FROM pedido
 WHERE status IN ('PAGO','ENTREGUE'))
AS faturamento;



-- =====================================================
-- 2 - RELATÓRIO VENDA COMPLETA
-- =====================================================

SELECT


ped.id AS pedido,


pe.nome AS cliente,


prod.nome AS produto,


pi.quantidade,


pi.valor_unitario,


pi.valor_total,


ped.status,


ped.data_pedido



FROM pedido ped


JOIN cliente c

ON c.id=ped.cliente_id


JOIN pessoa pe

ON pe.id=c.pessoa_id


JOIN pedido_item pi

ON pi.pedido_id=ped.id


JOIN produto prod

ON prod.id=pi.produto_id;




-- =====================================================
-- 3 - RANKING CLIENTES
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



GROUP BY pe.nome


ORDER BY total_comprado DESC;




-- =====================================================
-- 4 - RANKING PRODUTOS VENDIDOS
-- =====================================================

SELECT


p.nome,


SUM(pi.quantidade)
AS quantidade_vendida,


SUM(pi.valor_total)
AS faturamento



FROM produto p


JOIN pedido_item pi

ON pi.produto_id=p.id



GROUP BY p.nome


ORDER BY quantidade_vendida DESC;




-- =====================================================
-- 5 - FATURAMENTO POR MÊS
-- =====================================================

SELECT


YEAR(data_pedido)
AS ano,


MONTH(data_pedido)
AS mes,


SUM(valor_total)
AS faturamento



FROM pedido


WHERE status IN
(
'PAGO',
'ENTREGUE'
)



GROUP BY


YEAR(data_pedido),


MONTH(data_pedido)



ORDER BY ano,mes;




-- =====================================================
-- 6 - LUCRO POR PRODUTO
-- =====================================================

SELECT


p.nome,


p.preco_venda,


p.preco_custo,


(p.preco_venda-p.preco_custo)
AS lucro_unitario,


SUM(pi.quantidade)
AS vendidos,


SUM(
(pi.valor_total) -
(pi.quantidade*p.preco_custo)
)

AS lucro_total



FROM produto p


JOIN pedido_item pi

ON pi.produto_id=p.id



GROUP BY p.nome,
p.preco_venda,
p.preco_custo;



-- =====================================================
-- 7 - ESTOQUE CRÍTICO
-- =====================================================

SELECT


p.nome,


e.quantidade



FROM produto p


JOIN estoque e

ON e.produto_id=p.id



WHERE e.quantidade <= 5



ORDER BY e.quantidade;



-- =====================================================
-- 8 - CONTAS A RECEBER ABERTAS
-- =====================================================

SELECT


pe.nome,


cr.descricao,


cr.valor,


cr.vencimento,


DATEDIFF(
CURDATE(),
cr.vencimento
)

AS dias_atraso



FROM conta_receber cr


JOIN cliente c

ON c.id=cr.cliente_id


JOIN pessoa pe

ON pe.id=c.pessoa_id



WHERE cr.status <> 'PAGA';




-- =====================================================
-- 9 - CONTAS A PAGAR
-- =====================================================

SELECT


pe.nome AS fornecedor,


cp.descricao,


cp.valor,


cp.status



FROM conta_pagar cp


JOIN fornecedor f

ON f.id=cp.fornecedor_id


JOIN pessoa pe

ON pe.id=f.pessoa_id;



-- =====================================================
-- 10 - FLUXO DE CAIXA
-- =====================================================

SELECT


'ENTRADA'
AS tipo,


SUM(valor)
AS total



FROM movimento_caixa


WHERE tipo='ENTRADA'



UNION ALL



SELECT


'SAIDA',


SUM(valor)



FROM movimento_caixa


WHERE tipo='SAIDA';




-- =====================================================
-- 11 - PRODUTOS MAIS RENTÁVEIS
-- =====================================================

SELECT


p.nome,


SUM(
(pi.valor_total) -
(pi.quantidade*p.preco_custo)
)

AS lucro



FROM produto p


JOIN pedido_item pi

ON pi.produto_id=p.id



GROUP BY p.nome



ORDER BY lucro DESC;




-- =====================================================
-- 12 - CLIENTES INADIMPLENTES
-- =====================================================

SELECT


pe.nome,


SUM(cr.valor)
AS divida



FROM cliente c


JOIN pessoa pe

ON pe.id=c.pessoa_id


JOIN conta_receber cr

ON cr.cliente_id=c.id



WHERE cr.status IN
(
'ATRASADA',
'ABERTA'
)



GROUP BY pe.nome;




-- =====================================================
-- 13 - AVALIAÇÃO DOS PRODUTOS
-- =====================================================

SELECT


p.nome,


AVG(a.nota)
AS media,


COUNT(a.id)
AS quantidade_avaliacoes



FROM produto p


JOIN avaliacao_produto a

ON a.produto_id=p.id



GROUP BY p.nome



ORDER BY media DESC;




-- =====================================================
-- 14 - FUNCIONÁRIOS E SALÁRIOS
-- =====================================================

SELECT


p.nome,


f.matricula,


f.salario



FROM funcionario f


JOIN pessoa p

ON p.id=f.pessoa_id



ORDER BY f.salario DESC;




-- =====================================================
-- 15 - RESUMO RH
-- =====================================================

SELECT


COUNT(*) 
AS funcionarios,


AVG(salario)
AS salario_medio,


MAX(salario)
AS maior_salario,


MIN(salario)
AS menor_salario



FROM funcionario;



-- =====================================================
-- 16 - PRODUTOS POR MARCA
-- =====================================================

SELECT


m.nome AS marca,


COUNT(p.id)
AS quantidade



FROM marca m


LEFT JOIN produto p

ON p.marca_id=m.id



GROUP BY m.nome;




-- =====================================================
-- 17 - VENDA POR FORMA PAGAMENTO
-- =====================================================

SELECT


fp.nome,


COUNT(pg.id)
AS quantidade,


SUM(pg.valor)
AS total



FROM pagamento pg


JOIN forma_pagamento fp

ON fp.id=pg.forma_pagamento_id



GROUP BY fp.nome;



-- =====================================================
-- 18 - ÚLTIMAS VENDAS
-- =====================================================

SELECT *


FROM pedido


ORDER BY data_pedido DESC


LIMIT 10;



-- =====================================================
-- 19 - CLIENTES VIP
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
-- 20 - RELATÓRIO FINAL ERP
-- =====================================================

SELECT


pe.nome AS cliente,


COUNT(ped.id)
AS compras,


SUM(ped.valor_total)
AS gasto,


MAX(ped.data_pedido)
AS ultima_compra



FROM cliente c


JOIN pessoa pe

ON pe.id=c.pessoa_id


LEFT JOIN pedido ped

ON ped.cliente_id=c.id



GROUP BY pe.nome;


