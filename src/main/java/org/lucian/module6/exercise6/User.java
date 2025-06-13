package org.lucian.module6.exercise6;

import java.io.Serializable;

/**
 * User class representing a user with name, email, and age. Implements Serializable for object serialization.
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String name;
    private final String email;
    private final int age;

    public User(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
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

    @Override
    public String toString() {
        return "User{name='" + name + "', email='" + email + "', age=" + age + "}";
    }
}
