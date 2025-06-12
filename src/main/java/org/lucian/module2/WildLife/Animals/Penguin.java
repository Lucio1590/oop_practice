package org.lucian.module2.WildLife.Animals;

import org.lucian.module2.WildLife.AnimalsSpecifics.Acquatic;
import org.lucian.module2.WildLife.AnimalsSpecifics.Aerial;
import org.lucian.module2.WildLife.AnimalsSpecifics.Animal;

public class Penguin extends Animal implements Aerial, Acquatic {

    public Penguin(String name, int age) {
        super(name, age);
    }
    @Override
    public void swim() {
        System.out.println("The penguin is swimming.");
    }

    @Override
    public void dive() {
        System.out.println("The penguin is diving.");
    }

    @Override
    public void fly() {
        System.out.println("The penguin cannot fly, but it can glide short distances.");
    }
    
}
