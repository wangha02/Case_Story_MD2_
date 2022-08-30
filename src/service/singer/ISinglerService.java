package service.singer;

import model.Story;
import service.IGenericService;

import java.util.List;

public interface ISinglerService extends IGenericService<Story> {
    List<Story> findAll();

    List<Story> singerStory(String name);

    List<Story> findByName(String name);


    List<Story> edit(int id, String name); //3

    List<Story> sortByName(); //4


    void remove(int id);   //6

    Story findById(int id); //7

    List<Story> deleteById(int id); //8

    void updateData();


}
