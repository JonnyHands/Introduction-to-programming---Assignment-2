

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class StudentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StudentTest
{
    /**
     * Default constructor for test class StudentTest
     */
    public StudentTest()
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
    public void testFinishedStudies()
    {
        Library library1 = new Library(15);
        Student student1 = new Student("test", library1);
        assertEquals(false, student1.finishedStudies());
        for( int i = 0; i < 30; i++) 
        {
            student1.study();
        }
        assertEquals(true, student1.finishedStudies());
    }
    
    @Test
    public void testStudy()
    {
        Library library1 = new Library(15);
        Student student1 = new Student("Test", library1);
        student1.study(); //test to borrow book
         for( int i = 0; i < 3; i++) //test to read book chapters and to finish book
        {
            student1.study();
        }
    }
    
    @Test
    public void testDescribe()
    {
        Library library1 = new Library(15);
        Student student1 = new Student("Test", library1);
        student1.describe();
        student1.study();
        student1.describe();
          for( int i = 0; i < 3; i++) //test to read book chapters and to finish book
        {
            student1.study();
        }
        student1.describe();
    }
}






