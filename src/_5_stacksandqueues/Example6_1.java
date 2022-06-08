package _5_stacksandqueues;

import _5_stacksandqueues.datastructures.Animal;
import _5_stacksandqueues.datastructures.AnimalQueue;
import _5_stacksandqueues.datastructures.Cat;
import _5_stacksandqueues.datastructures.Dog;

public class Example6_1 {
    public static void main(String[] args) {
        Dog dog = new Dog("Boomer");
        Cat cat = new Cat("Leopard");

        AnimalQueue animalQueue = new AnimalQueue();
        animalQueue.enqueueAnimal(dog);
        animalQueue.enqueueAnimal(cat);

        Animal animal = animalQueue.dequeueAny();

        System.out.println("Oldest animal: " + animal);
    }
}
