package _9_objectorienteddesign.example11_1;

import java.time.Instant;
import java.util.Date;

public abstract class Entry {
    protected String name;
    protected Date createdAt;
    protected Date modifiedAt;
    protected Date accessedAt;

    protected Directory parent;

    protected Entry(String name, Directory parent) {
        this.name = name;
        this.createdAt = Date.from(Instant.now());
        this.modifiedAt = Date.from(Instant.now());
        this.accessedAt = Date.from(Instant.now());
        this.parent = parent;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public void deleteEntry() {
        if (parent != null) {
            parent.removeEntry(this);
        }
    }

    public abstract int size();

    public String getFullPath() {
        if (parent == null) {
            return name;
        } else {
            return parent.getFullPath() + "/" + name;
        }
    }

    public String getName() {
        return name;
    }

    public Date getCreationTime() {
        return createdAt;
    }

    public Date getLastUpdatedTime() {
        return modifiedAt;
    }

    public Date getLastAccessedTime() {
        return accessedAt;
    }
}
