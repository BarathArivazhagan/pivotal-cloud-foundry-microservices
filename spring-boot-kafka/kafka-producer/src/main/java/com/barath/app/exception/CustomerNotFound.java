package com.barath.app.exception;

public class CustomerNotFound extends RuntimeException {


    public CustomerNotFound() {
    }

    public CustomerNotFound(String s) {
        super(s);
    }

    public CustomerNotFound(String s, Throwable throwable) {
        super(s, throwable);
    }

    public CustomerNotFound(Throwable throwable) {
        super(throwable);
    }

    public CustomerNotFound(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
