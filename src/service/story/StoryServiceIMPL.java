package service.story;

import model.Story;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StoryServiceIMPL implements IStoryService {

    public static List<Story> storyArrayList = new ArrayList<>();

    static {

        storyArrayList.add(new Story(1,"Sọ Dừa"));
        storyArrayList.add(new Story(2,"Trạng Quỳnh"));
        storyArrayList.add(new Story(3,"Cây Bút Thần"));
        storyArrayList.add(new Story(4,"Tình Yêu Giam Cầm"));
        storyArrayList.add(new Story(5,"11 Âm Bình"));
        storyArrayList.add(new Story(6,"Thang Máy Nghi Vấn"));
        storyArrayList.add(new Story(7,"Người Du Hành Giấc Mơ"));
        storyArrayList.add(new Story(8,"Ai đáng khen nhiều hơn?"));
        storyArrayList.add(new Story(9,"Chú ếch huênh hoan"));
        storyArrayList.add(new Story(10,"Chimmmmm khách và quạ"));
        storyArrayList.add(new Story(11,"Một trí khôn hơn trăm trí khôn"));
    }
//admin

    @Override
    public List<Story> findAll() {
        return storyArrayList;
    }

    @Override
    public List<Story> save(Story story) {
        storyArrayList.add(story);
        return storyArrayList;
    }

    @Override
    public List<Story> edit(int id, String name) {
        storyArrayList.get(id-1).setName(name);
        return storyArrayList;
    }

    @Override
    public List<Story> sortByName() {
        Collections.sort(storyArrayList);
        return storyArrayList;
    }

    @Override
    public List<Story> search(String name) {
        List<Story> result = new ArrayList<>();
        for (Story story : storyArrayList) {
            if (story.getName().equals(name)) {
                result.add(story);
            }
        }
        return storyArrayList;
    }

    @Override
    public List<Story> remove(int id) {
        storyArrayList.remove(id-1);
        return storyArrayList;
    }

    @Override
    public List<Story> findById(int id) {
        List<Story> arrayList1 = new ArrayList<>();
        for (int i = 0; i < storyArrayList.size(); i++) {
            arrayList1.add(storyArrayList.get(id - 1));
            break;
        }
        return arrayList1;
    }

    @Override
    public List<Story> deleteById(int id) {
        storyArrayList.remove(id-1);
        updateData();
        return storyArrayList;
    }

    @Override
    public void updateData() {
        for (int i = 0; i < storyArrayList.size(); i++) {
            storyArrayList.get(i).setId(i + 1);
        }
    }
}
