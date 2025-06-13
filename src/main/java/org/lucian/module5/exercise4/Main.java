package org.lucian.module5.exercise4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

// Simple Player class
class Player {
    private final String name;
    public Player(String name) { this.name = name; }
    public String getName() { return name; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }
    @Override
    public int hashCode() { return Objects.hash(name); }
    @Override
    public String toString() { return name; }
}

// Data for a single player
class PlayerData {
    private final Set<String> achievements = new HashSet<>();
    private Map<String, Integer> stats = new HashMap<>();

    public void updateStat(String stat, int amount) {
        stats.put(stat, stats.getOrDefault(stat, 0) + amount);
    }
    public int getStat(String stat) {
        return stats.getOrDefault(stat, 0);
    }
    public boolean hasAchievement(String achievement) {
        return achievements.contains(achievement);
    }
    public void unlockAchievement(String achievement) {
        achievements.add(achievement);
    }
    public Set<String> getAchievements() {
        return achievements;
    }
    public Map<String, Integer> getStats() {
        return stats;
    }

    public void setStats(Map<String, Integer> stats) {
        this.stats = stats;
    }
}

// Achievement tracker for multiple players
class AchievementTracker {
    private final Map<Player, PlayerData> playerDataMap = new HashMap<>();

    public PlayerData getPlayerData(Player player) {
        return playerDataMap.computeIfAbsent(player, _ -> new PlayerData());
    }

    public void updateStat(Player player, String stat, int amount) {
        PlayerData data = getPlayerData(player);
        data.updateStat(stat, amount);
        checkAchievements(player, data);
    }

    private void checkAchievements(Player player, PlayerData data) {
        // Example: unlock "Monster Slayer" for 10 monsters defeated
        if (data.getStat("monsters defeated") >= 10 && !data.hasAchievement("Monster Slayer")) {
            data.unlockAchievement("Monster Slayer");
            System.out.println(player + " unlocked achievement: Monster Slayer!");
        }
        // Example: unlock "Quest Master" for 5 quests completed
        if (data.getStat("quests completed") >= 5 && !data.hasAchievement("Quest Master")) {
            data.unlockAchievement("Quest Master");
            System.out.println(player + " unlocked achievement: Quest Master!");
        }
    }

    public void printPlayerSummary(Player player) {
        PlayerData data = getPlayerData(player);
        System.out.println("Stats for " + player + ": " + data.getStats());
        System.out.println("Achievements: " + data.getAchievements());
    }
}

public class Main {
    public static void main(String[] args) {
        AchievementTracker tracker = new AchievementTracker();
        Player alice = new Player("Alice");
        Player bob = new Player("Bob");

        // Update stats for Alice
        tracker.updateStat(alice, "monsters defeated", 3);
        tracker.updateStat(alice, "quests completed", 2);
        tracker.updateStat(alice, "monsters defeated", 7); // Should unlock Monster Slayer
        tracker.updateStat(alice, "quests completed", 3);  // Should unlock Quest Master
        tracker.printPlayerSummary(alice);

        // Update stats for Bob
        tracker.updateStat(bob, "monsters defeated", 10); // Should unlock Monster Slayer
        tracker.updateStat(bob, "quests completed", 1);
        tracker.printPlayerSummary(bob);
    }
}
