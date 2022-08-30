package service.withname;

import model.Story;

import java.util.List;

public interface ISearchName {
    List<Story> findAll();
    void updateData();

    List<Story> editSearchName(int id, String name); //3

    List<Story> searchCategory(String name);

    List<Story> findByName(String name);

    List<Story> deleteById(int id); //8

    List<Story> sortByName(); //4

    List<Story> findById(int id); //7

}
