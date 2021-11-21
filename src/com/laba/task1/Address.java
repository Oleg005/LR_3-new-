package com.laba.task1;

public final class Address {
    private final String city;
    private final String street;
    private final int houseNumber;
    private final int apartmentNumber;

    public Address(final String city, final String street, final int houseNumber, final int apartmentNumber) {
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
    }

    public final boolean isValid() {
        if(city.matches("[0-9]") || "".equals(city.trim())
                || street.matches("[\\p{P}&&[^,-]]+") || "".equals(street.trim())
                || houseNumber <= 0 || apartmentNumber <= 0)
            return false;
        return true;
    }

    public final String getCity() { return city; }
    public final String getStreet() { return street; }
    public final int getHouseNumber() { return houseNumber; }
    public final int getApartmentNumber() { return apartmentNumber; }
}