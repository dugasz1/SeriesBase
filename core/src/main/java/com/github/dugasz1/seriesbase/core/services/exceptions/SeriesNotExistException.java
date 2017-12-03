package com.github.dugasz1.seriesbase.core.services.exceptions;

public class SeriesNotExistException extends Exception {
    public SeriesNotExistException() {
    }

    public SeriesNotExistException(String message) {
        super(message);
    }

    public SeriesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public SeriesNotExistException(Throwable cause) {
        super(cause);
    }

    public SeriesNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
