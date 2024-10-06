INSERT INTO "CUSTOMER" (ID, DATE_REGISTERED,NAME,PHONE_NUMBER,STATUS ) VALUES
(CUSTOMER_SEQ.NEXTVAL, '04-Oct-2024', 'Vimal Kumar', '+919922334466', 'Active'),
(CUSTOMER_SEQ.NEXTVAL, '03-Oct-2024', 'Abhishek Kumar', '+919922334444', 'Active');


INSERT INTO "ACCOUNT" (balance,id,account_number, account_type, customerid , date_opened,status  ) VALUES
(50000.3, ACCOUNT_SEQ.NEXTVAL, 'AC00001', 'Savings', '1', '04-Sep-2024', 'Active'),
(60000.3, ACCOUNT_SEQ.NEXTVAL, 'AC00002', 'Savings', '2', '05-Sep-2024', 'Active');

INSERT INTO "TRANSACTION" (amount, id, account,date_transacted,status , transaction_type) VALUES
(500.0, TRANSACTION_SEQ.NEXTVAL, 'AC00001', '06-Oct-2024', 'Success', 'Debit'),
(1500.0, TRANSACTION_SEQ.NEXTVAL, 'AC00001', '07-Oct-2024', 'Success', 'Credit'),
(200.0, TRANSACTION_SEQ.NEXTVAL, 'AC00002', '07-Oct-2024', 'Success', 'Credit');

