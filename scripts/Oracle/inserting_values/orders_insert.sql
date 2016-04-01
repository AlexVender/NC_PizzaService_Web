PROMPT orders_insert...
INSERT INTO ORDERS (ord_id, clnt_clnt_id, order_date, delivery_date, description)
VALUES (null, 1, sysdate, sysdate + 30/24/60, null);
INSERT INTO ORDERS (ord_id, clnt_clnt_id, order_date, delivery_date, description)
VALUES (null, 2, to_date('12.02.2016 14:46', 'DD.MM.YYYY HH24:MI'), to_date('12.02.2016 21:00', 'DD.MM.YYYY HH24:MI'), 'Доставка необходима точно в указанную дату.');
INSERT INTO ORDERS (ord_id, clnt_clnt_id, order_date, delivery_date, description)
VALUES (null, 2, trunc(sysdate - 1, 'MI'), sysdate, null);
commit;