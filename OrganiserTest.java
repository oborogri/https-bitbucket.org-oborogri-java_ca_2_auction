import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class OrganiserTest.
 *
 * @author  Grigore Oboroceanu
 * @version 15.03.2016
 */
public class OrganiserTest
{
    /**
     * Default constructor for test class OrganiserTest
     */
    public OrganiserTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testSubmitBids()
    {
        Organiser organise1 = new Organiser();
        assertEquals(true, organise1.submitBids());
    }
}