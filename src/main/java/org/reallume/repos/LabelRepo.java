package org.reallume.repos;

import org.reallume.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.reallume.domain.Label;

import java.util.List;

public interface LabelRepo extends CrudRepository<Label, Long> {

    Label findByName(String name);

    Label findById(Integer category_id);

    void deleteByIdAndAuthor(Integer category_id, User author);

    Label findByIdAndAuthor(Integer category_id, User author);

    void deleteById(Integer label_id);




}