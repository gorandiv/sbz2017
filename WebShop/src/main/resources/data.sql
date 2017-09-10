INSERT INTO consumption_threshold(id, range_from, range_to, calculus_function)
VALUES(1, 5000, 10000, 'TOTAL_2_PERCENT');

INSERT INTO consumption_threshold(id, range_from, range_to, calculus_function)
VALUES(2, 5000, 10000, 'TOTAL_5_PERCENT');

INSERT INTO consumption_threshold(id, range_from, range_to, calculus_function)
VALUES(3, 5000, 10000, 'TOTAL_10_PERCENT');

INSERT INTO consumption_threshold(id, range_from, range_to, calculus_function)
VALUES(4, 10000, 50000, 'TOTAL_5_PERCENT');

INSERT INTO consumption_threshold(id, range_from, range_to, calculus_function)
VALUES(5, 10000, 50000, 'TOTAL_10_PERCENT');

INSERT INTO consumption_threshold(id, range_from, range_to, calculus_function)
VALUES(6, 10000, 50000, 'TOTAL_15_PERCENT');

INSERT INTO consumption_threshold(id, range_from, range_to, calculus_function)
VALUES(7, 50000, 200000, 'TOTAL_10_PERCENT');

INSERT INTO consumption_threshold(id, range_from, range_to, calculus_function)
VALUES(8, 10000, 200000, 'TOTAL_15_PERCENT');

INSERT INTO consumption_threshold(id, range_from, range_to, calculus_function)
VALUES(9, 10000, 200000, 'TOTAL_20_PERCENT');

INSERT INTO buyer_category(id, buyer_category_code, buyer_category_name)
VALUES(1, 'copper', 'COPPER');

INSERT INTO buyer_category(id, buyer_category_code, buyer_category_name)
VALUES(2, 'silver', 'SILVER');

INSERT INTO buyer_category(id, buyer_category_code, buyer_category_name)
VALUES(3, 'gold', 'GOLD');

INSERT INTO buyer_category_consumption_thresholds(buyer_category_id, consumption_thresholds_id)
VALUES(1, 1);

INSERT INTO buyer_category_consumption_thresholds(buyer_category_id, consumption_thresholds_id)
VALUES(2, 2);

INSERT INTO buyer_category_consumption_thresholds(buyer_category_id, consumption_thresholds_id)
VALUES(3, 3);

INSERT INTO buyer_category_consumption_thresholds(buyer_category_id, consumption_thresholds_id)
VALUES(1, 4);

INSERT INTO buyer_category_consumption_thresholds(buyer_category_id, consumption_thresholds_id)
VALUES(2, 5);

INSERT INTO buyer_category_consumption_thresholds(buyer_category_id, consumption_thresholds_id)
VALUES(3, 6);

INSERT INTO buyer_category_consumption_thresholds(buyer_category_id, consumption_thresholds_id)
VALUES(1, 7);

INSERT INTO buyer_category_consumption_thresholds(buyer_category_id, consumption_thresholds_id)
VALUES(2, 8);

INSERT INTO buyer_category_consumption_thresholds(buyer_category_id, consumption_thresholds_id)
VALUES(3, 9);

INSERT INTO sys_user(id, username, password, name, last_name, registration_date, user_type) 
VALUES(1, 'b', 'b', 'Goran', 'Divovic', '19/08/2015', 'BUYER');

INSERT INTO buyer_profile(id, delivery_address, reward_points, category_id, buyer_id)
VALUES(1, 'Brace Krkljus 1, Novi Sad', 50, 2, 1);

INSERT INTO sys_user(id, username, password, name, last_name, registration_date, user_type) 
VALUES(2, 's', 's', 'Nikola', 'Smiljanic', '04/08/2017', 'SALESMAN');

INSERT INTO sys_user(id, username, password, name, last_name, registration_date, user_type) 
VALUES(3, 'm', 'm', 'Milan', 'Adamovic', '06/07/2017', 'MANAGER');

INSERT INTO product_category(id, product_category_code, parent_category_id, product_category_name, maximum_discount)
VALUES(1, '411Ab', null, 'Electronics', 25);

INSERT INTO product_category(id, product_category_code, parent_category_id, product_category_name, maximum_discount)
VALUES(2, '134aa', null, 'Organic food', 10);

INSERT INTO product_category(id, product_category_code, parent_category_id, product_category_name, maximum_discount)
VALUES(3, '123a', 1, 'TVs', 7);

INSERT INTO product_category(id, product_category_code, parent_category_id, product_category_name, maximum_discount)
VALUES(4, '123b', 1, 'Computers', 15);

INSERT INTO product_category(id, product_category_code, parent_category_id, product_category_name, maximum_discount)
VALUES(5, '123c', 1, 'Laptops', 10);

INSERT INTO product_category(id, product_category_code, parent_category_id, product_category_name, maximum_discount)
VALUES(6, 'caadbb', 2, 'Salads', 5);

INSERT INTO product_category(id, product_category_code, parent_category_id, product_category_name, maximum_discount)
VALUES(7, 'caab', 2, 'Rices', 7);

INSERT INTO product_category(id, product_category_code, parent_category_id, product_category_name, maximum_discount)
VALUES(8, '1234', null, 'Product of wide consumption', 10);

INSERT INTO product(id, product_code, product_name, category_id, prize, quantity, minimum_quantity, date_noted, refill_needed, active)
VALUES(1, '23133', 'TV FOX 12a', 3, 20000, 5, 2, '07/10/2017', false, true);

INSERT INTO product(id, product_code, product_name, category_id, prize, quantity, minimum_quantity, date_noted, refill_needed, active)
VALUES(2, '2313a3', 'TV Samsung 1a', 3, 35000, 10, 5, '07/09/2016', false, true);

INSERT INTO product(id, product_code, product_name, category_id, prize, quantity, minimum_quantity, date_noted, refill_needed, active)
VALUES(3, '43133', 'Assus x5ly', 4, 40000, 10, 5, '06/10/2017', false, true);

INSERT INTO product(id, product_code, product_name, category_id, prize, quantity, minimum_quantity, date_noted, refill_needed, active)
VALUES(4, '2c133', 'TV 421412', 3, 20000, 3, 7, '07/10/2017', true, true);

INSERT INTO product(id, product_code, product_name, category_id, prize, quantity, minimum_quantity, date_noted, refill_needed, active)
VALUES(5, '22133', 'TV hdX', 3, 20000, 3, 7, '07/10/2017', false, false);

INSERT INTO product(id, product_code, product_name, category_id, prize, quantity, minimum_quantity, date_noted, refill_needed, active)
VALUES(6, '231ddc', 'Green salad', 8, 50, 125, 20, '07/10/2017', false, true);
