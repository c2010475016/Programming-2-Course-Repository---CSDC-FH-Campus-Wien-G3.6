package at.ac.fhcampuswien;

import at.ac.fhcampuswien.models.Article;
import at.ac.fhcampuswien.models.Source;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*; //Alle Methoden der Klasse werden importiert

public class SetArticlesTest {

    @Test
    @DisplayName("Set Articles: test setting articles")
    public void testSetArticlesAddingArticles() {
        AppController appCon = new AppController();
        appCon.setArticles(listToSet()); // <-- to be tested

        assertNotNull(listToSet()); //For Null-pointer-exception
        assertEquals(appCon.getArticles().toString(), listToSet().toString()); //set articles, articles to be set
    }


//-----------------------------------------------------------------------------------------------------------------//
    //region helper
    private List<Article> generateMockList(){
        List<Article> dummyList = new ArrayList<>();
        Source source = new Source();
        for (int i = 0; i <= 1; i++) { //dummyList filled with dummy articles
            Article article = new Article("author" + i, "title" + i, source, "descr." + i);
            dummyList.add(article);
        }
        return dummyList;
    }

    private List<Article> listToSet(){   //dummy list extended, list to be used in setter
        Source source = new Source();
        Article someArticleToAdd = new Article("Me","I am smart!", source, "descr."); //Article to be added
        List<Article> setList = generateMockList();
        setList.add(someArticleToAdd);
        return setList;
    }
    //endregion
}
