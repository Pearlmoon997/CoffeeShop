--product 더미데이터
INSERT INTO product(id, name, price, category) VALUES (1, '에스프레소', 4000, '커피');
INSERT INTO product(id, name, price, category) VALUES (2, '아메리카노', 4500, '커피');
INSERT INTO product(id, name, price, category) VALUES (3, '라떼', 4800, '커피');
INSERT INTO product(id, name, price, category) VALUES (4, '아이스티', 3800, 'Non 커피');
INSERT INTO product(id, name, price, category) VALUES (5, '우유', 2000, 'Non 커피');

--user 더미데이터
INSERT INTO user(id, email, user_name, age, phone_num, password) VALUES (1,'aaa@aa.com', '김일번', 26, '01012345678', 'a123');
INSERT INTO user(id, email, user_name, age, phone_num, password) VALUES (2, 'bbb@bb.com', '문이번', 23, '01043218765', 'b123');
INSERT INTO user(id, email, user_name, age, phone_num, password) VALUES (3, 'ccc@cc.com', '박삼번', 29, '01056781234', 'c123');

--Store 더미데이터
INSERT INTO store(id, name, location) VALUES (1, '기흥점', '용인');
INSERT INTO store(id, name, location) VALUES (2, '둔전점', '용인');
INSERT INTO store(id, name, location) VALUES (3, '강남점', '서울');

--order 더미데이터
INSERT INTO orders(id, user_id, store_id, order_date) VALUES (1, 1, 1, current_timestamp);
INSERT INTO orders(id, user_id, store_id, order_date) VALUES (2, 2, 2, current_timestamp);
INSERT INTO orders(id, user_id, store_id, order_date) VALUES (3, 3, 3, current_timestamp);

--orderProduct 더미데이터
INSERT INTO order_product(id, order_id, product_id, total) VALUES (1, 1, 1, 4000);
INSERT INTO order_product(id, order_id, product_id, total) VALUES (2, 2, 3, 4800);
INSERT INTO order_product(id, order_id, product_id, total) VALUES (3, 3, 5, 2000);

