package com.laba.task3;

public final class StudentSimple {
    private final String name;
    private final Double averageRate;

    public StudentSimple(final String name, final Double averageRate) {
        this.name = name;
        this.averageRate = averageRate;
    }

    public final String getName() { return name; }
    public final Double getAverageRate() { return averageRate; }

    @Override
    public final String toString() {
        return "Студент " + name + ", середній бал " + averageRate;
    }
}