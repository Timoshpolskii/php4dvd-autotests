package helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface HasLogger {
    default Logger getLogger() {
        return LogManager.getLogger(this.getClass());
    }
}
