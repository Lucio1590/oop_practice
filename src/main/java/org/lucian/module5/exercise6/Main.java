package org.lucian.module5.exercise6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Character class with Comparable
class Character implements Comparable<Character> {
    private final String name;
    private final int level;
    private final int xp;

    public Character(String name, int level, int xp) {
        this.name = name;
        this.level = level;
        this.xp = xp;
    }
    public String getName() { return name; }
    public int getLevel() { return level; }
    public int getXp() { return xp; }

    // Natural ordering: by level ascending
    @Override
    public int compareTo(Character other) {
        return Integer.compare(this.level, other.level);
    }

    @Override
    public String toString() {
        return String.format("%s (Level %d, XP %d)", name, level, xp);
    }
}

// Comparator for XP descending
class XpDescendingComparator implements Comparator<Character> {
    @Override
    public int compare(Character a, Character b) {
        return Integer.compare(b.getXp(), a.getXp());
    }
}

// Comparator for name alphabetical
class NameComparator implements Comparator<Character> {
    @Override
    public int compare(Character a, Character b) {
        return a.getName().compareToIgnoreCase(b.getName());
    }
}

public class Main {
    public static void main(String[] args) {
        List<Character> characters = new ArrayList<>();
        characters.add(new Character("Alice", 10, 1500));
        characters.add(new Character("Bob", 7, 2200));
        characters.add(new Character("Charlie", 12, 1200));
        characters.add(new Character("Diana", 10, 1800));

        // Sort by natural order (level)
        Collections.sort(characters);
        System.out.println("Sorted by level (natural order):");
        for (Character c : characters) System.out.println(c);

        // Sort by XP descending
        characters.sort(new XpDescendingComparator());
        System.out.println("\nSorted by XP descending:");
        for (Character c : characters) System.out.println(c);

        // Sort by name alphabetical
        characters.sort(new NameComparator());
        System.out.println("\nSorted by name (alphabetical):");
        for (Character c : characters) System.out.println(c);
    }
}


//OUTPUT:

/*
Sorted by level (natural order):
Bob (Level 7, XP 2200)
Alice (Level 10, XP 1500)
Diana (Level 10, XP 1800)
Charlie (Level 12, XP 1200)

Sorted by XP descending:
Bob (Level 7, XP 2200)
Diana (Level 10, XP 1800)
Alice (Level 10, XP 1500)
Charlie (Level 12, XP 1200)

Sorted by name (alphabetical):
Alice (Level 10, XP 1500)
Bob (Level 7, XP 2200)
Charlie (Level 12, XP 1200)
Diana (Level 10, XP 1800)
*/