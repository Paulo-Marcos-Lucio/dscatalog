insert into tb_categoria (nome, criada_Em) values ('Informática', NOW());
insert into tb_categoria (nome, criada_Em) values ('Eletrônicos', NOW());
insert into tb_categoria (nome, criada_Em) values ('Eletrodomésticos', NOW());
insert into tb_categoria (nome, criada_Em) values ('Telefonia', NOW());
insert into tb_categoria (nome, criada_Em) values ('Games', NOW());
insert into tb_categoria (nome, criada_Em) values ('Livros', NOW());
insert into tb_categoria (nome, criada_Em) values ('Papelaria', NOW());
insert into tb_categoria (nome, criada_Em) values ('Móveis', NOW());
insert into tb_categoria (nome, criada_Em) values ('Casa e Decoração', NOW());
insert into tb_categoria (nome, criada_Em) values ('Moda Masculina', NOW());
insert into tb_categoria (nome, criada_Em) values ('Moda Feminina', NOW());
insert into tb_categoria (nome, criada_Em) values ('Esportes e Lazer', NOW());
insert into tb_categoria (nome, criada_Em) values ('Ferramentas', NOW());
insert into tb_categoria (nome, criada_Em) values ('Pet Shop', NOW());
insert into tb_categoria (nome, criada_Em) values ('Automotivo', NOW());
insert into tb_categoria (nome, criada_Em) values ('Beleza e Saúde', NOW());
insert into tb_categoria (nome, criada_Em) values ('Brinquedos', NOW());
insert into tb_categoria (nome, criada_Em) values ('Instrumentos Musicais', NOW());
insert into tb_categoria (nome, criada_Em) values ('Jardinagem', NOW());
insert into tb_categoria (nome, criada_Em) values ('Supermercado', NOW());
insert into tb_categoria (nome, criada_Em) values ('Bebidas', NOW());
insert into tb_categoria (nome, criada_Em) values ('Cama, Mesa e Banho', NOW());
insert into tb_categoria (nome, criada_Em) values ('Construção Civil', NOW());
insert into tb_categoria (nome, criada_Em) values ('Segurança e Monitoramento', NOW());
insert into tb_categoria (nome, criada_Em) values ('Energia Solar', NOW());

