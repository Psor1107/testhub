CREATE TABLE Usuario (
    id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    tipo VARCHAR(20) NOT NULL -- 'ADMIN' ou 'TESTER'
);

CREATE TABLE Projeto (
    id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao VARCHAR(1000),
    dataCriacao TIMESTAMP NOT NULL,
    dataFim TIMESTAMP NOT NULL
);

CREATE TABLE Projeto_Membro (
    projeto_id BIGINT NOT NULL,
    usuario_id BIGINT NOT NULL,
    PRIMARY KEY (projeto_id, usuario_id),
    FOREIGN KEY (projeto_id) REFERENCES Projeto(id),
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id)
);

CREATE TABLE Estrategia (
    id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao VARCHAR(1000),
    exemplos VARCHAR(2000),
    dicas VARCHAR(1000)
);

CREATE TABLE SessaoTeste (
    id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    estrategia_id BIGINT NOT NULL,
    tempoMinutos INT NOT NULL,
    descricao VARCHAR(1000),
    status VARCHAR(20) NOT NULL, -- 'CRIADO', 'EM_EXECUCAO', 'FINALIZADO'
    dataInicio TIMESTAMP,
    dataFim TIMESTAMP,
    projeto_id BIGINT NOT NULL,
    FOREIGN KEY (estrategia_id) REFERENCES Estrategia(id),
    FOREIGN KEY (projeto_id) REFERENCES Projeto(id)
);

CREATE TABLE Projeto_Admin (
    projeto_id BIGINT NOT NULL,
    admin_id BIGINT NOT NULL,
    PRIMARY KEY (projeto_id, admin_id),
    FOREIGN KEY (projeto_id) REFERENCES Projeto(id),
    FOREIGN KEY (admin_id) REFERENCES Usuario(id)
);

CREATE TABLE SessaoTeste_Tester (
    sessaoTeste_id BIGINT NOT NULL,
    tester_id BIGINT NOT NULL,
    PRIMARY KEY (sessaoTeste_id, tester_id),
    FOREIGN KEY (sessaoTeste_id) REFERENCES SessaoTeste(id),
    FOREIGN KEY (tester_id) REFERENCES Usuario(id)
);