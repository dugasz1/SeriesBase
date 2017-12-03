package com.github.dugasz1.seriesbase.core.services.exceptions;

public class ActorNotExistException extends Exception {
    public ActorNotExistException() {
    }

    public ActorNotExistException(String message) {
        super(message);
    }

    public ActorNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public ActorNotExistException(Throwable cause) {
        super(cause);
    }

    public ActorNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
