CREATE OR REPLACE FUNCTION purchase_shop_log_file()
RETURNS TRIGGER AS $$
BEGIN
IF (TG_OP = 'DELETE') THEN
INSERT INTO shop_log_file SELECT 'D', now() , 'purchase', OLD.id  ;
RETURN OLD;
ELSIF (TG_OP = 'UPDATE') THEN
INSERT INTO shop_log_file SELECT 'U',  now() , 'purchase', new.id ;
RETURN NEW;
ELSIF (TG_OP = 'INSERT') THEN
INSERT INTO shop_log_file SELECT 'I',  now() , 'purchase', new.id ;
RETURN NEW;
END IF;
RETURN NULL;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER purchase_results_log_file
AFTER INSERT OR UPDATE OR DELETE ON purchase
FOR EACH ROW EXECUTE PROCEDURE purchase_shop_log_file();






CREATE OR REPLACE FUNCTION product_shop_log_file()
RETURNS TRIGGER AS $$
BEGIN
IF (TG_OP = 'DELETE') THEN
INSERT INTO shop_log_file SELECT 'D', now() , 'product', OLD.id  ;
RETURN OLD;
ELSIF (TG_OP = 'UPDATE') THEN
INSERT INTO shop_log_file SELECT 'U',  now() , 'product', new.id ;
RETURN NEW;
ELSIF (TG_OP = 'INSERT') THEN
INSERT INTO shop_log_file SELECT 'I',  now() , 'product', new.id ;
RETURN NEW;
END IF;
RETURN NULL;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER purchase_results_log_file
AFTER INSERT OR UPDATE OR DELETE ON product
FOR EACH ROW EXECUTE PROCEDURE product_shop_log_file();



CREATE OR REPLACE FUNCTION Account_shop_log_file()
RETURNS TRIGGER AS $$
BEGIN
IF (TG_OP = 'DELETE') THEN
INSERT INTO shop_log_file SELECT 'D', now() , 'Account', OLD.id  ;
RETURN OLD;
ELSIF (TG_OP = 'UPDATE') THEN
INSERT INTO shop_log_file SELECT 'U',  now() , 'Account', new.id ;
RETURN NEW;
ELSIF (TG_OP = 'INSERT') THEN
INSERT INTO shop_log_file SELECT 'I',  now() , 'Account', new.id ;
RETURN NEW;
END IF;
RETURN NULL;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER Account_results_log_file
AFTER INSERT OR UPDATE OR DELETE ON "user"
FOR EACH ROW EXECUTE PROCEDURE Account_shop_log_file();



CREATE OR REPLACE FUNCTION Purchase_shop_log_file()
RETURNS TRIGGER AS $$
BEGIN
IF (TG_OP = 'DELETE') THEN
INSERT INTO shop_log_file SELECT 'D', now() , 'Purchase', OLD.id  ;
RETURN OLD;
ELSIF (TG_OP = 'UPDATE') THEN
INSERT INTO shop_log_file SELECT 'U',  now() , 'Purchase', new.id ;
RETURN NEW;
ELSIF (TG_OP = 'INSERT') THEN
INSERT INTO shop_log_file SELECT 'I',  now() , 'Purchase', new.id ;
RETURN NEW;
END IF;
RETURN NULL;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER Purchase_results_log_file
AFTER INSERT OR UPDATE OR DELETE ON Purchase
FOR EACH ROW EXECUTE PROCEDURE Purchase_shop_log_file();



CREATE OR REPLACE FUNCTION Supplier_shop_log_file()
RETURNS TRIGGER AS $$
BEGIN
IF (TG_OP = 'DELETE') THEN
INSERT INTO shop_log_file SELECT 'D', now() , 'Supplier', OLD.id  ;
RETURN OLD;
ELSIF (TG_OP = 'UPDATE') THEN
INSERT INTO shop_log_file SELECT 'U',  now() , 'Supplier', new.id ;
RETURN NEW;
ELSIF (TG_OP = 'INSERT') THEN
INSERT INTO shop_log_file SELECT 'I',  now() , 'Supplier', new.id ;
RETURN NEW;
END IF;
RETURN NULL;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER Supplier_results_log_file
AFTER INSERT OR UPDATE OR DELETE ON Supplier
FOR EACH ROW EXECUTE PROCEDURE Supplier_shop_log_file();



CREATE OR REPLACE FUNCTION Client_shop_log_file()
RETURNS TRIGGER AS $$
BEGIN
IF (TG_OP = 'DELETE') THEN
INSERT INTO shop_log_file SELECT 'D', now() , 'Client', OLD.id  ;
RETURN OLD;
ELSIF (TG_OP = 'UPDATE') THEN
INSERT INTO shop_log_file SELECT 'U',  now() , 'Client', new.id ;
RETURN NEW;
ELSIF (TG_OP = 'INSERT') THEN
INSERT INTO shop_log_file SELECT 'I',  now() , 'Client', new.id ;
RETURN NEW;
END IF;
RETURN NULL;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER Client_results_log_file
AFTER INSERT OR UPDATE OR DELETE ON Client
FOR EACH ROW EXECUTE PROCEDURE Client_shop_log_file();
