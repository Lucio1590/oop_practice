package org.lucian.module2.Remotes;

public class Main {
    public static void main(String[] args) {
        TV tv = new TV();
        TVBasicRemote tvBasic = new TVBasicRemote(tv);
        TVAdvancedRemote tvAdvanced = new TVAdvancedRemote(tv);

        Radio radio = new Radio();
        RadioBasicRemote radioBasic = new RadioBasicRemote(radio);
        RadioAdvancedRemote radioAdvanced = new RadioAdvancedRemote(radio);

        // TV remotes
        tvBasic.turnOn();
        tvBasic.turnOff();
        tvAdvanced.turnOn();
        tvAdvanced.setVolume(15);
        tvAdvanced.turnOff();

        // Radio remotes
        radioBasic.turnOn();
        radioBasic.turnOff();
        radioAdvanced.turnOn();
        radioAdvanced.setFrequency(101.2);
        radioAdvanced.turnOff();
    }
}
