package service.ngungon;

import model.Story;
import service.IGenericService;

import java.util.List;

public interface ICategoryService3 extends IGenericService<Story> {
    List<Story> findAll();
    void updateData();

    List<Story> searchCategory3(String name);
}
