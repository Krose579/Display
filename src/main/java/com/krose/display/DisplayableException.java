package com.krose.display;

public class DisplayableException extends RuntimeException {
    public DisplayableException(String message, Exception e) {
        super(message, e);
    }
}
