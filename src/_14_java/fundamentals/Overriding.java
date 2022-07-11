package _14_java.fundamentals;

public class Overriding {
    private static abstract class Shape {
        public void printMe() {
            System.out.println("I am a shape.");
        }

        public abstract double computeArea();
    }

    private static class Circle extends Shape {
        private double radius = 5;

        public void printMe() {
            System.out.println("I am a circle.");
        }

        @Override
        public double computeArea() {
            return 3.15 * radius * radius;
        }
    }

    private static class Ambiguous extends Shape {
        private double area = 10;

        @Override
        public double computeArea() {
            return area;
        }
    }

    public static void main(String[] args) {
        Shape[] shapes = new Shape[2];
        Circle circle = new Circle();
        Ambiguous ambiguous = new Ambiguous();

        shapes[0] = circle;
        shapes[1] = ambiguous;

        for (Shape shape : shapes) {
            shape.printMe();
            System.out.println(shape.computeArea());
        }
    }
}
