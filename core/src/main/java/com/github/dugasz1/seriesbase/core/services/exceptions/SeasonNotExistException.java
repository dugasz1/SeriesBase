package com.github.dugasz1.seriesbase.core.services.exceptions;

public class SeasonNotExistException extends Exception {
    public SeasonNotExistException() {
    }

    public SeasonNotExistException(String message) {
        super(message);
    }

    public SeasonNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public SeasonNotExistException(Throwable cause) {
        super(cause);
    }

    public SeasonNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
