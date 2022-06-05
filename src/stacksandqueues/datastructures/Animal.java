package stacksandqueues.datastructures;

public abstract class Animal {
    protected String name;
    private int order;

    Animal(String name) {
        this.name = name;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isOlderThan(Animal animal) {
        return this.order < animal.order;
    }

    @Override
    public String toString() {
        return name;
    }
}
