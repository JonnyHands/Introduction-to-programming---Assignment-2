
/**
 * The college class is to create a virtual college to be implemented into the program. You can check the state of the college and run it through a desired seires of steps.
 *
 * @author Jonathan Hands
 * @version 10/12/2019
 */
import java.util.ArrayList;
import java.util.Random;

public class College
{

    private ArrayList<Student> students;
    private Library library;
    private Random random;

    public College(int NoBooks, int NoStudents)
    {
        library = new Library(NoBooks);
        students = new ArrayList<Student>(NoStudents);
        random = new Random();
        for (int i = 0; i < NoStudents; i++)
        {
            students.add(new Student("Student" + i, library));
        }
    }

    /**  
     * (prints out a simple description of the state of the College)
     * @return description of the state of the College
     */
    public void describe() 
    {
        System.out.println("The college has currently " + students.size() + " hard-working students");
        library.describe();
    }

    /**  
     * (or internal use by this class only (hence the method is private) which carries out the following actions:
     * if there are no Students left at the College, then the method should just print out a message such as "Everything has gone quiet."
     * otherwise, a Student should be selected at random from those still at the College.
     * If the selected Student has finished their studies, then they should be removed from the College and a suitable message printed out
     * (e.g. "The student has graduated and left the college."); otherwise, the Student should study.)
     * @return description of the state of college
     */
    private void nextStep()
    {
        if (students.size() > 0)
        {
            Student draft = students.get(random.nextInt(students.size())); //selects random student
            if (draft.finishedStudies() == true)  //checks if finished studies
            {
                System.out.println("Student has left the college.");
                students.remove(draft);
            }
            else 
            {
                draft.study(); //makes selected student study otherwise
            }
        }
        else 
        {
            System.out.println("Everything has gone quiet.");
        }   
    }

    /**  
     * (repeatedly carries out the following actions (exactly nStep times):
     * print out the number of the step being carried out (e.g. "Step 12")
     * describe the state of the College (i.e. invoke the describe() method); and
     * invoke the nextStep() method.)
     * @param int nSteps
     * @return a run through of the class in set nSteps
     * etc
     */
    public void runCollege(int nSteps)
    {
        for (int i = 0; i < nSteps; i++)
        {
            System.out.println("Step " + i);
            describe();
            nextStep();
        }
    }

    /**  
     * (allow the whole project to be run without BlueJ)
     * @param string of arguments
     * @return run through of college with set parameters
     */
    public static void main(String[] args)
    {
        int numberBooks = Integer.parseInt(args[0]);
        int numberStudents = Integer.parseInt(args[1]);
        int numberSteps = Integer.parseInt(args[2]);
        College sA = new College(numberBooks, numberStudents);
        sA.runCollege(numberSteps);
    }

}