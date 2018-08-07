package listeners;

import helper.HasLogger;
import helper.Screenshot;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestListener extends TestListenerAdapter implements HasLogger {
    private Logger log = getLogger();

    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);
        log.info("FAILED TEST [" + this.getTestName(tr) + "]");
        Screenshot.takeScreenshot(tr.getName());
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        super.onTestSkipped(tr);
        log.info("SKIPPED TEST [" + this.getTestName(tr) + "]");
        Screenshot.takeScreenshot(tr.getName());
    }

    @Override
    public void onTestStart(ITestResult tr) {
        super.onTestStart(tr);
        log.info("STARTED TEST [" + this.getTestName(tr) + "]");
    }

    private String getTestName(ITestResult tr) {
        return tr.getTestClass().getRealClass().getSimpleName() + "." + tr.getName();
    }
}
