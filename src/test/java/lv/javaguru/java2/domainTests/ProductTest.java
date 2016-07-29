package lv.javaguru.java2.domainTests;

import lv.javaguru.java2.domain.Product;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductTest {

    @Test
    public void testDisplayPrice() {
        Product p = new Product();
        p.setPrice(1333);
        assertEquals(p.getDisplayPrice(), "13.33");
    }

}