
/**
 * Write a description of class LibraryCard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LibraryCard
{
    // instance variables - replace the example below with your own
    private int bookLimit;
    private int booksBorrowed;
    private String cardRef;

    /**
     * Constructor for objects of class LibraryCard
     */
    public LibraryCard(int bookLimit, int cardRef)
    {
        this.bookLimit = bookLimit;
        this.cardRef = "cardID " + cardRef;
        booksBorrowed = 0;

    }

    public void swipe()
    {//if statement prevents books borrowed from going negative by implementing a check.
        if(booksBorrowed < bookLimit)
        {
            booksBorrowed++;  
        }
        else
        {
            System.out.println("Book limit reached on this card."); 
        }
    }

    public boolean expired()
    {
        return booksBorrowed >= bookLimit;
    }

    public String getCardRef()
    {
        return cardRef;   
    }

    public void describe()
    {
        System.out.println("library card, " + cardRef + " has " + (bookLimit - booksBorrowed) + " books available to withdraw. ");   
    }

}
