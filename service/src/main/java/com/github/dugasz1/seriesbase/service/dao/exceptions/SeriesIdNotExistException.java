package com.github.dugasz1.seriesbase.service.dao.exceptions;

public class SeriesIdNotExistException extends Exception {
    public SeriesIdNotExistException() {
    }

    public SeriesIdNotExistException(String message) {
        super(message);
    }

    public SeriesIdNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public SeriesIdNotExistException(Throwable cause) {
        super(cause);
    }

    public SeriesIdNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
