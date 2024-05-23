package kth.se.IV1350.PointOfSale.exceptions;

import kth.se.IV1350.PointOfSale.integration.InventorySystem;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for the DatabaseFailureException.
 */
public class DatabaseFailureExceptionTest {
private InventorySystem exc;
    /**
     * Initializes the test environment before each test case.
     * Creates a new instance of InventorySystem.
     * @throws Exception if an error occurs during setup.
     */
    @Before
    public void setUp() throws Exception {
    exc = new InventorySystem();

    }

    /**
     * Tests that the DatabaseFailureException is thrown with the correct message
     * when the database connection fails.
     *
     * @throws DatabaseFailureException if a database failure occurs.
     * @throws ItemNotFoundException if the item is not found.(Note: This exception is not expected to be thrown in this test)
     */
    @Test
    public void testDatabaseFailureException() throws DatabaseFailureException , ItemNotFoundException{
        String actualMsg = null;
        try{
        exc.getItemInfo("xxxx");
        }catch ( DatabaseFailureException e){
            actualMsg = e.getMessage();
        }
        assertEquals("Sorry , an Error occurred with connecting database please tyr again later", actualMsg);
    }

}