package org.lucian.module2.Remotes;

public abstract class RemoteControl {
    protected Device device;
    public RemoteControl(Device device) {
        this.device = device;
    }
    public void powerOn() {
        device.turnOn();
    }
    public void powerOff() {
        device.turnOff();
    }
}