-- PRODUTOS (25 inserts)
insert into tb_produto (nome, descricao, preco, img_url, date) values ('Notebook Dell Inspiron 15', 'Notebook com processador Intel Core i5, 8GB RAM, SSD 256GB', 3299.90, 'https://exemplo.com/notebook-dell.jpg', TIMESTAMP '2024-01-15 10:30:00');
insert into tb_produto (nome, descricao, preco, img_url, date) values ('Smart TV Samsung 50"', 'Smart TV LED 50 polegadas 4K UHD com WiFi integrado', 2199.00, 'https://exemplo.com/tv-samsung.jpg', TIMESTAMP '2024-01-16 14:20:00');
insert into tb_produto (nome, descricao, preco, img_url, date) values ('Geladeira Brastemp Frost Free', 'Geladeira duplex 375 litros com tecnologia frost free', 2899.90, 'https://exemplo.com/geladeira-brastemp.jpg', TIMESTAMP '2024-01-17 09:15:00');
insert into tb_produto (nome, descricao, preco, img_url, date) values ('iPhone 14 Pro Max 256GB', 'Smartphone Apple com tela Super Retina XDR de 6.7 polegadas', 7499.00, 'https://exemplo.com/iphone-14.jpg', TIMESTAMP '2024-01-18 16:45:00');
insert into tb_produto (nome, descricao, preco, img_url, date) values ('PlayStation 5', 'Console de videogame Sony com SSD ultra rápido e controle DualSense', 4199.90, 'https://exemplo.com/ps5.jpg', TIMESTAMP '2024-01-19 11:00:00');
insert into tb_produto (nome, descricao, preco, img_url, date) values ('O Senhor dos Anéis - Box Completo', 'Coleção completa da trilogia em capa dura com ilustrações', 189.90, 'https://exemplo.com/lotr-box.jpg', TIMESTAMP '2024-01-20 13:30:00');
insert into tb_produto (nome, descricao, preco, img_url, date) values ('Kit Canetas Stabilo Boss', 'Conjunto com 6 canetas marca texto cores variadas', 45.90, 'https://exemplo.com/canetas-stabilo.jpg', TIMESTAMP '2024-01-21 10:00:00');
insert into tb_produto (nome, descricao, preco, img_url, date) values ('Sofá Retrátil 3 Lugares', 'Sofá reclinável e retrátil em tecido suede com compartimento', 1899.00, 'https://exemplo.com/sofa-retratil.jpg', TIMESTAMP '2024-01-22 15:20:00');
insert into tb_produto (nome, descricao, preco, img_url, date) values ('Jogo de Panelas Tramontina', 'Kit com 5 panelas antiaderentes com tampas de vidro', 349.90, 'https://exemplo.com/panelas-tramontina.jpg', TIMESTAMP '2024-01-23 09:45:00');
insert into tb_produto (nome, descricao, preco, img_url, date) values ('Camisa Polo Lacoste', 'Camisa polo masculina 100% algodão com logo bordado', 399.90, 'https://exemplo.com/polo-lacoste.jpg', TIMESTAMP '2024-01-24 14:10:00');
insert into tb_produto (nome, descricao, preco, img_url, date) values ('Vestido Longo Floral', 'Vestido longo feminino em viscose estampado', 189.90, 'https://exemplo.com/vestido-floral.jpg', TIMESTAMP '2024-01-25 11:30:00');
insert into tb_produto (nome, descricao, preco, img_url, date) values ('Bicicleta Mountain Bike Caloi', 'Bike aro 29 com 21 marchas e suspensão dianteira', 1799.00, 'https://exemplo.com/bike-caloi.jpg', TIMESTAMP '2024-01-26 16:00:00');
insert into tb_produto (nome, descricao, preco, img_url, date) values ('Furadeira de Impacto Bosch', 'Furadeira elétrica 650W com maleta e acessórios', 289.90, 'https://exemplo.com/furadeira-bosch.jpg', TIMESTAMP '2024-01-27 10:20:00');
insert into tb_produto (nome, descricao, preco, img_url, date) values ('Ração Golden Formula Cães', 'Ração premium para cães adultos sabor frango 15kg', 179.90, 'https://exemplo.com/racao-golden.jpg', TIMESTAMP '2024-01-28 13:45:00');
insert into tb_produto (nome, descricao, preco, img_url, date) values ('Pneu Pirelli P7 205/55 R16', 'Pneu para veículos de passeio com tecnologia verde', 459.90, 'https://exemplo.com/pneu-pirelli.jpg', TIMESTAMP '2024-01-29 09:30:00');
insert into tb_produto (nome, descricao, preco, img_url, date) values ('Perfume Importado Dior Sauvage', 'Eau de Toilette masculino 100ml amadeirado aromático', 589.90, 'https://exemplo.com/perfume-dior.jpg', TIMESTAMP '2024-01-30 15:15:00');
insert into tb_produto (nome, descricao, preco, img_url, date) values ('LEGO Star Wars Millennium Falcon', 'Kit de montagem com 1351 peças para maiores de 9 anos', 799.90, 'https://exemplo.com/lego-falcon.jpg', TIMESTAMP '2024-01-31 11:50:00');
insert into tb_produto (nome, descricao, preco, img_url, date) values ('Violão Yamaha C40', 'Violão clássico acústico com cordas de nylon', 899.00, 'https://exemplo.com/violao-yamaha.jpg', TIMESTAMP '2024-02-01 14:30:00');
insert into tb_produto (nome, descricao, preco, img_url, date) values ('Cortador de Grama Tramontina', 'Cortador elétrico 1200W com cesto coletor 25 litros', 449.90, 'https://exemplo.com/cortador-grama.jpg', TIMESTAMP '2024-02-02 10:15:00');
insert into tb_produto (nome, descricao, preco, img_url, date) values ('Café Pilão Tradicional 500g', 'Café torrado e moído tradicional pacote 500g', 18.90, 'https://exemplo.com/cafe-pilao.jpg', TIMESTAMP '2024-02-03 16:40:00');
insert into tb_produto (nome, descricao, preco, img_url, date) values ('Vinho Tinto Casillero del Diablo', 'Vinho chileno Cabernet Sauvignon 750ml', 54.90, 'https://exemplo.com/vinho-casillero.jpg', TIMESTAMP '2024-02-04 13:20:00');
insert into tb_produto (nome, descricao, preco, img_url, date) values ('Jogo de Lençol Casal 4 Peças', 'Lençol 100% algodão 180 fios com fronhas', 159.90, 'https://exemplo.com/lencol-casal.jpg', TIMESTAMP '2024-02-05 09:55:00');
insert into tb_produto (nome, descricao, preco, img_url, date) values ('Cimento Portland 50kg', 'Saco de cimento CP II para construção civil', 32.90, 'https://exemplo.com/cimento-50kg.jpg', TIMESTAMP '2024-02-06 15:30:00');
insert into tb_produto (nome, descricao, preco, img_url, date) values ('Câmera de Segurança Intelbras', 'Câmera IP WiFi Full HD com visão noturna e app', 299.90, 'https://exemplo.com/camera-intelbras.jpg', TIMESTAMP '2024-02-07 11:10:00');
insert into tb_produto (nome, descricao, preco, img_url, date) values ('Kit Energia Solar 3kWp', 'Sistema fotovoltaico completo com 8 placas e inversor', 12999.00, 'https://exemplo.com/energia-solar.jpg', TIMESTAMP '2024-02-08 14:45:00');

