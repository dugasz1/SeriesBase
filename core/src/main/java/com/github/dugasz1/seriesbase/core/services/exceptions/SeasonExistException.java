package com.github.dugasz1.seriesbase.core.services.exceptions;

public class SeasonExistException extends Exception{
    public SeasonExistException() {
    }

    public SeasonExistException(String message) {
        super(message);
    }

    public SeasonExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public SeasonExistException(Throwable cause) {
        super(cause);
    }

    public SeasonExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
