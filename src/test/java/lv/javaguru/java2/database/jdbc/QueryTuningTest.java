package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by algis on 16.22.7.
 */
public class QueryTuningTest {

    private QueryTuning queryTuning;
    private ProductDAOImpl productDAO = new ProductDAOImpl();
    private List<Product> productsWithoutTuning;
    @Before
    public void before() throws Exception{
        queryTuning = new QueryTuning();
        productsWithoutTuning = productDAO.getAll();
    }
    @Test
    public void testEmptyTuningWorksAsNoTuning() throws DBException{
        List<Product> productsWithTuning = productDAO.getAll(queryTuning);

        assertEquals(productsWithoutTuning.size(),productsWithTuning.size());
        for (int i = 0; i < productsWithoutTuning.size(); i++) {
            assertEquals(productsWithoutTuning.get(i).getId(), productsWithTuning.get(i).getId());
        }
    }

    @Test
    public void testTuneLimit()  throws DBException{
        final int TEST_LIMIT = 5;
        if(productsWithoutTuning.size()<TEST_LIMIT)
            fail();
        queryTuning.setQueryLimit(TEST_LIMIT);
        List<Product> productsWithTuning = productDAO.getAll(queryTuning);
        assertEquals(TEST_LIMIT,productsWithTuning.size());
        for (int i = 0; i < productsWithTuning.size(); i++) {
            assertEquals(productsWithTuning.get(i).getId(), productsWithoutTuning.get(i).getId());
        }
    }

    @Test
    public void testOffset() throws DBException{
        final int TEST_OFFSET = 5;
        if(productsWithoutTuning.size()<=TEST_OFFSET)
            fail();
        queryTuning.setQueryOffset(TEST_OFFSET);
        List<Product> productsWithTuning = productDAO.getAll(queryTuning);
        assertEquals(productsWithoutTuning.size() - TEST_OFFSET,productsWithTuning.size());
        for (int i = 0; i < productsWithTuning.size(); i++) {
            assertEquals(productsWithoutTuning.get(i+TEST_OFFSET).getId(),productsWithTuning.get(i).getId());
        }
    }

    @Test
    public void testLimitAndOffset() throws DBException{
        final int TEST_LIMIT = 6;
        final int TEST_OFFSET = 3;
        if(productsWithoutTuning.size()<=TEST_OFFSET + TEST_LIMIT)
            fail();
        queryTuning.setQueryLimit(TEST_LIMIT);
        queryTuning.setQueryOffset(TEST_OFFSET);
        List<Product> productsWithTuning = productDAO.getAll(queryTuning);
        assertEquals(productsWithTuning.size() ,TEST_LIMIT);
        for (int i = 0; i < productsWithTuning.size(); i++) {
            assertEquals(productsWithoutTuning.get(i+TEST_OFFSET).getId(),productsWithTuning.get(i).getId());
        }
    }

    @Test
    public void testLimitAndOffsetWithPagination() throws DBException{
        final int TEST_LIMIT = 3;
        final int TEST_PAGE = 3;
        final int OFFSET_BY_FACT = 6;

        if(productsWithoutTuning.size()<=TEST_LIMIT * TEST_PAGE)
            fail();
        queryTuning.setQueryLimit(TEST_LIMIT);
        queryTuning.setPagedQuery(TEST_PAGE);

        List<Product> productsWithTuning = productDAO.getAll(queryTuning);
        assertEquals(productsWithTuning.size() ,TEST_LIMIT);
        for (int i = 0; i < productsWithTuning.size(); i++) {
            assertEquals(productsWithoutTuning.get(i+OFFSET_BY_FACT).getId(),productsWithTuning.get(i).getId());
        }
    }

    @Test
    public void testOrderByFieldAscending() throws DBException{
        queryTuning.addSortOrderAsc("price");
        List<Product> productsWithTuning = productDAO.getAll(queryTuning);

        Double startPrice = productsWithTuning.get(0).getPrice();
        for (Product product : productsWithTuning) {
            if(product.getPrice() < startPrice)
                fail();
            else
                startPrice = product.getPrice();
        }
    }

    @Test
    public void testOrderByFieldDescending() throws DBException{
        queryTuning.addSortOrder("price",true);
        List<Product> productsWithTuning = productDAO.getAll(queryTuning);
        Double startPrice = productsWithTuning.get(0).getPrice();
        for (Product product : productsWithTuning) {
            if(product.getPrice() > startPrice)
                fail();
            else
                startPrice = product.getPrice();
        }
    }

    @Test
    public void testOrderByTwoFields() throws DBException{
        queryTuning.addSortOrder("price",false);
        queryTuning.addSortOrder("id"   , true);
        List<Product> productsWithTuning = productDAO.getAll(queryTuning);

        Double startPrice = productsWithTuning.get(0).getPrice();
        Long startId = productsWithTuning.get(0).getId();
        for (Product product : productsWithTuning) {
            if(product.getPrice() < startPrice){
                fail();
            }
            else{
                if(product.getPrice()  > startPrice){
                    startPrice = product.getPrice();
                    startId = product.getId();
                }
                else{
                    if(startId < product.getId()){
                        fail();
                    }
                }
            }
        }
    }

    @Test
    public void testOrderByWithLimit() throws DBException{
        int testCount = 0;
        Double testPrice = productsWithoutTuning.get(0).getPrice();
        for (Product product : productsWithoutTuning) {
            if(product.getPrice().equals(testPrice))
                testCount++;
        }

        queryTuning.addSortOrder("price",false);
        queryTuning.setQueryLimit(testCount);
        List<Product> productsWithTuning = productDAO.getAll(queryTuning);

        assertEquals(testCount , productsWithTuning.size());
        for (Product product : productsWithTuning) {
            if(!product.getPrice().equals(testPrice))
                fail();
        }
    }

    @Test
    public void testOrderByWithOffset() throws DBException{
        int testCount = 0;
        Double testPrice = productsWithoutTuning.get(0).getPrice();
        for (Product product : productsWithoutTuning) {
            if(product.getPrice().equals(testPrice))
                testCount++;
        }

        queryTuning.addSortOrder("price",false);
        queryTuning.setQueryOffset(testCount);
        List<Product> productsWithTuning = productDAO.getAll(queryTuning);

        assertEquals(productsWithoutTuning.size() - testCount , productsWithTuning.size());
        for (Product product : productsWithTuning) {
            if(product.getPrice().equals(testPrice))
                fail();
        }
    }


}