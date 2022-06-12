package _9_objectorienteddesign.example3_1;

import java.util.Set;

public class CDSelector {
    private Set<CD> cdCollection;

    public CD getCD(String name) {
        for (CD cd: cdCollection) {
            if (cd.getName().equals(name)) {
                return cd;
            }
        }
        return null;
    }
}
