package at.ac.fhcampuswien.models;

public class Article {

    private String author;
    private String title;
    private Source source;
    private String description;

    public Article(String author, String title, Source source, String description) {
        this.author = author;
        this.title = title;
        this.source = source;
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Source getSource() {
        return source;
    }

    @Override
    public String toString() {
        return "Author: " + getAuthor()+ " Title: " + getTitle();
    }
}
