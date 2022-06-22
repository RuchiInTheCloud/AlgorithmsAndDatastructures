package _11_systemdesignandscalability.example2_1;

import _3_arraysandstrings.datastructures.HashTable;

public class Server {
    HashTable<Integer, Machine> machines = new HashTable<>();
    HashTable<Integer, Integer> personToMachineMap = new HashTable<>();

    public Machine getMachineWithId(int machineID) {
        return machines.get(machineID);
    }

    public int getMachineIDForUser(int personID) {
        Integer machineID = personToMachineMap.get(personID);
        return machineID == null ? -1 : machineID;
    }

    public Person getPersonWithID(int personID) {
        Integer machineID = personToMachineMap.get(personID);
        if (machineID == null) {
            return null;
        }
        Machine machine = getMachineWithId(machineID);
        if (machine == null) {
            return null;
        }
        return machine.getPersonWithID(personID);
    }
}
