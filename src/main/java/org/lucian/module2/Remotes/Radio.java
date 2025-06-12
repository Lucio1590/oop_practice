package org.lucian.module2.Remotes;

public class Radio {
    private boolean on = false;
    private double frequency = 99.5;

    public void turnOn() {
        on = true;
        System.out.println("Radio ON");
    }
    public void turnOff() {
        on = false;
        System.out.println("Radio OFF");
    }
    public void setFrequency(double freq) {
        if (on) {
            frequency = freq;
            System.out.println("Radio frequency set to " + frequency);
        }
    }
}
