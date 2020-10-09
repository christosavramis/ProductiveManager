
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christos
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import resourses.Account;
import resourses.Category;
import resourses.Client;
import resourses.LogData;
import resourses.Product;
import resourses.Supplier;
public class DatabaseInfo {
    final static String     driverClassName = "org.postgresql.Driver" ;
    final static String     url             = "jdbc:postgresql://dblabs.it.teithe.gr:5432/it174918";
   static Connection dbConnection = null;
    final static String     username = "it174918";
    final static String     passwd = "880866";
   
   
   static Statement  statement       = null;
   static ResultSet rs		      = null;




    public static int lastID(String table){
        String selectString ="select max(id) as maxindex from "+table;
        int temp=0;
       try {
           Class.forName (driverClassName);
           dbConnection = DriverManager.getConnection (url, username, passwd);
           statement    = dbConnection.createStatement();
           rs = statement.executeQuery(selectString);
           rs.next();
           temp = rs.getInt("maxindex");
           statement.close();
           dbConnection.close();
       } 
       catch(SQLException ex) {
            System.out.println("\n -- SQL Exception --- \n");
            while(ex != null) {
                    System.out.println("Message: " + ex.getMessage());
                    System.out.println("SQLState: " + ex.getSQLState());
                    System.out.println("ErrorCode: " + ex.getErrorCode());
                    ex = ex.getNextException();
                    System.out.println("");
            }
       }
      catch (Exception ex) {System.out.println("_______________SQL_NOT_CONNECT____________");System.out.println("System will exit");System.exit(0);}
     
       return temp;
    }
    public static int UserCount(){
        String selectString ="SELECT count(*) as users FROM it174918.\"user\" \"userPro\";";
        int temp=0;
       try {
           Class.forName (driverClassName);
           dbConnection = DriverManager.getConnection (url, username, passwd);
           statement    = dbConnection.createStatement();
           rs = statement.executeQuery(selectString);
           rs.next();
           temp = rs.getInt("users");
           statement.close();
           dbConnection.close();
       } 
       catch(SQLException ex) {
           JOptionPane.showMessageDialog(null, "Lost Connection to the base , app closing");
            System.out.println("\n -- SQL Exception --- \n");
            while(ex != null) {
                    System.out.println("Message: " + ex.getMessage());
                    System.out.println("SQLState: " + ex.getSQLState());
                    System.out.println("ErrorCode: " + ex.getErrorCode());
                    ex = ex.getNextException();
                    System.out.println("");
            }
            System.exit(1);
       }
      catch (Exception ex) {System.out.println("_______________SQL_NOT_CONNECT____________");System.out.println("System will exit");System.exit(0);}
     
       return temp;
    }
    public static int UserExist(String selectString){
        int temp=-1;
       try {
           Class.forName (driverClassName);
           dbConnection = DriverManager.getConnection (url, username, passwd);
           statement    = dbConnection.createStatement();
           rs = statement.executeQuery(selectString);

           if(rs.next());
           temp = rs.getInt("type");
           statement.close();
           dbConnection.close();
       } 
       catch(SQLException ex) {
            System.out.println("\n -- SQL Exception --- \n");
            while(ex != null) {
                    System.out.println("Message: " + ex.getMessage());
                    System.out.println("SQLState: " + ex.getSQLState());
                    System.out.println("ErrorCode: " + ex.getErrorCode());
                    ex = ex.getNextException();
                    System.out.println("");
            }
       }
      catch (Exception ex) {System.out.println("_______________SQL_NOT_CONNECT____________");System.out.println("System will exit");System.exit(0);}
     
       return temp;
    }
    public static int UserID(String username1,String password){
        int temp=-1;
       String selectString="select id\n" +
        "from \"user\" \n" +
        "where name = '"+username1+"'";
       try {
           Class.forName (driverClassName);
           dbConnection = DriverManager.getConnection (url, username, passwd);
           statement    = dbConnection.createStatement();
           rs = statement.executeQuery(selectString);
            if(rs.next());
           temp = rs.getInt("id");
           statement.close();
           dbConnection.close();
       } 
       catch(SQLException ex) {
            System.out.println("\n -- SQL Exception --- \n");
            while(ex != null) {
                    System.out.println("Message: " + ex.getMessage());
                    System.out.println("SQLState: " + ex.getSQLState());
                    System.out.println("ErrorCode: " + ex.getErrorCode());
                    ex = ex.getNextException();
                    System.out.println("");
            }
       }
      catch (Exception ex) {System.out.println("_______________SQL_NOT_CONNECT____________");System.out.println("System will exit");System.exit(0);}
     
       return temp;
    }
    
    
    public static void executeInsert(String command){
        try {
           Class.forName (driverClassName);
           dbConnection = DriverManager.getConnection (url, username, passwd);
           statement    = dbConnection.createStatement();
           statement.executeUpdate(command);
 
       } 
       catch(SQLException ex) {
            System.out.println("\n -- SQL Exception --- \n");
            while(ex != null) {
                    System.out.println("Message: " + ex.getMessage());
                    System.out.println("SQLState: " + ex.getSQLState());
                    System.out.println("ErrorCode: " + ex.getErrorCode());
                    ex = ex.getNextException();
                    System.out.println("");
            }
       }
       catch (Exception ex) {System.out.println("_______________SQL_NOT_CONNECT____________");System.out.println("System will exit");System.exit(0);}
     
    }
    
