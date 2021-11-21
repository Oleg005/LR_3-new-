package com.laba.task4;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public final class Main {
    public static int result;
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String expression = "";

        final CalcThread thread1 = new CalcThread();
        final CalcCallable thread2 = new CalcCallable();
        final ExecutorService service = Executors.newFixedThreadPool(1);

        while(!(expression = scanner.nextLine()).equals("exit")) {
            final String[] expressionSplit = expression.trim().split(" ");
            final int number1 = Integer.valueOf(expressionSplit[0]);
            final int number2 = Integer.valueOf(expressionSplit[2]);
            final char operation = expressionSplit[1].charAt(0);

            thread1.setExpression(number1, number2, operation);
            final Thread tmp = new Thread(thread1);
            tmp.start();
            if(tmp.isAlive()){
                try{
                    tmp.join();
                } catch (InterruptedException e){}
            }

            thread2.setExpression(number1, number2, operation);
            final Future future = service.submit(thread2);
            int result = 0;
            try {
                result = (Integer) future.get();
            } catch (Exception e) {}

            System.out.println("[Runnable] " + number1 + " " + operation + " " + number2 + " = " + Main.result);
            System.out.println("[Callable] " + number1 + " " + operation + " " + number2 + " = " + result);
        }
    }
}