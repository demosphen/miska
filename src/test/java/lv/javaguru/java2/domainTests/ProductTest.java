package lv.javaguru.java2.domainTests;

import lv.javaguru.java2.domain.Product;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void testPriceString() {
        Product p = new Product();
        p.setPrice(1333);
        assertEquals(p.getPriceString(), "13.33");
    }

}