    public static Category[] loadCategories(){
        ArrayList<Category> ints = new ArrayList<>();
        String selectString ="select id,name from product_category";
       try {
           Class.forName (driverClassName);
           dbConnection = DriverManager.getConnection (url, username, passwd);
           statement    = dbConnection.createStatement();
           rs = statement.executeQuery(selectString);
           while(rs.next()){
               int id = rs.getInt("id");
               String name = rs.getString("name");
           ints.add(new Category(id,name));
           //System.out.println(id +" "+name);
           }
           statement.close();
           dbConnection.close();
       } 
       catch(SQLException ex) {
            System.out.println("\n -- SQL Exception --- \n");
            while(ex != null) {
                    System.out.println("Message: " + ex.getMessage());
                    System.out.println("SQLState: " + ex.getSQLState());
                    System.out.println("ErrorCode: " + ex.getErrorCode());
                    ex = ex.getNextException();
                    System.out.println("");
            }
       }
       catch (Exception ex) {System.out.println("_______________SQL_NOT_CONNECT____________");System.out.println("System will exit");System.exit(0);}
        
        Category tempC [] = new Category[ints.size()];
        for(int i =0 ;i<ints.size();i++){
            tempC[i] = ints.get(i);
        }
 
        return tempC;
    }
    public static Supplier[] loadSuppliers() {
           ArrayList<Supplier> ints = new ArrayList<>();
           String selectString ="select id,name from Supplier";
           try {
               Class.forName (driverClassName);
               dbConnection = DriverManager.getConnection (url, username, passwd);
               statement    = dbConnection.createStatement();
               rs = statement.executeQuery(selectString);
               while(rs.next()){
                   int id = rs.getInt("id");
                   String name = rs.getString("name");
               ints.add(new Supplier(id,name));
               //System.out.println(id +" "+name);
               }
               statement.close();
               dbConnection.close();
           } 
           catch(SQLException ex) {
                System.out.println("\n -- SQL Exception --- \n");
                while(ex != null) {
                        System.out.println("Message: " + ex.getMessage());
                        System.out.println("SQLState: " + ex.getSQLState());
                        System.out.println("ErrorCode: " + ex.getErrorCode());
                        ex = ex.getNextException();
                        System.out.println("");
                }
           }
           catch (Exception ex) {System.out.println("_______________SQL_NOT_CONNECT____________");System.out.println("System will exit");System.exit(0);}

            Supplier tempS [] = new Supplier[ints.size()];
            for(int i =0 ;i<ints.size();i++){
                tempS[i] = ints.get(i);
            }

            return tempS;
    }
    
    public static void deletefromtable(String table,int id){
        String command = "delete from "+table+" where id ="+id+" ";
        try {
           Class.forName (driverClassName);
           dbConnection = DriverManager.getConnection (url, username, passwd);
           statement    = dbConnection.createStatement();
           statement.execute(command);
           statement.close();
           dbConnection.close();
       } 
       catch(SQLException ex) {
            System.out.println("\n -- SQL Exception --- \n");
            while(ex != null) {
                    System.out.println("Message: " + ex.getMessage());
                    System.out.println("SQLState: " + ex.getSQLState());
                    System.out.println("ErrorCode: " + ex.getErrorCode());
                    ex = ex.getNextException();
                    System.out.println("");
                    
            }
            JOptionPane.showMessageDialog(null, table+" cant be deleted since other entities use it");
       }
       catch (Exception ex) {System.out.println("_______________SQL_NOT_CONNECT____________");System.out.println("System will exit");System.exit(0);}
    }

