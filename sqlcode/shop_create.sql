-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2019-05-01 17:59:44.724

-- tables
-- Table: client
CREATE TABLE client (
    id int  NOT NULL,
    full_name varchar(255)  NOT NULL,
    email varchar(255)  NOT NULL,
    phone varchar(15)  NOT NULL,
    CONSTRAINT client_pk PRIMARY KEY (id)
);

-- Table: product
CREATE TABLE product (
    id int  NOT NULL,
    product_category_id int  NOT NULL,
    name varchar(255)  NOT NULL,
    price decimal(12,2)  NOT NULL,
    description varchar(1000)  NOT NULL,
    url varchar(100)  NOT NULL,
    quantity int  NOT NULL,
    CONSTRAINT product_pk PRIMARY KEY (id)
);
ALTER TABLE product
ADD barcode varchar(255);
-- Table: product_category
CREATE TABLE product_category (
    id int  NOT NULL,
    name varchar(255)  NOT NULL,
    parent_category_id int  NULL,
    CONSTRAINT product_category_pk PRIMARY KEY (id)
);


-- Table: product_from_suppliers
CREATE TABLE product_from_suppliers (
    id int  NOT NULL,
    product_id int  NOT NULL,
    supplier_id int  NOT NULL,
    CONSTRAINT product_from_suppliers_pk PRIMARY KEY (id)
);

-- Table: purchase
CREATE TABLE purchase (
    id int  NOT NULL,
    purchase_no char(12)  NOT NULL,
    client_id int  NOT NULL,
    TotalCost decimal(12,2)  NOT NULL,
    user_id int  NOT NULL,
    CONSTRAINT purchase_pk PRIMARY KEY (id)
);

-- Table: purchase_item
CREATE TABLE purchase_item (
    id int  NOT NULL,
    purchase_id int  NOT NULL,
    product_id int  NOT NULL,
    quantity int  NOT NULL,
    cost decimal(12,2)  NOT NULL,
    CONSTRAINT purchase_item_pk PRIMARY KEY (id)
);

-- Table: supplier
CREATE TABLE supplier (
    id int  NOT NULL,
    Name varchar(255)  NOT NULL,
    address varchar(255)  NOT NULL,
    phone varchar(15)  NOT NULL,
    CONSTRAINT supplier_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
    id int  NOT NULL,
    name varchar(10)  NOT NULL,
    password varchar(10)  NOT NULL,
    type int  NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (id)
);
create table shop_log_file (operation char(1),
oper_time timestamp, job varchar(10) , id varchar(5),
primary key (oper_time,job, id));

-- foreign keys
-- Reference: client_purchase (table: purchase)
ALTER TABLE purchase ADD CONSTRAINT client_purchase
    FOREIGN KEY (client_id)
    REFERENCES client (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: product_category_product (table: product)
ALTER TABLE product ADD CONSTRAINT product_category_product
    FOREIGN KEY (product_category_id)
    REFERENCES product_category (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: product_category_product_category (table: product_category)
ALTER TABLE product_category ADD CONSTRAINT product_category_product_category
    FOREIGN KEY (parent_category_id)
    REFERENCES product_category (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: product_from_suppliers_product (table: product_from_suppliers)
ALTER TABLE product_from_suppliers ADD CONSTRAINT product_from_suppliers_product
    FOREIGN KEY (product_id)
    REFERENCES product (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: product_from_suppliers_supplier (table: product_from_suppliers)
ALTER TABLE product_from_suppliers ADD CONSTRAINT product_from_suppliers_supplier
    FOREIGN KEY (supplier_id)
    REFERENCES supplier (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: product_purchase_item (table: purchase_item)
ALTER TABLE purchase_item ADD CONSTRAINT product_purchase_item
    FOREIGN KEY (product_id)
    REFERENCES product (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: purchase_purchase_item (table: purchase_item)
ALTER TABLE purchase_item ADD CONSTRAINT purchase_purchase_item
    FOREIGN KEY (purchase_id)
    REFERENCES purchase (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: purchase_user (table: purchase)
ALTER TABLE purchase ADD CONSTRAINT purchase_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

