package service.series;

import model.Story;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SeriesStoryServiceIMPL implements ISeriesStory {

    public static List<Story> listTruyenBo = new ArrayList<>();

    static {
        listTruyenBo.add(new Story("|1.Conan                   - Trinh Thám            |"));
        listTruyenBo.add(new Story("|3.Doremon                 - Hài Hước              |"));
        listTruyenBo.add(new Story("|2.NôBen                   - Danh Nhân Thế Giới    |"));
        listTruyenBo.add(new Story("|4.Tình Ca Mùa Đông        - Tình Cảm              |"));
        listTruyenBo.add(new Story("|──────────────────────────────────────────────────|"));

    }

    @Override
    public List<Story> findAll() {
        return listTruyenBo;
    }

    @Override
    public List<Story> truyenBoStory(String name) {
        List<Story> truyenBo = new ArrayList<>();
        for (Story story : listTruyenBo) {
            if (story.getName().equals(name)) {
                truyenBo.add(story);
            }
        }
        return null;
    }

    @Override
    public List<Story> findByName(String name) {
        return listTruyenBo;
    }

    @Override
    public List<Story> edit(int id, String name) {
        listTruyenBo.get(id - 1).setName(name);
        return listTruyenBo;
    }

    @Override
    public List<Story> sortByName() {
        Collections.sort(listTruyenBo);
        updateData();
        return listTruyenBo;
    }

    @Override
    public List<Story> save(Story story) {
        listTruyenBo.add(story);
        return null;
    }

    @Override
    public void remove(int id) {
        listTruyenBo.remove(id - 1);
    }

    @Override
    public Story findById(int id) {
        listTruyenBo.remove(id - 1);
        updateData();
        return null;
    }


    @Override
    public List<Story> deleteById(int id) {
        for (int i = 0; i < listTruyenBo.size(); i++) {
            listTruyenBo.get(i).setName(listTruyenBo.get(i).getName());
        }
        return listTruyenBo;
    }

    @Override
    public void updateData() {

    }

    @Override
    public int getLastId() {
        return 0;
    }
}