    /**
     *
     * @param table
     * @param id
     */
    public static void deletefromtable(String table,ArrayList id){
        String tempids="";

        tempids=id.toString().substring(1, id.toString().length()-1);
        
        String command = "delete from "+table+" where id in ( "+tempids+" )";
        System.out.println(command);
        try {
           Class.forName (driverClassName);
           dbConnection = DriverManager.getConnection (url, username, passwd);
           statement    = dbConnection.createStatement();
           statement.execute(command);
           statement.close();
           dbConnection.close();
       } 
       catch(SQLException ex) {
            System.out.println("\n -- SQL Exception --- \n");
            while(ex != null) {
                    System.out.println("Message: " + ex.getMessage());
                    System.out.println("SQLState: " + ex.getSQLState());
                    System.out.println("ErrorCode: " + ex.getErrorCode());
                    ex = ex.getNextException();
                    System.out.println("");
                    
            }
            JOptionPane.showMessageDialog(null, table+" cant be deleted since other entities use it");
       }
       catch (Exception ex) {System.out.println("_______________SQL_NOT_CONNECT____________");System.out.println("System will exit");System.exit(0);}
    }

    public static Product[] loadProducts() {
       ArrayList<Product> ints = new ArrayList<>();
       String selectString ="select p.id as product_id,ps.id as supplier_product,p.name,p.price,p.quantity,p.url,c.name as category_name,s.name as supplier_name\n" +
                            "from product_from_suppliers as ps inner join product as p on p.id = ps.product_id inner join supplier as s on s.id = ps.supplier_id inner join product_category as c on c.id = p.product_category_id";
           try {
               Class.forName (driverClassName);
               dbConnection = DriverManager.getConnection (url, username, passwd);
               statement    = dbConnection.createStatement();
               rs = statement.executeQuery(selectString);
               while(rs.next()){
                   int id = rs.getInt("product_id");
                   int idsp = rs.getInt("supplier_product");
                   String name = rs.getString("name");
                   double price = rs.getDouble("price");
                   int quantity = rs.getInt("quantity");
                   String nameS = rs.getString("supplier_name");
                   String nameC = rs.getString("category_name");
               ints.add(new Product(id,idsp,quantity,price, name, nameS, nameC));
               //System.out.println(id +" "+name);
               }
               statement.close();
               dbConnection.close();
           } 
           catch(SQLException ex) {
                System.out.println("\n -- SQL Exception --- \n");
                while(ex != null) {
                        System.out.println("Message: " + ex.getMessage());
                        System.out.println("SQLState: " + ex.getSQLState());
                        System.out.println("ErrorCode: " + ex.getErrorCode());
                        ex = ex.getNextException();
                        System.out.println("");
                }
           }
           catch (Exception ex) {System.out.println("_______________SQL_NOT_CONNECT____________");System.out.println("System will exit");System.exit(0);}

            Product tempS [] = new Product[ints.size()];
            for(int i =0 ;i<ints.size();i++){
                tempS[i] = ints.get(i);
            }

            return tempS;
    }
    public static Product loadProductWD(int id) {
       Product tempS= null;
       String selectString ="select p.id as product_id,p.description as desc,ps.id as supplier_product,p.name,p.price,p.quantity,p.url,c.name as category_name,s.name as supplier_name,p.barcode as barcode\n" +
                            "from product_from_suppliers as ps inner join product as p on p.id = ps.product_id inner join supplier as s on s.id = ps.supplier_id inner join product_category as c on c.id = p.product_category_id"
                            +"\n where p.id = "+id;
           try {
               Class.forName (driverClassName);
               dbConnection = DriverManager.getConnection (url, username, passwd);
               statement    = dbConnection.createStatement();
               rs = statement.executeQuery(selectString);
               while(rs.next()){
                   int idsp = rs.getInt("supplier_product");
                   String name = rs.getString("name");
                   double price = rs.getDouble("price");
                   int quantity = rs.getInt("quantity");
                   String nameS = rs.getString("supplier_name");
                   String nameC = rs.getString("category_name");
                   String desc = rs.getString("desc");
                   String url = rs.getString("url");
                   String barcode = rs.getString("barcode");
               tempS = new Product(id,idsp,quantity,price, name, nameS, nameC, desc,url,barcode);
               //System.out.println(id +" "+name);
               }
               statement.close();
               dbConnection.close();
           } 
           catch(SQLException ex) {
                System.out.println("\n -- SQL Exception --- \n");
                while(ex != null) {
                        System.out.println("Message: " + ex.getMessage());
                        System.out.println("SQLState: " + ex.getSQLState());
                        System.out.println("ErrorCode: " + ex.getErrorCode());
                        ex = ex.getNextException();
                        System.out.println("");
                }
           }
           catch (Exception ex) {System.out.println("_______________SQL_NOT_CONNECT____________");System.out.println("System will exit");System.exit(0);}
           return tempS;
    }
    public static Product loadProductWU(int id) {
       Product tempS= null;
       String selectString ="select p.id as product_id,p.description as desc,ps.id as supplier_product,p.name,p.price,p.quantity,p.url,c.name as category_name,s.name as supplier_name,p.barcode as barcode\n" +
                            "from product_from_suppliers as ps inner join product as p on p.id = ps.product_id inner join supplier as s on s.id = ps.supplier_id inner join product_category as c on c.id = p.product_category_id"
                            +"\n where p.id = "+id;
           try {
               Class.forName (driverClassName);
               dbConnection = DriverManager.getConnection (url, username, passwd);
               statement    = dbConnection.createStatement();
               rs = statement.executeQuery(selectString);
               while(rs.next()){
                   int idsp = rs.getInt("supplier_product");
                   String name = rs.getString("name");
                   double price = rs.getDouble("price");
                   int quantity = rs.getInt("quantity");
                   String nameS = rs.getString("supplier_name");
                   String nameC = rs.getString("category_name");
                   String desc = rs.getString("desc");
                   String url = rs.getString("url");
                   String barcode = rs.getString("barcode");
               tempS = new Product(id,idsp,quantity,price, name, nameS, nameC, desc ,url,barcode);
               //System.out.println(id +" "+name);
               }
               statement.close();
               dbConnection.close();
           } 
           catch(SQLException ex) {
                System.out.println("\n -- SQL Exception --- \n");
                while(ex != null) {
                        System.out.println("Message: " + ex.getMessage());
                        System.out.println("SQLState: " + ex.getSQLState());
                        System.out.println("ErrorCode: " + ex.getErrorCode());
                        ex = ex.getNextException();
                        System.out.println("");
                }
           }
           catch (Exception ex) {System.out.println("_______________SQL_NOT_CONNECT____________");System.out.println("System will exit");System.exit(0);}
           return tempS;
    }

