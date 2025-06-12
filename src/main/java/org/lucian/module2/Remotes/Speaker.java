package org.lucian.module2.Remotes;

public class Speaker implements Device {
    private boolean on = false;
    private int volume = 5;

    @Override
    public void turnOn() {
        on = true;
        System.out.println("Speaker ON");
    }
    @Override
    public void turnOff() {
        on = false;
        System.out.println("Speaker OFF");
    }
    public void setVolume(int level) {
        if (on) {
            volume = level;
            System.out.println("Speaker volume set to " + volume);
        }
    }
}
