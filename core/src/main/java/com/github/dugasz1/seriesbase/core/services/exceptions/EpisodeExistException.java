package com.github.dugasz1.seriesbase.core.services.exceptions;

public class EpisodeExistException extends Exception {
    public EpisodeExistException() {
    }

    public EpisodeExistException(String message) {
        super(message);
    }

    public EpisodeExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public EpisodeExistException(Throwable cause) {
        super(cause);
    }

    public EpisodeExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
