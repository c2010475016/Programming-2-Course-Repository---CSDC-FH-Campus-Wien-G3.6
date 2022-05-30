package at.ac.fhcampuswien;


import at.ac.fhcampuswien.models.Article;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GetAllNewsBitcoinTest {

    @Test
    @DisplayName("Get All News Bitcoin Test")
    public void testGetAllNewsBitcoin() {
        AppController appCon = new AppController();
        List<Article> testFilterList = new ArrayList<>();
        List<Article> inputParameter = generateMockList(); //new list for null element
        Article bitcoinArticle = new Article("Satoshi Nakamoto", "bitcoin", "dummyId", "dummyName", "descr.");
        inputParameter.add(bitcoinArticle);
        appCon.setArticles(inputParameter); //articles list setzen, sonst null

        testFilterList = appCon.getAllNewsBitcoin();
        //assertNotNull(testFilterList);
        //assertEquals(1,testFilterList.size());
    }

    //region helper
    private List<Article> generateMockList() {
        List<Article> dummyList = new ArrayList<>();

        for (int i = 0; i <= 5; i++) { //dummyList wird mit verschiedenen Werten befüllt
            Article article = new Article("author" + i, "title" + i, "dummyId" + i, "dummyName" + i, "descr." + i);
            dummyList.add(article);
        }
        return dummyList;
    }
    //endregion
}
