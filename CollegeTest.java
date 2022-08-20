

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CollegeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CollegeTest
{
    /**
     * Default constructor for test class CollegeTest
     */
    public CollegeTest()
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
    public void testDescribe()
    {
        College college1 = new College(15, 10);
        college1.describe();
    }

    @Test
    public void testRunCollege()
    {
        College college1 = new College(15, 10);
        college1.runCollege(200);
    }
}



