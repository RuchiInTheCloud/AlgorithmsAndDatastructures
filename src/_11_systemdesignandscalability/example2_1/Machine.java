package _11_systemdesignandscalability.example2_1;

import _3_arraysandstrings.datastructures.HashTable;

public class Machine {
    public HashTable<Integer, Person> persons = new HashTable<>();
    public int machineID;

    public Person getPersonWithID(int personID) {
        return persons.get(personID);
    }
}
