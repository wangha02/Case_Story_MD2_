package service.ngungon;

import model.Story;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceIMPL3 implements ICategoryService3{

    public static List<Story> listStory = new ArrayList<>();

    static {
        listStory.add(new Story("Ngụ Ngôn"));
        listStory.add(new Story("|1. Ai đáng khen nhiều hơn?            |"));
        listStory.add(new Story("|2. Chú ếch huênh hoang                |"));
        listStory.add(new Story("|3. Chim khách và quạ                  |"));
        listStory.add(new Story("|4. Một trí khôn hơn trăm trí khôn     |"));
        listStory.add(new Story("========================================"));

    }

    @Override
    public List<Story> save(Story story) {

        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Story findById(int id) {
        return null;
    }

    @Override
    public int getLastId() {
        return 0;
    }

    @Override
    public List<Story> findAll() {
        return listStory;
    }

    @Override
    public void updateData() {

    }

    @Override
    public List<Story> searchCategory3(String name) {
        List<Story> strs = new ArrayList<>();
        for (Story story : listStory) {
            if (story.getName().equals(name)) {
                strs.add(story);
            }
        }
        return null;
    }
}
