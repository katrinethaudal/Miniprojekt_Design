package controller;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.LP;
/**
 * The test class LPControllerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class LPControllerTest
{
    
    LPController lpController;
    /**
     * Default constructor for test class LPControllerTest
     */
    public LPControllerTest()
    {
        lpController = new LPController();
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
    @Test
    public void TestCreateLP() {
        String name = "lpName";
        int serialNumber = 123;
        String artist = "Singer";
        String publicationDate = "2004-12-11";
        LP lp = lpController.CreateLP(name, serialNumber, artist, publicationDate);
        
        assertNotNull(lp);
        assertEquals(name, lp.getTitle());
        assertEquals(serialNumber, lp.getSerialNumber());
        assertEquals(publicationDate, lp.getPublicationDate());
        assertEquals(artist, lp.getArtist());
    }
}