-- RELACIONAMENTOS PRODUTO-CATEGORIA (50 inserts)
insert into tb_produto_categoria (produto_id, categoria_id) values (1, 1);
insert into tb_produto_categoria (produto_id, categoria_id) values (1, 2);
insert into tb_produto_categoria (produto_id, categoria_id) values (2, 2);
insert into tb_produto_categoria (produto_id, categoria_id) values (2, 3);
insert into tb_produto_categoria (produto_id, categoria_id) values (3, 3);
insert into tb_produto_categoria (produto_id, categoria_id) values (4, 4);
insert into tb_produto_categoria (produto_id, categoria_id) values (4, 2);
insert into tb_produto_categoria (produto_id, categoria_id) values (5, 5);
insert into tb_produto_categoria (produto_id, categoria_id) values (5, 2);
insert into tb_produto_categoria (produto_id, categoria_id) values (6, 6);
insert into tb_produto_categoria (produto_id, categoria_id) values (7, 7);
insert into tb_produto_categoria (produto_id, categoria_id) values (8, 8);
insert into tb_produto_categoria (produto_id, categoria_id) values (8, 9);
insert into tb_produto_categoria (produto_id, categoria_id) values (9, 9);
insert into tb_produto_categoria (produto_id, categoria_id) values (9, 3);
insert into tb_produto_categoria (produto_id, categoria_id) values (10, 10);
insert into tb_produto_categoria (produto_id, categoria_id) values (11, 11);
insert into tb_produto_categoria (produto_id, categoria_id) values (12, 12);
insert into tb_produto_categoria (produto_id, categoria_id) values (12, 15);
insert into tb_produto_categoria (produto_id, categoria_id) values (13, 13);
insert into tb_produto_categoria (produto_id, categoria_id) values (13, 23);
insert into tb_produto_categoria (produto_id, categoria_id) values (14, 14);
insert into tb_produto_categoria (produto_id, categoria_id) values (15, 15);
insert into tb_produto_categoria (produto_id, categoria_id) values (16, 16);
insert into tb_produto_categoria (produto_id, categoria_id) values (17, 17);
insert into tb_produto_categoria (produto_id, categoria_id) values (17, 5);
insert into tb_produto_categoria (produto_id, categoria_id) values (18, 18);
insert into tb_produto_categoria (produto_id, categoria_id) values (19, 19);
insert into tb_produto_categoria (produto_id, categoria_id) values (19, 13);
insert into tb_produto_categoria (produto_id, categoria_id) values (20, 20);
insert into tb_produto_categoria (produto_id, categoria_id) values (21, 21);
insert into tb_produto_categoria (produto_id, categoria_id) values (22, 22);
insert into tb_produto_categoria (produto_id, categoria_id) values (22, 9);
insert into tb_produto_categoria (produto_id, categoria_id) values (23, 23);
insert into tb_produto_categoria (produto_id, categoria_id) values (24, 24);
insert into tb_produto_categoria (produto_id, categoria_id) values (24, 2);
insert into tb_produto_categoria (produto_id, categoria_id) values (25, 25);
insert into tb_produto_categoria (produto_id, categoria_id) values (25, 2);
insert into tb_produto_categoria (produto_id, categoria_id) values (1, 3);
insert into tb_produto_categoria (produto_id, categoria_id) values (3, 8);
insert into tb_produto_categoria (produto_id, categoria_id) values (4, 1);
insert into tb_produto_categoria (produto_id, categoria_id) values (6, 17);
insert into tb_produto_categoria (produto_id, categoria_id) values (10, 16);
insert into tb_produto_categoria (produto_id, categoria_id) values (11, 16);
insert into tb_produto_categoria (produto_id, categoria_id) values (14, 20);
insert into tb_produto_categoria (produto_id, categoria_id) values (16, 11);
insert into tb_produto_categoria (produto_id, categoria_id) values (16, 10);
insert into tb_produto_categoria (produto_id, categoria_id) values (20, 21);
insert into tb_produto_categoria (produto_id, categoria_id) values (21, 20);
insert into tb_produto_categoria (produto_id, categoria_id) values (23, 13);



