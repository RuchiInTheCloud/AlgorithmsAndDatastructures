package _9_objectorienteddesign.example3_1;

public class JukeBox {
    private CDPlayer cdPlayer;
    private CDSelector cdSelector;

    public void setCd(String name) {
        CD cd = cdSelector.getCD(name);
        if (cd != null) {
            cdPlayer.setCd(cd);
        }
    }

    public void playSong(String name) {
        cdPlayer.playSong(name);
    }
}
