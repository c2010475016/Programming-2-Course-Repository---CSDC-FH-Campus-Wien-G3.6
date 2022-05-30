package at.ac.fhcampuswien;

import at.ac.fhcampuswien.models.Article;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*; //Alle Methoden der Klasse werden importiert

public class TopHeadlinesAustriaTest {

    @Test
    @DisplayName("Headlines Austria: get Top Headlines Austria with articles")
    public void testGetTopHeadlinesAustria() {
        AppController appCon = new AppController();
        List<Article> testHeadlinesAustriaList;

        testHeadlinesAustriaList = appCon.getTopHeadlinesAustria();
        assertNotNull(testHeadlinesAustriaList);
        //assertEquals(articles.toString(),testHeadlinesAustriaList.toString());
    }

    @Test
    @DisplayName("Headlines Austria: get Top Headlines Austria with Empty List Parameter")
    public void testGetTopHeadlinesAustriaWithEmptyListParameter() {
        AppController appCon = new AppController();
        List<Article> testHeadlinesAustriaList;

        testHeadlinesAustriaList = appCon.getTopHeadlinesAustria();
        //assertNotNull(testHeadlinesAustriaList);
        //assertEquals(0,testHeadlinesAustriaList.size());
    }



// -----------------------------------------------------------------------------------------------------------------//
    //region helper
    private List<Article> generateMockList() {
        List<Article> dummyList = new ArrayList<>();

        for (int i = 0; i <= 5; i++) { //dummyList wird mit verschiedenen Werten befüllt
            Article article = new Article("author" + i, "title" + i, "dummyId" + i, "dummyName" + i, "descr." + i);
            dummyList.add(article);
        }
        return dummyList;
    }

    private List<Article> listToSet(){   //dummy list extended, list to be used in setter
        Article someArticleToAdd = new Article("Me","I am smart!", "dummyId", "dummyName", "descr."); //Article to be added
        List<Article> setList = generateMockList();
        setList.add(someArticleToAdd);
        return setList;
    }
    private List<Article> articles = listToSet();
    //endregion
}
