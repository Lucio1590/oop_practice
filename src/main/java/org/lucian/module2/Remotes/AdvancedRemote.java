package org.lucian.module2.Remotes;

public class AdvancedRemote extends RemoteControl {
    public AdvancedRemote(Device device) {
        super(device);
    }
    public void setVolume(int level) {
        if (device instanceof TV2 tv2) {
            tv2.setVolume(level);
        }
    }
    public void setFrequency(double freq) {
        if (device instanceof Radio2 radio2) {
            radio2.setFrequency(freq);
        }
    }
}
