package org.lucian.module2.WildLife.Animals;

import org.lucian.module2.WildLife.AnimalsSpecifics.Aerial;
import org.lucian.module2.WildLife.AnimalsSpecifics.Animal;

public class Eagle extends Animal implements Aerial {

    public Eagle(String name, int age) {
        super(name, age);
    }

    @Override
    public void fly() {
        System.out.println(getName() + " is flying high in the sky.");
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is hunting for prey.");
    }

    @Override
    public void sleep() {
        System.out.println(getName() + " is resting in its nest.");
    }
    
}
