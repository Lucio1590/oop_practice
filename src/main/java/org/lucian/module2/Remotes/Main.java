package org.lucian.module2.Remotes;

public class Main {
    public static void main(String[] args) {
        Device tv = new TV2();
        Device radio = new Radio2();

        BasicRemote tvBasic = new BasicRemote(tv);
        AdvancedRemote tvAdvanced = new AdvancedRemote(tv);
        BasicRemote radioBasic = new BasicRemote(radio);
        AdvancedRemote radioAdvanced = new AdvancedRemote(radio);

        // TV remotes
        tvBasic.powerOn();
        tvBasic.powerOff();
        tvAdvanced.powerOn();
        tvAdvanced.setVolume(20);
        tvAdvanced.powerOff();

        // Radio remotes
        radioBasic.powerOn();
        radioBasic.powerOff();
        radioAdvanced.powerOn();
        radioAdvanced.setFrequency(104.7);
        radioAdvanced.powerOff();
    }
}
