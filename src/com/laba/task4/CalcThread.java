package com.laba.task4;

public final class CalcThread implements Runnable {
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
    public final void run() {
        switch (operation) {
            case '+' -> Main.result = number1 + number2;
            case '-' -> Main.result = number1 - number2;
        }
        System.out.println("[Runnable] Розрахунок в другому потоці!");
    }
}