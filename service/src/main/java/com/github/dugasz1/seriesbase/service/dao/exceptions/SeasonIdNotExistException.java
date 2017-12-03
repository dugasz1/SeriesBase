package com.github.dugasz1.seriesbase.service.dao.exceptions;

public class SeasonIdNotExistException extends Exception {
    public SeasonIdNotExistException() {
    }

    public SeasonIdNotExistException(String message) {
        super(message);
    }

    public SeasonIdNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public SeasonIdNotExistException(Throwable cause) {
        super(cause);
    }

    public SeasonIdNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
