package com.github.dugasz1.seriesbase.dao.exceptions;

public class UnableToSaveException extends Exception {
    public UnableToSaveException() {
    }

    public UnableToSaveException(String message) {
        super(message);
    }

    public UnableToSaveException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnableToSaveException(Throwable cause) {
        super(cause);
    }

    public UnableToSaveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
