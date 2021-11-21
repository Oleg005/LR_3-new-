package com.laba.task3;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

public final class Student {
    private final int id;
    private final Set<PairSubjectRate> subjects;
    private final String name;
    private final String surname;
    private final String patronymic;

    public Student(final int id, final String name, final String surname, final String patronymic) {
        this.id = id;
        this.subjects = new HashSet<>();
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public final int getId() {
        return id;
    }
    public final Set<PairSubjectRate> getSubjects() {
        return subjects;
    }
    public final String getName() {
        return name;
    }
    public final String getSurname() {
        return surname;
    }
    public final String getPatronymic() {
        return patronymic;
    }

    public final void addSubject(final String subject){
        this.subjects.add(new PairSubjectRate(subject));
    }

    public final void setRate(final String name, final int rate){
        final PairSubjectRate subject =  subjects.stream()
                                            .filter(s->s.getName().equalsIgnoreCase(name))
                                            .findFirst()
                                            .orElseThrow(NoSuchElementException::new);
        subject.getRate().setRate(rate);
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        final Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public final String toString() {
        return "Студент " + surname + " " + name + " " + patronymic + ", id = " + id + ", предмети: "
                + subjects;
    }
}