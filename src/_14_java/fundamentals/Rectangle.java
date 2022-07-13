package _14_java.fundamentals;

public class Rectangle {
    Double length;
    Double width;

    public Rectangle(Double length, Double width) {
        this.length = length;
        this.width = width;
    }

    public Double area() {
        return length * width;
    }
}