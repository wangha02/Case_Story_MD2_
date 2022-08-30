package view.ViewStory;

import config.Config;
import controller.SingerStoryController;
import model.Story;
import view.ViewAll.ViewHome;

import java.util.List;

public class ViewSinger {
    SingerStoryController singerStoryController = new SingerStoryController();
    List<Story> singerlist = singerStoryController.showListStory();
    public void SingerStory() {
        System.out.println("0. Exit ");

        for (int i = 0; i < singerlist.size(); i++) {
            System.out.println("=>" + singerlist.get(i).getName());
        }
        int choice = Integer.parseInt(Config.scanner().nextLine());
        switch (choice) {
            case 0:
                new ViewHome().bigMenu();
                break;
            case 1:
                new ViewHome().formSingleStory();
                break;
            default:
        }
    }
}
