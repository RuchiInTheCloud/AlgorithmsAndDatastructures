package _9_objectorienteddesign.example7_1;

import java.util.Date;

public class Message {
    private String content;
    private Date date;
    public Message(String content, Date date) {
        this.content = content;
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public Date getDate() {
        return date;
    }
}
