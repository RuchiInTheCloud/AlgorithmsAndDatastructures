package stacksandqueues.datastructures;

import linkedlists.datastructures.LinkedList;

public class AnimalQueue {
    LinkedList<Dog> dogQueue = new LinkedList<>();
    LinkedList<Cat> catQueue = new LinkedList<>();
    int order = 0;

    public void enqueueAnimal(Animal animal) {
        animal.setOrder(order);
        order++;

        if (animal instanceof Dog)
            dogQueue.addLast((Dog) animal);
        else if (animal instanceof Cat)
            catQueue.addLast((Cat) animal);
    }

    public Animal dequeueAny() {
        if (dogQueue.size() == 0) {
            dequeueCat();
        } else if (catQueue.size() == 0) {
            dequeueDog();
        }

        Cat oldestCat = catQueue.peek().data;
        Dog oldestDog = dogQueue.peek().data;

        if (oldestDog.isOlderThan(oldestCat)) {
            return dogQueue.poll().data;
        } else {
            return catQueue.poll().data;
        }
    }

    public Dog dequeueDog() {
        return dogQueue.poll().data;
    }

    public Cat dequeueCat() {
        return catQueue.poll().data;
    }
}