-- ============================================
-- INSERÇÕES NA TABELA tb_usuario
-- ============================================

INSERT INTO tb_usuario (email, primeiro_nome, senha, ultimo_nome) VALUES ('joao.silva@email.com', 'João', '$2a$10$abcdefghijklmnopqrstuv', 'Silva');

INSERT INTO tb_usuario (email, primeiro_nome, senha, ultimo_nome) VALUES ('maria.santos@email.com', 'Maria', '$2a$10$bcdefghijklmnopqrstuvw', 'Santos');

INSERT INTO tb_usuario (email, primeiro_nome, senha, ultimo_nome) VALUES ('pedro.oliveira@email.com', 'Pedro', '$2a$10$cdefghijklmnopqrstuvwx', 'Oliveira');

INSERT INTO tb_usuario (email, primeiro_nome, senha, ultimo_nome) VALUES ('ana.costa@email.com', 'Ana', '$2a$10$defghijklmnopqrstuvwxy', 'Costa');

INSERT INTO tb_usuario (email, primeiro_nome, senha, ultimo_nome) VALUES ('carlos.pereira@email.com', 'Carlos', '$2a$10$efghijklmnopqrstuvwxyz', 'Pereira');

INSERT INTO tb_usuario (email, primeiro_nome, senha, ultimo_nome) VALUES ('julia.rodrigues@email.com', 'Júlia', '$2a$10$fghijklmnopqrstuvwxyza', 'Rodrigues');

INSERT INTO tb_usuario (email, primeiro_nome, senha, ultimo_nome) VALUES ('lucas.almeida@email.com', 'Lucas', '$2a$10$ghijklmnopqrstuvwxyzab', 'Almeida');

INSERT INTO tb_usuario (email, primeiro_nome, senha, ultimo_nome) VALUES ('fernanda.lima@email.com', 'Fernanda', '$2a$10$hijklmnopqrstuvwxyzabc', 'Lima');

INSERT INTO tb_usuario (email, primeiro_nome, senha, ultimo_nome) VALUES ('rafael.martins@email.com', 'Rafael', '$2a$10$ijklmnopqrstuvwxyzabcd', 'Martins');

INSERT INTO tb_usuario (email, primeiro_nome, senha, ultimo_nome) VALUES ('camila.souza@email.com', 'Camila', '$2a$10$jklmnopqrstuvwxyzabcde', 'Souza');

INSERT INTO tb_usuario (email, primeiro_nome, senha, ultimo_nome) VALUES ('bruno.ferreira@email.com', 'Bruno', '$2a$10$klmnopqrstuvwxyzabcdef', 'Ferreira');

