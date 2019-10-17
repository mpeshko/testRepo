package tests;

import org.testng.Assert;
import tests.base.BaseTest;
import tests.base.annotations.TestInfo;

@TestInfo(id = 2)
public class FailedTest extends BaseTest {
    @Override
    public void run() {
        Assert.assertFalse(false);
    }
}
