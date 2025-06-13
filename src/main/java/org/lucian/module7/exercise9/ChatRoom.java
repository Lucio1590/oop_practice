package org.lucian.module7.exercise9;

import java.util.ArrayList;
import java.util.List;

// Subject class: manages observers and notifies them
public class ChatRoom {
    private List<UserObserver> observers = new ArrayList<>();
    private List<String> messages = new ArrayList<>();

    // Subscribe a user to the chatroom
    public void subscribe(UserObserver observer) {
        observers.add(observer);
    }

    // Unsubscribe a user from the chatroom
    public void unsubscribe(UserObserver observer) {
        observers.remove(observer);
    }

    // Post a message and notify all observers
    public void postMessage(String message) {
        messages.add(message);
        notifyObservers(message);
    }

    // Notify all subscribed users
    private void notifyObservers(String message) {
        for (UserObserver observer : observers) {
            observer.receive(message);
        }
    }

    // Optional: get all messages
    public List<String> getMessages() {
        return new ArrayList<>(messages);
    }
}