    static void ResetSchemma() {
        String command = "-- Created by Vertabelo (http://vertabelo.com)\n" +
        "-- Last modification date: 2019-05-01 17:51:32.364\n" +
        "\n" +
        "-- foreign keys\n" +
        "ALTER TABLE purchase\n" +
        "    DROP CONSTRAINT client_purchase;\n" +
        "\n" +
        "ALTER TABLE product\n" +
        "    DROP CONSTRAINT product_category_product;\n" +
        "\n" +
        "ALTER TABLE product_category\n" +
        "    DROP CONSTRAINT product_category_product_category;\n" +
        "\n" +
        "ALTER TABLE product_from_suppliers\n" +
        "    DROP CONSTRAINT product_from_suppliers_product;\n" +
        "\n" +
        "ALTER TABLE product_from_suppliers\n" +
        "    DROP CONSTRAINT product_from_suppliers_supplier;\n" +
        "\n" +
        "ALTER TABLE purchase_item\n" +
        "    DROP CONSTRAINT product_purchase_item;\n" +
        "\n" +
        "ALTER TABLE purchase_item\n" +
        "    DROP CONSTRAINT purchase_purchase_item;\n" +
        "\n" +
        "ALTER TABLE purchase\n" +
        "    DROP CONSTRAINT purchase_user;\n" +
        "\n" +
        "-- tables\n" +
        "DROP TABLE client;\n" +
        "\n" +
        "DROP TABLE product;\n" +
        "\n" +
        "DROP TABLE product_category;\n" +
        "\n" +
        "DROP TABLE product_from_suppliers;\n" +
        "\n" +
        "DROP TABLE purchase;\n" +
        "\n" +
        "DROP TABLE purchase_item;\n" +
        "\n" +
        "DROP TABLE supplier;\n" +
        "\n" +
        "DROP TABLE \"user\";\n" +
        "drop table shop_log_file;\n"+
        "\n" +
        "-- End of file.\n" +
        "";
        String command2="-- Created by Vertabelo (http://vertabelo.com)\n" +
        "-- Last modification date: 2019-05-01 17:59:44.724\n" +
        "\n" +
        "-- tables\n" +
        "-- Table: client\n" +
        "CREATE TABLE client (\n" +
        "    id int  NOT NULL,\n" +
        "    full_name varchar(255)  NOT NULL,\n" +
        "    email varchar(255)  NOT NULL,\n" +
        "    phone varchar(15)  NOT NULL,\n" +
        "    CONSTRAINT client_pk PRIMARY KEY (id)\n" +
        ");\n" +
        "\n" +
        "-- Table: product\n" +
        "CREATE TABLE product (\n" +
        "    id int  NOT NULL,\n" +
        "    product_category_id int  NOT NULL,\n" +
        "    name varchar(255)  NOT NULL,\n" +
        "    price decimal(12,2)  NOT NULL,\n" +
        "    description varchar(1000)  NOT NULL,\n" +
        "    url varchar(100)  NOT NULL,\n" +
        "    quantity int  NOT NULL,\n" +
        "    CONSTRAINT product_pk PRIMARY KEY (id)\n" +
        ");\n" +
        "ALTER TABLE product\n" +
        "ADD barcode varchar(255);"+  
        "\n" +
        "create table shop_log_file (operation char(1),\n" +
        "oper_time timestamp, job varchar(10) , id varchar(5),\n" +
        "primary key (oper_time,job, id));"+
        "-- Table: product_category\n" +
        "CREATE TABLE product_category (\n" +
        "    id int  NOT NULL,\n" +
        "    name varchar(255)  NOT NULL,\n" +
        "    parent_category_id int  NULL,\n" +
        "    CONSTRAINT product_category_pk PRIMARY KEY (id)\n" +
        ");\n" +
        "\n" +
        "-- Table: product_from_suppliers\n" +
        "CREATE TABLE product_from_suppliers (\n" +
        "    id int  NOT NULL,\n" +
        "    product_id int  NOT NULL,\n" +
        "    supplier_id int  NOT NULL,\n" +
        "    CONSTRAINT product_from_suppliers_pk PRIMARY KEY (id)\n" +
        ");\n" +
        "\n" +
        "-- Table: purchase\n" +
        "CREATE TABLE purchase (\n" +
        "    id int  NOT NULL,\n" +
        "    purchase_no char(12)  NOT NULL,\n" +
        "    client_id int  NOT NULL,\n" +
        "    TotalCost decimal(12,2)  NOT NULL,\n" +
        "    user_id int  NOT NULL,\n" +
        "    CONSTRAINT purchase_pk PRIMARY KEY (id)\n" +
        ");\n" +
        "\n" +
        "-- Table: purchase_item\n" +
        "CREATE TABLE purchase_item (\n" +
        "    id int  NOT NULL,\n" +
        "    purchase_id int  NOT NULL,\n" +
        "    product_id int  NOT NULL,\n" +
        "    quantity int  NOT NULL,\n" +
        "    cost decimal(12,2)  NOT NULL,\n" +
        "    CONSTRAINT purchase_item_pk PRIMARY KEY (id)\n" +
        ");\n" +
        "\n" +
        "-- Table: supplier\n" +
        "CREATE TABLE supplier (\n" +
        "    id int  NOT NULL,\n" +
        "    Name varchar(255)  NOT NULL,\n" +
        "    address varchar(255)  NOT NULL,\n" +
        "    phone varchar(15)  NOT NULL,\n" +
        "    CONSTRAINT supplier_pk PRIMARY KEY (id)\n" +
        ");\n" +
        "\n" +
        "-- Table: user\n" +
        "CREATE TABLE \"user\" (\n" +
        "    id int  NOT NULL,\n" +
        "    name varchar(10)  NOT NULL,\n" +
        "    password varchar(10)  NOT NULL,\n" +
        "    type int  NOT NULL,\n" +
        "    CONSTRAINT user_pk PRIMARY KEY (id)\n" +
        ");\n" +
        "\n" +
        "-- foreign keys\n" +
        "-- Reference: client_purchase (table: purchase)\n" +
        "ALTER TABLE purchase ADD CONSTRAINT client_purchase\n" +
        "    FOREIGN KEY (client_id)\n" +
        "    REFERENCES client (id)  \n" +
        "    NOT DEFERRABLE \n" +
        "    INITIALLY IMMEDIATE\n" +
        ";\n" +
        "\n" +
        "-- Reference: product_category_product (table: product)\n" +
        "ALTER TABLE product ADD CONSTRAINT product_category_product\n" +
        "    FOREIGN KEY (product_category_id)\n" +
        "    REFERENCES product_category (id)  \n" +
        "    NOT DEFERRABLE \n" +
        "    INITIALLY IMMEDIATE\n" +
        ";\n" +
        "\n" +
        "-- Reference: product_category_product_category (table: product_category)\n" +
        "ALTER TABLE product_category ADD CONSTRAINT product_category_product_category\n" +
        "    FOREIGN KEY (parent_category_id)\n" +
        "    REFERENCES product_category (id)  \n" +
        "    NOT DEFERRABLE \n" +
        "    INITIALLY IMMEDIATE\n" +
        ";\n" +
        "\n" +
        "-- Reference: product_from_suppliers_product (table: product_from_suppliers)\n" +
        "ALTER TABLE product_from_suppliers ADD CONSTRAINT product_from_suppliers_product\n" +
        "    FOREIGN KEY (product_id)\n" +
        "    REFERENCES product (id)  \n" +
        "    NOT DEFERRABLE \n" +
        "    INITIALLY IMMEDIATE\n" +
        ";\n" +
        "\n" +
        "-- Reference: product_from_suppliers_supplier (table: product_from_suppliers)\n" +
        "ALTER TABLE product_from_suppliers ADD CONSTRAINT product_from_suppliers_supplier\n" +
        "    FOREIGN KEY (supplier_id)\n" +
        "    REFERENCES supplier (id)  \n" +
        "    NOT DEFERRABLE \n" +
        "    INITIALLY IMMEDIATE\n" +
        ";\n" +
        "\n" +
        "-- Reference: product_purchase_item (table: purchase_item)\n" +
        "ALTER TABLE purchase_item ADD CONSTRAINT product_purchase_item\n" +
        "    FOREIGN KEY (product_id)\n" +
        "    REFERENCES product (id)  \n" +
        "    NOT DEFERRABLE \n" +
        "    INITIALLY IMMEDIATE\n" +
        ";\n" +
        "\n" +
        "-- Reference: purchase_purchase_item (table: purchase_item)\n" +
        "ALTER TABLE purchase_item ADD CONSTRAINT purchase_purchase_item\n" +
        "    FOREIGN KEY (purchase_id)\n" +
        "    REFERENCES purchase (id)  \n" +
        "    NOT DEFERRABLE \n" +
        "    INITIALLY IMMEDIATE\n" +
        ";\n" +
        "\n" +
        "-- Reference: purchase_user (table: purchase)\n" +
        "ALTER TABLE purchase ADD CONSTRAINT purchase_user\n" +
        "    FOREIGN KEY (user_id)\n" +
        "    REFERENCES \"user\" (id)  \n" +
        "    NOT DEFERRABLE \n" +
        "    INITIALLY IMMEDIATE\n" +
        ";\n" +
        "\n" +
        "-- End of file.\n" +
        "";
        try {
               Class.forName (driverClassName);
               dbConnection = DriverManager.getConnection (url, username, passwd);
               statement    = dbConnection.createStatement();
               statement.execute(command);
               statement.close();
               dbConnection.close();
           } 
           catch(SQLException ex) {
                System.out.println("\n -- SQL Exception --- \n");
                while(ex != null) {
                        System.out.println("Message: " + ex.getMessage());
                        System.out.println("SQLState: " + ex.getSQLState());
                        System.out.println("ErrorCode: " + ex.getErrorCode());
                        ex = ex.getNextException();
                        System.out.println("");
                }
           }
           catch (ClassNotFoundException ex) {System.out.println("_______________SQL_NOT_CONNECT____________");System.out.println("System will exit");System.exit(0);}
    }

