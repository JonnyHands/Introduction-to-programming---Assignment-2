
/**
 * Write a description of class Library here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Library
{
    // instance variables - replace the example below with your own
    private TextBook[] bookShelf;
    private int nextBook;
    private int borrowers = 0;

    /**
     * Constructor for objects of class Library
     */
    public Library(int bookShelfCapacity)
    {   
        bookShelf = new TextBook[bookShelfCapacity];
        for(int i = 0; i< bookShelfCapacity; i++)
        {
            bookShelf[i]= new TextBook("Text book " + (i + 1), 3);
        }  
    }

    public LibraryCard issueCard()
    {
        borrowers++;
        LibraryCard newCard = new LibraryCard(3, borrowers);
        return newCard;

    }

    public TextBook borrowBook(LibraryCard card)
    {
        if(card == null)
        {
            return null;
        }
        //check library card is valid and books left on shelf
        if(card.expired() == false && booksOnShelfCount() > 0)
        {
            // get the next book
            TextBook book = bookShelf[nextBook];
            //remove book from bookshelf
            bookShelf[nextBook] = null;
            // increment next book counter
            nextBook++;
            card.swipe();
            return book;
        }
       
        return null;
    }

    private int booksOnShelfCount()
    {   
        int count = 0;
        for(int i = 0; i<bookShelf.length; i++)
        {
            if( bookShelf[i] != null)
            {
              count++;
            }
        }
        return count;
    }
    
    
    public void returnBook(TextBook book)
    {
        //put book back into bookshelf
        nextBook--;
        bookShelf[nextBook] = book;
        //reduce number of books borrowed on card

    }
    
    public void describe()
    {
        System.out.println("The library has " + (booksOnShelfCount()) + " book(s) left on the shelf and has issued " + borrowers + " library cards."); 
    }
}
