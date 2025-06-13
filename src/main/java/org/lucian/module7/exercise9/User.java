package org.lucian.module7.exercise9;

// Concrete User class implementing the Observer interface
public class User implements UserObserver {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void receive(String message) {
        // Print the received message with the user's name
        System.out.println(name + " received: " + message);
    }

    public String getName() {
        return name;
    }

    // Override equals and hashCode for correct removal from lists
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
