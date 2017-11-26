package com.github.dugasz1.seriesbase.core.services.exceptions;

public class SeriesExistException extends Exception {
    public SeriesExistException() {
    }

    public SeriesExistException(String message) {
        super(message);
    }

    public SeriesExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public SeriesExistException(Throwable cause) {
        super(cause);
    }

    public SeriesExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
