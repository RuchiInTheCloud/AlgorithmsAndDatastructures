package _9_objectorienteddesign.example3_1;

import _3_arraysandstrings.datastructures.ArrayList;

public class CD {
    private String name;
    private ArrayList<Song> songs;

    public CD(String name, ArrayList<Song> songs) {
        this.name = name;
        this.songs = songs;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }
}
