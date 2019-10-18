package forms;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BaseForm {
    @FindBy(css = "div.search_results.search_results_last")
    private WebElement searchResul;

    public boolean findContent(String searchResultText) {
        return searchResul.getText().toLowerCase().contains(searchResultText);
    }

}