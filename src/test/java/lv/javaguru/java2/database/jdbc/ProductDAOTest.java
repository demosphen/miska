package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.domain.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

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

        Product productFromDb = productDAO.getById(id);

        assertEquals(product, productFromDb);

        productDAO.delete(id);

        productFromDb = productDAO.getById(id);
        assertNull(productFromDb);
    }
}