package _14_java;

import _14_java.fundamentals.Rectangle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//Reflection can be used to get information about classes and objects such as
//methods and fields present at runtime
//creating a new instance at runtime
//Getting and setting object fields directly by getting the field reference, regardless of what the access modifier is
//Observe and manipulate runtime behavior (debug)
//Call methods
public class Example6_1 {
    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException,
            IllegalAccessException {
        Object[] doubleArgs = new Object[]{4.2, 3.9};
        Class rectangleDefinition = Class.forName("_14_java.fundamentals.Rectangle");
        Class[] doubleArgsClass = new Class[]{Double.class, Double.class};
        Constructor doubleArgsConstructor = rectangleDefinition.getConstructor(doubleArgsClass);
        Rectangle rectangle = (Rectangle) doubleArgsConstructor.newInstance(doubleArgs);
        Method method = rectangleDefinition.getDeclaredMethod("area");
        Double area = (Double) method.invoke(rectangle);
        System.out.println(area);
    }
}
