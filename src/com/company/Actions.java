package com.company;

public class Actions implements IActions{
    @Override
    public double addition(int first, int second) {
        return first+second;
    }

    @Override
    public double subtraction(int first, int second) {
        return first-second;
    }

    @Override
    public double division(int first, int second) {
        return first/second;
    }

    @Override
    public long multiplication(int first, int second) {
        return first*second;
    }
}
