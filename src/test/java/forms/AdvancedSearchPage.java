package forms;


import driver.DriverHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AdvancedSearchPage extends BaseForm {

    @FindBy(css = "input#find_film.text.el_1")
    private WebElement filmNameInput;

    private Select contentTypeDropDown = new Select(DriverHolder.getInstance().findElement(By.cssSelector("select[class*='text'][class*='el_17']")));
    private Select fromYearDropDown = new Select(DriverHolder.getInstance().findElement(By.cssSelector("select#from_year")));
    private Select toYearDropDown = new Select(DriverHolder.getInstance().findElement(By.cssSelector("select#to_year")));

    @FindBy(css = "input.el_18.submit.nice_button")
    private WebElement submitButton;

    public void enterFilmName(String filmNameText) {
        filmNameInput.sendKeys(filmNameText);
    }

    public void selectContentType(String contentType) {
        contentTypeDropDown.selectByVisibleText(contentType);
    }

    public void selectFromYear(String fromYear) {
        fromYearDropDown.selectByVisibleText(fromYear);
    }

    public void selectToYear(String toYear) {
        toYearDropDown.selectByVisibleText(toYear);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }
}