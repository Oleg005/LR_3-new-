package com.laba.task4;

import java.util.concurrent.Callable;

public final class CalcCallable implements Callable<Integer> {
    private int number1;
    private int number2;
    private char operation;

    public final void setExpression(final int number1, final int number2, final char operation) {
        if(operation != '+' && operation != '-')
            throw new IllegalArgumentException();
        this.number1 = number1;
        this.number2 = number2;
        this.operation = operation;
    }

    @Override
    public final Integer call() {
        final int result = switch (operation) {
            case '+' -> number1 + number2;
            case '-' -> number1 - number2;
            default -> 0;
        };
        System.out.println("[Callable] Розрахунок в другому потоці!");
        return result;
    }
}
