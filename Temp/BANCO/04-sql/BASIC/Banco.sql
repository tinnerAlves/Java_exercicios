CREATE DATABASE Banco;
/*Criou a DataBase*/

USE Banco;
/* defini qual database vou usar*/


/*CRIAÇAO DE TABELA */
CREATE TABLE conta (
    id INTEGER PRIMARY KEY,
    titular VARCHAR(150),
    saldo DECIMAL(10,2),
    tipo VARCHAR(20) 
);

CREATE TABLE conta_poupanca(
    id_conta INTEGER,
    tipo_conta VARCHAR(20),
    saldo DECIMAL(10, 2),
    Taxa double not null default 0,
    CONSTRAINT Fk_conta_poupanca
    FOREIGN KEY (id_conta) REFERENCES conta(id)
    ON UPDATE CASCADE
);


CREATE TABLE transacao (
    id INTEGER PRIMARY KEY,
    conta_id INTEGER,
    tipo VARCHAR(20),
    valor DECIMAL(10, 2)
);

/* INSERINDO CHAVE ESTRANGEIRO na Table TRANSACAO*/

ALTER TABLE transacao
ADD CONSTRAINT FK_conta_transacao
FOREIGN KEY (conta_id) REFERENCES conta(id)
ON UPDATE CASCADE;


/* INSERINDO VALORES DA Tabela conta*/
INSERT INTO conta VALUES(0, 'Fernando', 100.00, 'comum');
/*-----------------------(valor do tipo INTEGER, AGORA UMA STRING, DECIMAL(COM PRECISAO 10, E 2 CASAS DECIMAIS), STRING DO TIPO DE CONTA)*/
INSERT INTO conta VALUES(1, 'Joana', 100.00, 'comum');

INSERT INTO conta VALUES(2, 'Maria', 200.00, 'poupanca');

INSERT INTO conta VALUES (3, 'Carlos', 50.00, 'comum');

INSERT INTO conta VALUES (4, 'Ana', 500.00, 'poupanca');

/*TRANSACAO*/
INSERT INTO transacao VALUES (1, 0, 'deposito', 50.00);
INSERT INTO transacao VALUES (2, 0, 'saque', 20.00);
INSERT INTO transacao VALUES (3, 2, 'deposito', 100.00);
INSERT INTO transacao VALUES (4, 4, 'saque', 30.00);
INSERT INTO transacao VALUES (5, 4, 'deposito', 10.00);





