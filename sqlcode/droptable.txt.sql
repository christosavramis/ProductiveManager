-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2019-05-01 17:51:32.364

-- foreign keys
ALTER TABLE purchase
    DROP CONSTRAINT client_purchase;

ALTER TABLE product
    DROP CONSTRAINT product_category_product;

ALTER TABLE product_category
    DROP CONSTRAINT product_category_product_category;

ALTER TABLE product_from_suppliers
    DROP CONSTRAINT product_from_suppliers_product;

ALTER TABLE product_from_suppliers
    DROP CONSTRAINT product_from_suppliers_supplier;

ALTER TABLE purchase_item
    DROP CONSTRAINT product_purchase_item;

ALTER TABLE purchase_item
    DROP CONSTRAINT purchase_purchase_item;

ALTER TABLE purchase
    DROP CONSTRAINT purchase_user;

-- tables
DROP TABLE client;

DROP TABLE product;

DROP TABLE product_category;

DROP TABLE product_from_suppliers;

DROP TABLE purchase;

DROP TABLE purchase_item;

DROP TABLE supplier;

DROP TABLE "user";
drop table shop_log_file;
-- End of file.

