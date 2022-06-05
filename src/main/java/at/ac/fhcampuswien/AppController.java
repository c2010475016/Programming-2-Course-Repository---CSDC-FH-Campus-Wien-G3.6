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
import java.util.stream.Collectors;

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
        NewsApi newsapi = new NewsApi();
        NewsResponse response = null;
        try {
            response = newsapi.getNews(Endpoint.EVERYTHING, "*", null);
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
            setArticles(Collections.emptyList());
        } else {
            setArticles(sortArticles(response.getArticles()));
        }
        return getArticles();
    }

    public List<Article> getAllNewsBitcoin() {
        NewsApi newsapi = new NewsApi();
        NewsResponse response = null;
        try {
            response = newsapi.getNews(Endpoint.EVERYTHING, "bitcoin",null);
        } catch (NewsApiException e) {
            e.printStackTrace();
        }

        if (response == null || !Objects.equals(response.getStatus(), Status.ok.name())) {
            setArticles(Collections.emptyList());
        } else {
            setArticles(sortArticles(response.getArticles()));
        }
        return getArticles();
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

    private List<Article> sortArticles(List<Article> list) {
        return list.stream().sorted((a1,a2) -> {
            int a1DescriptionSize = a1.getDescription().length();
            int a2DescriptionSize = a2.getDescription().length();

            if (a1DescriptionSize > a2DescriptionSize || a1DescriptionSize < a2DescriptionSize) {
                return Integer.compare(a1.getDescription().length(),a2.getDescription().length());
            } else {
                return a1.getDescription().compareTo(a2.getDescription());
            }
        }).collect(Collectors.toList());
    }


    //region Search
    public String providerWithMostArticles() {
        getArticles().stream().collect(Collectors.groupingBy(article -> article.getSource()));
        System.out.print("" +
                "" +
                "hallo");
        return "";
    }

    public long getCountOfNewYorkTimes() {
       return getArticles().stream().filter(article -> article.getSource().getName().equals("New York Times")).count();
    }

    public long getCountHeadlineUnder15Chars() {
        return getArticles().stream().filter(article -> article.getTitle().length() < 15).count();
    }
    //endregion

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
