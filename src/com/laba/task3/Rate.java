package com.laba.task3;

public final class Rate {
    private int rate;

    public final int getRate() {
        return rate;
    }

    public final void setRate(final int rate) {
        this.rate = rate;
    }

    @Override
    public final String toString() {
        return Integer.toString(rate);
    }
}
