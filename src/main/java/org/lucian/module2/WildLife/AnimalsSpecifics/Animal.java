package org.lucian.module2.WildLife.AnimalsSpecifics;

public abstract class Animal {

    private String name;
    private int age;

    public Animal() {
        this.name = "Unknown";
        this.age = 0;
    }
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public void eat() {
        System.out.println("The animal is eating.");
    }
    
    public void sleep() {
        System.out.println("The animal is sleeping.");
    }

    public void makeSound() {
        System.out.println("Hi there, I am an animal!");
    }
}
