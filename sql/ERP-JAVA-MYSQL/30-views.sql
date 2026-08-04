-- =====================================================
-- ERP JAVA MYSQL
-- Arquivo: 30-views.sql
-- Views
-- =====================================================

USE erp_java;



-- =====================================================
-- CLIENTES COMPLETOS
-- =====================================================

CREATE VIEW vw_clientes_completos AS

SELECT

    c.id AS cliente_id,

    p.nome,

    p.cpf,

    e.cidade,

    e.estado,

    t.numero AS telefone,

    em.email,

    c.limite_credito,

    c.ativo


FROM cliente c


JOIN pessoa p
ON p.id = c.pessoa_id


LEFT JOIN endereco e
ON e.pessoa_id = p.id


LEFT JOIN telefone t
ON t.pessoa_id = p.id


LEFT JOIN email em
ON em.pessoa_id = p.id;




-- =====================================================
-- PRODUTOS COM ESTOQUE
-- =====================================================

CREATE VIEW vw_produtos_estoque AS

SELECT

    p.id AS produto_id,

    p.nome,

    m.nome AS marca,

    c.nome AS categoria,

    e.quantidade,

    p.preco_venda


FROM produto p


JOIN marca m
ON m.id = p.marca_id


JOIN categoria c
ON c.id = p.categoria_id


LEFT JOIN estoque e
ON e.produto_id = p.id;



-- =====================================================
-- VENDAS DETALHADAS
-- =====================================================

CREATE VIEW vw_vendas_detalhadas AS

SELECT

    pe.nome AS cliente,

    ped.id AS pedido_id,

    ped.data_pedido,

    pr.nome AS produto,

    pi.quantidade,

    pi.valor_unitario,

    pi.valor_total,

    ped.status


FROM pedido ped


JOIN cliente cli
ON cli.id = ped.cliente_id


JOIN pessoa pe
ON pe.id = cli.pessoa_id


JOIN pedido_item pi
ON pi.pedido_id = ped.id


JOIN produto pr
ON pr.id = pi.produto_id;



-- =====================================================
-- FATURAMENTO MENSAL
-- =====================================================

CREATE VIEW vw_faturamento_mensal AS

SELECT


YEAR(data_pedido) AS ano,


MONTH(data_pedido) AS mes,


COUNT(id) AS quantidade_vendas,


SUM(valor_total) AS faturamento



FROM pedido


WHERE status IN
(
'PAGO',
'ENTREGUE'
)


GROUP BY

YEAR(data_pedido),

MONTH(data_pedido);




-- =====================================================
-- FINANCEIRO EM ABERTO
-- =====================================================

CREATE VIEW vw_financeiro_aberto AS


SELECT

'RECEBER' AS tipo,


cr.id,


pe.nome AS pessoa,


cr.valor,


cr.vencimento,


cr.status



FROM conta_receber cr


JOIN cliente c
ON c.id = cr.cliente_id


JOIN pessoa pe
ON pe.id = c.pessoa_id


WHERE cr.status <> 'PAGA'



UNION ALL



SELECT


'PAGAR',


cp.id,


pe.nome,


cp.valor,


cp.vencimento,


cp.status



FROM conta_pagar cp


JOIN fornecedor f
ON f.id = cp.fornecedor_id


JOIN pessoa pe
ON pe.id = f.pessoa_id


WHERE cp.status <> 'PAGA';





-- =====================================================
-- FUNCIONARIOS COMPLETOS
-- =====================================================

CREATE VIEW vw_funcionarios_completos AS


SELECT


pe.nome,


pe.cpf,


d.nome AS departamento,


c.nome AS cargo,


s.valor AS salario,


fr.status



FROM funcionario fun


JOIN pessoa pe
ON pe.id = fun.pessoa_id


LEFT JOIN funcionario_rh fr
ON fr.funcionario_id = fun.id


LEFT JOIN departamento d
ON d.id = fr.departamento_id


LEFT JOIN cargo c
ON c.id = fr.cargo_id


LEFT JOIN salario s
ON s.funcionario_id = fun.id;




-- =====================================================
-- ENTREGAS COMPLETAS
-- =====================================================

CREATE VIEW vw_entregas_completas AS


SELECT


ped.id AS pedido,


pe.nome AS cliente,


t.nome_fantasia AS transportadora,


m.nome AS motorista,


e.status,


e.data_prevista,


e.data_entrega,


r.localizacao



FROM entrega e


JOIN pedido ped
ON ped.id=e.pedido_id


JOIN cliente cli
ON cli.id=ped.cliente_id


JOIN pessoa pe
ON pe.id=cli.pessoa_id


LEFT JOIN motorista m
ON m.id=e.motorista_id


LEFT JOIN transportadora t
ON t.id=m.transportadora_id


LEFT JOIN rastreamento r
ON r.entrega_id=e.id;