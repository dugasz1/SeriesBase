package com.github.dugasz1.seriesbase.core.model.exceptions;

public class InvalidRatingException extends Exception {
    public InvalidRatingException() {
    }

    public InvalidRatingException(String s) {
        super(s);
    }

    public InvalidRatingException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public InvalidRatingException(Throwable throwable) {
        super(throwable);
    }

    public InvalidRatingException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
