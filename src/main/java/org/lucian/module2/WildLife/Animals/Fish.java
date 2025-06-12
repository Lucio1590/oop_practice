package org.lucian.module2.WildLife.Animals;

import org.lucian.module2.WildLife.AnimalsSpecifics.Acquatic;
import org.lucian.module2.WildLife.AnimalsSpecifics.Animal;

public class Fish extends Animal implements Acquatic {

    public Fish(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Blub blub");
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is eating fish food.");
    }

    @Override
    public void sleep() {
        System.out.println(getName() + " is sleeping in the water.");
    }

    @Override
    public void swim() {
        System.out.println(getName() + " is swimming gracefully in the water.");
    }

    @Override
    public void dive() {
        System.out.println(getName() + " is diving deep into the water.");
    }
    
}
