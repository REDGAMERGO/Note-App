package org.reallume.repos;

import org.reallume.domain.Category;
import org.reallume.domain.Note;
import org.reallume.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NoteRepo extends CrudRepository<Note, Long> {

    List<Note> findByCategory(Category category);

    void deleteById(Integer note_id);

    void deleteByCategory(Integer category_id);

    void deleteByIdAndAuthor(Integer note_id, User author);

    Note findByIdAndAuthor(Integer note_id, User author);

}
