package ood.OOD.src.Kindle;

import java.util.ArrayList;
import java.util.List;

public class Kindle {
    private List<Book> books;
    private EBookReaderFactory ERF;

    public Kindle(List<Book> books, EBookReaderFactory ERF ) {
        this.books = books;
        this.ERF = ERF;
    }

    public Kindle(){
        books = new ArrayList<>();
    }

    public void upLoadBook(Book b){
        books.add(b);

    };

    public void downLoadBook(Book b) {
        books.add(b);

    };

    public void deleteBook(Book b) {
        books.add(b);
    }

    public String readBook(Book b) throws Exception{
        EBookReader reader = ERF.createReader(b);
        if (reader == null) {
            throw new Exception("can't read this format");
        }

        return reader.displayReaderType() + ", book content is : " + reader.readBook();
     };



}
