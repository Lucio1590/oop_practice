package org.lucian.module2.Remotes;

public class TVBasicRemote {
    private TV tv;
    public TVBasicRemote(TV tv) {
        this.tv = tv;
    }
    public void turnOn() {
        tv.turnOn();
    }
    public void turnOff() {
        tv.turnOff();
    }
}
