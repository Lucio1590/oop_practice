package org.lucian.module7.exercise2;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * DownloadManager coordinates progress updates and redraws the console.
 */
public class DownloadManager {
    private final Map<String, String> progressMap = new LinkedHashMap<>();
    private final int maxShown;

    public DownloadManager(int maxShown) {
        this.maxShown = maxShown;
    }

    public synchronized void updateProgress(String fileName, String progress) {
        progressMap.put(fileName, progress);
        redraw();
    }

    private void redraw() {
        // Clear console (ANSI escape code)
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("--- Download Progress ---");
        progressMap.values().stream()
            .skip(Math.max(0, progressMap.size() - maxShown))
            .forEach(System.out::println);
    }
}
