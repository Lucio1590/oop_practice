package org.lucian.module2.Remotes;

public class RadioBasicRemote {
    private Radio radio;
    public RadioBasicRemote(Radio radio) {
        this.radio = radio;
    }
    public void turnOn() {
        radio.turnOn();
    }
    public void turnOff() {
        radio.turnOff();
    }
}
