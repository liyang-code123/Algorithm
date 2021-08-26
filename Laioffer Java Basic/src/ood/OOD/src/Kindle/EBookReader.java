package ood.OOD.src.Kindle;

public abstract class EBookReader {
    protected Book book;

    public EBookReader(Book book) {
        this.book = book;
    }

    public abstract String readBook();
    public abstract String displayReaderType();
}
