package at.ac.fhcampuswien;

import java.util.ArrayList;
import java.util.List;

public class AppController {

    private List<Article> articles;

    public AppController() {

    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public int getArticleCount() {
        return articles.size();
    }

    public List<Article> getTopHeadlinesAustria(){
        return articles;
    }

    public List<Article> getAllNewsBitcoin() {
        return articles;
    }

    protected List<Article> filterList(String query, List<Article> articles){
        return articles;
    }

    private static List<Article> generateMockList(){
        return null;
    }
}
