package com.barath.app.exception;

public class CustomerExists extends RuntimeException {

    public CustomerExists() {
    }

    public CustomerExists(String s) {
        super(s);
    }

    public CustomerExists(String s, Throwable throwable) {
        super(s, throwable);
    }

    public CustomerExists(Throwable throwable) {
        super(throwable);
    }

    public CustomerExists(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
