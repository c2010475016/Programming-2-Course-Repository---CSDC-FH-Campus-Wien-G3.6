package at.ac.fhcampuswien;

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
        List<Article> inputParameter = generateMockList();   //some List to set the Article-to-add into
        Article someArticleToAdd = new Article("Me","I am smart!"); //Article to be added
        inputParameter.add(someArticleToAdd);
        appCon.setArticles(inputParameter); // <-- to be tested

        assertNotNull(inputParameter); //For Null-pointer-exception
        assertEquals(appCon.getArticles().toString(), inputParameter.toString()); //set articles, articles to be set
    }

    //region helper
    private List<Article> generateMockList(){
        List<Article> dummyList = new ArrayList<>();

        for (int i = 0; i <= 1; i++) { //dummyList filled with dummy articles
            Article article = new Article("author" + i, "title" + i);
            dummyList.add(article);
        }
        return dummyList;
    }
    //endregion
}
