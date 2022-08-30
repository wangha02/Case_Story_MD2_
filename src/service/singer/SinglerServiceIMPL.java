package service.singer;

import model.Story;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SinglerServiceIMPL implements ISinglerService {

    public static List<Story> listSinger = new ArrayList<>();

    static {
        listSinger.add(new Story("Ai đáng khen nhiều hơn"));
        listSinger.add(new Story("Chú ếch huênh hoang"));
        listSinger.add(new Story("Chim khách và quạ"));
        listSinger.add(new Story("Một trí khôn hơn trăm trí khôn"));

    }


    @Override
    public List<Story> findAll() {
        return listSinger;
    }

    @Override
    public List<Story> singerStory(String name) {
        List<Story> stories = new ArrayList<>();
        for (Story story : listSinger){
            if(story.getName().equals(name)){
                stories.add(story);
            }
        }
        return null;
    }

    @Override
    public List<Story> findByName(String name) {
        return null;
    }

    @Override
    public List<Story> edit(int id, String name) {
        listSinger.get(id-1).setName(name);
        return listSinger;
    }

    @Override
    public List<Story> sortByName() {
        Collections.sort(listSinger);
        updateData();
        return listSinger;
    }

    @Override
    public List<Story> save(Story story) {
        listSinger.add(story);
        return null;
    }

    @Override
    public void remove(int id) {
        listSinger.remove(id-1);
    }

    @Override
    public Story findById(int id) {
        List<Story> arrayList = new ArrayList<>();
        for(int i=0; i<arrayList.size(); i++){
            arrayList.add(listSinger.get(id-1));
            break;
        }
        return null;
    }

    @Override
    public List<Story> deleteById(int id) {
        listSinger.remove(id-1);
        updateData();
        return listSinger;
    }

    @Override
    public void updateData() {
        for (int i=0; i<listSinger.size(); i++){
         listSinger.get(i).setName(listSinger.get(i).getName());
        }
    }

    @Override
    public int getLastId() {
        return 0;
    }
}
