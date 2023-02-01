﻿/* RELATÓRIO DE PRODUTOS E CATEGORIAS */
SELECT C.ID, C.NOME AS CATEGORIA, P.ID, P.NOME AS PRODUTO, P.PRECO FROM CATEGORIAS C INNER JOIN PRODUTOS P ON C.ID = P.CATEGORIA_ID ORDER BY CATEGORIA, PRODUTO ASC;

/* RELATÓRIO COMPLETO DE PEDIDOS */
SELECT CL.NOME AS CLIENTE, CA.NOME AS CATEGORIA, PR.NOME AS PRODUTO, I.PRECO_UNITARIO, I.QUANTIDADE, PE.DATA FROM CATEGORIAS CA INNER JOIN PRODUTOS PR ON CA.ID = PR.CATEGORIA_ID INNER JOIN ITEM_PEDIDO I ON PR.ID = I.PRODUTO_ID INNER JOIN PEDIDOS PE ON I.PEDIDO_ID = PE.ID INNER JOIN CLIENTES CL ON PE.CLIENTE_ID = CL.ID ORDER BY CL.NOME, CA.NOME ASC;

/* RELATÓRIO DE VENDAS POR CATEGORIAS */
SELECT CA.NOME, SUM(PR.PRECO * I.QUANTIDADE) AS TOTAL FROM CATEGORIAS CA INNER JOIN PRODUTOS PR ON CA.ID = PR.CATEGORIA_ID INNER JOIN ITEM_PEDIDO I ON PR.ID = I.PRODUTO_ID GROUP BY CA.NOME ORDER BY TOTAL DESC;

/* RELATÓRIO ANALÍTICO DE PEDIDOS */
SELECT COUNT(PE.ID) AS PEDIDOS_REALIZADOS, SUM(I.QUANTIDADE) AS PRODUTOS_VENDIDOS, MIN(I.PRECO_UNITARIO * I.QUANTIDADE) AS PEDIDO_MAIS_BARATO, MAX(I.PRECO_UNITARIO * I.QUANTIDADE) AS PEDIDO_MAIS_CARO, SUM(I.PRECO_UNITARIO * I.QUANTIDADE) AS MONTANTE_VENDIDO FROM PEDIDOS PE INNER JOIN ITEM_PEDIDO I ON PE.ID = I.PEDIDO_ID;