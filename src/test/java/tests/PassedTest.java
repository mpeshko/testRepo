package tests;

import org.testng.Assert;
import tests.base.BaseTest;
import tests.base.annotations.TestInfo;

@TestInfo(id = 1)
public class PassedTest extends BaseTest {
    @Override
    public void run() {
        Assert.assertTrue(true);
    }
}