    static Client[] loadClient() {
        ArrayList<Client> ints = new ArrayList<>();
           String selectString ="select * from client";
           try {
               Class.forName (driverClassName);
               dbConnection = DriverManager.getConnection (url, username, passwd);
               statement    = dbConnection.createStatement();
               rs = statement.executeQuery(selectString);
               while(rs.next()){
                   int id = rs.getInt("id");
                   String name = rs.getString("full_name");
                   String email = rs.getString("email");
                   long phone = rs.getLong("phone");
               ints.add(new Client(id,name,email, phone));
               //System.out.println(id +" "+name);
               }
               statement.close();
               dbConnection.close();
           } 
           catch(SQLException ex) {
                System.out.println("\n -- SQL Exception --- \n");
                while(ex != null) {
                        System.out.println("Message: " + ex.getMessage());
                        System.out.println("SQLState: " + ex.getSQLState());
                        System.out.println("ErrorCode: " + ex.getErrorCode());
                        ex = ex.getNextException();
                        System.out.println("");
                }
           }
           catch (Exception ex) {System.out.println("_______________SQL_NOT_CONNECT____________");System.out.println("System will exit");System.exit(0);}

            Client tempS [] = new Client[ints.size()];
            for(int i =0 ;i<ints.size();i++){
                tempS[i] = ints.get(i);
            }

            return tempS;
    }

