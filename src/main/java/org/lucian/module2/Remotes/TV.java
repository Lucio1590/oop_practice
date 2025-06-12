package org.lucian.module2.Remotes;

public class TV {
    private boolean on = false;
    private int volume = 10;

    public void turnOn() {
        on = true;
        System.out.println("TV ON");
    }
    public void turnOff() {
        on = false;
        System.out.println("TV OFF");
    }
    public void setVolume(int level) {
        if (on) {
            volume = level;
            System.out.println("TV volume set to " + volume);
        }
    }
}
