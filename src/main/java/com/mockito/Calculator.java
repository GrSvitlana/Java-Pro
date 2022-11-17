package com.mockito;

public class Calculator {

    ICalculator icalc;

    public Calculator(ICalculator icalc) {
        this.icalc = icalc;
    }

    public double sum (double a, double b) {
        return icalc.sum(a, b);
    }

    public double sub (double a, double b) {
        return icalc.sub(a, b);
    }

    public double mul (double a, double b) {
        return icalc.mul(a, b);
    }

    public double div (double a, double b) {
        return icalc.div(a, b);
    }

    public double aDouble15() {
        return 15.;
    }
}
