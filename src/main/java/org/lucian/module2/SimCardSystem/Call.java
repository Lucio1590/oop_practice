package org.lucian.module2.SimCardSystem;

public class Call {
    private int duration; // in seconds
    private String calledNumber;

    public Call(int duration, String calledNumber) {
        this.duration = duration;
        this.calledNumber = calledNumber;
    }

    public int getDuration() {
        return duration;
    }

    public String getCalledNumber() {
        return calledNumber;
    }

    @Override
    public String toString() {
        return "Call to: " + calledNumber + ", duration: " + duration + "s";
    }
}
