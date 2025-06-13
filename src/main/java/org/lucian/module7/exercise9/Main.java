package org.lucian.module7.exercise9;

public class Main {
    public static void main(String[] args) {
        // Create a chatroom
        ChatRoom chatRoom = new ChatRoom();

        // Create users
        User userA = new User("UserA");
        User userB = new User("UserB");
        User userC = new User("UserC");

        // Subscribe users
        chatRoom.subscribe(userA);
        chatRoom.subscribe(userB);
        chatRoom.subscribe(userC);

        // Post a welcome message
        chatRoom.postMessage("Welcome to the chat!");

        // Unsubscribe UserB
        chatRoom.unsubscribe(userB);

        // Post another message
        chatRoom.postMessage("UserB has left.");
    }
}
