package tests.base;

import driver.DriverHolder;
import framework.utils.testrail.api.APIException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import tests.base.annotations.TestInfo;
import framework.utils.testrail.TestRailUtils;

import java.io.IOException;

public abstract class BaseTest {

    private TestInfo testInfo;
    private TestRailUtils util = new TestRailUtils();

    public abstract void run();

    private static final String URL = "https://www.kinopoisk.ru";

    @BeforeMethod
    public void setUp() {
        WebDriver driver = DriverHolder.getInstance();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @Test
    public void test(){
        testInfo = getClass().getAnnotation(TestInfo.class);
        run();
    }

    @AfterMethod
    public void report(ITestResult result) throws IOException, APIException {
        util.addResultForTestCase(util.insertTestRunId(), String.valueOf(testInfo.id()), util.convertTestNGtoTestRail(result.getStatus()));
        DriverHolder.clean();
    }
}
