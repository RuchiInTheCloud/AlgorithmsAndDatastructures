package _11_systemdesignandscalability.example2_1;

import _3_arraysandstrings.datastructures.ArrayList;

public class Person {
    private ArrayList<Integer> friends = new ArrayList<>();
    private int personID;

    public Person(int personID) {
        this.personID = personID;
    }

    public int getPersonID() {
        return personID;
    }

    public void addFriend(int id) {
        friends.add(id);
    }

    public ArrayList<Integer> getFriends() {
        return friends;
    }

    @Override
    public String toString() {
        return personID + "";
    }
}
