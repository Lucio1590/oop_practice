package org.lucian.module5.exercise2;

// Generic Box class
class Box<T> {
    private T content;

    public void setContent(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }
}

// Custom Player class
class Player {
    private final String name;
    private final int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Player{name='" + name + "', score=" + score + "}";
    }
}

public class Main {
    public static void main(String[] args) {
        // Test with Integer
        Box<Integer> intBox = new Box<>();
        intBox.setContent(42);
        System.out.println("Integer box contains: " + intBox.getContent());

        // Test with String
        Box<String> strBox;
        strBox = new Box<>();
        strBox.setContent("Hello Generics");
        System.out.println("String box contains: " + strBox.getContent());

        // Test with custom Player class
        Box<Player> playerBox = new Box<>();
        playerBox.setContent(new Player("Alice", 100));
        System.out.println("Player box contains: " + playerBox.getContent());
    }
}
