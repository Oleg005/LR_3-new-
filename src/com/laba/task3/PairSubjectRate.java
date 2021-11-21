package com.laba.task3;

import java.util.Objects;

public final class PairSubjectRate {
    private final String name;
    private Rate rate;

    public PairSubjectRate(final String name) {
        this.name = name;
        this.rate = new Rate();
    }

    public final Rate getRate() {
        return rate;
    }

    public final void setRate(final Rate rate) {
        this.rate = rate;
    }

    public final String getName() {
        return name;
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof PairSubjectRate)) return false;
        final PairSubjectRate subject = (PairSubjectRate) o;
        return Objects.equals(name, subject.name);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public final String toString() {
        return  name +  (rate.getRate()==0 ? "":" "+rate.getRate());
    }
}