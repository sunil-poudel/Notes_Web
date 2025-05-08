package org.sunil_spring_demo.notes_web.dao;


import org.sunil_spring_demo.notes_web.entity.Notes;

import java.util.List;

public interface NotesDAO {
    void createNote(Notes note);

    void createMultipleNotes(List<Notes> notesList);

    Notes readNote(int id);

    List<Notes> readMultipleNotes();

    void updateNote(int id, Notes updatedNote);

    void updateMultipleNotes(List<Integer> ids, List<Notes> updatedNotes);

    void deleteNote(int id);



}
