package forms;

import driver.DriverHolder;
import org.openqa.selenium.support.PageFactory;

abstract class BaseForm {
    BaseForm() {
        PageFactory.initElements(DriverHolder.getInstance(), this);
    }
}
