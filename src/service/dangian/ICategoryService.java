package service.dangian;

import model.Story;
import service.IGenericService;

import java.util.List;

public interface ICategoryService extends IGenericService<Story> {
    List<Story> findAll();
    void updateData();

    List<Story> searchCategory(String name);
}
