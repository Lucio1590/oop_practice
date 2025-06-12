package org.lucian.module2.WildLife.Animals;

import org.lucian.module2.WildLife.AnimalsSpecifics.Animal;
import org.lucian.module2.WildLife.AnimalsSpecifics.Terrestrial;

public class Lion extends Animal implements Terrestrial{

    public Lion(String name, int age) {
        super(name, age);
    }

    @Override
    public void walk() {
        System.out.println("The lion is walking.");
    }

    @Override
    public void run() {
        System.out.println("The lion is running.");
    }

    @Override
    public void jump() {
        System.out.println("The lion is jumping.");
    }

    @Override
    public void climb() {
        System.out.println("The lion is climbing.");
    }
    
}
