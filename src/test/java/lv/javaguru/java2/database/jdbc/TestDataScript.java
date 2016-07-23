package lv.javaguru.java2.database.jdbc;


import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestDataScript extends DAOImpl{

    public void insertTestContent() throws Exception {
        List<String> sqlStatements = getSetupStatements();
        Connection connection = getConnection();

        for (String sqlStatement : sqlStatements) {
            System.out.println("executing :" + sqlStatement);
            try {
                Statement statement = connection.createStatement();
                statement.execute(sqlStatement);
            }
            catch (Exception e){
                System.out.println("Exception while trying " + sqlStatement);
                throw new Exception(e);
            }
        }
        closeConnection(connection);
    }

    private List<String> getSetupStatements() {
        List<String> sqlStatements = new ArrayList<String>();

        sqlStatements.add("INSERT INTO categories(name,father_id) VALUES('All products',0)");//0
            sqlStatements.add("INSERT INTO categories(name,father_id) VALUES('Fruits',0)");//1
            sqlStatements.add("INSERT INTO categories(name,father_id) VALUES('Vegetables',0)");//2
                sqlStatements.add("INSERT INTO categories(name,father_id) VALUES('Fresh',2)");//3
                sqlStatements.add("INSERT INTO categories(name,father_id) VALUES('Marinades',2)");//4

            sqlStatements.add("INSERT INTO categories(name,father_id) VALUES('Milk products',0)");//5
                sqlStatements.add("INSERT INTO categories(name,father_id) VALUES('Milk',5)");//6
                sqlStatements.add("INSERT INTO categories(name,father_id) VALUES('Cream',5)");//7
                sqlStatements.add("INSERT INTO categories(name,father_id) VALUES('Butter',5)");//8

            sqlStatements.add("INSERT INTO categories(name,father_id) VALUES('Meat',0)");//9
                sqlStatements.add("INSERT INTO categories(name,father_id) VALUES('Chicken',9)");//10
                sqlStatements.add("INSERT INTO categories(name,father_id) VALUES('Pork',9)");//11
                sqlStatements.add("INSERT INTO categories(name,father_id) VALUES('Beef',9)");//12
                sqlStatements.add("INSERT INTO categories(name,father_id) VALUES('Sausages',9)");//13


        /*fruits 1*/
        sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Small Green Aapples' ,'','img/products/fruits/01/',1.29,1)");//01
            sqlStatements.add("INSERT INTO product_attributes(attribute,attr_value,product_id) VALUES('shape','spheric',1)");
            sqlStatements.add("INSERT INTO product_attributes(attribute,attr_value,product_id) VALUES('origin','apple tree',1)");//
            sqlStatements.add("INSERT INTO product_attributes(attribute,attr_value,product_id) VALUES('best for','charlotte pie',1)");//

        sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Large Green Apples'  ,'','img/products/fruits/02/',1.11,1)");//2
        sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Large Red Apples'    ,'','img/products/fruits/03/',1.32,1)");//3
        sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Green Grapes'        ,'','img/products/fruits/04/',2.22,1)");//4
        sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Red Grapes'          ,'','img/products/fruits/05/',2.09,1)");//5
        sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Bananas Honduras'    ,'','img/products/fruits/06/',1.56,1)");//6
        sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Bananas Mexico'      ,'','img/products/fruits/07',1.65,1)");//7

        /*vegetable 2*/
            /*fresh 3*/
            sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Potatoes small','','img/products/vegetables/fresh/08/',0.79,3)");//8
            sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Potatoes large ','','img/products/vegetables/fresh/09/',1.01,3)");//9
            sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Onion natural','','img/products/vegetables/fresh/10/',0.65,3)");//10
            sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Carrots','','img/products/vegetables/fresh/11/',0.66,3)");//11
            sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Tomatoes large','','img/products/vegetables/fresh/12/',1.12,3)");//12
            sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Tomatoes medium','','img/products/vegetables/fresh/13/',1.43,3)");//13
            sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Tomatoes cherry','','img/products/vegetables/fresh/14/',1.89,3)");//14
            sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Cucumber tiny','','img/products/vegetables/fresh/15/',1.44,3)");//15
            sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Cucumber medium','','img/products/vegetables/fresh/16/',1.55,3)");//16

            /*marinadess 4*/
            sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Cucumber in marinade','','img/products/vegetables/marinades/17/',2.29,4)");//17
            sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Tomatoes in marinade','','img/products/vegetables/marinades/18/',3.02,4)");//18

        /*milk products 5*/
            /*milk 6*/
            sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Milk 2.5% first brand','','img/products/milkproducts/milk/19/',0.89,6)");//19
            sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Milk 2.5% second brand','','img/products/milkproducts/milk/20/',0.96,6)");//20
            sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Milk 3.5% first brand','','img/products/milkproducts/milk/21/',1.01,6)");//21
            sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Preserved milk third brand','','img/products/milkproducts/milk/22/',1.76,6)");//22

            /*cream 7*/
            sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Cream 15% second brand','','img/products/milkproducts/cream/23/',1.12,7)");//23
            sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Cream 15% first brand','','img/products/milkproducts/cream/24/',1.12,7)");//24
            sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Cream 25%second brand','','img/products/milkproducts/cream/25/',1.34,7)");//25

            /*butter 8*/
            sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Simple butter','','img/products/milkproducts/butter/26/',0.96,8)");//26
            sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Buttier than butter','','img/products/milkproducts/butter/27/',1.07,8)");//27

        /*meat 9*/
            /*chicken 10*/
            sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Chicken legs','','img/products/meat/chicken/28/',2.50,10)");//28
            sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Chicken wings','','img/products/meat/chicken/29/',2.60,10)");//29
            sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Whole chicken','','img/products/meat/chicken/30/',7.10,10)");//30

            /*pork 11*/
            sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Pork belly cut','','img/products/meat/pork/31/',3.33,11)");//31
            sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Pork ribs','','img/products/meat/pork/32/',4.44,11)");//32
            sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Bacon Yeahbaby','','img/products/meat/pork/33/',5.55,11)");//33
            sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Ham first brand','','img/products/meat/pork/34/',3.45,11)");//34
            sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Ham second brand','','img/products/meat/pork/35/',4.56,11)");//35
            sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Poignants Chunky Bacon','','img/products/meat/pork/36/',5.67,11)");//36

            /*beef 12*/
            sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Beef belly cut','','img/products/meat/beef/37/',4.44,12)");//37
            sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Beef ribs','','img/products/meat/beef/38/',4.53,12)");//38
            sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Beef legs','','img/products/meat/beef/39/',4.36,12)");//39
            sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Beef ribs another','','img/products/meat/beef/40/',5.12,12)");//40

            /*sausages 13*/
            sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Sausages','','img/products/meat/sausages/41/',2.33,13)");//41
            sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Sausages for grilling','','img/products/meat/sausages/42/',3.24,13)");//42
            sqlStatements.add("INSERT INTO products(name,description,imagepath,price,category_id) VALUES('Salami','','img/products/meat/sausages/43/',4.54,13)");//43

        sqlStatements.add("UPDATE products SET products.description = CONCAT('desc for ',products.name)" );

        return  sqlStatements;
    }

}
