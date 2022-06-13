package _9_objectorienteddesign.example5_1;

import _3_arraysandstrings.datastructures.HashTable;

public class UserManager {
    private HashTable<Integer, User> users;

    public void addUser(int id, String details, int accountType) {
        if (!users.containsKey(id)) {
            User user = new User(id, details, accountType);
            users.put(id, user);
        }
    }

    public boolean remove(User user) {
        return remove(user.getId());
    }

    public boolean remove(int id) {
        if (!users.containsKey(id)) {
            return false;
        }
        users.remove(id);
        return true;
    }

    public User find(int id) {
        return users.get(id);
    }
}
