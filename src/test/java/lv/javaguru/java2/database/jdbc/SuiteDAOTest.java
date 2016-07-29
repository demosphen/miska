package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DatabaseRefresher;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        UserDAOImplTest.class
        ,ProductDAOImplTest.class
       // ,QueryTuningTest.class
})
public class SuiteDAOTest {

    @BeforeClass
    public static void beforeClass() throws Exception{
        DatabaseRefresher refresher = new DatabaseRefresher();
        refresher.refreshDatabse();
        TestDataScript testData = new TestDataScript();
        testData.insertTestContent();
    }
}
