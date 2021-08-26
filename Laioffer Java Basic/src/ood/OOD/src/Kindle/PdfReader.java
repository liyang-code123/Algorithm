package ood.OOD.src.Kindle;

public class PdfReader extends EBookReader{

    public PdfReader(Book book) {
        super(book);
    }

    @Override
    public String readBook() {
        return book.getFormat().getContent();
    }

    @Override
    public String displayReaderType() {
        return "Using PDF reader";
    }
}
