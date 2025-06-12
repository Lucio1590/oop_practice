package org.lucian.module2.Remotes;

public class Radio2 implements Device {
    private boolean on = false;
    private double frequency = 99.5;

    @Override
    public void turnOn() {
        on = true;
        System.out.println("Radio ON");
    }
    @Override
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
