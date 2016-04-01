INSERT INTO SAUCES (sc_id, price, title, description) VALUES (null, 100, 'Карри' , 'Классический индийский соус');
INSERT INTO SAUCES (sc_id, price, title, description) VALUES (null, 200, 'Сырный соус' , null);
INSERT INTO SAUCES (sc_id, price, title, description) VALUES (null, 50, 'Барбекю' , null);
INSERT INTO SAUCES (sc_id, price, title, description) VALUES (null, 120, 'Тэрияки' , 'Японский соус');
commit;

INSERT INTO DRINKS (drnk_id, volume, price, title, description) VALUES (null, 200 , 20, 'Черный чай', 'С бергамотом');
INSERT INTO DRINKS (drnk_id, volume, price, title, description) VALUES (null, 500 , 100, 'Молочный коктейль', null);
commit;

INSERT INTO INGREDIENTS (ingrd_id, title, description) VALUES (null, 'Томаты черри', null);
INSERT INTO INGREDIENTS (ingrd_id, title, description) VALUES (null, 'Томаты обычные', null);
INSERT INTO INGREDIENTS (ingrd_id, title, description) VALUES (null, 'Сыр Пармезан', null);
INSERT INTO INGREDIENTS (ingrd_id, title, description) VALUES (null, 'Оливки', 'Прямиком из Греции');
INSERT INTO INGREDIENTS (ingrd_id, title, description) VALUES (null, 'Маслины', null);
INSERT INTO INGREDIENTS (ingrd_id, title, description) VALUES (null, 'Сосиски', null);
INSERT INTO INGREDIENTS (ingrd_id, title, description) VALUES (null, 'Красный перец', null);
INSERT INTO INGREDIENTS (ingrd_id, title, description) VALUES (null, 'Сыр Камамбер', null);
INSERT INTO INGREDIENTS (ingrd_id, title, description) VALUES (null, 'Оливковое масло', null);
INSERT INTO INGREDIENTS (ingrd_id, title, description) VALUES (null, 'Чеснок', null);
INSERT INTO INGREDIENTS (ingrd_id, title, description) VALUES (null, 'Соль', null);
INSERT INTO INGREDIENTS (ingrd_id, title, description) VALUES (null, 'Перец', null);
commit;

INSERT INTO PIZZAS (pz_id, title, type, weight, price, description)
VALUES (null, 'Моцарелла', 'На толстом тесте', 900, 450, 'Классическая итальянская пицца');
INSERT INTO PIZZAS (pz_id, title, type, weight, price, description)
VALUES (null, 'Пепперони', 'На толстом тесте', 450, 250, 'Итало-американская пицца на тонком тесте');
INSERT INTO PIZZAS (pz_id, title, type, weight, price, description)
VALUES (null, 'Дьябло', 'На тонком тесте', 750, 650, 'Острая пицца');
commit;

INSERT INTO MEASUREMENT_UNITS(msru_id, title) VALUES (null, 'Килограмм');
INSERT INTO MEASUREMENT_UNITS(msru_id, title) VALUES (null, 'Грамм');
INSERT INTO MEASUREMENT_UNITS(msru_id, title) VALUES (null, 'Миллилитр');
INSERT INTO MEASUREMENT_UNITS(msru_id, title) VALUES (null, 'Литр');
INSERT INTO MEASUREMENT_UNITS(msru_id, title) VALUES (null, 'Штука');
INSERT INTO MEASUREMENT_UNITS(msru_id, title) VALUES (null, 'Столовая ложка');
INSERT INTO MEASUREMENT_UNITS(msru_id, title) VALUES (null, 'Чайная ложка');
commit;