    static Client loadClientWD(int clientid) {
           Client temp= null;
           String selectString ="select * from client where id = "+clientid;
           try {
               Class.forName (driverClassName);
               dbConnection = DriverManager.getConnection (url, username, passwd);
               statement    = dbConnection.createStatement();
               rs = statement.executeQuery(selectString);
               while(rs.next()){
                   int id = rs.getInt("id");
                   String name = rs.getString("full_name");
                   String email = rs.getString("email");
                   long phone = rs.getLong("phone");
               temp = new Client(id,name,email,phone);
               //System.out.println(id +" "+name);
               }
               statement.close();
               dbConnection.close();
           } 
           catch(SQLException ex) {
                System.out.println("\n -- SQL Exception --- \n");
                while(ex != null) {
                        System.out.println("Message: " + ex.getMessage());
                        System.out.println("SQLState: " + ex.getSQLState());
                        System.out.println("ErrorCode: " + ex.getErrorCode());
                        ex = ex.getNextException();
                        System.out.println("");
                }
           }
           catch (Exception ex) {System.out.println("_______________SQL_NOT_CONNECT____________");System.out.println("System will exit");System.exit(0);}
           return temp;
    }

    static Account[] loadAccount() {
       ArrayList<Account> ints = new ArrayList<>();
           String selectString ="select * from \"user\"";
           try {
               Class.forName (driverClassName);
               dbConnection = DriverManager.getConnection (url, username, passwd);
               statement    = dbConnection.createStatement();
               rs = statement.executeQuery(selectString);
               while(rs.next()){
                   int id = rs.getInt("id");
                   String name = rs.getString("name");
                   String password = rs.getString("password");
               ints.add( new Account(id,name,password));
               //System.out.println(id +" "+name);
               }
               statement.close();
               dbConnection.close();
           } 
           catch(SQLException ex) {
                System.out.println("\n -- SQL Exception --- \n");
                while(ex != null) {
                        System.out.println("Message: " + ex.getMessage());
                        System.out.println("SQLState: " + ex.getSQLState());
                        System.out.println("ErrorCode: " + ex.getErrorCode());
                        ex = ex.getNextException();
                        System.out.println("");
                }
           }
           catch (Exception ex) {System.out.println("_______________SQL_NOT_CONNECT____________");System.out.println("System will exit");System.exit(0);}

            Account tempS [] = new Account[ints.size()];
            for(int i =0 ;i<ints.size();i++){
                tempS[i] = ints.get(i);
            }

            return tempS; 
    }

