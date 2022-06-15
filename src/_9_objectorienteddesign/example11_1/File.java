package _9_objectorienteddesign.example11_1;

public class File extends Entry {
    private String content;

    protected File(String name, Directory parent) {
        super(name, parent);
    }

    @Override
    public int size() {
        return content.length();
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
