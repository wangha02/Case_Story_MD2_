package controller;

import model.Story;
import service.story.IStoryService;
import service.story.StoryServiceIMPL;

import java.util.List;

public class
StoryController {

    private final IStoryService iStoryService = new StoryServiceIMPL();

    public List<Story> getStory(){
        return iStoryService.findAll();
    }

    public List<Story> showListStory() {
        return iStoryService.findAll();
    }


    public List<Story> findById(int id){
        return iStoryService.findById(id);
    }


    public List<Story> createStory(String name) {
        return iStoryService.save(new Story(showListStory().size()+1, name));
    }


}
