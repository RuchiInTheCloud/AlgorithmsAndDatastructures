package stacksandqueues;

import stacksandqueues.datastructures.Animal;
import stacksandqueues.datastructures.AnimalQueue;
import stacksandqueues.datastructures.Cat;
import stacksandqueues.datastructures.Dog;

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
