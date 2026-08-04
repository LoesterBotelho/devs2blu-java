-- =====================================================
-- ERP JAVA MYSQL
-- Arquivo: 20-inserts-pessoas.sql
-- Dados Pessoas
-- =====================================================

USE erp_java;



-- =====================================================
-- PESSOAS
-- =====================================================

INSERT INTO pessoa
(
    nome,
    cpf,
    rg,
    data_nascimento,
    sexo,
    tipo_pessoa
)
VALUES

('João Silva','11111111111','1234567','1990-01-10','M','FISICA'),

('Maria Oliveira','22222222222','2345678','1992-05-20','F','FISICA'),

('Carlos Souza','33333333333','3456789','1985-03-15','M','FISICA'),

('Ana Santos','44444444444','4567890','1998-07-12','F','FISICA'),

('Pedro Costa','55555555555','5678901','1980-11-05','M','FISICA'),

('Empresa Alpha LTDA','12345678000199',NULL,NULL,NULL,'JURIDICA'),

('Comercial Beta SA','98765432000188',NULL,NULL,NULL,'JURIDICA'),

('Fornecedor Gamma LTDA','45678912000155',NULL,NULL,NULL,'JURIDICA'),

('Transportadora Delta LTDA','78945612000177',NULL,NULL,NULL,'JURIDICA'),

('Mercado Omega LTDA','32165498000166',NULL,NULL,NULL,'JURIDICA');



-- =====================================================
-- ENDERECOS
-- =====================================================

INSERT INTO endereco
(
    pessoa_id,
    logradouro,
    numero,
    bairro,
    cidade,
    estado,
    cep
)
VALUES

(1,'Rua das Flores','100','Centro','São Paulo','SP','01001000'),

(2,'Rua Brasil','200','Jardim América','Rio de Janeiro','RJ','20040000'),

(3,'Avenida Central','300','Centro','Curitiba','PR','80010000'),

(4,'Rua das Palmeiras','400','Vila Nova','Joinville','SC','89200000'),

(5,'Rua do Comércio','500','Centro','Belo Horizonte','MG','30010000'),

(6,'Avenida Industrial','600','Distrito Industrial','São Paulo','SP','01002000'),

(7,'Rua Empresarial','700','Centro','Campinas','SP','13010000'),

(8,'Rua Fornecedores','800','Industrial','Sorocaba','SP','18010000'),

(9,'Avenida Logística','900','Zona Norte','São Paulo','SP','02010000'),

(10,'Rua Mercado','1000','Centro','Florianópolis','SC','88010000');



-- =====================================================
-- TELEFONES
-- =====================================================

INSERT INTO telefone
(
    pessoa_id,
    numero,
    tipo
)
VALUES

(1,'11999990001','CELULAR'),

(2,'21999990002','CELULAR'),

(3,'41999990003','CELULAR'),

(4,'47999990004','CELULAR'),

(5,'31999990005','CELULAR'),

(6,'1133330001','COMERCIAL'),

(7,'1933330002','COMERCIAL'),

(8,'1533330003','COMERCIAL'),

(9,'1133330004','COMERCIAL'),

(10,'4833330005','COMERCIAL');



-- =====================================================
-- EMAIL
-- =====================================================

INSERT INTO email
(
    pessoa_id,
    email,
    principal
)
VALUES

(1,'joao@email.com',TRUE),

(2,'maria@email.com',TRUE),

(3,'carlos@email.com',TRUE),

(4,'ana@email.com',TRUE),

(5,'pedro@email.com',TRUE),

(6,'contato@alpha.com',TRUE),

(7,'contato@beta.com',TRUE),

(8,'vendas@gamma.com',TRUE),

(9,'contato@delta.com',TRUE),

(10,'contato@omega.com',TRUE);



-- =====================================================
-- CLIENTE
-- =====================================================

INSERT INTO cliente
(
    pessoa_id,
    data_cadastro,
    limite_credito,
    ativo
)
VALUES

(1,'2025-01-10',5000,TRUE),

(2,'2025-02-15',3000,TRUE),

(3,'2025-03-20',7000,TRUE),

(4,'2025-04-05',2000,TRUE),

(5,'2025-05-10',10000,TRUE);



-- =====================================================
-- FORNECEDOR
-- =====================================================

INSERT INTO fornecedor
(
    pessoa_id,
    inscricao_estadual,
    categoria
)
VALUES

(6,'123456789','ELETRONICOS'),

(7,'987654321','ALIMENTOS'),

(8,'456789123','GERAL'),

(10,'321654987','VAREJO');



-- =====================================================
-- FUNCIONARIO
-- =====================================================

INSERT INTO funcionario
(
    pessoa_id,
    matricula,
    data_admissao,
    salario
)
VALUES

(1,'FUNC001','2024-01-10',3500),

(2,'FUNC002','2024-02-15',4200),

(3,'FUNC003','2024-03-20',5000),

(4,'FUNC004','2024-04-05',2800),

(5,'FUNC005','2024-05-10',6000);