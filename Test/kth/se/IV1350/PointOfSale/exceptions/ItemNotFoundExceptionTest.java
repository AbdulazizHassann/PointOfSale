package kth.se.IV1350.PointOfSale.exceptions;
import kth.se.IV1350.PointOfSale.integration.InventorySystem;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class ItemNotFoundExceptionTest {

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
     * Tests that the ItemNotFoundException is thrown with the correct message
     * when the database connection fails.
     *
     * @throws DatabaseFailureException if a database failure occurs.(Note: This exception is not expected to be thrown in this test)
     * @throws ItemNotFoundException if the item is not found.
     */
    @Test
    public void testItemNotFoundException() throws DatabaseFailureException , ItemNotFoundException{
        String actualMsg = null;
        try{
            exc.getItemInfo("098RTY");
        }catch(ItemNotFoundException e){
            actualMsg = e.getMessage();
        }
        assertEquals("The scanned item is not in inventorySystem", actualMsg);
    }
}