    static Account loadAccountID(int clientid) {
        Account temp= null;
           String selectString ="select * from \"user\" where id = "+clientid;
           try {
               Class.forName (driverClassName);
               dbConnection = DriverManager.getConnection (url, username, passwd);
               statement    = dbConnection.createStatement();
               rs = statement.executeQuery(selectString);
               while(rs.next()){
                   int id = rs.getInt("id");
                   String name = rs.getString("name");
                   String password = rs.getString("password");
               temp = new Account(id,name,password);
               //System.out.println(id +" "+name);
               }
               statement.close();
               dbConnection.close();
           } 
           catch(SQLException ex) {
                System.out.println("\n -- SQL Exception --- \n");
                while(ex != null) {
                        System.out.println("Message: " + ex.getMessage());
                        System.out.println("SQLState: " + ex.getSQLState());
                        System.out.println("ErrorCode: " + ex.getErrorCode());
                        ex = ex.getNextException();
                        System.out.println("");
                }
           }
           catch (Exception ex) {System.out.println("_______________SQL_NOT_CONNECT____________");System.out.println("System will exit");System.exit(0);}
           return temp;
    }

    static ArrayList<Double> loadSales() {
        ArrayList<Double> ints = new ArrayList<>();
           String selectString ="select totalcost from purchase";
           try {
               Class.forName (driverClassName);
               dbConnection = DriverManager.getConnection (url, username, passwd);
               statement    = dbConnection.createStatement();
               rs = statement.executeQuery(selectString);
               while(rs.next()){
                   Double money = rs.getDouble("totalcost");
               ints.add(money);
               //System.out.println(id +" "+name);
               }
               statement.close();
               dbConnection.close();
           } 
           catch(SQLException ex) {
                System.out.println("\n -- SQL Exception --- \n");
                while(ex != null) {
                        System.out.println("Message: " + ex.getMessage());
                        System.out.println("SQLState: " + ex.getSQLState());
                        System.out.println("ErrorCode: " + ex.getErrorCode());
                        ex = ex.getNextException();
                        System.out.println("");
                }
           }
           catch (Exception ex) {System.out.println("_______________SQL_NOT_CONNECT____________");System.out.println("System will exit");System.exit(0);}
           return ints; 
    }

