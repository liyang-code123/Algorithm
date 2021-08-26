package ood.OOD.src.Kindle;

import java.util.ArrayList;
import java.util.List;

public class KindleTest {

    public static void main(String[] args) throws Exception {

        List<Book> b = new ArrayList<>();
        EBookReaderFactory ERF = new EBookReaderFactory();

        Book b1 = new Book(Format.PDF);
        Book b2 = new Book(Format.MOBI);
        Book b3 = new Book(Format.EPUB);

        Kindle k = new Kindle(b,ERF);
        String s1 = k.readBook(b1);
        System.out.println(s1);

        String s2 = k.readBook(b1);
        System.out.println(s2);

        String s3 = k.readBook(b1);
        System.out.println(s3);
    }
}
