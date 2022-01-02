package com.krose.display;

public final class UserInput<T> {
    private static final int CODE_SUCCESS = 0;
    private static final int CODE_FAILURE = 1;

    private final T value;
    private final int statusCode;
    private final String failureMessage;
    private final boolean isRetryAllowed;

    private UserInput(T value, int statusCode, String failureMessage, boolean isRetryAllowed) {
        this.value = value;
        this.statusCode = statusCode;
        this.failureMessage = failureMessage;
        this.isRetryAllowed = isRetryAllowed;
    }

    public boolean isSuccessful() {
        return statusCode == CODE_SUCCESS;
    }

    public boolean isFailure() {
        return statusCode == CODE_FAILURE;
    }

    public boolean isRetryAllowed() {
        return isRetryAllowed;
    }

    public T getValue() {
        return value;
    }

    public String getFailureMessage() {
        return failureMessage;
    }

    public static <U> UserInput<U> successful(U value) {
        return new UserInput<>(value, CODE_SUCCESS, null, false);
    }

    public static <U> UserInput<U> failure(String failureMessage, boolean isRetryAllowed) {
        return new UserInput<>(null, CODE_FAILURE, failureMessage, isRetryAllowed);
    }
}
