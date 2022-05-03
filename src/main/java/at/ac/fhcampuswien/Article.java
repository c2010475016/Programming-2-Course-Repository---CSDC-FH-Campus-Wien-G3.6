package at.ac.fhcampuswien;

public class Article {

    private String author = "";
    private String title = "";
    private String sourceId = "";
    private String sourceName = "";
    private String description = "";

    public Article(String author, String title, String sourceId, String sourceName, String description) {
        this.author = author;
        this.title = title;
        this.sourceId = sourceId;
        this.sourceName = sourceName;
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return "Author: " + this.author + " Title: " + this.title;
    }
}
