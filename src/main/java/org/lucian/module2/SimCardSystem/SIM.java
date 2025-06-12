package org.lucian.module2.SimCardSystem;

public class SIM {
    private String phoneNumber;
    private double credit;
    private Call[] lastCalls;
    private int callCount;

    public SIM(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.credit = 0.0;
        this.lastCalls = new Call[5];
        this.callCount = 0;
    }

    public void addCall(Call call) {
        // Shift calls if already 5
        if (callCount < 5) {
            lastCalls[callCount] = call;
            callCount++;
        } else {
            // Remove oldest, shift left
            for (int i = 0; i < 4; i++) {
                lastCalls[i] = lastCalls[i + 1];
            }
            lastCalls[4] = call;
        }
    }

    public void printDetails() {
        System.out.println("SIM Phone Number: " + phoneNumber);
        System.out.println("Available Credit: " + credit + " €");
        System.out.println("Last Calls:");
        for (int i = 0; i < callCount; i++) {
            System.out.println("  " + lastCalls[i]);
        }
    }

    // Optionally, add credit method
    public void addCredit(double amount) {
        if (amount > 0) {
            credit += amount;
        }
    }
}
