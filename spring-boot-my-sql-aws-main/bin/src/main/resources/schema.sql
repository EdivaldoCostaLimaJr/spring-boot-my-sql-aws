CREATE TABLE account_details
(
   id INTEGER GENERATED BY DEFAULT AS IDENTITY,
   product_name   VARCHAR (40),
   product_code   VARCHAR (40),
   line_item_type VARCHAR (40),
   bill_type      VARCHAR (40),
   billing_entity VARCHAR (40),
   PRIMARY KEY (id)
   );