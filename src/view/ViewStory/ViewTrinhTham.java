package view.ViewStory;

import config.Config;
import controller.StoryControllerTrinhTham;
import model.Story;

import java.util.List;

public class ViewTrinhTham {
    StoryControllerTrinhTham storyController = new StoryControllerTrinhTham();
    List<Story> storyList = storyController.showCategoryLists2();
    public void formSearchStory2() {
        System.out.println("╔═════════════════════════╗");
        System.out.println("║   Enter Name Category   ║");
        System.out.println("╚═════════════════════════╝");
        String name1 = Config.scanner().nextLine();
        for (int i = 0; i < storyList.size(); i++) {
            System.out.println(storyList.get(i).getName());
        }
    }
}
