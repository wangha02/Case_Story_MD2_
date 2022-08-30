package controller;

import model.Story;
import service.ngungon.CategoryServiceIMPL3;
import service.ngungon.ICategoryService3;

import java.util.List;

public class StoryControllerNguNgon {

    ICategoryService3 storyService3 = new CategoryServiceIMPL3();
    public List<Story> showCategoryList(){
        return storyService3.findAll();
    }
}
