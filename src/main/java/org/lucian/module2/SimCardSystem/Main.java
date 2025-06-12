package org.lucian.module2.SimCardSystem;

public class Main {
    public static void main(String[] args) {
        SIM sim = new SIM("0712345678");
        // Optionally add some credit
        sim.addCredit(10.0);

        // Make 6 calls
        Call call1 = new Call(60, "0721111111");
        Call call2 = new Call(120, "0722222222");
        Call call3 = new Call(180, "0723333333");
        Call call4 = new Call(240, "0724444444");
        Call call5 = new Call(300, "0725555555");
        Call call6 = new Call(360, "0726666666");

        sim.addCall(call1);
        sim.addCall(call2);
        sim.addCall(call3);
        sim.addCall(call4);
        sim.addCall(call5);
        sim.addCall(call6); // This will push out the oldest call

        sim.printDetails();
    }
}
