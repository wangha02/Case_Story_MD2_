package view.ViewStory;

import config.Config;
import controller.StoryControllerDanGian;
import model.Story;

import java.util.List;

public class ViewDanGian {
    StoryControllerDanGian storyController = new StoryControllerDanGian();
    List<Story> storyList = storyController.showCategoryList();
    public void formSearchStory() {
        System.out.println("╔═════════════════════════╗");
        System.out.println("║   Enter Name Category   ║");
        System.out.println("╚═════════════════════════╝");
        String name = Config.scanner().nextLine();
        for (int i = 0; i < storyList.size(); i++) {
            System.out.println(storyList.get(i).getName());
        }
    }
}
