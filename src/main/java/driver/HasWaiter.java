package driver;

public interface HasWaiter {

    default Waiter waiter(long duration) {
        return new Waiter(duration);
    }

    boolean waitForPageToBeLoaded();
}
