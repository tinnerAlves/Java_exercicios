use Banco;

SELECT * FROM conta_poupanca;
SELECT titular, saldo FROM conta;
SELECT * FROM conta WHERE saldo > 100.00;
SELECT * FROM conta WHERE tipo = 'poupanca' ORDER BY saldo DESC;
SELECT COUNT(id) AS Quant_conta FROM conta;
SELECT tipo, COUNT(id) AS numeros_contas FROM conta GROUP BY tipo;

SELECT c.id, c.titular, transacao.tipo as tipo_transacao, SUM(transacao.valor) as total_depositado
FROM conta c
INNER JOIN transacao
ON c.id = transacao.conta_id
WHERE transacao.tipo = 'deposito' GROUP BY c.titular, transacao.conta_id;

SELECT c.titular, SUM(t.valor) AS total_depositado
FROM conta c
INNER JOIN transacao t ON c.id = t.conta_id
WHERE t.tipo = 'deposito'
GROUP BY c.titular;

SELECT c.id, c.titular
FROM conta c
LEFT JOIN transacao t
ON c.id = t.conta_id
WHERE t.conta_id is  NULL;




select * from transacao;
