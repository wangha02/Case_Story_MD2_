package view.ViewStory;

import config.Config;
import controller.SeriesStoryController;
import model.Story;
import view.ViewAll.ViewHome;

import java.util.List;

public class ViewSeriesStory {
    SeriesStoryController seriesStoryController = new SeriesStoryController();
    List<Story> seriesList = seriesStoryController.showListSeriesStory();
    public void SeriesStory() {
        System.out.println("0.Exit");
        for (int i = 0; i < seriesList.size(); i++) {
            System.out.println("=>" + seriesList.get(i).getName());
        }
        int choice = Integer.parseInt(Config.scanner().nextLine());
        switch (choice) {
            case 0:
                new ViewHome().bigMenu();
                break;
            case 1:
                new ViewHome().formSeriesStory();
                break;
            default:
        }
    }
}