    static LogData[] loadLogs() {
        ArrayList< LogData> ints = new ArrayList<>();
           String selectString ="select * from  shop_log_file";
           try {
               Class.forName (driverClassName);
               dbConnection = DriverManager.getConnection (url, username, passwd);
               statement    = dbConnection.createStatement();
               rs = statement.executeQuery(selectString);
               while(rs.next()){
                   String ope = rs.getString("operation");
                   String oper_time = rs.getString("oper_time");
                   String job= rs.getString("job");
                  int id = rs.getInt("id");
               ints.add( new  LogData(ope,oper_time,job,id));
               //System.out.println(id +" "+name);
               }
               statement.close();
               dbConnection.close();
           } 
           catch(SQLException ex) {
                System.out.println("\n -- SQL Exception --- \n");
                while(ex != null) {
                        System.out.println("Message: " + ex.getMessage());
                        System.out.println("SQLState: " + ex.getSQLState());
                        System.out.println("ErrorCode: " + ex.getErrorCode());
                        ex = ex.getNextException();
                        System.out.println("");
                }
           }
           catch (Exception ex) {System.out.println("_______________SQL_NOT_CONNECT____________");System.out.println("System will exit");System.exit(0);}

            LogData tempS [] = new LogData[ints.size()];
            for(int i =0 ;i<ints.size();i++){
                tempS[i] = ints.get(i);
            }

            return tempS; 
    }

    static Product loadProductWU(String barcode) {
        Product tempS= null;
       String selectString ="select p.id as product_id,p.description as desc,ps.id as supplier_product,p.name,p.price,p.quantity,p.url,c.name as category_name,s.name as supplier_name,p.barcode as barcode\n" +
                            "from product_from_suppliers as ps inner join product as p on p.id = ps.product_id inner join supplier as s on s.id = ps.supplier_id inner join product_category as c on c.id = p.product_category_id"
                            +"\n where p.barcode = '"+barcode+"'";
           try {
               Class.forName (driverClassName);
               dbConnection = DriverManager.getConnection (url, username, passwd);
               statement    = dbConnection.createStatement();
               rs = statement.executeQuery(selectString);
               while(rs.next()){
                   int id = rs.getInt("product_id");
                   int idsp = rs.getInt("supplier_product");
                   String name = rs.getString("name");
                   double price = rs.getDouble("price");
                   int quantity = rs.getInt("quantity");
                   String nameS = rs.getString("supplier_name");
                   String nameC = rs.getString("category_name");
                   String desc = rs.getString("desc");
                   String urls = rs.getString("url");
               tempS = new Product(id,idsp,quantity,price, name, nameS, nameC, desc ,urls,barcode);
               //System.out.println(id +" "+name);
               }
               statement.close();
               dbConnection.close();
           } 
           catch(SQLException ex) {
                System.out.println("\n -- SQL Exception --- \n");
                while(ex != null) {
                        System.out.println("Message: " + ex.getMessage());
                        System.out.println("SQLState: " + ex.getSQLState());
                        System.out.println("ErrorCode: " + ex.getErrorCode());
                        ex = ex.getNextException();
                        System.out.println("");
                }
           }
           catch (Exception ex) {System.out.println("_______________SQL_NOT_CONNECT____________");System.out.println("System will exit");System.exit(0);}
           return tempS;
    }
    
    
}





