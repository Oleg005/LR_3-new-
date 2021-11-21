package com.laba.task1;

enum AuthorizedStatusCode {
    INVALID_ADDRESS(100, "Invalid address"),
    INVALID_FIRSTNAME(101, "Invalid firstname"),
    INVALID_EMAIL(102, "Invalid email"),
    INVALID_LOGIN(103, "Invalid login"),
    INVALID_AGE(104, "Invalid age");

    private final int code;
    private final String description;

    AuthorizedStatusCode(final int code, final String description) {
        this.code = code;
        this.description = description;
    }

    public final int getCode() { return code; }
    public final String getDescription() { return description; }

    @Override
    public final String toString() {
        return code + " : " + description;
    }
}

public final class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(final AuthorizedStatusCode code) {
        super(code.toString());
    }
}