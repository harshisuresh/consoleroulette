package com.exercise.comet.exceptions;

/**
 * Created by harshitha.suresh on 30/11/2017.
 */
public class UserInputException extends RuntimeException {
    public UserInputException() {
        super();
    }

    public UserInputException(String message) {
        super(message);
    }

    public UserInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserInputException(Throwable cause) {
        super(cause);
    }

    protected UserInputException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
