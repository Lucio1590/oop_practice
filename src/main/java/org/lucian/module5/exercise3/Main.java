package org.lucian.module5.exercise3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Simple Player class
class Player {
    private final String name;
    public Player(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return name;
    }
}

// GameLobby system
class GameLobby {
    private final List<Player> roomPlayers = new ArrayList<>();
    private final Queue<Player> matchmakingQueue = new LinkedList<>();
    private static final int ROOM_SIZE = 3;

    // Add player to matchmaking queue
    public void joinQueue(Player player) {
        matchmakingQueue.offer(player);
        System.out.println(player + " joined the matchmaking queue.");
    }

    // Remove player from room
    public void leaveRoom(Player player) {
        if (roomPlayers.remove(player)) {
            System.out.println(player + " left the game room.");
        } else {
            System.out.println(player + " is not in the game room.");
        }
    }

    // Process queue and fill the room
    public void processQueue() {
        while (roomPlayers.size() < ROOM_SIZE && !matchmakingQueue.isEmpty()) {
            Player p = matchmakingQueue.poll();
            roomPlayers.add(p);
            System.out.println(p + " moved from queue to game room.");
        }
    }

    // Show current room players
    public void showRoom() {
        System.out.println("Current game room: " + roomPlayers);
    }

    // Show current queue
    public void showQueue() {
        System.out.println("Current matchmaking queue: " + matchmakingQueue);
    }
}

public class Main {
    public static void main(String[] args) {
        GameLobby lobby = new GameLobby();
        Player alice = new Player("Alice");
        Player bob = new Player("Bob");
        Player charlie = new Player("Charlie");
        Player diana = new Player("Diana");
        Player eve = new Player("Eve");

        // Players join the matchmaking queue
        lobby.joinQueue(alice);
        lobby.joinQueue(bob);
        lobby.joinQueue(charlie);
        lobby.joinQueue(diana);
        lobby.joinQueue(eve);
        lobby.showQueue();

        // Process queue into game room
        lobby.processQueue();
        lobby.showRoom();
        lobby.showQueue();

        // A player leaves the room
        lobby.leaveRoom(bob);
        lobby.showRoom();

        // Process queue again (should fill the room)
        lobby.processQueue();
        lobby.showRoom();
        lobby.showQueue();
    }
}
