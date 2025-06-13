package org.lucian.module7.exercise8;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Thread-safe, lazily-initialized Singleton for application configuration.
 * Uses Initialization-on-demand holder idiom for best practice.
 */
public class AppConfig {
    // Map to hold configuration settings
    private final Map<String, String> settings;

    // Private constructor prevents instantiation from outside
    private AppConfig() {
        // Hardcoded settings for demonstration; could be loaded from file
        Map<String, String> temp = new HashMap<>();
        temp.put("app.name", "OOP Practice");
        temp.put("app.version", "1.0.0");
        temp.put("max.threads", "5");
        settings = Collections.unmodifiableMap(temp);
    }

    // Static inner class holds the Singleton instance
    private static class Holder {
        private static final AppConfig INSTANCE = new AppConfig();
    }

    // Public method to get the Singleton instance
    public static AppConfig getInstance() {
        return Holder.INSTANCE;
    }

    // Method to get a setting by key
    public String getSetting(String key) {
        return settings.get(key);
    }

    // Method to get all settings (read-only)
    public Map<String, String> getAllSettings() {
        return settings;
    }
}
