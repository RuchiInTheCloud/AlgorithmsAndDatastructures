package _9_objectorienteddesign.example7_1;

import _3_arraysandstrings.datastructures.ArrayList;

public abstract class Conversation {
    protected ArrayList<User> participants = new ArrayList<User>();
    protected int id;
    protected ArrayList<Message> messages = new ArrayList<Message>();

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public boolean addMessage(Message message) {
        messages.add(message);
        return true;
    }

    public int getId() {
        return id;
    }
}