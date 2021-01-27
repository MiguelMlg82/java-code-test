-- Point 1
SELECT DISTINCT (col1, col2,...) FROM table1;

-- Point 2
INSERT INTO table1 (col1, col2, col3, ...) VALUES (val1, val2, val3, ...);

-- Point 3
-- Taking as an example a table called CUSTOMER, with fields CUSTOMER_NAME and CUSTOMER_ID
-- and a table called ORDERS, with fields ORDER_ID_ and CUSTOMER_ID
SELECT CUSTOMER.CUSTOMER_NAME, ORDERS.ORDER_ID FROM CUSTOMER 
LEFT JOIN ORDERS ON CUSTOMER.CUSTOMER_ID = ORDERS.CUSTOMER_ID
ORDER BY CUSTOMER.CUSTOMER_NAME;