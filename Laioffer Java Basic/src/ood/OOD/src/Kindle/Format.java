package ood.OOD.src.Kindle;

public enum Format {
    EPUB("epub"), PDF("pdf"), MOBI("mobi");

    private String content;
    Format(String content) {
        this.content = content;
    }


    public String getContent() {
        return content;
    }
}
