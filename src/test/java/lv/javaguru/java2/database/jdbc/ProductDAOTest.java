package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ProductDAOTest {
    private static final String DB_SCHEMA = "store_product_test";
    private ProductDAO productDAO = new ProductDAO();

    @Before
    public void setUp() throws Exception {
        Connection connection = productDAO.getConnection();
        PreparedStatement statement = connection.prepareStatement("create schema " + DB_SCHEMA + ";");
        statement.executeUpdate();
        productDAO.closeConnection(connection);

        String oldSchema = productDAO.getDbSchema();
        productDAO.setDbSchema(DB_SCHEMA);

        connection = productDAO.getConnection();
        statement = connection.prepareStatement("create table products like " + oldSchema + ".products;");
        statement.executeUpdate();
    }

    @After
    public void tearDown() throws Exception {
        Connection connection = productDAO.getConnection();
        PreparedStatement statement = connection.prepareStatement("drop schema " + DB_SCHEMA + ";");
        statement.executeUpdate();
    }

    @Test
    public void saveAndGetById() throws Exception {
        Product product = new Product("Piens Karums", "", 79);
        int id = productDAO.save(product);
        product.setId(id);

        Product productFromDb = productDAO.findById(id);

        assertEquals(product, productFromDb);

        productDAO.delete(id);

        productFromDb = productDAO.findById(id);
        assertNull(productFromDb);
    }

    @Test
    public void findAllProductsTest() throws SQLException, DBException {
        Connection connection = productDAO.getConnection();
        connection.prepareStatement("delete from products;").executeUpdate();

        connection.prepareStatement(
                "insert into products (name, description, price)"
                        + "values ('Milk', '2%', 42), ('Desa', 'Doktordesa', 162), ('Maize', 'Paralona, Fazer', 38);"
        ).executeUpdate();

        List<Product> products = productDAO.findAll();
//        for (Product p: products) {
//            System.out.println(p);
//        }

        assertEquals(3, products.size());
    }
}