package com.github.dugasz1.seriesbase.core.services.exceptions;

public class ActorExistException extends Exception {
    public ActorExistException() {
    }

    public ActorExistException(String message) {
        super(message);
    }

    public ActorExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public ActorExistException(Throwable cause) {
        super(cause);
    }

    public ActorExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
