-- =====================================================
-- ERP JAVA MYSQL
-- Arquivo: 22-inserts-vendas.sql
-- Dados Vendas
-- =====================================================

USE erp_java;



-- =====================================================
-- CARRINHO
-- =====================================================

INSERT INTO carrinho
(
    cliente_id,
    status
)
VALUES

(1,'FINALIZADO'),

(2,'FINALIZADO'),

(3,'FINALIZADO'),

(4,'ABERTO'),

(5,'FINALIZADO');



-- =====================================================
-- CARRINHO ITEM
-- =====================================================

INSERT INTO carrinho_item
(
    carrinho_id,
    produto_id,
    quantidade,
    valor_unitario
)
VALUES

(1,3,1,6500),

(1,6,2,120),

(2,4,1,4800),

(3,5,1,5200),

(5,9,2,750);



-- =====================================================
-- ORCAMENTOS
-- =====================================================

INSERT INTO orcamento
(
    cliente_id,
    vendedor_id,
    data_orcamento,
    validade,
    status,
    valor_total
)
VALUES

(1,1,'2026-01-10','2026-01-20','APROVADO',6740),

(2,2,'2026-02-15','2026-02-25','APROVADO',4800),

(3,3,'2026-03-05','2026-03-15','REJEITADO',5200);



-- =====================================================
-- ORCAMENTO ITEM
-- =====================================================

INSERT INTO orcamento_item
(
    orcamento_id,
    produto_id,
    quantidade,
    valor_unitario,
    valor_total
)
VALUES

(1,3,1,6500,6500),

(1,6,2,120,240),

(2,4,1,4800,4800),

(3,5,1,5200,5200);



-- =====================================================
-- PEDIDOS
-- =====================================================

INSERT INTO pedido
(
    cliente_id,
    vendedor_id,
    orcamento_id,
    data_pedido,
    status,
    valor_produtos,
    valor_desconto,
    valor_frete,
    valor_total
)
VALUES

(1,1,1,
'2026-01-12 10:00:00',
'ENTREGUE',
6740,
200,
50,
6590),


(2,2,2,
'2026-02-20 14:30:00',
'ENTREGUE',
4800,
0,
30,
4830),


(3,3,NULL,
'2026-03-10 09:00:00',
'PAGO',
5200,
500,
50,
4750),


(4,4,NULL,
'2026-04-05 15:00:00',
'CANCELADO',
180,
0,
0,
180),


(5,5,NULL,
'2026-05-20 12:00:00',
'ENTREGUE',
1500,
100,
40,
1440);



-- =====================================================
-- PEDIDO ITEM
-- =====================================================

INSERT INTO pedido_item
(
    pedido_id,
    produto_id,
    quantidade,
    valor_unitario,
    desconto,
    valor_total
)
VALUES

(1,3,1,6500,100,6400),

(1,6,2,120,0,240),


(2,4,1,4800,0,4800),


(3,5,1,5200,500,4700),


(4,8,1,180,0,180),


(5,9,2,750,100,1400);



-- =====================================================
-- DEVOLUÇÃO
-- =====================================================

INSERT INTO devolucao
(
    pedido_id,
    cliente_id,
    funcionario_id,
    data_devolucao,
    motivo,
    valor_total,
    status
)
VALUES

(4,4,4,
'2026-04-10',
'Produto com defeito',
180,
'FINALIZADA');



-- =====================================================
-- DEVOLUCAO ITEM
-- =====================================================

INSERT INTO devolucao_item
(
    devolucao_id,
    produto_id,
    quantidade,
    valor,
    motivo
)
VALUES

(1,
8,
1,
180,
'Defeito fabricação');



-- =====================================================
-- COMISSAO VENDA
-- =====================================================

INSERT INTO comissao_venda
(
    vendedor_id,
    pedido_id,
    percentual,
    valor,
    pago,
    data_calculo
)
VALUES

(1,1,5,329.50,TRUE,'2026-01-13'),

(2,2,5,241.50,TRUE,'2026-02-21'),

(3,3,5,237.50,FALSE,'2026-03-11'),

(5,5,5,72.00,FALSE,'2026-05-21');



-- =====================================================
-- AVALIAÇÃO PRODUTO
-- =====================================================

INSERT INTO avaliacao_produto
(
    cliente_id,
    produto_id,
    nota,
    comentario
)
VALUES

(1,3,5,'Excelente celular'),

(2,4,4,'Muito bom'),

(3,5,5,'Notebook rápido'),

(5,9,4,'Tênis confortável');