INSERT INTO PIZZAS_INGREDIENTS (pz_pz_id, ingrd_ingrd_id, amount, msru_msru_id)
VALUES (1, 2, 100, 1);
INSERT INTO PIZZAS_INGREDIENTS (pz_pz_id, ingrd_ingrd_id, amount, msru_msru_id)
VALUES (1, 3, 50, 1);
INSERT INTO PIZZAS_INGREDIENTS (pz_pz_id, ingrd_ingrd_id, amount, msru_msru_id)
VALUES (1, 4, 350, 1);
INSERT INTO PIZZAS_INGREDIENTS (pz_pz_id, ingrd_ingrd_id, amount, msru_msru_id)
VALUES (1, 6, 20, 1);
INSERT INTO PIZZAS_INGREDIENTS (pz_pz_id, ingrd_ingrd_id, amount, msru_msru_id)
VALUES (1, 7, 1, 3);
INSERT INTO PIZZAS_INGREDIENTS (pz_pz_id, ingrd_ingrd_id, amount, msru_msru_id)
VALUES (3, 4, 2, 2);
commit;

INSERT INTO CLIENTS (clnt_id, name, address, phone_number)
VALUES (null, 'Иванов Иван Иванович', 'Ул. Гагарина, д.252, кв.42', '88005553535');
INSERT INTO CLIENTS (clnt_id, name, address, phone_number)
VALUES (null, 'Петров Петр Петрович', 'Ул. Победы д.142 2к кв.78', '260-50-48');
commit;

INSERT INTO ORDERS (ord_id, clnt_clnt_id, order_date, delivery_date, description)
VALUES (null, 1, sysdate, sysdate + 30/24/60, null);
INSERT INTO ORDERS (ord_id, clnt_clnt_id, order_date, delivery_date, description)
VALUES (null, 2, to_date('12.02.2016 14:46', 'DD.MM.YYYY HH24:MI'), to_date('12.02.2016 21:00', 'DD.MM.YYYY HH24:MI'), 'Доставка необходима точно в указанную дату.');
INSERT INTO ORDERS (ord_id, clnt_clnt_id, order_date, delivery_date, description)
VALUES (null, 2, trunc(sysdate - 1, 'MI'), sysdate, null);
commit;

INSERT INTO ORDERS_PIZZAS(ord_ord_id, pz_pz_id, amount)
VALUES (1, 1, 1);
INSERT INTO ORDERS_PIZZAS(ord_ord_id, pz_pz_id, amount)
VALUES (1, 2, 2);
INSERT INTO ORDERS_PIZZAS(ord_ord_id, pz_pz_id, amount)
VALUES (2, 2, 1);
INSERT INTO ORDERS_PIZZAS(ord_ord_id, pz_pz_id, amount)
VALUES (2, 3, 1);
INSERT INTO ORDERS_PIZZAS(ord_ord_id, pz_pz_id, amount)
VALUES (3, 1, 3);
INSERT INTO ORDERS_PIZZAS(ord_ord_id, pz_pz_id, amount)
VALUES (3, 2, 2);
INSERT INTO ORDERS_PIZZAS(ord_ord_id, pz_pz_id, amount)
VALUES (3, 3, 1);
commit;

INSERT INTO ORDERS_DRINKS (ord_ord_id, drnk_drnk_id, amount)
VALUES (1, 1, 5);
INSERT INTO ORDERS_DRINKS (ord_ord_id, drnk_drnk_id, amount)
VALUES (1, 2, 5);
INSERT INTO ORDERS_DRINKS (ord_ord_id, drnk_drnk_id, amount)
VALUES (3, 1, 1);
commit;

INSERT INTO ORDERS_SAUCES (ord_ord_id, sc_sc_id, amount)
VALUES (1, 2, 3);
INSERT INTO ORDERS_SAUCES (ord_ord_id, sc_sc_id, amount)
VALUES (3, 1, 1);
INSERT INTO ORDERS_SAUCES (ord_ord_id, sc_sc_id, amount)
VALUES (3, 2, 1);
INSERT INTO ORDERS_SAUCES (ord_ord_id, sc_sc_id, amount)
VALUES (3, 3, 1);
INSERT INTO ORDERS_SAUCES (ord_ord_id, sc_sc_id, amount)
VALUES (3, 4, 2);
commit;