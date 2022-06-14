package _9_objectorienteddesign.example7_1;

import _3_arraysandstrings.datastructures.ArrayList;
import _3_arraysandstrings.datastructures.HashTable;

import java.util.Date;

public class User {
    private int id;
    private String accountName;
    private String fullName;

    private UserStatus status = null;

    private HashTable<Integer, User> contacts = new HashTable<>();
    private HashTable<Integer, AddRequest> receivedAddRequests = new HashTable<>();
    private HashTable<Integer, AddRequest> sentAddRequests = new HashTable<>();

    private HashTable<Integer, PrivateChat> privateChats = new HashTable<>();
    private ArrayList<GroupChat> groupChats = new ArrayList<>();

    public User(int id, String accountName, String fullName) {
        this.id = id;
        this.accountName = accountName;
        this.fullName = fullName;
    }

    public void requestAddUser(String accountName) {
        UserManager.getInstance().addUser(this, accountName);
    }

    public void receivedAddRequest(AddRequest req) {
        int senderId = req.getFromUser().getId();
        if (!receivedAddRequests.containsKey(senderId)) {
            receivedAddRequests.put(senderId, req);
        }
    }

    public void sentAddRequest(AddRequest req) {
        int receiverId = req.getFromUser().getId();
        if (!sentAddRequests.containsKey(receiverId)) {
            sentAddRequests.put(receiverId, req);
        }
    }

    public boolean addContact(User user) {
        if (contacts.containsKey(user.getId())) {
            return false;
        } else {
            contacts.put(user.getId(), user);
            return true;
        }
    }

    public void removeAddRequest(AddRequest req) {
        if (req.getToUser() == this) {
            receivedAddRequests.remove(req.getFromUser().getId());
        } else if (req.getFromUser() == this) {
            sentAddRequests.remove(req.getToUser().getId());
        }
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public UserStatus getStatus() {
        return status;
    }

    public boolean sendMessageToUser(User toUser, String content) {
        PrivateChat chat = privateChats.get(toUser.getId());
        if (chat == null) {
            chat = new PrivateChat(this, toUser);
            privateChats.put(toUser.getId(), chat);
        }
        Message message = new Message(content, new Date());
        return chat.addMessage(message);
    }

    public boolean sendMessageToGroupChat(int groupId, String content) {
        GroupChat chat = groupChats.get(groupId);
        if (chat != null) {
            Message message = new Message(content, new Date());
            return chat.addMessage(message);
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getFullName() {
        return fullName;
    }
}
