import java.math.BigDecimal;
import java.util.List;

import com.dao.Bookdao;
import com.dao.Bookimpl;
import com.pojo.Book;
import com.pojo.Page;
import com.service.bookserimp;


import org.junit.Test;

public class bookdattest {
    
    private Bookdao book = new Bookimpl();

    @Test
    public void addbook() {
        book.addBoook(new Book(null,"dfssdfdsf","151",new BigDecimal(12),11,0,null));
    }

    @Test
    public void booklist() {
        List<Book> queryBooks = book.queryBooks();
        for (Book book : queryBooks) {
            System.out.println(book.toString());
        }
    }

    @Test
    public void bookpage() {
        System.out.println(book.queryCount());
    }

    @Test
    public void booktest() {
        List<Book> query = book.queryForPageItems(0, 4);
        for (Book book : query) {
            System.out.println(book);
        }
    }


    @Test
    public void name() {
        bookserimp book = new bookserimp();
        
        System.out.println(book.page(4, Page.PAGE_SIZE));
    }

    @Test
    public void querybyprice() {
        System.out.println(book.queryCountbyprice(0, 20));
    }

    @Test
    public void querybypageprice() {
        System.out.println(book.queryForPageItemsbyprice(1,Page.PAGE_SIZE,0,10));
    }


    @Test
    public void querybypriceser() {
        bookserimp book = new bookserimp();
        System.out.println(book.pageByPrice(1, Page.PAGE_SIZE, 0, 10));
    }


}
