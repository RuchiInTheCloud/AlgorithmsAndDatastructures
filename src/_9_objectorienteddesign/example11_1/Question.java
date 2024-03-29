package _9_objectorienteddesign.example11_1;

public class Question {
    public static void main(String[] args) {
        Directory root = new Directory("Food", null);
        File taco = new File("Taco", root);
        File hamburger = new File("Hamburger", root);
        root.addEntry(taco);
        root.addEntry(hamburger);

        Directory healthy = new Directory("Healthy", root);

        Directory fruits = new Directory("Fruits", healthy);
        File apple = new File("Apple", fruits);
        File banana = new File("Banana", fruits);
        fruits.addEntry(apple);
        fruits.addEntry(banana);

        healthy.addEntry(fruits);

        Directory veggies = new Directory("Veggies", healthy);
        File carrot = new File("Carrot", veggies);
        File lettuce = new File("Lettuce", veggies);
        File peas = new File("Peas", veggies);
        veggies.addEntry(carrot);
        veggies.addEntry(lettuce);
        veggies.addEntry(peas);

        healthy.addEntry(veggies);

        root.addEntry(healthy);

        System.out.println(root.numberOfFiles());
        System.out.println(veggies.getFullPath());
    }
}
