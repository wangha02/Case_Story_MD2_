package controller;

import model.Story;
import service.dangian.ICategoryService;
import service.dangian.CategoryServiceIMPL;


import java.util.List;

public class StoryControllerDanGian {
    ICategoryService storyService = new CategoryServiceIMPL();
    public List<Story> showCategoryList(){
        return storyService.findAll();
    }

}