INSERT INTO tb_usuario (email, primeiro_nome, senha, ultimo_nome) VALUES ('patricia.gomes@email.com', 'Patrícia', '$2a$10$lmnopqrstuvwxyzabcdefg', 'Gomes');

INSERT INTO tb_usuario (email, primeiro_nome, senha, ultimo_nome) VALUES ('rodrigo.barbosa@email.com', 'Rodrigo', '$2a$10$mnopqrstuvwxyzabcdefgh', 'Barbosa');

INSERT INTO tb_usuario (email, primeiro_nome, senha, ultimo_nome) VALUES ('amanda.ribeiro@email.com', 'Amanda', '$2a$10$nopqrstuvwxyzabcdefghi', 'Ribeiro');

INSERT INTO tb_usuario (email, primeiro_nome, senha, ultimo_nome) VALUES ('gustavo.cardoso@email.com', 'Gustavo', '$2a$10$opqrstuvwxyzabcdefghij', 'Cardoso');



-- ============================================
-- INSERÇÕES NA TABELA tb_papel
-- ============================================

INSERT INTO tb_papel (autoridade) VALUES ('ROLE_ADMIN');

INSERT INTO tb_papel (autoridade) VALUES ('ROLE_USER');

INSERT INTO tb_papel (autoridade) VALUES ('ROLE_MANAGER');

INSERT INTO tb_papel (autoridade) VALUES ('ROLE_MODERATOR');

INSERT INTO tb_papel (autoridade) VALUES ('ROLE_EDITOR');

INSERT INTO tb_papel (autoridade) VALUES ('ROLE_VIEWER');

INSERT INTO tb_papel (autoridade) VALUES ('ROLE_DEVELOPER');

INSERT INTO tb_papel (autoridade) VALUES ('ROLE_ANALYST');

INSERT INTO tb_papel (autoridade) VALUES ('ROLE_SUPPORT');

INSERT INTO tb_papel (autoridade) VALUES ('ROLE_SALES');

INSERT INTO tb_papel (autoridade) VALUES ('ROLE_MARKETING');

INSERT INTO tb_papel (autoridade) VALUES ('ROLE_FINANCE');

INSERT INTO tb_papel (autoridade) VALUES ('ROLE_HR');

INSERT INTO tb_papel (autoridade) VALUES ('ROLE_CUSTOMER');

INSERT INTO tb_papel (autoridade) VALUES ('ROLE_GUEST');


-- ============================================
-- INSERÇÕES NA TABELA tb_usuario_papel
-- ============================================

INSERT INTO tb_usuario_papel (papel_id, usuario_id) VALUES (1, 1);

INSERT INTO tb_usuario_papel (papel_id, usuario_id) VALUES (2, 1);

INSERT INTO tb_usuario_papel (papel_id, usuario_id) VALUES (2, 2);

INSERT INTO tb_usuario_papel (papel_id, usuario_id) VALUES (3, 2);

INSERT INTO tb_usuario_papel (papel_id, usuario_id) VALUES (3, 3);

INSERT INTO tb_usuario_papel (papel_id, usuario_id) VALUES (4, 3);

INSERT INTO tb_usuario_papel (papel_id, usuario_id) VALUES (5, 4);

INSERT INTO tb_usuario_papel (papel_id, usuario_id) VALUES (6, 4);

INSERT INTO tb_usuario_papel (papel_id, usuario_id) VALUES (7, 5);

INSERT INTO tb_usuario_papel (papel_id, usuario_id) VALUES (8, 5);

INSERT INTO tb_usuario_papel (papel_id, usuario_id) VALUES (9, 6);

INSERT INTO tb_usuario_papel (papel_id, usuario_id) VALUES (10, 6);

INSERT INTO tb_usuario_papel (papel_id, usuario_id) VALUES (1, 7);

INSERT INTO tb_usuario_papel (papel_id, usuario_id) VALUES (11, 7);

INSERT INTO tb_usuario_papel (papel_id, usuario_id) VALUES (12, 8);