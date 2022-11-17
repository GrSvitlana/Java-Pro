package com.junit;

public class Calculator {
    public int sum(int a, int b) {
        if (a + b == ((long) a) + (long) b) {
            return a + b;
        } else {
            throw new AppException("Overflow");
        }
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int mul(int a, int b) {
        return a * b;
    }

    public int div(int a, int b) {
        return a / b;
    }
}
