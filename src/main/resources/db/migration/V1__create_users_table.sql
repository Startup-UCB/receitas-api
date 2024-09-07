CREATE TABLE IF NOT EXISTS usuarios (
    id_usuario SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    sobrenome VARCHAR(255), --necessário apenas de pessoa fisica--
    documento VARCHAR(14) NOT NULL,  --CPF / CNPJ--
    email VARCHAR(100) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    perfil VARCHAR(50) NOT NULL,
    UNIQUE(documento),
    UNIQUE(email)
);

CREATE TABLE IF NOT EXISTS enderecos (
    id_endereco SERIAL PRIMARY KEY,
    cep VARCHAR(8) NOT NULL,
    logradouro VARCHAR(50) NOT NULL,
    numero VARCHAR(10),
    bairro VARCHAR(50),
    complemento VARCHAR(50),
    pais VARCHAR(255) NOT NULL,
    cidade VARCHAR(255) NOT NULL,
    estado VARCHAR(2),
    id_usuario INT,
    FOREIGN KEY (id_usuario) REFERENCES usuarios (id_usuario) ON DELETE CASCADE
);