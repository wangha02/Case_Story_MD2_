package view.ViewStory;

import config.Config;
import controller.StoryControllerSearchName;
import model.Story;

import static color.ConsoleColors.RED;
import static color.ConsoleColors.RESET;

public class ViewSearchName {
    StoryControllerSearchName searchNameController = new StoryControllerSearchName();
    public void nameSearchStory(){
        System.out.println("╔════════════════════════════════╗");
        System.out.println("║   Enter Name Search Category   ║");
        System.out.println("╚════════════════════════════════╝");
        String storyName = Config.scanner().nextLine();
        if (searchNameController.findByName(storyName)==null){
            System.out.println(RED + "No Story Found" + RESET);
        }else {
            Story story = new Story(storyName);
            System.out.println("|" + story.getName()+ "|");
        }
        nameSearchStory();
    }
}