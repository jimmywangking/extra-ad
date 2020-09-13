package com.baron.extraad.exception;

/***
 @package com.baron.extraad
 @author Baron
 @create 2020-09-13-12:38 PM
 */
public class CustomException extends Exception{
    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public CustomException(String message) {
        super(message);
    }
}
