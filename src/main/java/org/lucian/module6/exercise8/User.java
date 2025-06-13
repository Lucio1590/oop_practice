package org.lucian.module6.exercise8;

import java.io.Serializable;

/**
 * User class (version 2) with an added 'phoneNumber' field. Implements Serializable for object serialization.
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String name;
    private final String email;
    private final int age;
    private final String phoneNumber; // New field added in version 2

    public User(String name, String email, int age, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', email='" + email + "', age=" + age + ", phoneNumber='" + phoneNumber + "'}";
    }
}
