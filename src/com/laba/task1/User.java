package com.laba.task1;

import java.util.regex.Pattern;

public final class User {
    private final Address address;
    private final String firstName;
    private final String email;
    private final String login;
    private final int age;

    public User(final Address address, final String firstName, final String email, final String login, final int age) {
        this.address = address;
        this.firstName = firstName;
        this.email = email;
        this.login = login;
        this.age = age;
    }

    /*
   Правила валідації для поля firstName: не пусте, не містить цифр, не містить пробілів
    Правила валідації для поля email: один чи більше одного символа @ один чи більше одного символа . один чи більше одного символа
    Правила валідації для поля address:
        Правила валідації для поля address.city: не пусте, не містить цифр
        Правила валідації для поля address.street: не пусте, не містить знаків пункутації, крім , і -
        Правила валідації для поля address.houseNumber: не менше чи рівно 0
        Правила валідації для поля address.apartmentNumber: не менше чи рівно 0
    Правила валідації для поля login: не містить знаків пунктуації, крім _
    Правила валідації для поля age: не менше чи рівно 5 і не більше чи рівно 123
    */

    public final void validate() {
        if(isValidFirstName(firstName))
            throw new UnauthorizedException(AuthorizedStatusCode.INVALID_FIRSTNAME);
        if(!isValidEmail(email))
            throw new UnauthorizedException(AuthorizedStatusCode.INVALID_EMAIL);
        if(!address.isValid())
            throw new UnauthorizedException(AuthorizedStatusCode.INVALID_ADDRESS);
        if(login.matches("[\\p{P}&&[^_]]+"))
            throw new UnauthorizedException(AuthorizedStatusCode.INVALID_LOGIN);
        if(age <= 5 || age >= 123)
            throw new UnauthorizedException(AuthorizedStatusCode.INVALID_AGE);
    }

    private final boolean isValidFirstName(final String firstName) {
        return firstName == null || "".equals (firstName.trim ()) ||
                firstName.matches("[0-9]") || firstName.contains(" ");
    }
    private final boolean isValidEmail(final String email) {
        final Pattern pattern = Pattern.compile("^.+@.+\\..+$");
        return pattern.matcher(email).matches();
    }
}