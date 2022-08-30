package controller;

import model.Story;
import service.series.ISeriesStory;
import service.series.SeriesStoryServiceIMPL;

import java.util.List;

public class SeriesStoryController {

    private final ISeriesStory iSeriesStory = new SeriesStoryServiceIMPL();
    public List<Story> showListSeriesStory() {
        return iSeriesStory.findAll();
    }

    public Story findById(int id) {
        return iSeriesStory.findById(id);
    }
}
