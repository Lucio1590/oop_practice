package org.lucian.module2.Remotes;

public class RadioAdvancedRemote extends RadioBasicRemote {
    private Radio radio;
    public RadioAdvancedRemote(Radio radio) {
        super(radio);
        this.radio = radio;
    }
    public void setFrequency(double freq) {
        radio.setFrequency(freq);
    }
}
