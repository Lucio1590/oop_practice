package org.lucian.module2.WildLife;

import java.util.List;

import org.lucian.module2.WildLife.Animals.Eagle;
import org.lucian.module2.WildLife.Animals.Fish;
import org.lucian.module2.WildLife.Animals.Lion;
import org.lucian.module2.WildLife.Animals.Penguin;
import org.lucian.module2.WildLife.AnimalsSpecifics.Acquatic;
import org.lucian.module2.WildLife.AnimalsSpecifics.Animal;
import org.lucian.module2.WildLife.AnimalsSpecifics.Terrestrial;

public class WildLifeConservationSystem {
    public static void main(String[] args) {
        
        Lion Jhonny = new Lion("Jhonny", 4);
        Penguin Pingu = new Penguin("Pingu", 2);
        Eagle Jertrude = new Eagle("Jertrude", 3);
        Fish Nemo = new Fish("Nemo", 1);

        List<Animal> animals;

        animals = List.of(Jhonny, Pingu, Jertrude, Nemo);

        for (Animal animal : animals) {
            System.out.println("Name: " + animal.getName() + ", Age: " + animal.getAge());
            animal.eat();
            animal.sleep();

            switch (animal) {
                case Lion lion -> {
                    lion.walk();
                    lion.run();
                    lion.jump();
                    lion.climb();
                }
                case Penguin penguin -> {
                    penguin.swim();
                    penguin.dive();
                }
                case Eagle eagle -> eagle.fly();
                case Fish fish -> fish.swim();
                default -> {
                }
            }
        }

    }

    public void performAction(Acquatic aquaticAnimal) {
        aquaticAnimal.swim();
        aquaticAnimal.dive();
    }
    public void  performAction(Terrestrial terrestrialAnimal) {
        terrestrialAnimal.walk();
        terrestrialAnimal.run();
        terrestrialAnimal.jump();
        terrestrialAnimal.climb();
    }
}
