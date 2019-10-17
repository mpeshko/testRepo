package tests.base;

import framework.utils.testrail.api.APIException;
import org.testng.ITestResult;
import org.testng.annotations.*;
import tests.base.annotations.TestInfo;
import framework.utils.testrail.TestRailUtils;

import java.io.IOException;

public abstract class BaseTest {

    private TestInfo testInfo;
    private TestRailUtils util = new TestRailUtils();

    public abstract void run();

    @Test
    public void test(){
        testInfo = getClass().getAnnotation(TestInfo.class);
        run();
    }

    @AfterMethod
    public void report(ITestResult result) throws IOException, APIException {
        util.addResultForTestCase(util.insertTestRunId(), String.valueOf(testInfo.id()), util.convertTestNGtoTestRail(result.getStatus()));
    }
}
