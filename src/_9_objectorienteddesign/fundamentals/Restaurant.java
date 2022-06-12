package _9_objectorienteddesign.fundamentals;

public class Restaurant {
    private static Restaurant instance = null;

    private Restaurant() { }

    public static Restaurant getInstance() {
        if (instance == null) {
            instance = new Restaurant();
        }
        return instance;
    }
}
