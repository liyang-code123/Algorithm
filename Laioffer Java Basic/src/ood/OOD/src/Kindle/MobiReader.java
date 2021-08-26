package ood.OOD.src.Kindle;

public class MobiReader extends EBookReader{

    public MobiReader(Book book) {
        super(book);
    }

    @Override
    public String readBook() {
        return book.getFormat().getContent();
    }

    @Override
    public String displayReaderType() {
        return "Using MOBI reader";
    }
}
