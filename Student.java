
/**
 * The student class is used to create a virtual student to be implemented into the program. You can check if the student has finished their studies, make them study and describe the state they're in here.
 *
 * @author Jonathan Hands
 * @version 10/12/2019
 */
public class Student
{

    private String nameOfStudent;
    private Library libraryOfStudent;
    private LibraryCard cardOfStudent;
    private TextBook bookOfStudent;

    public Student(String name, Library library)
    {
        nameOfStudent = name; //name assigned to nameOfStudent
        libraryOfStudent = library; //library assigned to libraryOfStudent
        cardOfStudent = library.issueCard(); //using the library to assign/create card
        bookOfStudent = null; //makes book empty

    }

    /**  
     * (return true if the student does not have a TextBook to read, but can't borrow one because the LibraryCard has expired. Otherwise, it should return false.)
     * @return boolean true or false
     */
    public boolean finishedStudies()
    {

        if(bookOfStudent == null & (cardOfStudent.expired() == true)) //checks student has no book and if card is expired
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**  
     * (causes the student to study, and has the following behaviour:
     * if the student does not currently have a TextBook then the student tries to borrow one from the library;
     * if the student does have a book and it is not finished, then the student reads one chapter of the book;
     * otherwise, the student has a book that is finished and so closes it and returns it to the library. (Note that after this the student should not have a book.))
     * @return necessary action for student to study. i.e makes them read
     */
    public void study()
    {
        if(bookOfStudent == null) //checks student has book
        {
            bookOfStudent = libraryOfStudent.borrowBook(cardOfStudent);
        }
        else if(bookOfStudent.isFinished() == false) //checks if book is finished
        {
            bookOfStudent.readNextChapter();
        } 
        else
        {
            bookOfStudent.closeBook();
            libraryOfStudent.returnBook(bookOfStudent);
            bookOfStudent = null;
        }
    }

    /**  
     * (prints out messages about the student, e.g. about whether or not they have a TextBook and if they do have book, whether or not the book is finished or they are still reading it. )
     * @return description of the state the students in 
     */
    public void describe()
    {
        if(bookOfStudent == null) //checks if student has a book
        {
            System.out.print("Student " + nameOfStudent + " does not have a book and their "); 
            cardOfStudent.describe();
        }
        else if(bookOfStudent != null & bookOfStudent.isFinished() == false) //checks if student has book and if its not finished
        {
            System.out.print("Student " + nameOfStudent + " has "); bookOfStudent.describe();
            System.out.println("The student is reading the book.");   
        }
        else
        {
            System.out.print("Student " + nameOfStudent + " has "); bookOfStudent.describe(); 
            System.out.println("This book is finished.");   
        }
    }
}
