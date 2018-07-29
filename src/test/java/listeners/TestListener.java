package listeners;

import helper.Screenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult tr) {
        //TODO implement logging
        super.onTestFailure(tr);
        Screenshot.takeScreenshot(tr.getName());
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        //TODO implement logging
        super.onTestSkipped(tr);
        Screenshot.takeScreenshot(tr.getName());
    }

    private String getTestName(ITestResult tr) {
        return tr.getTestClass().getRealClass().getSimpleName() + "." + tr.getTestName();
    }
}
