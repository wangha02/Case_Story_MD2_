package view.ViewStory;

import config.Config;
import controller.StoryControllerNguNgon;
import model.Story;

import java.util.List;

public class ViewNguNgon {

    StoryControllerNguNgon storyController = new StoryControllerNguNgon();

    List<Story> storyList = storyController.showCategoryList();

    public void formSearchStory3(){
        System.out.println("╔═════════════════════════╗");
        System.out.println("║   Enter Name Category   ║");
        System.out.println("╚═════════════════════════╝");
        String name2 = Config.scanner().nextLine();
        for (int i = 0; i < storyList.size(); i++){
            System.out.println(storyList.get(i).getName());
        }

    }

}
