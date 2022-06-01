package at.ac.fhcampuswien;

import at.ac.fhcampuswien.Enums.Country;
import at.ac.fhcampuswien.Enums.Endpoint;
import at.ac.fhcampuswien.Enums.Status;
import at.ac.fhcampuswien.api.NewsApi;
import at.ac.fhcampuswien.api.NewsApiException;
import at.ac.fhcampuswien.models.Article;
import at.ac.fhcampuswien.models.NewsResponse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class AppController {

    private List<Article> articles;

    public AppController() {
        //articles = generateMockList(); statische Liste aus Übung 1?
        articles = new ArrayList<>();
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public int getArticleCount() {
//        if (articles == null) {
//            return 0;
//        }
//        return articles.size();

        NewsApi newsapi = new NewsApi();
        NewsResponse response = null;
        try {
            response = newsapi.getNews(Endpoint.EVERYTHING, "*");
        } catch (NewsApiException e) {
            e.printStackTrace();
        }

        if (response == null || !Objects.equals(response.getStatus(), Status.ok.name())) {
            return 0;
        }
        return response.getArticles().size();
    }

    public List<Article> getTopHeadlinesAustria() {
        NewsApi newsapi = new NewsApi();
        NewsResponse response = null;
        try {
            response = newsapi.getNews(Endpoint.TOP_HEADLINES, "corona", Country.at);
        } catch (NewsApiException e) {
            e.printStackTrace();
        }

        if (response == null || !Objects.equals(response.getStatus(), Status.ok.name())) {
            return Collections.emptyList();
        }
        return response.getArticles();
        //old code
        //if (articles == null) { // für Nullpointer Exception
        //   return Collections.emptyList(); // return empty list oder new Arraylist
        //}
        //return articles;
    }

    public List<Article> getAllNewsBitcoin() {
        NewsApi newsapi = new NewsApi();
        NewsResponse response = null;
        try {
            response = newsapi.getNews(Endpoint.EVERYTHING, "bitcoin");
        } catch (NewsApiException e) {
            e.printStackTrace();
        }

        if (response == null || !Objects.equals(response.getStatus(), Status.ok.name())) {
            return Collections.emptyList();
        }

        return response.getArticles();
        //old code
        //return filterList("bitcoin",articles); //die articles gefiltert
    }

    protected List<Article> filterList(String query, List<Article> articles) {
        List<Article> tempFilterList = new ArrayList<>(); //temporäre Zwischenliste für die neuen Artikel mit Query speichern

        if (articles == null) { // für Nullpointer Exception
            return Collections.emptyList(); // return empty list oder new Arraylist
        }
        if (query == null) {
            return Collections.emptyList(); // oder articles
        }

        articles.forEach(articleElement -> { // forEach geht jedes Element in articleElement durch, dadurch Zugriff auf einen spezifischen Artikel
            if (articleElement != null && articleElement.getTitle().toLowerCase().contains(query.toLowerCase())) { // Groß/Kleinschreibung wird nicht beachtet
                tempFilterList.add(articleElement); // Liste wird mit diesen gefilterten Artikel befüllt
            }
        });
        return tempFilterList; //neue Liste zurückgeben
    }

//    private static List<Article> generateMockList() {
//        List<Article> dummyList = new ArrayList<>();
//
//        for (int i = 0; i <= 5; i++) { //dummyList wird mit verschiedenen Werten befüllt
//            Article article = new Article("author" + i, "title" + i, "dummyId" + i, "dummyName" + i, "descr." + i);
//            dummyList.add(article);
//        }
//        return dummyList;
//    }
}
