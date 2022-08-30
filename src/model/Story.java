package model;

import java.io.Serializable;

public class Story implements Comparable<Story>, Serializable {

    private int id;
    private String name;

    public Story() {
    }
    public Story(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Story(String name, int i) {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Story(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Story{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    @Override
    public int compareTo(Story o) {
        if (!this.name.equals(o.name)) {
            return this.name.compareTo(o.name);
        }
        return compareTo(o);
    }
}
