package controller;

import model.Story;
import service.trinhtham.CategoryServiceIMPL1;
import service.trinhtham.ICategoryService1;

import java.util.List;

public class StoryControllerTrinhTham {
    ICategoryService1 storyService1 = new CategoryServiceIMPL1();
    public List<Story> showCategoryLists2(){
        return storyService1.findAll();
    }
}
