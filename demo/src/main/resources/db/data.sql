-- Inserir um usuário
INSERT INTO usuario (usuario, senha) VALUES ('admin', 'password');

-- Inserir 10 clientes
INSERT INTO cliente (nome, email) VALUES ('John Doe', 'john.doe@example.com');
INSERT INTO cliente (nome, email) VALUES ('Jane Smith', 'jane.smith@example.com');
INSERT INTO cliente (nome, email) VALUES ('Michael Johnson', 'michael.johnson@example.com');
INSERT INTO cliente (nome, email) VALUES ('Emily Davis', 'emily.davis@example.com');
INSERT INTO cliente (nome, email) VALUES ('Chris Brown', 'chris.brown@example.com');
INSERT INTO cliente (nome, email) VALUES ('Jessica Wilson', 'jessica.wilson@example.com');
INSERT INTO cliente (nome, email) VALUES ('David Martinez', 'david.martinez@example.com');
INSERT INTO cliente (nome, email) VALUES ('Laura Lee', 'laura.lee@example.com');
INSERT INTO cliente (nome, email) VALUES ('Daniel Anderson', 'daniel.anderson@example.com');
INSERT INTO cliente (nome, email) VALUES ('Sarah Thomas', 'sarah.thomas@example.com');

-- Inserir 5 aplicativos
INSERT INTO aplicativo (nome, custo_mensal) VALUES ('Netflix', 15.99);
INSERT INTO aplicativo (nome, custo_mensal) VALUES ('Spotify', 9.99);
INSERT INTO aplicativo (nome, custo_mensal) VALUES ('Amazon Prime', 12.99);
INSERT INTO aplicativo (nome, custo_mensal) VALUES ('Hulu', 11.99);
INSERT INTO aplicativo (nome, custo_mensal) VALUES ('Disney+', 7.99);

-- Inserir 5 assinaturas
INSERT INTO assinatura (inicio_vigencia, fim_vigencia, aplicativo_codigo, cliente_codigo) VALUES ('2024-01-01', '2024-12-31', 1, 1);
INSERT INTO assinatura (inicio_vigencia, fim_vigencia, aplicativo_codigo, cliente_codigo) VALUES ('2024-02-01', '2024-12-31', 2, 2);
INSERT INTO assinatura (inicio_vigencia, fim_vigencia, aplicativo_codigo, cliente_codigo) VALUES ('2024-03-01', '2024-12-31', 3, 3);
INSERT INTO assinatura (inicio_vigencia, fim_vigencia, aplicativo_codigo, cliente_codigo) VALUES ('2024-04-01', '2024-12-31', 4, 4);
INSERT INTO assinatura (inicio_vigencia, fim_vigencia, aplicativo_codigo, cliente_codigo) VALUES ('2024-05-01', '2024-12-31', 5, 5);
