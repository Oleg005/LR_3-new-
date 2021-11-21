package com.laba.task2;

import java.io.IOException;

public final class Main {
    public static void main(final String[] args) {
        try(final MyReader reader = new MyReader("test.txt")) {
            String line;
            while((line = reader.readLine()) != null)
                System.out.println(line);
        } catch (final IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}