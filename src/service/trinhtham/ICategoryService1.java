package service.trinhtham;

import model.Story;
import service.IGenericService;

import java.util.List;

public interface ICategoryService1 extends IGenericService<Story> {
    List<Story> findAll();
    void updateData();

    List<Story> searchCategory(String name);

}
