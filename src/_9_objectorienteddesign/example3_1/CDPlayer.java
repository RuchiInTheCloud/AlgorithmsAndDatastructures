package _9_objectorienteddesign.example3_1;

import _3_arraysandstrings.datastructures.ArrayList;

public class CDPlayer {
    private CD cd;

    public void setCd(CD cd) {
        this.cd = cd;
    }

    public void playSong(String name) {
        ArrayList<Song> songs = cd.getSongs();
        for (int i = 0; i < songs.size(); i++) {
            Song song = songs.get(i);
            if (song.getName().equals(name)) {
                System.out.println(song);
                return;
            }
        }
        System.out.println("Not found");
    }
}
