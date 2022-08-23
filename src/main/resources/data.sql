--product 더미데이터
INSERT INTO product(id, name, price, category) VALUES (1, '에스프레소', 4000, '커피');
INSERT INTO product(id, name, price, category) VALUES (2, '아메리카노', 4500, '커피');
INSERT INTO product(id, name, price, category) VALUES (3, '라떼', 4800, '커피');
INSERT INTO product(id, name, price, category) VALUES (4, '아이스티', 3800, 'Non 커피');
INSERT INTO product(id, name, price, category) VALUES (5, '우유', 2000, 'Non 커피');

--user 더미데이터
INSERT INTO user(id, token, name, birth, phone_num) VALUES (1,'aaa', '김일번', '1982', '010-1234-5678');
INSERT INTO user(id, token, name, birth, phone_num) VALUES (2, 'bbb', '문이번', '1994', '010-4321-8765');
INSERT INTO user(id, token, name, birth, phone_num) VALUES (3, 'ccc', '박삼번', '1990', '010-5678-1234');

--order 더미데이터
INSERT INTO orders(id, user_id, order_date) VALUES (1, 1, current_timestamp);
INSERT INTO orders(id, user_id, order_date) VALUES (2, 2, current_timestamp);
INSERT INTO orders(id, user_id, order_date) VALUES (3, 3, current_timestamp);

--orderProduct 더미데이터
INSERT INTO order_product(id, order_id, product_id, total) VALUES (1, 1, 1, 4000);
INSERT INTO order_product(id, order_id, product_id, total) VALUES (2, 2, 3, 4800);
INSERT INTO order_product(id, order_id, product_id, total) VALUES (3, 3, 5, 2000);

