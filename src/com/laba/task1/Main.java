package com.laba.task1;

public final class Main {
    public static void main(final String[] args) {
        final Address address = new Address("Kiev", "Pushkinskaya Street", 3, 128);
        final User user = new User(address, "Andrey", "andrey@gmail.com", "andrey_login", 21);
        user.validate();
    }
}