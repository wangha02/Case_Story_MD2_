package controller;

import model.Story;
import service.withname.ISearchName;
import service.withname.SearchNameIMPL;

import java.util.List;

public class StoryControllerSearchName {
    private final ISearchName searchStoryName = new SearchNameIMPL();


ISearchName searchName = new SearchNameIMPL();

    public List<Story> showSearchName(){
        return searchName.findAll();
    }

    public List<Story> editStory(int id,String name){
        return searchName.editSearchName(id,name);
    }
    public List<Story> findByName(String name){
        return searchStoryName.findByName(name);
    }
    public void deleteStory(int id) {
        searchName.deleteById(id);
    }
    public List<Story> findStoriesById(int id) {
        return searchName.findById(id);
    }

}
