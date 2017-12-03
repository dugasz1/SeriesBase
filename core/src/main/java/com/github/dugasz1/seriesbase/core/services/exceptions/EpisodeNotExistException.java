package com.github.dugasz1.seriesbase.core.services.exceptions;

public class EpisodeNotExistException extends Exception {
    public EpisodeNotExistException() {
    }

    public EpisodeNotExistException(String message) {
        super(message);
    }

    public EpisodeNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public EpisodeNotExistException(Throwable cause) {
        super(cause);
    }

    public EpisodeNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
