package service.trinhtham;

import model.Story;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceIMPL1 implements ICategoryService1{
    public static List<Story> listStory = new ArrayList<>();

    static {
        listStory.add(new Story("Trinh Thám"));
        listStory.add(new Story("|1. Tình Yêu Giam Cầm         |"));
        listStory.add(new Story("|2. 11 Âm Bình                |"));
        listStory.add(new Story("|3. Thang Máy Nghi Vấn        |"));
        listStory.add(new Story("|4. Người Du Hành Giấc Mơ     |"));
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
    public List<Story> searchCategory(String name) {
        List<Story> str = new ArrayList<>();
        for (Story story : listStory){
            if (story.getName().equals(name)) {
                str.add(story);
            }
        }
        return null;
    }
}
