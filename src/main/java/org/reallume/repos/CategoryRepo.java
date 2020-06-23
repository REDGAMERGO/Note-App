package org.reallume.repos;

import org.reallume.domain.Note;
import org.springframework.data.repository.CrudRepository;
import org.reallume.domain.Category;

import java.util.List;

public interface CategoryRepo extends CrudRepository<Category, Long> {

    Category findByName(String name);

    Category findById(Integer category_id);

    void deleteById(Integer item_id);

}
