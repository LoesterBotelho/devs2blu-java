-- =====================================================
-- ERP JAVA MYSQL
-- Arquivo: 21-inserts-produtos.sql
-- Dados Produtos
-- =====================================================

USE erp_java;



-- =====================================================
-- FABRICANTE
-- =====================================================

INSERT INTO fabricante
(
    nome,
    pais_origem,
    site
)
VALUES

('Samsung','Coreia do Sul','https://samsung.com'),

('Apple','Estados Unidos','https://apple.com'),

('Dell','Estados Unidos','https://dell.com'),

('LG','Coreia do Sul','https://lg.com'),

('Nike','Estados Unidos','https://nike.com'),

('Adidas','Alemanha','https://adidas.com');



-- =====================================================
-- MARCA
-- =====================================================

INSERT INTO marca
(
    fabricante_id,
    nome
)
VALUES

(1,'Samsung'),

(2,'Apple'),

(3,'Dell'),

(4,'LG'),

(5,'Nike'),

(6,'Adidas');



-- =====================================================
-- CATEGORIA
-- =====================================================

INSERT INTO categoria
(
    nome,
    descricao
)
VALUES

('Eletrônicos','Produtos eletrônicos'),

('Informática','Computadores e acessórios'),

('Celulares','Smartphones'),

('Roupas','Vestuário'),

('Calçados','Tênis e sapatos'),

('Acessórios','Diversos');



-- =====================================================
-- SUBCATEGORIA
-- =====================================================

INSERT INTO subcategoria
(
    categoria_id,
    nome
)
VALUES

(1,'Televisão'),

(1,'Som'),

(2,'Notebook'),

(2,'Periféricos'),

(3,'Smartphone'),

(4,'Camiseta'),

(5,'Tênis'),

(6,'Mochila');



-- =====================================================
-- UNIDADE MEDIDA
-- =====================================================

INSERT INTO unidade_medida
(
    nome,
    sigla
)
VALUES

('Unidade','UN'),

('Caixa','CX'),

('Quilograma','KG'),

('Litro','LT');



-- =====================================================
-- CORES
-- =====================================================

INSERT INTO cor
(
    nome,
    codigo_hex
)
VALUES

('Preto','#000000'),

('Branco','#FFFFFF'),

('Azul','#0000FF'),

('Vermelho','#FF0000'),

('Verde','#00FF00');



-- =====================================================
-- TAMANHOS
-- =====================================================

INSERT INTO tamanho
(
    nome
)
VALUES

('PP'),

('P'),

('M'),

('G'),

('GG'),

('42'),

('43'),

('44');



-- =====================================================
-- PRODUTOS
-- =====================================================

INSERT INTO produto
(
    categoria_id,
    subcategoria_id,
    marca_id,
    unidade_medida_id,
    nome,
    descricao,
    codigo_barras,
    peso,
    preco_custo,
    preco_venda
)
VALUES

(1,1,1,1,
'Smart TV Samsung 50',
'Televisão 50 polegadas',
'789000000001',
8.500,
2500,
3200),


(1,1,4,1,
'Smart TV LG 55',
'Televisão 55 polegadas',
'789000000002',
10.200,
2800,
3600),


(3,5,2,1,
'iPhone 15',
'Smartphone Apple',
'789000000003',
0.200,
4500,
6500),


(3,5,1,1,
'Galaxy S25',
'Smartphone Samsung',
'789000000004',
0.190,
3000,
4800),


(2,3,3,1,
'Notebook Dell Inspiron',
'Notebook 15 polegadas',
'789000000005',
2.100,
3500,
5200),


(2,4,3,1,
'Mouse Dell USB',
'Mouse óptico',
'789000000006',
0.100,
50,
120),


(2,4,3,1,
'Teclado Dell Mecânico',
'Teclado gamer',
'789000000007',
0.800,
200,
450),


(4,6,5,1,
'Camiseta Nike Masculina',
'Camiseta esportiva',
'789000000008',
0.300,
80,
180),


(5,7,5,1,
'Tênis Nike Air',
'Tênis corrida',
'789000000009',
0.900,
400,
750),


(5,7,6,1,
'Tênis Adidas Run',
'Tênis esportivo',
'789000000010',
0.850,
350,
700),


(6,8,6,1,
'Mochila Adidas',
'Mochila escolar',
'789000000011',
0.600,
120,
250);