package _14_java;

//Difference between final, finally and finalize

//Final control whether variable, method or class is changeable
//- variable primitive: value cannot change
//- variable reference: reference cannot point to any other object on the heap
//- method: method cannot be overridden
//- class: class cannot be subclassed
//
//Finally used in a try catch block to ensure that a segment of code is always executed
public class Example3_1 {
    public static String lem() {
        System.out.println("lem");
        return "return from lem";
    }
    public static String foo() {
        int x = 0;
        int y = 5;
        try {
            System.out.println("start try");
            int b = y / x;
            System.out.println("end try");
            return "returned from try";
        } catch (Exception ex) {
            return lem() + " | returned from catch";
        } finally {
            System.out.println("finally");
        }
    }
    public static void bar() {
        System.out.println("start bar");
        String v = foo();
        System.out.println(v);
        System.out.println("end bar");
    }

    public static void main(String[] args) {
        bar();
    }
}
//finalize() method is called by the garbage collector just before it destroys the object. Override to define custom garbage
// collection behavior
//protected void finalize() throws Throwable {}