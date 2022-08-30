package service.withname;

import model.Story;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchNameIMPL implements ISearchName {
    public static List<Story> listName = new ArrayList<>();

    static {

        listName.add(new Story(1,  "Sọ Dừa"));
        listName.add(new Story(2,  "11 Âm Bình"));
        listName.add(new Story(3,  "Trạng Quỳnh"));
        listName.add(new Story(4,  "Cây Bút Thần"));
        listName.add(new Story(5,  "Tình Yêu Giam Cầm"));
        listName.add(new Story(6,  "Thang Máy Nghi Vấn"));
        listName.add(new Story(7,  "Chú ếch huênh hoan"));
        listName.add(new Story(8,  "Chimm khách và quạ"));
        listName.add(new Story(9,  "Người Du Hành Giấc Mơ"));
        listName.add(new Story(10, "Ai đáng khen nhiều hơn?"));
        listName.add(new Story(11, "Một trí khôn hơn trăm trí khôn"));
    }

    @Override
    public List<Story> findAll() {
        return listName;
    }

    @Override
    public void updateData() {
    }

    @Override
    public List<Story> editSearchName(int id, String name) {
        listName.get(id - 1).setName(name);
        return listName;
    }

    @Override
    public List<Story> searchCategory(String name) {
        List<Story> s = new ArrayList<>();
        for (Story story : listName) {
            if (story.getName().equals(name)) {
                s.add(story);
            }
        }
        return null;
    }

    @Override
    public List<Story> findByName(String name) {
        List<Story> list = new ArrayList<>();
        for (Story story : listName) {
            if (story.getName().equals(name)) {
                list.add(story);
            }
        }
        return list;
    }

    @Override
    public List<Story> deleteById(int id) {
        listName.remove(id);
        updateData();
        return listName;
    }

    @Override
    public List<Story> sortByName() {
        List<Story> list = new ArrayList<>(listName);
        updateData();
        Collections.sort(list);
        return list;
    }

    @Override
    public List<Story> findById(int id) {
        List<Story> arrayList = new ArrayList<>();
        for (int i = 0; i < listName.size(); i++) {
            arrayList.add(listName.get(id - 1));
            break;
        }
        return arrayList;
    }
}
