package org.reallume.repos;

import org.reallume.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.reallume.domain.Category;

import java.util.List;

public interface CategoryRepo extends CrudRepository<Category, Long> {

    Category findByName(String name);

    Category findById(Integer category_id);

    void deleteByIdAndAuthor(Integer category_id, User author);

    Category findByIdAndAuthor(Integer category_id, User author);

    void deleteById(Integer category_id);




}
