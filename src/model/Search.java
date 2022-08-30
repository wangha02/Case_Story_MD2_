package model;

public class Search {
    private String name;

    public Search() {
    }
    public Search(String name) {
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
        return "Search{" +
                "name='" + name + '\'' +
                '}';
    }
}
