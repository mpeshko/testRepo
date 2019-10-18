import forms.AdvancedSearchPage;
import forms.KinoPoiskManagerPage;
import forms.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import tests.base.annotations.TestInfo;

@TestInfo(id = 2)
public class TestKinopoisk extends BaseTest {

    @Override
       public void run() {

        KinoPoiskManagerPage manager = new KinoPoiskManagerPage();
        manager.clickAdvancedSearch();

        AdvancedSearchPage searchForm = new AdvancedSearchPage();
        searchForm.enterFilmName("Игра");
        searchForm.selectContentType("сериал" );
        searchForm.selectFromYear("2011");
        searchForm.selectToYear("2020");
        searchForm.clickSubmitButton();

        SearchResultPage searchResult = new SearchResultPage();
        Assert.assertTrue(searchResult.findContent("игра престолов"), "Result does not contain expected search result");
    }
}