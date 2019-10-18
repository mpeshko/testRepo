package forms;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KinoPoiskManagerPage extends BaseForm {

    @FindBy(xpath = "//a[@class[contains(., 'advanced-search-button')]]")
    private WebElement advancedSearchButton;

    public void clickAdvancedSearch() {
        advancedSearchButton.click();
    }

}