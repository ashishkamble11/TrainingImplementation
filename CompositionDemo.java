import java.util.ArrayList;
import java.util.List;

public class CompositionDemo
{
    public static void main(String[] args)
    {
        Book book1=new Book("abc","abc");
        Book book2=new Book("xyz","xyz");
        Book book3=new Book("pqr","pqr");
        Book book4=new Book("def","def");

        List<Book> list=new ArrayList<>();
        list.add(book1);
        list.add(book2);
        list.add(book3);
        list.add(book4);

        Library library=new Library(list);
        List<Book> books=library.getBooks();
        System.out.println("Name\t"+"Title");
        for(Book book: books)
        {
            System.out.println(book.bname+"\t\t"+book.btitle);
        }
    }
}

class Library
{
    final List<Book> books;

    Library(List<Book> books)
    {
        this.books=books;
    }

    public List<Book> getBooks()
    {
        return books;
    }
}

class Book
{
    String bname;
    String btitle;

    Book(String bname, String btitle)
    {
        this.bname=bname;
        this.btitle=btitle;
    }
}