package at.ac.fhcampuswien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppController {

    private List<Article> articles = new ArrayList<>(); // initialisiere liste

    public AppController() {
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public int getArticleCount() {
        if (articles == null) {
            return 0;
        } else {
            return articles.size();
        }
    }

    public List<Article> getTopHeadlinesAustria(){
        if (articles == null) {
            return Collections.emptyList(); // return empty list oder new Arraylist
        } else {
            return articles;
        }
    }

    public List<Article> getAllNewsBitcoin() {
        return filterList("bitcoin",articles);
    }

    protected List<Article> filterList(String query, List<Article> articles){
        List<Article> tempFilterList = new ArrayList<>(); //temporäre Zwischenliste für die neuen Artikel mit Query speichern
        if (articles == null) { // für Nullpointer Exception
            return Collections.emptyList(); // return empty list oder new Arraylist
        }
        if (query == null) {
            return Collections.emptyList(); // oder articles
        }

        articles.forEach(article -> { // forEach geht jedes Element in article durch, dadurch Zugriff auf einen spezifischen Artikel
            if (article != null && article.getTitle().toLowerCase().contains(query.toLowerCase())) { // Groß/Kleinschreibung wird nicht beachtet
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
