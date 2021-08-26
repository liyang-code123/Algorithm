package ood.OOD.src.Kindle;

public class EpubReader extends EBookReader {

    public EpubReader(Book book) {
        super(book);
    }

    @Override
    public String readBook() {
        return book.getFormat().getContent();
    }

    @Override
    public String displayReaderType() {
        return "Using Epub reader";
    }
}
