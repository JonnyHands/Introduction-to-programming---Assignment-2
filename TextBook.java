
/**
 * Write a description of class TextBook here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TextBook
{
    // instance variables - replace the example below with your own
    private String title;
    private int lengthInChapters;
    private int lastRead;

    public TextBook(String title, int lengthInChapters)
    {
        this.title = title;
        this.lengthInChapters = lengthInChapters;
        this.lastRead = 0;

    }

    public String getTitle()
    {  
        return title;  
    }

    public void readNextChapter()
    {
        if(lastRead<lengthInChapters)
        {
            lastRead++;
        }
        else
        {
            System.out.println("No more chapters left to be read!");
        }
    }

    public boolean isFinished()
    {
        if(lastRead==lengthInChapters)
        {
            return true;
        }

        return false;
    }

    public void closeBook()
    {
        lastRead = 0;   
    }

    public void describe()
    {
        String message;
        if(isFinished())
        {
            message = title + " is finished.";
        }
        else
        {
            message = title + " with " + (lengthInChapters-lastRead) + " chapters left to read.";   
        }
        System.out.println(message);
    }
}
