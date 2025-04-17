public class Book
{
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String title, String author)
    {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getTitle()
    {
        return title;
    }

    public String getAuthor()
    {
        return author;
    }

    public boolean isAvailable()
    {
        return isAvailable;
    }

    public void borrowBOOK()
    {
        if (Book.this.isAvailable())
        {
            isAvailable = false;
        }
    }

    public void returnBook()
    {
        isAvailable = true;
    }
}