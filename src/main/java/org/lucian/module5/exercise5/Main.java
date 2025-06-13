package org.lucian.module5.exercise5;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

// Event class with timestamp
class GameEvent {
    private final String description;
    private final Instant timestamp;

    public GameEvent(String description, Instant timestamp) {
        this.description = description;
        this.timestamp = timestamp;
    }
    public String getDescription() { return description; }
    public Instant getTimestamp() { return timestamp; }
    @Override
    public String toString() {
        return "[" + timestamp + "] " + description;
    }
}

// Custom collection for game events
class GameEventLog implements Iterable<GameEvent> {
    private final List<GameEvent> events = new ArrayList<>();

    public void addEvent(String description) {
        events.add(new GameEvent(description, Instant.now()));
    }
    public void addEvent(GameEvent event) {
        events.add(event);
    }
    public List<GameEvent> getAllEvents() {
        return events;
    }

    // Iterator that returns only events from the last 5 minutes
    public class RecentEventIterator implements Iterator<GameEvent> {
        private final Iterator<GameEvent> baseIterator;
        private GameEvent nextRecent;
        private final Instant cutoff;

        public RecentEventIterator() {
            this.baseIterator = events.iterator();
            this.cutoff = Instant.now().minus(Duration.ofMinutes(5));
            advance();
        }
        private void advance() {
            nextRecent = null;
            while (baseIterator.hasNext()) {
                GameEvent e = baseIterator.next();
                if (e.getTimestamp().isAfter(cutoff)) {
                    nextRecent = e;
                    break;
                }
            }
        }
        @Override
        public boolean hasNext() {
            return nextRecent != null;
        }
        @Override
        public GameEvent next() {
            if (nextRecent == null) throw new NoSuchElementException();
            GameEvent result = nextRecent;
            advance();
            return result;
        }
    }

    // Returns the custom iterator
    public RecentEventIterator recentEvents() {
        return new RecentEventIterator();
    }

    // Default iterator returns all events
    @Override
    public Iterator<GameEvent> iterator() {
        return events.iterator();
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GameEventLog log = new GameEventLog();
        Instant now = Instant.now();
        // Add events: some old, some recent
        log.addEvent(new GameEvent("Player joined", now.minus(Duration.ofMinutes(10))));
        log.addEvent(new GameEvent("Monster defeated", now.minus(Duration.ofMinutes(4))));
        log.addEvent(new GameEvent("Treasure found", now.minus(Duration.ofMinutes(2))));
        log.addEvent(new GameEvent("Level up!", now));

        System.out.println("All events:");
        for (GameEvent e : log) {
            System.out.println(e);
        }

        System.out.println("\nRecent events (last 5 minutes):");
        Iterator<GameEvent> it = log.recentEvents();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
