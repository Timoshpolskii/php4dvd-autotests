package driver;

public interface HasWaiter {

    default Waiter waiter(long duration) {
        return new Waiter(duration);
    }

    default Waiter waiter() {
        return new Waiter();
    }

    boolean waitForPageToBeLoaded();
}
