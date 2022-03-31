package at.ac.fhcampuswien;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*; //Alle Methoden der Klasse werden importiert

public class AppTest {

    @Test
    @DisplayName("Filter List Filtering After Non Existing Article")
    public void testFilterListFilteringAfterNonExistingArticles() {
        AppController appCon = new AppController();
        List<Article> testFilterList = new ArrayList<>();
        testFilterList = appCon.filterList("Dog", generateMockList());
        assertNotNull(testFilterList);
        assertEquals(0,testFilterList.size()); //0, weil es 0 "Dog" Artikel gibt
    }

    @Test
    @DisplayName("Filter List Filtering Test")
    public void testFilterListFilteringTestForExistingArticles() {
        AppController appCon = new AppController();
        List<Article> testFilterList = new ArrayList<>();
        testFilterList = appCon.filterList("Title", generateMockList());
        assertNotNull(testFilterList);
        assertEquals(6,testFilterList.size()); //6, weil es 6 Title Artikel gibt
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
