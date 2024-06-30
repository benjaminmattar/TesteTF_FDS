INSERT INTO usuario (usuario, senha) VALUES ('admin', 'password');

INSERT INTO cliente (codigo, nome, email) VALUES (1, 'John Doe', 'john.doe@example.com');
INSERT INTO cliente (codigo, nome, email) VALUES (2, 'Jane Smith', 'jane.smith@example.com');
INSERT INTO cliente (codigo, nome, email) VALUES (3, 'Michael Johnson', 'michael.johnson@example.com');
INSERT INTO cliente (codigo, nome, email) VALUES (4, 'Emily Davis', 'emily.davis@example.com');
INSERT INTO cliente (codigo, nome, email) VALUES (5, 'Chris Brown', 'chris.brown@example.com');
INSERT INTO cliente (codigo, nome, email) VALUES (6, 'Jessica Wilson', 'jessica.wilson@example.com');
INSERT INTO cliente (codigo, nome, email) VALUES (7, 'David Martinez', 'david.martinez@example.com');
INSERT INTO cliente (codigo, nome, email) VALUES (8, 'Laura Lee', 'laura.lee@example.com');
INSERT INTO cliente (codigo, nome, email) VALUES (9, 'Daniel Anderson', 'daniel.anderson@example.com');
INSERT INTO cliente (codigo, nome, email) VALUES (10, 'Sarah Thomas', 'sarah.thomas@example.com');

INSERT INTO aplicativo (codigo, nome, custo_mensal) VALUES ('Netflix', 15.99);
INSERT INTO aplicativo (codigo, nome, custo_mensal) VALUES ('Spotify', 9.99);
INSERT INTO aplicativo (codigo, nome, custo_mensal) VALUES ('Amazon Prime', 12.99);
INSERT INTO aplicativo (codigo, nome, custo_mensal) VALUES ('Hulu', 11.99);
INSERT INTO aplicativo (codigo, nome, custo_mensal) VALUES ('Disney+', 7.99);

INSERT INTO assinatura (codigo, cliente_codigo, aplicativo_codigo, inicio_vigencia, fim_vigencia) VALUES (1, 1, 1, '2024-01-01', '2024-12-31');
INSERT INTO assinatura (codigo, cliente_codigo, aplicativo_codigo, inicio_vigencia, fim_vigencia) VALUES (2, 2, 2, '2024-02-01', '2024-12-31');
INSERT INTO assinatura (codigo, cliente_codigo, aplicativo_codigo, inicio_vigencia, fim_vigencia) VALUES (3, 3, 3, '2024-03-01', '2024-12-31');
INSERT INTO assinatura (codigo, cliente_codigo, aplicativo_codigo, inicio_vigencia, fim_vigencia) VALUES (4, 4, 4, '2024-04-01', '2024-12-31');
INSERT INTO assinatura (codigo, cliente_codigo, aplicativo_codigo, inicio_vigencia, fim_vigencia) VALUES (5, 5, 5, '2024-05-01', '2024-12-31');
