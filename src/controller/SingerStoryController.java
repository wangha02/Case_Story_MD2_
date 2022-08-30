package controller;

import model.Story;
import service.singer.ISinglerService;
import service.singer.SinglerServiceIMPL;

import java.util.List;

public class SingerStoryController {
    private final ISinglerService iSinglerService = new SinglerServiceIMPL();
    public List<Story> showListStory() {
        return iSinglerService.findAll();
    }

    public Story findById(int id) {
        return iSinglerService.findById(id);
    }
}
