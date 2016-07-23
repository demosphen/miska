package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.Product;
import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by algis on 16.22.7.
 */
public class ProductDAOImplTest {

    ProductDAOImpl productDAO = new ProductDAOImpl();

    @Test
    public void testCreateWithoutAttributes() throws DBException{

        Product product = sampleProduct();
        assertTrue(product.getId() == 0);
        productDAO.create(product);
        assertTrue(product.getId() > 0 );

        Product anotherProduct = productDAO.getById(product.getId());

        assertEquals(product.getName(), anotherProduct.getName());
        assertEquals(product.getPrice(), anotherProduct.getPrice());
        assertThatAttributesAreEqual(product,anotherProduct);
    }

    @Test
    public void testCreateWithAttributes() throws DBException{
        Product product = sampleProduct();
        addSampleAttributes(product);

        assertTrue(product.getId() == 0);
        productDAO.create(product);
        assertTrue(product.getId() > 0 );

        Product anotherProduct = productDAO.getById(product.getId());
        assertEquals(product.getName(), anotherProduct.getName());
        assertEquals(product.getPrice(), anotherProduct.getPrice());
        assertThatAttributesAreEqual(product,anotherProduct);
    }

    @Test
    public  void testDelete() throws DBException,SQLException{
        Product product = sampleProductFromDb();
        Long id = product.getId();
        productDAO.delete(product);
        assertTrue(product.getId() == 0);
        assertTrue(assertThatAttributesAreDeleted(id));

        Product deletedProduct = productDAO.getById(id);
        assertNull(deletedProduct);
    }

    @Test
    public void testUpdate() throws DBException{

        Product product = sampleProductFromDb();
        product.setName("updated name");
        product.setPrice(product.getPrice() * 2);
        product.getAttributes().remove("attr1");
        product.getAttributes().put("attr3","param3");
        product.getAttributes().put("attr4","param4");
        productDAO.update(product);

        Product updatedProduct = productDAO.getById(product.getId());
        assertEquals(product.getName(), updatedProduct.getName());
        assertEquals(product.getPrice(), updatedProduct.getPrice());
        assertThatAttributesAreEqual(product,updatedProduct);
    }

    @Test
    public void testGetByGoodId() throws DBException{
        Product product = sampleProductFromDb();
        assertNotNull(product);
    }

    @Test
    public void testGetByBadId() throws DBException{
        Product badProduct = productDAO.getById(-10L);
        assertNull(badProduct);
    }

    @Test
    public void testGetAll() throws DBException{
        List<Product> products = productDAO.getAll();
        assertNotNull(products);
    }

    private Product sampleProductFromDb() throws DBException{
        Product product = sampleProduct();
        addSampleAttributes(product);
        productDAO.create(product);
        return  productDAO.getById(product.getId());
    }

    private Product sampleProduct(){
        Product product = new Product();
        product.setName("Cake 'Bishops Indulgence'");
        product.setDescription("meow");
        product.setCategoryId(123L);
        product.setPrice(12.3);
        product.setImagePath("this/is/imagepath/");
        return  product;
    }

    private void addSampleAttributes(Product product){
        Map<String,String> attributes = new HashMap<String, String>();
        attributes.put("attr1","param1");
        attributes.put("attr2","param2");
        product.setAttributes(attributes);
    }

    private boolean assertThatAttributesAreDeleted(Long id) throws SQLException,DBException{
        PreparedStatement statement = new DAOImpl().getConnection().prepareStatement("select count(product_id) from product_attributes where product_id = ?");
        statement.setLong(1 , id);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            if(resultSet.getInt(1) != 0 )
                return false;
            if(resultSet.next())
                return  false;
            return true;
        }
        return false;
    }

    private void assertThatAttributesAreEqual(Product product1 , Product product2){
        assertEquals(product1.getAttributes().size(),product2.getAttributes().size());
        for (Map.Entry<String, String> attribute : product1.getAttributes().entrySet()) {
            assertEquals(attribute.getValue() , product2.getAttributes().get(attribute.getKey()));
        }
    }



}