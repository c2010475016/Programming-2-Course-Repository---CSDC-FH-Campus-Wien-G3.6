package at.ac.fhcampuswien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppController {

    private List<Article> articles;

    public AppController() {

    }

    public void setArticles(List<Article> articles) {
        this.articles = new ArrayList<>(articles);
    }

    public List<Article> getArticles() {
        return articles;
    }

    public int getArticleCount() {
        if (articles == null) {
            return 0;
        }
        return articles.size();
    }

    public List<Article> getTopHeadlinesAustria(){
        Article someArticleToAdd = new Article("Me","I am smart!"); //Article to be added
        setArticles(generateMockList());
        articles.add(someArticleToAdd);
        if (articles == null) { // für Nullpointer Exception
            return Collections.emptyList(); // return empty list oder new Arraylist
        }
        return articles;
    }

    public List<Article> getAllNewsBitcoin() {
        return filterList("bitcoin",articles); //die articles gefiltert
    }

    protected List<Article> filterList(String query, List<Article> articles){
        List<Article> tempFilterList = new ArrayList<>(); //temporäre Zwischenliste für die neuen Artikel mit Query speichern

        if (articles == null) { // für Nullpointer Exception
            return Collections.emptyList(); // return empty list oder new Arraylist
        }
        if (query == null) {
            return Collections.emptyList(); // oder articles
        }

        articles.forEach(articleElement -> { // forEach geht jedes Element in articleElement durch, dadurch Zugriff auf einen spezifischen Artikel
            if (articleElement != null && articleElement.getTitle() != null && articleElement.getTitle().toLowerCase().contains(query.toLowerCase())) { // Groß/Kleinschreibung wird nicht beachtet
                tempFilterList.add(articleElement); // Liste wird mit diesen gefilterten Artikel befüllt
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
