package service.dangian;

import model.Story;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceIMPL implements ICategoryService {

    public static List<Story> listStory = new ArrayList<>();

    static {
        listStory.add(new Story("Dân Gian"));
        listStory.add(new Story("|1. Cây Tre Trăm Đốt       |"));
        listStory.add(new Story("|2. Sọ Dừa                 |"));
        listStory.add(new Story("|3. Trạng Quỳnh            |"));
        listStory.add(new Story("|4. Cây Bút Thần           |"));
        listStory.add(new Story("========================================"));
    }




    @Override
    public List<Story> findAll() {
        return listStory;
    }

    @Override
    public void updateData() {

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
    public List<Story> searchCategory(String name) {
        List<Story> storyList = new ArrayList<>();
        for (Story story : listStory) {
            if (story.getName().equals(name)) {
                storyList.add(story);
            }
        }
        return null;
    }
}
