package at.ac.fhcampuswien;

import java.util.ArrayList;
import java.util.Collections;
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
        List<Article> tempFilterList = new ArrayList<>(); //temporäre Zwischenliste für die neuen Artikel mit Query speichern

        if (query == null) {
            return Collections.emptyList(); // oder articles
        }

        articles.forEach(article -> { // forEach geht jedes Element in article durch, dadurch Zugriff auf einen spezifischen Artikel
            if (article.getTitle().toLowerCase().contains(query.toLowerCase())) { // Groß/Kleinschreibung wird nicht beachtet
                tempFilterList.add(article); // Liste wird mit diesen gefilterten Artikel befüllt
            }
        });
        return tempFilterList; //neue Liste zurückgeben
    }

    private static List<Article> generateMockList(){
        List<Article> dummyList = new ArrayList<>();

        for (int i = 0; i <= 5; i++) { //dummyList wird mit verschiedenen Werten befüllt
            Article article = new Article("author" + i, "title" + i);
            dummyList.add(article);
        }
        return dummyList;
    }
}
