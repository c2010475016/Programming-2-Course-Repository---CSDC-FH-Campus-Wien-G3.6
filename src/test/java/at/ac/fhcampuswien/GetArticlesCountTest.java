package at.ac.fhcampuswien;

import at.ac.fhcampuswien.models.Article;
import at.ac.fhcampuswien.models.Source;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*; //Alle Methoden der Klasse werden importiert

public class GetArticlesCountTest {

    @Test
    @DisplayName("Counting Articles After generateMockList")
    public void testArticlesCountWithArticles() {
        AppController appCon = new AppController();
        appCon.setArticles(listToSet());
        assertEquals(generateMockList().size()+1, appCon.getArticleCount());
    }

    @Test
    @DisplayName("Testing Article count with Null articles")
    public void testArticlesCountWithNullArticles(){
        AppController appCon = new AppController();
        appCon.setArticles(null);
        assertEquals(0, appCon.getArticleCount());
    }

    //region helper
    private List<Article> generateMockList(){
        List<Article> dummyList = new ArrayList<>();
        Source source = new Source();
        for (int i = 0; i <= 5; i++) { //dummyList wird mit verschiedenen Werten befüllt
            Article article = new Article("author" + i, "title" + i, source, "descr." + i);
            dummyList.add(article);
        }
        return dummyList;
    }

    private List<Article> listToSet(){
        Source source = new Source();
        Article someArticleToAdd = new Article("Me","I am smart!", source, "descr."); //Article to be added
        List<Article> setList = generateMockList();
        setList.add(someArticleToAdd);
        return setList;
    }
    //endregion
}
