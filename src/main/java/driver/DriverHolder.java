package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverHolder {
    private static WebDriver instance;

    private DriverHolder() {
    }

    public static WebDriver getInstance() {
        if (instance == null) {
            WebDriverManager.chromedriver().setup();
            instance = new ChromeDriver();
        }
        return instance;
    }

    public static void clean() {
        instance.quit();
        instance = null;
    }
}

