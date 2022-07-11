package _14_java.fundamentals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class Collections {
    public static void main(String[] args) {
        ArrayList<String> myArr = new ArrayList<>(); //dynamically resizing array that grows as you insert elements
        myArr.add("one");
        System.out.println(myArr.get(0));

        Vector<String> myVect = new Vector<>(); //similar to arraylist but synchronized
        myVect.add("one");
        System.out.println(myVect.get(0));

        LinkedList<String> myLinkedList = new LinkedList<>(); //similar to arraylist but synchronized
        myLinkedList.add("two");
        myLinkedList.addFirst("one");
        Iterator<String> iterator = myLinkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        HashMap<String, String> map = new HashMap<>();
        map.put("one", "uno");
        map.put("two", "dos");
        System.out.println(map.get("one"));
    }
}
