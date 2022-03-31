package at.ac.fhcampuswien;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*; //Alle Methoden der Klasse werden importiert

public class SetArticlesTest {

    @Test
    @DisplayName("setArticles1")
    public void testSetArticles1() {
//        AppController appCon = new AppController();
//        List<Article> testFilterList = new ArrayList<>();
//        testFilterList = appCon.filterList("Dog", generateMockList());
//        assertNotNull(testFilterList); //Für Nullpointerexception
//        assertEquals(0,testFilterList.size()); //0, weil es 0 "Dog" Artikel gibt
    }

    @Test
    @DisplayName("setArticles2")
    public void testSetArticles2() {
//        AppController appCon = new AppController();
//        List<Article> testFilterList = new ArrayList<>();
//        testFilterList = appCon.filterList("Dog", generateMockList());
//        assertNotNull(testFilterList); //Für Nullpointerexception
//        assertEquals(0,testFilterList.size()); //0, weil es 0 "Dog" Artikel gibt
    }

    @Test
    @DisplayName("setArticles3")
    public void testSetArticles3() {
//        AppController appCon = new AppController();
//        List<Article> testFilterList = new ArrayList<>();
//        testFilterList = appCon.filterList("Dog", generateMockList());
//        assertNotNull(testFilterList); //Für Nullpointerexception
//        assertEquals(0,testFilterList.size()); //0, weil es 0 "Dog" Artikel gibt
    }

    //region helper
    private List<Article> generateMockList(){
        List<Article> dummyList = new ArrayList<>();

        for (int i = 0; i <= 5; i++) { //dummyList wird mit verschiedenen Werten befüllt
            Article article = new Article("author" + i, "title" + i);
            dummyList.add(article);
        }
        return dummyList;
    }
    //endregion
}
