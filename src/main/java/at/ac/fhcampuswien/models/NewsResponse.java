package at.ac.fhcampuswien.models;

import at.ac.fhcampuswien.models.Article;

import java.util.List;

public class NewsResponse {

    private String status;
    private int totalResults;
    private List<Article> articles;


    public String getStatus() {
        return status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public List<Article> getArticles() {
        return articles;
    }
}
