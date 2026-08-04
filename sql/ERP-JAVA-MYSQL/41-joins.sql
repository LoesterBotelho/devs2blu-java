-- =====================================================
-- ERP JAVA MYSQL
-- Arquivo: 41-joins.sql
-- Consultas JOIN
-- =====================================================

USE erp_java;



-- =====================================================
-- 1 - CLIENTE + PESSOA
-- INNER JOIN
-- =====================================================

SELECT

c.id AS cliente_id,

p.nome,

p.cpf,

c.limite_credito


FROM cliente c


INNER JOIN pessoa p

ON p.id = c.pessoa_id;



-- =====================================================
-- 2 - CLIENTE + ENDEREÇO
-- =====================================================

SELECT

p.nome,

e.logradouro,

e.cidade,

e.estado


FROM pessoa p


INNER JOIN endereco e

ON e.pessoa_id = p.id;



-- =====================================================
-- 3 - PRODUTO + MARCA
-- =====================================================

SELECT

p.nome AS produto,

m.nome AS marca


FROM produto p


INNER JOIN marca m

ON m.id = p.marca_id;



-- =====================================================
-- 4 - PRODUTO + CATEGORIA
-- =====================================================

SELECT

p.nome,

c.nome AS categoria


FROM produto p


INNER JOIN categoria c

ON c.id=p.categoria_id;



-- =====================================================
-- 5 - PRODUTO COMPLETO
-- 4 TABELAS
-- =====================================================

SELECT


p.nome AS produto,


m.nome AS marca,


c.nome AS categoria,


f.nome AS fabricante,


p.preco_venda



FROM produto p


JOIN marca m

ON m.id=p.marca_id


JOIN fabricante f

ON f.id=m.fabricante_id


JOIN categoria c

ON c.id=p.categoria_id;



-- =====================================================
-- 6 - PEDIDO + CLIENTE
-- =====================================================

SELECT


ped.id AS pedido,


pe.nome AS cliente,


ped.data_pedido,


ped.valor_total



FROM pedido ped


JOIN cliente c

ON c.id=ped.cliente_id


JOIN pessoa pe

ON pe.id=c.pessoa_id;



-- =====================================================
-- 7 - VENDA COMPLETA
-- 5 TABELAS
-- =====================================================

SELECT


ped.id AS pedido,


cliente.nome AS cliente,


prod.nome AS produto,


pi.quantidade,


pi.valor_total



FROM pedido ped


JOIN cliente cli

ON cli.id=ped.cliente_id


JOIN pessoa cliente

ON cliente.id=cli.pessoa_id


JOIN pedido_item pi

ON pi.pedido_id=ped.id


JOIN produto prod

ON prod.id=pi.produto_id;




-- =====================================================
-- 8 - PEDIDO + PAGAMENTO
-- =====================================================

SELECT


ped.id,


ped.valor_total,


pg.valor,


fp.nome AS forma_pagamento


FROM pedido ped


JOIN pagamento pg

ON pg.pedido_id=ped.id


JOIN forma_pagamento fp

ON fp.id=pg.forma_pagamento_id;




-- =====================================================
-- 9 - CLIENTES SEM PEDIDO
-- LEFT JOIN
-- =====================================================

SELECT


pe.nome


FROM cliente c


JOIN pessoa pe

ON pe.id=c.pessoa_id


LEFT JOIN pedido p

ON p.cliente_id=c.id


WHERE p.id IS NULL;



-- =====================================================
-- 10 - PRODUTOS SEM ESTOQUE
-- LEFT JOIN
-- =====================================================

SELECT


p.nome,


e.quantidade



FROM produto p


LEFT JOIN estoque e

ON e.produto_id=p.id


WHERE e.id IS NULL;



-- =====================================================
-- 11 - PRODUTO + COR
-- N:N
-- =====================================================

SELECT


p.nome,


c.nome AS cor



FROM produto p


JOIN produto_cor pc

ON pc.produto_id=p.id


JOIN cor c

ON c.id=pc.cor_id;



-- =====================================================
-- 12 - PRODUTO + TAMANHO
-- N:N
-- =====================================================

SELECT


p.nome,


t.nome AS tamanho



FROM produto p


JOIN produto_tamanho pt

ON pt.produto_id=p.id


JOIN tamanho t

ON t.id=pt.tamanho_id;




-- =====================================================
-- 13 - VENDA + ENTREGA
-- =====================================================

SELECT


ped.id AS pedido,


pe.nome AS cliente,


e.status,


e.data_prevista



FROM pedido ped


JOIN cliente c

ON c.id=ped.cliente_id


JOIN pessoa pe

ON pe.id=c.pessoa_id


LEFT JOIN entrega e

ON e.pedido_id=ped.id;



-- =====================================================
-- 14 - FUNCIONARIO COMPLETO
-- =====================================================

SELECT


pe.nome,


d.nome AS departamento,


ca.nome AS cargo,


s.valor AS salario



FROM funcionario f


JOIN pessoa pe

ON pe.id=f.pessoa_id


LEFT JOIN funcionario_rh fr

ON fr.funcionario_id=f.id


LEFT JOIN departamento d

ON d.id=fr.departamento_id


LEFT JOIN cargo ca

ON ca.id=fr.cargo_id


LEFT JOIN salario s

ON s.funcionario_id=f.id;




-- =====================================================
-- 15 - FINANCEIRO COMPLETO
-- =====================================================

SELECT


pe.nome,


cr.valor,


cr.vencimento,


cr.status



FROM conta_receber cr


JOIN cliente c

ON c.id=cr.cliente_id


JOIN pessoa pe

ON pe.id=c.pessoa_id;




-- =====================================================
-- 16 - VENDA COM TODOS OS DADOS
-- JOIN GRANDE
-- =====================================================

SELECT


ped.id AS pedido,


cliente.nome,


produto.nome,


marca.nome AS marca,


ped.valor_total,


pg.status AS pagamento



FROM pedido ped


JOIN cliente cli

ON cli.id=ped.cliente_id


JOIN pessoa cliente

ON cliente.id=cli.pessoa_id


JOIN pedido_item pi

ON pi.pedido_id=ped.id


JOIN produto

ON produto.id=pi.produto_id


JOIN marca

ON marca.id=produto.marca_id


LEFT JOIN pagamento pg

ON pg.pedido_id=ped.id;
