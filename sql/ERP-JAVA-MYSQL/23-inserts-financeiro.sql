-- =====================================================
-- ERP JAVA MYSQL
-- Arquivo: 23-inserts-financeiro.sql
-- Dados Financeiro
-- =====================================================

USE erp_java;



-- =====================================================
-- FORMA PAGAMENTO
-- =====================================================

INSERT INTO forma_pagamento
(
    nome,
    tipo,
    taxa,
    prazo_recebimento
)
VALUES

('Dinheiro','DINHEIRO',0,0),

('PIX','PIX',0,0),

('Cartão Crédito','CARTAO_CREDITO',2.50,30),

('Cartão Débito','CARTAO_DEBITO',1.20,1),

('Boleto Bancário','BOLETO',1.00,3),

('Transferência','TRANSFERENCIA',0,1);



-- =====================================================
-- PAGAMENTOS
-- =====================================================

INSERT INTO pagamento
(
    pedido_id,
    forma_pagamento_id,
    data_pagamento,
    valor,
    status,
    codigo_transacao
)
VALUES

(1,2,'2026-01-12 10:10:00',6590,'APROVADO','PIX001'),

(2,3,'2026-02-20 15:00:00',4830,'APROVADO','CARD001'),

(3,5,'2026-03-10 10:00:00',4750,'PENDENTE','BOL001'),

(4,1,'2026-04-05 15:10:00',180,'CANCELADO','DIN001'),

(5,4,'2026-05-20 12:20:00',1440,'APROVADO','DEB001');



-- =====================================================
-- PARCELAS
-- =====================================================

INSERT INTO parcela
(
    pagamento_id,
    numero,
    vencimento,
    valor,
    status
)
VALUES

(1,1,'2026-01-12',6590,'PAGA'),

(2,1,'2026-03-20',2415,'PAGA'),

(2,2,'2026-04-20',2415,'PAGA'),

(3,1,'2026-04-10',4750,'ABERTA'),

(5,1,'2026-05-20',1440,'PAGA');



-- =====================================================
-- CONTAS RECEBER
-- =====================================================

INSERT INTO conta_receber
(
    cliente_id,
    pedido_id,
    parcela_id,
    descricao,
    valor,
    vencimento,
    status
)
VALUES

(1,1,1,
'Venda Smartphone',
6590,
'2026-01-12',
'PAGA'),


(2,2,2,
'Venda Galaxy',
4830,
'2026-04-20',
'PAGA'),


(3,3,4,
'Venda Notebook',
4750,
'2026-04-10',
'ABERTA'),


(5,5,5,
'Venda Tênis',
1440,
'2026-05-20',
'PAGA');



-- =====================================================
-- CONTAS PAGAR
-- =====================================================

INSERT INTO conta_pagar
(
    fornecedor_id,
    descricao,
    valor,
    vencimento,
    status
)
VALUES

(1,
'Compra de celulares',
15000,
'2026-01-30',
'PAGA'),


(2,
'Compra alimentos',
8000,
'2026-02-15',
'PAGA'),


(3,
'Compra acessórios',
3000,
'2026-03-20',
'ABERTA'),


(4,
'Compra produtos varejo',
5000,
'2026-04-10',
'ATRASADA');



-- =====================================================
-- BANCO
-- =====================================================

INSERT INTO banco
(
    nome,
    codigo,
    agencia,
    conta
)
VALUES

('Banco do Brasil','001','1234','10000-1'),

('Caixa Econômica','104','5678','20000-2'),

('Itaú','341','9876','30000-3'),

('Bradesco','237','5555','40000-4');



-- =====================================================
-- CAIXA
-- =====================================================

INSERT INTO caixa
(
    funcionario_id,
    nome,
    saldo_inicial,
    saldo_atual,
    data_abertura,
    status
)
VALUES

(1,
'Caixa Loja Centro',
1000,
8500,
'2026-01-01 08:00:00',
'ABERTO'),


(2,
'Caixa Loja Shopping',
2000,
12000,
'2026-01-01 08:00:00',
'ABERTO');



-- =====================================================
-- MOVIMENTO CAIXA
-- =====================================================

INSERT INTO movimento_caixa
(
    caixa_id,
    tipo,
    origem,
    documento_id,
    descricao,
    valor
)
VALUES

(1,
'ENTRADA',
'VENDA',
1,
'Venda pedido 1',
6590),


(1,
'ENTRADA',
'VENDA',
5,
'Venda pedido 5',
1440),


(1,
'SAIDA',
'COMPRA',
1,
'Compra fornecedor',
3000),


(2,
'ENTRADA',
'VENDA',
2,
'Venda pedido 2',
4830);



-- =====================================================
-- CONCILIACAO
-- =====================================================

INSERT INTO conciliacao_financeira
(
    pagamento_id,
    data_conciliacao,
    valor_sistema,
    valor_banco,
    diferenca,
    observacao
)
VALUES

(1,
'2026-01-13',
6590,
6590,
0,
'Conciliado'),


(2,
'2026-02-21',
4830,
4830,
0,
'Conciliado'),


(5,
'2026-05-21',
1440,
1438,
-2,
'Taxa bancária');



-- =====================================================
-- MOVIMENTO BANCARIO
-- =====================================================

INSERT INTO movimento_bancario
(
    banco_id,
    tipo,
    valor,
    data_movimento,
    descricao
)
VALUES

(1,'CREDITO',6590,'2026-01-12','Recebimento venda'),

(3,'CREDITO',4830,'2026-02-20','Recebimento cartão'),

(1,'DEBITO',3000,'2026-03-01','Pagamento fornecedor'),

(4,'CREDITO',1440,'2026-05-20','Venda produto');