package _3_arraysandstrings.datastructures;

public class StringBuilder {
    ArrayList<Character> charachterBuffer;

    public StringBuilder() {
        charachterBuffer = new ArrayList<>();
    }

    public void append(String anotherString) {
        if (anotherString == null) {
            throw new IllegalArgumentException();
        }
        char[] stringCharachters = anotherString.toCharArray();
        for (Character stringCharachter : stringCharachters) {
            charachterBuffer.add(stringCharachter);
        }
    }

    @Override
    public String toString() {
        char[] charachters = new char[charachterBuffer.size()];
        for (int i = 0; i < charachterBuffer.size(); i++) {
            charachters[i] = charachterBuffer.get(i);
        }
        return new String(charachters);
    }
}
