package com.laba.task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public final class MyReader implements AutoCloseable {
    final BufferedReader bufferedReader;
    public MyReader(final String path) throws IOException {
        bufferedReader = new BufferedReader(new FileReader(path));
    }
    public final String readLine() throws IOException {
        return bufferedReader.readLine();
    }
    @Override
    public final void close() throws IOException {
        bufferedReader.close();
    }
}
