package com.krose.display;

public abstract class UserInput<T, U> {
    public boolean isSuccess() {
        return this instanceof Success;
    }

    public boolean isFailure() {
        return this instanceof Failure;
    }

    public static final class Success<T> extends UserInput<T, Void> {
        private final T value;

        public Success(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }
    }

    public static final class Failure<U extends Exception> extends UserInput<Void, U> {
        private final U exception;
        private final String retryMessage;
        private final boolean isRetryAllowed;

        public Failure(U exception) {
            this.exception = exception;
            this.retryMessage = null;
            this.isRetryAllowed = false;
        }

        public Failure(U exception, String retryMessage) {
            this.exception = exception;
            this.retryMessage = retryMessage;
            this.isRetryAllowed = true;
        }

        public U getException() {
            return exception;
        }

        public String getRetryMessage() {
            return retryMessage;
        }

        public boolean isRetryAllowed() {
            return isRetryAllowed;
        }
    }
}
