package at.ac.fhcampuswien;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*; //Alle Methoden der Klasse werden importiert

public class AppTest {

    @Test
    @DisplayName("Filter List Filtering After Non Existing Articles")
    public void testFilterListFilteringAfterNonExistingArticles() {
        AppController appCon = new AppController();
        List<Article> testFilterList = new ArrayList<>();
        testFilterList = appCon.filterList("Dog", generateMockList());
        assertNotNull(testFilterList); //Für Nullpointerexception
        assertEquals(0,testFilterList.size()); //0, weil es 0 "Dog" Artikel gibt
    }

    @Test
    @DisplayName("Filter List Filtering Test For Existing Articles")
    public void testFilterListFilteringTestForExistingArticles() {
        AppController appCon = new AppController();
        List<Article> testFilterList = new ArrayList<>();
        testFilterList = appCon.filterList("Title", generateMockList());
        assertNotNull(testFilterList); //Für Nullpointerexception
        assertEquals(6,testFilterList.size()); //6, weil es 6 Title Artikel gibt
    }

    @Test
    @DisplayName("Filter List Filtering Test Empty Query Parameter")
    public void testFilterListFilteringTestEmptyQueryParameter() {
        AppController appCon = new AppController();
        List<Article> testFilterList = new ArrayList<>();
        testFilterList = appCon.filterList("", generateMockList());
        assertNotNull(testFilterList);
        assertEquals(6,testFilterList.size());
    }

    @Test
    @DisplayName("Filter List Filtering Test Null Query Parameter")
    public void testFilterListFilteringTestNullQueryParameter() {
        AppController appCon = new AppController();
        List<Article> testFilterList = new ArrayList<>();
        testFilterList = appCon.filterList(null, generateMockList());
        assertNotNull(testFilterList);
        assertEquals(0,testFilterList.size());
    }

    @Test
    @DisplayName("Filter List Filtering Test Null List Parameter")
    public void testFilterListFilteringTestNullListParameter() {
        AppController appCon = new AppController();
        List<Article> testFilterList = new ArrayList<>();
        testFilterList = appCon.filterList("", null);
        assertNotNull(testFilterList);
        assertEquals(0,testFilterList.size());
    }

    @Test
    @DisplayName("Filter List Filtering Test With Null Element")
    public void testFilterListTestListWithNullElement() {
        AppController appCon = new AppController();
        List<Article> testFilterList = new ArrayList<>();
        List<Article> inputParameter = generateMockList(); //new list for null element
        inputParameter.add(null);
        testFilterList = appCon.filterList("", inputParameter);
        assertNotNull(testFilterList);
        assertEquals(6,testFilterList.size());
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
